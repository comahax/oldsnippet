/**
 * auto-generated code
 * Wed Sep 02 17:16:59 CST 2009
 */
package com.gmcc.pboss.control.resource.numtypedeflog;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.numtypedeflog.NumtypedeflogDBParam;
import com.gmcc.pboss.business.resource.numtypedeflog.NumtypedeflogDAO;
import com.gmcc.pboss.business.resource.numtypedeflog.NumtypedeflogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: NumtypedeflogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/resource/numtypedeflog/control/NumtypedeflogBO"
*    name="Numtypedeflog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class NumtypedeflogBO extends AbstractControlBean implements
		Numtypedeflog {

	public NumtypedeflogVO doCreate(NumtypedeflogVO vo) throws Exception {
		try {
			NumtypedeflogDAO dao = (NumtypedeflogDAO) DAOFactory.build(NumtypedeflogDAO.class, user);
			// TODO set the pk */
			return (NumtypedeflogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(NumtypedeflogVO vo) throws Exception {
		try {
			NumtypedeflogDAO dao = (NumtypedeflogDAO) DAOFactory.build(NumtypedeflogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			NumtypedeflogDAO dao = (NumtypedeflogDAO) DAOFactory.build(NumtypedeflogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public NumtypedeflogVO doUpdate(NumtypedeflogVO vo) throws Exception {
		try {
			NumtypedeflogDAO dao = (NumtypedeflogDAO) DAOFactory.build(NumtypedeflogDAO.class,user);
			return (NumtypedeflogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public NumtypedeflogVO doFindByPk(Serializable pk) throws Exception {
		NumtypedeflogDAO dao = (NumtypedeflogDAO) DAOFactory.build(NumtypedeflogDAO.class,user);
		return (NumtypedeflogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(NumtypedeflogDBParam params)
			throws Exception {
		NumtypedeflogDAO dao = (NumtypedeflogDAO) DAOFactory.build(NumtypedeflogDAO.class,user);
		return dao.query(params);
	}
}
