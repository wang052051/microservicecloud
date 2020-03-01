 
package com.atguigu.springcloud.entities;
 
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
 //去警告
@SuppressWarnings("serial")
//空构造函数
@NoArgsConstructor
//每个方法设置set、get方法
@Data
//链式风格访问
@Accessors(chain=true)
//全参构造函数
//@AllArgsConstructor	
//注意使用lombok eclipse 需要装lombok插件
public class Dept implements Serializable {//必须序列化  类表关系映射
  private Long  deptno;   //主键
  private String  dname;   //部门名称
  private String  db_source;//来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库,如果是db_source2  这里就写db_source2 
public Dept(String dname) {
	super();
	this.dname = dname;
}

  
}
 
 

