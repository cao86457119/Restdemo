package com.example.hz.demo.controller;

import com.example.hz.demo.utils.FastDFSClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

/**
 * @author kiva
 */
@Component
@RestController
public class IndexController {
    public IndexController() throws Exception {
    }

    @RequestMapping("/")
    public String index() {
        return "Hello World1";
    }
    /** 1、把FastDFS提供的jar包添加到工程中
    2、初始化全局配置。加载一个配置文件。*/
    String confUrl = this.getClass().getClassLoader().getResource("fdfs_client.properties").getPath();
    FastDFSClient fastDFSClient = new FastDFSClient(confUrl);
    @RequestMapping(value = "file/uploadFast", method = RequestMethod.GET)
    public String uploadFast(HttpServletRequest request) throws Exception {

        //上传文件
        String filePath = fastDFSClient.uploadFile("/Users/kiva/Desktop/UNADJUSTEDNONRAW_thumb_a.jpg");
        System.out.println("返回路径：" + filePath);
        return filePath;
    }
    @RequestMapping(value = "file/downFast", method = RequestMethod.GET)
    public void  downFast(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //FileOutputStream fs = new FileOutputStream("/Users/kiva/Desktop/aa.jpg");
        ServletOutputStream out = response.getOutputStream();
        response.setHeader("Content-Type", "application/octet-stream");
        BufferedOutputStream bt = new BufferedOutputStream(out);
        //上传文件
        fastDFSClient.download_file("group1/M00/00/00/rBCBW1yirjiAINUwAAHh3mP5aOs155.jpg",bt);
        out.flush();

    }
}
