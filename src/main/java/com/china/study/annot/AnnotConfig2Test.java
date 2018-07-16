package com.china.study.annot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

/**
 * @ClassName: AnnotConfigTest
 * @Description: TODO(学习注解的配置文件) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月16日 下午3:24:57
 */
//@Conditional({SysWinConditional.class}) // 只有当操作系统为window时，才会加载配置文件
@Configuration  // 声明这个一个配置文件
//@Import({ColorTest.class,RedTest.class})  // 快速导入组件
@Import({MyImportSelectorTest.class,MyImportBeanDefinitionRegistrarTest.class})  // 自定义要导入的组件
public class AnnotConfig2Test {
	
	private static final Logger logger = LoggerFactory.getLogger(AnnotConfig2Test.class);
	
	/**
	 * @Scope 默认是单例模式，每次获取的对象都不一样
	 * @Scope("singleton")  单例模式为默认值，ioc容器启动会调用方法创建对象，然后放到ioc容器中，以后每次获取就是从容器中拿
	 * @Scope("prototype")  多例模式，ioc容器启动时并不会调用方法创建对象，每次获取的时候，才会调用方法创建对象
	 * @Scope("request")
	 * @Scope("session")
	 */
//	@Scope("prototype") //多例模式
	@Lazy   // 懒加载是针对单实例bean使用的，使用@lazy懒加载后，ioc容器启动时不会加载单实例bean,获取时才会加载
	@Bean("entityTest")  // entityTest01是Bean在容器中的名称，不写名称，默认为entityTest
	public EntityTest entityTest(){
		logger.info("Annot ====>  第 2 个配置文件  注入成功。。。");
		EntityTest et = new EntityTest(1, "第一个实体");
		return et;
		
	}
	
	@Conditional({SysWinConditional.class})
	@Bean("win10")
	public EntityTest win10(){
		return new EntityTest(10,"比尔盖茨");
	}
	
	@Conditional({SysLinuxConditional.class})
	@Bean("linux")
	public EntityTest linux(){
		return new EntityTest(11,"林牛克斯");
	}

	@Bean("factoryBeanColorTest")
	public FactoryBeanColorTest factoryBeanColorTest(){
		return new FactoryBeanColorTest();
	}

}
