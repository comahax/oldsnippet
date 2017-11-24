/**
 * auto-generated code
 * Sun Sep 13 11:05:37 CST 2009
 */
package com.gmcc.pboss.control.channel.microarea;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.microarea.MicroareaDBParam;
import com.gmcc.pboss.business.channel.microarea.MicroareaDAO;
import com.gmcc.pboss.business.channel.microarea.MicroareaVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: MicroareaBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/channel/microarea/control/MicroareaBO"
*    name="Microarea"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class MicroareaBO extends AbstractControlBean implements
		Microarea {

	public MicroareaVO doCreate(MicroareaVO vo) throws Exception {
		try {
			MicroareaDAO dao = (MicroareaDAO) DAOFactory.build(MicroareaDAO.class, user);
			// TODO set the pk */
			return (MicroareaVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(MicroareaVO vo) throws Exception {
		try {
			MicroareaDAO dao = (MicroareaDAO) DAOFactory.build(MicroareaDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			MicroareaDAO dao = (MicroareaDAO) DAOFactory.build(MicroareaDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public MicroareaVO doUpdate(MicroareaVO vo) throws Exception {
		try {
			MicroareaDAO dao = (MicroareaDAO) DAOFactory.build(MicroareaDAO.class,user);
			return (MicroareaVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public MicroareaVO doFindByPk(Serializable pk) throws Exception {
		MicroareaDAO dao = (MicroareaDAO) DAOFactory.build(MicroareaDAO.class,user);
		return (MicroareaVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(MicroareaDBParam params)
			throws Exception {
		MicroareaDAO dao = (MicroareaDAO) DAOFactory.build(MicroareaDAO.class,user);
		return dao.query(params);
	}
	
	public DataPackage doFindCountyMarea(MicroareaDBParam params) throws Exception {
		MicroareaDAO dao = (MicroareaDAO) DAOFactory.build(MicroareaDAO.class,user);
		return dao.queryByNamedSqlQuery("boss.cms.microarea.queryBycountyid", params);
	}
}
