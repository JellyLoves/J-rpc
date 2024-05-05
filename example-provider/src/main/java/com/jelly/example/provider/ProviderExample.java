package com.jelly.example.provider;

import com.jelly.example.service.UserService;
import com.jelly.jrpc.RpcApplication;
import com.jelly.jrpc.registry.LocalRegistry;
import com.jelly.jrpc.server.HttpServer;
import com.jelly.jrpc.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class ProviderExample {

    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动WEB服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
