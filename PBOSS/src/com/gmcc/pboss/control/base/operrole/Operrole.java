/**
 * auto-generated code
 * Fri Jul 10 14:35:20 CST 2009
 */
package com.gmcc.pboss.control.base.operrole;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.base.operator.OperatorVO;
import com.gmcc.pboss.business.base.operrole.OperroleDBParam;
import com.gmcc.pboss.business.base.operrole.OperroleVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: Operrole </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Lee
 * @version 1.0
 */
public interface Operrole extends AbstractControl {
    public OperroleVO doCreate(OperroleVO vo) throws Exception;

    public void doRemoveByVO(OperroleVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OperroleVO doUpdate(OperroleVO vo) throws Exception;

    public OperroleVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OperroleDBParam params,User user) throws Exception;
    
    public DataPackage doQuery(OperroleDBParam params) throws Exception;
    /**
	 * �жϽ�ɫ���Ƿ���ڲ���Ա
	 * @param roleids
	 * @param operid
	 * @return
	 * @throws Exception
	 */
	public boolean doIsRoleInOperator(String roleids,String operid)throws Exception;
	
	public void doBatchSave(List roleList, List operList) throws Exception;
	
	/**
	 * ���ݽ�ɫID��ȡ���ڸý�ɫ�Ĳ���Ա(Operator)
	 * @param roleid
	 * @return
	 * @throws Exception
	 */
	public List<OperatorVO> getOperatorsByRoleId(String roleid) throws Exception;

}
