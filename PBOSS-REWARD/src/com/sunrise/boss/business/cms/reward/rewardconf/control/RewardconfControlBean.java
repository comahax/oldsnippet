/**
 * auto-generated code
 * Fri Mar 06 14:15:03 CST 2009
 */
package com.sunrise.boss.business.cms.reward.rewardconf.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rewardconf.persistent.RewardconfVO;
import com.sunrise.boss.business.cms.reward.rewardconf.persistent.RewardconfDAO;
import com.sunrise.boss.business.cms.reward.rewardconf.persistent.RewardconfListVO;

/**
 * <p>Title: RewardconfControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/rewardconf/control/RewardconfControlBean"
 name="RewardconfControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
 */
public class RewardconfControlBean extends AbstractControlBean implements
		RewardconfControl {

	public RewardconfVO doCreate(RewardconfVO vo, User user) throws Exception {
		try {
			RewardconfDAO dao = (RewardconfDAO) DAOFactory.build(
					RewardconfDAO.class, user);
			// TODO  set the pk */
			return (RewardconfVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(RewardconfVO vo, User user) throws Exception {
		try {
			RewardconfDAO dao = (RewardconfDAO) DAOFactory.build(
					RewardconfDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public RewardconfVO doUpdate(RewardconfVO vo, User user) throws Exception {
		try {
			RewardconfDAO dao = (RewardconfDAO) DAOFactory.build(
					RewardconfDAO.class, user);
			return (RewardconfVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public RewardconfVO doFindByPk(Serializable pk, User user) throws Exception {
		RewardconfDAO dao = (RewardconfDAO) DAOFactory.build(
				RewardconfDAO.class, user);
		return (RewardconfVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RewardconfListVO params, User user)
			throws Exception {
		RewardconfDAO dao = (RewardconfDAO) DAOFactory.build(
				RewardconfDAO.class, user);
		return dao.query(params);
	}

	public List doCheckRewardconf(String rewardmonth,
			String rewardkind, User user) throws Exception {
		
		RewardconfVO confvo = new RewardconfVO();
		List list = new ArrayList();
		RewardconfListVO conflistvo = new RewardconfListVO();
		conflistvo.set_se_cityid(user.getCityid());
		conflistvo.set_se_rewardkind(rewardkind);
		conflistvo.set_se_rewardmonth(rewardmonth);
		conflistvo.set_se_state("1");
		
		DataPackage dp = doQuery(conflistvo, user);
		
		if(dp!=null||dp.getDatas().size()>0){
		Collection col=dp.getDatas();
		Iterator it=col.iterator();
		while(it.hasNext())
			{
			confvo=(RewardconfVO)it.next();
			list.add(confvo.getBatchno());
			}
		}
		return list;
	}
	
	public List doCheckUnRewardconf(String rewardmonth,
			String rewardkind, User user) throws Exception {
		RewardconfVO confvo = new RewardconfVO();
		List list = new ArrayList();
		RewardconfListVO conflistvo = new RewardconfListVO();
		conflistvo.set_se_cityid(user.getCityid());
		conflistvo.set_se_rewardkind(rewardkind);
		conflistvo.set_se_rewardmonth(rewardmonth);
		
		DataPackage dp = doQuery(conflistvo, user);
		if(dp!=null||dp.getDatas().size()>0){
			Collection col=dp.getDatas();
			Iterator it=col.iterator();
			while(it.hasNext())
				{
				confvo=(RewardconfVO)it.next();
				list.add(confvo.getBatchno());
				}
			}
		return list;
	}
}
