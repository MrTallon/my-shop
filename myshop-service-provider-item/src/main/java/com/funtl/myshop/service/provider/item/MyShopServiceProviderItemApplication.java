package com.funtl.myshop.service.provider.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 商品服务提供者启动类
 *
 * @author YangBo
 * @date 2019/03/10
 */
@SpringBootApplication(scanBasePackages = "com.funtl.myshop")
@EnableDiscoveryClient
@MapperScan(basePackages = "com.funtl.myshop.commons.mapper")
@EnableSwagger2
public class MyShopServiceProviderItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyShopServiceProviderItemApplication.class, args);
    }
}