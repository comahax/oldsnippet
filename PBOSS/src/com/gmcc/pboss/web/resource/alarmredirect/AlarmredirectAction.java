package com.gmcc.pboss.web.resource.alarmredirect;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.resource.resalarmrule.ResalarmruleDBParam;
import com.gmcc.pboss.business.resource.resalarmrule.ResalarmruleVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.resource.resalarmrule.Resalarmrule;
import com.gmcc.pboss.web.resource.resalarmrule.ResalarmruleForm;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>
 * Title: ResalarmruleAction
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
 * @author LiZhaoLiang
 * @version 1.0
 */
public class AlarmredirectAction extends BaseAction {
	public AlarmredirectAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new ResalarmruleForm());
		this.setParam(new ResalarmruleDBParam());

		// ָ��VO��
		setClsVO(ResalarmruleVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "recid" };
		this.setClsControl(Resalarmrule.class);
		this.setClsQueryParam(ResalarmruleDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	/**
	 * ��ѯϵͳ������, ʵ����ת
	 */
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					getDBAccessUser());
			Serializable pkVO = new SysparamVO();
			BeanUtils.setProperty(pkVO, "systemid", "55");// ϵͳ��ʶ=53
			BeanUtils.setProperty(pkVO, "paramtype", "pboss_fx");// ��������==pboss_fx
			SysparamVO vo = sysparam.doFindByPk(pkVO);
			if (vo != null && !StringUtils.isEmpty(vo.getParamvalue())) {
				String paramvalue = vo.getParamvalue();
				request.setAttribute("paramvalue", paramvalue);
			}
		} catch (Exception ex) {
			setActionMessage(ex.getMessage());
		}
		return "redirect";
	}

}