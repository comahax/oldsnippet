/**
 * auto-generated code
 * Wed Oct 14 10:59:52 CST 2009
 */
 package com.gmcc.pboss.web.sales.orderflow;

import com.gmcc.pboss.business.sales.orderflow.OrderflowVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.orderflow.OrderflowDBParam;
import com.gmcc.pboss.control.sales.orderflow.Orderflow ;

/**
 * <p>Title: OrderflowAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderflowAction extends BaseAction{
	
	public OrderflowAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new OrderflowForm());
		this.setParam(new OrderflowWebParam());

        //ָ��VO��
        setClsVO(OrderflowVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"flowid"};
		this.setClsControl(Orderflow.class);
		this.setClsQueryParam(OrderflowDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	public String doNew() throws Exception {
		// TODO Auto-generated method stub
		super.doNew();
		OrderflowForm form = (OrderflowForm)super.getForm();
		form.setCityid(super.getDBAccessUser().getCityid());
		return WEB_RESULT_CONTENT;
	}

	@Override
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		OrderflowDBParam param = (OrderflowDBParam)super.getParam();
		param.set_se_cityid(super.getDBAccessUser().getCityid());
		return super.doList();
	}
	
	
}