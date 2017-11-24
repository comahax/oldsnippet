/**
 * auto-generated code
 * Wed Jul 08 10:58:02 CST 2009
 */
package com.gmcc.pboss.control.channel.cntycompany;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.cntycompany.CntycompanyDBParam;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyDAO;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: CntycompanyBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/channel/cntycompany/control/CntycompanyBO"
*    name="Cntycompany"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class CntycompanyBO extends AbstractControlBean implements
		Cntycompany {

	public CntycompanyVO doCreate(CntycompanyVO vo) throws Exception {
		try {
			CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(CntycompanyDAO.class, user);
			// TODO set the pk */
			return (CntycompanyVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(CntycompanyVO vo) throws Exception {
		try {
			CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(CntycompanyDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(CntycompanyDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CntycompanyVO doUpdate(CntycompanyVO vo) throws Exception {
		try {
			CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(CntycompanyDAO.class,user);
			return (CntycompanyVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CntycompanyVO doFindByPk(Serializable pk) throws Exception {
		CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(CntycompanyDAO.class,user);
		return (CntycompanyVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CntycompanyDBParam params)
			throws Exception {
		CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(CntycompanyDAO.class,user);
		return dao.query(params);
	}
	
	public DataPackage doGetCntycompanysOfCity(String cityid) throws Exception {
		CntycompanyDAO dao = (CntycompanyDAO) DAOFactory.build(CntycompanyDAO.class, user);
		CntycompanyDBParam listVO = new CntycompanyDBParam();
		listVO.set_se_citycompid(cityid);
		return dao.query(listVO);
	}
}
