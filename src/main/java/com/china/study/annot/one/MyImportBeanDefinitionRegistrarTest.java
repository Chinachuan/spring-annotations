package com.china.study.annot.one;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName: MyImportBeanDefinitionRegistrarTest
 * @Description: TODO(手动注入一个Bean) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月16日 下午8:26:06
 */
public class MyImportBeanDefinitionRegistrarTest implements ImportBeanDefinitionRegistrar{

	/**
	 * AnnotationMetadata 当前类的注册信息
	 * BeanDefinitionRegistry  BeanDefinition的注册类
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// TODO Auto-generated method stub
		
		boolean definition1 = registry.containsBeanDefinition("com.china.study.annot.ColorTest");
		boolean definition2 = registry.containsBeanDefinition("com.china.study.annot.RedTest");
		
		// 判断这两个bean是否存在
		if(definition1 && definition2){
			// 这两个bean存在，创建一个bean，注册到容器中
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainTest.class);
			// 把rainTest注册到容器中
			registry.registerBeanDefinition("rainTest", rootBeanDefinition);
		}
		
		
	}

}
