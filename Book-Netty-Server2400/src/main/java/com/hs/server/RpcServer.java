package com.hs.server;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.io.File;
import java.net.URL;
import java.util.*;

/**
 * @author Huasheng
 * @Date 2021/05/21/9:40
 * @Description
 */
public class RpcServer {
    //注册表  Key:业务接口名 Value:实现类的的实例
    private final Map<String,Object> registryMap = new HashMap<>();
    //线程安全的ArrayList
//private final List<String> classCache = Collections.synchronizedList(new ArrayList<>());
    //用于缓存制定包下的业务接口实现
    private final List<String> classCache = new ArrayList<>();

    //发布包下所有实现类
    public void publish(String basePackage) throws Exception{
        getProviderClass(basePackage);
        doRegistry();
    }

    public void doRegistry() throws Exception {
        if (classCache.size() == 0){
            return;
        }
        for (String className : classCache){
            Class<?>  clas = Class.forName(className);
            Class<?>[] interfaces = clas.getInterfaces();
            if (interfaces.length == 1) {
                registryMap.put(interfaces[0].getName(),clas.newInstance());
            }
        }

    }

    public void getProviderClass(String basePackage) {
        //获取指定包目录中的资源
        URL resource = this.getClass().getClassLoader()
                //com.hs.service => com/hs/service 转译
                .getResource(basePackage.replaceAll("\\.","/"));
        //若目录中没有任何资源 则 直接结束
        if (resource == null) {
            return;
        }

        //将URL资源转换为file
        File dir = new File((resource.getFile()));
        //遍历指定包及其子包
        for(File file : dir.listFiles()){
            if (file.isDirectory()){
                //递归
                getProviderClass(basePackage + "." + file.getName());
            }else if (file.getName().endsWith(".class")){
                //获取实现类的简单类名
                String fileName = file.getName().replace(".class","").trim();
                //将实现类的全限定类名写入缓存
                classCache.add(basePackage+"."+fileName);
            }
        }
        System.out.println("classCache: "+classCache);
    }

    //启动netty
    public void start() throws Exception{
        //定义连接请求
        EventLoopGroup parentGroup = new NioEventLoopGroup();
        //连接成功后的后续请求
        EventLoopGroup childGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            //初始化
            bootstrap.group(parentGroup,childGroup)
                    //SO_BACKLOG 指定用于存放连接请求的队列的长度 default 50
                    .option(ChannelOption.SO_BACKLOG,1024)
                    //SO_KEEPALIVE启用心跳 检测长链接存活状态 default存活两个小时
                    .childOption(ChannelOption.SO_KEEPALIVE,true)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel)throws Exception{
                            ChannelPipeline pipeline = channel.pipeline();
                            pipeline.addLast(new ObjectEncoder());
                            pipeline.addLast(new ObjectDecoder(Integer.MAX_VALUE,
                                    ClassResolvers.cacheDisabled(null)));
                            pipeline.addLast(new RpcServerHandler(registryMap));
                        }
                    });

            ChannelFuture future = bootstrap.bind(2400).sync();
            System.out.println("服务启动 port 2200");
            future.channel().closeFuture().sync();
        } finally {
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
        }
    }
}
