/**
 * auto-generated code
 * Mon Oct 19 19:01:28 CST 2009
 */
package com.gmcc.pboss.web.sales.activerate;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.sales.activerate.ActiverateVO;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.sales.activerate.ActiverateDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.sales.activerate.Activerate;

/**
 * <p>
 * Title: ActiverateAction
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
 * @author
 * @version 1.0
 */
public class ActiverateAction extends BaseAction {

	public ActiverateAction() {
		super();

		// 以下几个方法是必须的
		this.setForm(new ActiverateForm());
		this.setParam(new ActiverateWebParam());

		// 指定VO类
		setClsVO(ActiverateVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "brand", "wayid" };
		this.setClsControl(Activerate.class);
		this.setClsQueryParam(ActiverateDBParam.class);

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
		export.setFileName("套卡激活率查询");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
		export.addOutputProperty("wayid", "合作商编码");
		export.addOutputProperty("wayid", "合作商名称",CommonExportBean.CODE2NAME,"#WAY");
		export.addOutputProperty("brand", "套卡品牌",CommonExportBean.CODE2NAME,"$FX_SMPBRAND");
		export.addOutputProperty("rate", "激活率",export.RATE,"0.00");
		export.addOutputProperty("isachieve", "是否达标", export.CODE2NAME, "$IM_YESNO10");
		export.addOutputProperty("difamt", "达标差距");
		export.addOutputProperty("chgtime", "更新时间", export.DATE, "yyyy-MM-dd HH:mm:ss");
		getParam().set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
}