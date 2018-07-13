package com.study.note.proxy;

/**
 * @ClassName: DynamicProxy_Sum
 * @Description: TODO(动态代理-计算接口) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月13日 下午2:34:04
 */
public interface DynamicProxy_Sum {
	
	/**
	 * 加法
	 * @param i
	 * @param j
	 * @return
	 */
	public int add(int i,int j);
	
	/**
	 * 减法
	 * @param i
	 * @param j
	 * @return
	 */
	public int sub(int i,int j);

}
