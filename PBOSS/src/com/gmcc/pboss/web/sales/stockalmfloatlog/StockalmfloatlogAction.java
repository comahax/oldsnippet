/**
 * auto-generated code
 * Sun May 22 15:20:29 GMT 2011
 */
 package com.gmcc.pboss.web.sales.stockalmfloatlog;

import com.gmcc.pboss.business.sales.stockalmfloatlog.StockalmfloatlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.stockalmfloatlog.StockalmfloatlogDBParam;
import com.gmcc.pboss.control.sales.stockalmfloatlog.Stockalmfloatlog ;

/**
 * <p>Title: StockalmfloatlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class StockalmfloatlogAction extends BaseAction{
	
	public StockalmfloatlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new StockalmfloatlogForm());
		this.setParam(new StockalmfloatlogDBParam());

        //ָ��VO��
        setClsVO(StockalmfloatlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Stockalmfloatlog.class);
		this.setClsQueryParam(StockalmfloatlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}