package com.jelly.example.provider;

import com.jelly.example.service.UserService;
import com.jelly.jrpc.RpcApplication;
import com.jelly.jrpc.config.RegistryConfig;
import com.jelly.jrpc.config.RpcConfig;
import com.jelly.jrpc.model.ServiceMetaInfo;
import com.jelly.jrpc.registry.LocalRegistry;
import com.jelly.jrpc.registry.Registry;
import com.jelly.jrpc.registry.RegistryFactory;
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
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        serviceMetaInfo.setServiceVersion(rpcConfig.getVersion());
        try {
            System.out.println("服务端注册："+serviceMetaInfo.toString());
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动WEB服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
/**
 * {"serviceName":"com.jelly.example.service.UserService",
 * "serviceVersion":"1.0","serviceAddress":"null:0",
 * "serviceGroup":"default","servicePort":0}
 */