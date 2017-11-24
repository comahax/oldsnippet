/**
* auto-generated code
* Fri Feb 15 15:21:19 CST 2008
*/
package com.sunrise.boss.business.cms.reward.busiload.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busiload.persistent.BusiloadVO;
import com.sunrise.boss.business.cms.reward.busiload.persistent.BusiloadDAO;
import com.sunrise.boss.business.cms.reward.busiload.persistent.BusiloadListVO;

/**
 * <p>Title: BusiloadControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author zeng jianxin
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/busiload/control/BusiloadControlBean"
 name="BusiloadControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BusiloadControlBean extends AbstractControlBean
    implements BusiloadControl {

    public BusiloadVO doCreate(BusiloadVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         BusiloadDAO dao = (BusiloadDAO) DAOFactory.build(BusiloadDAO.class, user);
            return (BusiloadVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(BusiloadVO vo, User user)
        throws Exception {
        try{
         BusiloadDAO dao = (BusiloadDAO) DAOFactory.build(BusiloadDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BusiloadVO doUpdate(BusiloadVO vo, User user)
        throws Exception {
        try{
         BusiloadDAO dao = (BusiloadDAO) DAOFactory.build(BusiloadDAO.class, user);
            return (BusiloadVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BusiloadVO doFindByPk(Serializable pk, User user)
        throws Exception {
         BusiloadDAO dao = (BusiloadDAO) DAOFactory.build(BusiloadDAO.class, user);
        return (BusiloadVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(BusiloadListVO params, User user)
        throws Exception {
         BusiloadDAO dao = (BusiloadDAO) DAOFactory.build(BusiloadDAO.class, user);
        return dao.query(params);
    }
}
