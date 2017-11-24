/**
 * auto-generated code
 * Wed Jul 01 17:31:42 CST 2009
 */
 package com.gmcc.pboss.web.channel.netsynlog;

import com.gmcc.pboss.business.channel.netsynlog.NetsynlogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.netsynlog.NetsynlogDBParam;
import com.gmcc.pboss.control.channel.netsynlog.Netsynlog ;

/**
 * <p>Title: NetsynlogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class NetsynlogAction extends BaseAction{
	
	public NetsynlogAction() {
		super();

		//????????¡¤?¡¤¡§??¡À?????
		this.setForm(new NetsynlogForm());
		this.setParam(new NetsynlogWebParam());

        //???¡§VO?¨¤
        setClsVO(NetsynlogVO.class);
        //???¡§?¡Â?¨¹??¡Á¨¦?????????????¡Â?¨¹???¨°?¨¨???¡§?????????¡Â?¨¹??¡Á???????
        this.pkNameArray=new String[]{"itemid"};
		this.setClsControl(Netsynlog.class);
		this.setClsQueryParam(NetsynlogDBParam.class) ;

		/**
		 * ???????¡§??????????????????BaseAction??CRUD???¨¢?¡Â?????¡§??Delegate????¡ã??¨¦??????¡À????¡§
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}