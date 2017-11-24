package com.gmcc.pboss.business.cms.examine.coefrevision.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.coefrevision.persistent.CoefrevisionDAO;
import com.gmcc.pboss.business.cms.examine.coefrevision.persistent.CoefrevisionListVO;
import com.gmcc.pboss.business.cms.examine.coefrevision.persistent.CoefrevisionVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;


/**
 * <p>Title: CoefrevisionControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/coefrevision/control/CoefrevisionControlBean"
 name="CoefrevisionControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CoefrevisionBO extends AbstractControlBean
    implements Coefrevision {

    public CoefrevisionVO doCreate(CoefrevisionVO vo)
        throws Exception {
        try{
			CoefrevisionDAO dao = (CoefrevisionDAO) DAOFactory.build(CoefrevisionDAO.class, user);
            // TODO  set the pk */
            return (CoefrevisionVO) dao.create(vo);
        } catch(Exception ex){
            
            throw new JOPException(ex);
        }
    }

    public void doRemove(CoefrevisionVO vo)
        throws Exception {
        try{
			CoefrevisionDAO dao = (CoefrevisionDAO) DAOFactory.build(CoefrevisionDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            
            throw new JOPException(ex);
        }
    }

    public CoefrevisionVO doUpdate(CoefrevisionVO vo)
        throws Exception {
        try{
			CoefrevisionDAO dao = (CoefrevisionDAO) DAOFactory.build(CoefrevisionDAO.class, user);
            return (CoefrevisionVO) dao.update(vo);
        } catch(Exception ex){
            
            throw new JOPException(ex);
        }
    }

    public CoefrevisionVO doFindByPk(Serializable pk)
        throws Exception {
			CoefrevisionDAO dao = (CoefrevisionDAO) DAOFactory.build(CoefrevisionDAO.class, user);
        return (CoefrevisionVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(CoefrevisionListVO params)
        throws Exception {
			CoefrevisionDAO dao = (CoefrevisionDAO) DAOFactory.build(CoefrevisionDAO.class, user);
        return dao.query(params);
    }
}
