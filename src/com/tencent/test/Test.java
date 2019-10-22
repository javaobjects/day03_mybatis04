package com.tencent.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tencent.dao.OrderMapper;
import com.tencent.pojo.Order;
import com.tencent.pojo.OrderDetail;
import com.tencent.pojo.Page;
import com.tencent.pojo.User;

public class Test {

	public static void main(String[] args) throws IOException {
		
		//1.获取SqlSessionFactory接口
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml"));

		//2.获取SqlSession接口
		SqlSession session = factory.openSession();
		
		//3.基于接口生成代理对象
		OrderMapper orderMapper = session.getMapper(OrderMapper.class);
		
		//一对一：返回resultType:查询订单及订单所属用户，一个订单属于一个用户
		/*List<OrderCustom> orderList = orderMapper.selectOrders();
		for (OrderCustom orderCustom : orderList) {
			System.out.println(orderCustom);
		}*/
		
		//一对一：返回resultMap,查询订单及订单所属用户，一个订单属于一个用户
		/*List<Order> orderList = orderMapper.selectOrdersByResultMap();
		for (Order order : orderList) {
			System.out.println(order);
		}*/
		
		//一对多：返回resultMap,查询订单及订单所属用户，一个订单属于一个用户，与订单关联的所有明细，一个订单关联多个明细
		/*List<Order> orderList = orderMapper.selectOrderDetailsByResultMap();
		for (Order order : orderList) {
			//一对一：订单与用户信息
			System.out.println(order);
			
			//一对多：订单与订单明细
			List<OrderDetail> orderDetailList = order.getOrderDetailList();
			for (OrderDetail orderDetail : orderDetailList) {
				System.out.println("---->" + orderDetail);
			}
			
			System.out.println();
		}*/
		
		//多对多：返回resultMap,一个用户关联多个订单，一个订单关联多个明细，一个明细关联一个商品
		/*List<User> userList = orderMapper.selectUsersByResultMap();
		//用户信息
		for (User user : userList) {
			System.out.println(user);
			
			//一对多：一个用户关联多个订单
			List<Order> orderList = user.getOrderList();
			for (Order order : orderList) {
				System.out.println("---->" + order);
				
				//一对多：一个订单关联多个明细
				List<OrderDetail> orderDetailList = order.getOrderDetailList();
				for (OrderDetail orderDetail : orderDetailList) {
					System.out.println("-------->" + orderDetail);
				}
			}
		}*/
		
		//多对多：返回resultMap,一个用户关联多个订单，一个订单关联多个明细，一个明细关联一个商品
		/*List<User> userList = orderMapper.selectUsersByResultMap();
		//用户信息
		for (User user : userList) {
			System.out.println("【登陆用户名】" + user.getUserName());
			
			//一对多：一个用户关联多个订单
			List<Order> orderList = user.getOrderList();
			for (Order order : orderList) {
				System.out.println("\t下单时间：" + order.getCreateTime().toLocaleString() + "\t订单流水号：" + order.getOrderId());
				
				//一对多：一个订单关联多个明细
				List<OrderDetail> orderDetailList = order.getOrderDetailList();
				for (OrderDetail orderDetail : orderDetailList) {
					System.out.println("\t\t商品名称" + orderDetail.getItem().getName() + "\t单价：" + orderDetail.getItem().getPrice()+ "\t数量：" + orderDetail.getItemsNum());
				}
			}
			System.out.println();
		}*/
		
		//分页查询
		Page page = new Page(orderMapper.selectUsersByPageCount());
		page.setPageNum(3);//页码
		List<User> userList = orderMapper.selectUsersByPage(page);
		//用户信息
		for (User user : userList) {
			System.out.println("【登陆用户名】" + user.getUserName());
			
			//一对多：一个用户关联多个订单
			List<Order> orderList = user.getOrderList();
			for (Order order : orderList) {
				System.out.println("\t下单时间：" + order.getCreateTime().toLocaleString() + "\t订单流水号：" + order.getOrderId());
				
				//一对多：一个订单关联多个明细
				List<OrderDetail> orderDetailList = order.getOrderDetailList();
				for (OrderDetail orderDetail : orderDetailList) {
					System.out.println("\t\t商品编号:" + orderDetail.getId() + "\t 商品名称:" + orderDetail.getItem().getName() + "\t单价：" + orderDetail.getItem().getPrice()+ "\t数量：" + orderDetail.getItemsNum());
				}
			}
			System.out.println();
		}
	}
}
