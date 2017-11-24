package com.gmcc.pboss.biz.basic.goods.service;

import com.gmcc.pboss.common.service.ServiceType;

/**
 * 从兴公司电子渠道业务部
 * @author yuwenjun
 * @date 2009-11-12
 * 所属项目：PBOSS
 * 所属模块：商品订购操作码
 * 描述：
 */
public class GoodsServiceCode extends ServiceType {
	/**
	 * 商品订购资格检查
	 */
	public static final int Qualification = 110;
	/**
	 * 基本信息查询
	 */
	public static final int QueryBookBasicInfo = 111;
	/**
	 * 商品售价/订购基数查询
	 */
	public static final int GETPRICERADIX = 112;
	/**
	 * 商品订购订单提交
	 */
	public static final int ComOrderCommit = 115;
}
