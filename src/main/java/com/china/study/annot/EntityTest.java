package com.china.study.annot;

/**
 * @ClassName: EntityTest
 * @Description: TODO(注解学习的测试实体) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月16日 下午3:21:58
 */
public class EntityTest {
	
	/**
	 * id
	 */
	private int id;
	
	/**
	 * 名称
	 */
	private String name;

	public EntityTest(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EntityTest [id=" + id + ", name=" + name + "]";
	}
	
	
	

}
