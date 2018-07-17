package com.china.study.annot.two;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @ClassName: BeanUserTest
 * @Description: TODO(通过注解的方式，实现容器的初始化和销毁) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月17日 上午10:34:27
 */
//@Component    //(声明组件，包扫描的时候，会自动加载到容器中)
public class BeanUser3Test implements ApplicationContextAware{
	
	private ApplicationContext applicationContexts;
	
	public BeanUser3Test(){
		System.out.println("BeanUser3Test==>构造器...BeanUser3Test...");
	}

	//创建对象并赋值之后调用
	@PostConstruct
	public void init(){
		// TODO Auto-generated method stub
		System.out.println("BeanUser3Test==>初始化...init...");
	}

	
	// 注销之前调用
	@PreDestroy
	public void detory(){
		// TODO Auto-generated method stub
		System.out.println("BeanUser3Test==>銷毀...detory...");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContexts = applicationContext;
	}

	
	
	
	
}
