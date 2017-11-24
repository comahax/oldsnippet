/**
 * auto-generated code
 * Wed Jan 04 10:07:20 CST 2012
 */
package com.gmcc.pboss.control.channel.bondformlog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.bondformlog.BondformlogDBParam;
import com.gmcc.pboss.business.channel.bondformlog.BondformlogDAO;
import com.gmcc.pboss.business.channel.bondformlog.BondformlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: BondformlogBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class BondformlogBO extends AbstractControlBean implements
		Bondformlog {

	public BondformlogVO doCreate(BondformlogVO vo) throws Exception {
		try {
			BondformlogDAO dao = (BondformlogDAO) DAOFactory.build(BondformlogDAO.class, user);
			// TODO set the pk */
			return (BondformlogVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(BondformlogVO vo) throws Exception {
		try {
			BondformlogDAO dao = (BondformlogDAO) DAOFactory.build(BondformlogDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			BondformlogDAO dao = (BondformlogDAO) DAOFactory.build(BondformlogDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BondformlogVO doUpdate(BondformlogVO vo) throws Exception {
		try {
			BondformlogDAO dao = (BondformlogDAO) DAOFactory.build(BondformlogDAO.class,user);
			return (BondformlogVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BondformlogVO doFindByPk(Serializable pk) throws Exception {
		BondformlogDAO dao = (BondformlogDAO) DAOFactory.build(BondformlogDAO.class,user);
		return (BondformlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BondformlogDBParam params)
			throws Exception {
		BondformlogDAO dao = (BondformlogDAO) DAOFactory.build(BondformlogDAO.class,user);
		return dao.query(params);
	}
   public DataPackage doBondformlogList(BondformlogDBParam params)
           throws Exception{
	   BondformlogDAO dao = (BondformlogDAO) DAOFactory.build(BondformlogDAO.class,user);
	   return dao.bondformLogVoList(params); 
	}
   public DataPackage doBondformlogListForExcel(BondformlogDBParam params)
            throws Exception{
       BondformlogDAO dao = (BondformlogDAO) DAOFactory.build(BondformlogDAO.class,user);
       return dao.bondformLogVoListForExcel(params); 
}
   
}
