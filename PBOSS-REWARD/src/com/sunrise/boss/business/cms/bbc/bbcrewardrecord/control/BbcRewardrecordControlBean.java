/**
* auto-generated code
* Mon Dec 08 10:50:04 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.bbcrewardrecord.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.bbcrewardrecord.persistent.BbcRewardrecordDAO;
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord.persistent.BbcRewardrecordListVO;
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord.persistent.BbcRewardrecordVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BbcRewardrecordControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: SUNRISE Tech Ltd.</p>
 * @author Zhang Fengchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/bbcrewardrecord/control/BbcRewardrecordControlBean"
 name="BbcRewardrecordControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BbcRewardrecordControlBean extends AbstractControlBean
    implements BbcRewardrecordControl {

    public BbcRewardrecordVO doCreate(BbcRewardrecordVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
        	BbcRewardrecordDAO dao = (BbcRewardrecordDAO) DAOFactory.build(BbcRewardrecordDAO.class, user);
            return (BbcRewardrecordVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(BbcRewardrecordVO vo, User user)
        throws Exception {
        try{
        	BbcRewardrecordDAO dao = (BbcRewardrecordDAO) DAOFactory.build(BbcRewardrecordDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BbcRewardrecordVO doUpdate(BbcRewardrecordVO vo, User user)
        throws Exception {
        try{
        	BbcRewardrecordDAO dao = (BbcRewardrecordDAO) DAOFactory.build(BbcRewardrecordDAO.class, user);
            return (BbcRewardrecordVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BbcRewardrecordVO doFindByPk(Serializable pk, User user)
        throws Exception {
    	BbcRewardrecordDAO dao = (BbcRewardrecordDAO) DAOFactory.build(BbcRewardrecordDAO.class, user);
        return (BbcRewardrecordVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(BbcRewardrecordListVO params, User user)
        throws Exception {
    	BbcRewardrecordDAO dao = (BbcRewardrecordDAO) DAOFactory.build(BbcRewardrecordDAO.class, user);
        return dao.query(params);
    }
}
