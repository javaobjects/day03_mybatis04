package com.tencent.pojo;

import java.util.Date;
import java.util.List;

/**
 * 
* <p>Title: Order</p>  
* <p>
*	Description: 
*   映射orders表的实体类
* </p> 
* @author xianxian 
* @date 2019年10月22日
 */
public class Order {

	/**订单编号(主键)***/
	private int id;
	/**用户编号(外键,关联user的id)***/
	private int userId;
	/**订单流水号(例如:2019102211)***/
	private String orderId;
	/**创建时间***/
	private Date createTime;
	/**备注***/
	private String note;
	
	//一对一: 一个订单属于一个用户
	private User user;
	
	//一对多: 一个订单可以包含多个订单明细
	private List<OrderDetail> orderDetailList;
}
