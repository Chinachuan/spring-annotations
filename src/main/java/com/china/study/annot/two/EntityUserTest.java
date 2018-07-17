package com.china.study.annot.two;

import org.springframework.beans.factory.annotation.Value;

/**
 * @ClassName: EntityUserTest
 * @Description: TODO(测试实体) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月17日 下午2:04:19
 */
public class EntityUserTest {
	/**
	 * @Value
	 * 1.声明基本数值
	 * 2.可以写表达式
	 * 3.可以取出配置文件中的值
	 */
	
	
	@Value("#{20-2}")
	private int age;
	
	@Value("张三")
	private String name;
	
	/**
	 * 获取 test.properties 配置文件中的值
	 */
	@Value("${test.name}")
	private String testName;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	@Override
	public String toString() {
		return "EntityUserTest [age=" + age + ", name=" + name + ", testName=" + testName + "]";
	}

	
	
	
	
	

}
