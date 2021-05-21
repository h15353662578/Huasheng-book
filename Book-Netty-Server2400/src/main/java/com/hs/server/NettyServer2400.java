package com.hs.server;

import com.hs.server.RpcServer;
/**
 * @author Huasheng
 * @Date 2021/05/21/9:21
 * @Description
 * 1:netty client启动 从eventLoopGroup中选择一个NioEventGroup去连接server并发送数据
 * 4:netty从childGroup中选出一个NioEventGroup与该channel进行绑定 用于处理该channel的所有操作
 * 6:pipeline中的处理器依次对channel中的数据包进行处理
 * 7:server如需向client发送数据 则需将数据经pipeline的处理器处理形成byteBuf数据包
 */

public class NettyServer2400 {
    public static void main(String[] args) throws Exception{
        RpcServer rpcServer = new RpcServer();
        rpcServer.publish("com.hs.service");
        rpcServer.start();
    }
}
