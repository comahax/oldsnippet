/**
 * auto-generated code
 * Wed Jul 08 10:21:09 CST 2009
 */
package com.gmcc.pboss.control.channel.areacenter;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.areacenter.AreacenterDAO;
import com.gmcc.pboss.business.channel.areacenter.AreacenterDBParam;
import com.gmcc.pboss.business.channel.areacenter.AreacenterVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: AreacenterBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/channel/areacenter/control/AreacenterBO"
*    name="Areacenter"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class AreacenterBO extends AbstractControlBean implements
		Areacenter {

	public AreacenterVO doCreate(AreacenterVO vo) throws Exception {
		try {
			AreacenterDAO dao = (AreacenterDAO) DAOFactory.build(AreacenterDAO.class, user);
			// TODO set the pk */
			return (AreacenterVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(AreacenterVO vo) throws Exception {
		try {
			AreacenterDAO dao = (AreacenterDAO) DAOFactory.build(AreacenterDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			AreacenterDAO dao = (AreacenterDAO) DAOFactory.build(AreacenterDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AreacenterVO doUpdate(AreacenterVO vo) throws Exception {
		try {
			AreacenterDAO dao = (AreacenterDAO) DAOFactory.build(AreacenterDAO.class,user);
			return (AreacenterVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AreacenterVO doFindByPk(Serializable pk) throws Exception {
		AreacenterDAO dao = (AreacenterDAO) DAOFactory.build(AreacenterDAO.class,user);
		return (AreacenterVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(AreacenterDBParam params)
			throws Exception {
		AreacenterDAO dao = (AreacenterDAO) DAOFactory.build(AreacenterDAO.class,user);
		return dao.query(params);
	}
	
    public DataPackage doGetCenters() throws Exception {
    	AreacenterDAO dao = (AreacenterDAO) DAOFactory.build(AreacenterDAO.class, user);
    	AreacenterDBParam listVO = new AreacenterDBParam();
    	listVO.set_pagesize("0");
    	return dao.query(listVO);
    }
    
}
