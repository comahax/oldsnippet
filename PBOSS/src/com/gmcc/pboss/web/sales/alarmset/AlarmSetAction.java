package com.gmcc.pboss.web.sales.alarmset;

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
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.sales.orderuplimit.Orderuplimit;
import com.gmcc.pboss.control.sales.orderuplimit.OrderuplimitBO;
import com.gmcc.pboss.web.base.dictitem.DictitemWebParam;
import com.gmcc.pboss.web.sales.orderuplimit.OrderuplimitForm;
import com.gmcc.pboss.web.sales.orderuplimit.OrderuplimitWebParam;
import com.gmcc.pboss.web.sales.stockalarm.AlarmUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

public class AlarmSetAction extends BaseAction {

	private ArrayList dictitemformlist = null;

	public ArrayList getDictitemformlist() {
		return dictitemformlist;
	}

	public void setDictitemformlist(ArrayList dictitemformlist) {
		this.dictitemformlist = dictitemformlist;
	}

	// 跳转到批量导入界面
	public String doImport() throws Exception {
		try {
			DictitemWebParam dictitemwebparam = new DictitemWebParam();
			dictitemwebparam.set_se_groupid("FX_SMPBRAND");
			dictitemwebparam.set_sne_dictid("AllBrand");
			DictitemBO dictitembo = (DictitemBO) BOFactory.build(
					DictitemBO.class, this.getDBAccessUser());
			dictitemformlist = (ArrayList) (dictitembo
					.doQuery(dictitemwebparam).getDatas());
			super.getRequest().getSession().setAttribute("dictitemformlist",
					dictitemformlist);
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return "toImport";
	}

	public AlarmSetAction() {
		super();
		// 以下几个方法是必须的
		this.setForm(new OrderuplimitForm());
		this.setParam(new OrderuplimitWebParam());

		// 指定VO类
		setClsVO(OrderuplimitVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "recid" };
		this.setClsControl(Orderuplimit.class);
		this.setClsQueryParam(OrderuplimitDBParam.class);

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	public String doDelete() throws Exception {
		// TODO Auto-generated method stub
		super.doDelete();
		return this.doList2();
	}

	@Override
	public String doEdit() throws Exception {
		// TODO Auto-generated method stub
		try {
			super.doEdit();
			OrderuplimitForm form = (OrderuplimitForm) super.getForm();
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

		} catch (Exception e) {
			super.addActionError(e.getMessage());
		}
		return WEB_RESULT_CONTENT;
	}

	@Override
	public String doEditNew() throws Exception {
		// TODO Auto-generated method stub
		return super.doEditNew();
	}

	public String doList2() throws Exception {
		// TODO Auto-generated method stub
		try {
			OrderuplimitDBParam param = (OrderuplimitDBParam) super.getParam();
			param.set_se_limitmode("STOCKALARM");
			param.set_se_restype("COMRESSMP");
			if (null == param.get_se_cityid()) {
				param.set_se_cityid(super.getDBAccessUser().getCityid());
			}
			super.doList();
			DataPackage dp = super.getDp();
			if (dp != null && dp.getDatas() != null) {
				List<OrderuplimitForm> list = new ArrayList<OrderuplimitForm>();
				for (OrderuplimitVO vo : (List<OrderuplimitVO>) dp.getDatas()) {
					OrderuplimitForm form = new OrderuplimitForm();
					BeanUtils.copyProperties(vo, form);
					form.setExtendAlarmValue(AlarmUtils.alarmCode2Name(form
							.getAlarmvalue(), super.getDBAccessUser()
							.getCityid()));
					form.setBrand(AlarmUtils.alarmbrandinterpret(form
							.getBrand(), (User) this.getDBAccessUser()));
					list.add(form);
				}
				super.getDp().setDatas(list);
			}
		} catch (Exception e) {
			super.addActionError(e.getMessage());
		}
		return WEB_RESULT_LIST;
	}

	@Override
	public String doNew() throws Exception {
		// TODO Auto-generated method stub
		try {
			super.doNew();

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
				OrderuplimitForm orderuplimitForm = (OrderuplimitForm) this
						.getForm();
				orderuplimitForm.setSysparamflag("1");
				orderuplimitForm.setBrandlist(dp2.getDatas());
				this.setForm(orderuplimitForm);
			}

		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		return WEB_RESULT_CONTENT;
	}

	@Override
	public String doSave() throws Exception {
		// TODO Auto-generated method stub
		try {
			OrderuplimitForm form = (OrderuplimitForm) super.getForm();
			form.setRestype("COMRESSMP");
			
//			Sysparam sysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class,super.getDBAccessUser());
			SysparamVO sysparamVO = new SysparamVO();
//			sysparamVO.setParamtype("pboss_fx");
//			sysparamVO.setSystemid(new Long(73));
//			sysparamVO = sysparamBO.doFindByPk(sysparamVO);
			sysparamVO.setParamvalue(form.getSysparamflag());
			
			
			if(sysparamVO.getParamvalue().toString().equals("1")){				
				form.setBrand(AlarmUtils.brandPageToDb(form.getBrandstr()));
			}		
			
			OrderuplimitDBParam param = new OrderuplimitDBParam();
			param.set_se_cityid(form.getCityid());
			param.set_se_countyid(form.getCountyid());
			param.set_ne_starlevel("" + form.getStarlevel());
			param.set_se_brand(form.getBrand());
			param.set_se_limitmode(form.getLimitmode());
			param.set_se_restype("COMRESSMP");
			Orderuplimit bo = (OrderuplimitBO) BOFactory.build(
					OrderuplimitBO.class, super.getDBAccessUser());
			DataPackage dp = bo.doQuery(param);
			if (dp != null && dp.getDatas().size() > 0) {
				OrderuplimitVO vo = (OrderuplimitVO) dp.getDatas().get(0);
				if (!vo.getRecid().equals(form.getRecid()))
					throw new Exception("相同记录已经存在，请检查。");
			}
			form.setAlarmvalue("REDALARM:" + form.getRedalarm() + ";YELALARM:"
					+ form.getYellowalarm());
			
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
			super.doSave();
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		return WEB_RESULT_CONTENT;
	}

	@Override
	public String doView() throws Exception {
		// TODO Auto-generated method stub
		try {

			return super.doView();
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		return WEB_RESULT_CONTENT;
	}

	public String doExcel() throws Exception {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			export.setFileName("套卡库存预警设置");
			export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
			export.appendHeadLine(new String[] { "导出时间",
					format.format(new Date()) });
			export.addOutputProperty("recid", "编号");
			export.addOutputProperty("cityid", "地市公司");
			export.addOutputProperty("countyid", "分公司", export.CODE2NAME,
					"#CNTYCOMPANY");
			export.addOutputProperty("starlevel", "星级", export.CODE2NAME,
					"$CH_STARLEVEL");
			export.addOutputProperty("brand", "套卡品牌", export.CODE2NAME,
					"$FX_SMPBRAND");
			export.addOutputProperty("maxstock", "最高库存(套)");
			export.addOutputProperty("extendAlarmValue", "预警阀值");
			export.queryMethodName = ("doList2");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			OrderuplimitDBParam param = (OrderuplimitDBParam) super.getParam();
			param.set_pagesize("0");
			super.setParam(param);
			return super.doExcel();
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}

	

}
