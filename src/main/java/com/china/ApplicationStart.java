package com.china;

import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;


/**
 * excludeFilters 包扫描的排除规则
 * FilterType  排除规则 ANNOTATION是根据注解排除
 * classes 要排除那些类型
 */
//@ComponentScan(value = "com.china",excludeFilters = {
//		@Filter(type=FilterType.ANNOTATION, classes = {Controller.class,Service.class})
//})

@ComponentScan(basePackages = "com.china.dev")  // 配置单个扫描包 
@SpringBootApplication
public class ApplicationStart {
	
	// 日志打印
	private static final Logger Logger = LoggerFactory.getLogger(ApplicationStart.class);
	
	public static void main(String[] args) throws Exception {
		
		// Springboot启动类
		SpringApplication springApplication = new SpringApplication(ApplicationStart.class);

		// 获取java虚拟机的对象类
		Environment environment = springApplication.run().getEnvironment();
		
		Logger.info("\n----------------------------------------------------------\n\t"
				+ "Application '{}' is running! Access URLs:\n\t "
				+ "Local: \t\thttp://localhost:{}\n\t "
				+ "External: \t\thttp://{}:{}\n\t"
				+ "----------------------------------------------------------",
				environment.getProperty("spring.application.name"),
				environment.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(),
				environment.getProperty("server.port"));

		Logger.info("\n----------------------------------------------------------\n\t");
		
	}

}
