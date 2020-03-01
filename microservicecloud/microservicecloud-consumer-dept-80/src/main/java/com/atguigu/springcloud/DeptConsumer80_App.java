package com.atguigu.springcloud;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.atguigu.myrule.MySelfRule;
 
 
@SpringBootApplication
//需要与Eurekaz整合
@EnableEurekaClient
//在启动该服务的时候就能去加载我们自定义Ribbon配置类，从而使配置生效
//name哪个服务使用  configuration使用的规则  在自定义的MySelfRule类中复写算法 此类需要返回实现IRule接口的类
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class)
public class DeptConsumer80_App
{
  public static void main(String[] args)
  {
   SpringApplication.run(DeptConsumer80_App.class, args);
  }
}
 
 
 

