package com.tencent.pojo;

import java.util.Date;
/**
 * 
* <p>Title: Item</p>  
* <p>
*	Description: 
* 映射item表的实体类
*   
* </p> 
* @author xianxian 
* @date 2019年10月22日
 */
public class Item {
	/**商品编号（主键）*/
	private int id;
	/**商品名称*/
	private String name;
	/**商品单价*/
	private double price;
	/**图片路径*/
	private String pic;
	/**创建时间*/
	private Date createTime;
	/**详情*/
	private String detail;
	
	public Item(){}

	public Item(int id, String name, double price, String pic, Date createTime,
			String detail) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.pic = pic;
		this.createTime = createTime;
		this.detail = detail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price
				+ ", pic=" + pic + ", createTime=" + createTime + ", detail="
				+ detail + "]";
	}
}
