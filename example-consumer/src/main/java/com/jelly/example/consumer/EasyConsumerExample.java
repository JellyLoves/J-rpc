package com.jelly.example.consumer;

import com.jelly.example.model.User;
import com.jelly.example.service.UserService;
import com.jelly.jrpc.proxy.ServiceProxyFactory;

public class EasyConsumerExample {

    public static void main(String[] args) {
        // 静态代理
        // UserService userService = new UserServiceProxy();
        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);

        User user = new User();
        user.setName("jelly");
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}
