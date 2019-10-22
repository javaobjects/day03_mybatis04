package com.tencent.pojo;

import java.util.Date;

/**
 * 
* <p>Title: Item</p>  
* <p>
*	Description: 
*   映射item表的实体类
* </p> 
* @author xianxian 
* @date 2019年10月22日
 */
public class Item {

	/**商品编号(主键)**/
	private int id;
	/**商品名称 **/
	private String name;
	/**商品单价**/
	private double price;
	/**图片路径 **/
	private String pic;
	/**创建时间**/
	private Date createTime;
	/**详情**/
	private String detai;
}
