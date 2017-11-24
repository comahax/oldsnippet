/**
 * auto-generated code
 * Wed Jul 16 15:07:03 CST 2014
 */
package com.gmcc.pboss.web.resource.emptysimbad;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.gmcc.pboss.business.resource.emptysimbad.EmptysimbadVO ;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.resource.emptysimbad.EmptysimbadDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.resource.emptysimbad.Emptysimbad ;
import com.gmcc.pboss.control.resource.emptysimbad.EmptysimbadBO;

/**
 * <p>Title: EmptysimbadAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class EmptysimbadAction extends BaseAction{
	
	public EmptysimbadAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new EmptysimbadForm());
		this.setParam(new EmptysimbadDBParam());

        //指定VO类
        setClsVO(EmptysimbadVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"emptyno"};
		this.setClsControl(Emptysimbad.class);
		this.setClsQueryParam(EmptysimbadDBParam.class) ;

	}

	public String doSave() throws Exception {
		EmptysimbadForm form = (EmptysimbadForm) getForm();
		Emptysimbad emptysimbad = (Emptysimbad) BOFactory.build(EmptysimbadBO.class, getDBAccessUser());
		EmptysimbadDBParam params = new EmptysimbadDBParam();
		params.set_se_emptyno(form.getEmptyno());
		DataPackage dp = emptysimbad.doQueryComcategory(params);
		if (dp.getDatas() == null || dp.getDatas().size() == 0) {
			addActionError("未找到该空白SIM卡对应的商品种类，请检查。");
			return WEB_RESULT_CONTENT;
		}
		form.setComcategory(dp.getDatas().get(0).toString());
		form.setOprcode(getDBAccessUser().getOprcode());
		form.setCreatetime(new Date());
		return super.doSave();
	}
	
	public String doTxt() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("空白SIM卡坏卡录入导出");
		export.addOutputProperty("emptyno", "空白SIM卡序列号");
		export.addOutputProperty("comcategory", "商品种类", export.CODE2NAME,
				"$IM_FXCOMCATEGORY");
		export.addOutputProperty("wayid", "渠道编码");
		export.addOutputProperty("wayid", "渠道名称", export.CODE2NAME, "#WAY");
		export.addOutputProperty("createtime", "录入时间", export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("oprcode", "录入人工号");
		export.voClassArray = new Class[] { EmptysimbadVO.class };

		prepareResponse(export.getFileName());
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"空白SIM卡序列号", "商品种类", "渠道编码", "渠道名称", "录入时间", "录入人工号" });
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("空白SIM卡坏卡录入导出");
		export.addOutputProperty("emptyno", "空白SIM卡序列号");
		export.addOutputProperty("comcategory", "商品种类", export.CODE2NAME,
				"$IM_FXCOMCATEGORY");
		export.addOutputProperty("wayid", "渠道编码");
		export.addOutputProperty("wayid", "渠道名称", export.CODE2NAME, "#WAY");
		export.addOutputProperty("createtime", "录入时间", export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("oprcode", "录入人工号");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
}