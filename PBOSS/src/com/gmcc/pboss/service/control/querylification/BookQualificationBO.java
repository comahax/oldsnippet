package com.gmcc.pboss.service.control.querylification;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountDBParam;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.wayaccount.Wayaccount;
import com.gmcc.pboss.control.channel.wayaccount.WayaccountBO;
import com.gmcc.pboss.control.sales.wayassistant.Wayassistant;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;
import com.gmcc.pboss.service.exception.WebSiteException;
import com.gmcc.pboss.service.result.RetResult;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * 商品订购资格检查
 * @author Canigar
 *
 */
public class BookQualificationBO extends AbstractControlBean implements BookQualification{
	
	private static Logger logger = Logger.getLogger(BookQualificationBO.class);
	
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
	
	//step2
	private void doBookQualification(String wayid) throws Exception{
		Wayassistant wayassistant = (Wayassistant) BOFactory.build(WayassistantBO.class, user);
		WayassistantVO vo = wayassistant.doFindByPk(wayid);
		if(null == vo){
			throw new WebSiteException("该合作商["+wayid+"]商品订购辅助信息不存在",RetResult.FAILURE);
		}else if(1 != vo.getCanorder()){
			throw new WebSiteException("该合作商["+wayid+"]无商品订购资格，不能发起商品订购",RetResult.FAILURE);
		}else if("BANK".equals(vo.getPaytype())){
			doAccountInformation(wayid);//step3
		}
	}
	
	//step3
	private void doAccountInformation(String wayid) throws Exception{
		Wayaccount wayaccount = (Wayaccount) BOFactory.build(WayaccountBO.class,user);
		WayaccountDBParam params = new WayaccountDBParam();
		params.set_se_wayid(wayid);
		DataPackage dp = wayaccount.doQuery(params);
		if(dp.getDatas() == null || dp.getDatas().size() == 0){
			throw new WebSiteException("该合作商["+wayid+"]银行账号信息不完整",RetResult.FAILURE);
		}
		WayaccountVO vo = (WayaccountVO) dp.getDatas().get(0);
		if(StringUtils.isEmpty(vo.getDeacctno()) || StringUtils.isEmpty(vo.getDeacctname()) || StringUtils.isEmpty(vo.getDebankname())){
			throw new WebSiteException("该合作商["+wayid+"]银行账号信息不完整",RetResult.FAILURE);
		}
	}
	
	private RetResult doReturnSuccVal() throws Exception{
		RetResult result = new RetResult();
		result.setRetCode(RetResult.SUCCESS);
		result.setMessage("成功");
		return result;
	}
	
	public RetResult doCheck(String wayid) throws Exception{
		try{
			doBasicQualification(wayid);  //基本资料检查
			doBookQualification(wayid);  //订购资格检查
			return doReturnSuccVal();
		}catch (Exception e) {
			throw e;
		}
	}
	
}
