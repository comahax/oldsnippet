/**
 * auto-generated code
 * Thu Jul 01 16:27:16 CST 2010
 */
 package com.gmcc.pboss.web.sales.comdisscalelog;

import com.gmcc.pboss.business.sales.comdisscalelog.ComdisscalelogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.comdisscalelog.ComdisscalelogDBParam;
import com.gmcc.pboss.control.sales.comdisscalelog.Comdisscalelog ;

/**
 * <p>Title: ComdisscalelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ComdisscalelogAction extends BaseAction{
	
	public ComdisscalelogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ComdisscalelogForm());
		this.setParam(new ComdisscalelogDBParam());

        //ָ��VO��
        setClsVO(ComdisscalelogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Comdisscalelog.class);
		this.setClsQueryParam(ComdisscalelogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}