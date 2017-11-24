/**
 * auto-generated code
 * Tue Jun 22 17:25:03 CST 2010
 */
 package com.gmcc.pboss.web.sales.stockalarm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitDBParam;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitVO;
import com.gmcc.pboss.business.sales.stockalarm.StockalarmDBParam;
import com.gmcc.pboss.business.sales.stockalarm.StockalarmVO;
import com.gmcc.pboss.business.sales.vstockalarm.VstockalarmDBParam;
import com.gmcc.pboss.business.sales.vstockalarm.VstockalarmVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.sales.orderuplimit.Orderuplimit;
import com.gmcc.pboss.control.sales.orderuplimit.OrderuplimitBO;
import com.gmcc.pboss.control.sales.stockalarm.Stockalarm;
import com.gmcc.pboss.control.sales.stockalarm.StockalarmBO;
import com.gmcc.pboss.control.sales.vstockalarm.Vstockalarm;
import com.gmcc.pboss.control.sales.vstockalarm.VstockalarmBO;
import com.gmcc.pboss.web.base.dictitem.DictitemWebParam;
import com.gmcc.pboss.web.sales.alarmset.AlarmSetAction;
import com.gmcc.pboss.web.sales.orderuplimit.OrderuplimitForm;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: StockalarmAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class StockalarmAction extends BaseAction{
	
	private ArrayList dictitemformlist=null;
	
	public ArrayList getDictitemformlist() {
		return dictitemformlist;
	}

	public void setDictitemformlist(ArrayList dictitemformlist) {
		this.dictitemformlist = dictitemformlist;
	}

	//跳转到批量导入界面
	public String doImport() throws Exception{
		try{
			DictitemWebParam dictitemwebparam = new DictitemWebParam();
			dictitemwebparam.set_se_groupid("FX_SMPBRAND");
			dictitemwebparam.set_sne_dictid("AllBrand");
			DictitemBO dictitembo = (DictitemBO)BOFactory.build(DictitemBO.class, this.getDBAccessUser());
			dictitemformlist = (ArrayList)(dictitembo.doQuery(dictitemwebparam).getDatas());
			super.getRequest().getSession().setAttribute("dictitemformlist", dictitemformlist);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return "toImport";
	}

	
	
	
	public StockalarmAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new StockalarmForm());
		this.setParam(new StockalarmDBParam());

        //指定VO类
        setClsVO(StockalarmVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"brand","wayid"};
		this.setClsControl(Stockalarm.class);
		this.setClsQueryParam(StockalarmDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	public String doEdit() throws Exception {
		// TODO Auto-generated method stub
		try{
			super.doEdit();
			StockalarmForm form = (StockalarmForm) super.getForm();
			String alarmvalue = form.getAlarmvalue();
			if( null != alarmvalue ){
				String tempAlarm = alarmvalue.replaceAll(";&", "");
				String[] types = tempAlarm.split(";");
				for(String type:types){
					String[] temp = type.trim().split(":");
					if("REDALARM".equals(temp[0]))
						form.setRedalarm(temp[1]);
					else if("YELALARM".equals(temp[0]))
						form.setYellowalarm(temp[1]);
				}				
			}
			
			Sysparam sysparamBO = (SysparamBO) BOFactory.build(
					SysparamBO.class, super.getDBAccessUser());
			SysparamVO sysparamVO = new SysparamVO();
			sysparamVO.setParamtype("pboss_fx");
			sysparamVO.setSystemid(new Long(73));
			sysparamVO = sysparamBO.doFindByPk(sysparamVO);


			String brandstr = form.getBrand();
			String brandarr[] = brandstr.split(",");

			if (sysparamVO.getParamvalue().toString().equals("1")||brandarr.length>1) {
				Dictitem dictitem = (Dictitem) BOFactory.build(
						DictitemBO.class, (User) this.getDBAccessUser());
				DictitemDBParam param2 = new DictitemDBParam();
				DataPackage dp2 = null;
				param2.set_se_groupid("FX_SMPBRAND");
				param2.set_sne_dictid("AllBrand");
				dp2 = dictitem.doQuery(param2);
			
				List datalist = dp2.getDatas();
				for (int j = 0; j < datalist.size(); j++) {
					DictitemVO dictitemvo = (DictitemVO) datalist.get(j);
					for (int i = 0; i < brandarr.length; i++) {
						if (dictitemvo.getDictid().equals(brandarr[i])) {
							dictitemvo.setDescription("checked");
							break;
						} else {
							dictitemvo.setDescription("");
						}
					}
				}

				form.setSysparamflag("1");
				form.setBrandlist(dp2.getDatas());
				this.setForm(form);
			}
			
			
		}catch(Exception e){
			super.addActionMessage(e.getMessage());
		}
		return WEB_RESULT_CONTENT;
	}

	@Override
	public String doList() throws Exception {
		try{
			StockalarmDBParam params = (StockalarmDBParam)super.getParam();
			VstockalarmDBParam vparams = new VstockalarmDBParam();
			BeanUtils.copyProperties(params, vparams);
			Vstockalarm bo = (Vstockalarm)BOFactory.build(VstockalarmBO.class, getDBAccessUser());
			DataPackage dp = bo.doQuery(vparams);
			if(dp != null && dp.getDatas() != null){
				List<StockalarmForm> list = new ArrayList<StockalarmForm>();
				for(VstockalarmVO vo :(List<VstockalarmVO>)dp.getDatas()){
					StockalarmForm form = new StockalarmForm();
					BeanUtils.copyProperties(vo, form);
					form.setExtendAlarmValue(AlarmUtils.alarmCode2Name(vo.getAlarmvalue(), super.getDBAccessUser().getCityid()));
					form.setSbrand(StockalarmAction.alarmbrandinterpret(form
							.getBrand(), (User) this.getDBAccessUser()));
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

	@Override
	public String doNew() throws Exception {
		// TODO Auto-generated method stub
		Sysparam sysparamBO = (SysparamBO) BOFactory.build(
				SysparamBO.class, super.getDBAccessUser());
		SysparamVO sysparamVO = new SysparamVO();
		sysparamVO.setParamtype("pboss_fx");
		sysparamVO.setSystemid(new Long(73));
		sysparamVO = sysparamBO.doFindByPk(sysparamVO);

		if (sysparamVO.getParamvalue().toString().equals("1")) {
			Dictitem dictitem = (Dictitem) BOFactory.build(
					DictitemBO.class, (User) this.getDBAccessUser());
			DictitemDBParam param2 = new DictitemDBParam();
			DataPackage dp2 = dictitem.doQuery(param2);
			param2.set_se_groupid("FX_SMPBRAND");
			param2.set_sne_dictid("AllBrand");
			dp2 = dictitem.doQuery(param2);
			StockalarmForm stockalarmForm = (StockalarmForm) this
					.getForm();
			stockalarmForm.setSysparamflag("1");
			stockalarmForm.setBrandlist(dp2.getDatas());
			this.setForm(stockalarmForm);
		}		
		
		return super.doNew();
	}

	@Override
	public String doSave() throws Exception {
		// TODO Auto-generated method stub
		StockalarmForm form = (StockalarmForm) super.getForm();
		form.setAlarmvalue("REDALARM:"+form.getRedalarm()+";YELALARM:"+form.getYellowalarm());
		form.setChgtime(new Date());
		
		//Sysparam sysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class,super.getDBAccessUser());
		SysparamVO sysparamVO = new SysparamVO();
		//sysparamVO.setParamtype("pboss_fx");
		//sysparamVO.setSystemid(new Long(73));
		//sysparamVO = sysparamBO.doFindByPk(sysparamVO);
		sysparamVO.setParamvalue(form.getSysparamflag());
		
		if(sysparamVO.getParamvalue().toString().equals("1")){				
			form.setBrand(this.brandPageToDb(form.getBrandstr()));
		}		
	
		String brandstr = form.getBrand();
		String brandarr [] = brandstr.split(",");
		

		if(sysparamVO.getParamvalue().toString().equals("1")){				
			Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, (User)this.getDBAccessUser());
			DictitemDBParam param2 = new DictitemDBParam();
			DataPackage dp2 = null;
			param2.set_se_groupid("FX_SMPBRAND");
			param2.set_sne_dictid("AllBrand");
			dp2 = dictitem.doQuery(param2);
			List datalist =dp2.getDatas(); 
			for(int j=0;j<datalist.size();j++){
				DictitemVO dictitemvo = (DictitemVO)datalist.get(j);
				for(int i=0;i<brandarr.length;i++){
					if(dictitemvo.getDictid().equals(brandarr[i])){
						dictitemvo.setDescription("checked");
						break;
					}else{
						dictitemvo.setDescription("");
					}						
				}					
			}
			form.setSysparamflag("1");
			form.setBrandlist(dp2.getDatas());
		
		}
		
		
		
		return super.doSave();
	}
	
	public String doExcel() throws Exception{
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			export.setFileName("套卡库存预警设置(渠道)");
			export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
			export.appendHeadLine(new String[] { "导出时间",
							format.format(new Date()) });
			export.addOutputProperty("countyid", "分公司",export.CODE2NAME, "#CNTYCOMPANY");			
			export.addOutputProperty("wayid", "合作商编码");			
			export.addOutputProperty("wayid", "合作商名称",export.CODE2NAME, "#WAY");
			export.addOutputProperty("starlevel", "渠道星级",export.CODE2NAME, "$CH_STARLEVEL");
			export.addOutputProperty("waystate", "渠道状态",export.CODE2NAME, "$CH_VALIDFLAG");
			export.addOutputProperty("brand", "套卡品牌",export.CODE2NAME,"$FX_SMPBRAND");
			export.addOutputProperty("stdvalue", "基准值");
			export.addOutputProperty("quotiety", "浮动系数");
			export.addOutputProperty("maxstock", "最高库存(套)");
			export.addOutputProperty("extendAlarmValue", "预警阀值");
			export.addOutputProperty("updatechannel", "更新途径",export.CODE2NAME,"$FX_UPDATECHANNEL");
			export.addOutputProperty("chgtime", "更新时间",export.DATE,"yyyy-MM-dd HH:mm:ss");
			export.addOutputProperty("aveactnum", "平均激活量");
			export.addOutputProperty("memo", "备注");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			StockalarmDBParam param=(StockalarmDBParam)super.getParam();
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
	
	/*
	 * 套卡库存预警设置 品牌翻译 dbtopage
	 */
	public static String alarmbrandinterpret(String brand, User user)
			throws Exception {
		Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
		DictitemDBParam param2 = new DictitemDBParam();
		DataPackage dp2 = dictitem.doQuery(param2);
		param2.set_se_groupid("FX_SMPBRAND");
		param2.set_sne_dictid("AllBrand");
		dp2 = dictitem.doQuery(param2);

		String starr[] = brand.split(",");

		StringBuffer restr = new StringBuffer();

		if (starr.length > 0) {
			for (Iterator<DictitemVO> it = dp2.getDatas().iterator(); it
					.hasNext();) {
				DictitemVO dictitemvo = it.next();
				for (int i = 0; i < starr.length; i++) {
					if (dictitemvo.getDictid().toString().equals(starr[i])) {
						if (i == starr.length - 1) {
							restr.append(dictitemvo.getDictname());
						} else {
							restr.append(dictitemvo.getDictname() + ",");
						}
					}
				}
			}
		}
		return restr.toString();
	}

	/*
	 * 套卡库存预警设置 品牌翻译 pagetodb
	 */
	public String brandPageToDb(String str[]) {

		StringBuffer strbu = new StringBuffer();

		for (int i = 0; i < str.length; i++) {
			if (i == str.length - 1) {
				strbu.append(str[i]);
			} else {
				strbu.append(str[i] + ",");
			}
		}
		return strbu.toString();
	}
}