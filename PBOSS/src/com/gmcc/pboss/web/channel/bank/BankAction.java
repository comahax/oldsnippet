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

		//���¼��������Ǳ����
		this.setForm(new BankForm());
		this.setParam(new BankDBParam());

        //ָ��VO��
        setClsVO(BankVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"bankid"};
		this.setClsControl(Bank.class);
		this.setClsQueryParam(BankDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
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