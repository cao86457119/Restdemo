package com.example.hz.demo.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kiva
 */
@Configuration
public class DruidDataSourceConfig {


    @Bean
    public ServletRegistrationBean druidSRB(){
        StatViewServlet c =  new StatViewServlet();
        ServletRegistrationBean t = new ServletRegistrationBean(c,"/druid/*");
        t.addInitParameter("loginUsername","admin");
        t.addInitParameter("loginPassword","admin");
        t.addInitParameter("allow","localhost");
        return t;

    }
    @Bean
    public FilterRegistrationBean druidFRB(){
        WebStatFilter c = new WebStatFilter();
        WallFilter b = new WallFilter();
        FilterRegistrationBean f = new FilterRegistrationBean(c);
        return f;
    }
    @Bean
    public WallFilter wallFRB(){
        WallFilter b = new WallFilter();

        return b;
    }

//    @Bean
//    public Log4jFilter log4jFilter(){
//        Log4jFilter l4f = new  Log4jFilter();
//        l4f.setStatementExecutableSqlLogEnable(true);
//        return l4f;
//    }
}
