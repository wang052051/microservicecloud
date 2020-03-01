package com.atguigu.springcloud.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
 
@RestController
public class DeptController{
  @Autowired
  private DeptService service;
  @Autowired
  private DiscoveryClient client;
  
  @RequestMapping(value="/dept/add",method=RequestMethod.POST)
  public boolean add(@RequestBody Dept dept)
  {
   return service.add(dept);
  }
  
  @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
  public Dept get(@PathVariable("id") Long id)
  {
   return service.get(id);
  }
  
  @RequestMapping(value="/dept/list",method=RequestMethod.GET)
  public List<Dept> list()
  {
   return service.list();
  }
  
  @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
  public Object discovery(){
	  //client.getServices()盘点Eureka里的所有微服务
    List<String> list = client.getServices();
    System.out.println("********* *" + list);
     //在里面找一个叫 "MICROSERVICECLOUD-DEPT"的微服务   	
    List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
    for (ServiceInstance element : srvList) {
    //找出后打印 它的ID 主机IP 端口 以及访问地址  	
     System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
         + element.getUri());
    }
    return this.client;
  }
  
  
}
 

