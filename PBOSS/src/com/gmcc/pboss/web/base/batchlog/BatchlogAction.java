/**
 * auto-generated code
 * Mon Sep 07 10:54:49 CST 2009
 */
 package com.gmcc.pboss.web.base.batchlog;

import com.gmcc.pboss.business.base.batchlog.BatchlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.batchlog.BatchlogDBParam;
import com.gmcc.pboss.control.base.batchlog.Batchlog ;

/**
 * <p>Title: BatchlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class BatchlogAction extends BaseAction{
	
	public BatchlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new BatchlogForm());
		this.setParam(new BatchlogWebParam());

        //ָ��VO��
        setClsVO(BatchlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Batchlog.class);
		this.setClsQueryParam(BatchlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}