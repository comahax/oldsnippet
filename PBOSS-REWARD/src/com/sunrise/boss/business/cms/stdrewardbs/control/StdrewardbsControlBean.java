/**
 * auto-generated code
 * Thu Feb 14 10:50:04 CST 2008
 */
package com.sunrise.boss.business.cms.stdrewardbs.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardDAO;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardVO;
import com.sunrise.boss.business.cms.stdrewardbs.persistent.StdrewardbsDAO;
import com.sunrise.boss.business.cms.stdrewardbs.persistent.StdrewardbsListVO;
import com.sunrise.boss.business.cms.stdrewardbs.persistent.StdrewardbsVO;
import com.sunrise.boss.business.cms.stdrewardbs.persistent.StdrewardbsdVO;
import com.sunrise.boss.business.cms.stdrewardbs.persistent.V_StdrewardbsDAO;
import com.sunrise.boss.business.cms.stdrewardbs.persistent.V_StdrewardbsVO;
import com.sunrise.boss.business.cms.stdrewardbss.persistent.StdrewardbssDAO;
import com.sunrise.boss.business.cms.stdrewardbss.persistent.StdrewardbssListVO;
import com.sunrise.boss.business.cms.stdrewardbss.persistent.StdrewardbssVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: StdrewardbsControlBean
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
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/stdrewardbs/control/StdrewardbsControlBean"
 *           name="StdrewardbsControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class StdrewardbsControlBean extends AbstractControlBean implements
		StdrewardbsControl {

	public StdrewardVO doCreate(StdrewardVO vo, List list, User user)
			throws Exception {
		try {
			StdrewardDAO dao1 = (StdrewardDAO) DAOFactory.build(
					StdrewardDAO.class, user);
			StdrewardVO stdrewardVO = (StdrewardVO) dao1.create(vo);
			
			StdrewardbsDAO dao = (StdrewardbsDAO) DAOFactory.build(
					StdrewardbsDAO.class, user);
			List listvo = new ArrayList();
			listvo = list;
			Iterator it = listvo.iterator();
			Session session = SessionUtil.currentSession(dao.getDbFlag());
			while (it.hasNext()) {
				V_StdrewardbsVO unionVO = (V_StdrewardbsVO)it.next();
				StdrewardbsVO stdrewardbsVO=new StdrewardbsVO();
				BeanUtils.copyProperties(stdrewardbsVO, unionVO);
				stdrewardbsVO.setRewardid(stdrewardVO.getRewardid());
				stdrewardbsVO.setIslimt(new Short((short) 1));
				stdrewardbsVO.setIntvmonth(new Short((short) 0));
				session.clear();
				session.evict(unionVO);
				dao.create(stdrewardbsVO);
			}
			return stdrewardVO;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(StdrewardVO vo, User user) throws Exception {
		try {
			StdrewardDAO dao = (StdrewardDAO) DAOFactory.build(
					StdrewardDAO.class, user);
			dao.remove(vo);
//			StdrewardbsDAO dao1 = (StdrewardbsDAO) DAOFactory.build(
//					StdrewardbsDAO.class, user);
			// dao1.deleteStar(vo.getRewardid().toString());
			StdrewardbsListVO listvo = new StdrewardbsListVO();
			listvo.set_ne_rewardid(vo.getRewardid().toString());
			DataPackage pack = new DataPackage();
			pack = doQuery(listvo, user);
			List list = new ArrayList();
			list = pack.toList(StdrewardbsVO.class);
			Iterator it = list.iterator();
			Session session = SessionUtil.currentSession(dao.getDbFlag());
			while (it.hasNext()) {
				Object ob = it.next();
				session.clear();
				session.evict(ob);
				dao.remove(ob);
				
				// 删除逻辑 增加对星级专营销售酬金标准表（CH_PW_STDREWARDBSS）的关联。
				StdrewardbssListVO listsvo = new StdrewardbssListVO();
				listsvo.set_ne_rewardid(vo.getRewardid().toString());
				listsvo.set_se_region(((StdrewardbsVO)ob).getRegion());
				DataPackage dp = new DataPackage();
				dp = doStdrewardbssQuery(listsvo, user);
				List lists = new ArrayList();
				lists = dp.toList(StdrewardbssVO.class);
				Iterator its = lists.iterator();
				Session sessions = SessionUtil.currentSession(dao.getDbFlag());
				while (its.hasNext()) {
					Object obs = its.next();
					sessions.clear();
					sessions.evict(obs);
					dao.remove(obs);
				}
			}
			
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public StdrewardVO doUpdate(StdrewardVO vo, List list, User user)
			throws Exception {
		try {
			StdrewardDAO dao1 = (StdrewardDAO) DAOFactory.build(
					StdrewardDAO.class, user);
			StdrewardVO stdrewardVO = (StdrewardVO) dao1.update(vo);
			
			StdrewardbsDAO dao = (StdrewardbsDAO) DAOFactory.build(
					StdrewardbsDAO.class, user);
			// dao.deleteStar(vo.getRewardid().toString());
			StdrewardbsListVO stdrewardbsListVO = new StdrewardbsListVO();
			stdrewardbsListVO.set_ne_rewardid(vo.getRewardid().toString());
			stdrewardbsListVO.set_ne_islimt("1");
			List listvo = new ArrayList();
			listvo = list;
			Iterator it = listvo.iterator();
			Session session = SessionUtil.currentSession(dao.getDbFlag());
			while (it.hasNext()) {
				DataPackage pack = new DataPackage();
				StdrewardbsVO stdrewardbsVO=new StdrewardbsVO();
				V_StdrewardbsVO ob = (V_StdrewardbsVO) it.next();
				if(ob.getCitystd2().doubleValue()==-1.0&&ob.getCountrystd2().doubleValue()==-1.0){
					stdrewardbsListVO.set_se_region(ob.getRegion());
					stdrewardbsListVO.set_ne_islimt("0");
					pack = dao.query(stdrewardbsListVO);
					session.clear();
					session.evict(ob);
					if (pack.getDatas().size() > 0) {
						BeanUtils.copyProperties(stdrewardbsVO, ob);
						stdrewardbsVO.setIslimt(new Short((short) 0));
						dao.remove(stdrewardbsVO);
					}
				}
				stdrewardbsListVO.set_ne_islimt("1");
				stdrewardbsListVO.set_se_region(ob.getRegion());
				pack = dao.query(stdrewardbsListVO);
				session.clear();
				session.evict(ob);
				if (pack.getDatas().size() > 0) {
					BeanUtils.copyProperties(stdrewardbsVO, ob);
					stdrewardbsVO.setIslimt(new Short((short) 1));
					dao.update(stdrewardbsVO);
				} else {
					BeanUtils.copyProperties(stdrewardbsVO, ob);
					stdrewardbsVO.setIslimt(new Short((short) 1));
					stdrewardbsVO.setIntvmonth(new Short((short) 0));
					dao.create(stdrewardbsVO);
				}
			}
			
			DataPackage packdel = new DataPackage();
			StdrewardbsListVO stdrewardbsListVO1 = new StdrewardbsListVO();
			List listvodel = new ArrayList();
			stdrewardbsListVO1.set_ne_rewardid(vo.getRewardid().toString());
			packdel = dao.query(stdrewardbsListVO1);
			listvodel = packdel.toList(StdrewardbsVO.class);
			Iterator packlist = listvodel.iterator();
			while(packlist.hasNext()) {
				StdrewardbsVO obj = (StdrewardbsVO) packlist.next();
				boolean flag = false;
				Iterator listob = list.iterator();     
				while(listob.hasNext()) {
					V_StdrewardbsVO objvo = (V_StdrewardbsVO) listob.next();
					if(obj.getRegion().equals(objvo.getRegion())){
						flag = true;
					}
				}
				if(!flag) {
					session.clear();
					session.evict(obj);
					dao.remove(obj);
				}
			}
			return stdrewardVO;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public StdrewardbsdVO doUpdatestar(StdrewardbsdVO vo, User user)
			throws Exception {
		try {
			StdrewardbsdVO stdrewardbsdVO = new StdrewardbsdVO();
			StdrewardbsVO stdrewardbsVO = new StdrewardbsVO();
			StdrewardbsVO stdrewardbsVO1 = new StdrewardbsVO();
			stdrewardbsVO = vo.getStdrewardbsVO();
			StdrewardDAO dao1 = (StdrewardDAO) DAOFactory.build(
					StdrewardDAO.class, user);
			StdrewardVO stdrewardVO = (StdrewardVO) dao1.update(vo
					.getStdrewardVO());
			stdrewardbsdVO.setStdrewardVO(stdrewardVO);
			StdrewardbsDAO dao = (StdrewardbsDAO) DAOFactory.build(
					StdrewardbsDAO.class, user);
			if ("1".equals(stdrewardbsVO.getIslimt().toString())) {
				stdrewardbsVO.setIslimt(new Short((short) 0));
				stdrewardbsVO1 = (StdrewardbsVO) dao.create(stdrewardbsVO);
			} else {
				stdrewardbsVO1 = (StdrewardbsVO) dao.update(stdrewardbsVO);
			}
			stdrewardbsdVO.setStdrewardbsVO(stdrewardbsVO1);
			return stdrewardbsdVO;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public StdrewardbsdVO doFindByPk(Serializable pk, User user)
			throws Exception {
		try {
			StdrewardbsdVO ob = (StdrewardbsdVO) pk;
			StdrewardbsdVO stdrewardbsdVO = new StdrewardbsdVO();
			//DataPackage pack = new DataPackage();
			StdrewardbsListVO listvo = new StdrewardbsListVO();
			StdrewardbsVO stdrewardbsVO = new StdrewardbsVO();
			StdrewardVO stdrewardVO = new StdrewardVO();
			stdrewardVO = ob.getStdrewardVO();
			stdrewardbsVO = ob.getStdrewardbsVO();
			StdrewardDAO dao = (StdrewardDAO) DAOFactory.build(
					StdrewardDAO.class, user);
			stdrewardVO = (StdrewardVO) dao.findByPk(stdrewardVO.getRewardid());
			stdrewardbsdVO.setStdrewardVO(stdrewardVO);
			V_StdrewardbsDAO dao1 = (V_StdrewardbsDAO) DAOFactory.build(
					V_StdrewardbsDAO.class, user);
			listvo.set_ne_islimt(stdrewardbsVO.getIslimt().toString());
			listvo.set_ne_rewardid(stdrewardbsVO.getRewardid().toString());
			if ("0".equals(stdrewardbsVO.getIslimt().toString())) {
				stdrewardbsVO.setIslimt(new Short((short) 0));
				stdrewardbsVO.setRegion(user.getCityid());
				stdrewardbsVO = (StdrewardbsVO) dao.findByPk(stdrewardbsVO);
				stdrewardbsdVO.setStdrewardbsVO(stdrewardbsVO);
			} else {
				StdrewardbsListVO listvo1 = new StdrewardbsListVO();
				//pack = dao1.query(listvo);
				//listvo.set_ne_islimt(null);
				listvo1.set_ne_rewardid(listvo.get_ne_rewardid());
				DataPackage unionPack=dao1.unionQuery(listvo1);
				stdrewardbsdVO.setPack(unionPack);
			}
			return stdrewardbsdVO;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public StdrewardbsdVO doFindByPkcity(Serializable pk, User user)
			throws Exception {
		try {
			StdrewardbsdVO ob = (StdrewardbsdVO) pk;
			StdrewardbsdVO stdrewardbsdVO = new StdrewardbsdVO();
			;
			StdrewardbsVO stdrewardbsVO = new StdrewardbsVO();
			StdrewardVO stdrewardVO = new StdrewardVO();
			stdrewardVO = ob.getStdrewardVO();
			stdrewardbsVO = ob.getStdrewardbsVO();
			StdrewardDAO dao = (StdrewardDAO) DAOFactory.build(
					StdrewardDAO.class, user);
			stdrewardVO = (StdrewardVO) dao.findByPk(stdrewardVO.getRewardid());
			stdrewardbsdVO.setStdrewardVO(stdrewardVO);
			StdrewardbsDAO dao1 = (StdrewardbsDAO) DAOFactory.build(
					StdrewardbsDAO.class, user);
			stdrewardbsVO.setRegion(user.getCityid());
			stdrewardbsVO = (StdrewardbsVO) dao1.findByPk(stdrewardbsVO);
			stdrewardbsdVO.setStdrewardbsVO(stdrewardbsVO);
			return stdrewardbsdVO;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public StdrewardbsVO doCheck(Serializable pk, User user) throws Exception {
		try {

			StdrewardbsDAO dao = (StdrewardbsDAO) DAOFactory.build(
					StdrewardbsDAO.class, user);
			return (StdrewardbsVO) dao.findByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public DataPackage doQuery(StdrewardbsListVO params, User user)
			throws Exception {
		StdrewardbsDAO dao = (StdrewardbsDAO) DAOFactory.build(
				StdrewardbsDAO.class, user);
		return dao.query(params);
	}
	
	public DataPackage doStdrewardbssQuery(StdrewardbssListVO params, User user)
			throws Exception {
		StdrewardbssDAO dao = (StdrewardbssDAO) DAOFactory.build(
				StdrewardbssDAO.class, user);
		return dao.query(params);
	}
}
