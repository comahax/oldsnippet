/**
 * auto-generated code
 * Fri Sep 25 15:01:17 CST 2009
 */
 package com.gmcc.pboss.web.resource.resimport;

import com.gmcc.pboss.business.resource.resimport.ResimportVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.resimport.ResimportDBParam;
import com.gmcc.pboss.control.resource.resimport.Resimport ;

/**
 * <p>Title: ResimportAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResimportAction extends BaseAction{
	
	public ResimportAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ResimportForm());
		this.setParam(new ResimportWebParam());

        //ָ��VO��
        setClsVO(ResimportVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Resimport.class);
		this.setClsQueryParam(ResimportDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}