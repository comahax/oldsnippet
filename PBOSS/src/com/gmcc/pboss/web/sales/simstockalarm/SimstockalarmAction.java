/**
 * auto-generated code
 * Sat Mar 31 10:28:57 CST 2012
 */
package com.gmcc.pboss.web.sales.simstockalarm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;
import com.gmcc.pboss.business.sales.simstockalarm.SimstockalarmDBParam;
import com.gmcc.pboss.business.sales.simstockalarm.SimstockalarmVO;
import com.gmcc.pboss.business.sales.vsimstockalarm.VsimstockalarmDBParam;
import com.gmcc.pboss.business.sales.vsimstockalarm.VsimstockalarmVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.sales.simstockalarm.Simstockalarm;
import com.gmcc.pboss.control.sales.vsimstockalarm.Vsimstockalarm;
import com.gmcc.pboss.control.sales.vsimstockalarm.VsimstockalarmBO;
import com.gmcc.pboss.web.sales.stockalarm.AlarmUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: SimstockalarmAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class SimstockalarmAction extends BaseAction{
	
	public SimstockalarmAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new SimstockalarmForm());
		this.setParam(new SimstockalarmDBParam());

        //指定VO类
        setClsVO(SimstockalarmVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"wayid", "comcategory"};
		this.setClsControl(Simstockalarm.class);
		this.setClsQueryParam(SimstockalarmDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	// 跳转到批量导入界面
	public String doImport() throws Exception {
		return "toImport";
	}
	
	public String doList() throws Exception {
		try{
			SimstockalarmDBParam params = (SimstockalarmDBParam)super.getParam();
			VsimstockalarmDBParam vparams = new VsimstockalarmDBParam();
			BeanUtils.copyProperties(params, vparams);
			Vsimstockalarm bo = (Vsimstockalarm)BOFactory.build(VsimstockalarmBO.class, getDBAccessUser());
			DataPackage dp = bo.doQuery(vparams);
			if(dp != null && dp.getDatas() != null){
				List<SimstockalarmForm> list = new ArrayList<SimstockalarmForm>();
				for(VsimstockalarmVO vo :(List<VsimstockalarmVO>)dp.getDatas()){
					SimstockalarmForm form = new SimstockalarmForm();
					BeanUtils.copyProperties(vo, form);
						form.setExtendAlarmValue(AlarmUtils.alarmCode2Name(vo.getAlarmvalue(), super.getDBAccessUser().getCityid()));
					list.add(form);
				}
				dp.setDatas(list);
				super.setDp(dp);
			}
		}catch(Exception e){
			super.addActionError(e.getMessage());
			e.printStackTrace();
		}
		return WEB_RESULT_LIST;
	}
	
	public String doNew() throws Exception {
		super.doNew();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		return WEB_RESULT_CONTENT;
	}
	
	public String doEdit() throws Exception {
		super.doEdit();
		SimstockalarmForm form = (SimstockalarmForm) super.getForm();
		String alarmvalue = form.getAlarmvalue();
		if (null != alarmvalue) {
			String tempAlarm = alarmvalue.replaceAll(";&", "");
			String[] types = tempAlarm.split(";");
			for (String type : types) {
				String[] temp = type.trim().split(":");
				if ("REDALARM".equals(temp[0]))
					form.setRedalarm(temp[1]);
				else if ("YELALARM".equals(temp[0]))
					form.setYellowalarm(temp[1]);
			}
		}
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		return WEB_RESULT_CONTENT;
	}
	
	public String doSave() throws Exception {
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		
		SimstockalarmForm form = (SimstockalarmForm) super.getForm();
		form.setAlarmvalue("REDALARM:"+form.getRedalarm()+";YELALARM:"+form.getYellowalarm());
		
		super.doSave();
		return WEB_RESULT_CONTENT;
	}
	
	public String doExcel() throws Exception{
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			export.setFileName("空白SIM卡库存预警设置(渠道)");
			export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
			export.appendHeadLine(new String[] { "导出时间",
							format.format(new Date()) });
			export.addOutputProperty("countyid", "分公司",export.CODE2NAME, "#CNTYCOMPANY");			
			export.addOutputProperty("wayid", "合作商编码");			
			export.addOutputProperty("wayid", "合作商名称",export.CODE2NAME, "#WAY");
			export.addOutputProperty("starlevel", "渠道星级",export.CODE2NAME, "$CH_STARLEVEL");
			export.addOutputProperty("waystate", "渠道状态",export.CODE2NAME, "$CH_VALIDFLAG");
			export.addOutputProperty("comcategory", "商品种类",export.CODE2NAME, "$IM_FXCOMCATEGORY");
			export.addOutputProperty("maxstock", "最高库存(套)");
			export.addOutputProperty("extendAlarmValue", "预警阀值");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			SimstockalarmDBParam param=(SimstockalarmDBParam)super.getParam();
			//export.voClassArray = new Class[] { StockalarmForm.class };
			param.set_pagesize("0");
			super.setParam(param);
			return super.doExcel();
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}
}