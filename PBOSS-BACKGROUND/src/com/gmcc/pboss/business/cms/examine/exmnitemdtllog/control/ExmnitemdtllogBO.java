package com.gmcc.pboss.business.cms.examine.exmnitemdtllog.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.exmnitemdtllog.persistent.ExmnitemdtllogDAO;
import com.gmcc.pboss.business.cms.examine.exmnitemdtllog.persistent.ExmnitemdtllogListVO;
import com.gmcc.pboss.business.cms.examine.exmnitemdtllog.persistent.ExmnitemdtllogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ExmnitemdtllogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/exmnitemdtllog/control/ExmnitemdtllogControlBean"
 name="ExmnitemdtllogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExmnitemdtllogBO extends AbstractControlBean
    implements Exmnitemdtllog {

    public ExmnitemdtllogVO doCreate(ExmnitemdtllogVO vo)
        throws Exception {
        try{
			ExmnitemdtllogDAO dao = (ExmnitemdtllogDAO) DAOFactory.build(ExmnitemdtllogDAO.class, user);
            // TODO  set the pk */
            return (ExmnitemdtllogVO) dao.create(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public void doRemove(ExmnitemdtllogVO vo)
        throws Exception {
        try{
			ExmnitemdtllogDAO dao = (ExmnitemdtllogDAO) DAOFactory.build(ExmnitemdtllogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public ExmnitemdtllogVO doUpdate(ExmnitemdtllogVO vo)
        throws Exception {
        try{
			ExmnitemdtllogDAO dao = (ExmnitemdtllogDAO) DAOFactory.build(ExmnitemdtllogDAO.class, user);
            return (ExmnitemdtllogVO) dao.update(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public ExmnitemdtllogVO doFindByPk(Serializable pk)
        throws Exception {
			ExmnitemdtllogDAO dao = (ExmnitemdtllogDAO) DAOFactory.build(ExmnitemdtllogDAO.class, user);
        return (ExmnitemdtllogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExmnitemdtllogListVO params)
        throws Exception {
			ExmnitemdtllogDAO dao = (ExmnitemdtllogDAO) DAOFactory.build(ExmnitemdtllogDAO.class, user);
        return dao.query(params);
    }
}
