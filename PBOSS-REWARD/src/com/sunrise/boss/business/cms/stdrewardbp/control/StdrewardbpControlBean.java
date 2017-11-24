/**
 * auto-generated code
 * Fri Feb 01 18:09:59 CST 2008
 */
package com.sunrise.boss.business.cms.stdrewardbp.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardDAO;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardVO;
import com.sunrise.boss.business.cms.stdrewardbp.persistent.StdrewardbpDAO;
import com.sunrise.boss.business.cms.stdrewardbp.persistent.StdrewardbpListVO;
import com.sunrise.boss.business.cms.stdrewardbp.persistent.StdrewardbpVO;
import com.sunrise.boss.business.cms.stdrewardbp.persistent.StdrewardbpdVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: StdrewardbpControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/stdrewardbp/control/StdrewardbpControlBean"
 *           name="StdrewardbpControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class StdrewardbpControlBean extends AbstractControlBean implements
		StdrewardbpControl {

	public StdrewardbpdVO doCreate(StdrewardbpdVO vo, User user)
			throws Exception {
		try {
			StdrewardbpdVO stdrewardbpdVO = new StdrewardbpdVO();
			StdrewardbpVO stdrewardbpVO = new StdrewardbpVO();
			StdrewardDAO dao1 = (StdrewardDAO) DAOFactory.build(
					StdrewardDAO.class, user);
			stdrewardbpdVO.setStdrewardVO((StdrewardVO) dao1.create(vo
					.getStdrewardVO()));
			stdrewardbpVO = vo.getStdrewardbpVO();
			stdrewardbpVO.setRewardid(stdrewardbpdVO.getStdrewardVO()
					.getRewardid());
			StdrewardbpDAO dao = (StdrewardbpDAO) DAOFactory.build(
					StdrewardbpDAO.class, user);
			stdrewardbpdVO.setStdrewardbpVO((StdrewardbpVO) dao
					.create(stdrewardbpVO));

			return stdrewardbpdVO;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(StdrewardbpdVO vo, User user) throws Exception {
		try {
			StdrewardDAO dao1 = (StdrewardDAO) DAOFactory.build(
					StdrewardDAO.class, user);
			dao1.remove(vo.getStdrewardVO());
			StdrewardbpDAO dao = (StdrewardbpDAO) DAOFactory.build(
					StdrewardbpDAO.class, user);
			//dao.deleteBp(vo.getStdrewardbpVO().getRewardid().toString());
			 StdrewardbpListVO listvo = new StdrewardbpListVO();
			 listvo.set_ne_rewardid(vo.getStdrewardbpVO().getRewardid().toString());
			 DataPackage pack = new DataPackage();
			 pack = doQuery(listvo,user);
			 List list = new ArrayList();
			 list = pack.toList(StdrewardbpVO.class);
			 Iterator it = list.iterator();
			 Session session=SessionUtil.currentSession(dao.getDbFlag());
			 while(it.hasNext()){
			 Object ob=it.next();
			 session.clear();
			 session.evict(ob);
			 dao.remove(ob);
			 }
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public StdrewardbpdVO doUpdate(StdrewardbpdVO vo, User user)
			throws Exception {
		try {
			StdrewardbpdVO stdrewardbpdVO = new StdrewardbpdVO();
			StdrewardbpVO stdrewardbpVO = new StdrewardbpVO();
			StdrewardDAO dao1 = (StdrewardDAO) DAOFactory.build(
					StdrewardDAO.class, user);
			stdrewardbpdVO.setStdrewardVO((StdrewardVO) dao1.update(vo
					.getStdrewardVO()));

			stdrewardbpVO = vo.getStdrewardbpVO();
			StdrewardbpDAO dao = (StdrewardbpDAO) DAOFactory.build(
					StdrewardbpDAO.class, user);
			stdrewardbpdVO.setStdrewardbpVO((StdrewardbpVO) dao
					.update(stdrewardbpVO));

			return stdrewardbpdVO;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public StdrewardbpdVO doUpdate1(StdrewardbpdVO vo, User user)
			throws Exception {
		try {
			StdrewardbpdVO stdrewardbpdVO = new StdrewardbpdVO();
			StdrewardbpVO stdrewardbpVO = new StdrewardbpVO();
			stdrewardbpVO = vo.getStdrewardbpVO();
			stdrewardbpVO.setRegion(user.getCityid());
			StdrewardbpDAO dao = (StdrewardbpDAO) DAOFactory.build(
					StdrewardbpDAO.class, user);
			if(dao.selectBp(stdrewardbpVO.getRewardid().toString(), stdrewardbpVO.getRegion())>0) {
				stdrewardbpVO =(StdrewardbpVO) dao.update(stdrewardbpVO); 
			}else{
				stdrewardbpVO=(StdrewardbpVO) dao.create(stdrewardbpVO);
			}
			stdrewardbpdVO.setStdrewardbpVO(stdrewardbpVO);
			stdrewardbpdVO.setStdrewardVO(vo.getStdrewardVO()); 
			return stdrewardbpdVO;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public StdrewardbpdVO doFindByPk(Serializable pk, User user)
			throws Exception {
		StdrewardbpdVO stdrewardbpdVO = new StdrewardbpdVO();
		StdrewardbpVO stdrewardbpVO = new StdrewardbpVO();
		StdrewardVO stdrewardVO = new StdrewardVO();
		stdrewardbpVO = ((StdrewardbpdVO) pk).getStdrewardbpVO();
		stdrewardVO = ((StdrewardbpdVO) pk).getStdrewardVO();
		StdrewardDAO dao1 = (StdrewardDAO) DAOFactory.build(StdrewardDAO.class,
				user);
		stdrewardbpdVO.setStdrewardVO((StdrewardVO) dao1.findByPk(stdrewardVO
				.getRewardid()));

		StdrewardbpDAO dao = (StdrewardbpDAO) DAOFactory.build(
				StdrewardbpDAO.class, user);
		stdrewardbpdVO.setStdrewardbpVO((StdrewardbpVO) dao
				.findByPk(stdrewardbpVO));

		return stdrewardbpdVO;
	}

	public StdrewardbpVO doFindByPkstar(Serializable pk, User user)
			throws Exception {
		StdrewardbpDAO dao = (StdrewardbpDAO) DAOFactory.build(
				StdrewardbpDAO.class, user);
		return (StdrewardbpVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(StdrewardbpListVO params, User user)
			throws Exception {
		StdrewardbpDAO dao = (StdrewardbpDAO) DAOFactory.build(
				StdrewardbpDAO.class, user);
		return dao.query(params);
	}
}
