/**
 * auto-generated code
 * Mon Mar 01 14:59:35 CST 2010
 */
package com.gmcc.pboss.control.channel.result;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.result.ResultDBParam;
import com.gmcc.pboss.business.channel.result.ResultDAO;
import com.gmcc.pboss.business.channel.result.ResultVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: ResultBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResultBO extends AbstractControlBean implements
		Result {

	public ResultVO doCreate(ResultVO vo) throws Exception {
		try {
			ResultDAO dao = (ResultDAO) DAOFactory.build(ResultDAO.class, user);
			// TODO set the pk */
			return (ResultVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ResultVO vo) throws Exception {
		try {
			ResultDAO dao = (ResultDAO) DAOFactory.build(ResultDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ResultDAO dao = (ResultDAO) DAOFactory.build(ResultDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResultVO doUpdate(ResultVO vo) throws Exception {
		try {
			ResultDAO dao = (ResultDAO) DAOFactory.build(ResultDAO.class,user);
			return (ResultVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResultVO doFindByPk(Serializable pk) throws Exception {
		ResultDAO dao = (ResultDAO) DAOFactory.build(ResultDAO.class,user);
		return (ResultVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ResultDBParam params)
			throws Exception {
		ResultDAO dao = (ResultDAO) DAOFactory.build(ResultDAO.class,user);
		return dao.query(params);
	}
}
