/**
 * auto-generated code
 * Tue Jun 22 17:26:01 CST 2010
 */
 package com.gmcc.pboss.web.sales.stockalarmlog;

import com.gmcc.pboss.business.sales.stockalarmlog.StockalarmlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.stockalarmlog.StockalarmlogDBParam;
import com.gmcc.pboss.control.sales.stockalarmlog.Stockalarmlog ;

/**
 * <p>Title: StockalarmlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class StockalarmlogAction extends BaseAction{
	
	public StockalarmlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new StockalarmlogForm());
		this.setParam(new StockalarmlogDBParam());

        //ָ��VO��
        setClsVO(StockalarmlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Stockalarmlog.class);
		this.setClsQueryParam(StockalarmlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}