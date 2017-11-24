/**
 * auto-generated code
 * Fri May 07 16:29:05 CST 2010
 */
 package com.gmcc.pboss.web.sales.ordertimes;

import com.gmcc.pboss.business.sales.ordertimes.OrdertimesDBParam;
import com.gmcc.pboss.business.sales.ordertimes.OrdertimesVO;
import com.gmcc.pboss.control.sales.ordertimes.Ordertimes;
import com.gmcc.pboss.control.sales.ordertimes.OrdertimesBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: OrdertimesAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zsw
 * @version 1.0
 */
public class OrdertimesAction extends BaseAction{
	private String otlimitType;//订购次数约束类型
	
	public String getOtlimitType() {
		return otlimitType;
	}

	public void setOtlimitType(String otlimitType) {
		this.otlimitType = otlimitType;
	}

	public OrdertimesAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new OrdertimesForm());
		this.setParam(new OrdertimesDBParam());

        //指定VO类
        setClsVO(OrdertimesVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Ordertimes.class);
		this.setClsQueryParam(OrdertimesDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	public String doList() throws Exception {
		OrdertimesDBParam params = (OrdertimesDBParam)getParam();
		if ("APPSTAR".equals(this.otlimitType)) {// 星级
			params.set_se_objtype("APPSTAR");
			super.doList();
			return "list";
		}else{// 渠道
			params.set_se_objtype("APPWAY");
			super.doList();
			return "list2";
		}
	}

	@Override
	public String doEdit() throws Exception {
		super.doEdit();
		if ("APPSTAR".equals(this.otlimitType)) {// 星级
			return "content";
		}else{// 渠道
			return "content2";
		}
	}

	@Override
	public String doNew() throws Exception {
		super.doNew();
		if ("APPSTAR".equals(this.otlimitType)) {// 星级
			return "content";
		}else{// 渠道
			return "content2";
		}
	}

	@Override
	public String doSave() throws Exception {
		try {
			Ordertimes control = (Ordertimes)BOFactory.build(OrdertimesBO.class, getDBAccessUser());
			OrdertimesForm form = (OrdertimesForm)getForm();
			OrdertimesDBParam params = new OrdertimesDBParam();
			params.set_se_objtype(form.getObjtype());
			params.set_se_objectcode(form.getObjectcode());
			params.set_ne_isurgent(form.getIsurgent().toString());
			if (WEB_CMD_EDIT.equals(CMD)) {
				params.set_nne_recid(form.getRecid().toString());
			}
			DataPackage dp = control.doQuery(params);
			if(null != dp && dp.getRowCount()>0){
				if("APPSTAR".equals(form.getObjtype())){
					throw new Exception("该星级的数据已存在，请检查。");
				}else{
					throw new Exception("该合作商的数据已存在，请检查。");
				}
			}
			super.doSave();
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		if ("APPSTAR".equals(this.otlimitType)) {// 星级
			return "content";
		}else{// 渠道
			return "content2";
		}
	}
	
	
	
	
	
}