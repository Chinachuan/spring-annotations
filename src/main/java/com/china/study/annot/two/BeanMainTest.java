package com.china.study.annot.two;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: BeanMainTest
 * @Description: TODO(注解驱动第二部分测试类) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月17日 上午10:37:20
 */
public class BeanMainTest {
	
	/**
	 * 说明：
	 *    该测试类，主要测试，bean的生命周期
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

}
