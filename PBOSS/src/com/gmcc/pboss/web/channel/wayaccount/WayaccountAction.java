/**
 * auto-generated code
 * Wed Jul 01 17:30:39 CST 2009
 */
 package com.gmcc.pboss.web.channel.wayaccount;

import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountDBParam;
import com.gmcc.pboss.control.channel.wayaccount.Wayaccount ;

/**
 * <p>Title: WayaccountAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class WayaccountAction extends BaseAction{
	
	public WayaccountAction() {
		super();

		//????????��?����??��?????
		this.setForm(new WayaccountForm());
		this.setParam(new WayaccountWebParam());

        //???��VO?��
        setClsVO(WayaccountVO.class);
        //???��?��?��??����?????????????��?��???��?��???��?????????��?��??��???????
        this.pkNameArray=new String[]{"accid","wayid"};
		this.setClsControl(Wayaccount.class);
		this.setClsQueryParam(WayaccountDBParam.class) ;

		/**
		 * ???????��??????????????????BaseAction??CRUD???��?��?????��??Delegate????��??��??????��????��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}