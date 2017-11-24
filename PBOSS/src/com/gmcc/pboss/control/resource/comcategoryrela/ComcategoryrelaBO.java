/**
 * auto-generated code
 * Sat Sep 05 15:14:44 CST 2009
 */
package com.gmcc.pboss.control.resource.comcategoryrela;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDAO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.sales.waystockrecord.WaystockrecordDBParam;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ComcategoryrelaBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/resource/comcategoryrela/control/ComcategoryrelaBO"
*    name="Comcategoryrela"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ComcategoryrelaBO extends AbstractControlBean implements
		Comcategoryrela {

	public ComcategoryrelaVO doCreate(ComcategoryrelaVO vo) throws Exception {
		try {
			ComcategoryrelaDAO dao = (ComcategoryrelaDAO) DAOFactory.build(ComcategoryrelaDAO.class, user);
			// TODO set the pk */
			return (ComcategoryrelaVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ComcategoryrelaVO vo) throws Exception {
		try {
			ComcategoryrelaDAO dao = (ComcategoryrelaDAO) DAOFactory.build(ComcategoryrelaDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ComcategoryrelaDAO dao = (ComcategoryrelaDAO) DAOFactory.build(ComcategoryrelaDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComcategoryrelaVO doUpdate(ComcategoryrelaVO vo) throws Exception {
		try {
			ComcategoryrelaDAO dao = (ComcategoryrelaDAO) DAOFactory.build(ComcategoryrelaDAO.class,user);
			return (ComcategoryrelaVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComcategoryrelaVO doFindByPk(Serializable pk) throws Exception {
		ComcategoryrelaDAO dao = (ComcategoryrelaDAO) DAOFactory.build(ComcategoryrelaDAO.class,user);
		return (ComcategoryrelaVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ComcategoryrelaDBParam params)
			throws Exception {
		ComcategoryrelaDAO dao = (ComcategoryrelaDAO) DAOFactory.build(ComcategoryrelaDAO.class,user);
		return dao.query(params);
	}
	public List<String> doQueryComcategoryByBrand(String brand)
			throws Exception {
		ComcategoryrelaDAO dao = (ComcategoryrelaDAO) DAOFactory.build(ComcategoryrelaDAO.class,user);
		return dao.queryComcategoryByBrand(brand);
	}
	public DataPackage doLoadComCateAndResType(ComcategoryrelaDBParam params)
			throws Exception {
		ComcategoryrelaDAO dao = (ComcategoryrelaDAO) DAOFactory.build(ComcategoryrelaDAO.class,user);
		return dao.loadComCateAndResType(params);
	}
	public DataPackage doLoadComCateAndBrand(ComcategoryrelaDBParam params)
			throws Exception {
		ComcategoryrelaDAO dao = (ComcategoryrelaDAO) DAOFactory.build(
				ComcategoryrelaDAO.class, user);
		return dao.loadComCateAndBrand(params);
	}
	
	 public DataPackage doQueryDistinctComcategory(ComcategoryrelaDBParam param)throws Exception{
		 ComcategoryrelaDAO dao = (ComcategoryrelaDAO) DAOFactory.build(
					ComcategoryrelaDAO.class, user);
			return dao.queryDistinctComcategory(param);
	 }

	public DataPackage doQueryRestypeToComcategory(
			ComcategoryrelaDBParam params) throws Exception {
		ComcategoryrelaDAO dao = (ComcategoryrelaDAO) DAOFactory.build(
				ComcategoryrelaDAO.class, user);
		return dao.queryByNamedSqlQuery("queryRestypeToComcategory", params);
	}
}
