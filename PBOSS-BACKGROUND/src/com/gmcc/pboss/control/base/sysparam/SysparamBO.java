/**
 * auto-generated code
 * Wed Sep 02 17:01:06 CST 2009
 */
package com.gmcc.pboss.control.base.sysparam;

import java.io.Serializable;

import com.gmcc.pboss.business.base.sysparam.SysparamDAO;
import com.gmcc.pboss.business.base.sysparam.SysparamDBParam;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: SysparamBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/base/sysparam/control/SysparamBO"
*    name="Sysparam"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class SysparamBO extends AbstractControlBean implements
		Sysparam {

	public SysparamVO doCreate(SysparamVO vo) throws Exception {
		try {
			SysparamDAO dao = (SysparamDAO) DAOFactory.build(SysparamDAO.class, user);
			// TODO set the pk */
			return (SysparamVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SysparamVO vo) throws Exception {
		try {
			SysparamDAO dao = (SysparamDAO) DAOFactory.build(SysparamDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SysparamDAO dao = (SysparamDAO) DAOFactory.build(SysparamDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SysparamVO doUpdate(SysparamVO vo) throws Exception {
		try {
			SysparamDAO dao = (SysparamDAO) DAOFactory.build(SysparamDAO.class,user);
			return (SysparamVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SysparamVO doFindByPk(Serializable pk) throws Exception {
		SysparamDAO dao = (SysparamDAO) DAOFactory.build(SysparamDAO.class,user);
		return (SysparamVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SysparamDBParam params)
			throws Exception {
		SysparamDAO dao = (SysparamDAO) DAOFactory.build(SysparamDAO.class,user);
		return dao.query(params);
	}
	
	public String doFindByID(String systemid,String paramtype) throws Exception {
		return this.doFindByID(Long.parseLong(systemid), paramtype);
	}
	
    public String doFindByID(Long systemid, String paramtype)
		throws Exception {
    	SysparamDAO sysparamDAO = (SysparamDAO) DAOFactory.build(SysparamDAO.class, user);
    	return sysparamDAO.doFindByID(systemid, paramtype);
    }    
}
