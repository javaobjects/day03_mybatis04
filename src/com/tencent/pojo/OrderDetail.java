package com.tencent.pojo;

/**
 * 
* <p>Title: OrderDetail</p>  
* <p>
*	Description: 
* 映射orderDetail表的实体类
*   
* </p> 
* @author xianxian 
* @date 2019年10月22日
 */
public class OrderDetail {
	
	/**订单明细编号（主键）*/
	private int id;
	/**订单编号（外键关联Orders表id）*/
	private int ordersId;
	/**商品编号（外键关联item表id）*/
	private int itemsId;
	/**商品数量*/
	private int itemsNum;
	
	//一对一：一个明细关联一个商品
	private Item item;
	
	public OrderDetail(){
		
	}

	public OrderDetail(int id, int ordersId, int itemsId, int itemsNum) {
		super();
		this.id = id;
		this.ordersId = ordersId;
		this.itemsId = itemsId;
		this.itemsNum = itemsNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}

	public int getItemsId() {
		return itemsId;
	}

	public void setItemsId(int itemsId) {
		this.itemsId = itemsId;
	}

	public int getItemsNum() {
		return itemsNum;
	}

	public void setItemsNum(int itemsNum) {
		this.itemsNum = itemsNum;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", ordersId=" + ordersId + ", itemsId=" + itemsId + ", itemsNum=" + itemsNum
				+ ", item=" + item + "]";
	}
	
}
