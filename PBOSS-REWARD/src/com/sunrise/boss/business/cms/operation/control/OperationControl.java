/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */
package com.sunrise.boss.business.cms.operation.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.operation.persistent.OperationDAO;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationListVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Title: OperationControl
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
public interface OperationControl extends AbstractControl {
	public OperationVO doCreate(OperationVO vo, User user) throws Exception;

	public void doRemove(OperationVO vo, User user) throws Exception;

	public OperationVO doUpdate(OperationVO vo, User user) throws Exception;

	public OperationVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(OperationListVO params, User user)
			throws Exception;

	public DataPackage doQuerysubtype(String id, User user) throws Exception;

	public int getParentlevel(OperationVO vo, User user) throws Exception;
	
	public OperationVO doUpdatetree(OperationVO vo, User user) throws Exception;
	
	public void doRemovetree(OperationVO vo, User user) throws Exception;
	
	public String formatString(OperationVO vo, User user) throws Exception;
	
	public DataPackage doQueryopnbyisbusi(String rootid, User user) throws Exception;
	
	public List doQuerybusiload(User user) throws Exception;
	
	public List doQueryupper(OperationListVO params,User user) throws Exception;
	
	public OperationVO doCreateload(String []exesys , String []region,String []starlevel,OperationVO vo, User user) throws Exception;


	public OperationVO doUpdateload(ArrayList  dellist,ArrayList  addlist,OperationVO vo, User user) throws Exception;

	public DataPackage doQueryOperation(OperationListVO operationListVO,User user) throws Exception;
	
	public DataPackage doQueryallsubopn(String id, User user) throws Exception ;
	
	public DataPackage doQueryallsubopn1(OperationListVO list, User user) throws Exception ;
		
	public DataPackage doQueryallfifthopnids(OperationListVO list, User user) throws Exception ;
}
