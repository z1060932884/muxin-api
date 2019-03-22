package com.zzj.muxin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

//spring-boot应用标识
@SpringBootApplication
//mapper接口类扫描包配置
@MapperScan("com.zzj.muxin.mapper")
@ComponentScan(basePackages = {"com.zzj.muxin","org.n3r.idworker"})
public class App extends SpringBootServletInitializer {

    public static void main(String[] args){
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
//        SpringApplication.run(App.class,args);
        new App()
                .configure(new SpringApplicationBuilder(App.class))
                .run(args);
    }

}
