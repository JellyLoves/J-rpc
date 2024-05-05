# 概念描述

### 什么是 RPC？
* RPC（Remote Procedure Call）即远程过程调用，是一种计算机通信协议，它允许程序在不同的计算机之间进行通信和交互，就像本地调用一样。
### 为什么需要 RPC？
* RPC 允许一个程序（称为服务消费者）像调用自己程序的方法一样，调用另一个程序（称为服务提供者）的接口，而不需要了解数据的传输处理过程、底层网络通信的细节等。这些都会由 RPC 框架帮你完成，使得开发者可以轻松调用远程服务，快速开发分布式系统。

# 示意图
* 简易RPC框架示意图

![image](https://github.com/JellyLoves/J-rpc/assets/78403409/b5899b43-fab2-428b-8614-cf63c919c9b6)

* 简易RPC框架架构图

![image](https://github.com/JellyLoves/J-rpc/assets/78403409/9f9d6490-0a3d-44a1-9b7e-ef0f7f60a280)


# 模块说明：

* example-common：示例代码的公共依赖，包括接口、Model 等
* example-consumer：示例服务消费者代码
* example-provider：示例服务提供者代码
* j-rpc-core：完整版 RPC 框架
* j-rpc-easy：简易版 RPC 框架
