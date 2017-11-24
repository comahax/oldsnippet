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
	// ���ڲ��Է����Ƿ����
	private static Logger logger = Logger.getLogger(WebSiteServiceImpl.class);
	
	public String test(String param) {
		return "Web Site Service running! you input is:[" + param + "]";
	}

	// ��Ʒ�����ʸ���
	// ��������: ��֤�û��Ƿ������Ʒ�������ʸ�
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

	// ������Ϣ��ѯ
	// ������������ѯ�û������Ķ�����Ϣ��
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

	// ��Ʒ�ۼۡ�����������ѯ
	// ������������ѯ��Ʒ�ۼۡ�����������
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

	// ��Ʒ��Դ��ȡ
	// ����������������Ʒ�����������������Ʒ������Դ��ϸ���ṩ���û�ѡ��
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

	// ��Ʒ���������ύ
	// ������������Ʒ������
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
	 * ������һ������
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
