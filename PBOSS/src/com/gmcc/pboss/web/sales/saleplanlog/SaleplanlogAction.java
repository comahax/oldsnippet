/**
 * auto-generated code
 * Tue Nov 08 14:10:56 CST 2011
 */
 package com.gmcc.pboss.web.sales.saleplanlog;

import com.gmcc.pboss.business.sales.saleplanlog.SaleplanlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.saleplanlog.SaleplanlogDBParam;
import com.gmcc.pboss.control.sales.saleplanlog.Saleplanlog ;

/**
 * <p>Title: SaleplanlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class SaleplanlogAction extends BaseAction{
	
	public SaleplanlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new SaleplanlogForm());
		this.setParam(new SaleplanlogDBParam());

        //ָ��VO��
        setClsVO(SaleplanlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Saleplanlog.class);
		this.setClsQueryParam(SaleplanlogDBParam.class) ;

	}
}