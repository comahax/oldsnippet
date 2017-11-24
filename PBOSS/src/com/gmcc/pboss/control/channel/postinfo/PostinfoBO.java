/**
 * auto-generated code
 * Wed Jul 01 17:28:49 CST 2009
 */
package com.gmcc.pboss.control.channel.postinfo;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.postinfo.PostinfoDBParam;
import com.gmcc.pboss.business.channel.postinfo.PostinfoDAO;
import com.gmcc.pboss.business.channel.postinfo.PostinfoVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PostinfoBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/channel/postinfo/control/PostinfoBO"
*    name="Postinfo"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class PostinfoBO extends AbstractControlBean implements
		Postinfo {

	public PostinfoVO doCreate(PostinfoVO vo) throws Exception {
		try {
			PostinfoDAO dao = (PostinfoDAO) DAOFactory.build(PostinfoDAO.class, user);
			// TODO set the pk */
			return (PostinfoVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PostinfoVO vo) throws Exception {
		try {
			PostinfoDAO dao = (PostinfoDAO) DAOFactory.build(PostinfoDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PostinfoDAO dao = (PostinfoDAO) DAOFactory.build(PostinfoDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PostinfoVO doUpdate(PostinfoVO vo) throws Exception {
		try {
			PostinfoDAO dao = (PostinfoDAO) DAOFactory.build(PostinfoDAO.class,user);
			return (PostinfoVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PostinfoVO doFindByPk(Serializable pk) throws Exception {
		PostinfoDAO dao = (PostinfoDAO) DAOFactory.build(PostinfoDAO.class,user);
		return (PostinfoVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(PostinfoDBParam params)
			throws Exception {
		PostinfoDAO dao = (PostinfoDAO) DAOFactory.build(PostinfoDAO.class,user);
		return dao.query(params);
	}
}
