/**
 * auto-generated code
 * Wed Jul 08 10:58:48 CST 2009
 */
 package com.gmcc.pboss.web.channel.servcent;

import com.gmcc.pboss.business.channel.servcent.ServcentVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.servcent.ServcentDBParam;
import com.gmcc.pboss.control.channel.servcent.Servcent ;

/**
 * <p>Title: ServcentAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class ServcentAction extends BaseAction{
	
	public ServcentAction() {
		super();

		//????????��?����??��?????
		this.setForm(new ServcentForm());
		this.setParam(new ServcentWebParam());

        //???��VO?��
        setClsVO(ServcentVO.class);
        //???��?��?��??����?????????????��?��???��?��???��?????????��?��??��???????
        this.pkNameArray=new String[]{"svccode"};
		this.setClsControl(Servcent.class);
		this.setClsQueryParam(ServcentDBParam.class) ;

		/**
		 * ???????��??????????????????BaseAction??CRUD???��?��?????��??Delegate????��??��??????��????��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}