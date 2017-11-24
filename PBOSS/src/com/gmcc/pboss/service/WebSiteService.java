package com.gmcc.pboss.service;

import java.util.List;

import com.gmcc.pboss.service.result.RetResult;
import com.gmcc.pboss.service.result.goods.BookBasicInfo;
import com.gmcc.pboss.service.result.goods.GoodsInfo;
import com.gmcc.pboss.service.result.goods.GoodsResource;

/**
 * 提供给网站使用的接口
 * 
 * @author hbm
 */
public interface WebSiteService {
	// 用于测试服务是否可用
	String test(String param);

	// 商品订购资格检查
	// 功能描述: 验证用户是否具有商品订购的资格。
	RetResult bookQualificationCheck(String wayid);

	// 基本信息查询
	// 功能描述：查询用户以往的订购信息。
	BookBasicInfo queryBookBasicInfo(String wayid);

	// 商品售价、订购基数查询
	// 功能描述：查询商品售价、订购基数。
	GoodsInfo queryGoodsPriceRadix(String wayid, String comType);

	// 商品资源抽取
	// 功能描述：根据商品种类和数量，返回商品包和资源明细，提供给用户选择。
	GoodsResource getGoodsResource(String wayid, String comType, int orderCount);

	// 商品订购订单提交
	// 功能描述：商品订购。
	RetResult comOrderCommit(String wayid, boolean isQueryDetail, List comOrderList);
	
	/**
	 * 订单下一步处理
	 * @param wayid
	 * @param orderid
	 * @return
	 */
	RetResult doOrderNextProc (String wayid,String orderid);
}
