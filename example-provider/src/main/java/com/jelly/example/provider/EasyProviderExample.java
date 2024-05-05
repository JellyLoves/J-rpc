package com.jelly.example.provider;

import com.jelly.example.service.UserService;
import com.jelly.jrpc.registry.LocalRegistry;
import com.jelly.jrpc.server.HttpServer;
import com.jelly.jrpc.server.VertxHttpServer;

public class EasyProviderExample {

    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 提供服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
