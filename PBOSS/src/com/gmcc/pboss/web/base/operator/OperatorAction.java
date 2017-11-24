/**
 * auto-generated code
 * Thu Jul 09 10:43:47 CST 2009
 */
 package com.gmcc.pboss.web.base.operator;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.base.operator.OperatorDBParam;
import com.gmcc.pboss.business.base.operator.OperatorVO;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.control.base.operator.Operator;
import com.gmcc.pboss.control.base.operator.OperatorBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: OperatorAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class OperatorAction extends BaseAction{
	
	public OperatorAction() {
		super();

		this.setForm(new OperatorForm());
		this.setParam(new OperatorWebParam());

        setClsVO(OperatorVO.class);
        this.pkNameArray=new String[]{"operid"};
		this.setClsControl(Operator.class);
		this.setClsQueryParam(OperatorDBParam.class) ;
	}
	
	@Override
	public String doList() throws Exception {
		OperatorDBParam param = (OperatorDBParam) getParam();
		if(param.getIsCheck()){
			Operator operator = (Operator) BOFactory.build(OperatorBO.class, getDBAccessUser());
			DataPackage dp = operator.doQueryLowerOperator(param);
			setDp(dp);
			return "list";
		}
		return super.doList();
	}
	
	
	/**
	 * ��ѯ��˽�ɫ�б�
	 * @return
	 * @throws Exception
	 */
	public String auditingRoleList()throws Exception{
		OperatorDBParam param = (OperatorDBParam) getParam();
		//����ϵͳ��ʶ=3,��������==pboss����ϵͳ��������
		Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class, getDBAccessUser());
		Serializable pkVO=new SysparamVO();
		BeanUtils.setProperty(pkVO, "systemid", "53");//ϵͳ��ʶ=53
		BeanUtils.setProperty(pkVO, "paramtype", "pboss_fx");//��������==pboss_fx
		SysparamVO vo=sysparam.doFindByPk(pkVO);
		DataPackage dp = new DataPackage();
		if(vo!=null && !StringUtils.isEmpty(vo.getParamvalue())){
			String paramvalue= vo.getParamvalue();
			Operator operator = (Operator) BOFactory.build(OperatorBO.class, getDBAccessUser());
			param.set_pagesize("10");
			dp=operator.doQueryOperatorList(paramvalue, param);
			super.setDp(dp);
		}else{
			super.setActionMessage("δ�趨�����˽�ɫ");
		}
		
		return "auditRole";
	}
	/**
	 * ��ѯ������ɫ�б�
	 * @return
	 * @throws Exception
	 */
	public String auditRoleList() throws Exception {
		String lastStepid = ServletActionContext.getRequest().getParameter(
				"lastStepid") == null ? "" : (String) ServletActionContext
				.getRequest().getParameter("lastStepid");
		OperatorVO vos=(OperatorVO)super.getForm();
		if(!"".equals(lastStepid)){
		vos.setLastStepid(lastStepid);
		}
		OperatorWebParam param = (OperatorWebParam) getParam();
		// ����ϵͳ��ʶ=3,��������==pboss����ϵͳ��������
		Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
				getDBAccessUser());
		Serializable pkVO = new SysparamVO();
		BeanUtils.setProperty(pkVO, "systemid", "67");// ϵͳ��ʶ=67
		BeanUtils.setProperty(pkVO, "paramtype", "channel");// ��������==channel
		SysparamVO vo = sysparam.doFindByPk(pkVO);
		DataPackage dp = new DataPackage();
		if (vo != null && vo.getParamvalue() != null
				&& "1".equals(vo.getParamvalue())) {
			Operator operator = (Operator) BOFactory.build(OperatorBO.class,
					getDBAccessUser());
			param.set_pagesize("10");
			// ���ж���û�е�������ѡ���Ľ�ɫ
			dp = operator.doQueryWayOperatorList("djugeAudit", new OperatorWebParam());
			if (dp.getRowCount() > 0) {
				if(StringUtils.isBlank(lastStepid))
				{
					lastStepid=vos.getLastStepid();
				}
				dp = operator.doQueryWayOperatorList(lastStepid, param);
			} else if(dp.getRowCount()<=0) {
				super.addActionError("��½���Ų�����������ɫ[N-PBOSS-04],[N-PBOSS-06]");
			}
			super.setDp(dp);
		} else if ((vo != null && vo.getParamvalue() != null && "0".equals(vo
				.getParamvalue()))
				|| (vo == null)) {
			Operator operator = (Operator) BOFactory.build(OperatorBO.class,
					getDBAccessUser());
			User puser=(User)super.getDBAccessUser();
			param.set_ne_status("1");
			param.set_ne_region(puser.getHwcityid());
			param.set_pagesize("10");
			dp = operator.doQuery(param);
			super.setDp(dp);
		}
		setForm(vos);
		return "auditWayRole";
	}
	/**
	 * ֻ������ͨ����
	 * @return
	 * @throws Exception
	 */
	public String auditRoleList2() throws Exception {
		OperatorVO vos = (OperatorVO) super.getForm();
		DataPackage dp = new DataPackage();
		Operator operator = (Operator) BOFactory.build(OperatorBO.class,
				getDBAccessUser());
		User puser = (User) super.getDBAccessUser();
		OperatorWebParam param = (OperatorWebParam) getParam();
		param.set_ne_status("1");
		param.set_ne_region(puser.getHwcityid());
		param.set_pagesize("10");
		dp = operator.doQuery(param);
		super.setDp(dp);
		setForm(vos);
		return "auditWayRole";
	}
}