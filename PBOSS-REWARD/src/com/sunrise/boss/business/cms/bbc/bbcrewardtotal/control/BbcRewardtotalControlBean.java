/**
* auto-generated code
* Mon Dec 08 10:50:04 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.bbcrewardtotal.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.bbcrewardtotal.persistent.BbcRewardtotalDAO;
import com.sunrise.boss.business.cms.bbc.bbcrewardtotal.persistent.BbcRewardtotalListVO;
import com.sunrise.boss.business.cms.bbc.bbcrewardtotal.persistent.BbcRewardtotalVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BbcRewardtotalControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: SUNRISE Tech Ltd.</p>
 * @author Zhang Fengchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/bbcrewardtotal/control/BbcRewardtotalControlBean"
 name="BbcRewardtotalControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BbcRewardtotalControlBean extends AbstractControlBean
    implements BbcRewardtotalControl {

    public BbcRewardtotalVO doCreate(BbcRewardtotalVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
        	BbcRewardtotalDAO dao = (BbcRewardtotalDAO) DAOFactory.build(BbcRewardtotalDAO.class, user);
            return (BbcRewardtotalVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(BbcRewardtotalVO vo, User user)
        throws Exception {
        try{
        	BbcRewardtotalDAO dao = (BbcRewardtotalDAO) DAOFactory.build(BbcRewardtotalDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BbcRewardtotalVO doUpdate(BbcRewardtotalVO vo, User user)
        throws Exception {
        try{
        	BbcRewardtotalDAO dao = (BbcRewardtotalDAO) DAOFactory.build(BbcRewardtotalDAO.class, user);
            return (BbcRewardtotalVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BbcRewardtotalVO doFindByPk(Serializable pk, User user)
        throws Exception {
    	BbcRewardtotalDAO dao = (BbcRewardtotalDAO) DAOFactory.build(BbcRewardtotalDAO.class, user);
        return (BbcRewardtotalVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(BbcRewardtotalListVO params, User user)
        throws Exception {
    	BbcRewardtotalDAO dao = (BbcRewardtotalDAO) DAOFactory.build(BbcRewardtotalDAO.class, user);
        return dao.query(params);
    }
}
