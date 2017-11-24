/**
 * auto-generated code
 * Thu Sep 17 14:55:57 CST 2009
 */
package com.gmcc.pboss.control.promotion.elmtinstlog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.elmtinstlog.ElmtinstlogDBParam;
import com.gmcc.pboss.business.promotion.elmtinstlog.ElmtinstlogDAO;
import com.gmcc.pboss.business.promotion.elmtinstlog.ElmtinstlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ElmtinstlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/elmtinstlog/control/ElmtinstlogBO"
*    name="Elmtinstlog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ElmtinstlogBO extends AbstractControlBean implements
		Elmtinstlog {

	public ElmtinstlogVO doCreate(ElmtinstlogVO vo) throws Exception {
		try {
			ElmtinstlogDAO dao = (ElmtinstlogDAO) DAOFactory.build(ElmtinstlogDAO.class, user);
			// TODO set the pk */
			return (ElmtinstlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ElmtinstlogVO vo) throws Exception {
		try {
			ElmtinstlogDAO dao = (ElmtinstlogDAO) DAOFactory.build(ElmtinstlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ElmtinstlogDAO dao = (ElmtinstlogDAO) DAOFactory.build(ElmtinstlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ElmtinstlogVO doUpdate(ElmtinstlogVO vo) throws Exception {
		try {
			ElmtinstlogDAO dao = (ElmtinstlogDAO) DAOFactory.build(ElmtinstlogDAO.class,user);
			return (ElmtinstlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ElmtinstlogVO doFindByPk(Serializable pk) throws Exception {
		ElmtinstlogDAO dao = (ElmtinstlogDAO) DAOFactory.build(ElmtinstlogDAO.class,user);
		return (ElmtinstlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ElmtinstlogDBParam params)
			throws Exception {
		ElmtinstlogDAO dao = (ElmtinstlogDAO) DAOFactory.build(ElmtinstlogDAO.class,user);
		return dao.query(params);
	}
}
