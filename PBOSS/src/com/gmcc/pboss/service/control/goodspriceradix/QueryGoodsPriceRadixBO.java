package com.gmcc.pboss.service.control.goodspriceradix;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.comorder.Comorder;
import com.gmcc.pboss.control.sales.comorder.ComorderBO;
import com.gmcc.pboss.service.exception.WebSiteException;
import com.gmcc.pboss.service.result.RetResult;
import com.gmcc.pboss.service.result.goods.GoodsInfo;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class QueryGoodsPriceRadixBO extends AbstractControlBean implements QueryGoodsPriceRadix{

	private static Logger logger = Logger.getLogger(QueryGoodsPriceRadixBO.class);
	
	//step1
	private void doBasicQualification(String wayid) throws Exception{
		Way way = (Way) BOFactory.build(WayBO.class, user);
		WayDBParam params = new WayDBParam();
		params.set_se_wayid(wayid);
		params.set_se_waytype("AG");
		DataPackage dp = way.doQuery(params);
		if(dp.getDatas() == null || dp.getDatas().size() == 0){
			throw new WebSiteException("该合作商["+wayid+"]基本信息不存在",RetResult.FAILURE);
		}
		user.setCityid(((WayVO)dp.getDatas().get(0)).getCityid());
	}
	
	//step2 商品单价
	private Double doGetUnitprice(String wayid, String comType) throws Exception{
		Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
		return comorder.doGetUnitprice(wayid, comType);
	}
	
	//step3 订购基数
	private Integer doGetUnitage(String comType)  throws Exception{
		Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
		return Integer.parseInt(comorder.doGetUnitage(user.getCityid(), comType));
	}
	
	private GoodsInfo doReturnSuccVal(String wayid, String comType) throws Exception{
		GoodsInfo result = new GoodsInfo();
		result.setRetCode(RetResult.SUCCESS);
		result.setMessage("成功");
		result.setPrice(this.doGetUnitprice(wayid, comType));
		result.setRadix(doGetUnitage(comType));
		return result;
	}
	
	
	public GoodsInfo doQuery(String wayid, String comType) throws Exception{
		try{
			doBasicQualification(wayid);
			return doReturnSuccVal(wayid,comType);
		}catch (Exception e) {
			throw e;
		}
	}
	
}
