module demoModule1 {
    requires spring.boot.autoconfigure;
    requires spring.boot;
    exports com.tuling.service;

    provides com.tuling.service.HelloService with
            com.tuling.service.impl.MorningHello,
            com.tuling.service.impl.EveningHello;
}