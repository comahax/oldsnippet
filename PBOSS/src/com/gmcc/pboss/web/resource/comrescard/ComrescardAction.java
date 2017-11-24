/**
 * auto-generated code
 * Tue Sep 01 14:54:44 CST 2009
 */
 package com.gmcc.pboss.web.resource.comrescard;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.comrescard.ComrescardVO ;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.resource.comrescard.ComrescardDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.export.ExportDataCreator.PropertyFormat;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.comrescard.Comrescard ;
import com.gmcc.pboss.control.resource.comrescard.ComrescardBO;

/**
 * <p>Title: ComrescardAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ComrescardAction extends BaseAction{
	private boolean isQuery;//是否统计标识，默认不查询
	public ComrescardAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new ComrescardForm());
		this.setParam(new ComrescardWebParam());

        //指定VO类
        setClsVO(ComrescardVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"comid","comresid"};
		this.setClsControl(Comrescard.class);
		this.setClsQueryParam(ComrescardDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	@Override
	public String doList() throws Exception{
		try{
			ComrescardDBParam param = (ComrescardDBParam)this.getParam();
			param.set_orderby("comresid");
			param.set_desc("1");
			Comrescard bo = (ComrescardBO)BOFactory.build(ComrescardBO.class, this.getDBAccessUser());
			DataPackage dp = bo.doQueryBySqlName("com.gmcc.pboss.business.resource.comrescard.doList", this.getParam());
			this.setDp(dp);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return WEB_RESULT_LIST;
	}
	
	public String doTolist() throws Exception {
		try{//首次进入页面，显示登录账户所属分公司信息
			ComrescardDBParam param = (ComrescardDBParam)this.getParam();
			//if( null == param.get_se_countyid()){
				User user = (User)super.getRequest().getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
				Way wayBO = (WayBO) BOFactory.build(WayBO.class,super.getDBAccessUser());
				WayVO wayvo = wayBO.doFindByPk(user.getWayid());
				param.set_se_countyid(wayvo.getCountyid());
			//}
//			param.set_orderby("comresid");
//			param.set_desc("1");
//			//this.setParam(param);
//			Comrescard bo = (ComrescardBO)BOFactory.build(ComrescardBO.class, this.getDBAccessUser());
//			DataPackage dp = bo.doQueryBySqlName("com.gmcc.pboss.business.resource.comrescard.doList", this.getParam());
//			this.setDp(dp);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return WEB_RESULT_LIST;
	}
	
	//充值卡库存统计
	public String doStat(){
		try{
			if( this.isQuery ){
				ComrescardDBParam comrescarParam = (ComrescardDBParam)super.getParam();
				comrescarParam.setQueryAll(true);
				Comrescard bo = (ComrescardBO) BOFactory.build(ComrescardBO.class,super.getDBAccessUser());
				DataPackage dp = bo.doStat(comrescarParam);
				super.setDp(dp);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getCause() == null ? e.getMessage():e.getCause().getMessage());
		}
		return "stat";
	}
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("充值卡资源导出");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
		export.addOutputProperty("comresid", "商品资源编号");
		export.addOutputProperty("comid", "商品标识");
		export.addOutputProperty("comid", "商品名称",export.CODE2NAME, "#COM");
		export.addOutputProperty("batchno", "商品批次");
		export.addOutputProperty("comstate", "商品状态", export.CODE2NAME, "$FX_COMSTATE");
		export.addOutputProperty("wayid", "渠道标识", export.CODE2NAME, "#WAYIDINFO");
		//用于表达式计算中的字段对于，已经设为输出的字段不需要另外设置
		HashMap map = new HashMap();
		map.put("price", export.new  PropertyFormat(0,"price",null,null));
		export.hashmap=map;
		export.addOutputProperty("price/100", "商品价格(元)",export.EXPRESSION,null);
		export.addOutputProperty("comactive", "最后激活期",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("entertime", "入库时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("saletime", "销售时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
		ComrescardDBParam params = (ComrescardDBParam)super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	public String doTxt() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("充值卡资源导出");
		export.addOutputProperty("comresid", "商品资源编号");
		export.addOutputProperty("comid", "商品标识");
		export.addOutputProperty("comid", "商品名称",export.CODE2NAME, "#COM");
		export.addOutputProperty("batchno", "商品批次");
		export.addOutputProperty("comstate", "商品状态", export.CODE2NAME, "$FX_COMSTATE");
		export.addOutputProperty("wayid", "渠道标识", export.CODE2NAME, "#WAYIDINFO");
		//用于表达式计算中的字段对于，已经设为输出的字段不需要另外设置
		HashMap map = new HashMap();
		map.put("price", export.new  PropertyFormat(0,"price",null,null));
		export.hashmap=map;
		export.addOutputProperty("price/100", "商品价格(元)",export.EXPRESSION,null);
		export.addOutputProperty("comactive", "最后激活期",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("entertime", "入库时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("saletime", "销售时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
		export.voClassArray = new Class[] { ComrescardVO.class };

		prepareResponse(export.getFileName());
		ComrescardDBParam params = (ComrescardDBParam)super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"商品资源编号", "商品标识", "商品名称", "商品批次", "商品状态" ,"渠道标识","商品价格","最后激活期","入库时间","销售时间"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	public String doStatExportExcel() throws Exception{
		try{
			Comrescard bo = (ComrescardBO) BOFactory.build(ComrescardBO.class,super.getDBAccessUser());
			DataPackage dp = bo.doStat((ComrescardDBParam)super.getParam());
			super.setDp(dp);
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return "exportexcel";
	}

	public boolean getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(boolean isQuery) {
		this.isQuery = isQuery;
	}
	
}