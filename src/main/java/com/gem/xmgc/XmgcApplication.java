package com.gem.xmgc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.gem.xmgc.mapper")
public class XmgcApplication {
    public static void main(String[] args) {
        SpringApplication.run(XmgcApplication.class, args);
    }
}
