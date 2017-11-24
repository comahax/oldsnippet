/**
 * auto-generated code
 * Mon Sep 14 14:23:48 CST 2009
 */
package com.gmcc.pboss.control.promotion.elmttmpllog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.elmttmpllog.ElmttmpllogDBParam;
import com.gmcc.pboss.business.promotion.elmttmpllog.ElmttmpllogDAO;
import com.gmcc.pboss.business.promotion.elmttmpllog.ElmttmpllogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ElmttmpllogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author linli
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/elmttmpllog/control/ElmttmpllogBO"
*    name="Elmttmpllog"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ElmttmpllogBO extends AbstractControlBean implements
		Elmttmpllog {

	public ElmttmpllogVO doCreate(ElmttmpllogVO vo) throws Exception {
		try {
			ElmttmpllogDAO dao = (ElmttmpllogDAO) DAOFactory.build(ElmttmpllogDAO.class, user);
			// TODO set the pk */
			return (ElmttmpllogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ElmttmpllogVO vo) throws Exception {
		try {
			ElmttmpllogDAO dao = (ElmttmpllogDAO) DAOFactory.build(ElmttmpllogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ElmttmpllogDAO dao = (ElmttmpllogDAO) DAOFactory.build(ElmttmpllogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ElmttmpllogVO doUpdate(ElmttmpllogVO vo) throws Exception {
		try {
			ElmttmpllogDAO dao = (ElmttmpllogDAO) DAOFactory.build(ElmttmpllogDAO.class,user);
			return (ElmttmpllogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ElmttmpllogVO doFindByPk(Serializable pk) throws Exception {
		ElmttmpllogDAO dao = (ElmttmpllogDAO) DAOFactory.build(ElmttmpllogDAO.class,user);
		return (ElmttmpllogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ElmttmpllogDBParam params)
			throws Exception {
		ElmttmpllogDAO dao = (ElmttmpllogDAO) DAOFactory.build(ElmttmpllogDAO.class,user);
		return dao.query(params);
	}
}
