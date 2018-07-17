package com.china.study.annot.two;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @ClassName: BeanMainTest
 * @Description: TODO(注解驱动第二部分测试类) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月17日 上午10:37:20
 */
public class BeanMainTest {
	
	/**
	 * 说明：
	 *    该测试类，主要测试，bean的生命周期、属性赋值
	 * 
	 */
	
	/**
	 * 容器的初始化和销毁
	 *  1.单实例bean,容器关闭的时候，会执行销毁的方法
	 *  2.多实例bean,容器关闭的时候，不会执行销毁方法，容器不会管理需要手动销毁
	 */
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfigTest.class);
		System.out.println("容器创建完成。。。" + applicationContext.getId());
		// 容器销毁
		applicationContext.close();
	}
	
	
	
	/**
	 * 测试 @value 赋值
	 */
	@Test
	public void test02(){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfigTest.class);
		EntityUserTest bean = (EntityUserTest) applicationContext.getBean("entityUserTest");
		
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String property = environment.getProperty("os.name");
		System.out.println("当前操作系统是："+property);
		
		String property2 = environment.getProperty("test.name");
		System.out.println("配置的外部环境的取值："+property2);
		
		System.out.println("赋值测试：========>" + bean);
		
	}
	
	
	

}
