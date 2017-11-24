/**
 * auto-generated code
 * Tue Aug 24 11:24:17 CST 2010
 */
 package com.gmcc.pboss.web.sales.bankdeduct;

import java.util.Date;

import com.gmcc.pboss.business.sales.bankdeduct.BankdeductVO ;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductDBParam;
import com.gmcc.pboss.control.sales.bankdeduct.Bankdeduct ;

/**
 * <p>Title: BankdeductAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class BankdeductAction extends BaseAction{
	
	public BankdeductAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new BankdeductForm());
		this.setParam(new BankdeductDBParam());

        //ָ��VO��
        setClsVO(BankdeductVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"deductid"};
		this.setClsControl(Bankdeduct.class);
		this.setClsQueryParam(BankdeductDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	public String doList() throws Exception {
		BankdeductDBParam param = (BankdeductDBParam)getParam();
		//Ĭ�ϰ��������ʼʱ���ѯ
		if(null == param.get_dnl_creatdate() )
			param.set_dnl_creatdate(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 00:00:00");
		if(null == param.get_dnm_creatdate() )
			param.set_dnm_creatdate(PublicUtils.formatUtilDate(new Date(),"yyyy-MM-dd")+" 23:59:59");
		return super.doList();
	}
}