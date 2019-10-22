package com.tencent.pojo;

import java.util.Date;

/**
 * 
* <p>Title: OrderCustom</p>  
* <p>
*	Description: 
* 自定义类，继承Order，扩展用户信息
*   
* </p> 
* @author xianxian 
* @date 2019年10月22日
 */
public class OrderCustom extends Order {

	/**用户id(主键)*/
	private int id;
	/**用户姓名*/
	private String userName;
	/**用户姓名*/
	private Date birthday;
	/**所在地址*/
	private String address;
	
	
	public OrderCustom() {
		super();
	}
	public OrderCustom(int id, String userName, Date birthday, String address) {
		super();
		this.id = id;
		this.userName = userName;
		this.birthday = birthday;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "OrderCustom [id=" + id + ", userName=" + userName + ", birthday=" + birthday + ", address=" + address
				+ ", toString()=" + super.toString() + "]";
	}
	
}
