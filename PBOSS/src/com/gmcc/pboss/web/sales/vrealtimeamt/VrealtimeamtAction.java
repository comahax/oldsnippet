/**
 * auto-generated code
 * Wed Sep 08 17:44:18 CST 2010
 */
 package com.gmcc.pboss.web.sales.vrealtimeamt;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.sales.vrealtimeamt.VrealtimeamtDBParam;
import com.gmcc.pboss.business.sales.vrealtimeamt.VrealtimeamtVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.sales.vrealtimeamt.Vrealtimeamt;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: VrealtimeamtAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
public class VrealtimeamtAction extends BaseAction{
	
	public VrealtimeamtAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new VrealtimeamtForm());
		this.setParam(new VrealtimeamtDBParam());

        //指定VO类
        setClsVO(VrealtimeamtVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"wayid","comcategory"};
		this.setClsControl(Vrealtimeamt.class);
		this.setClsQueryParam(VrealtimeamtDBParam.class)
		;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	/**
	 * 合作商订购量实时查询批量导出
	 * @return
	 */
	public String doExcel(){
		try{
			VrealtimeamtDBParam employeeParam = (VrealtimeamtDBParam)super.getParam();
			employeeParam.setQueryAll(true);
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			export.setFileName("合作商订购量实时查询");
			// export.addOutputProperty(0,"business","营业点",null,null);
			export.appendHeadLine(new String[] { "导出工号:",user.getOprcode() });
			export.appendHeadLine(new String[] { "导出渠道:", user.getWayid() });
			export.addOutputProperty("countyid", "分公司",export.CODE2NAME, "#CNTYCOMPANY");
			export.addOutputProperty("svccode", "服务销售中心",export.CODE2NAME, "#SERVCENT");
			export.addOutputProperty("mareacode", "微区域",export.CODE2NAME, "#MICROAREA");
			export.addOutputProperty("wayid", "合作商编码");
			export.addOutputProperty("wayid", "合作商名称",export.CODE2NAME, "#WAY");
			export.addOutputProperty("starlevel", "星级",export.CODE2NAME, "$CH_STARLEVEL");
			export.addOutputProperty("brand", "品牌",export.CODE2NAME, "$FX_SMPBRAND");
			export.addOutputProperty("comcategory", "商品种类",export.CODE2NAME, "$IM_FXCOMCATEGORY");
			export.addOutputProperty("monordered", "当月订购量",export.NUMBER,"#");
			export.addOutputProperty("dayordered", "当天订购量",export.NUMBER,"#");
			export.addOutputProperty("nowstock", "库存量",export.NUMBER,"#");
			export.addOutputProperty("orderdstock", "在订库存量",export.NUMBER,"#");
			
			
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			return super.doExcel();
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
}