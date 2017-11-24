/**
 * auto-generated code
 * Thu Jul 09 10:43:47 CST 2009
 */
package com.gmcc.pboss.control.base.operator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.business.base.operator.OperatorDAO;
import com.gmcc.pboss.business.base.operator.OperatorDBParam;
import com.gmcc.pboss.business.base.operator.OperatorVO;
import com.gmcc.pboss.business.base.operrole.OperroleDBParam;
import com.gmcc.pboss.business.base.operrole.OperroleVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OperatorBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/base/operator/control/OperatorBO"
*    name="Operator"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class OperatorBO extends AbstractControlBean implements
		Operator {

	public OperatorVO doCreate(OperatorVO vo) throws Exception {
		try {
			OperatorDAO dao = (OperatorDAO) DAOFactory.build(OperatorDAO.class, user);
			// TODO set the pk */
			return (OperatorVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OperatorVO vo) throws Exception {
		try {
			OperatorDAO dao = (OperatorDAO) DAOFactory.build(OperatorDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OperatorDAO dao = (OperatorDAO) DAOFactory.build(OperatorDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OperatorVO doUpdate(OperatorVO vo) throws Exception {
		try {
			OperatorDAO dao = (OperatorDAO) DAOFactory.build(OperatorDAO.class,user);
			return (OperatorVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OperatorVO doFindByPk(Serializable pk) throws Exception {
		OperatorDAO dao = (OperatorDAO) DAOFactory.build(OperatorDAO.class,user);
		return (OperatorVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OperatorDBParam params)
			throws Exception {
		OperatorDAO dao = (OperatorDAO) DAOFactory.build(OperatorDAO.class,user);
		return dao.query(params);
	}
	/**
     * 根据角色标识查找操作员用户列表
     * @param roleids
     * @return
     * @throws Exception
     */
    public DataPackage doQueryOperatorList(String roleids, OperatorDBParam param) throws Exception {
    	OperatorDAO dao = (OperatorDAO) DAOFactory.build(OperatorDAO.class,user);
    	String ids=roleids.replaceAll(",", "','");
    	return dao.queryOperatorList(ids, param);
    }
    
    /**
     * 根据角色标识查找网点审批可用操作员用户列表
     * @param roleids
     * @return
     * @throws Exception
     */
    public DataPackage doQueryWayOperatorList(String lastStepid, OperatorDBParam param) throws Exception {
    	OperatorDAO dao = (OperatorDAO) DAOFactory.build(OperatorDAO.class,user);
    	return dao.queryWayOperatorList(lastStepid,user,param);
    }
    /**
     * 根据渠道ID查找所有下级
     * @param roleids
     * @return
     * @throws Exception
     */
    public DataPackage doQueryLowerOperator(OperatorDBParam param) throws Exception {
    	OperatorDAO dao = (OperatorDAO) DAOFactory.build(OperatorDAO.class,user);
    	return dao.showLowerOperator(param);
    }
}
