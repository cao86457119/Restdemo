package com.example.hz.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author kiva
 */
@Configuration
public class CORSConfiguration implements WebMvcConfigurer {
    private  final Logger logger = LoggerFactory.getLogger(CORSConfiguration.class);
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        logger.info("addcorsmapping");
        final int TIME_OUT = 100;
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowedHeaders("*");
        CountDownLatch c = new CountDownLatch(1);
        try {
            if(!c.await(TIME_OUT,TimeUnit.SECONDS)){
                System.out.println("close");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
