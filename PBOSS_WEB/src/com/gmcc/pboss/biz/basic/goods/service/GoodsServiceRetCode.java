package com.gmcc.pboss.biz.basic.goods.service;

import com.gmcc.pboss.common.service.ServiceRetCode;

/**
 * 从兴公司电子渠道业务部
 * @author yuwenjun
 * @date 2009-11-12
 * 所属项目：PBOSS
 * 所属模块：商品订购 
 * 描述：
 */
public class GoodsServiceRetCode extends ServiceRetCode {
	//购物车操作
	/**
	 * 购物车为空
	 */
	public static final int CAREMPTY = 109;
	/**
	 * 购物车操作异常
	 */
	public static final int CARERROR = 108;
	/**
	 * 购物车不存在此商品
	 */
	public static final int CARNOTFIND = 107;
	//用户名商品订购资格检查
	/**
	 * 用户有订购资格
	 */
	public static final int QUALIFICATION_SUCC = 110;
	/**
	 * 用户没有订购资格
	 */
	public static final int QUALIFICATION_FAIL = 111;
	/**
	 * 订购资格判断异常
	 */
	public static final int QUALIFICATION_ERROR = 112;
	
	//基本信息查询
	/**
	 * 查询成功
	 */
	public static final int QUERYBASEINFO_SUCC = 120;
	/**
	 * 无数据
	 */
	public static final int QUERYBASEINFO_FAIL = 121;
	/**
	 * 系统内部错误
	 */
	public static final int QUERYBASEINFO_ERROR = 122;
	
	//商品售价/订购基数查询
	/**
	 * 查询成功
	 */
	public static final int QUERYPRICERADIX_SUCC = 130;
	/**
	 * 无数据
	 */
	public static final int QUERYPRICERADIX_FAIL = 131;
	/**
	 * 系统内部错误
	 */
	public static final int QUERYPRICERADIX_ERROR = 132;
	
	//资料抽取
	/**
	 * 查询成功
	 */
	public static final int GETGOODSRESOURCE_SUCC = 140;
	/**
	 * 无数据
	 */
	public static final int GETGOODSRESOURCE_FAIL = 141;
	/**
	 * 系统内部错误
	 */
	public static final int GETGOODSRESOURCE_ERROR = 142;
	/**
	 * 查询次数过多
	 */
	public static final int GETGOODSRESOURCE_EXCEED = 146;
	/**
	 * ComType 不能为空
	 */
	public static final int GETGOODSRESOURCE_COMTYPENULL = 143;
	/**
	 * OrderCount 不能为空
	 */
	public static final int GETGOODSRESOURCE_ORDERCOUNTNULL = 144;
	/**
	 * WayID 不能为空
	 */
	public static final int GETGOODSRESOURCE_WAYIDNULL = 145;

	//商品订购订单提交
	/**
	 * 查询成功
	 */
	public static final int ORDERCOMMIT_SUCC = 150;
	/**
	 * 无数据
	 */
	public static final int ORDERCOMMIT_FAIL = 151;
	/**
	 * 系统内部错误
	 */
	public static final int ORDERCOMMIT_ERROR = 152;
}
