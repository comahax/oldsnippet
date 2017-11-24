package com.gmcc.pboss.business.cms.examine.exmnaudit.control;

import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.exmnaudit.persistent.ExmnauditListVO;
import com.gmcc.pboss.business.cms.examine.exmnaudit.persistent.ExmnauditVO;
import com.gmcc.pboss.business.cms.examine.exmnaudit.persistent.ExmnauditDAO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;


/**
 * <p>Title: ExmnauditControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/exmnaudit/control/ExmnauditControlBean"
 name="ExmnauditControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExmnauditBO extends AbstractControlBean
    implements Exmnaudit {

    public ExmnauditVO doCreate(ExmnauditVO vo)
        throws Exception {
        try{
			ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
            // TODO  set the pk */
            return (ExmnauditVO) dao.create(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public void doRemove(ExmnauditVO vo)
        throws Exception {
        try{
			ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public ExmnauditVO doUpdate(ExmnauditVO vo)
        throws Exception {
        try{
			ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
            return (ExmnauditVO) dao.update(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public ExmnauditVO doFindByPk(Serializable pk)
        throws Exception {
			ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
        return (ExmnauditVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExmnauditListVO params)
        throws Exception {
			ExmnauditDAO dao = (ExmnauditDAO) DAOFactory.build(ExmnauditDAO.class, user);
        return dao.query(params);
    }
}
