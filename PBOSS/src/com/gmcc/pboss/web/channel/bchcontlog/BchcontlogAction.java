/**
 * auto-generated code
 * Sun Oct 18 20:53:55 CST 2009
 */
 package com.gmcc.pboss.web.channel.bchcontlog;

import com.gmcc.pboss.business.channel.bchcontlog.BchcontlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.bchcontlog.BchcontlogDBParam;
import com.gmcc.pboss.control.channel.bchcontlog.Bchcontlog ;

/**
 * <p>Title: BchcontlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class BchcontlogAction extends BaseAction{
	
	public BchcontlogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new BchcontlogForm());
		this.setParam(new BchcontlogWebParam());

        //ָ��VO��
        setClsVO(BchcontlogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Bchcontlog.class);
		this.setClsQueryParam(BchcontlogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}