package com.gmcc.pboss.member.support;

import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.model.employee.ChPwEmployeeapply;

/**
 * 从兴公司营帐研发部
 * @author yuwenjun
 * @date 2009-10-12
 * 所属项目：Pboss
 * 所属模块：店员管理申请参数
 * 描述：
 */
public class EmployeeApplyParameter extends QueryParameter {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1829747877277450008L;
	/**
	 * 申请对象
	 */
	private ChPwEmployeeapply apply;
	/**
	 * 申请动作
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
