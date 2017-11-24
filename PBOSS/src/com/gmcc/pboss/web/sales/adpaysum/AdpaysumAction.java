/**
 * auto-generated code
 * Wed Apr 28 12:20:30 CST 2010
 */
 package com.gmcc.pboss.web.sales.adpaysum;

import com.gmcc.pboss.business.sales.adpaysum.AdpaysumDBParam;
import com.gmcc.pboss.business.sales.adpaysum.AdpaysumVO;
import com.gmcc.pboss.control.sales.adpaysum.Adpaysum;
import com.gmcc.pboss.control.sales.adpaysum.AdpaysumBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: AdpaysumAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class AdpaysumAction extends BaseAction{
	
	public AdpaysumAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new AdpaysumForm());
		this.setParam(new AdpaysumDBParam());

        //指定VO类
        setClsVO(AdpaysumVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"sumid"};
		this.setClsControl(Adpaysum.class);
		this.setClsQueryParam(AdpaysumDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doList() throws Exception{
		if(this.isQuery){ 
			AdpaysumDBParam params =(AdpaysumDBParam)this.getParam();
			Adpaysum bo = (AdpaysumBO)BOFactory.build(AdpaysumBO.class, getDBAccessUser());
			DataPackage dp = bo.doQuery(params);
			this.setDp(dp);
		}
		return WEB_RESULT_LIST;
	}
	
	//执行确认
	public String doConfirm() throws Exception{
		try {
			Adpaysum adpaysum = (Adpaysum)BOFactory.build(AdpaysumBO.class, getDBAccessUser());
			String[] selectItem = param.get_selectitem();
			String sumid = getParam().get_pk();
			adpaysum.doConfirm(sumid);
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return super.doList();
	}
	
	//执行支付
	public String doPay() throws Exception{
		try{
			Adpaysum adpaysum = (Adpaysum)BOFactory.build(AdpaysumBO.class, getDBAccessUser());
			String sumid = getParam().get_pk();
			adpaysum.doPay(sumid);
			super.addActionMessage("汇总单["+sumid+"]支付成功");
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return super.doList();
	}
	
	//查看明细
	public String doDetail() throws Exception{
		try {
			Order order = (Order)BOFactory.build(OrderBO.class, getDBAccessUser());
//			String[] selectItem = param.get_selectitem();
//			String[] pk = null;
//			pk = selectItem[0].split("\\|");
//			String _ne_sumid = pk[0];
//			String _ne_sumid = getRequest().getParameter("sumid");
			String _ne_sumid = getParam().get_pk();
			DataPackage dp = order.doQueryAdpaydet(_ne_sumid);
			setDp(dp);
			
			Adpaysum adpaysum = (Adpaysum)BOFactory.build(AdpaysumBO.class, getDBAccessUser());
			AdpaysumVO vo = (AdpaysumVO) adpaysum.doFindByPk(new Long(_ne_sumid));
			AdpaysumForm form2 = new AdpaysumForm();
			BeanUtils.copyProperties(form2, vo);
			setForm(form2);
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return "detail";
	}
	private boolean isQuery;// 是否统计标识，默认不查询

	public boolean getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(boolean isQuery) {
		this.isQuery = isQuery;
	}
}