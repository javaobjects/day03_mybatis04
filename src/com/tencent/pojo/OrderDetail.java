package com.tencent.pojo;

/**
 * 
* <p>Title: OrderDetail</p>  
* <p>
*	Description: 
*   映射orderDetail表的实体类
* </p> 
* @author xianxian 
* @date 2019年10月22日
 */
public class OrderDetail {

	/**订单明细编号(主键)**/
	private int id;
	/**订单编号(外键关联Orders表)**/
	private int ordersId;
	/**商品编号(外键关联item表id)**/
	private int itemsId;
	/**商品数量**/
	private int itemsNum;
}
