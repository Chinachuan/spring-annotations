package com.china.study.annot;

import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName: FactoryBeanColorTest
 * @Description: TODO(使用FactoryBean创建一个对象) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月16日 下午8:41:47
 */
public class FactoryBeanColorTest implements FactoryBean<ColorTest>{

	@Override
	public ColorTest getObject() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ColorTest...getObject()...");
		return new ColorTest();
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return ColorTest.class;
	}

	/**
	 * 返回true这个bean是单实例，在容器中保存一份
	 * 返回false这个bean是多例，每次获取时都会调用
	 */
	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
