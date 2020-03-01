package com.atguigu.springcloud.cfgbeans;
 
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
 
@Configuration
//以前是在resources 里面有个applicationContext.xml文件配置beans 现在SpringBootbu建议这做了
//用类来new bean  在类上标注 @Configuration 就类似此类是一个applicationContext.xml
//@Bean 类似 <bean>节点   RestTemplate 类型 id="RestTemplate" class自动获取 下面类似一个bean 的无参构造
public class ConfigBean
{
    @Bean
    //是通过RestTemplate远程调用我们的服务 所以在它身上加负载均衡  没人定义负载均衡默认是轮询
    @LoadBalanced
    public RestTemplate getRestTemplate()
    {
         return new RestTemplate();
    }
    //配置其它的负载均衡策略
    public IRule myRule() {
    	return new RetryRule(); //返回实现IRule即可  
    }
}

