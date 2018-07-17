package com.china.study.annot.two;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName: BeanConfigTest
 * @Description: TODO(注解驱动第二部分测试配置文件) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月17日 上午10:30:56
 */

@ComponentScan(value="com.china.study.annot.two")
public class BeanConfigTest {
	
	@Bean(initMethod="init",destroyMethod="detory")
	public BeanUserTest beanUserTest(){
		return new BeanUserTest();
	}

}
