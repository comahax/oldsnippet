/**
 * auto-generated code
 * Wed Sep 02 17:29:19 CST 2009
 */
package com.gmcc.pboss.control.resource.numsortrulelog;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.numsortrulelog.NumsortrulelogDBParam;
import com.gmcc.pboss.business.resource.numsortrulelog.NumsortrulelogDAO;
import com.gmcc.pboss.business.resource.numsortrulelog.NumsortrulelogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: NumsortrulelogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/resource/numsortrulelog/control/NumsortrulelogBO"
*    name="Numsortrulelog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class NumsortrulelogBO extends AbstractControlBean implements
		Numsortrulelog {

	public NumsortrulelogVO doCreate(NumsortrulelogVO vo) throws Exception {
		try {
			NumsortrulelogDAO dao = (NumsortrulelogDAO) DAOFactory.build(NumsortrulelogDAO.class, user);
			// TODO set the pk */
			return (NumsortrulelogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(NumsortrulelogVO vo) throws Exception {
		try {
			NumsortrulelogDAO dao = (NumsortrulelogDAO) DAOFactory.build(NumsortrulelogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			NumsortrulelogDAO dao = (NumsortrulelogDAO) DAOFactory.build(NumsortrulelogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public NumsortrulelogVO doUpdate(NumsortrulelogVO vo) throws Exception {
		try {
			NumsortrulelogDAO dao = (NumsortrulelogDAO) DAOFactory.build(NumsortrulelogDAO.class,user);
			return (NumsortrulelogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public NumsortrulelogVO doFindByPk(Serializable pk) throws Exception {
		NumsortrulelogDAO dao = (NumsortrulelogDAO) DAOFactory.build(NumsortrulelogDAO.class,user);
		return (NumsortrulelogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(NumsortrulelogDBParam params)
			throws Exception {
		NumsortrulelogDAO dao = (NumsortrulelogDAO) DAOFactory.build(NumsortrulelogDAO.class,user);
		return dao.query(params);
	}
}
