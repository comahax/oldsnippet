/**
 * auto-generated code
 * Thu Sep 03 15:32:51 CST 2009
 */
package com.gmcc.pboss.control.base.dictitem;

import java.io.Serializable;
import java.util.Collection;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.base.dictitem.DictitemDAO;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: DictitemBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/base/dictitem/control/DictitemBO"
*    name="Dictitem"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class DictitemBO extends AbstractControlBean implements
		Dictitem {

	public DictitemVO doCreate(DictitemVO vo) throws Exception {
		try {
			DictitemDAO dao = (DictitemDAO) DAOFactory.build(DictitemDAO.class, user);
			// TODO set the pk */
			return (DictitemVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(DictitemVO vo) throws Exception {
		try {
			DictitemDAO dao = (DictitemDAO) DAOFactory.build(DictitemDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			DictitemDAO dao = (DictitemDAO) DAOFactory.build(DictitemDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DictitemVO doUpdate(DictitemVO vo) throws Exception {
		try {
			DictitemDAO dao = (DictitemDAO) DAOFactory.build(DictitemDAO.class,user);
			return (DictitemVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DictitemVO doFindByPk(Serializable pk) throws Exception {
		DictitemDAO dao = (DictitemDAO) DAOFactory.build(DictitemDAO.class,user);
		return (DictitemVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(DictitemDBParam params)
			throws Exception {
		DictitemDAO dao = (DictitemDAO) DAOFactory.build(DictitemDAO.class,user);
		return dao.query(params);
	}
	
	 public Collection doFindAll(User user) throws Exception {
	        DictitemDAO dao = (DictitemDAO) DAOFactory.build(DictitemDAO.class, user);
	       return dao.findAll();
	 }
}
