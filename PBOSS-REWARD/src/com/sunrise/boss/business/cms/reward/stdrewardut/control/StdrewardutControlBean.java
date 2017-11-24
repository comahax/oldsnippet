/**
 * auto-generated code
 * Fri Oct 08 14:53:45 CST 2010
 */
package com.sunrise.boss.business.cms.reward.stdrewardut.control;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;

import com.sunrise.boss.business.cms.reward.stdrewardut.persistent.StdrewardutDAO;
import com.sunrise.boss.business.cms.reward.stdrewardut.persistent.StdrewardutListVO;
import com.sunrise.boss.business.cms.reward.stdrewardut.persistent.StdrewardutVO;
import com.sunrise.boss.business.cms.reward.stdrewardut.persistent.VStdrewardutDAO;
import com.sunrise.boss.business.cms.reward.stdrewardut.persistent.VStdrewardutVO;
import com.sunrise.boss.business.cms.reward.vwaycompact.persistent.VwaycompactDAO;
import com.sunrise.boss.business.cms.reward.vwaycompact.persistent.VwaycompactVO;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardDAO;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardVO;
import com.sunrise.boss.business.cms.way.persistent.WayDAO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.delegate.cms.reward.stdrewardut.StdrewardutDelegate;
import com.sunrise.boss.delegate.cms.stdreward.StdrewardDelegate;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: StdrewardutControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/reward/stdrewardut/control/StdrewardutControlBean"
 *           name="StdrewardutControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class StdrewardutControlBean extends AbstractControlBean implements
		StdrewardutControl {

	public StdrewardutVO doCreate(StdrewardutVO vo, User user) throws Exception {
		try {
			StdrewardutDAO dao = (StdrewardutDAO) DAOFactory.build(
					StdrewardutDAO.class, user);
			// TODO set the pk */
			return (StdrewardutVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(StdrewardutVO vo, User user) throws Exception {
		try {
			StdrewardutDAO dao = (StdrewardutDAO) DAOFactory.build(
					StdrewardutDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public StdrewardutVO doUpdate(StdrewardutVO vo, User user) throws Exception {
		try {
			StdrewardutDAO dao = (StdrewardutDAO) DAOFactory.build(
					StdrewardutDAO.class, user);
			return (StdrewardutVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public StdrewardutVO doFindByPk(Serializable pk, User user)
			throws Exception {
		StdrewardutDAO dao = (StdrewardutDAO) DAOFactory.build(
				StdrewardutDAO.class, user);
		return (StdrewardutVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(StdrewardutListVO params, User user)
			throws Exception {
		StdrewardutDAO dao = (StdrewardutDAO) DAOFactory.build(
				StdrewardutDAO.class, user);
		return dao.query(params);
	}
	
	public DataPackage doQuerylist(StdrewardutListVO params, User user)
			throws Exception {
		VStdrewardutDAO dao = (VStdrewardutDAO) DAOFactory.build(
				VStdrewardutDAO.class, user);
		return dao.queryStdrewardut(params);
	}
	
	public DataPackage doQuerycitylist(StdrewardutListVO params, User user)
	throws Exception {
		VwaycompactDAO dao = (VwaycompactDAO) DAOFactory.build(
				VwaycompactDAO.class, user);
		DataPackage dp= dao.queryStdrewardutcity(params);
		Iterator it=dp.getDatas().iterator();
		StdrewardutDAO stdrewardutDAO = (StdrewardutDAO) DAOFactory.build(
				StdrewardutDAO.class, user);
		while(it.hasNext())
		{
			VwaycompactVO vo=(VwaycompactVO)it.next();
			String cityid = SessionFactoryRouter.conversionCityid2Num(vo.getCityid());
			StdrewardutListVO listVO=new StdrewardutListVO();
			listVO.set_se_wayid(vo.getWayid());
			listVO.set_se_region(cityid);
			if(stdrewardutDAO.query(listVO).getRowCount()>0)
			{
				vo.setSetflag("SET");
			}else
			{
				vo.setSetflag("NOTSET");
			}
			vo.setCityid(cityid);
		}
		
		return dp;
	}
	/**
	 * 新增
	 */
	public StdrewardutVO doBatchcreate(VStdrewardutVO vo, String[] selectcity,
			ArrayList list51, ArrayList list52, ArrayList list53, User user)
			throws Exception {
		boolean isValid = false;
		StdrewardutVO stdvo = new StdrewardutVO();
		StdrewardutListVO params = new StdrewardutListVO();
		StdrewardutDelegate delegate = new StdrewardutDelegate();
		try {
			for (int i = 0; i < selectcity.length; i++) {
				params.set_se_region(selectcity[i]);
				DataPackage dp = delegate.doQuerylist(params, user);
				if (dp != null && dp.getDatas().size() > 0) {
					isValid = false;
					break;
				} else {
					isValid = true;
				}
			}
			if (isValid) {
				for (int i = 0; i < selectcity.length; i++) {
					if(!"999".equals(selectcity[i])){
						this.doSaverecord(list51, selectcity[i], user);
						this.doSaverecord(list52, selectcity[i], user);
						this.doSaverecord(list53, selectcity[i], user);
					}
				}
			} else {
				throw new Exception("所选省公司酬金标准已存在!");
			}
		} catch (Exception e) {
			sessionContext.setRollbackOnly();
			throw e;
		}
		return stdvo;
	}

	/**
	 * 保存
	 * @param list
	 * @param city
	 * @param user
	 * @throws Exception
	 */
	public void doSaverecord(ArrayList list, String city, User user)
			throws Exception {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			StdrewardVO stdvo = new StdrewardVO();
			StdrewardutVO utvo = new StdrewardutVO();
			StdrewardDelegate stddelegate = new StdrewardDelegate();
			stdvo.setRewardname(list.get(0).toString());
			stdvo.setRewardtype(new Short(list.get(1).toString()));
			stdvo.setStartdate(format.parse(list.get(2).toString()));
			stdvo.setStopdate(format.parse(list.get(3).toString()));
			stdvo.setRewardproj(new Short("5"));
			stdvo.setMemo("");
			stdvo = stddelegate.doCreate(stdvo, user);
			utvo.setRewardid(stdvo.getRewardid());
			utvo.setRegion(city);
			utvo.setRewardstd(new Double(list.get(4).toString()));
			utvo.setIntvmonth(new Long(list.get(5).toString()));
			if (stdvo.getRewardtype() == 52) {
				utvo.setIntegralnum(new Long(list.get(6).toString()));
			}
			if (stdvo.getRewardtype() == 53) {
				utvo.setUnitprice(new Double(list.get(7).toString()));
			}
			utvo.setIslimt(new Short("0"));
			utvo.setWayid("DIS999");
			this.doCreate(utvo, user);
		} catch (Exception e) {
			sessionContext.setRollbackOnly();
			throw e;
		}

	}
	
	/**
	 * 更新
	 */
	public StdrewardutVO doBatchupdate(VStdrewardutVO vo, String[] selectcity,
			ArrayList list51, ArrayList list52, ArrayList list53, User user)
			throws Exception {
		StdrewardutVO stdutvo = new StdrewardutVO();
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			StdrewardutDelegate delegate = new StdrewardutDelegate();
			StdrewardutListVO params = new StdrewardutListVO();
			VStdrewardutVO contentVO = new VStdrewardutVO();
			StdrewardDAO stddao = (StdrewardDAO) DAOFactory.build(
					StdrewardDAO.class, user);
			StdrewardutDAO utdao = (StdrewardutDAO) DAOFactory.build(
					StdrewardutDAO.class, user);
			params.set_se_region(selectcity[0]);
			DataPackage dp = delegate.doQuerylist(params, user);
			if (dp.getRowCount() > 0) {
				for (Iterator it = dp.getDatas().iterator(); it.hasNext();) {
					StdrewardVO stdvo = new StdrewardVO();
					StdrewardutVO utvo = new StdrewardutVO();
					contentVO = (VStdrewardutVO) it.next();
					if (contentVO.getRewardtype() == 51) {
						stdvo.setRewardid(contentVO.getRewardid());
						stdvo.setRewardname(list51.get(0).toString());
						stdvo.setRewardtype(new Short(list51.get(1).toString()));
						stdvo.setStartdate(format.parse(list51.get(2).toString()));
						stdvo.setStopdate(format.parse(list51.get(3).toString()));
						utvo.setRewardid(contentVO.getRewardid());
						utvo.setRegion(contentVO.getRegion());
						utvo.setRewardstd(new Double(list51.get(4).toString()));
						utvo.setIntvmonth(new Long(list51.get(5).toString()));
					} else if (contentVO.getRewardtype() == 52) {
						stdvo.setRewardid(contentVO.getRewardid());
						stdvo.setRewardname(list52.get(0).toString());
						stdvo.setRewardtype(new Short(list52.get(1).toString()));
						stdvo.setStartdate(format.parse(list52.get(2).toString()));
						stdvo.setStopdate(format.parse(list52.get(3).toString()));
						utvo.setRewardid(contentVO.getRewardid());
						utvo.setRegion(contentVO.getRegion());
						utvo.setRewardstd(new Double(list52.get(4).toString()));
						utvo.setIntvmonth(new Long(list52.get(5).toString()));
						utvo.setIntegralnum(new Long(list52.get(6).toString()));
					} else if (contentVO.getRewardtype() == 53) {
						stdvo.setRewardid(contentVO.getRewardid());
						stdvo.setRewardname(list53.get(0).toString());
						stdvo.setRewardtype(new Short(list53.get(1).toString()));
						stdvo.setStartdate(format.parse(list53.get(2).toString()));
						stdvo.setStopdate(format.parse(list53.get(3).toString()));
						utvo.setRewardid(contentVO.getRewardid());
						utvo.setRegion(contentVO.getRegion());
						utvo.setRewardstd(new Double(list53.get(4).toString()));
						utvo.setIntvmonth(new Long(list53.get(5).toString()));
						utvo.setUnitprice(new Double(list53.get(7).toString()));
					}
					utvo.setIslimt(new Short("0"));
					utvo.setWayid("DIS999");
					stdvo.setRewardproj(new Short("5"));
					utdao.update(utvo);
					stddao.update(stdvo);
				}
			}

		} catch (Exception e) {
			sessionContext.setRollbackOnly();
			throw e;
		}
		return stdutvo;
	}

	/**
	 * 删除
	 */
	public void doBatchremove(ArrayList regionlist, User user) throws Exception {
		try {
			StdrewardVO stdvo = new StdrewardVO();
			StdrewardutVO utvo = new StdrewardutVO();
			VStdrewardutVO contentVO = new VStdrewardutVO();
			StdrewardutListVO utparams = new StdrewardutListVO();
			StdrewardutDelegate delegate = new StdrewardutDelegate();
			StdrewardDelegate stddelegate = new StdrewardDelegate();
			for (int i = 0; i < regionlist.size(); i++) {
				utparams.set_se_region(regionlist.get(i).toString());
				DataPackage dp = delegate.doQuerylist(utparams, user);
				if (dp.getRowCount() > 0) {
					for (Iterator it = dp.getDatas().iterator(); it.hasNext();) {
						contentVO = (VStdrewardutVO) it.next();
						stdvo.setRewardid(contentVO.getRewardid());
						utvo.setRewardid(contentVO.getRewardid());
						utvo.setWayid("DIS999");
						utvo.setRegion(contentVO.getRegion());
						delegate.doRemove(utvo, user);
						stddelegate.doRemove(stdvo, user);
					}
				}
			}
		} catch (Exception e) {
			sessionContext.setRollbackOnly();
			throw e;
		}
	}
	public StdrewardutVO doSavecity(StdrewardutVO stdrewardutVO, User user)throws Exception{
		//查询统一管理模式酬金标准表,看有没有已经存在的记录,如果有,则修改,否则新增.
//		StdrewardutVO returnVO=new StdrewardutVO();
		//新增/修改专营补贴酬金
		try{
		StdrewardutDAO mainDAO = (StdrewardutDAO) DAOFactory.build(
				StdrewardutDAO.class, user);
		StdrewardutVO pkvo=new StdrewardutVO();
		pkvo.setRegion(stdrewardutVO.getRegion());
		pkvo.setRewardid(stdrewardutVO.getRewardid_51());
		pkvo.setWayid(stdrewardutVO.getWayid());
		if(mainDAO.findByPk(pkvo)==null)
		{
			mainDAO.create(setSaveVO("51",stdrewardutVO));
		}else
		{
			Session session = SessionUtil.currentSession(mainDAO.getDbFlag());
			// session.evict(oldVO);
			StdrewardutVO newVO = (StdrewardutVO) session.merge(setSaveVO("51",stdrewardutVO));
			mainDAO.registerLog("update", newVO, user);
			session.flush();
		}
		//新增/修改销售达标酬金
		pkvo.setRewardid(stdrewardutVO.getRewardid_52());
		if(mainDAO.findByPk(pkvo)==null)
		{
			mainDAO.create(setSaveVO("52",stdrewardutVO));
		}
		else
		{
			Session session = SessionUtil.currentSession(mainDAO.getDbFlag());
			// session.evict(oldVO);
			StdrewardutVO newVO = (StdrewardutVO) session.merge(setSaveVO("52",stdrewardutVO));
			mainDAO.registerLog("update", newVO, user);
			session.flush();
		}
		//新增/修改销售超额酬金
		pkvo.setRewardid(stdrewardutVO.getRewardid_53());
		if(mainDAO.findByPk(pkvo)==null)
		{
			mainDAO.create(setSaveVO("53",stdrewardutVO));
		}
		else
		{
			Session session = SessionUtil.currentSession(mainDAO.getDbFlag());
			// session.evict(oldVO);
			StdrewardutVO newVO = (StdrewardutVO) session.merge(setSaveVO("53",stdrewardutVO));
			mainDAO.registerLog("update", newVO, user);
			session.flush();
		}
		}catch(Exception e){
			sessionContext.setRollbackOnly();
			throw e;
		}
		return stdrewardutVO;
	}
	private StdrewardutVO setSaveVO(String rewardtype,StdrewardutVO stdrewardutVO){
		StdrewardutVO saveVO=new StdrewardutVO();
		saveVO.setIslimt(new Short("1"));
		saveVO.setWayid(stdrewardutVO.getWayid());
		if("51".equals(rewardtype))
		{
			saveVO.setRewardid(stdrewardutVO.getRewardid_51());
			saveVO.setRewardstd(stdrewardutVO.getRewardstdcity_51());
			saveVO.setIntvmonth(stdrewardutVO.getIntvmonthcity_51());
			saveVO.setRegion(stdrewardutVO.getRegion());
		}else if("52".equals(rewardtype))
		{
			saveVO.setRewardid(stdrewardutVO.getRewardid_52());
			saveVO.setRewardstd(stdrewardutVO.getRewardstdcity_52());
			saveVO.setIntvmonth(stdrewardutVO.getIntvmonthcity_52());
			saveVO.setIntegralnum(stdrewardutVO.getIntegralnumcity_52());
			saveVO.setRegion(stdrewardutVO.getRegion());
			
		}else if("53".equals(rewardtype)){
			saveVO.setRewardid(stdrewardutVO.getRewardid_53());
			saveVO.setRewardstd(stdrewardutVO.getRewardstdcity_53());
			saveVO.setIntvmonth(stdrewardutVO.getIntvmonthcity_53());
			saveVO.setUnitprice(stdrewardutVO.getUnitpricecity_53());
			saveVO.setRegion(stdrewardutVO.getRegion());
		}
		return saveVO;
		
	}
	/**
	 * 地市删除数据
	 */
	public void doDeletecity(String wayid, User user) throws Exception {
		try {
			WayDAO wayDAO = (WayDAO) DAOFactory.build(WayDAO.class, user);
			WayVO wayVO=(WayVO)wayDAO.findByPk(wayid);
			String cityid=SessionFactoryRouter.conversionCityid(user.getCityid());
			if(!cityid.equals(wayVO.getCityid()))
			{
				throw new Exception("只能删除本地市的数据");
			}
			VStdrewardutDAO dao = (VStdrewardutDAO) DAOFactory.build(
					VStdrewardutDAO.class, user);
			StdrewardutDAO stdrewardutDAO = (StdrewardutDAO) DAOFactory.build(
					StdrewardutDAO.class, user);
			StdrewardutListVO params=new StdrewardutListVO();
			params.set_se_region(user.getCityid());
			DataPackage dp=dao.queryStdrewardut(params);
			Iterator it=dp.getDatas().iterator();
			while(it.hasNext()){
				VStdrewardutVO stdVO=(VStdrewardutVO)it.next();
				StdrewardutVO pkVO=new StdrewardutVO();
				//查询到省公司的REWARDID.
				pkVO.setWayid(wayid);
				pkVO.setRegion(stdVO.getRegion());
				pkVO.setRewardid(stdVO.getRewardid());
				if(stdrewardutDAO.findByPk(pkVO)!=null)
				{
					dao.remove(stdrewardutDAO.findByPk(pkVO));
				}
			}
			
		} catch (Exception e) {
			sessionContext.setRollbackOnly();
			throw e;
		}
	}
}
