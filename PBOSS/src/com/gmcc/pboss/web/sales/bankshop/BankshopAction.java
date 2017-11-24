/**
 * auto-generated code
 * Mon Aug 23 12:07:17 CST 2010
 */
 package com.gmcc.pboss.web.sales.bankshop;

import com.gmcc.pboss.business.sales.bankshop.BankshopVO ;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.bankshop.BankshopDBParam;
import com.gmcc.pboss.control.sales.bankshop.Bankshop ;
import com.gmcc.pboss.control.sales.bankshop.BankshopBO;

/**
 * <p>Title: BankshopAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class BankshopAction extends BaseAction{
	
	public BankshopAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new BankshopForm());
		this.setParam(new BankshopDBParam());

        //指定VO类
        setClsVO(BankshopVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Bankshop.class);
		this.setClsQueryParam(BankshopDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	public String doList() throws Exception {
		BankshopDBParam param = (BankshopDBParam)getParam();
		param.set_se_cityid(getDBAccessUser().getCityid());
		return super.doList();
	}

	@Override
	public String doSave() throws Exception {
		try {
			Bankshop bo = (Bankshop)BOFactory.build(BankshopBO.class, getDBAccessUser());
			BankshopForm form = (BankshopForm)getForm();
			BankshopDBParam param = new BankshopDBParam();
			param.set_se_cityid(form.getCityid());
			param.set_se_countyid(form.getCountyid());
			if (WEB_CMD_NEW.equals(CMD)) {
				DataPackage dp = bo.doQuery(param);
				if (dp.getRowCount() > 0) {
					throw new Exception("相同记录已经存在，请检查。");
				}
				super.doSave();
			} else {
				//param.set_nne_recid(form.getRecid().toString());
				param.getQueryConditions().put("_nne_recid",form.getRecid().toString());
				DataPackage dp = bo.doQuery(param);
				if (dp.getRowCount() > 0) {
					throw new Exception("相同记录已经存在，请检查。");
				}
				super.doSave();
			}
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		return "content";
	}
}