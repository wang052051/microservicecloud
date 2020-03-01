package com.atguigu.springcloud;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
 
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //启用服务发现
@EnableCircuitBreaker //启用熔断器
public class 修改主启动类DeptProvider8001_Hystrix_Appp{
  public static void main(String[] args)
  {
   SpringApplication.run(修改主启动类DeptProvider8001_Hystrix_Appp.class, args);
  }
}
 

