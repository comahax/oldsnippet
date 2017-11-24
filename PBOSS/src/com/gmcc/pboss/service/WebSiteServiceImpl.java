package com.gmcc.pboss.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.service.control.basicinformation.BookBasicInformation;
import com.gmcc.pboss.service.control.basicinformation.BookBasicInformationBO;
import com.gmcc.pboss.service.control.goodsordercommit.ComOrderCommit;
import com.gmcc.pboss.service.control.goodsordercommit.ComOrderCommitBO;
import com.gmcc.pboss.service.control.goodspriceradix.QueryGoodsPriceRadix;
import com.gmcc.pboss.service.control.goodspriceradix.QueryGoodsPriceRadixBO;
import com.gmcc.pboss.service.control.goodsresource.GainGoodsResource;
import com.gmcc.pboss.service.control.goodsresource.GainGoodsResourceBO;
import com.gmcc.pboss.service.control.order.OrderProcess;
import com.gmcc.pboss.service.control.order.OrderProcessBO;
import com.gmcc.pboss.service.control.querylification.BookQualification;
import com.gmcc.pboss.service.control.querylification.BookQualificationBO;
import com.gmcc.pboss.service.result.RetResult;
import com.gmcc.pboss.service.result.goods.BookBasicInfo;
import com.gmcc.pboss.service.result.goods.GoodsInfo;
import com.gmcc.pboss.service.result.goods.GoodsResource;
import com.sunrise.jop.exception.business.SaleException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;

/**
 * @author hbm
 * 
 */
public class WebSiteServiceImpl implements WebSiteService {
	// 用于测试服务是否可用
	private static Logger logger = Logger.getLogger(WebSiteServiceImpl.class);
	
	public String test(String param) {
		return "Web Site Service running! you input is:[" + param + "]";
	}

	// 商品订购资格检查
	// 功能描述: 验证用户是否具有商品订购的资格。
	public RetResult bookQualificationCheck(String wayid) {
		try{
			BookQualification bookQualification = (BookQualification)BOFactory.build(BookQualificationBO.class, DBAccessUser.getInnerUser());
			RetResult result = bookQualification.doCheck(wayid);
			return result;
		}catch (Exception e) {
			return WebSiteUtils.getErrorResult(e, logger);
			// TODO: handle exception
		}
	}

	// 基本信息查询
	// 功能描述：查询用户以往的订购信息。
	public BookBasicInfo queryBookBasicInfo(String wayid) {
		try{
			BookBasicInformation bookBasicInformation = (BookBasicInformation)BOFactory.build(BookBasicInformationBO.class,DBAccessUser.getInnerUser());
			BookBasicInfo result = bookBasicInformation.doCheck(wayid);
			return result;
		}catch (Exception e) {
			BookBasicInfo basicInfo = new BookBasicInfo();
			RetResult result = WebSiteUtils.getErrorResult(e, logger);
			basicInfo.setRetCode(result.getRetCode());
			basicInfo.setMessage(result.getMessage());
			return basicInfo;
		}
	}

	// 商品售价、订购基数查询
	// 功能描述：查询商品售价、订购基数。
	public GoodsInfo queryGoodsPriceRadix(String wayid, String comType) {
		try{
			QueryGoodsPriceRadix queryGoodsPriceRadix = (QueryGoodsPriceRadix)BOFactory.build(QueryGoodsPriceRadixBO.class,DBAccessUser.getInnerUser());
			GoodsInfo result = queryGoodsPriceRadix.doQuery(wayid, comType);
			return result;
		}catch (Exception e) {
			GoodsInfo goodsInfo = new GoodsInfo();
			RetResult result = WebSiteUtils.getErrorResult(e, logger);
			goodsInfo.setRetCode(result.getRetCode());
			goodsInfo.setMessage(result.getMessage());
			return goodsInfo;
		}
	}

	// 商品资源抽取
	// 功能描述：根据商品种类和数量，返回商品包和资源明细，提供给用户选择。
	public GoodsResource getGoodsResource(String wayid, String comType, int orderCount){
		try{
			GainGoodsResource gainGoodsResource = (GainGoodsResource)BOFactory.build(GainGoodsResourceBO.class, DBAccessUser.getInnerUser());
			GoodsResource result = gainGoodsResource.doGain(wayid, comType, orderCount);
			return result;
		}catch (Exception e) {
			GoodsResource goodsResource = new GoodsResource();
			RetResult result = WebSiteUtils.getErrorResult(e, logger);
			goodsResource.setRetCode(result.getRetCode());
			goodsResource.setMessage(result.getMessage());
			return goodsResource;
		}
	}

	// 商品订购订单提交
	// 功能描述：商品订购。
	public RetResult comOrderCommit(String wayid, boolean isQueryDetail, List comOrderList) {
		try{
			ComOrderCommit comOrderCommit = (ComOrderCommit)BOFactory.build(ComOrderCommitBO.class, DBAccessUser.getInnerUser());
			RetResult result = comOrderCommit.doCheck(wayid,isQueryDetail,comOrderList);
			return result;
		}catch (Exception e) {
			return WebSiteUtils.getErrorResult(e, logger);
			// TODO: handle exception
		}
	}

	/**
	 * 订单下一步处理
	 */
	public RetResult doOrderNextProc(String wayid, String orderid) {
		// TODO Auto-generated method stub
		RetResult result = new RetResult();
		try {
			OrderProcess orderBO = (OrderProcess)BOFactory.build(OrderProcessBO.class,DBAccessUser.getInnerUser());
			return orderBO.doNextProcess(wayid, orderid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setRetCode(2);
			result.setMessage(e.getMessage());
		}
		return result;
	}

}
