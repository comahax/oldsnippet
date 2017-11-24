/**
 * auto-generated code
 * Wed Jul 08 10:58:02 CST 2009
 */
 package com.gmcc.pboss.web.channel.cntycompany;

import com.gmcc.pboss.business.channel.cntycompany.CntycompanyVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyDBParam;
import com.gmcc.pboss.control.channel.cntycompany.Cntycompany ;

/**
 * <p>Title: CntycompanyAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class CntycompanyAction extends BaseAction{
	
	public CntycompanyAction() {
		super();

		//????????¡¤?¡¤¡§??¡À?????
		this.setForm(new CntycompanyForm());
		this.setParam(new CntycompanyWebParam());

        //???¡§VO?¨¤
        setClsVO(CntycompanyVO.class);
        //???¡§?¡Â?¨¹??¡Á¨¦?????????????¡Â?¨¹???¨°?¨¨???¡§?????????¡Â?¨¹??¡Á???????
        this.pkNameArray=new String[]{"countycompid"};
		this.setClsControl(Cntycompany.class);
		this.setClsQueryParam(CntycompanyDBParam.class) ;

		/**
		 * ???????¡§??????????????????BaseAction??CRUD???¨¢?¡Â?????¡§??Delegate????¡ã??¨¦??????¡À????¡§
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}