/**
 * auto-generated code
 * Sat Feb 02 15:13:27 CST 2008
 */
package com.sunrise.boss.business.cms.reward.busyxplan.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.reward.busyxplan.persistent.BusyxplanDAO;
import com.sunrise.boss.business.cms.reward.busyxplan.persistent.BusyxplanListVO;
import com.sunrise.boss.business.cms.reward.busyxplan.persistent.BusyxplanVO;
import com.sunrise.boss.business.cms.reward.wayxplan.control.WayxplanControl;
import com.sunrise.boss.business.cms.reward.wayxplan.control.WayxplanControlBean;
import com.sunrise.boss.business.cms.reward.wayxplan.persistent.WayxplanVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BusyxplanControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/busyxplan/control/BusyxplanControlBean"
 name="BusyxplanControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
 */
public class BusyxplanControlBean extends AbstractControlBean implements
		BusyxplanControl {

	public BusyxplanVO doCreate(BusyxplanVO vo, User user) throws Exception {
		try {
			// TODO  set the pk */
			BusyxplanDAO dao = (BusyxplanDAO) DAOFactory.build(
					BusyxplanDAO.class, user); 
			//如果wayid有值,且在表中无此条记录,则插入ch_pw_wayxplan表.
			if ("WLAN".equals(vo.getPlanbusitype()) && null!=vo.getYxplanid()) {
					operateWayxplan(vo, user);
			}
			BusyxplanVO saveVO = (BusyxplanVO) dao.create(vo);
			//接回值供form显示.
			if ("WLAN".equals(vo.getPlanbusitype()) && null!=vo.getYxplanid()) {
				saveVO.setWayid(vo.getWayid());
			}
			return saveVO;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
	
	private void operateWayxplan(BusyxplanVO vo, User user) throws Exception{
		WayxplanControl WayxplanControl = (WayxplanControl) ControlFactory
		.build(WayxplanControlBean.class);
		WayxplanVO wayidvo = WayxplanControl.doFindByPk(vo.getYxplanid(), user);
		if(wayidvo==null){
			wayidvo = new WayxplanVO();
			wayidvo.setWayid(vo.getWayid());
			wayidvo.setYxplanid(vo.getYxplanid());
			WayxplanControl.doCreate(wayidvo, user);
		} else {
			//throw new Exception("营销方案编码已经存在!");
			wayidvo.setWayid(vo.getWayid());
			WayxplanControl.doUpdate(wayidvo, user);
		}
	}

	public void doRemove(BusyxplanVO vo, User user) throws Exception {
		try {
			BusyxplanDAO dao = (BusyxplanDAO) DAOFactory.build(
					BusyxplanDAO.class, user);
			dao.remove(vo);
			if("WLAN".equals(vo.getPlanbusitype())){
				removeWayxplan(vo, user);
			}
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public BusyxplanVO doUpdate(BusyxplanVO vo, User user) throws Exception {
		try {
			BusyxplanDAO dao = (BusyxplanDAO) DAOFactory.build(
					BusyxplanDAO.class, user);
//			//如果wayid有值,且在表中有此条记录,则更新ch_pw_wayxplan表,否则更新此条记录.
//			if ("WLAN".equals(vo.getPlanbusitype())  && null!=vo.getYxplanid()) {
//				operateWayxplan(vo, user);
//			}else{
//				removeWayxplan(vo, user);
//			}
			if (null != vo.getYxplanid()){
				if ("WLAN".equals(vo.getPlanbusitype())){
					operateWayxplan(vo, user);
				}else{
					removeWayxplan(vo, user);
				}
				
			}
			
			BusyxplanVO saveVO = (BusyxplanVO) dao.update(vo);
			//接回值供form显示.
			if ("WLAN".equals(vo.getPlanbusitype())  && null!=vo.getYxplanid()) {
				saveVO.setWayid(vo.getWayid());
			}else{
				saveVO.setWayid(null);
			}
			return saveVO;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
	
	private void removeWayxplan(BusyxplanVO vo, User user) throws Exception{
		WayxplanControl WayxplanControl = (WayxplanControl) ControlFactory
		.build(WayxplanControlBean.class);
		WayxplanVO wayidvo = WayxplanControl.doFindByPk(vo.getYxplanid(), user);
		if(wayidvo!=null){
			WayxplanControl.doRemove(wayidvo, user);
		}
	}

	public BusyxplanVO doFindByPk(Serializable pk, User user) throws Exception {
		BusyxplanDAO dao = (BusyxplanDAO) DAOFactory.build(BusyxplanDAO.class,
				user);
		return (BusyxplanVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BusyxplanListVO params, User user)
			throws Exception {
		BusyxplanDAO dao = (BusyxplanDAO) DAOFactory.build(BusyxplanDAO.class,
				user);
		return dao.query(params);
	}

	public DataPackage queryBusyxplan(BusyxplanListVO params, User user)
			throws Exception {
		BusyxplanDAO dao = (BusyxplanDAO) DAOFactory.build(BusyxplanDAO.class,
				user);
		return dao.queryBusyxplan(params);
	}
}
