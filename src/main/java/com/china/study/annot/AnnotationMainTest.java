package com.china.study.annot;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class AnnotationMainTest {
	
	private static final Logger logger = LoggerFactory.getLogger(AnnotationMainTest.class);
	
	/**
	 * Spring 注解驱动开发说明
	 * 
	 *   Spring 注解驱动开发主要包括三个部分{容器、扩展原理、Web}
	 * 		1. 容器：{AnnotationConfigApplicationContext,
	 * 					组件添加，组件赋值，组件注入，AOP，声明式事务}
	 * 
	 *      2. 扩展原理：{BeanFactoryPostProcessor, BeanDefinitionRegistryPostProcessor
	 *      			ApplicationListener, Spring容器创建过程}
	 *      
	 *      3. Web: {Servlet3.0, 异步请求}
	 */
	
	
	/**
	 * J2SE 提供的最后一个批注是 @SuppressWarnings
	      注解@SuppressWarnings的使用：（作用：用于抑制编译器产生警告信息。）
	  				@SuppressWarnings(“”)
       				@SuppressWarnings({})
       				@SuppressWarnings(value={})
       				使用：
       				@SuppressWarnings("unchecked")  抑制单类型的警告
       				@SuppressWarnings(value={"unchecked", "rawtypes"}) 抑制多类型的警告
       				@SuppressWarnings("all") 抑制所有类型的警告
       				@SuppressWarnings(“unchecked”)//未检查的转化，如集合没有指定类型
					@SuppressWarnings(“resource”)  //有泛型未指定类型
	 */
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		logger.info("Annot ====>  测试-获取EntityTest。。。");
		
		// 创建容器，加载AnnotConfigTest配置文件
		ApplicationContext context = new AnnotationConfigApplicationContext(AnnotConfig2Test.class);
		// 通过Bean的类型，拿到创建的实例对象
//		EntityTest bean = context.getBean(EntityTest.class);
		
		// 通过bean的类型，获取bean在容器中的名称
//		String[] beanNamesForType = context.getBeanNamesForType(EntityTest.class);
//		for (String name : beanNamesForType) {
//			System.out.println(name);
//		}
		
		// 获取容器中所有的bean
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String name01 : beanDefinitionNames) {
			System.out.println("容器中所有的Bean ==>" + name01);
		}
		
		Object bean = context.getBean("entityTest");
		System.out.println("bean1==>"+bean.hashCode());
		Object bean2 = context.getBean("entityTest");
		System.out.println("bean2==>"+bean2.hashCode());
		
		System.out.println(bean==bean2);
		
		
		
		
	}
	
	
	/**
	 * 测试 @Conditional 条件加载Bean
	 */
	@Test
	@SuppressWarnings("resource")
	public void test01(){
		/**
		 * 提示，系统通过配置当前系统的jvm运行环境，来做测试，比如，-Dos.name=linux 就是linux运行环境
		 * 配置路径为：Run as --> Run configurations... --> argument -->VM argument
		 */
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotConfig2Test.class);
		// 获取系统运行的环境
		Environment environment = context.getEnvironment();
		// 获取系统的名字
		String property = environment.getProperty("os.name");
		System.out.println("当前系统的名称为：" + property);
		
		String[] beanNamesForType = context.getBeanNamesForType(EntityTest.class);
		for (String name : beanNamesForType) {
			System.out.println("根据条件加载Bean ==>" + name);
		}
	}
	
	
	/**
	 * 测试 @Import 组件导入
	 */
	@Test
	@SuppressWarnings("resource")
	public void test02(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotConfig2Test.class);
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.println("根据条件加载Bean ==>" + name);
		}
		
		/**
		 * 工厂Bean调用getObject(),默认获取的是Bean创建的对象
		 * 加上&符号，例如 Object bean = context.getBean("&factoryBeanColorTest"); 获取的是bean工厂本身的对象
		 */
		Object bean = context.getBean("factoryBeanColorTest");
		System.out.println("工厂Bean获取的对象：" + bean.getClass());
		
		
	}
	
	

	

	
	

}
