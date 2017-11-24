/**
 * auto-generated code
 * Tue Oct 19 15:41:02 CST 2010
 */
package com.gmcc.pboss.control.sales.waystockrecord;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDAO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.sales.waystockrecord.WaystockrecordDAO;
import com.gmcc.pboss.business.sales.waystockrecord.WaystockrecordDBParam;
import com.gmcc.pboss.business.sales.waystockrecord.WaystockrecordVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: WaystockrecordBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class WaystockrecordBO extends AbstractControlBean implements
		Waystockrecord {

	public WaystockrecordVO doCreate(WaystockrecordVO vo) throws Exception {
		try {
			WaystockrecordDAO dao = (WaystockrecordDAO) DAOFactory.build(WaystockrecordDAO.class, user);
			// TODO set the pk */
			return (WaystockrecordVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WaystockrecordVO vo) throws Exception {
		try {
			WaystockrecordDAO dao = (WaystockrecordDAO) DAOFactory.build(WaystockrecordDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WaystockrecordDAO dao = (WaystockrecordDAO) DAOFactory.build(WaystockrecordDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaystockrecordVO doUpdate(WaystockrecordVO vo) throws Exception {
		try {
			WaystockrecordDAO dao = (WaystockrecordDAO) DAOFactory.build(WaystockrecordDAO.class,user);
			return (WaystockrecordVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaystockrecordVO doFindByPk(Serializable pk) throws Exception {
		WaystockrecordDAO dao = (WaystockrecordDAO) DAOFactory.build(WaystockrecordDAO.class,user);
		return (WaystockrecordVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WaystockrecordDBParam params)
			throws Exception {
		WaystockrecordDAO dao = (WaystockrecordDAO) DAOFactory.build(WaystockrecordDAO.class,user);
		return dao.query(params);
	}

	public DataPackage queryRestypeToComcategory(WaystockrecordDBParam params,
			String name) throws Exception {
		WaystockrecordDAO dao = (WaystockrecordDAO) DAOFactory.build(WaystockrecordDAO.class, user);
		return dao.queryByNamedSqlQuery(name,params);
	}
	
	public Map doLoadComCateAndBrand(
			ComcategoryrelaDBParam params) throws Exception {
		ComcategoryrelaDAO dao = (ComcategoryrelaDAO) DAOFactory.build(
				ComcategoryrelaDAO.class, user);
		params.setSelectFieldsString("comcategory,wayname");
		Map comg = new HashMap();
		DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.resource.comcategoryrela.loadAllComCateAndBrand", params);
		if (dp!=null && dp.getDatas().size()>0) {
			for (int i=0; i<dp.getDatas().size(); i++) {
				Map tmp =(Map)dp.getDatas().get(i);
				comg.put(tmp.get("comcategory"), tmp.get("wayname"));
			}
		}
		
		return comg;
	}
	
	public Long getComcategoryCount() throws Exception {
		WaystockrecordDAO dao = (WaystockrecordDAO) DAOFactory.build(WaystockrecordDAO.class, user);
		return getComcategoryCount();
	}
}
