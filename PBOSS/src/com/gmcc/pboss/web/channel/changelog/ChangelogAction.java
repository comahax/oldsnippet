/**
 * auto-generated code
 * Wed May 18 19:21:10 CST 2011
 */
 package com.gmcc.pboss.web.channel.changelog;

import javax.servlet.http.HttpServletRequest;

import com.gmcc.pboss.business.channel.changelog.ChangelogVO ;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.channel.changelog.ChangelogDBParam;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.changelog.Changelog ;

/**
 * <p>Title: ChangelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChangelogAction extends BaseAction{
	public String param75;//是否填写退出原因判断
	
	public ChangelogAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new ChangelogForm());
		this.setParam(new ChangelogDBParam());

        //指定VO类
        setClsVO(ChangelogVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Changelog.class);
		this.setClsQueryParam(ChangelogDBParam.class) ;

	}
	public String doList () throws Exception{
		try {
			super.doList();
			HttpServletRequest request = getRequest();
			User user = (User) request.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
			//1:退出时需要填写原因 0:不用填写退出原因 空:不用填写退出原因
			param75 = sysparamBO.doFindByID("75", "channel");			
			request.getSession().setAttribute("param75",param75);//批量导入用到
	
		}catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
		}
		return WEB_RESULT_LIST;
	}
	
	
	public String getParam75() {
		return param75;
	}
	public void setParam75(String param75) {
		this.param75 = param75;
	}
	 
}