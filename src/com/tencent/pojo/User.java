package com.tencent.pojo;

import java.util.Date;
import java.util.List;

/**
 * 
* <p>Title: User</p>  
* <p>
*	Description: 
* 映射t_user表的实体类
*   
* </p> 
* @author xianxian 
* @date 2019年10月22日
 */
public class User {
	/**用户id(主键)*/
	private int id;
	/**用户姓名*/
	private String userName;
	/**用户姓名*/
	private Date birthday;
	/**所在地址*/
	private String address;
	
	//一对多：一个用户关联多个订单
	private List<Order> orderList;
	
	public User(){}

	public User(int id, String userName, Date birthday, String address) {
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

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", date=" + birthday
				+ ", address=" + address + "]";
	}
	
	
}
