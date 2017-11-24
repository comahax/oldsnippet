/**
 * auto-generated code
 * Wed Oct 14 13:53:36 CST 2009
 */
 package com.gmcc.pboss.web.sales.orderproce;

import com.gmcc.pboss.business.sales.orderproce.OrderproceVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.control.sales.orderproce.Orderproce ;

/**
 * <p>Title: OrderproceAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderproceAction extends BaseAction{
	
	public OrderproceAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new OrderproceForm());
		this.setParam(new OrderproceWebParam());

        //ָ��VO��
        setClsVO(OrderproceVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Orderproce.class);
		this.setClsQueryParam(OrderproceDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	/*
	 * �������̹����ж��������б�
	 */
	public String doListByFlow(){
		try{
			OrderproceWebParam param = (OrderproceWebParam)super.getParam();
			if( null != param.get_ne_flowid() && !"".equals(param.get_ne_flowid())){
				OrderproceForm form = (OrderproceForm)super.getForm();
				form.setFlowid(new Long(param.get_ne_flowid()));
				super.doList();
			}
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return "listbyflow";
	}
	
	/*
	 * �������̹����ж������豣��
	 */
	public String doSaveInFlow(){
		try{
			super.doSave();
		}catch(Exception e){
			e.getMessage();
			super.addActionError(e.getMessage());
		}
		return doListByFlow();
	}
	
	
	/*
	 * �������̹����ж�������ɾ��
	 */
	public String doDeleteInFlow(){
		try{
			super.doDelete();
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return doListByFlow();
	}
	
	public String doEditInFlow(){
		try{
			super.doEdit();
			//super.doList();
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return "listbyflow";
	}
	
	
	public String doNewInFlow(){
		try{
			super.doNew();
			super.setForm(new OrderproceForm());
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return "listbyflow";
	}
}