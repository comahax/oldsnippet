/**
* auto-generated code
* Mon Jan 09 14:26:52 CST 2012
*/
package com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.persistent.BbcRewardrecord2DAO;
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.persistent.BbcRewardrecord2ListVO;
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.persistent.BbcRewardrecord2VO;
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.persistent.VBbcRewardrecord2DAO;
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.persistent.VBbcRewardrecord2ListVO;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordDAO;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordListVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BbcRewardrecord2ControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/bbcrewardrecord2/control/BbcRewardrecord2ControlBean"
 name="BbcRewardrecord2Control"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BbcRewardrecord2ControlBean extends AbstractControlBean
    implements BbcRewardrecord2Control {

    public BbcRewardrecord2VO doCreate(BbcRewardrecord2VO vo, User user)
        throws Exception {
        try{
			BbcRewardrecord2DAO dao = (BbcRewardrecord2DAO) DAOFactory.build(BbcRewardrecord2DAO.class, user);
            // TODO  set the pk */
            return (BbcRewardrecord2VO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(BbcRewardrecord2VO vo, User user)
        throws Exception {
        try{
			BbcRewardrecord2DAO dao = (BbcRewardrecord2DAO) DAOFactory.build(BbcRewardrecord2DAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BbcRewardrecord2VO doUpdate(BbcRewardrecord2VO vo, User user)
        throws Exception {
        try{
			BbcRewardrecord2DAO dao = (BbcRewardrecord2DAO) DAOFactory.build(BbcRewardrecord2DAO.class, user);
            return (BbcRewardrecord2VO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BbcRewardrecord2VO doFindByPk(Serializable pk, User user)
        throws Exception {
			BbcRewardrecord2DAO dao = (BbcRewardrecord2DAO) DAOFactory.build(BbcRewardrecord2DAO.class, user);
        return (BbcRewardrecord2VO) dao.findByPk(pk);
    }
    
    public DataPackage doQuery(BbcRewardrecord2ListVO params, User user)
    	throws Exception {
    	BbcRewardrecord2DAO dao = (BbcRewardrecord2DAO) DAOFactory.build(BbcRewardrecord2DAO.class, user);
    	return dao.query(params);
    }
    
    public DataPackage doQuery2(BbcRewardrecord2ListVO params, User user)
		throws Exception {
    		BbcRewardrecord2DAO dao = (BbcRewardrecord2DAO) DAOFactory.build(BbcRewardrecord2DAO.class, user);
    	return dao.queryByNamedSqlQuery("boss.cms.bbc.bbcrewardrecord2.sqlquery", params);
}
    public DataPackage doQuery4ThreadTotal(BbcRewardrecord2ListVO params, User user)
	throws Exception {
		BbcRewardrecord2DAO dao = (BbcRewardrecord2DAO) DAOFactory.build(BbcRewardrecord2DAO.class, user);
//	return dao.queryByNamedSqlQuery("boss.cms.bbc.bbcrewardrecord2.sqlquery", params);
	return dao.doQuery4ThreadTotal(params,user);
}
	public DataPackage doQuery3(BbcRewardrecord2ListVO params, User user)
			throws Exception {
		// TODO Auto-generated method stub
		VBbcRewardrecord2DAO  dao=(VBbcRewardrecord2DAO)DAOFactory.build(VBbcRewardrecord2DAO.class, user);
		VBbcRewardrecord2ListVO listVO=new VBbcRewardrecord2ListVO();
		BeanUtils.copyProperties(listVO, params);
		return dao.doQuerycnt(listVO,user);
	}

}
