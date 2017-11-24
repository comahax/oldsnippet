package com.gmcc.pboss.business.cms.examine.exmnrslt.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.exmnrslt.persistent.ExmnrsltDAO;
import com.gmcc.pboss.business.cms.examine.exmnrslt.persistent.ExmnrsltListVO;
import com.gmcc.pboss.business.cms.examine.exmnrslt.persistent.ExmnrsltVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

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
public class ExmnrsltBO extends AbstractControlBean
    implements Exmnrslt {

    public ExmnrsltVO doCreate(ExmnrsltVO vo)
        throws Exception {
        try{
			ExmnrsltDAO dao = (ExmnrsltDAO) DAOFactory.build(ExmnrsltDAO.class, user);
            // TODO  set the pk */
            return (ExmnrsltVO) dao.create(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public void doRemove(ExmnrsltVO vo)
        throws Exception {
        try{
			ExmnrsltDAO dao = (ExmnrsltDAO) DAOFactory.build(ExmnrsltDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public ExmnrsltVO doUpdate(ExmnrsltVO vo)
        throws Exception {
        try{
			ExmnrsltDAO dao = (ExmnrsltDAO) DAOFactory.build(ExmnrsltDAO.class, user);
            return (ExmnrsltVO) dao.update(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public ExmnrsltVO doFindByPk(Serializable pk)
        throws Exception {
			ExmnrsltDAO dao = (ExmnrsltDAO) DAOFactory.build(ExmnrsltDAO.class, user);
        return (ExmnrsltVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExmnrsltListVO params)
        throws Exception {
			ExmnrsltDAO dao = (ExmnrsltDAO) DAOFactory.build(ExmnrsltDAO.class, user);
        return dao.query(params);
    }
}
