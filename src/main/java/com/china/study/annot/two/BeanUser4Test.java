package com.china.study.annot.two;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @ClassName: BeanUserTest
 * @Description: TODO(Bean的后置处理器，一个Bean,执行初始化和销毁方法之前，调用的方法) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月17日 上午10:34:27
 */
@Component
public class BeanUser4Test implements BeanPostProcessor{
	
	public BeanUser4Test(){
		System.out.println("BeanUser4Test<================>BeanUser4Test");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("<-------------------------BeanUser4Test Bean初始化之前 postProcessBeforeInitialization---------------------------->");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("<-------------------------BeanUser4Test 容器销毁之前调用 postProcessAfterInitialization---------------------------->");
		return null;
	}

	

	
	
	
	
}
