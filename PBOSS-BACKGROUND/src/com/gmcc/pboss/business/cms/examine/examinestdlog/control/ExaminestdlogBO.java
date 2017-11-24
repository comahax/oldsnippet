package com.gmcc.pboss.business.cms.examine.examinestdlog.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.examinestdlog.persistent.ExaminestdlogDAO;
import com.gmcc.pboss.business.cms.examine.examinestdlog.persistent.ExaminestdlogListVO;
import com.gmcc.pboss.business.cms.examine.examinestdlog.persistent.ExaminestdlogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ExaminestdlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examinestdlog/control/ExaminestdlogControlBean"
 name="ExaminestdlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExaminestdlogBO extends AbstractControlBean
    implements Examinestdlog {

    public ExaminestdlogVO doCreate(ExaminestdlogVO vo)
        throws Exception {
        try{
			ExaminestdlogDAO dao = (ExaminestdlogDAO) DAOFactory.build(ExaminestdlogDAO.class, user);
            // TODO  set the pk */
            return (ExaminestdlogVO) dao.create(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public void doRemove(ExaminestdlogVO vo)
        throws Exception {
        try{
			ExaminestdlogDAO dao = (ExaminestdlogDAO) DAOFactory.build(ExaminestdlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public ExaminestdlogVO doUpdate(ExaminestdlogVO vo)
        throws Exception {
        try{
			ExaminestdlogDAO dao = (ExaminestdlogDAO) DAOFactory.build(ExaminestdlogDAO.class, user);
            return (ExaminestdlogVO) dao.update(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public ExaminestdlogVO doFindByPk(Serializable pk)
        throws Exception {
			ExaminestdlogDAO dao = (ExaminestdlogDAO) DAOFactory.build(ExaminestdlogDAO.class, user);
        return (ExaminestdlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExaminestdlogListVO params)
        throws Exception {
			ExaminestdlogDAO dao = (ExaminestdlogDAO) DAOFactory.build(ExaminestdlogDAO.class, user);
        return dao.query(params);
    }
}
