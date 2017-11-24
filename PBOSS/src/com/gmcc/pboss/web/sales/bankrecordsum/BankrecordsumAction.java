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

		//���¼��������Ǳ����
		this.setForm(new BankrecordsumForm());
		this.setParam(new BankrecordsumDBParam());

        //ָ��VO��
        setClsVO(BankrecordsumVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Bankrecordsum.class);
		this.setClsQueryParam(BankrecordsumDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
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