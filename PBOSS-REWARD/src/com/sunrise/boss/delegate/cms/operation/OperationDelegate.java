/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */
package com.sunrise.boss.delegate.cms.operation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sunrise.boss.business.cms.operation.control.OperationControl;
import com.sunrise.boss.business.cms.operation.control.OperationControlBean;
import com.sunrise.boss.business.cms.operation.persistent.OperationDAO;
import com.sunrise.boss.business.cms.operation.persistent.OperationListVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: OperationDelegate
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class OperationDelegate {

	private static OperationControl control;

	public OperationDelegate() throws Exception {
		control = (OperationControl) ControlFactory
				.build(OperationControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public OperationVO doCreate(OperationVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(OperationVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public OperationVO doUpdate(OperationVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public OperationVO doFindByPk(Serializable pk, User user) throws Exception {
		return (OperationVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(OperationListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}

	public DataPackage doQuerysubtype(String id, User user) throws Exception {
		return control.doQuerysubtype(id, user);
	}

	public int getParentlevel(OperationVO vo, User user) throws Exception {
		return control.getParentlevel(vo, user);
	}

	public OperationVO doUpdatetree(OperationVO vo, User user) throws Exception {
		return control.doUpdatetree(vo, user);
	}

	public void doRemovetree(OperationVO vo, User user) throws Exception {
		control.doRemovetree(vo, user);
	}

	public String formatString(OperationVO vo, User user) throws Exception {
		return control.formatString(vo, user);
	}

	public DataPackage doQueryopnbyisbusi(String rootid, User user)
			throws Exception {
		return control.doQueryopnbyisbusi(rootid, user);
	}

	public List doQuerybusiload(User user) throws Exception {
		return control.doQuerybusiload(user);
	}

	public List doQueryupper(OperationListVO params, User user)
			throws Exception {
		return control.doQueryupper(params, user);
	}

	public OperationVO doCreateload(String[] exesys, String[] region,
			String[] starlevel, OperationVO vo, User user) throws Exception {
		return control.doCreateload(exesys, region, starlevel, vo, user);
	}

	public OperationVO doUpdateload(ArrayList dellist, ArrayList addlist,
			OperationVO vo, User user) throws Exception {
		return control.doUpdateload(dellist, addlist, vo, user);
	}

	public DataPackage doQueryOperation(OperationListVO operationListVO,User user) throws Exception {
		return control.doQueryOperation(operationListVO, user);
	}
	
	public DataPackage doQueryallsubopn(OperationListVO list, User user) throws Exception {
		
		return control.doQueryallsubopn1(list, user);
	}
	
	public DataPackage doAllfifthopnids(OperationListVO list, User user) throws Exception {
		
		return control.doQueryallfifthopnids(list, user);
	}
	
}
