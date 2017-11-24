package com.gmcc.pboss.business.cms.examine.exmnperiodlog.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.exmnperiodlog.persistent.ExmnperiodlogDAO;
import com.gmcc.pboss.business.cms.examine.exmnperiodlog.persistent.ExmnperiodlogListVO;
import com.gmcc.pboss.business.cms.examine.exmnperiodlog.persistent.ExmnperiodlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ExmnperiodlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/exmnperiodlog/control/ExmnperiodlogControlBean"
 name="ExmnperiodlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExmnperiodlogBO extends AbstractControlBean
    implements Exmnperiodlog {

    public ExmnperiodlogVO doCreate(ExmnperiodlogVO vo)
        throws Exception {
        try{
			ExmnperiodlogDAO dao = (ExmnperiodlogDAO) DAOFactory.build(ExmnperiodlogDAO.class, user);
            // TODO  set the pk */
            return (ExmnperiodlogVO) dao.create(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public void doRemove(ExmnperiodlogVO vo)
        throws Exception {
        try{
			ExmnperiodlogDAO dao = (ExmnperiodlogDAO) DAOFactory.build(ExmnperiodlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public ExmnperiodlogVO doUpdate(ExmnperiodlogVO vo)
        throws Exception {
        try{
			ExmnperiodlogDAO dao = (ExmnperiodlogDAO) DAOFactory.build(ExmnperiodlogDAO.class, user);
            return (ExmnperiodlogVO) dao.update(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public ExmnperiodlogVO doFindByPk(Serializable pk)
        throws Exception {
			ExmnperiodlogDAO dao = (ExmnperiodlogDAO) DAOFactory.build(ExmnperiodlogDAO.class, user);
        return (ExmnperiodlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExmnperiodlogListVO params)
        throws Exception {
			ExmnperiodlogDAO dao = (ExmnperiodlogDAO) DAOFactory.build(ExmnperiodlogDAO.class, user);
        return dao.query(params);
    }
}
