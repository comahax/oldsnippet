/**
 * auto-generated code
 * Wed Mar 05 16:41:04 CST 2008
 */
package com.sunrise.boss.business.cms.reward.stdrewardbj.control;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.sunrise.boss.business.cms.audit.common.CityIDMap;
import com.sunrise.boss.business.cms.reward.stdrewardbj.persistent.StdrewardbjDAO;
import com.sunrise.boss.business.cms.reward.stdrewardbj.persistent.StdrewardbjListVO;
import com.sunrise.boss.business.cms.reward.stdrewardbj.persistent.StdrewardbjVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjstar.persistent.StdrewardbjstarDAO;
import com.sunrise.boss.business.cms.reward.stdrewardbjstar.persistent.StdrewardbjstarListVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjstar.persistent.StdrewardbjstarVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjway.persistent.StdrewardbjwayDAO;
import com.sunrise.boss.business.cms.reward.stdrewardbjway.persistent.StdrewardbjwayListVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjway.persistent.StdrewardbjwayVO;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardDAO;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: StdrewardbjControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author Zhang Fengchao
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/reward/stdrewardbj/control/StdrewardbjControlBean"
 *           name="StdrewardbjControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class StdrewardbjControlBean extends AbstractControlBean implements
		StdrewardbjControl {
	public StdrewardbjVO doCreate(StdrewardbjVO vo, User user) throws Exception {
		try {
			StdrewardbjDAO dao = (StdrewardbjDAO) DAOFactory.build(
					StdrewardbjDAO.class, user);
			return (StdrewardbjVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(StdrewardbjVO vo, User user) throws Exception {
		try {
			StdrewardbjDAO dao = (StdrewardbjDAO) DAOFactory.build(
					StdrewardbjDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public StdrewardbjVO doUpdate(StdrewardbjVO vo, User user) throws Exception {
		try {
			StdrewardbjDAO dao = (StdrewardbjDAO) DAOFactory.build(
					StdrewardbjDAO.class, user);
			return (StdrewardbjVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public StdrewardbjVO doFindByPk(Serializable pk, User user)
			throws Exception {
		StdrewardbjDAO dao = (StdrewardbjDAO) DAOFactory.build(
				StdrewardbjDAO.class, user);
		return (StdrewardbjVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(StdrewardbjListVO params, User user)
			throws Exception {
		StdrewardbjDAO dao = (StdrewardbjDAO) DAOFactory.build(
				StdrewardbjDAO.class, user);
		return dao.query(params);
	}

	/**
	 * 计件酬金上限设置 保存
	 * 
	 * @param list
	 * @param user
	 * @throws Exception
	 */
	public void doSave(List list, User user) throws Exception {
		try {
			if (null == list || list.size() == 0) {
				return;
			}

			StdrewardbjDAO dao = (StdrewardbjDAO) DAOFactory.build(StdrewardbjDAO.class, user);
			StdrewardDAO stdrewardDAO = (StdrewardDAO) DAOFactory.build(StdrewardDAO.class, user);
			StdrewardbjstarDAO stdrewardbjstarDAO = (StdrewardbjstarDAO) DAOFactory.build(StdrewardbjstarDAO.class,user);
			StdrewardbjwayDAO stdrewardbjwayDAO = (StdrewardbjwayDAO) DAOFactory.build(StdrewardbjwayDAO.class,user);
			
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				StdrewardbjVO item = (StdrewardbjVO) iter.next();
				StdrewardVO stdrewardVO = new StdrewardVO();
				BeanUtils.copyProperties(stdrewardVO, item);

				//删除操作
				if (item.isDeletefalg()) {
					stdrewardDAO.remove(stdrewardVO);
					StdrewardbjVO stdrewardbjVO = new StdrewardbjVO();
					BeanUtils.copyProperties(stdrewardbjVO, item);
					stdrewardbjVO.setRewardid(stdrewardVO.getRewardid());
					dao.remove(stdrewardbjVO);
					this.doOperatorBy2G(stdrewardbjVO, user, DELETE);
					continue;
				}
				
				//新增或更新操作
				if (null == item.getRewardid()) {
					stdrewardVO = (StdrewardVO) stdrewardDAO.create(stdrewardVO);
				} else {
					stdrewardVO = (StdrewardVO) stdrewardDAO.update(stdrewardVO);
				}

				StdrewardbjVO stdrewardbjVO = new StdrewardbjVO();
				BeanUtils.copyProperties(stdrewardbjVO, item);
				stdrewardbjVO.setRewardid(stdrewardVO.getRewardid());
				if (null == item.getRewardid()) {
					stdrewardbjVO = (StdrewardbjVO) dao.create(stdrewardbjVO);
					//同步地市公司酬金标准
					StdrewardbjListVO listvo = new StdrewardbjListVO();
					listvo.getQueryConditions().put("_se_opnid", stdrewardbjVO.getOpnid());
					listvo.getQueryConditions().put("_se_ruleid", stdrewardbjVO.getRuleid());
					listvo.getQueryConditions().put("_sne_region", stdrewardbjVO.getRegion());
					listvo.set_pagesize("0");
					DataPackage dpBj = dao.query(listvo);
					if(dpBj.getDatas() != null && dpBj.getDatas().size() != 0){
						for(Iterator itt = dpBj.getDatas().iterator(); itt.hasNext();){
							StdrewardbjVO vo = (StdrewardbjVO)itt.next();
							dao.remove(vo);
							vo.setRewardid(stdrewardbjVO.getRewardid());
							dao.create(vo);
						}
					}
					
					//同步地市公司星级酬金标准
					StdrewardbjstarListVO starListvo = new StdrewardbjstarListVO();
					starListvo.getQueryConditions().put("_se_opnid", stdrewardbjVO.getOpnid());
					starListvo.getQueryConditions().put("_se_ruleid", stdrewardbjVO.getRuleid());
					starListvo.getQueryConditions().put("_sne_region", stdrewardbjVO.getRegion());
					starListvo.set_pagesize("0");
					DataPackage dpStar = stdrewardbjstarDAO.query(starListvo);
					if(dpStar.getDatas() != null && dpStar.getDatas().size() != 0){
						for(Iterator itt = dpStar.getDatas().iterator(); itt.hasNext();){
							StdrewardbjstarVO starvo = (StdrewardbjstarVO)itt.next();
							stdrewardbjstarDAO.remove(starvo);
							starvo.setRewardid(stdrewardbjVO.getRewardid());
							stdrewardbjstarDAO.create(starvo);
						}
					}
					
					//同步地市公司渠道酬金标准
					StdrewardbjwayListVO bjwayListvo = new StdrewardbjwayListVO();
					bjwayListvo.getQueryConditions().put("_se_opnid", stdrewardbjVO.getOpnid());
					bjwayListvo.getQueryConditions().put("_se_ruleid", stdrewardbjVO.getRuleid());
					bjwayListvo.getQueryConditions().put("_sne_region", stdrewardbjVO.getRegion());
					bjwayListvo.set_pagesize("0");
					DataPackage dpBjway = stdrewardbjwayDAO.query(bjwayListvo);
					if(dpBjway.getDatas() != null && dpBjway.getDatas().size() != 0){
						for(Iterator itt = dpBjway.getDatas().iterator(); itt.hasNext();){
							StdrewardbjwayVO bjwayvo = (StdrewardbjwayVO)itt.next();
							stdrewardbjwayDAO.remove(bjwayvo);
							bjwayvo.setRewardid(stdrewardbjVO.getRewardid());
							stdrewardbjwayDAO.create(bjwayvo);
						}
					}
					
					this.doOperatorBy2G(stdrewardbjVO, user, CREATE);
				} else {
					dao.update(stdrewardbjVO);
					this.doOperatorBy2G(stdrewardbjVO, user, UPDATE);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
	
	/**
	 * 市公司计件酬金上限设置 保存
	 * 
	 * @param list
	 * @param user
	 * @throws Exception
	 */
	public void doSavecity(List list, User user, List starList, List wayList) throws Exception {
		try {
			if (null == list || list.size() == 0) {
				return;
			}

			StdrewardbjDAO dao = (StdrewardbjDAO) DAOFactory.build(StdrewardbjDAO.class, user);
			StdrewardbjstarDAO starDao = (StdrewardbjstarDAO) DAOFactory.build(StdrewardbjstarDAO.class, user);
			StdrewardbjwayDAO bjwayDao = (StdrewardbjwayDAO) DAOFactory.build(StdrewardbjwayDAO.class, user);
			
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				StdrewardbjVO item = (StdrewardbjVO) iter.next();
				
				//删除操作
				if (item.isDeletefalg()) {
					StdrewardbjVO stdrewardbjVO = new StdrewardbjVO();
					BeanUtils.copyProperties(stdrewardbjVO, item);
					stdrewardbjVO.setRegion(user.getCityid());
					stdrewardbjVO = this.doFindByPk(stdrewardbjVO, user);
					if(stdrewardbjVO != null){
						this.doRemove(stdrewardbjVO, user);
						//清理starlist
						for(int i=0;i<starList.size();i++){
							StdrewardbjstarVO starvo = (StdrewardbjstarVO)starList.get(i);
							if(stdrewardbjVO.getRegion().equals(starvo.getRegion()) && stdrewardbjVO.getRewardid().equals(starvo.getRegion())
									&& stdrewardbjVO.getAcctype().equals(starvo.getAcctype()) && stdrewardbjVO.getRuleid().equals(starvo.getRuleid())
									&& stdrewardbjVO.getOpnid().equals(starvo.getOpnid())){
								starList.remove(i);
							}
						}
						//清理star表
						StdrewardbjstarListVO starlistvo = new StdrewardbjstarListVO();
						starlistvo.getQueryConditions().put("_se_opnid", stdrewardbjVO.getOpnid());
						starlistvo.getQueryConditions().put("_se_ruleid", stdrewardbjVO.getRuleid());
						starlistvo.getQueryConditions().put("_se_region", stdrewardbjVO.getRegion());
						starlistvo.getQueryConditions().put("_ne_rewardid", stdrewardbjVO.getRewardid());
						starlistvo.getQueryConditions().put("_ne_acctype", stdrewardbjVO.getAcctype());
						starlistvo.set_pagesize("0");
						DataPackage starDp = starDao.query(starlistvo);
						if(starDp.getDatas() != null && starDp.getDatas().size() != 0){
							for(Iterator itt = starDp.getDatas().iterator(); itt.hasNext();){
								StdrewardbjstarVO vo = (StdrewardbjstarVO)itt.next();
								starDao.remove(vo);
							}
						}
						
						//清理waylist
						for(int i=0;i<wayList.size();i++){
							StdrewardbjwayVO bjwayvo = (StdrewardbjwayVO)wayList.get(i);
							if(stdrewardbjVO.getRegion().equals(bjwayvo.getRegion()) && stdrewardbjVO.getRewardid().equals(bjwayvo.getRegion())
									&& stdrewardbjVO.getAcctype().equals(bjwayvo.getAcctype()) && stdrewardbjVO.getRuleid().equals(bjwayvo.getRuleid())
									&& stdrewardbjVO.getOpnid().equals(bjwayvo.getOpnid())){
								wayList.remove(i);
							}
						}
						//清理bjway表
						StdrewardbjwayListVO bjwaylistvo = new StdrewardbjwayListVO();
						bjwaylistvo.getQueryConditions().put("_se_opnid", stdrewardbjVO.getOpnid());
						bjwaylistvo.getQueryConditions().put("_se_ruleid", stdrewardbjVO.getRuleid());
						bjwaylistvo.getQueryConditions().put("_se_region", stdrewardbjVO.getRegion());
						bjwaylistvo.getQueryConditions().put("_ne_rewardid", stdrewardbjVO.getRewardid());
						bjwaylistvo.getQueryConditions().put("_ne_acctype", stdrewardbjVO.getAcctype());
						bjwaylistvo.set_pagesize("0");
						DataPackage bjwayDp = bjwayDao.query(bjwaylistvo);
						if(bjwayDp.getDatas() != null && bjwayDp.getDatas().size() != 0){
							for(Iterator itt = bjwayDp.getDatas().iterator(); itt.hasNext();){
								StdrewardbjwayVO vo = (StdrewardbjwayVO)itt.next();
								bjwayDao.remove(vo);
							}
						}
						
					}
					continue;
				}
				
				StdrewardbjVO vo = new StdrewardbjVO();
				vo.setRegion(user.getCityid());
				vo.setRewardid(item.getRewardid());
				vo = (StdrewardbjVO) dao.findByPk(vo);
				if (null == vo) {
					item.setRegion(user.getCityid());
					dao.create(item);
				} else {
					BeanUtils.copyProperties(vo, item);
					dao.update(vo);
				}
			}
			
			if(starList != null){
				for(Iterator itt = starList.iterator();itt.hasNext();){
					StdrewardbjstarVO starVO = (StdrewardbjstarVO) itt.next();
					if(starVO.isDeleteFlag()){
						starDao.remove(starVO);
					}else{
						if(starVO.isUpdateFlag()){
							starDao.update(starVO);
						}else{
							starDao.create(starVO);
						}
					}
				}
			}
			
			if(wayList != null){
				for(Iterator itt = wayList.iterator();itt.hasNext();){
					StdrewardbjwayVO bjwayVO = (StdrewardbjwayVO) itt.next();
					if(bjwayVO.isDeleteFlag()){
						starDao.remove(bjwayVO);
					}else{
						if(bjwayVO.isUpdateFlag()){
							starDao.update(bjwayVO);
						}else{
							starDao.create(bjwayVO);
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
	
	private final static int CREATE = 1;
	private final static int UPDATE = 2;
	private final static int DELETE = 3;
	
	private void doOperatorBy2G(StdrewardbjVO provVO, User user, int type) throws Exception {
		if(!provVO.getOpnid().trim().toString().substring(0, 4).equals("0403")){
			return ;
		}
		
		StdrewardbjDAO dao = (StdrewardbjDAO) DAOFactory.build(StdrewardbjDAO.class, user);
		switch(type){
			case CREATE:
				for(Iterator itt = CityIDMap.cityidMap.keySet().iterator(); itt.hasNext();){
					StdrewardbjVO cityVO = new StdrewardbjVO();
					BeanUtils.copyProperties(cityVO, provVO);
					cityVO.setRegion((String)itt.next());
					if(!"999".equals(cityVO.getRegion())){
						dao.create(cityVO);
					}
				}
				break;
			case UPDATE:
				StdrewardbjListVO updateListvo = new StdrewardbjListVO();
				updateListvo.set_pagesize("0");
				updateListvo.set_ne_rewardid(provVO.getRewardid().toString());
				DataPackage updateDp = dao.query(updateListvo);
				if(updateDp != null && updateDp.getDatas().size() != 0){
					for(Iterator itt = updateDp.getDatas().iterator(); itt.hasNext();){
						StdrewardbjVO cityVO = (StdrewardbjVO)itt.next();
						String cityid = cityVO.getRegion();
						BeanUtils.copyProperties(cityVO, provVO);
						cityVO.setRegion(cityid);
						if(!"999".equals(cityVO.getRegion())){
							dao.update(cityVO);
						}
					}
				}
				break;
			case DELETE:
				StdrewardbjListVO deleteListvo = new StdrewardbjListVO();
				deleteListvo.set_pagesize("0");
				deleteListvo.set_ne_rewardid(provVO.getRewardid().toString());
				DataPackage deleteDp = dao.query(deleteListvo);
				if(deleteDp != null && deleteDp.getDatas().size() != 0){
					for(Iterator itt = deleteDp.getDatas().iterator(); itt.hasNext();){
						StdrewardbjVO cityVO = (StdrewardbjVO)itt.next();
						if(!"999".equals(cityVO.getRegion())){
							dao.remove(cityVO);
						}
					}
				}
				break;
		}
	}
}
