/**
 * auto-generated code
 * Wed Oct 21 19:54:26 CST 2009
 */
package com.gmcc.pboss.control.channel.custwaytype;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeDBParam;
import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeDAO;
import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: CustwaytypeBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/channel/custwaytype/control/CustwaytypeBO"
*    name="Custwaytype"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class CustwaytypeBO extends AbstractControlBean implements
		Custwaytype {

	public CustwaytypeVO doCreate(CustwaytypeVO vo) throws Exception {
		try {
			CustwaytypeDAO dao = (CustwaytypeDAO) DAOFactory.build(CustwaytypeDAO.class, user);
			// TODO set the pk */
			return (CustwaytypeVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(CustwaytypeVO vo) throws Exception {
		try {
			CustwaytypeDAO dao = (CustwaytypeDAO) DAOFactory.build(CustwaytypeDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CustwaytypeDAO dao = (CustwaytypeDAO) DAOFactory.build(CustwaytypeDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CustwaytypeVO doUpdate(CustwaytypeVO vo) throws Exception {
		try {
			CustwaytypeDAO dao = (CustwaytypeDAO) DAOFactory.build(CustwaytypeDAO.class,user);
			return (CustwaytypeVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CustwaytypeVO doFindByPk(Serializable pk) throws Exception {
		CustwaytypeDAO dao = (CustwaytypeDAO) DAOFactory.build(CustwaytypeDAO.class,user);
		return (CustwaytypeVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CustwaytypeDBParam params)
			throws Exception {
		CustwaytypeDAO dao = (CustwaytypeDAO) DAOFactory.build(CustwaytypeDAO.class,user);
		return dao.query(params);
	}
}
