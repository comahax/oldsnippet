/**
 * auto-generated code
 * Thu Sep 17 14:53:18 CST 2009
 */
 package com.gmcc.pboss.web.promotion.spproposallog;

import com.gmcc.pboss.business.promotion.spproposallog.SpproposallogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.promotion.spproposallog.SpproposallogDBParam;
import com.gmcc.pboss.control.promotion.spproposallog.Spproposallog ;

/**
 * <p>Title: SpproposallogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class SpproposallogAction extends BaseAction{
	
	public SpproposallogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new SpproposallogForm());
		this.setParam(new SpproposallogWebParam());

        //ָ��VO��
        setClsVO(SpproposallogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Spproposallog.class);
		this.setClsQueryParam(SpproposallogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}