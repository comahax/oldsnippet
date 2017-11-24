/**
 * auto-generated code
 * Tue Dec 07 10:33:29 CST 2010
 */
package com.gmcc.pboss.control.base.webfunctionitem;

import java.io.Serializable;

import com.gmcc.pboss.business.base.functionitem.FunctionitemDAO;
import com.gmcc.pboss.business.base.functionitem.FunctionitemDBParam;
import com.gmcc.pboss.business.base.webfunctionitem.WebfunctionitemDAO;
import com.gmcc.pboss.business.base.webfunctionitem.WebfunctionitemDBParam;
import com.gmcc.pboss.business.base.webfunctionitem.WebfunctionitemVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: WebfunctionitemBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class WebfunctionitemBO extends AbstractControlBean implements
		Webfunctionitem {

	public WebfunctionitemVO doCreate(WebfunctionitemVO vo) throws Exception {
		try {
			WebfunctionitemDAO dao = (WebfunctionitemDAO) DAOFactory.build(WebfunctionitemDAO.class, user);
			// TODO set the pk */
			return (WebfunctionitemVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WebfunctionitemVO vo) throws Exception {
		try {
			WebfunctionitemDAO dao = (WebfunctionitemDAO) DAOFactory.build(WebfunctionitemDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WebfunctionitemDAO dao = (WebfunctionitemDAO) DAOFactory.build(WebfunctionitemDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WebfunctionitemVO doUpdate(WebfunctionitemVO vo) throws Exception {
		try {
			WebfunctionitemDAO dao = (WebfunctionitemDAO) DAOFactory.build(WebfunctionitemDAO.class,user);
			return (WebfunctionitemVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WebfunctionitemVO doFindByPk(Serializable pk) throws Exception {
		WebfunctionitemDAO dao = (WebfunctionitemDAO) DAOFactory.build(WebfunctionitemDAO.class,user);
		return (WebfunctionitemVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WebfunctionitemDBParam params)
			throws Exception {
		WebfunctionitemDAO dao = (WebfunctionitemDAO) DAOFactory.build(WebfunctionitemDAO.class,user);
		return dao.query(params);
	}
	
	/**
	 * 自定义SQL查询
	 * @param querySqlName 自定义的SQL名称
	 * @param param	查询参数
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryByNameSql(String querySqlName,WebfunctionitemDBParam param)  throws Exception {
		WebfunctionitemDAO dao = (WebfunctionitemDAO) DAOFactory.build(WebfunctionitemDAO.class,user);
		return dao.queryByNamedSqlQuery(querySqlName, param);
	}
	
	/**
	 * 菜单多选树
	 * @param queryText
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryText(String queryText) throws Exception{
		WebfunctionitemDBParam params = new WebfunctionitemDBParam();
		WebfunctionitemDAO dao = (WebfunctionitemDAO) DAOFactory.build(WebfunctionitemDAO.class,user);
		params.getQueryConditions().put("queryText", "%"+queryText+"%");
		params.setQueryAll(true);
		return dao.queryByNamedSqlQuery("querywebFunctionitemTextSQL",params);
	}
}
