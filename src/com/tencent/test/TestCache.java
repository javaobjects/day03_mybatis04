package com.tencent.test;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tencent.dao.OrderMapper;
import com.tencent.pojo.Order;

public class TestCache {

	public static void main(String[] args) throws IOException {
		
		//1.获取SqlSessionFactory接口
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml"));

		//2.第一个SqlSession
		SqlSession session = factory.openSession();
		OrderMapper orderMapper = session.getMapper(OrderMapper.class);
		
		/**
		 * 第一次查询，判断内存中是否存在编号为1的订单数据，如果有，则直接从缓存中获取，如果没有，则从数据库进行查询
		 */
		//第一次：查询数据库中的数据
		Order order = orderMapper.selectOrderById(1);
		System.out.println("★★★★★★★★★：" + order);
		
		session.commit(); //会清空一级缓存
		
		//第二次：查询到内存中存在编号为1的订单数据，直接获取缓存数据，不需要查询数据库
		Order order2 = orderMapper.selectOrderById(1);
		System.out.println("★★★★★★★★★：" + order2);
		
		session.close();  //会清空一级缓存
		
		//2.第二个SqlSession
		SqlSession session2 = factory.openSession();
		OrderMapper orderMapper2 = session2.getMapper(OrderMapper.class);
		
		//第三次：
		Order order3 = orderMapper2.selectOrderById(1);
		System.out.println("★★★★★★★★★：" + order3);
		
		/**
		 * 1. 一级缓存：默认配置，在同一个SqlSession中有效
		 * 
		 * 		   但是如果碰到session.commit()  或  session.close() 时，一级缓存被清空
		 * 
		 * 2. 二级缓存：手动配置，在同一的Mapper（同一个namespace）中有效
		 * 
		 * 		 ① 在sqlMapConfig.xml中开启二级缓存总开关
					<settings>
						<!-- 开启二级缓存总开关 ,true开启   false(默认值)不开启-->
						<setting name="cacheEnabled" value="true"/>
					</settings>
					
				 ② 在xxxMapper.xml文件中开启二级缓存子开关
				 	<!-- 开启二级缓存的子开关 -->
					<cache></cache>
					
				 ③ 需要被缓存的对象必须实现序列化接口Serializable
				 	public class Order implements Serializable{ } 
				 	
				 在xxxMapper.xml文件中使用useCache="false"可以关闭指定语句的二级缓存功能
				 				       使用flushCache="true"在DML操作之后，自动刷新缓存
				 				       
				 				       
			 3.使用分布式缓存框架
			 	① 导入jar包
			 			ehcache-2.10.1.jar
			 			mybatis-ehcache-1.0.2.jar
			 			
			 	② 在xxxMapper.xml文件中开启Ehcache二级缓存的开关
			 		<!-- 开启EhCache二级缓存的子开关 -->
					<cache type="org.mybatis.caches.ehcache.EhcacheCache"></cache>
					
				③ 在src下添加Ehcache分布式缓存框架的ehcache.xml的配置文件
		 */
		
	}
}
