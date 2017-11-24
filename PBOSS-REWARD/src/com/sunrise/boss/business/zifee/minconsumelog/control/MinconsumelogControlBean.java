/**
* auto-generated code
* Fri Aug 08 15:19:24 CST 2008
*/
package com.sunrise.boss.business.zifee.minconsumelog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.minconsumelog.persistent.MinconsumelogVO;
import com.sunrise.boss.business.zifee.minconsumelog.persistent.MinconsumelogDAO;
import com.sunrise.boss.business.zifee.minconsumelog.persistent.MinconsumelogListVO;

/**
 * <p>Title: MinconsumelogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/zifee/minconsumelog/control/MinconsumelogControlBean"
 name="MinconsumelogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class MinconsumelogControlBean extends AbstractControlBean
    implements MinconsumelogControl {

    public MinconsumelogVO doCreate(MinconsumelogVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         MinconsumelogDAO dao = (MinconsumelogDAO) DAOFactory.build(MinconsumelogDAO.class, user);
            return (MinconsumelogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(MinconsumelogVO vo, User user)
        throws Exception {
        try{
         MinconsumelogDAO dao = (MinconsumelogDAO) DAOFactory.build(MinconsumelogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public MinconsumelogVO doUpdate(MinconsumelogVO vo, User user)
        throws Exception {
        try{
         MinconsumelogDAO dao = (MinconsumelogDAO) DAOFactory.build(MinconsumelogDAO.class, user);
            return (MinconsumelogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public MinconsumelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
         MinconsumelogDAO dao = (MinconsumelogDAO) DAOFactory.build(MinconsumelogDAO.class, user);
        return (MinconsumelogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(MinconsumelogListVO params, User user)
        throws Exception {
         MinconsumelogDAO dao = (MinconsumelogDAO) DAOFactory.build(MinconsumelogDAO.class, user);
        return dao.query(params);
    }
}
