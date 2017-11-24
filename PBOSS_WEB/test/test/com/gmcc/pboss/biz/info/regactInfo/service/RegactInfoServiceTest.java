package test.com.gmcc.pboss.biz.info.regactInfo.service;

import java.util.List;

import com.gmcc.pboss.biz.info.regactInfo.model.MhTkRegactinfo;
import com.gmcc.pboss.biz.info.regactInfo.service.RegactInfoService;
import com.gmcc.pboss.biz.info.regactInfo.support.RegactInfoQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;

import test.com.gmcc.pboss.common.BaseTest;

public class RegactInfoServiceTest extends BaseTest {

	private RegactInfoService regactInfoService;

	/**
	 * @return the regactInfoService
	 */
	public RegactInfoService getRegactInfoService() {
		return regactInfoService;
	}

	/**
	 * @param regactInfoService the regactInfoService to set
	 */
	public void setRegactInfoService(RegactInfoService regactInfoService) {
		this.regactInfoService = regactInfoService;
	}


	public void testQuery() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		RegactInfoQueryParameter parameter = new RegactInfoQueryParameter();
		parameter.setWayid("CH_2323");
		parameter.setMonth("200911");
		
		ServiceResult result = regactInfoService.query(new LoginMember(), parameter);
		//System.out.println(result);
		List data = result.getRetResult().getData();
		System.out.println("¸öÊý£º"+ data.size());
		for (int i=0;i<data.size();i++){
		}
	}

}
