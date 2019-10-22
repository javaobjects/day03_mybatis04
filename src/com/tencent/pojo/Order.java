package com.tencent.pojo;

import java.util.Date;
import java.util.List;
/**
 * 
* <p>Title: Order</p>  
* <p>
*	Description: 
* 映射orders表的实体类
*   
* </p> 
* @author xianxian 
* @date 2019年10月22日
 */
public class Order {
	
	/**订单编号（主键）*/
	private int id;
	/**用户编号（外键，关联user的id）*/
	private int userId;
	/**订单流水号（例如：201910221114330000001）*/
	private String orderId;
	/**创建时间*/
	private Date createTime;
	/**备注*/
	private String note;
	
	//一对一：一个订单属于一个用户
	private User user;
	
	//一对多：一个订单可以包含多个订单明细
	private List<OrderDetail> orderDetailList;
	
	public Order(){
		
	}
	public Order(int id, int userId, String orderId, Date createTime,String note) {
		super();
		this.id = id;
		this.userId = userId;
		this.orderId = orderId;
		this.createTime = createTime;
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}
	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", orderId=" + orderId + ", createTime=" + createTime
				+ ", note=" + note + ", user=" + user + "]";
	}
}
