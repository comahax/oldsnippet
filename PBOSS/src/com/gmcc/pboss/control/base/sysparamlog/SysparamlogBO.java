/**
 * auto-generated code
 * Mon Sep 07 10:58:56 CST 2009
 */
package com.gmcc.pboss.control.base.sysparamlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.sysparamlog.SysparamlogDBParam;
import com.gmcc.pboss.business.base.sysparamlog.SysparamlogDAO;
import com.gmcc.pboss.business.base.sysparamlog.SysparamlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: SysparamlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/base/sysparamlog/control/SysparamlogBO"
*    name="Sysparamlog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class SysparamlogBO extends AbstractControlBean implements
		Sysparamlog {

	public SysparamlogVO doCreate(SysparamlogVO vo) throws Exception {
		try {
			SysparamlogDAO dao = (SysparamlogDAO) DAOFactory.build(SysparamlogDAO.class, user);
			// TODO set the pk */
			return (SysparamlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SysparamlogVO vo) throws Exception {
		try {
			SysparamlogDAO dao = (SysparamlogDAO) DAOFactory.build(SysparamlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SysparamlogDAO dao = (SysparamlogDAO) DAOFactory.build(SysparamlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SysparamlogVO doUpdate(SysparamlogVO vo) throws Exception {
		try {
			SysparamlogDAO dao = (SysparamlogDAO) DAOFactory.build(SysparamlogDAO.class,user);
			return (SysparamlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SysparamlogVO doFindByPk(Serializable pk) throws Exception {
		SysparamlogDAO dao = (SysparamlogDAO) DAOFactory.build(SysparamlogDAO.class,user);
		return (SysparamlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SysparamlogDBParam params)
			throws Exception {
		SysparamlogDAO dao = (SysparamlogDAO) DAOFactory.build(SysparamlogDAO.class,user);
		return dao.query(params);
	}
}
