/**
 * auto-generated code
 * Sat Sep 05 17:12:40 CST 2009
 */
package com.gmcc.pboss.control.resource.numsortrule;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.numsortrule.NumsortruleDBParam;
import com.gmcc.pboss.business.resource.numsortrule.NumsortruleDAO;
import com.gmcc.pboss.business.resource.numsortrule.NumsortruleVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: NumsortruleBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/resource/numsortrule/control/NumsortruleBO"
*    name="Numsortrule"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class NumsortruleBO extends AbstractControlBean implements
		Numsortrule {

	public NumsortruleVO doCreate(NumsortruleVO vo) throws Exception {
		try {
			NumsortruleDAO dao = (NumsortruleDAO) DAOFactory.build(NumsortruleDAO.class, user);
			// TODO set the pk */
			return (NumsortruleVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(NumsortruleVO vo) throws Exception {
		try {
			NumsortruleDAO dao = (NumsortruleDAO) DAOFactory.build(NumsortruleDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			NumsortruleDAO dao = (NumsortruleDAO) DAOFactory.build(NumsortruleDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public NumsortruleVO doUpdate(NumsortruleVO vo) throws Exception {
		try {
			NumsortruleDAO dao = (NumsortruleDAO) DAOFactory.build(NumsortruleDAO.class,user);
			return (NumsortruleVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public NumsortruleVO doFindByPk(Serializable pk) throws Exception {
		NumsortruleDAO dao = (NumsortruleDAO) DAOFactory.build(NumsortruleDAO.class,user);
		return (NumsortruleVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(NumsortruleDBParam params)
			throws Exception {
		NumsortruleDAO dao = (NumsortruleDAO) DAOFactory.build(NumsortruleDAO.class,user);
		return dao.query(params);
	}
}
