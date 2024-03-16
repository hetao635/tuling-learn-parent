package com.tuling.service.impl;

import com.tuling.service.HelloService;

public class EveningHello implements HelloService {
    @Override
    public String sayHello(String name) {
        return name + "晚上好";
    }
}
