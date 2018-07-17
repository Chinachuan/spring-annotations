package com.china.study.annot.three;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: AmainTest
 * @Description: TODO(Aware注入Spring底层组件和原理,以及 @profile 注解的使用) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月17日 下午3:45:49
 */
public class AmainTest {
	
	@SuppressWarnings("resource")
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfigTest.class);
		Object bean = applicationContext.getBean("colorTest");
		System.out.println(bean);
	}
	
	
	/**
	 * 多数据源测试
	 */
	@SuppressWarnings("resource")
	@Test
	public void test02(){
		
		/**
		 * 数据源切换的方法：
		 *     1. 使用命令行，程序运行时，在jvm虚拟机中配置  -Dspring.profiles.active=test (这是测试环境)
		 *     2. 使用代码的方式
		 *     			// 创建一个 applicationContext 是无参的
		 *				AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		 *				// 设置java虚拟机的运行环境，可以设置多个
		 *				applicationContext.getEnvironment().setActiveProfiles("test","dev");
		 *				// 注册主配置类
		 *				applicationContext.register(ProfileConfigTest.class);
		 *				// 启动刷新容器
		 *				applicationContext.refresh();
		 *
		 *		同理，该注解也可以写在类上
		 */
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProfileConfigTest.class);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}
	}

}
