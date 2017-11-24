/**
 * auto-generated code
 * Thu Sep 09 16:14:40 CST 2010
 */
 package com.gmcc.pboss.web.channel.bank;

import com.gmcc.pboss.business.channel.bank.BankDBParam;
import com.gmcc.pboss.business.channel.bank.BankVO;
import com.gmcc.pboss.control.channel.bank.Bank;
import com.gmcc.pboss.control.channel.bank.BankBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: BankAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class BankAction extends BaseAction{
	
	public BankAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new BankForm());
		this.setParam(new BankDBParam());

        //指定VO类
        setClsVO(BankVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"bankid"};
		this.setClsControl(Bank.class);
		this.setClsQueryParam(BankDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doBankselect() throws Exception {
		BankDBParam param = (BankDBParam)getParam();
		BankBO bo = (BankBO)BOFactory.build(BankBO.class, getDBAccessUser());
		DataPackage dp = bo.doQueryBank(param);
		setDp(dp);
		return "bankselect";
	}
}