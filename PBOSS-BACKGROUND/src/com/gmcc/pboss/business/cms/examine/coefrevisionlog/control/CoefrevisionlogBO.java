package com.gmcc.pboss.business.cms.examine.coefrevisionlog.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.coefrevisionlog.persistent.CoefrevisionlogDAO;
import com.gmcc.pboss.business.cms.examine.coefrevisionlog.persistent.CoefrevisionlogListVO;
import com.gmcc.pboss.business.cms.examine.coefrevisionlog.persistent.CoefrevisionlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: CoefrevisionlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/coefrevisionlog/control/CoefrevisionlogControlBean"
 name="CoefrevisionlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CoefrevisionlogBO extends AbstractControlBean
    implements Coefrevisionlog {

    public CoefrevisionlogVO doCreate(CoefrevisionlogVO vo)
        throws Exception {
        try{
			CoefrevisionlogDAO dao = (CoefrevisionlogDAO) DAOFactory.build(CoefrevisionlogDAO.class, user);
            // TODO  set the pk */
            return (CoefrevisionlogVO) dao.create(vo);
        } catch(Exception ex){
            
            throw new JOPException(ex);
        }
    }

    public void doRemove(CoefrevisionlogVO vo)
        throws Exception {
        try{
			CoefrevisionlogDAO dao = (CoefrevisionlogDAO) DAOFactory.build(CoefrevisionlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            
            throw new JOPException(ex);
        }
    }

    public CoefrevisionlogVO doUpdate(CoefrevisionlogVO vo)
        throws Exception {
        try{
			CoefrevisionlogDAO dao = (CoefrevisionlogDAO) DAOFactory.build(CoefrevisionlogDAO.class, user);
            return (CoefrevisionlogVO) dao.update(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public CoefrevisionlogVO doFindByPk(Serializable pk)
        throws Exception {
			CoefrevisionlogDAO dao = (CoefrevisionlogDAO) DAOFactory.build(CoefrevisionlogDAO.class, user);
        return (CoefrevisionlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(CoefrevisionlogListVO params)
        throws Exception {
			CoefrevisionlogDAO dao = (CoefrevisionlogDAO) DAOFactory.build(CoefrevisionlogDAO.class, user);
        return dao.query(params);
    }
}
