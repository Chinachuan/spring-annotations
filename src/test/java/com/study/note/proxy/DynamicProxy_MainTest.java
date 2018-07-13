package com.study.note.proxy;

/**
 * @ClassName: DynamicProxy_Sum
 * @Description: TODO(动态代理-计算接口) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月13日 下午2:34:04
 */
public class DynamicProxy_MainTest {
	
	public static void main(String[] args) {
		
		/**
		   DynamicProxy_Sum sum = null;
		   sum = new DynamicProxy_SumImpl();
		   int result = sum.add(1, 2);
		   System.out.println(result);
		 * 
		 * 1.实现接口的方法
		 * 2.测试，如果实现的接口中，每个方法都有同样的日志，代码就会变的很冗余。
		 * 3.所以，用AOP切面编程可以很好的解决这些问题
		 *   首先，用动态代理模式实现该效果
		 */
		
		DynamicProxy_Sum sum = new DynamicProxy_SumImpl();
		DynamicProxy_Sum proxy = new DynamicProxy_SumLoggerProxy(sum).getLoggerProxy();
		
		int result01 = proxy.add(1, 3);
		int result02 = proxy.sub(4, 2);
		
		System.out.println("add结果：" + result01 +", sub结果：" + result02);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
