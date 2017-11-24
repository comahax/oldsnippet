/**
 * auto-generated code
 * Sat Sep 05 16:17:17 CST 2009
 */
package com.gmcc.pboss.control.resource.resloadparam;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.resloadparam.ResloadparamDBParam;
import com.gmcc.pboss.business.resource.resloadparam.ResloadparamDAO;
import com.gmcc.pboss.business.resource.resloadparam.ResloadparamVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ResloadparamBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/resource/resloadparam/control/ResloadparamBO"
*    name="Resloadparam"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ResloadparamBO extends AbstractControlBean implements
		Resloadparam {

	public ResloadparamVO doCreate(ResloadparamVO vo) throws Exception {
		try {
			//ResloadparamDAO dao = (ResloadparamDAO) DAOFactory.build(ResloadparamDAO.class, "DB_BOSSCOMMON");
			ResloadparamDAO dao = (ResloadparamDAO) DAOFactory.build(ResloadparamDAO.class, user);
			// TODO set the pk */
			return (ResloadparamVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ResloadparamVO vo) throws Exception {
		try {
			//ResloadparamDAO dao = (ResloadparamDAO) DAOFactory.build(ResloadparamDAO.class,"DB_BOSSCOMMON");
			ResloadparamDAO dao = (ResloadparamDAO) DAOFactory.build(ResloadparamDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			//ResloadparamDAO dao = (ResloadparamDAO) DAOFactory.build(ResloadparamDAO.class,"DB_BOSSCOMMON");
			ResloadparamDAO dao = (ResloadparamDAO) DAOFactory.build(ResloadparamDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResloadparamVO doUpdate(ResloadparamVO vo) throws Exception {
		try {
			//ResloadparamDAO dao = (ResloadparamDAO) DAOFactory.build(ResloadparamDAO.class, "DB_BOSSCOMMON");
			ResloadparamDAO dao = (ResloadparamDAO) DAOFactory.build(ResloadparamDAO.class,user);
			return (ResloadparamVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResloadparamVO doFindByPk(Serializable pk) throws Exception {
		ResloadparamDAO dao = (ResloadparamDAO) DAOFactory.build(ResloadparamDAO.class,user);
		return (ResloadparamVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ResloadparamDBParam params)
			throws Exception {
		ResloadparamDAO dao = (ResloadparamDAO) DAOFactory.build(ResloadparamDAO.class,user);
		return dao.query(params);
	}
}
