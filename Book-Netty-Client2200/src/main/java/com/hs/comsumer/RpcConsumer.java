package com.hs.comsumer;

import com.hs.client.RpcProxy;
import com.hs.rpc.service.Some;

/**
 * @author Huasheng
 * @Date 2021/05/21/11:14
 * @Description
 */
public class RpcConsumer {
    public static void main(String[] args) {
        Some some = RpcProxy.create(Some.class);
        System.out.println(some.hello("Huasheng"));
        System.out.println(some.hashCode());
    }
}
