/**
 * auto-generated code
 * Wed Jul 08 10:21:09 CST 2009
 */
 package com.gmcc.pboss.web.channel.areacenter;

import com.gmcc.pboss.business.channel.areacenter.AreacenterVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.areacenter.AreacenterDBParam;
import com.gmcc.pboss.control.channel.areacenter.Areacenter ;

/**
 * <p>Title: AreacenterAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class AreacenterAction extends BaseAction{
	
	public AreacenterAction() {
		super();

		//????????��?����??��?????
		this.setForm(new AreacenterForm());
		this.setParam(new AreacenterWebParam());

        //???��VO?��
        setClsVO(AreacenterVO.class);
        //???��?��?��??����?????????????��?��???��?��???��?????????��?��??��???????
        this.pkNameArray=new String[]{"centerid"};
		this.setClsControl(Areacenter.class);
		this.setClsQueryParam(AreacenterDBParam.class) ;

		/**
		 * ???????��??????????????????BaseAction??CRUD???��?��?????��??Delegate????��??��??????��????��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}