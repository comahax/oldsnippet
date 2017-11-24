package com.gmcc.pboss.business.cms.examine.exmnitemlog.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.exmnitemlog.persistent.ExmnitemlogDAO;
import com.gmcc.pboss.business.cms.examine.exmnitemlog.persistent.ExmnitemlogListVO;
import com.gmcc.pboss.business.cms.examine.exmnitemlog.persistent.ExmnitemlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ExmnitemlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/exmnitemlog/control/ExmnitemlogControlBean"
 name="ExmnitemlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExmnitemlogBO extends AbstractControlBean
    implements Exmnitemlog {

    public ExmnitemlogVO doCreate(ExmnitemlogVO vo)
        throws Exception {
        try{
			ExmnitemlogDAO dao = (ExmnitemlogDAO) DAOFactory.build(ExmnitemlogDAO.class,user);
            // TODO  set the pk */
            return (ExmnitemlogVO) dao.create(vo);
        } catch(Exception ex){  
            throw new JOPException(ex);
        }
    }

    public void doRemove(ExmnitemlogVO vo)
        throws Exception {
        try{
			ExmnitemlogDAO dao = (ExmnitemlogDAO) DAOFactory.build(ExmnitemlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){           
            throw new JOPException(ex);
        }
    }

    public ExmnitemlogVO doUpdate(ExmnitemlogVO vo)
        throws Exception {
        try{
			ExmnitemlogDAO dao = (ExmnitemlogDAO) DAOFactory.build(ExmnitemlogDAO.class, user);
            return (ExmnitemlogVO) dao.update(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public ExmnitemlogVO doFindByPk(Serializable pk)
        throws Exception {
			ExmnitemlogDAO dao = (ExmnitemlogDAO) DAOFactory.build(ExmnitemlogDAO.class, user);
        return (ExmnitemlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExmnitemlogListVO params)
        throws Exception {
			ExmnitemlogDAO dao = (ExmnitemlogDAO) DAOFactory.build(ExmnitemlogDAO.class, user);
        return dao.query(params);
    }
}
