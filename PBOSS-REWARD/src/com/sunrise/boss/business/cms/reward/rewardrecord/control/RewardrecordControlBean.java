package com.sunrise.boss.business.cms.reward.rewardrecord.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeListVO;
import com.sunrise.boss.business.cms.provincialright.control.ProvincialrightControl;
import com.sunrise.boss.business.cms.provincialright.control.ProvincialrightControlBean;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordVO;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordDAO;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordListVO;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.VRewardrecordDAO;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.VRewardrecordListVO;


/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/reward/rewardrecord/control/RewardrecordControlBean"
 *           name="RewardrecordControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class RewardrecordControlBean extends AbstractControlBean implements
		RewardrecordControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7511162432728797986L;

	public RewardrecordVO doCreate(RewardrecordVO vo, User user)
			throws Exception {
		try {
			// TODO set the pk */
			RewardrecordDAO dao = (RewardrecordDAO) DAOFactory.build(
					RewardrecordDAO.class, user);
			return (RewardrecordVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(RewardrecordVO vo, User user) throws Exception {
		try {
			RewardrecordDAO dao = (RewardrecordDAO) DAOFactory.build(
					RewardrecordDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public RewardrecordVO doUpdate(RewardrecordVO vo, User user)
			throws Exception {
		try {
			RewardrecordDAO dao = (RewardrecordDAO) DAOFactory.build(
					RewardrecordDAO.class, user);
			return (RewardrecordVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public RewardrecordVO doFindByPk(Serializable pk, User user)
			throws Exception {
		RewardrecordDAO dao = (RewardrecordDAO) DAOFactory.build(
				RewardrecordDAO.class, user);
		return (RewardrecordVO) dao.findByPk(pk);
	}
	public DataPackage doQuery(RewardrecordListVO params, User user,String purview,String countyid)
		throws Exception {
		RewardrecordDAO dao = (RewardrecordDAO) DAOFactory.build(
				RewardrecordDAO.class, user);
		ProvincialrightControl provincialControl = (ProvincialrightControl)ControlFactory.build(ProvincialrightControlBean.class);//.buildBean(ProvincialrightControlBean.class);
		boolean flag = provincialControl.checkPurview(user, "CH_PW_REWARDCONF");
		return dao.doQuery(params,purview,countyid,flag);
	}
	
	public DataPackage doQuery2(RewardrecordListVO params, User user)
		throws Exception {
		RewardrecordDAO dao = (RewardrecordDAO) DAOFactory.build(
				RewardrecordDAO.class, user);
		return dao.queryByNamedSqlQuery("boss.cms.reward.rewardrecord.sqlquery", params);
	}
	
	public DataPackage doQuery4ThreadTotal(RewardrecordListVO params, User user)
	throws Exception {
	RewardrecordDAO dao = (RewardrecordDAO) DAOFactory.build(
			RewardrecordDAO.class, user);
//	return dao.queryByNamedSqlQuery("boss.cms.reward.rewardrecord.sqlquery", params);
	return dao.doQuery4ThreadTotal(params, user);
}
	
	public DataPackage doQuery3(RewardrecordListVO params, User user)throws Exception {
		VRewardrecordDAO dao = (VRewardrecordDAO) DAOFactory.build(
				VRewardrecordDAO.class, user);
		VRewardrecordListVO  listvo=new VRewardrecordListVO();
		BeanUtils.copyProperties(listvo, params);
		return dao.doQuerycnt(listvo, user);
	}
	
}
