/**
 * auto-generated code
 * Mon Aug 16 15:40:34 CST 2010
 */
 package com.gmcc.pboss.web.resource.resinfostat;

import com.gmcc.pboss.business.resource.resinfostat.ResinfostatVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.resinfostat.ResinfostatDBParam;
import com.gmcc.pboss.control.resource.resinfostat.Resinfostat ;

/**
 * <p>Title: ResinfostatAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zhangsiwei
 * @version 1.0
 */
public class ResinfostatAction extends BaseAction{
	
	public ResinfostatAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ResinfostatForm());
		this.setParam(new ResinfostatDBParam());

        //ָ��VO��
        setClsVO(ResinfostatVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"brand","statdate","wayid"};
		this.setClsControl(Resinfostat.class);
		this.setClsQueryParam(ResinfostatDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}