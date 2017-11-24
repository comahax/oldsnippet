package com.gmcc.pboss.business.cms.examine.exmnauditlog.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.exmnauditlog.persistent.ExmnauditlogDAO;
import com.gmcc.pboss.business.cms.examine.exmnauditlog.persistent.ExmnauditlogListVO;
import com.gmcc.pboss.business.cms.examine.exmnauditlog.persistent.ExmnauditlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ExmnauditlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/exmnauditlog/control/ExmnauditlogControlBean"
 name="ExmnauditlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExmnauditlogBO extends AbstractControlBean
    implements Exmnauditlog {

    public ExmnauditlogVO doCreate(ExmnauditlogVO vo)
        throws Exception {
        try{
			ExmnauditlogDAO dao = (ExmnauditlogDAO) DAOFactory.build(ExmnauditlogDAO.class, user);
            // TODO  set the pk */
            return (ExmnauditlogVO) dao.create(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public void doRemove(ExmnauditlogVO vo)
        throws Exception {
        try{
			ExmnauditlogDAO dao = (ExmnauditlogDAO) DAOFactory.build(ExmnauditlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public ExmnauditlogVO doUpdate(ExmnauditlogVO vo)
        throws Exception {
        try{
			ExmnauditlogDAO dao = (ExmnauditlogDAO) DAOFactory.build(ExmnauditlogDAO.class, user);
            return (ExmnauditlogVO) dao.update(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public ExmnauditlogVO doFindByPk(Serializable pk)
        throws Exception {
			ExmnauditlogDAO dao = (ExmnauditlogDAO) DAOFactory.build(ExmnauditlogDAO.class, user);
        return (ExmnauditlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExmnauditlogListVO params)
        throws Exception {
			ExmnauditlogDAO dao = (ExmnauditlogDAO) DAOFactory.build(ExmnauditlogDAO.class, user);
        return dao.query(params);
    }
}
