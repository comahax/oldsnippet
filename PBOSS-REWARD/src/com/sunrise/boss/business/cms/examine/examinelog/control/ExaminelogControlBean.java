/**
* auto-generated code
* Wed Nov 18 16:15:36 CST 2009
*/
package com.sunrise.boss.business.cms.examine.examinelog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.examinelog.persistent.ExaminelogVO;
import com.sunrise.boss.business.cms.examine.examinelog.persistent.ExaminelogDAO;
import com.sunrise.boss.business.cms.examine.examinelog.persistent.ExaminelogListVO;

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
public class ExaminelogControlBean extends AbstractControlBean
    implements ExaminelogControl {

    public ExaminelogVO doCreate(ExaminelogVO vo, User user)
        throws Exception {
        try{
			ExaminelogDAO dao = (ExaminelogDAO) DAOFactory.build(ExaminelogDAO.class, user);
            // TODO  set the pk */
            return (ExaminelogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ExaminelogVO vo, User user)
        throws Exception {
        try{
			ExaminelogDAO dao = (ExaminelogDAO) DAOFactory.build(ExaminelogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExaminelogVO doUpdate(ExaminelogVO vo, User user)
        throws Exception {
        try{
			ExaminelogDAO dao = (ExaminelogDAO) DAOFactory.build(ExaminelogDAO.class, user);
            return (ExaminelogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExaminelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ExaminelogDAO dao = (ExaminelogDAO) DAOFactory.build(ExaminelogDAO.class, user);
        return (ExaminelogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExaminelogListVO params, User user)
        throws Exception {
			ExaminelogDAO dao = (ExaminelogDAO) DAOFactory.build(ExaminelogDAO.class, user);
        return dao.query(params);
    }
}
