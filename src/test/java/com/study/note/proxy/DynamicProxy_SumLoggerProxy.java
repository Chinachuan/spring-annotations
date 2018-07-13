package com.study.note.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: DynamicProxy_SumLoggerProxy
 * @Description: TODO(动态代理) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月13日 下午3:28:31
 */
public class DynamicProxy_SumLoggerProxy {
	
	
	private static final Logger logger = LoggerFactory.getLogger(DynamicProxy_SumLoggerProxy.class);
	
	private DynamicProxy_Sum target;
	
	public DynamicProxy_SumLoggerProxy(DynamicProxy_Sum sum){
		this.target = sum;
	}
	
	
	public DynamicProxy_Sum getLoggerProxy(){
		
		DynamicProxy_Sum proxy = null;
		
		// 代理对象由哪一个类加载器负责加载
		ClassLoader classLoader = target.getClass().getClassLoader();
		
		// 代理对象的类型，即其中有哪些方法
		Class[] interfaces = new Class[]{DynamicProxy_Sum.class};
		
		// 当调用对象中的方法时，执行该方法
		InvocationHandler pxy = new InvocationHandler() {
			
			/**
			 * proxy : 返回正在代理那个对象，通常情况下，不使用这个方法
			 * method ： 正在调用的方法
			 * args ：调用方法时，传入的参数
			 */
			
			@Override
			public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("---------------------------代理模式开始执行----------------------------");
				System.out.println(target.getClass() + " 对象执行了 "+method.getName() + "方法，传入的参数为：" + Arrays.asList(args));
				Object data = method.invoke(target, args);
				return data;
			}
		}; 
		
		proxy =(DynamicProxy_Sum)Proxy.newProxyInstance(classLoader, interfaces, pxy);
		logger.info("返回的代理对象 proxy ：" + proxy.getClass());
		return proxy;
		
		
	}
	

}
