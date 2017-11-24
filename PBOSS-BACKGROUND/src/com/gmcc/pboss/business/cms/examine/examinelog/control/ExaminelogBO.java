package com.gmcc.pboss.business.cms.examine.examinelog.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.examinelog.persistent.ExaminelogDAO;
import com.gmcc.pboss.business.cms.examine.examinelog.persistent.ExaminelogListVO;
import com.gmcc.pboss.business.cms.examine.examinelog.persistent.ExaminelogVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;


/**
 * <p>Title: ExaminelogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/examinelog/control/ExaminelogControlBean"
 name="ExaminelogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExaminelogBO extends AbstractControlBean
    implements Examinelog {

    public ExaminelogVO doCreate(ExaminelogVO vo)
        throws Exception {
        try{
			ExaminelogDAO dao = (ExaminelogDAO) DAOFactory.build(ExaminelogDAO.class, user);
            // TODO  set the pk */
            return (ExaminelogVO) dao.create(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public void doRemove(ExaminelogVO vo)
        throws Exception {
        try{
			ExaminelogDAO dao = (ExaminelogDAO) DAOFactory.build(ExaminelogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public ExaminelogVO doUpdate(ExaminelogVO vo)
        throws Exception {
        try{
			ExaminelogDAO dao = (ExaminelogDAO) DAOFactory.build(ExaminelogDAO.class, user);
            return (ExaminelogVO) dao.update(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public ExaminelogVO doFindByPk(Serializable pk)
        throws Exception {
			ExaminelogDAO dao = (ExaminelogDAO) DAOFactory.build(ExaminelogDAO.class, user);
        return (ExaminelogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExaminelogListVO params)
        throws Exception {
			ExaminelogDAO dao = (ExaminelogDAO) DAOFactory.build(ExaminelogDAO.class, user);
        return dao.query(params);
    }
}
