package com.library;


import com.library.feign.NaverClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = NaverClientTest.TestConfig.class)
@ActiveProfiles("test")
public class NaverClientTest {

    @EnableAutoConfiguration
    @EnableFeignClients(clients = com.library.feign.NaverClient.class)
    static class TestConfig {}


    @Autowired
    NaverClient naverClient;


    @Test
    void callNaver(){
        String http = naverClient.search("HTTP",1,1);
        System.out.println(http);
    }
}
