package com.china.study.annot.three;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @ClassName: SpringIntoAwareTest
 * @Description: TODO(Aware 注入底层Spring 组件) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月17日 下午4:38:00
 */
@Component
public class SpringIntoAwareTest implements ApplicationContextAware,BeanNameAware,EmbeddedValueResolverAware{
	
	//private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println(applicationContext);
		//this.applicationContext = applicationContext;
	}
	
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("当前Bean的名字" + name);
		
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		// TODO Auto-generated method stub
		String rue = resolver.resolveStringValue("可以解析表达式中的值 ====> #{20*20}");
		System.out.println("setEmbeddedValueResolver ==>" + rue);
		
	}

	

}
