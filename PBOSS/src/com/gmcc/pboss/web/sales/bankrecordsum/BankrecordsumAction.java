/**
 * auto-generated code
 * Tue Jan 17 09:43:51 CST 2012
 */
 package com.gmcc.pboss.web.sales.bankrecordsum;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.gmcc.pboss.business.sales.bankrecordsum.BankrecordsumVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.bankrecordsum.BankrecordsumDBParam;
import com.gmcc.pboss.control.sales.bankrecordsum.Bankrecordsum ;

/**
 * <p>Title: BankrecordsumAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class BankrecordsumAction extends BaseAction{
	
	public BankrecordsumAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new BankrecordsumForm());
		this.setParam(new BankrecordsumDBParam());

        //指定VO类
        setClsVO(BankrecordsumVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Bankrecordsum.class);
		this.setClsQueryParam(BankrecordsumDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doList() throws Exception{
		BankrecordsumDBParam p = (BankrecordsumDBParam)this.getParam();
		String bStr = p.get_dnl_recordate();
		String eStr = p.get_dnm_recordate();
		if(bStr == null && eStr == null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String str = sdf.format(new Date());
			p.set_dnl_recordate(str);
			p.set_dnm_recordate(str);
		}
		super.doList();
		return WEB_RESULT_LIST;
	}

}