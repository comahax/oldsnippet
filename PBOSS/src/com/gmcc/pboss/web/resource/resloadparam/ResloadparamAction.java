/**
 * auto-generated code
 * Sat Sep 05 16:17:17 CST 2009
 */
 package com.gmcc.pboss.web.resource.resloadparam;

import com.gmcc.pboss.business.resource.resloadparam.ResloadparamVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.resloadparam.ResloadparamDBParam;
import com.gmcc.pboss.control.resource.resloadparam.Resloadparam ;

/**
 * <p>Title: ResloadparamAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResloadparamAction extends BaseAction{
	
	public ResloadparamAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ResloadparamForm());
		this.setParam(new ResloadparamWebParam());

        //ָ��VO��
        setClsVO(ResloadparamVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"id"};
		this.setClsControl(Resloadparam.class);
		this.setClsQueryParam(ResloadparamDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		ResloadparamDBParam param = (ResloadparamDBParam)super.getParam();
		if( null == param.get_se_cityid())
		param.set_se_cityid(super.getDBAccessUser().getCityid());
		return super.doList();
	}

	@Override
	public String doNew() throws Exception {
		// TODO Auto-generated method stub
		super.doNew();
		ResloadparamForm form = (ResloadparamForm)super.getForm();
		form.setCityid(super.getDBAccessUser().getCityid());
		return "content";
	}
	
	
	
}