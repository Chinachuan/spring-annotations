package com.china.study.annot.two;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName: BeanConfigTest
 * @Description: TODO(注解驱动第二部分测试配置文件) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月17日 上午10:30:56
 */

// 通过 @PropertySource 注解，加载外部配置文件
@PropertySource(value={"classpath:/test.properties"})
@ComponentScan(value="com.china.study.annot.two")
public class BeanConfigTest {
	
	/**
	 * 主要测试bean加载的声明周期，和赋值
	 * @return
	 */
	@Bean(initMethod="init",destroyMethod="detory")
	public BeanUserTest beanUserTest(){
		return new BeanUserTest();
	}
	
	/**
	 * 测试 @value 注解的使用
	 * @return
	 */
	@Bean("entityUserTest")
	public EntityUserTest entityUserTest(){
		return new EntityUserTest();
	}
	
}
