package com.tuling.service.impl;

import com.tuling.service.HelloService;

public class MorningHello implements HelloService {
    @Override
    public String sayHello(String name) {
        return name + "早上好";
    }
}
