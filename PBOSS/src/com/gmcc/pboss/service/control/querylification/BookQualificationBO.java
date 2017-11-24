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
 * ��Ʒ�����ʸ���
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
			throw new WebSiteException("�ú�����["+wayid+"]������Ϣ������",RetResult.FAILURE);
		}
		user.setCityid(((WayVO)dp.getDatas().get(0)).getCityid());
	}
	
	//step2
	private void doBookQualification(String wayid) throws Exception{
		Wayassistant wayassistant = (Wayassistant) BOFactory.build(WayassistantBO.class, user);
		WayassistantVO vo = wayassistant.doFindByPk(wayid);
		if(null == vo){
			throw new WebSiteException("�ú�����["+wayid+"]��Ʒ����������Ϣ������",RetResult.FAILURE);
		}else if(1 != vo.getCanorder()){
			throw new WebSiteException("�ú�����["+wayid+"]����Ʒ�����ʸ񣬲��ܷ�����Ʒ����",RetResult.FAILURE);
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
			throw new WebSiteException("�ú�����["+wayid+"]�����˺���Ϣ������",RetResult.FAILURE);
		}
		WayaccountVO vo = (WayaccountVO) dp.getDatas().get(0);
		if(StringUtils.isEmpty(vo.getDeacctno()) || StringUtils.isEmpty(vo.getDeacctname()) || StringUtils.isEmpty(vo.getDebankname())){
			throw new WebSiteException("�ú�����["+wayid+"]�����˺���Ϣ������",RetResult.FAILURE);
		}
	}
	
	private RetResult doReturnSuccVal() throws Exception{
		RetResult result = new RetResult();
		result.setRetCode(RetResult.SUCCESS);
		result.setMessage("�ɹ�");
		return result;
	}
	
	public RetResult doCheck(String wayid) throws Exception{
		try{
			doBasicQualification(wayid);  //�������ϼ��
			doBookQualification(wayid);  //�����ʸ���
			return doReturnSuccVal();
		}catch (Exception e) {
			throw e;
		}
	}
	
}
