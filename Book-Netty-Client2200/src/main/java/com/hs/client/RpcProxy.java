package com.hs.client;

import com.hs.dto.Invocation;
import com.hs.rpc.service.Some;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import lombok.val;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Huasheng
 * @Date 2021/05/21/11:19
 * @Description
 */
public class RpcProxy {
    public static <T> T create(Class<?> claz){
        return (T) Proxy.newProxyInstance(claz.getClassLoader(),
               new Class[]{claz},
                new InvocationHandler(){

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //判断是不是object方法来决定是否远程调用 是则本地调用
                        if (Object.class.equals(method.getDeclaringClass())) {
                            return method.invoke(this,args);
                        }
                        //远程调用
                        return rpcInvoke(claz,method,args);
                    }
                });
    }

    private static Object rpcInvoke(Class<?> claz,Method method,Object[] args)throws Exception{
        RpcClientHandler handler = new RpcClientHandler();

        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    //Nagel算法 关闭
                    .option(ChannelOption.TCP_NODELAY,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            ChannelPipeline pipeline = channel.pipeline();
                            pipeline.addLast(new ObjectEncoder());
                            pipeline.addLast(new ObjectDecoder(Integer.MAX_VALUE,
                                    ClassResolvers.cacheDisabled(null)));
                            pipeline.addLast(handler);
                        }
                    });

            ChannelFuture future = bootstrap.connect("localhost", 2200).sync();
             Invocation invocation = new Invocation();
             invocation.setClassName(claz.getName());
             invocation.setMethodName(method.getName());
             invocation.setParamTypes(method.getParameterTypes());
             invocation.setParamValues(args);
            future.channel().closeFuture().sync();
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
        return handler.getResult();
    }
}
