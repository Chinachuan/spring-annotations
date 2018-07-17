package com.china.study.annot.three;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(value="com.china.study.annot.three")
@Configurable
public class BeanConfigTest {
	
	@Bean
	public ColorTest colorTest(){
		return new ColorTest();
	}
	
	

}
