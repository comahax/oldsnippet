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

		//????????¡¤?¡¤¡§??¡À?????
		this.setForm(new AreacenterForm());
		this.setParam(new AreacenterWebParam());

        //???¡§VO?¨¤
        setClsVO(AreacenterVO.class);
        //???¡§?¡Â?¨¹??¡Á¨¦?????????????¡Â?¨¹???¨°?¨¨???¡§?????????¡Â?¨¹??¡Á???????
        this.pkNameArray=new String[]{"centerid"};
		this.setClsControl(Areacenter.class);
		this.setClsQueryParam(AreacenterDBParam.class) ;

		/**
		 * ???????¡§??????????????????BaseAction??CRUD???¨¢?¡Â?????¡§??Delegate????¡ã??¨¦??????¡À????¡§
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}