/**
 * auto-generated code
 * Wed May 18 19:21:10 CST 2011
 */
package com.gmcc.pboss.control.channel.changelog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.changelog.ChangelogDBParam;
import com.gmcc.pboss.business.channel.changelog.ChangelogDAO;
import com.gmcc.pboss.business.channel.changelog.ChangelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: ChangelogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChangelogBO extends AbstractControlBean implements
		Changelog {

	public ChangelogVO doCreate(ChangelogVO vo) throws Exception {
		try {
			ChangelogDAO dao = (ChangelogDAO) DAOFactory.build(ChangelogDAO.class, user);
			// TODO set the pk */
			return (ChangelogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ChangelogVO vo) throws Exception {
		try {
			ChangelogDAO dao = (ChangelogDAO) DAOFactory.build(ChangelogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ChangelogDAO dao = (ChangelogDAO) DAOFactory.build(ChangelogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ChangelogVO doUpdate(ChangelogVO vo) throws Exception {
		try {
			ChangelogDAO dao = (ChangelogDAO) DAOFactory.build(ChangelogDAO.class,user);
			return (ChangelogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ChangelogVO doFindByPk(Serializable pk) throws Exception {
		ChangelogDAO dao = (ChangelogDAO) DAOFactory.build(ChangelogDAO.class,user);
		return (ChangelogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ChangelogDBParam params)
			throws Exception {
		ChangelogDAO dao = (ChangelogDAO) DAOFactory.build(ChangelogDAO.class,user);
		return dao.query(params);
	}
}
