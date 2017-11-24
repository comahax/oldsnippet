/**
 * auto-generated code
 * Tue Oct 25 16:42:25 CST 2011
 */
package com.gmcc.pboss.web.sales.salesstd;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.sales.salesstd.SalesstdVO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.sales.salesstd.SalesstdDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.base.operator.Operator;
import com.gmcc.pboss.control.base.operator.OperatorBO;
import com.gmcc.pboss.control.sales.salesstd.Salesstd;
import com.gmcc.pboss.control.sales.salesstd.SalesstdBO;
import com.gmcc.pboss.web.base.dictitem.DictitemWebParam;

/**
 * <p>
 * Title: SalesstdAction
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
public class SalesstdAction extends BaseAction {

	public SalesstdAction() {
		super();

		// 以下几个方法是必须的
		this.setForm(new SalesstdForm());
		this.setParam(new SalesstdDBParam());

		// 指定VO类
		setClsVO(SalesstdVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "recid" };
		this.setClsControl(Salesstd.class);
		this.setClsQueryParam(SalesstdDBParam.class);

	}

	@Override
	public String doSave() throws Exception {

		SalesstdForm salesstdform = (SalesstdForm) this.getForm();
		salesstdform.setCityid(this.getDBAccessUser().getCityid());

		// 添加之前查询是否有重复项
		// 唯一约束检查，根据地市标识（默认当前操作员归属地市）、分公司、微区域、星级、套卡品牌对合作商销量阀值表（FX_RU_SALESSTD）进行查询，
		// 如果已经存在数据，则提示“相同记录已经存在，请检查。”并返回。
		SalesstdDBParam salesstddbparam = (SalesstdDBParam) this.getParam();
		salesstddbparam.set_se_cityid(salesstdform.getCityid());
		salesstddbparam.set_se_countyid(salesstdform.getCountyid());
		salesstddbparam.set_se_mareacode(salesstdform.getMareacode());
		salesstddbparam.set_ne_starlevel(salesstdform.getStarlevel().toString()); 

		SalesstdBO salesstdbo = (SalesstdBO) BOFactory.build(SalesstdBO.class,
				this.getDBAccessUser());
		DataPackage dp = salesstdbo.doQuery(salesstddbparam);
		if (this.CMD.equals("EDIT")) {
			if (dp.getDatas() != null && dp.getDatas().size() > 0) {
				SalesstdVO salesstdvo=(SalesstdVO)dp.getDatas().get(0);
				if(!salesstdvo.getRecid().equals(salesstdform.getRecid())){
					this.addActionError("相同记录已经存在，请检查");
					return "content";
				}				
			}
		} else {
			if (dp.getDatas() != null && dp.getDatas().size() > 0) {
				this.addActionError("相同记录已经存在，请检查");
				return "content";
			}
		}
		return super.doSave();
	}

	@Override
	public String doEdit() throws Exception {
		// TODO Auto-generated method stub
		((SalesstdDBParam) this.getParam()).set_se_cityid(this.getDBAccessUser()
				.getCityid());
		return super.doEdit();
	}

	@Override
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		((SalesstdDBParam) this.getParam()).set_se_cityid(this.getDBAccessUser()
				.getCityid());
		return super.doList();
	}

	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("合作商销量阀值");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
		export.addOutputProperty("recid", "编码");
		export.addOutputProperty("countyid", "分公司", export.CODE2NAME,
				"#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "微区域", export.CODE2NAME,
				"#MICROAREA");
		export.addOutputProperty("starlevel", "星级 ", export.CODE2NAME,
				"$CH_STARLEVEL"); 
		export.addOutputProperty("salesstd", "销量阀值(套)");
		getParam().set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}

	public String doImport() {
		try {
			DictitemWebParam dictitemwebparam = new DictitemWebParam();
			dictitemwebparam.set_se_groupid("FX_SMPBRAND");
			dictitemwebparam.set_sne_dictid("AllBrand");
			DictitemBO dictitembo = (DictitemBO) BOFactory.build(
					DictitemBO.class, this.getDBAccessUser());
			ArrayList dictitemformlist = (ArrayList) (dictitembo
					.doQuery(dictitemwebparam).getDatas());
			super.getRequest().getSession().setAttribute("dictitemformlist",
					dictitemformlist);
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return "import";
	}

	public String doListQuery() {

		SalesstdDBParam salesdbparam = (SalesstdDBParam) super.getParam();
		salesdbparam.set_se_cityid(this.getDBAccessUser().getCityid());
		DataPackage dp = null;
		try {
			SalesstdBO salesstdbo = (SalesstdBO) BOFactory.build(
					SalesstdBO.class, this.getDBAccessUser());
			dp = salesstdbo.doListQuery(salesdbparam);
			salesdbparam.set_se_brand(null);
			salesdbparam.set_se_wayid(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		this.setDp(dp);

		return "listquery";
	}

	public String doExportExcel() {
		// doExportExcel

		SalesstdDBParam salesdbparam = (SalesstdDBParam) super.getParam();
		salesdbparam.set_se_cityid(this.getDBAccessUser().getCityid());
		DataPackage dp = null;
		try {
			SalesstdBO salesstdbo = (SalesstdBO) BOFactory.build(
					SalesstdBO.class, this.getDBAccessUser());
			salesdbparam.set_se_brand(null);
			salesdbparam.set_se_wayid(null);
			salesdbparam.set_pagesize("0");
			dp = salesstdbo.doExportExcel(salesdbparam);
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		this.setDp(dp);
		return "ExportExcel";
	}

}