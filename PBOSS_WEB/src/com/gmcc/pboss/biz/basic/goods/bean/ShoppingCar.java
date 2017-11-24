package com.gmcc.pboss.biz.basic.goods.bean;

import java.util.LinkedHashMap;
import java.util.Map;

import com.gmcc.pboss.biz.basic.dictItem.service.DictItemService;


/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-9-16
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：商品订购——购物车
 */
public class ShoppingCar {
	/**购物车所属用户*/
	private String customer;
	/**购物车创建时间*/
	private long createTime;

	/**
	 * 商品种类查询
	 */
	private DictItemService dictItemService;
	
	/**商品对象列表*/
	private Map<String,Goods> goodsMark = new LinkedHashMap<String,Goods>();
	/** 记录汇总信息  */
	private Map<String,GoodsStat> goodsStat = new LinkedHashMap<String,GoodsStat>();
	

	/** 记录所有商品  */
	private Map<String,Goods> allGoods = new LinkedHashMap<String,Goods>();
	
	public ShoppingCar(String customer) {
		this.customer = customer;
		this.createTime = System.currentTimeMillis();
	}
	
	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * @return the createTime
	 */
	public long getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}


	/**
	 * @return the dictItemService
	 */
	public DictItemService getDictItemService() {
		return dictItemService;
	}

	/**
	 * @param dictItemService the dictItemService to set
	 */
	public void setDictItemService(DictItemService dictItemService) {
		this.dictItemService = dictItemService;
	}
	
	/**
	 * @return the allGoods
	 */
	public Map<String, Goods> getAllGoods() {
		return allGoods;
	}

	/**
	 * @param allGoods the allGoods to set
	 */
	public void setAllGoods(Map<String, Goods> allGoods) {
		this.allGoods = allGoods;
	}

	/**
	 * 商品是否在购物车中
	 */
	public boolean isInCar(Goods goods){
		String mark = getCarMark(goods);//提取标识
		return goodsMark.containsKey(mark);
	}
	/***
	 * 添加商品
	 * @param goods
	 */
	public void addGoods(Goods goods,boolean isQuery,boolean isComrescard){
		//设置新的列表
		GoodsStat gs;
		String mark = getCarMark(goods);//提取标识
		if (!goodsMark.containsKey(mark)){//购物车中无此种套卡 或者 充值卡
			//保存判断
			goods.setKey(mark);
			this.goodsMark.put(mark, goods);
			//保存汇总
			gs = this.goodsStat.get(goods.getComType());//按商品种类保存
			if (gs == null){ 
				gs = new GoodsStat();
				gs.setComType(goods.getComType());
				gs.setType(goods.getType());
			}//if
			gs.addNew(1,goods.getOrderCount());
			//保存新的信息
			this.goodsStat.put(goods.getComType(), gs);
		}else{//购物车中已有此种套卡 或者 充值卡
			if (!isQuery || isComrescard ){
				//没有查询的处理:提取已经选择的类型相加  或者 是套卡时
				Goods saveGoods = this.goodsMark.get(mark); 
				//提取已经选择的类型相加
				saveGoods.setOrderCount(saveGoods.getOrderCount()+goods.getOrderCount());
				this.goodsMark.put(mark, saveGoods);
				//保存汇总
				gs = this.goodsStat.get(saveGoods.getComType());
				if (gs == null){ 
					gs = new GoodsStat();
					gs.setComType(goods.getComType());
					gs.setType(goods.getType());
				}//if
				gs.addNew(0,goods.getOrderCount());
			}
		}
	}
	
	/**
	 * 删除商品
	 * @param good
	 */
	public void deleteGoods(Goods goods){

		String mark = goods.getKey();//提取以Key为主键的记录
		Goods t =this.goodsMark.get(mark); 
		this.goodsMark.remove(mark);
		//汇总信息提取
		GoodsStat gs = this.goodsStat.get(t.getComType());//按商品种类保存
		if (gs != null){
			gs.delOne(t);
			if (gs.getPckgCnt()<=0 && gs.getDtlCnt()<=0){//当对象的分类为空时
				this.goodsStat.remove(t.getComType());
			}//if
		}//if
	}

	public void addAllGoods(Goods goods){
		String mark = getCarMark(goods);//提取标识
		this.allGoods.put(mark, goods);
		
	}
	
	public Goods getGoods(String key){
		return this.allGoods.get(key);
	}
	/**
	 * @return the goodsMark
	 */
	public Map<String, Goods> getGoodsMark() {
		return goodsMark;
	}

	/**
	 * @param goodsMark the goodsMark to set
	 */
	public void setGoodsMark(Map<String, Goods> goodsMark) {
		this.goodsMark = goodsMark;
	}

	/**
	 * @return the goodsStat
	 */
	public Map<String, GoodsStat> getGoodsStat() {
		return goodsStat;
	}

	/**
	 * @param goodsStat the goodsStat to set
	 */
	public void setGoodsStat(Map<String, GoodsStat> goodsStat) {
		this.goodsStat = goodsStat;
	}

	private String getCarMark(Goods goods){

		return goods.getId()+"-"+ goods.getName() +"-"+ goods.getComType();//用批次号+包号+商品种类作为标识
	}
}
