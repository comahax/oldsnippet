/**
 * auto-generated code
 * Thu Jul 01 16:47:05 CST 2010
 */
 package com.gmcc.pboss.web.sales.compricelog;

import com.gmcc.pboss.business.sales.compricelog.CompricelogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.compricelog.CompricelogDBParam;
import com.gmcc.pboss.control.sales.compricelog.Compricelog ;

/**
 * <p>Title: CompricelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class CompricelogAction extends BaseAction{
	
	public CompricelogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new CompricelogForm());
		this.setParam(new CompricelogWebParam());

        //ָ��VO��
        setClsVO(CompricelogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Compricelog.class);
		this.setClsQueryParam(CompricelogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}