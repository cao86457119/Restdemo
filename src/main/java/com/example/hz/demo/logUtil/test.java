package com.example.hz.demo.logUtil;

import org.springframework.stereotype.Component;

@Component
public class test {
    @Log(after = "123",before = "asd")
    public void happy(){
        System.out.println("123123123123");
    }


}
