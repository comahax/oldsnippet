/**
 * auto-generated code
 * Sat Jan 24 11:49:16 CST 2015
 */
package com.gmcc.pboss.control.channel.property;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.property.PropertyDAO;
import com.gmcc.pboss.business.channel.property.PropertyDBParam;
import com.gmcc.pboss.business.channel.property.PropertyVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PropertyBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class PropertyBO extends AbstractControlBean implements
		Property {

	public PropertyVO doCreate(PropertyVO vo) throws Exception {
		try {
			PropertyDAO dao = (PropertyDAO) DAOFactory.build(PropertyDAO.class, user);
			// TODO set the pk */
			return (PropertyVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PropertyVO vo) throws Exception {
		try {
			PropertyDAO dao = (PropertyDAO) DAOFactory.build(PropertyDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PropertyDAO dao = (PropertyDAO) DAOFactory.build(PropertyDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PropertyVO doUpdate(PropertyVO vo) throws Exception {
		try {
			PropertyDAO dao = (PropertyDAO) DAOFactory.build(PropertyDAO.class,user);
			return (PropertyVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PropertyVO doFindByPk(Serializable pk) throws Exception {
		PropertyDAO dao = (PropertyDAO) DAOFactory.build(PropertyDAO.class,user);
		return (PropertyVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(PropertyDBParam params)
			throws Exception {
		PropertyDAO dao = (PropertyDAO) DAOFactory.build(PropertyDAO.class,user);
		return dao.query(params);
	}
}
