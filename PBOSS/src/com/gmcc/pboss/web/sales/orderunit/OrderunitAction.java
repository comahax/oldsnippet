/**
 * auto-generated code
 * Tue Oct 13 14:32:53 CST 2009
 */
 package com.gmcc.pboss.web.sales.orderunit;

import com.gmcc.pboss.business.sales.orderunit.OrderunitDBParam;
import com.gmcc.pboss.business.sales.orderunit.OrderunitVO;
import com.gmcc.pboss.control.sales.orderunit.Orderunit;
import com.gmcc.pboss.control.sales.orderunit.OrderunitBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: OrderunitAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OrderunitAction extends BaseAction{
	
	public OrderunitAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new OrderunitForm());
		this.setParam(new OrderunitWebParam());

        //指定VO类
        setClsVO(OrderunitVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Orderunit.class);
		this.setClsQueryParam(OrderunitDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doList() throws Exception{
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		OrderunitDBParam param = (OrderunitDBParam)getParam();
		param.set_se_unitagemode("FIXED");
		param.set_se_cityid(cityid);
		super.doList();
		return WEB_RESULT_LIST;
	}
	
	public String doNew() throws Exception{
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		OrderunitForm form = (OrderunitForm)getForm();
		form.setUnitage("20");
		form.setUnitagemode("FIXED");
		this.setCMD(WEB_CMD_NEW);
		return WEB_RESULT_CONTENT;
	}
	
	public String doEdit() throws Exception{
		super.doEdit();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		return WEB_RESULT_CONTENT;
	}
	
	public String doSave() throws Exception {
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		try {
			OrderunitForm form = (OrderunitForm) getForm();
			OrderunitDBParam param = new OrderunitDBParam();
			param.set_se_cityid(form.getCityid());
			param.set_se_comcategory(form.getComcategory());
			param.set_se_unitagemode(form.getUnitagemode());
			Orderunit control = (Orderunit) BOFactory.build(
					OrderunitBO.class, getDBAccessUser());
			if (WEB_CMD_NEW.equals(CMD)) {
				DataPackage dp = control.doQuery(param);
				if (dp.getRowCount() > 0) {
					throw new Exception("相同记录已经存在，请检查。");
				}
				super.doSave();
			} else {
				param.set_nne_recid(form.getRecid().toString());
				DataPackage dp = control.doQuery(param);
				if (dp.getRowCount() > 0) {
					throw new Exception("相同记录已经存在，请检查。");
				}
				super.doSave();
			}
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		return WEB_RESULT_CONTENT;
	}
}