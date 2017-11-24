/**
 * auto-generated code
 * Wed Sep 09 09:17:44 CST 2009
 */
package com.gmcc.pboss.control.resource.simpleboss;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.simpleboss.SimplebossDBParam;
import com.gmcc.pboss.business.resource.simpleboss.SimplebossDAO;
import com.gmcc.pboss.business.resource.simpleboss.SimplebossVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: SimplebossBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author linli
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/resource/simpleboss/control/SimplebossBO"
*    name="Simpleboss"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class SimplebossBO extends AbstractControlBean implements
		Simpleboss {

	public SimplebossVO doCreate(SimplebossVO vo) throws Exception {
		try {
			SimplebossDAO dao = (SimplebossDAO) DAOFactory.build(SimplebossDAO.class, user);
			// TODO set the pk */
			return (SimplebossVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SimplebossVO vo) throws Exception {
		try {
			SimplebossDAO dao = (SimplebossDAO) DAOFactory.build(SimplebossDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SimplebossDAO dao = (SimplebossDAO) DAOFactory.build(SimplebossDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SimplebossVO doUpdate(SimplebossVO vo) throws Exception {
		try {
			SimplebossDAO dao = (SimplebossDAO) DAOFactory.build(SimplebossDAO.class,user);
			return (SimplebossVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SimplebossVO doFindByPk(Serializable pk) throws Exception {
		SimplebossDAO dao = (SimplebossDAO) DAOFactory.build(SimplebossDAO.class,user);
		return (SimplebossVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SimplebossDBParam params)
			throws Exception {
		SimplebossDAO dao = (SimplebossDAO) DAOFactory.build(SimplebossDAO.class,user);
		return dao.query(params);
	}
}
