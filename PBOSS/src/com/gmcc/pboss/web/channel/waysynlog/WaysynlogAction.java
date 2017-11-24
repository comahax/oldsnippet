/**
 * auto-generated code
 * Wed Jul 01 17:02:51 CST 2009
 */
 package com.gmcc.pboss.web.channel.waysynlog;

import com.gmcc.pboss.business.channel.waysynlog.WaysynlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.waysynlog.WaysynlogDBParam;
import com.gmcc.pboss.control.channel.waysynlog.Waysynlog ;

/**
 * <p>Title: WaysynlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class WaysynlogAction extends BaseAction{
	
	public WaysynlogAction() {
		super();

		//????????¡¤?¡¤¡§??¡À?????
		this.setForm(new WaysynlogForm());
		this.setParam(new WaysynlogWebParam());

        //???¡§VO?¨¤
        setClsVO(WaysynlogVO.class);
        //???¡§?¡Â?¨¹??¡Á¨¦?????????????¡Â?¨¹???¨°?¨¨???¡§?????????¡Â?¨¹??¡Á???????
        this.pkNameArray=new String[]{"itemid"};
		this.setClsControl(Waysynlog.class);
		this.setClsQueryParam(WaysynlogDBParam.class) ;

		/**
		 * ???????¡§??????????????????BaseAction??CRUD???¨¢?¡Â?????¡§??Delegate????¡ã??¨¦??????¡À????¡§
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}