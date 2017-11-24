/**
 * 
 */
package com.sunrise.boss.business.admin.operator.control;

import java.io.Serializable;
import java.util.List;

import com.sunrise.boss.business.admin.operator.persistent.OperatorListVO;
import com.sunrise.boss.business.admin.operator.persistent.OperatorVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: GDIBOSS
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Hanny Yeung
 * @version 1.0
 */
public interface OperatorControl extends AbstractControl {
	public OperatorVO doCreate(OperatorVO vo, User user) throws Exception;

	public void doRemove(OperatorVO vo, User user) throws Exception;

	public OperatorVO doUpdate(OperatorVO vo, User user) throws Exception;

	public OperatorVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(OperatorListVO params, User user)
			throws Exception;

	public String changeIdToName(String id, User user) throws Exception;

	public List changeIdsToNames(String[] ids, User user) throws Exception;

	public boolean verifyOperator(String operCode, String wayId, User user)
			throws Exception;

	public boolean verifyOperator(String[] operCodes, String wayId, User user)
			throws Exception;
	  /**
     * 根据角色标识查找操作员用户列表
     * @param roleids
     * @param params TODO
     * @return
     * @throws Exception
     */
    public DataPackage doQueryOperatorList(String roleids, OperatorListVO params,User user) throws Exception;
    
    public String doQuerycountyid(String operid, User user)throws Exception;

}
