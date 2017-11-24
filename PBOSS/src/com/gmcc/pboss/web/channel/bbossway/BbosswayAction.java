/**
 * auto-generated code
 * Tue Apr 14 16:34:03 CST 2015
 */
 package com.gmcc.pboss.web.channel.bbossway;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.channel.bbossway.BbosswayDBParam;
import com.gmcc.pboss.business.channel.bbossway.BbosswayVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.channel.bbossway.Bbossway;
import com.gmcc.pboss.control.channel.bbossway.BbosswayBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: BbosswayAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class BbosswayAction extends BaseAction{
	
	public BbosswayAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new BbosswayForm());
		this.setParam(new BbosswayDBParam());

        //指定VO类
        setClsVO(BbosswayVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"wayid"};
		this.setClsControl(Bbossway.class);
		this.setClsQueryParam(BbosswayDBParam.class) ;

	}
	
	public String doList() throws Exception {
		HttpServletRequest request = getRequest();
		User user = (User) request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		Bbossway bossway = (Bbossway) BOFactory.build(BbosswayBO.class, getDBAccessUser());
		BbosswayDBParam params = (BbosswayDBParam)getParam();
		
		params.set_se_cityid(user.getCityid());
		
		DataPackage dp = bossway.doQuery(params);
		setDp(dp);
		return "list";
	}
	
	public String doExportExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("全网渠道编码管理");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date())});
		export.addOutputProperty("wayid", "渠道编码");
		export.addOutputProperty("wayid", "渠道名称", CommonExportBean.CODE2NAME, "#WAY");
		export.addOutputProperty("bbosswayid", "全网渠道编码");
		export.addOutputProperty("cityid", "地市", CommonExportBean.CODE2NAME, "CITYNAME");
		export.addOutputProperty("createtime", "创建时间",export.DATE,"yyyy-MM-dd");
		
		// 设置VO类
		export.voClassArray = new Class[] { BbosswayVO.class };
		
		// 设置查询方法
		export.queryMethodName = "doList";
		BbosswayDBParam params = (BbosswayDBParam) getParam();
	
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
}