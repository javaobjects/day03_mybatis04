package com.tencent.dao;

import java.util.List;

import com.tencent.pojo.Order;
import com.tencent.pojo.OrderCustom;

public interface OrderMapper {
	
	//一对一查询:<select id="selectOrders" resultType="com.tencent.pojo.OrderCustom">
	public List<OrderCustom> selectOrders();
	
	
	
	
	//一对一:返回resultMap
	//<resultMap id="ordersResultMap" type="com.tencent.pojo.Order">
	//<select id="selectOrdersByResultMap" resultMap="ordersResultMap">
	public List<Order> selectOrdersByResultMap();
}
