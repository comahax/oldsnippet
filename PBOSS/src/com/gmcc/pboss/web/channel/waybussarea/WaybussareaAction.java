/**
 * auto-generated code
 * Wed Jul 01 17:29:43 CST 2009
 */
 package com.gmcc.pboss.web.channel.waybussarea;

import com.gmcc.pboss.business.channel.waybussarea.WaybussareaVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.waybussarea.WaybussareaDBParam;
import com.gmcc.pboss.control.channel.waybussarea.Waybussarea ;

/**
 * <p>Title: WaybussareaAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class WaybussareaAction extends BaseAction{
	
	public WaybussareaAction() {
		super();

		//????????¡¤?¡¤¡§??¡À?????
		this.setForm(new WaybussareaForm());
		this.setParam(new WaybussareaWebParam());

        //???¡§VO?¨¤
        setClsVO(WaybussareaVO.class);
        //???¡§?¡Â?¨¹??¡Á¨¦?????????????¡Â?¨¹???¨°?¨¨???¡§?????????¡Â?¨¹??¡Á???????
        this.pkNameArray=new String[]{"wayid"};
		this.setClsControl(Waybussarea.class);
		this.setClsQueryParam(WaybussareaDBParam.class) ;

		/**
		 * ???????¡§??????????????????BaseAction??CRUD???¨¢?¡Â?????¡§??Delegate????¡ã??¨¦??????¡À????¡§
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}