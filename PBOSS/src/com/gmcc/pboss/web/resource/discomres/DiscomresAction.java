/**
 * auto-generated code
 * Fri Oct 02 10:44:18 CST 2009
 */
 package com.gmcc.pboss.web.resource.discomres;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.resource.discomres.DiscomresDBParam;
import com.gmcc.pboss.business.resource.discomres.DiscomresVO;
import com.gmcc.pboss.business.resource.discomres.VDiscomresVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.resource.discomres.Discomres;
import com.gmcc.pboss.control.resource.discomres.DiscomresBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: DiscomresAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class DiscomresAction extends BaseAction{
	
	public DiscomresAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new DiscomresForm());
		this.setParam(new DiscomresWebParam());

        //指定VO类
        setClsVO(DiscomresVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Discomres.class);
		this.setClsQueryParam(DiscomresDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	public String infolist() throws Exception {
		try{
			Discomres bo=(Discomres)BOFactory.build(DiscomresBO.class,super.getDBAccessUser());
			DiscomresWebParam param=(DiscomresWebParam)super.getParam();
			param.setSelectFieldsUseVOType(true);
			DataPackage dp = bo.doQueryDiscomresInfo(param);
			super.setDp(dp);
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return "infolist";
	}
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("套卡资源查询导出");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
		export.addOutputProperty("recid", "编号");
		export.addOutputProperty("disid", "分配单号");
		export.addOutputProperty("discomcode", "配送商", export.CODE2NAME, "#WAYIDINFO");
		export.addOutputProperty("batchno", "商品批次");
		export.addOutputProperty("boxnum", "包号");
		export.addOutputProperty("comid", "商品标识");
		export.addOutputProperty("comresid", "号码");
		export.addOutputProperty("comstate", "商品状态", export.CODE2NAME, "$IM_COMSTATE");
		export.addOutputProperty("issutime", "发布时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.voClassArray = new Class[] { VDiscomresVO.class };
		export.queryMethodName = "infolist";
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		DiscomresWebParam param=(DiscomresWebParam)super.getParam();
		param.set_pagesize("0");
		super.setParam(param);
		return super.doExcel();
	}
	public String doTxt() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("套卡资源查询导出");
		export.addOutputProperty("recid", "编号");
		export.addOutputProperty("disid", "分配单号");
		export.addOutputProperty("discomcode", "配送商", export.CODE2NAME, "#WAYIDINFO");
		export.addOutputProperty("batchno", "商品批次");
		export.addOutputProperty("boxnum", "包号");
		export.addOutputProperty("comid", "商品标识");
		export.addOutputProperty("comresid", "号码");
		export.addOutputProperty("comstate", "商品状态", export.CODE2NAME, "$IM_COMSTATE");
		export.addOutputProperty("issutime", "发布时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.voClassArray = new Class[] { VDiscomresVO.class };
		export.queryMethodName = "infolist";
		
		prepareResponse(export.getFileName());
		DiscomresWebParam param=(DiscomresWebParam)super.getParam();
		param.set_pagesize("0");
		super.setParam(param);
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"编号","分配单号","配送商", "商品批次", "包号", "商品标识" ,"号码","商品状态","发布时间"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
}