/**
 * auto-generated code
 * Fri Dec 30 09:40:47 CST 2011
 */
package com.gmcc.pboss.control.channel.invoice;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.invoice.InvoiceDBParam;
import com.gmcc.pboss.business.channel.invoice.InvoiceDAO;
import com.gmcc.pboss.business.channel.invoice.InvoiceVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: InvoiceBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class InvoiceBO extends AbstractControlBean implements
		Invoice { 
	public InvoiceVO doCreate(InvoiceVO vo) throws Exception {
		try {
			InvoiceDAO dao = (InvoiceDAO) DAOFactory.build(InvoiceDAO.class, user);
			// TODO set the pk */
			return (InvoiceVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(InvoiceVO vo) throws Exception {
		try {
			InvoiceDAO dao = (InvoiceDAO) DAOFactory.build(InvoiceDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			InvoiceDAO dao = (InvoiceDAO) DAOFactory.build(InvoiceDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public InvoiceVO doUpdate(InvoiceVO vo) throws Exception {
		try {
			InvoiceDAO dao = (InvoiceDAO) DAOFactory.build(InvoiceDAO.class,user);
			return (InvoiceVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public InvoiceVO doFindByPk(Serializable pk) throws Exception {
		InvoiceDAO dao = (InvoiceDAO) DAOFactory.build(InvoiceDAO.class,user);
		return (InvoiceVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(InvoiceDBParam params)
			throws Exception {
		InvoiceDAO dao = (InvoiceDAO) DAOFactory.build(InvoiceDAO.class,user);
		return dao.query(params);
	}
	
	public DataPackage doInvoiceList(InvoiceDBParam params,String countyid) throws Exception { 
		InvoiceDAO dao = (InvoiceDAO) DAOFactory.build(InvoiceDAO.class,user); 
		params.getQueryConditions().put("countyid",countyid);
		params.set_se_countyid(null); 
		return dao.queryInvoiceList(params);
	}
}
