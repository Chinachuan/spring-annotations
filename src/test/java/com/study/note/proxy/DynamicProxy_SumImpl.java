package com.study.note.proxy;

/**
 * @ClassName: DynamicProxy_Sum
 * @Description: TODO(动态代理-计算接口) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月13日 下午2:34:04
 */
public class DynamicProxy_SumImpl implements DynamicProxy_Sum{

	@Override
	public int add(int i, int j) {
		return i+j;
	}

	@Override
	public int sub(int i, int j) {
		// TODO Auto-generated method stub
		return i-j;
	}
	
	

}
