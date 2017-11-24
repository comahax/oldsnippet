/**
 * auto-generated code
 * Fri Oct 23 15:23:36 CST 2009
 */
package com.gmcc.pboss.web.sales.noactinfo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.sales.noactinfo.NoactinfoVO;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.sales.noactinfo.NoactinfoDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.sales.noactinfo.Noactinfo;

/**
 * <p>
 * Title: NoactinfoAction
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
public class NoactinfoAction extends BaseAction {

	public NoactinfoAction() {
		super();

		// 以下几个方法是必须的
		this.setForm(new NoactinfoForm());
		this.setParam(new NoactinfoWebParam());

		// 指定VO类
		setClsVO(NoactinfoVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "recid" };
		this.setClsControl(Noactinfo.class);
		this.setClsQueryParam(NoactinfoDBParam.class);

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("套卡激活数据查询");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
		export.addOutputProperty("recid", "编号");
		export.addOutputProperty("mobileno", "号码");
		export.addOutputProperty("activedate", "激活日期", CommonExportBean.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("creattime", "录入时间", CommonExportBean.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("memo", "备注");
		getParam().set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
}