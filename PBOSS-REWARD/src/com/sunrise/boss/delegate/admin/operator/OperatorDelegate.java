/**
 * 
 */
package com.sunrise.boss.delegate.admin.operator;

import java.io.Serializable;
import java.util.List;

import com.sunrise.boss.business.admin.operator.control.OperatorControl;
import com.sunrise.boss.business.admin.operator.control.OperatorControlBean;
import com.sunrise.boss.business.admin.operator.persistent.OperatorListVO;
import com.sunrise.boss.business.admin.operator.persistent.OperatorVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: CompanyDelegate
 * </p>
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
 * @author Hanny Yeung
 * @version 1.0
 */
public class OperatorDelegate {
	private OperatorControl control;

	public OperatorDelegate() throws Exception {
		control = (OperatorControl) ControlFactory
				.build(OperatorControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public OperatorVO doCreate(OperatorVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(OperatorVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public OperatorVO doUpdate(OperatorVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public OperatorVO doFindByPk(Serializable pk, User user) throws Exception {
		return (OperatorVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(OperatorListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}

	/**
	 * 将员工ID（工号）转换成中文名字
	 * 
	 * @param id
	 *            员工ID
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public String changeIdToName(String id, User user) throws Exception {
		return control.changeIdToName(id, user);
	}

	/**
	 * 将员工ID集合转换中中文名字，并以List形式返回
	 * 
	 * @param ids
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List changeIdsToNames(String[] ids, User user) throws Exception {
		return control.changeIdsToNames(ids, user);
	}

	public boolean verifyOperator(String operCode, String wayId, User user)
			throws Exception {
		return control.verifyOperator(operCode, wayId, user);
	}

	public boolean verifyOperator(String[] operCodes, String wayId, User user)
			throws Exception {
		return control.verifyOperator(operCodes, wayId, user);
	}
	   /**
     * 根据角色标识查找操作员用户列表
     * @param roleids
     * @param params TODO
     * @return
     * @throws Exception
     */
    public DataPackage doQueryOperatorList(String roleids, OperatorListVO params,User user) throws Exception {
    	return control.doQueryOperatorList(roleids, params, user);
    }
    
    public String doQuerycountyid(String operid, User user)throws Exception{
    	return control.doQuerycountyid(operid, user);
    }
}
