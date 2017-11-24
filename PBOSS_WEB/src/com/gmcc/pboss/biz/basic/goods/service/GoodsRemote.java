package com.gmcc.pboss.biz.basic.goods.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.gmcc.pboss.biz.basic.goods.bean.Goods;
import com.gmcc.pboss.biz.basic.goods.supper.GoodsListQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.BaseService;
import com.gmcc.pboss.common.service.ServiceResult;

public interface GoodsRemote extends BaseService {
	/**
	 * 商品订购资格检查
	 * @param wayId 渠道编码
	 * @return
	 */
	public ServiceResult chkQualification(LoginMember member);
	
	/**
	 * 基本信息查询
	 * @param wayId 渠道编码
	 * @return
	 */
	public ServiceResult getBaseInfo(LoginMember member);
	
	/**
	 * 商品售价/订购基数查询
	 * @param wayId 渠道编码
	 * @param prdcClg 商品种类（不包括充值卡）
	 * @return
	 */
	public ServiceResult getPriceRadix(LoginMember member,String comType);
	
	/**
	 * 商品资源抽取
	 * @param wayId 渠道商编码
	 * @param comType 商品种类标识。
	 * @param orderCount 订购套数。
	 * @return
	 */
	public ServiceResult getProductList(String wayId,String comType,int orderCount,GoodsListQueryParameter param);
	
	/**
	 * 商品订购订单提交
	 * @param wayId 渠道商编码
	 * @param sendObj 字符串数组,每个内容为：商品种类标识~订购套数
	 * @return
	 */
	public ServiceResult submitOrder(LoginMember member,List<Goods> sendObj,boolean isQueryDetail);
	
}