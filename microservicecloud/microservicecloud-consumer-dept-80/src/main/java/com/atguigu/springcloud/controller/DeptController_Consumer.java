package com.atguigu.springcloud.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
 
import com.atguigu.springcloud.entities.Dept;
 
@RestController
public class DeptController_Consumer{	
	//调用地址
	// private static final String REST_URL_PREFIX = "http://localhost:8001";
	
	//改成微服务名
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

    
    //通过RestTemplate 完成接口调用
    //使用restTemplate访问restful接口非常的简单粗暴无脑。
    //(url, requestMap, ResponseBean.class)这三个参数分别代表 
    //REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
    @Autowired
    private RestTemplate restTemplate;
     
    @RequestMapping(value="/consumer/dept/add")
    public boolean add(Dept dept)
    {	
    	//不再是 xxxservice.xxx 因为没有   REST调用帮你封装了一层
         return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }
    
    @RequestMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
         return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
    }
    
    @SuppressWarnings("unchecked")
    @RequestMapping(value="/consumer/dept/list")
    public List<Dept> list()
    {
         return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
    }
  //测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value="/consumer/dept/discovery") 
    public Object discovery()
    {
     return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
    } 
}
 
 
 

