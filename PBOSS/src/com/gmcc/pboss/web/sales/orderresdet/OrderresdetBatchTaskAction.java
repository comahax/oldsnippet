package com.gmcc.pboss.web.sales.orderresdet;


import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.common.batch.processfile.BatchTaskAction;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class OrderresdetBatchTaskAction extends BatchTaskAction {


	/**
	 * 启动bean运行
	 */
	protected String doProcess() throws Exception {
		User user = (User) ServletActionContext.getRequest().getSession()
		.getAttribute("USER");
		Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
		Serializable pkVO=new SysparamVO();
		BeanUtils.setProperty(pkVO, "systemid", "27");//系统标识
		BeanUtils.setProperty(pkVO, "paramtype", "pboss_fx");//参数类型
		SysparamVO vo=(SysparamVO) sysparamBO.doFindByPk(pkVO);
		try {
			if(vo==null){
				throw new Exception("资源批量抽取状态参数未设置");
			}
			if("1".equals(vo.getParamvalue())){
				throw new Exception("|资源批量抽取操作正在进行中，不允许多个操作同时进行|");
			}
			//订购资源是否管理配送商
			String sysparamvalue21=sysparamBO.doFindByID("21", "pboss_fx");
			if(StringUtils.isEmpty(sysparamvalue21)){
				throw new Exception("订购资源是否关联配送商参数未设置");
			}
			//载入套卡品牌包大小
			String sysparamvalue5=sysparamBO.doFindByID("5", "pboss_fx");
			if(StringUtils.isEmpty(sysparamvalue5)){
				throw new Exception("套卡品牌包大小参数未设置");
			}
			vo.setParamvalue("1");
			sysparamBO.doUpdate(vo);
			
			return super.doProcess();
		} catch (Exception ex) {
			if(vo!=null && !"0".equals(vo.getParamvalue())){
				vo.setParamvalue("0");
				sysparamBO.doUpdate(vo);
			}
			addActionError(ex.getMessage());
			ex.printStackTrace();
			return ERROR;
		}
	}
}
