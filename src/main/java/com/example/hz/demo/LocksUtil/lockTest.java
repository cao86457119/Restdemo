package com.example.hz.demo.LocksUtil;

import org.springframework.stereotype.Component;

@Component
public class lockTest {
    @Lock("id1")
    public String  getName(){
        return "happy";
    }
}
