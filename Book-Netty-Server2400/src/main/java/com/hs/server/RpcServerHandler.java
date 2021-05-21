package com.hs.server;

import com.hs.dto.Invocation;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Map;
import java.util.logging.SimpleFormatter;

/**
 * @author Huasheng
 * @Date 2021/05/21/17:19
 * @Description
 */
public class RpcServerHandler extends SimpleChannelInboundHandler<Invocation> {

    private Map<String,Object> registryMap;

    public RpcServerHandler(Map<String, Object> registryMap) {
        this.registryMap = registryMap;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Invocation msg) throws Exception {
        Object result = "没有指定的提供者";
        if (registryMap.containsKey(msg.getClassName())) {
            Object provider = registryMap.get(msg.getClassName());
            result = provider.getClass().getMethod(msg.getMethodName(),
                    msg.getParamTypes())
                    .invoke(provider,msg.getParamValues());
        }
        ctx.writeAndFlush(result);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
