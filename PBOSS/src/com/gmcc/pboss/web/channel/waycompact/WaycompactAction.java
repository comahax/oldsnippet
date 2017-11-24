/**
 * auto-generated code
 * Wed Jul 01 17:30:11 CST 2009
 */
 package com.gmcc.pboss.web.channel.waycompact;

import com.gmcc.pboss.business.channel.waycompact.WaycompactVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.waycompact.WaycompactDBParam;
import com.gmcc.pboss.control.channel.waycompact.Waycompact ;

/**
 * <p>Title: WaycompactAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class WaycompactAction extends BaseAction{
	
	public WaycompactAction() {
		super();

		//????????¡¤?¡¤¡§??¡À?????
		this.setForm(new WaycompactForm());
		this.setParam(new WaycompactWebParam());

        //???¡§VO?¨¤
        setClsVO(WaycompactVO.class);
        //???¡§?¡Â?¨¹??¡Á¨¦?????????????¡Â?¨¹???¨°?¨¨???¡§?????????¡Â?¨¹??¡Á???????
        this.pkNameArray=new String[]{"wayid"};
		this.setClsControl(Waycompact.class);
		this.setClsQueryParam(WaycompactDBParam.class) ;

		/**
		 * ???????¡§??????????????????BaseAction??CRUD???¨¢?¡Â?????¡§??Delegate????¡ã??¨¦??????¡À????¡§
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}