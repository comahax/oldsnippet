package com.gmcc.pboss.member.support;

import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.model.employee.ChPwEmployeeapply;

/**
 * ���˹�˾Ӫ���з���
 * @author yuwenjun
 * @date 2009-10-12
 * ������Ŀ��Pboss
 * ����ģ�飺��Ա�����������
 * ������
 */
public class EmployeeApplyParameter extends QueryParameter {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1829747877277450008L;
	/**
	 * �������
	 */
	private ChPwEmployeeapply apply;
	/**
	 * ���붯��
	 */
	private String doAction;
	/**
	 * @return the apply
	 */
	public ChPwEmployeeapply getApply() {
		return apply;
	}
	/**
	 * @param apply the apply to set
	 */
	public void setApply(ChPwEmployeeapply apply) {
		this.apply = apply;
	}
	/**
	 * @return the doAction
	 */
	public String getDoAction() {
		return doAction;
	}
	/**
	 * @param doAction the doAction to set
	 */
	public void setDoAction(String doAction) {
		this.doAction = doAction;
	}
	
}
