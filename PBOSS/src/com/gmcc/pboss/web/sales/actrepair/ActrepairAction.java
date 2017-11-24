/**
 * auto-generated code
 * Fri Oct 23 15:56:45 CST 2009
 */
package com.gmcc.pboss.web.sales.actrepair;

import java.util.Date;
import java.util.Iterator;

import com.gmcc.pboss.business.sales.actrepair.ActrepairVO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.gmcc.pboss.business.sales.actrepair.ActrepairDBParam;
import com.gmcc.pboss.business.sales.noactinfo.NoactinfoVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.sales.actrepair.Actrepair;
import com.gmcc.pboss.control.sales.actrepair.ActrepairBO;
import com.gmcc.pboss.control.sales.noactinfo.Noactinfo;
import com.gmcc.pboss.control.sales.noactinfo.NoactinfoBO;
import com.gmcc.pboss.web.sales.noactinfo.NoactinfoWebParam;

/**
 * <p>
 * Title: ActrepairAction
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
public class ActrepairAction extends BaseAction {

	public ActrepairAction() {
		super();

		// 以下几个方法是必须的
		this.setForm(new ActrepairForm());
		this.setParam(new ActrepairWebParam());

		// 指定VO类
		setClsVO(ActrepairVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "recid" };
		this.setClsControl(Actrepair.class);
		this.setClsQueryParam(ActrepairDBParam.class);

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	public String doSave() throws Exception {
		// 根据号码查询号码激活记录表（FX_SN_NOACTINFO），如果无记录则新增数据，激活日期取界面录入数据，录入时间为当前时间，备注为前台补录；
		// 如果有记录，首先查询系统参数表获取“激活时间波动范围”，无数据时默认为3，然后根据查询结果区别处理：
		// 一条记录：将号码的激活时间与查询结果的激活时间进行对比，如果激活时间的差距在波动范围内，则提示“该号码的激活记录已经存在，请检查。”并返回；否则新增数据，激活日期取界面录入数据，录入时间为当前时间，备注为前台补录；
		// 大于一条记录：将号码的激活时间与查询结果的激活时间逐个对比，如果激活时间的差距在波动范围内，则提示“该号码的激活记录已经存在，请检查。”并返回，否则继续下一条。如果与所有结果数据的差距都大于波动范围，则新增数据，激活日期取界面录入数据，录入时间为当前时间，备注为前台补录。
		// 新增记录到号码激活补录表(FX_SN_ACTREPAIR)，编号取序列（FX_SN_ACTREPAIR_SEQ），补录时间取当前时间，补录工号取当前操作员工号，其他字段取值对应界面录入的数据。

		
		ActrepairForm actrepairForm = (ActrepairForm) this.getForm();
		actrepairForm.setRepairtime(new Date(System.currentTimeMillis()));
		actrepairForm.setOprcode(this.getDBAccessUser().getOprcode());
		String mobileno = actrepairForm.getMobileno();
		
		NoactinfoWebParam noactinfoWebParam = new NoactinfoWebParam();	
		noactinfoWebParam.set_se_mobileno(mobileno);
		Actrepair actrepair = (Actrepair) BOFactory.build(ActrepairBO.class,
				getDBAccessUser());		
		Noactinfo noactinfo = (Noactinfo) BOFactory.build(NoactinfoBO.class,
				getDBAccessUser());
		
		DataPackage dp = noactinfo.doQuery(noactinfoWebParam);
		NoactinfoVO noactinfoVO = new NoactinfoVO();//保存号码激活表信息
		noactinfoVO.setActivedate(actrepairForm.getActivedate());
		noactinfoVO.setMemo("前台补录");
		noactinfoVO.setCreattime(new Date(System.currentTimeMillis()));
		noactinfoVO.setMobileno(actrepairForm.getMobileno());
		Sysparam sys = (Sysparam) BOFactory.build(SysparamBO.class,this.getDBAccessUser());
		String day = sys.doFindByID("75", "pboss_fx");
		if (day == null || day.equals("")) {
			day = "3";
		}
		boolean bo = actrepair.doCheckDate(mobileno, noactinfoVO.getActivedate(),day);
		if (bo) {
			try{
				noactinfo.doCreate(noactinfoVO);//添加激活号码表
				return super.doSave();
			}catch(Exception e){
				this.addActionMessage(e.getMessage());
				return WEB_RESULT_CONTENT;
			}			
		} else {
			this.addActionError("该号码的激活记录已经存在，请检查。");
			return WEB_RESULT_CONTENT;
		}
		

	}

}