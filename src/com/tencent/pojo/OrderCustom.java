package com.tencent.pojo;

import java.util.Date;

/**
 * 
* <p>Title: OrderCustom</p>  
* <p>
*	Description: 
*   自定义类，继承Order，扩展用户信息
* </p> 
* @author xianxian 
* @date 2019年10月22日
 */
public class OrderCustom extends Order {

	/**用户id(主键)**/
	private int id;
	/**用户姓名**/
	private String userName;
	/**用户生日**/
	private Date birthday;
	/**所在地址**/
	private String address;
}
