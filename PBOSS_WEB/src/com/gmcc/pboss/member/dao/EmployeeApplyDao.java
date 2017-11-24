package com.gmcc.pboss.member.dao;

import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.model.employee.ChPwEmployeeapply;

/**
 * 从兴公司营帐研发部
 * @author yuwenjun
 * @date 2009-10-12
 * 所属项目：Pboss
 * 所属模块：店员管理DAO
 * 描述：
 */
public interface EmployeeApplyDao extends BaseDao {
	
	/**
	 * 处理加入申请
	 * @param saveObj - 要保存的对象
	 * @return
	 */
	public boolean saveApply(ChPwEmployeeapply saveObj);//方法命名： 用事务控制的save开头作命名
	/**
	 * 处理退出申请
	 * @param saveObj - 要保存的对象
	 * @return
	 */
	public boolean saveQuit(ChPwEmployeeapply saveObj);//方法命名： 用事务控制的save开头作命名
}
