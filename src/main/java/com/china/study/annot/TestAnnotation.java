package com.china.study.annot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestAnnotation {
	
	@Bean
	public String save(){
		System.out.println("===============> 生产包注入成功。。。");
		return "succ";
		
	}

}
