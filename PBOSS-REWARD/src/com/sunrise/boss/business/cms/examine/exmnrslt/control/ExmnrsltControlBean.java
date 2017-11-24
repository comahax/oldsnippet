/**
* auto-generated code
* Sun Nov 29 14:14:27 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnrslt.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.examine.exmnrslt.persistent.ExmnrsltDAO;
import com.sunrise.boss.business.cms.examine.exmnrslt.persistent.ExmnrsltListVO;
import com.sunrise.boss.business.cms.examine.exmnrslt.persistent.ExmnrsltVO;
import com.sunrise.boss.business.cms.examine.exmnrslt.persistent.VExmnrsltDAO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ExmnrsltControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/exmnrslt/control/ExmnrsltControlBean"
 name="ExmnrsltControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExmnrsltControlBean extends AbstractControlBean
    implements ExmnrsltControl {

    public ExmnrsltVO doCreate(ExmnrsltVO vo, User user)
        throws Exception {
        try{
			ExmnrsltDAO dao = (ExmnrsltDAO) DAOFactory.build(ExmnrsltDAO.class, user);
            // TODO  set the pk */
            return (ExmnrsltVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ExmnrsltVO vo, User user)
        throws Exception {
        try{
			ExmnrsltDAO dao = (ExmnrsltDAO) DAOFactory.build(ExmnrsltDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExmnrsltVO doUpdate(ExmnrsltVO vo, User user)
        throws Exception {
        try{
			ExmnrsltDAO dao = (ExmnrsltDAO) DAOFactory.build(ExmnrsltDAO.class, user);
            return (ExmnrsltVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExmnrsltVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ExmnrsltDAO dao = (ExmnrsltDAO) DAOFactory.build(ExmnrsltDAO.class, user);
        return (ExmnrsltVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExmnrsltListVO params, User user)
        throws Exception {
			ExmnrsltDAO dao = (ExmnrsltDAO) DAOFactory.build(ExmnrsltDAO.class, user);
        return dao.query(params);
    }
    /**
	 * 查找考核结果明细列表信息
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryExmnrsltInfo(ExmnrsltListVO listVO,User user)
			throws Exception {
		VExmnrsltDAO dao = (VExmnrsltDAO) DAOFactory.build(VExmnrsltDAO.class, user);
        return dao.queryExmnrsltInfo(listVO);
	}
}
