package com.china.study.annot.one;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName: SysLinuxConditional
 * @Description: TODO(判断是不是linux系统) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月16日 下午7:34:50
 */
public class SysLinuxConditional implements Condition{

	/**
	 * ConditionContext 判断条件能使用的上下文环境
	 * AnnotatedTypeMetadata 注解的信息
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// TODO Auto-generated method stub
		// 获取ioc使用的bean工厂
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		// 获取类加载器
		ClassLoader classLoader = context.getClassLoader();
		// 获取当前系统环境的信息
		Environment environment = context.getEnvironment();
		// 获取bean定义的注册类
		BeanDefinitionRegistry registry = context.getRegistry();
		// 获取当前操作系统的名称
		String property = environment.getProperty("os.name");
		// 判断容器中是否包含 EntityTest
		boolean definition = registry.containsBeanDefinition("EntityTest");
		
		if(property.contains("linux")){
			return true;
		}
		return false;
	}

	
}
