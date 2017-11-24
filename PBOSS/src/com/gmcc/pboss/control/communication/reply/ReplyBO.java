/**
 * auto-generated code
 * Tue Sep 29 10:19:40 CST 2009
 */
package com.gmcc.pboss.control.communication.reply;

import java.io.Serializable;

import com.gmcc.pboss.business.communication.reply.ReplyDBParam;
import com.gmcc.pboss.business.communication.reply.ReplyDAO;
import com.gmcc.pboss.business.communication.reply.ReplyVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ReplyBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/communication/reply/control/ReplyBO"
*    name="Reply"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ReplyBO extends AbstractControlBean implements
		Reply {

	public ReplyVO doCreate(ReplyVO vo) throws Exception {
		try {
			ReplyDAO dao = (ReplyDAO) DAOFactory.build(ReplyDAO.class, user);
			// TODO set the pk */
			return (ReplyVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ReplyVO vo) throws Exception {
		try {
			ReplyDAO dao = (ReplyDAO) DAOFactory.build(ReplyDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ReplyDAO dao = (ReplyDAO) DAOFactory.build(ReplyDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ReplyVO doUpdate(ReplyVO vo) throws Exception {
		try {
			ReplyDAO dao = (ReplyDAO) DAOFactory.build(ReplyDAO.class,user);
			return (ReplyVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ReplyVO doFindByPk(Serializable pk) throws Exception {
		ReplyDAO dao = (ReplyDAO) DAOFactory.build(ReplyDAO.class,user);
		return (ReplyVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ReplyDBParam params)
			throws Exception {
		ReplyDAO dao = (ReplyDAO) DAOFactory.build(ReplyDAO.class,user);
		return dao.query(params);
	}

	public DataPackage doQueryReplyInfo(ReplyDBParam params) throws Exception {
		ReplyDAO dao = (ReplyDAO) DAOFactory.build(ReplyDAO.class,user);
		return dao.doQueryReplyInfo(params);
	}
	
	
}
