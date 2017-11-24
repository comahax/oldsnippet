/**
 * auto-generated code
 * Sat Sep 05 11:44:39 CST 2009
 */
package com.gmcc.pboss.control.resource.com;

import java.io.Serializable;
import java.util.Collection;

import com.gmcc.pboss.business.resource.com.ComDAO;
import com.gmcc.pboss.business.resource.com.ComDBParam;
import com.gmcc.pboss.business.resource.com.ComVO;
import com.gmcc.pboss.business.resource.numsortrule.NumsortruleDBParam;
import com.gmcc.pboss.business.resource.numsortrule.NumsortruleVO;
import com.gmcc.pboss.business.resource.numtypedef.NumtypedefDAO;
import com.gmcc.pboss.business.resource.numtypedef.NumtypedefDBParam;
import com.gmcc.pboss.business.resource.numtypedef.NumtypedefVO;
import com.gmcc.pboss.control.resource.numsortrule.Numsortrule;
import com.gmcc.pboss.control.resource.numsortrule.NumsortruleBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ComBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/resource/com/control/ComBO"
*    name="Com"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ComBO extends AbstractControlBean implements
		Com {

	public ComVO doCreate(ComVO vo) throws Exception {
		try {
			ComDAO dao = (ComDAO) DAOFactory.build(ComDAO.class, user);
			// TODO set the pk */
			return (ComVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ComVO vo) throws Exception {
		try {
			ComDAO dao = (ComDAO) DAOFactory.build(ComDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ComDAO dao = (ComDAO) DAOFactory.build(ComDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComVO doUpdate(ComVO vo) throws Exception {
		try {
			ComDAO dao = (ComDAO) DAOFactory.build(ComDAO.class,user);
			return (ComVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComVO doFindByPk(Serializable pk) throws Exception {
		ComDAO dao = (ComDAO) DAOFactory.build(ComDAO.class,user);
		return (ComVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ComDBParam params)
			throws Exception {
		ComDAO dao = (ComDAO) DAOFactory.build(ComDAO.class,user);
		return dao.query(params);
	}
	/**
	 * 创建号码规则
	 */
	public NumsortruleVO doCreateNumsortruleVO(NumsortruleVO vo) throws Exception {
		try {
			Numsortrule bo = (Numsortrule) BOFactory.build(NumsortruleBO.class, user);
			// TODO set the pk */
			return bo.doCreate(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
	
	
}
