package com.gmcc.pboss.business.cms.examine.exmnperiod.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.exmnperiod.persistent.ExmnperiodDAO;
import com.gmcc.pboss.business.cms.examine.exmnperiod.persistent.ExmnperiodListVO;
import com.gmcc.pboss.business.cms.examine.exmnperiod.persistent.ExmnperiodVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;


/**
 * <p>Title: ExmnperiodControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/exmnperiod/control/ExmnperiodControlBean"
 name="ExmnperiodControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExmnperiodBO extends AbstractControlBean
    implements Exmnperiod {

    public ExmnperiodVO doCreate(ExmnperiodVO vo)
        throws Exception {
        try{
			ExmnperiodDAO dao = (ExmnperiodDAO) DAOFactory.build(ExmnperiodDAO.class, user);
            // TODO  set the pk */
            return (ExmnperiodVO) dao.create(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public void doRemove(ExmnperiodVO vo)
        throws Exception {
        try{
			ExmnperiodDAO dao = (ExmnperiodDAO) DAOFactory.build(ExmnperiodDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public ExmnperiodVO doUpdate(ExmnperiodVO vo)
        throws Exception {
        try{
			ExmnperiodDAO dao = (ExmnperiodDAO) DAOFactory.build(ExmnperiodDAO.class, user);
            return (ExmnperiodVO) dao.update(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public ExmnperiodVO doFindByPk(Serializable pk)
        throws Exception {
			ExmnperiodDAO dao = (ExmnperiodDAO) DAOFactory.build(ExmnperiodDAO.class, user);
        return (ExmnperiodVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExmnperiodListVO params)
        throws Exception {
			ExmnperiodDAO dao = (ExmnperiodDAO) DAOFactory.build(ExmnperiodDAO.class, user);
        return dao.query(params);
    }

}
