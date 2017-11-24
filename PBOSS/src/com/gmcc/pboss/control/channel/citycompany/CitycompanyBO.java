/**
 * auto-generated code
 * Wed Jul 08 10:49:25 CST 2009
 */
package com.gmcc.pboss.control.channel.citycompany;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.citycompany.CitycompanyDBParam;
import com.gmcc.pboss.business.channel.citycompany.CitycompanyDAO;
import com.gmcc.pboss.business.channel.citycompany.CitycompanyVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: CitycompanyBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/channel/citycompany/control/CitycompanyBO"
*    name="Citycompany"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class CitycompanyBO extends AbstractControlBean implements
		Citycompany {

	public CitycompanyVO doCreate(CitycompanyVO vo) throws Exception {
		try {
			CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(CitycompanyDAO.class, user);
			// TODO set the pk */
			return (CitycompanyVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(CitycompanyVO vo) throws Exception {
		try {
			CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(CitycompanyDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(CitycompanyDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CitycompanyVO doUpdate(CitycompanyVO vo) throws Exception {
		try {
			CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(CitycompanyDAO.class,user);
			return (CitycompanyVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CitycompanyVO doFindByPk(Serializable pk) throws Exception {
		CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(CitycompanyDAO.class,user);
		return (CitycompanyVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CitycompanyDBParam params)
			throws Exception {
		CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(CitycompanyDAO.class,user);
		return dao.query(params);
	}
	
	public DataPackage doGetCitycompanysOfCenter(String centerid) throws Exception {
		CitycompanyDAO dao = (CitycompanyDAO) DAOFactory.build(
				CitycompanyDAO.class, user);
		CitycompanyDBParam listVO = new CitycompanyDBParam();
		listVO.set_se_centerid(centerid);
		return dao.query(listVO);
	}
}
