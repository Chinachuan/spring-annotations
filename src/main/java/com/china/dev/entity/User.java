package com.china.dev.entity;

/**
 * @ClassName: User
 * @Description: TODO(用户基本信息表) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月12日 下午7:37:10
 */
public class User {
	private long id;
	private String name;
	private String showName;
	private String cardID;
	private String phone;
	private int age;
	private String email;
	private String sex;
	private String address;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", showName=" + showName + ", cardID=" + cardID + ", phone="
				+ phone + ", age=" + age + ", email=" + email + ", sex=" + sex + ", address=" + address + "]";
	}
	
	
	

}
