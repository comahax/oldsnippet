/**
 * auto-generated code
 * Thu Sep 03 10:29:08 CST 2009
 */
 package com.gmcc.pboss.web.resource.resloadparamlog;

import com.gmcc.pboss.business.resource.resloadparamlog.ResloadparamlogDBParam;
import com.gmcc.pboss.business.resource.resloadparamlog.ResloadparamlogVO;
import com.gmcc.pboss.control.resource.resloadparamlog.Resloadparamlog;
import com.gmcc.pboss.control.resource.resloadparamlog.ResloadparamlogBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: ResloadparamlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ResloadparamlogAction extends BaseAction{
	
	public ResloadparamlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ResloadparamlogForm());
		this.setParam(new ResloadparamlogWebParam());

        //ָ��VO��
        setClsVO(ResloadparamlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Resloadparamlog.class);
		this.setClsQueryParam(ResloadparamlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	public String doList() throws Exception {
		ResloadparamlogDBParam param=(ResloadparamlogDBParam)super.getParam();
		param.set_se_cityid(getDBAccessUser().getCityid());
		String dnm_optime = param.get_dnm_optime();
		String dnl_optime = param.get_dnl_optime();
		if(dnm_optime != null && dnm_optime.trim().length()==10)
			param.set_dnm_optime(dnm_optime.trim()+" 23:59:59");
		if(dnl_optime != null && dnl_optime.trim().length()==10)
			param.set_dnl_optime(dnl_optime.trim()+" 00:00:00");
		Resloadparamlog bo = (Resloadparamlog) BOFactory.build(ResloadparamlogBO.class, getDBAccessUser());
		DataPackage dp =bo.doQuery(param);
		super.setDp(dp);
		return "list";
	}
	
}