/**
 * auto-generated code
 * Wed Jul 01 17:31:09 CST 2009
 */
package com.gmcc.pboss.control.channel.bchcontact;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.bchcontact.BchcontactDBParam;
import com.gmcc.pboss.business.channel.bchcontact.BchcontactDAO;
import com.gmcc.pboss.business.channel.bchcontact.BchcontactVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: BchcontactBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/channel/bchcontact/control/BchcontactBO"
*    name="Bchcontact"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class BchcontactBO extends AbstractControlBean implements
		Bchcontact {

	public BchcontactVO doCreate(BchcontactVO vo) throws Exception {
		try {
			BchcontactDAO dao = (BchcontactDAO) DAOFactory.build(BchcontactDAO.class, user);
			// TODO set the pk */
			return (BchcontactVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(BchcontactVO vo) throws Exception {
		try {
			BchcontactDAO dao = (BchcontactDAO) DAOFactory.build(BchcontactDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			BchcontactDAO dao = (BchcontactDAO) DAOFactory.build(BchcontactDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BchcontactVO doUpdate(BchcontactVO vo) throws Exception {
		try {
			BchcontactDAO dao = (BchcontactDAO) DAOFactory.build(BchcontactDAO.class,user);
			return (BchcontactVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BchcontactVO doFindByPk(Serializable pk) throws Exception {
		BchcontactDAO dao = (BchcontactDAO) DAOFactory.build(BchcontactDAO.class,user);
		return (BchcontactVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BchcontactDBParam params)
			throws Exception {
		BchcontactDAO dao = (BchcontactDAO) DAOFactory.build(BchcontactDAO.class,user);
		return dao.query(params);
	}
}
