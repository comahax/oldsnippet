/**
 * auto-generated code
 * Tue Sep 29 10:22:17 CST 2009
 */
package com.gmcc.pboss.control.communication.advgroupobj;

import java.io.Serializable;

import com.gmcc.pboss.business.communication.advgroupobj.AdvgroupobjDBParam;
import com.gmcc.pboss.business.communication.advgroupobj.AdvgroupobjDAO;
import com.gmcc.pboss.business.communication.advgroupobj.AdvgroupobjVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: AdvgroupobjBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/communication/advgroupobj/control/AdvgroupobjBO"
*    name="Advgroupobj"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class AdvgroupobjBO extends AbstractControlBean implements
		Advgroupobj {

	public AdvgroupobjVO doCreate(AdvgroupobjVO vo) throws Exception {
		try {
			AdvgroupobjDAO dao = (AdvgroupobjDAO) DAOFactory.build(AdvgroupobjDAO.class, user);
			// TODO set the pk */
			return (AdvgroupobjVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(AdvgroupobjVO vo) throws Exception {
		try {
			AdvgroupobjDAO dao = (AdvgroupobjDAO) DAOFactory.build(AdvgroupobjDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			AdvgroupobjDAO dao = (AdvgroupobjDAO) DAOFactory.build(AdvgroupobjDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AdvgroupobjVO doUpdate(AdvgroupobjVO vo) throws Exception {
		try {
			AdvgroupobjDAO dao = (AdvgroupobjDAO) DAOFactory.build(AdvgroupobjDAO.class,user);
			return (AdvgroupobjVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AdvgroupobjVO doFindByPk(Serializable pk) throws Exception {
		AdvgroupobjDAO dao = (AdvgroupobjDAO) DAOFactory.build(AdvgroupobjDAO.class,user);
		return (AdvgroupobjVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(AdvgroupobjDBParam params)
			throws Exception {
		AdvgroupobjDAO dao = (AdvgroupobjDAO) DAOFactory.build(AdvgroupobjDAO.class,user);
		return dao.query(params);
	}
}
