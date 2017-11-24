package com.gmcc.pboss.member.dao.impl;

import java.util.Date;

import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.member.dao.EmployeeApplyDao;
import com.gmcc.pboss.model.auditWork.ChPwAuditwork;
import com.gmcc.pboss.model.employee.ChPwEmployeeapply;

/**
 * ���˹�˾Ӫ���з���
 * @author yuwenjun
 * @date 2009-10-12
 * ������Ŀ��Pboss
 * ����ģ�飺��Ա����
 * ������DAOʵ������
 */
public class EmployeeApplyDaoHibernate extends BaseDaoHibernate implements EmployeeApplyDao{

	public EmployeeApplyDaoHibernate() {
		super(ChPwEmployeeapply.class);
		// TODO Auto-generated constructor stub
	}

	public boolean saveApply(ChPwEmployeeapply saveObj) {
		// TODO Auto-generated method stub
		saveObj.setAuditstatus(ConstantsType.AUDITSTATUS_NO);//���״��AUDITSTATUS��̬Ϊ0
		saveObj.setOptime(new Date());
		this.save(saveObj);
		//����ģʽ
		//��������CH_PW_AUDITWORK
		ChPwAuditwork auditWork = new ChPwAuditwork();
		auditWork.setWorktype(ConstantsType.AUDITWORKTYPE_EMPLOYEEADD);
		auditWork.setApplyno(saveObj.getApplyno());
		auditWork.setStepid(ConstantsType.AUDITSTEPID_EMPLOYEEADD1);
		auditWork.setCreatetime(saveObj.getOptime());
		auditWork.setAuditstatus(ConstantsType.AUDITSTATUS_NO);
		this.save(auditWork);
		return true;
	}

	public boolean saveQuit(ChPwEmployeeapply saveObj) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		saveObj.setAuditstatus(ConstantsType.AUDITSTATUS_NO);//���״��AUDITSTATUS��̬Ϊ0
		saveObj.setOptime(new Date());
		this.save(saveObj);
		//����ģʽ
		//��������CH_PW_AUDITWORK
		ChPwAuditwork auditWork = new ChPwAuditwork();
		auditWork.setWorktype(ConstantsType.AUDITWORKTYPE_EMPLOYEEREMOVE);
		auditWork.setApplyno(saveObj.getApplyno());
		auditWork.setStepid(ConstantsType.AUDITSTEPID_EMPLOYEEREMOVE1);
		auditWork.setCreatetime(saveObj.getOptime());
		auditWork.setAuditstatus(ConstantsType.AUDITSTATUS_NO);
		this.save(auditWork);
		return true;
	}

}
