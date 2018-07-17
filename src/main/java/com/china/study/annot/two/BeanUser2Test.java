package com.china.study.annot.two;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @ClassName: BeanUserTest
 * @Description: TODO(测试类的初始化和销毁，通过实现接口的方式) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月17日 上午10:34:27
 */
@Component
public class BeanUser2Test implements InitializingBean,DisposableBean{
	
	public BeanUser2Test(){
		System.out.println("BeanUser2Test==>构造器...BeanUser2Test...");
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BeanUser2Test==>销毁...destroy...");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BeanUser2Test==>初始化并赋值好参数调用...afterPropertiesSet...");
	}

	
	
	
	
}
