/**
 * auto-generated code
 * Wed Jul 08 11:40:54 CST 2009
 */
package com.gmcc.pboss.control.channel.svwaycnstr;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.svwaycnstr.SvwaycnstrDBParam;
import com.gmcc.pboss.business.channel.svwaycnstr.SvwaycnstrDAO;
import com.gmcc.pboss.business.channel.svwaycnstr.SvwaycnstrVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: SvwaycnstrBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/channel/svwaycnstr/control/SvwaycnstrBO"
*    name="Svwaycnstr"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class SvwaycnstrBO extends AbstractControlBean implements
		Svwaycnstr {

	public SvwaycnstrVO doCreate(SvwaycnstrVO vo) throws Exception {
		try {
			SvwaycnstrDAO dao = (SvwaycnstrDAO) DAOFactory.build(SvwaycnstrDAO.class, user);
			// TODO set the pk */
			return (SvwaycnstrVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SvwaycnstrVO vo) throws Exception {
		try {
			SvwaycnstrDAO dao = (SvwaycnstrDAO) DAOFactory.build(SvwaycnstrDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SvwaycnstrDAO dao = (SvwaycnstrDAO) DAOFactory.build(SvwaycnstrDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SvwaycnstrVO doUpdate(SvwaycnstrVO vo) throws Exception {
		try {
			SvwaycnstrDAO dao = (SvwaycnstrDAO) DAOFactory.build(SvwaycnstrDAO.class,user);
			return (SvwaycnstrVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SvwaycnstrVO doFindByPk(Serializable pk) throws Exception {
		SvwaycnstrDAO dao = (SvwaycnstrDAO) DAOFactory.build(SvwaycnstrDAO.class,user);
		return (SvwaycnstrVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SvwaycnstrDBParam params)
			throws Exception {
		SvwaycnstrDAO dao = (SvwaycnstrDAO) DAOFactory.build(SvwaycnstrDAO.class,user);
		return dao.query(params);
	}
}
