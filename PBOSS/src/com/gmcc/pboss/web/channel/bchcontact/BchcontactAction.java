/**
 * auto-generated code
 * Wed Jul 01 17:31:09 CST 2009
 */
 package com.gmcc.pboss.web.channel.bchcontact;

import com.gmcc.pboss.business.channel.bchcontact.BchcontactVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.bchcontact.BchcontactDBParam;
import com.gmcc.pboss.control.channel.bchcontact.Bchcontact ;

/**
 * <p>Title: BchcontactAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class BchcontactAction extends BaseAction{
	
	public BchcontactAction() {
		super();

		//????????¡¤?¡¤¡§??¡À?????
		this.setForm(new BchcontactForm());
		this.setParam(new BchcontactWebParam());

        //???¡§VO?¨¤
        setClsVO(BchcontactVO.class);
        //???¡§?¡Â?¨¹??¡Á¨¦?????????????¡Â?¨¹???¨°?¨¨???¡§?????????¡Â?¨¹??¡Á???????
        this.pkNameArray=new String[]{"wayid"};
		this.setClsControl(Bchcontact.class);
		this.setClsQueryParam(BchcontactDBParam.class) ;

		/**
		 * ???????¡§??????????????????BaseAction??CRUD???¨¢?¡Â?????¡§??Delegate????¡ã??¨¦??????¡À????¡§
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}