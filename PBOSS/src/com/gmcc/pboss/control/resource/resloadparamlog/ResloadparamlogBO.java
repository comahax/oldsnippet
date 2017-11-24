/**
 * auto-generated code
 * Thu Sep 03 10:29:08 CST 2009
 */
package com.gmcc.pboss.control.resource.resloadparamlog;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.resloadparamlog.ResloadparamlogDBParam;
import com.gmcc.pboss.business.resource.resloadparamlog.ResloadparamlogDAO;
import com.gmcc.pboss.business.resource.resloadparamlog.ResloadparamlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ResloadparamlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/resource/resloadparamlog/control/ResloadparamlogBO"
*    name="Resloadparamlog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ResloadparamlogBO extends AbstractControlBean implements
		Resloadparamlog {

	public ResloadparamlogVO doCreate(ResloadparamlogVO vo) throws Exception {
		try {
			ResloadparamlogDAO dao = (ResloadparamlogDAO) DAOFactory.build(ResloadparamlogDAO.class, user);
			// TODO set the pk */
			return (ResloadparamlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ResloadparamlogVO vo) throws Exception {
		try {
			ResloadparamlogDAO dao = (ResloadparamlogDAO) DAOFactory.build(ResloadparamlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ResloadparamlogDAO dao = (ResloadparamlogDAO) DAOFactory.build(ResloadparamlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResloadparamlogVO doUpdate(ResloadparamlogVO vo) throws Exception {
		try {
			ResloadparamlogDAO dao = (ResloadparamlogDAO) DAOFactory.build(ResloadparamlogDAO.class,user);
			return (ResloadparamlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResloadparamlogVO doFindByPk(Serializable pk) throws Exception {
		ResloadparamlogDAO dao = (ResloadparamlogDAO) DAOFactory.build(ResloadparamlogDAO.class,user);
		return (ResloadparamlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ResloadparamlogDBParam params)
			throws Exception {
		ResloadparamlogDAO dao = (ResloadparamlogDAO) DAOFactory.build(ResloadparamlogDAO.class,user);
		return dao.query(params);
	}
}
