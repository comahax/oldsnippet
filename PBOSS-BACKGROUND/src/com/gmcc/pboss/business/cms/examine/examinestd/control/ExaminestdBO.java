package com.gmcc.pboss.business.cms.examine.examinestd.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.examinestd.persistent.ExaminestdDAO;
import com.gmcc.pboss.business.cms.examine.examinestd.persistent.ExaminestdListVO;
import com.gmcc.pboss.business.cms.examine.examinestd.persistent.ExaminestdVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;


/**
 * <p>Title: ExaminestdControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examinestd/control/ExaminestdControlBean"
 name="ExaminestdControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExaminestdBO extends AbstractControlBean
    implements Examinestd {

    public ExaminestdVO doCreate(ExaminestdVO vo)
        throws Exception {
        try{
			ExaminestdDAO dao = (ExaminestdDAO) DAOFactory.build(ExaminestdDAO.class, user);
            // TODO  set the pk */
            return (ExaminestdVO) dao.create(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public void doRemove(ExaminestdVO vo)
        throws Exception {
        try{
			ExaminestdDAO dao = (ExaminestdDAO) DAOFactory.build(ExaminestdDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public ExaminestdVO doUpdate(ExaminestdVO vo)
        throws Exception {
        try{
			ExaminestdDAO dao = (ExaminestdDAO) DAOFactory.build(ExaminestdDAO.class, user);
            return (ExaminestdVO) dao.update(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public ExaminestdVO doFindByPk(Serializable pk)
        throws Exception {
			ExaminestdDAO dao = (ExaminestdDAO) DAOFactory.build(ExaminestdDAO.class, user);
        return (ExaminestdVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExaminestdListVO params)
        throws Exception {
			ExaminestdDAO dao = (ExaminestdDAO) DAOFactory.build(ExaminestdDAO.class, user);
        return dao.query(params);
    }
   
}
