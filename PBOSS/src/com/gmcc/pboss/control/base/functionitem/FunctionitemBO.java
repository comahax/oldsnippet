/**
 * auto-generated code
 * Tue Jul 14 14:52:45 CST 2009
 */
package com.gmcc.pboss.control.base.functionitem;

import java.io.Serializable;

import com.gmcc.pboss.business.base.functionitem.FunctionitemDAO;
import com.gmcc.pboss.business.base.functionitem.FunctionitemDBParam;
import com.gmcc.pboss.business.base.functionitem.FunctionitemVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: FunctionitemBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/system/functionitem/control/FunctionitemBO"
*    name="Functionitem"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class FunctionitemBO extends AbstractControlBean implements
		Functionitem {

	public FunctionitemVO doCreate(FunctionitemVO vo) throws Exception {
		try {
			FunctionitemDAO dao = (FunctionitemDAO) DAOFactory.build(FunctionitemDAO.class, user);
			// TODO set the pk */
			return (FunctionitemVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(FunctionitemVO vo) throws Exception {
		try {
			FunctionitemDAO dao = (FunctionitemDAO) DAOFactory.build(FunctionitemDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			FunctionitemDAO dao = (FunctionitemDAO) DAOFactory.build(FunctionitemDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public FunctionitemVO doUpdate(FunctionitemVO vo) throws Exception {
		try {
			FunctionitemDAO dao = (FunctionitemDAO) DAOFactory.build(FunctionitemDAO.class,user);
			return (FunctionitemVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public FunctionitemVO doFindByPk(Serializable pk) throws Exception {
		FunctionitemDAO dao = (FunctionitemDAO) DAOFactory.build(FunctionitemDAO.class,user);
		return (FunctionitemVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(FunctionitemDBParam params)
			throws Exception {
		FunctionitemDAO dao = (FunctionitemDAO) DAOFactory.build(FunctionitemDAO.class,user);
		return dao.query(params);
	}

	/**
	 * 自定义SQL查询
	 * @param querySqlName 自定义的SQL名称
	 * @param param	查询参数
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryByNameSql(String querySqlName,FunctionitemDBParam param)  throws Exception {
		FunctionitemDAO dao = (FunctionitemDAO) DAOFactory.build(FunctionitemDAO.class,user);
		return dao.queryByNamedSqlQuery(querySqlName, param);
	}
	
	/**
	 * 菜单多选树
	 * @param queryText
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryText(String queryText) throws Exception{
		FunctionitemDBParam params = new FunctionitemDBParam();
		FunctionitemDAO dao = (FunctionitemDAO) DAOFactory.build(FunctionitemDAO.class,user);
		params.getQueryConditions().put("queryText", "%"+queryText+"%");
		params.setQueryAll(true);
		return dao.queryByNamedSqlQuery("queryFunctionitemTextSQL",params);
	}
}
