package com.china.study.annot.three;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;


/**
 * @ClassName: ProfileConfigTest
 * @Description: TODO(加载不同的数据源) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月17日 下午4:34:49
 */
@Configurable
public class ProfileConfigTest {
	
	/**
	 * @Profile 指定组件在哪个环境下才能注入到容器中
	 * 			加了环境标示的Bean,只有当环境被激活时，才能被加入到容器中
	 * 			默认是 default 环境 
	 */
	
	
	// 默认值加载数据源0
	@Profile("default")
	@Bean("dataSource")
	public String dataSource(){
		return "数据源0";
	}
	
	@Profile("test")
	@Bean("testDataSource")
	public String testDataSource(){
		return "数据源1";
	}
	
	@Profile("dev")
	@Bean("devDataSource")
	public String devDataSource(){
		return "数据源2";
	}
	
	@Profile("prod")
	@Bean("prodDataSource")
	public String prodDataSource(){
		return "数据源3";
	}

}
