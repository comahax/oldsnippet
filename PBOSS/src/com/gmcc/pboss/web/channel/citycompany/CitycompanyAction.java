/**
 * auto-generated code
 * Wed Jul 08 10:49:25 CST 2009
 */
 package com.gmcc.pboss.web.channel.citycompany;

import com.gmcc.pboss.business.channel.citycompany.CitycompanyVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.citycompany.CitycompanyDBParam;
import com.gmcc.pboss.control.channel.citycompany.Citycompany ;

/**
 * <p>Title: CitycompanyAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class CitycompanyAction extends BaseAction{
	
	public CitycompanyAction() {
		super();

		//????????¡¤?¡¤¡§??¡À?????
		this.setForm(new CitycompanyForm());
		this.setParam(new CitycompanyWebParam());

        //???¡§VO?¨¤
        setClsVO(CitycompanyVO.class);
        //???¡§?¡Â?¨¹??¡Á¨¦?????????????¡Â?¨¹???¨°?¨¨???¡§?????????¡Â?¨¹??¡Á???????
        this.pkNameArray=new String[]{"citycompid"};
		this.setClsControl(Citycompany.class);
		this.setClsQueryParam(CitycompanyDBParam.class) ;

		/**
		 * ???????¡§??????????????????BaseAction??CRUD???¨¢?¡Â?????¡§??Delegate????¡ã??¨¦??????¡À????¡§
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}