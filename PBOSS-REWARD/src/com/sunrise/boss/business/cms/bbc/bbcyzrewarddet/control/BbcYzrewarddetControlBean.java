/**
* auto-generated code
* Mon Nov 16 17:27:59 CST 2009
*/
package com.sunrise.boss.business.cms.bbc.bbcyzrewarddet.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.bbcyzrewarddet.persistent.BbcYzrewarddetVO;
import com.sunrise.boss.business.cms.bbc.bbcyzrewarddet.persistent.BbcYzrewarddetDAO;
import com.sunrise.boss.business.cms.bbc.bbcyzrewarddet.persistent.BbcYzrewarddetListVO;

/**
 * <p>Title: BbcYzrewarddetControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/bbcyzrewarddet/control/BbcYzrewarddetControlBean"
 name="BbcYzrewarddetControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BbcYzrewarddetControlBean extends AbstractControlBean
    implements BbcYzrewarddetControl {

    public BbcYzrewarddetVO doCreate(BbcYzrewarddetVO vo, User user)
        throws Exception {
        try{
			BbcYzrewarddetDAO dao = (BbcYzrewarddetDAO) DAOFactory.build(BbcYzrewarddetDAO.class, user);
            // TODO  set the pk */
            return (BbcYzrewarddetVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(BbcYzrewarddetVO vo, User user)
        throws Exception {
        try{
			BbcYzrewarddetDAO dao = (BbcYzrewarddetDAO) DAOFactory.build(BbcYzrewarddetDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BbcYzrewarddetVO doUpdate(BbcYzrewarddetVO vo, User user)
        throws Exception {
        try{
			BbcYzrewarddetDAO dao = (BbcYzrewarddetDAO) DAOFactory.build(BbcYzrewarddetDAO.class, user);
            return (BbcYzrewarddetVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BbcYzrewarddetVO doFindByPk(Serializable pk, User user)
        throws Exception {
			BbcYzrewarddetDAO dao = (BbcYzrewarddetDAO) DAOFactory.build(BbcYzrewarddetDAO.class, user);
        return (BbcYzrewarddetVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(BbcYzrewarddetListVO params, User user)
        throws Exception {
			BbcYzrewarddetDAO dao = (BbcYzrewarddetDAO) DAOFactory.build(BbcYzrewarddetDAO.class, user);
        return dao.query(params);
    }
}
