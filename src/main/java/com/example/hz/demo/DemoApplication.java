package com.example.hz.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;

@SpringBootApplication
@RestController
@EnableCaching
@MapperScan("com.example.hz.demo.generated")
@EnableRedisHttpSession
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }

    @RequestMapping("/ad")
    public HashMap haveFun(){
        HashMap hm = new HashMap();
        hm.put("1","abc");
        hm.put("2","bcd");
        return hm;
    }

    @RequestMapping("/a/{id}")
    public String getName(@PathVariable String id){
        return id;
    }
}
