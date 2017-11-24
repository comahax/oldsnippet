package com.gmcc.pboss.biz.basic.goods.bean;


/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-9-16
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：商品订购——商品
 */
public class Goods {
	/**套卡*/
	public static final int SUIT_CARD = 1;
	/**套卡包*/
	public static final int SUIT_CARD_PACAKAGE = 2;
	/**充值卡*/
	public static final int ABOUND_VALUE_CARD = 3;
	
	/**商品类型*/
	private String type;
	/**商品批次号*/
	private String id = "";
	/**商品包号*/
	private String name;
	/**商品售价*/
	private String price;
	/** 号码明细 */
	private String mobiles;
	//提交参数
	/** 商品种类(代码) */
	private String comType = "";
	/** 订购套数 */
	private int orderCount=0;
	/** 保存KEY */
	private String key = "";
	/**
	 * 是否已经在购物车中
	 */
	private boolean inCar = false;
	
	/**商品名称(包号) */
	public String getName() {
		return name;
	}
	/**商品名称*/
	public void setName(String name) {
		this.name = name;
	}
	
	/**商品名称*/
	public String getPrice() {
		return price;
	}
	/**商品名称*/
	public void setPrice(String price) {
		this.price = price;
	}
	
	/**商品类型*/
	public String getType() {
		return type;
	}
	/**商品类型*/
	public void setType(String type) {
		this.type = type;
	}
	
	/**商品标识(批次号)*/
	public String getId() {
		return id;
	}
	/**商品标识*/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the mobiles
	 */
	public String getMobiles() {
		return mobiles;
	}
	/**
	 * @param mobiles the mobiles to set
	 */
	public void setMobiles(String mobiles) {
		this.mobiles = mobiles;
	}
	/**
	 * 商品种类（代码）
	 */
	public String getComType() {
		return comType;
	}
	/**
	 * @param comType the comType to set
	 */
	public void setComType(String comType) {
		this.comType = comType;
	}
	/**
	 * @return the orderCount
	 */
	public int getOrderCount() {
		return orderCount;
	}
	/**
	 * @param orderCount the orderCount to set
	 */
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return the inCar
	 */
	public boolean isInCar() {
		return inCar;
	}
	/**
	 * @param inCar the inCar to set
	 */
	public void setInCar(boolean inCar) {
		this.inCar = inCar;
	}
	
}
