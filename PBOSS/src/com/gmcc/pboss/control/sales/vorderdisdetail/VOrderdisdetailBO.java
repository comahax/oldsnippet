/**
 * auto-generated code
 * Tue Apr 03 12:44:47 CST 2012
 */
package com.gmcc.pboss.control.sales.vorderdisdetail;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.vorderdisdetail.VOrderdisdetailDBParam;
import com.gmcc.pboss.business.sales.vorderdisdetail.VOrderdisdetailDAO;
import com.gmcc.pboss.business.sales.vorderdisdetail.VOrderdisdetailVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: VOrderdisdetailBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class VOrderdisdetailBO extends AbstractControlBean implements
		VOrderdisdetail {
	public DataPackage doQuery(VOrderdisdetailDBParam params)
			throws Exception {
		VOrderdisdetailDAO dao = (VOrderdisdetailDAO) DAOFactory.build(VOrderdisdetailDAO.class,user);
		return dao.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.vorderdisdetail.orderdisdetaillist", params);
		//return dao.query(params);
	}
}
