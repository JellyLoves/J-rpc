package com.jelly.example.consumer;

import com.jelly.example.model.User;
import com.jelly.example.service.UserService;
import com.jelly.jrpc.proxy.ServiceProxyFactory;

/**
 * 简易服务消费者示例
 */
public class ConsumerExample {

    public static void main(String[] args) {
        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("jelly");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println("user1:"+newUser.getName());
        } else {
            System.out.println("user == null");
        }
        // 调用
        newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println("user2:"+newUser.getName());
        } else {
            System.out.println("user == null");
        }// 调用
        newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println("user3:"+newUser.getName());
        } else {
            System.out.println("user == null");
        }
        // long number = userService.getNumber();
        // System.out.println(number);
    }

    public static void temp(UserService userService, User user) {

    }
}
