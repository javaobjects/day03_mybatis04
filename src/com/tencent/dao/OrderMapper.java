package com.tencent.dao;

import java.util.List;

import com.tencent.pojo.Order;
import com.tencent.pojo.OrderCustom;
import com.tencent.pojo.Page;
import com.tencent.pojo.User;

public interface OrderMapper {
	
	//<select id="selectOrderById" parameterType="int" resultType="com.tencent.pojo.Order">
	public Order selectOrderById(int id);

	//一对一查询：返回resultType <select id="selectOrders" resultType="com.tencent.pojo.OrderCustom">
	public List<OrderCustom> selectOrders();
	
	//一对一：返回resultMap 
	//<resultMap id="ordersResultMap" type="com.tencent.pojo.Order">
	//<select id="selectOrdersByResultMap" resultMap="ordersResultMap">
	public List<Order> selectOrdersByResultMap();
	
	//一对多：返回resultMap 
	//<resultMap id="orderDetailResultMap" type="com.tencent.pojo.Order">
	//<select id="selectOrderDetailsByResultMap" resultMap="orderDetailResultMap">
	public List<Order> selectOrderDetailsByResultMap();
	
	//多对多：返回resultMap 
	//<resultMap id="usersResultMap" type="com.tencent.pojo.User">
	//<select id="selectUsersByResultMap" resultMap="usersResultMap">
	public List<User> selectUsersByResultMap();
	
	//分页查询
	//<resultMap id="usersResultMap" type="com.tencent.pojo.User">
	//<select id="selectUsersByPage" parameterType="com.tencent.pojo.Page" resultMap="usersResultMap">
	public List<User> selectUsersByPage(Page page);
	
	//分页查询: 统计分页数据总函数  <select id="selectUsersByPageCount" resultType="int">
	public int selectUsersByPageCount();
}
