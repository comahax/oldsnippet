/**
 * auto-generated code
 * Thu Dec 09 16:37:06 CST 2010
 */
package com.gmcc.pboss.control.base.webfunctionitemlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.webfunctionitemlog.WebfunctionitemlogDBParam;
import com.gmcc.pboss.business.base.webfunctionitemlog.WebfunctionitemlogDAO;
import com.gmcc.pboss.business.base.webfunctionitemlog.WebfunctionitemlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: WebfunctionitemlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class WebfunctionitemlogBO extends AbstractControlBean implements
		Webfunctionitemlog {

	public WebfunctionitemlogVO doCreate(WebfunctionitemlogVO vo) throws Exception {
		try {
			WebfunctionitemlogDAO dao = (WebfunctionitemlogDAO) DAOFactory.build(WebfunctionitemlogDAO.class, user);
			// TODO set the pk */
			return (WebfunctionitemlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WebfunctionitemlogVO vo) throws Exception {
		try {
			WebfunctionitemlogDAO dao = (WebfunctionitemlogDAO) DAOFactory.build(WebfunctionitemlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WebfunctionitemlogDAO dao = (WebfunctionitemlogDAO) DAOFactory.build(WebfunctionitemlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WebfunctionitemlogVO doUpdate(WebfunctionitemlogVO vo) throws Exception {
		try {
			WebfunctionitemlogDAO dao = (WebfunctionitemlogDAO) DAOFactory.build(WebfunctionitemlogDAO.class,user);
			return (WebfunctionitemlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WebfunctionitemlogVO doFindByPk(Serializable pk) throws Exception {
		WebfunctionitemlogDAO dao = (WebfunctionitemlogDAO) DAOFactory.build(WebfunctionitemlogDAO.class,user);
		return (WebfunctionitemlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WebfunctionitemlogDBParam params)
			throws Exception {
		WebfunctionitemlogDAO dao = (WebfunctionitemlogDAO) DAOFactory.build(WebfunctionitemlogDAO.class,user);
		return dao.query(params);
	}
}
