/**
 * auto-generated code
 * Wed Jul 08 11:40:54 CST 2009
 */
 package com.gmcc.pboss.web.channel.svwaycnstr;

import com.gmcc.pboss.business.channel.svwaycnstr.SvwaycnstrVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.svwaycnstr.SvwaycnstrDBParam;
import com.gmcc.pboss.control.channel.svwaycnstr.Svwaycnstr ;

/**
 * <p>Title: SvwaycnstrAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class SvwaycnstrAction extends BaseAction{
	
	public SvwaycnstrAction() {
		super();

		//????????¡¤?¡¤¡§??¡À?????
		this.setForm(new SvwaycnstrForm());
		this.setParam(new SvwaycnstrWebParam());

        //???¡§VO?¨¤
        setClsVO(SvwaycnstrVO.class);
        //???¡§?¡Â?¨¹??¡Á¨¦?????????????¡Â?¨¹???¨°?¨¨???¡§?????????¡Â?¨¹??¡Á???????
        this.pkNameArray=new String[]{"wayid"};
		this.setClsControl(Svwaycnstr.class);
		this.setClsQueryParam(SvwaycnstrDBParam.class) ;

		/**
		 * ???????¡§??????????????????BaseAction??CRUD???¨¢?¡Â?????¡§??Delegate????¡ã??¨¦??????¡À????¡§
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}