/**
 * auto-generated code
 * Thu Aug 24 15:28:14 CST 2006
 */
package com.sunrise.boss.business.cms.way.control;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.EntityMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaVO;
import com.sunrise.boss.business.cms.areacenter.persistent.AreacenterVO;
import com.sunrise.boss.business.cms.bchcontact.control.BchcontactControl;
import com.sunrise.boss.business.cms.bchcontact.control.BchcontactControlBean;
import com.sunrise.boss.business.cms.citycompany.persistent.CitycompanyVO;
import com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyDAO;
import com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyListVO;
import com.sunrise.boss.business.cms.common.AuditUtils;
import com.sunrise.boss.business.cms.custwaytype.persistent.CustwaytypeVO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeDAO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeListVO;
import com.sunrise.boss.business.cms.microarea.persistent.MicroareaDAO;
import com.sunrise.boss.business.cms.microarea.persistent.MicroareaListVO;
import com.sunrise.boss.business.cms.postinfo.persistent.PostinfoDAO;
import com.sunrise.boss.business.cms.postinfo.persistent.PostinfoListVO;
import com.sunrise.boss.business.cms.postinfo.persistent.PostinfoVO;
import com.sunrise.boss.business.cms.servcent.persistent.ServcentDAO;
import com.sunrise.boss.business.cms.servcent.persistent.ServcentListVO;
import com.sunrise.boss.business.cms.way.persistent.WayDAO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.wayaccount.control.WayaccountControl;
import com.sunrise.boss.business.cms.wayaccount.control.WayaccountControlBean;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountListVO;
import com.sunrise.boss.business.cms.waycompact.control.WaycompactControl;
import com.sunrise.boss.business.cms.waycompact.control.WaycompactControlBean;
import com.sunrise.boss.business.cms.wayhierarchy.control.WayhierarchyControl;
import com.sunrise.boss.business.cms.wayhierarchy.control.WayhierarchyControlBean;
import com.sunrise.boss.business.cms.wayhierarchy.persistent.WayhierarchyListVO;
import com.sunrise.boss.business.cms.wayhierarchy.persistent.WayhierarchyVO;
import com.sunrise.boss.business.cms.waysyn.persistent.WaysynVO;
import com.sunrise.boss.business.cms.waytype.persistent.WaytypeDAO;
import com.sunrise.boss.business.cms.waytype.persistent.WaytypeListVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.waysyn.WaysynDelegate;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: WayControlBean
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
 * @author He Kun
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/way/control/WayControlBean"
 *           name="WayControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class WayControlBean extends AbstractControlBean implements WayControl {

	private static Log log = LogFactory.getLog(WayControlBean.class);

	private WaysynDelegate delegate = null;

	public WayVO doCreate(WayVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			if (null == vo.getCreatetime()) {
				vo.setCreatetime(new Date());
			}
			if (dao.findByPk(vo.getWayid()) != null) {
				throw new BusinessException("CMS-10001", "已经存在该渠道编码:"
						+ vo.getWayid());
			}
			this.doCheckwayVO(vo, "0", user);// 添加过滤检查
			// 修改waylevel waylevel= 上级渠道waylevel + 1
			if (vo.getUpperwayid() != null) {
				WayVO upVO = (WayVO) dao.findByPk(vo.getUpperwayid());
				if (upVO.getWaylevel() == null) {
					throw new BusinessException("", vo.getWayid()+"的上级渠道 " + upVO.getWayid()
							+ " 缺少 渠道级别或者不存在， 请先将其设置正确。");
				}
				short ulevel = upVO.getWaylevel().shortValue();
				vo.setWaylevel(new Short((short) (ulevel + 1)));
			}
			WayVO wayVO = (WayVO) dao.create(vo);
			if (log.isInfoEnabled())
				log.info("create way wayid:" + wayVO.getWayid());

			// 处理渠道层次关系表, 添加不分层的节点关系.
			createWayHierarchy(wayVO, user);
			this.doCreateWaySyn(wayVO, "create",new Short("0"), user);
			this.doCreateWaySyn(wayVO, "create",new Short("2"), user);
			return wayVO;
		} catch (Exception ex) {

			if (log.isInfoEnabled())
				log.info("create way failed, wayid:" + vo.getWayid(), ex);
			sessionContext.setRollbackOnly();
			throw ex;

		}
	}

	/**
	 * 逻辑删除渠道，状态改为 -1
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public void doRemove(WayVO vo, User user) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		vo.setWaystate(new Short("0"));
		this.doCreateWaySyn(vo, "update",new Short("0"), user);
		this.doCreateWaySyn(vo, "update",new Short("2"), user);
		dao.update(vo);
	}

	public WayVO doUpdate(WayVO vo, User user) throws Exception {
		try {
			WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			if (vo.getWaystate().intValue() > 0) {
				this.doCheckwayVO(vo, "1", user);// 添加过滤检查
			}
			// dao.flushSession();
			// Short upperwaylevel = (Short) dao.getMaxid("wayid", vo
			// .getUpperwayid(), "waylevel");

			// vo.setWaylevel(new Short((short) (upperwaylevel.intValue() +
			// 1)));
			// WayVO tmpvo=(WayVO)BeanUtils.cloneBean(vo);
			/*
			 * dao.flushSession();
			 * 
			 * WayVO wayVO=(WayVO)dao.findByPk(vo.getWayid()); String
			 * upperwayid=wayVO.getUpperwayid(); BeanUtils.copyProperties(wayVO,
			 * vo); wayVO.setUpperwayid(upperwayid);//上级渠道不允许修改
			 */
			// 检验是否修改了上级渠道，如果有修改重新构建层次关系记录
			WayVO oldVO = (WayVO) dao.findByPk(vo.getWayid());
			if (vo.getUpperwayid() != null
					&& !vo.getUpperwayid().equalsIgnoreCase(
							oldVO.getUpperwayid())) {
				if (dao.findByProperty("upperwayid", vo.getWayid()) != null) {
					throw new BusinessException("",
							"修改失败，该渠道修改了归属的上级渠道，不允许含有子渠道");
				}
				WayVO upVO = (WayVO) dao.findByPk(vo.getUpperwayid());
				if (upVO.getWaylevel() == null) {
					throw new BusinessException("", "上级渠道 " + vo.getWayid()
							+ " 缺少 渠道级别，请先将其设置正确。");
				}
				short ulevel = upVO.getWaylevel().shortValue();
				vo.setWaylevel(new Short((short) (ulevel + 1)));
				
				removeWayHierarchy(vo, user);
				createWayHierarchy(vo, user);
			}
			if(!vo.getUpperwayid().equals(oldVO.getUpperwayid()) ||
					!vo.getWayname().equals(oldVO.getWayname())) {
				if (!new AuditUtils().doCheckPre("CH_PW_WAY_UPDATE", user)) {
					throw new BusinessException("",
							"该工号没有修改渠道名称或修改上级渠道编码的权限,请联系管理员赋权!");
				}
			}
			if(null == vo.getCreatetime()){
				vo.setCreatetime(oldVO.getCreatetime());
			}
			this.doCreateWaySyn(vo, "update", new Short("0"),user);
			this.doCreateWaySyn(vo, "update", new Short("2"),user);
			
			Session session = SessionUtil.currentSession(dao.getDbFlag());
			// session.evict(oldVO);
			WayVO newVO = (WayVO) session.merge(vo);
			dao.registerLog("update", newVO, user);
			session.flush();
			return newVO;
			// return (WayVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	/**
	 * 永久删除渠道，只允许状态为 -1 的被永久删除
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public void doRemovePermament(WayVO vo, User user) throws Exception {
		try {
			WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);

			DataPackage subways = getSubways(vo.getWayid(), user);
			if (subways.getDatas().size() > 0)
				throw new BusinessException("CMS-10002", "该渠道存在子渠道,不能删除! 渠道编码:"
						+ vo.getWayid());

			// adder by yjr
			BchcontactControl bchcontactControl = (BchcontactControl) ControlFactory
					.build(BchcontactControlBean.class);
			if (bchcontactControl.doFindByPk(vo.getWayid(), user) != null) {
				throw new BusinessException("CMS-10002",
						"该渠道存在渠道沟通信息,不能删除! 渠道编码:" + vo.getWayid());
			}

			WaycompactControl waycompactControl = (WaycompactControl) ControlFactory
					.build(WaycompactControlBean.class);
			if (waycompactControl.doFindByPk(vo.getWayid(), user) != null) {
				throw new BusinessException("CMS-10002",
						"该渠道存在渠道合同信息,不能删除! 渠道编码:" + vo.getWayid());
			}

			WayaccountControl wayaccountControl = (WayaccountControl) ControlFactory
					.build(WayaccountControlBean.class);
			WayaccountListVO listVO = new WayaccountListVO();
			listVO.set_se_wayid(vo.getWayid());
			if (wayaccountControl.doQuery(listVO, user).getDatas().size() > 0) {
				throw new BusinessException("CMS-10002",
						"该渠道存在渠道帐户信息,不能删除! 渠道编码:" + vo.getWayid());
			}

			dao.remove(vo);

			// 处理渠道层次关系表, 删除不分层的节点关系.
			removeWayHierarchy(vo, user);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public WayVO doFindByPk(Serializable pk, User user) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return (WayVO) dao.findByPk(pk);
	}

	/**
	 * 只查询直接和间接从属于当前用户所属渠道的所有子渠道.
	 */
	public DataPackage doQuery(WayListVO params, User user) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		DataPackage dp = dao.query(params);
		return dp;
	}

	/**
	 * 创建渠道层次关系
	 * 
	 * @param wayVO
	 * @param user
	 * @throws Exception
	 */
	protected void createWayHierarchy(WayVO wayVO, User user) throws Exception {

		if (log.isInfoEnabled())
			log.info("prepare to create way hierarchy of way, 渠道编码 "
					+ wayVO.getWayid());

		WayhierarchyControl wayhierarchyControl = (WayhierarchyControl) ControlFactory
				.build(WayhierarchyControlBean.class);

		String upperwayid = wayVO.getUpperwayid();

		if (upperwayid == null) {
			if (log.isInfoEnabled())
				log.info("way with no upperway,exit. 渠道编码 " + wayVO.getWayid());
			return;
		}
		String wayid = wayVO.getWayid();

		short hicyoffset = 1;
		while (upperwayid != null) {

			WayhierarchyVO wayhierarchyVO = new WayhierarchyVO();
			wayhierarchyVO.setParwayid(upperwayid);
			wayhierarchyVO.setSubwayid(wayid);
			wayhierarchyVO.setHichyoffset(new Short(hicyoffset));
			wayhierarchyVO.setCreatetime(new Timestamp(System
					.currentTimeMillis()));

			wayhierarchyControl.doCreate(wayhierarchyVO, user);

			log.info("create way hierarchy,渠道编码 " + wayVO.getWayid()
					+ " uppperid:" + upperwayid + " hicyoffset:" + hicyoffset);
			hicyoffset++;

			String thiswayid = upperwayid;
			wayVO = getUpperWay(thiswayid, user);
			if (wayVO == null)
				upperwayid = null;
			else
				upperwayid = wayVO.getWayid();
		}
	}

	/**
	 * 删除渠道层次关系
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	protected void removeWayHierarchy(WayVO wayVO, User user) throws Exception {
		WayhierarchyControl wayhierarchyControl = (WayhierarchyControl) ControlFactory
				.build(WayhierarchyControlBean.class);
		WayhierarchyListVO listVO = new WayhierarchyListVO();

		String wayid = wayVO.getWayid();
		// 删除wayid作为父渠道的记录
		listVO.getQueryConditions().put("_se_parwayid", wayid);
		listVO.set_pagesize("0");

		DataPackage data = wayhierarchyControl.doQuery(listVO, user);
		List dataList = (List) data.getDatas();

		for (int i = 0; i < dataList.size(); i++) {
			WayhierarchyVO vo = (WayhierarchyVO) dataList.get(i);
			wayhierarchyControl.doRemove(vo, user);
		}

		// 删除wayid作为子渠道的记录
		listVO = new WayhierarchyListVO();
		listVO.set_pagesize("0");
		listVO.getQueryConditions().put("_se_subwayid", wayid);
		data = wayhierarchyControl.doQuery(listVO, user);
		dataList = (List) data.getDatas();
		for (int i = 0; i < dataList.size(); i++) {
			WayhierarchyVO vo = (WayhierarchyVO) dataList.get(i);
			wayhierarchyControl.doRemove(vo, user);
		}
	}

	/**
	 * 获取上级渠道
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public WayVO getUpperWay(String wayid, User user) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayVO wayVO = (WayVO) dao.findByPk(wayid);
		if (wayVO == null || wayVO.getUpperwayid() == null)
			return null;
		else
			return (WayVO) dao.findByPk(wayVO.getUpperwayid());
	}

	public DataPackage getWaysOfHeadquarter(User user) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayListVO wayListVO = new WayListVO();
		wayListVO.getQueryConditions().put("_sn_upperwayid", "");
		wayListVO.getQueryConditions().put("_sn_centerid", "");
		wayListVO.getQueryConditions().put("_sn_cityid", "");
		wayListVO.getQueryConditions().put("_sn_countyid", "");
		wayListVO.set_pagesize("0");
		return dao.query(wayListVO);
	}

	public WayVO getWayOfGMCC(User user) throws Exception {
		List list = (List) getWaysOfHeadquarter(user);
		if (list.size() > 0)
			return (WayVO) list.get(0);
		else
			return null;
	}

	public DataPackage getWaysOfCenter(String centerid, User user)
			throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayListVO wayListVO = new WayListVO();
		wayListVO.getQueryConditions().put("_sn_upperwayid", "");
		wayListVO.set_se_centerid(centerid);
		wayListVO.getQueryConditions().put("_sn_cityid", "");
		wayListVO.getQueryConditions().put("_sn_countyid", "");
		wayListVO.set_pagesize("0");
		return dao.query(wayListVO);
	}

	public DataPackage getWaysOfCitycom(String cityid, User user)
			throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayListVO wayListVO = new WayListVO();
		wayListVO.getQueryConditions().put("_sn_upperwayid", "");
		wayListVO.getQueryConditions().put("_sn_centerid", "");
		wayListVO.set_se_cityid(cityid);
		wayListVO.getQueryConditions().put("_sn_countyid", "");
		wayListVO.set_pagesize("0");
		return dao.query(wayListVO);
	}

	public DataPackage getWaysOfCountycom(String countyid, User user)
			throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayListVO wayListVO = new WayListVO();
		wayListVO.getQueryConditions().put("_sn_upperwayid", "");
		wayListVO.getQueryConditions().put("_sn_centerid", "");
		wayListVO.getQueryConditions().put("_sn_cityid", "");
		wayListVO.set_se_countyid(countyid);
		wayListVO.set_pagesize("0");
		return dao.query(wayListVO);
	}

	public DataPackage getFirstLevelWays(User user) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayListVO wayListVO = new WayListVO();
		wayListVO.getQueryConditions().put("_sn_upperwayid", "");
		wayListVO.set_pagesize("0");
		return dao.query(wayListVO);
	}

	public DataPackage getSubways(String wayid, User user) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayListVO wayListVO = new WayListVO();
		wayListVO.set_se_upperwayid(wayid);
		wayListVO.set_pagesize("0"); // 当pagesize设为0时查所有数据，不分页
		wayListVO.set_orderby("wayid"); // 设置排序关键词为旧渠道代码
		return dao.query(wayListVO);
	}

	/**
	 * 不分层获取所有子渠道
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public DataPackage getAllSubways(String wayid, User user) throws Exception {
		WayhierarchyControl wayhierarchyControl = (WayhierarchyControl) ControlFactory
				.build(WayhierarchyControlBean.class);

		WayhierarchyListVO listVO = new WayhierarchyListVO();
		listVO.getQueryConditions().put("_se_parwayid", wayid);
		listVO.set_pagesize("0");

		List list = (List) wayhierarchyControl.doQuery(listVO, user).getDatas();

		DataPackage dataPackage = new DataPackage();
		dataPackage.setRowCount(list.size());
		List wayList = new ArrayList(list.size());
		for (int i = 0; i < list.size(); i++) {
			WayhierarchyVO wayhierarchyVO = (WayhierarchyVO) list.get(i);
			String subwayid = wayhierarchyVO.getSubwayid();

			WayVO wayVO = doFindByPk(subwayid, user);
			wayList.add(wayVO);
		}

		dataPackage.setDatas(wayList);
		return dataPackage;
	}

	/**
	 * 判断是否是某个渠道的直属子渠道
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public boolean isDirectSubwayOf(String wayid, String upperwayid, User user)
			throws Exception {
		WayVO wayVO = doFindByPk(wayid, user);
		if (wayVO == null)
			throw new BusinessException("CMS-10101", "找不到渠道, 渠道编码 " + wayid);

		WayVO upperWayVO = doFindByPk(upperwayid, user);
		if (upperWayVO == null)
			throw new BusinessException("CMS-10101", "找不到渠道, 渠道编码 "
					+ upperwayid);
		/**
		 * @modify by Cao Wei
		 * @time 09.23 11:51
		 * @description 资源测试渠道判断
		 */
		return wayVO.getUpperwayid() != null
				&& wayVO.getUpperwayid().equals(upperwayid);
	}

	/**
	 * 判断是否是某个渠道的子渠道(不论直属,非直属)
	 */
	public boolean isSubwayOf(String wayid, String uppperwayid, User user)
			throws Exception {
		WayVO wayVO = doFindByPk(wayid, user);
		if (wayVO == null)
			throw new BusinessException("CMS-10101", "找不到渠道, 渠道编码 " + wayid);

		WayVO wayVO2 = doFindByPk(uppperwayid, user);
		if (wayVO2 == null)
			throw new BusinessException("CMS-10101", "找不到渠道, 渠道编码 "
					+ uppperwayid);

		if (wayid.equals(uppperwayid))
			throw new BusinessException("CMS-10101", "渠道相同: 渠道编码 " + wayid
					+ ", 上级渠道 " + uppperwayid);
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		List list = (List) dao.queryAllSubways(uppperwayid).getDatas();
		return list.contains(wayVO);
		// WayhierarchyControl wayhierarchyControl =
		// (WayhierarchyControl)ControlFactory.build(WayhierarchyControlBean.class);
		// WayhierarchyListVO listVO = new WayhierarchyListVO();
		// listVO.getQueryConditions().put("_se_parwayid", uppperwayid);
		// listVO.getQueryConditions().put("_se_subwayid", wayid);
		//		
		// return wayhierarchyControl.doQuery(listVO, user).getDatas().size() >0
		// ;
	}

	/**
	 * 是否是区域中心直属渠道
	 */
	public boolean isCenterDirectWay(String wayid, User user) throws Exception {
		WayVO wayVO = doFindByPk(wayid, user);
		if (wayVO == null)
			throw new BusinessException("CMS-10101", "找不到渠道, 渠道编码 " + wayid);

		return (wayVO.getCenterid() != null && wayVO.getCityid() == null
				&& wayVO.getCountyid() == null && wayVO.getUpperwayid() == null);
	}

	/**
	 * 判断是否是市公司直属渠道
	 */
	public boolean isCitycomDirectWay(String wayid, User user) throws Exception {
		WayVO wayVO = doFindByPk(wayid, user);
		if (wayVO == null)
			throw new BusinessException("CMS-10101", "找不到渠道, 渠道编码 " + wayid);

		// BOSS1.0中 市公司直属渠道级别为1, 沿用此规则. 省和区域中心直属渠道,级别都为0.
		return (wayVO.getCityid() != null
				&& wayVO.getWaylevel().shortValue() == 1 && wayVO.getCountyid() == null // 割接数据中,
		// 市直属渠道也有县公司编码,
		// 暂时屏蔽此判断,
		);
	}

	/**
	 * 判断是否是县公司直属渠道
	 */
	public boolean isCountycomDirectWay(String wayid, User user)
			throws Exception {
		WayVO wayVO = doFindByPk(wayid, user);
		if (wayVO == null)
			throw new BusinessException("CMS-10101", "找不到渠道, 渠道编码 " + wayid);

		String upperwayid = wayVO.getUpperwayid();
		if (upperwayid == null)
			return false; // 没有上级渠道的渠道只有省公司直属渠道,因此它不是县公司直属渠道

		WayVO upperayVO = doFindByPk(upperwayid, user);
		if (upperayVO == null)
			throw new BusinessException("CMS-10102", "找不到渠道的父渠道, 渠道编码 " + wayid
					+ ", 父渠道编码:" + upperayVO);
		return upperayVO.getCityid() != null && upperayVO.getCountyid() == null;
	}

	/**
	 * 判断是否是GMCC直属渠道
	 */
	public boolean isGMCCDirectWay(String wayid, User user) throws Exception {
		WayVO wayVO = doFindByPk(wayid, user);
		if (wayVO == null)
			throw new BusinessException("CMS-10101", "找不到渠道, 渠道编码 " + wayid);

		return (wayVO.getCenterid() == null && wayVO.getCityid() == null
				&& wayVO.getCountyid() == null && wayVO.getUpperwayid() == null);
	}

	/**
	 * 判断渠道是否存在
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public boolean isWayExist(String wayid, User user) throws Exception {
		WayVO wayVO = doFindByPk(wayid, user);
		if (wayVO == null)
			return false;
		else
			return true;
	}

	/**
	 * 判断自定义类别是否被渠道使用
	 */
	public DataPackage getByCusttype(String custtype, User user)
			throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayListVO wayListVO = new WayListVO();
		wayListVO.set_se_custtype(custtype);
		return dao.query(wayListVO);
	}

	/**
	 * 判断渠道类别是否被渠道使用
	 */
	public DataPackage getByWaytype(String waytype, User user) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayListVO wayListVO = new WayListVO();
		wayListVO.set_se_waytype(waytype);
		return dao.query(wayListVO);
	}

	/**
	 * 根据一个特定渠道, 获取其所属市公司的直属(顶级)渠道
	 */
	public WayVO getCitycomDirectWayByWay(String wayid, User user)
			throws Exception {
		
		WayVO wayVO = checkWayid(wayid, user);
		
		if("GDYD".equals(wayVO.getWayid())){
			return wayVO;
		}

		String cityid = wayVO.getCityid();
		if (cityid == null) {
			// throw new BusinessException("CMS-10121","当前渠道不属于市公司,渠道编码:" +
			// wayid);
			// 返回其本身
			return wayVO;
		}

		WayListVO listVO = new WayListVO();
		listVO.set_se_cityid(cityid);
		listVO.getQueryConditions().put("_ne_waylevel", new Short((short) 1));

		List list = (List) (doQuery(listVO, user).getDatas());
		if (list.size() > 0)
			return (WayVO) list.get(0);

		return null;
	}

	/**
	 * 根据一个特定渠道, 获取其所属县公司的直属(顶级)渠道
	 */
	public WayVO getCountycomDirectWayByWay(String wayid, User user)
			throws Exception {
		WayVO wayVO = checkWayid(wayid, user);

		String countyid = wayVO.getCountyid();
		if (countyid == null)
			throw new BusinessException("CMS-10121", "当前渠道不属于县公司,渠道编码:" + wayid);

		WayListVO listVO1 = new WayListVO();
		listVO1.set_se_countyid(countyid);

		WayListVO listVO2 = new WayListVO(); // 查市公司
		listVO2.getQueryConditions().put("_snn_cityid", "");
		listVO2.getQueryConditions().put("_sn_countyid", "");

		WayDAO wayDAO = (WayDAO) DAOFactory.build(WayDAO.class, user);
		List list = (List) wayDAO.query2(new Object[] { listVO1, listVO2 },
				new Class[] { WayListVO.class, WayListVO.class },
				new String[][] { { "upperwayid", "wayid" } }).getDatas();

		if (list.size() > 1) {
			throw new BusinessException("CMS-10113",
					"数据非法, 找到了它的多个市属上级渠道, 渠道编码:" + wayid);
		}
		if (list.size() > 0)
			return (WayVO) list.get(0);

		return null;
	}

	private WayVO checkWayid(String wayid, User user) throws Exception {
		WayVO wayVO = doFindByPk(wayid, user);
		if (wayVO == null)
			throw new BusinessException("CMS-10101", "找不到渠道, 渠道编码 " + wayid);
		return wayVO;
	}

	public DataPackage queryUpperWaysAndMeByIdOrName(String queryText,
			boolean showDisabled, User user) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return dao.queryUpperWaysAndMeByIdOrName(queryText, showDisabled);
	}
	
	public boolean doCheckisNetWork(String wayid,User user) throws Exception{
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return dao.checkisNetWork(wayid);
	}
	public List doQueryNetWork(String wayid,User user) throws Exception{
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return dao.queryNetWork(wayid);
	}
	

	public WayVO doEdit(WayVO oldVO, WayVO newVO, User user) throws Exception {
		this.doRemove(oldVO, user);
		this.doCreate(newVO, user);
		return null;
	}

	/**
	 * 根据操作员所在的渠道查询其所能浏览的渠道记录
	 * 
	 * @param params
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryByOprcode(WayListVO params, User user)
			throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		DataPackage dp = dao.queryByOprcode(params, user.getWayid());
		return dp;
	}

	/**
	 * 查询竞争对手自营渠道信息管理
	 * 
	 * @param params
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryRvwaycnt(WayListVO params, User user)
			throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		DataPackage dp = dao.queryRvwaycnt(params, user.getWayid());
		return dp;

	}

	/**
	 * 判断渠道是否为社会渠道(AG)
	 * 
	 * @param wayid
	 * @return
	 * @throws Exception
	 */
	public boolean isAGWay(String wayid, String subtype, User user)
			throws Exception {
		boolean result = false;
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);

		WayVO vo = (WayVO) dao.findByPk(wayid);
		if (vo != null && vo.getWaytype() != null
				&& vo.getWaytype().trim().equals("AG")
				&& vo.getWaysubtype() != null
				&& vo.getWaysubtype().trim().equals(subtype)) {
			result = true;
		}
		return result;
	}

	public DataPackage doQuerysaleway(WayListVO params, User user)
			throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		DataPackage dp = dao.querySaleway(params, user.getWayid());
		return dp;
	}

	private boolean doCheckwayid(String upperwayid, User user) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		Object object = dao.findByPk(upperwayid);
		if (object == null) {
			return false;
		}
		return true;
	}

	private void doCheckwayVO(WayVO vo, String oprtype, User user)
			throws Exception {
		String option = "";
		if ("0".equals(oprtype)) {
			option = "新增操作,";
		} else {
			option = "修改操作,";
		}
		if ("true".equals(vo.getIsCooperator())) {
			// 不检查渠道编码格式
		} else {
			if (!AuditUtils.doCheckWayidStyle(vo.getWayid())) {
				throw new BusinessException("", option
						+ "渠道编码格式不正确,只能是字母+数字或者'-'");
			}
		}
		WayDAO waydao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		Session session = SessionUtil.currentSession(waydao.getDbFlag());
		WayVO tmpwayvo = (WayVO) session.get(WayVO.class, vo.getWayid());
		session.evict(tmpwayvo);
		if (tmpwayvo != null
				&& StringUtils.isNotEmpty(vo.getLatitude())
				&& StringUtils.isNotEmpty(vo.getLongtitude())
				&& (!StringUtils.equals(vo.getLatitude(), tmpwayvo
						.getLatitude()) || !StringUtils.equals(vo
						.getLongtitude(), tmpwayvo.getLongtitude()))) {
			WayListVO waylistvo = new WayListVO();
			waylistvo.set_se_latitude(vo.getLatitude());
			waylistvo.set_se_longtitude(vo.getLongtitude());
			waylistvo.set_ne_waystate(Short.valueOf("1"));
			List waylist = (ArrayList) waydao.query(waylistvo).getDatas();
			for (Iterator wayit = waylist.iterator(); wayit.hasNext();) {
				WayVO wayVO = (WayVO) wayit.next();
				if (!vo.getWayid().equals(wayVO.getWayid())) {
					throw new BusinessException("", option + "经度"
							+ wayVO.getLatitude() + ",纬度"
							+ wayVO.getLongtitude()
							+ "，已经存在.如网点确实同一经纬度,建议修改小数点后第6位以示区分");
				}
			}
		}

		if (vo.getWayid().equals(vo.getUpperwayid())) {
			throw new BusinessException("", option
					+ "上级渠道编码与该渠道编码相同,上级渠道不能是该渠道本身");
		}
		if (!this.doCheckwayid(vo.getUpperwayid(), user)) {
			throw new BusinessException("", option + "上级渠道编码:"
					+ vo.getUpperwayid() + "不存在,请确认渠道编码是否正确");
		}

		WayVO upperwayvo = (WayVO) waydao.findByPk(vo.getUpperwayid());

		if (upperwayvo.getWaystate().intValue() == -1
				|| upperwayvo.getWaystate().intValue() == 0) {
			throw new BusinessException("", option + "上级渠道状态为失效或以删除,请确认");
		}

		WaytypeListVO typelistvo = new WaytypeListVO();
		typelistvo.set_se_uppercode(vo.getWaytype());
		typelistvo.set_se_waytypecode(vo.getWaysubtype());
		WaytypeDAO waytypedao = (WaytypeDAO) DAOFactory.build(WaytypeDAO.class,
				user);
		if (waytypedao.query(typelistvo).getDatas().size() == 0
				&& (!"true".equals(vo.getIsCooperator()))
				&& !"KF".equalsIgnoreCase(vo.getWaytype())) {
			throw new BusinessException("", option + "渠道类别表没有定义所填的渠道类别:"+vo.getWaytype()+"与子类别:"+vo.getWaysubtype());
		}
		// 判断行政区域编码是否存在库表中
		if (StringUtils.isNotEmpty(vo.getAdacode())
				&& !"0".equals(vo.getAdacode())) {
			AdimareaVO adimareavo = new AdimareaVO();
			adimareavo.setAdacode(vo.getAdacode());
			if (!this.doQueryExsist(adimareavo, user)) {
				throw new BusinessException("", option + "行政区域编码:"
						+ vo.getAdacode() + "不存在");
			}
		}
		if (StringUtils.isNotEmpty(vo.getCenterid())) {
			AreacenterVO centvo = new AreacenterVO();
			centvo.setCenterid(vo.getCenterid());
			if (!this.doQueryExsist(centvo, user)) {
				throw new BusinessException("", option + "区域中心编码:"
						+ vo.getCenterid() + "不存在");
			}
		}
		if (StringUtils.isNotEmpty(vo.getCityid())) {
			CitycompanyVO cityvo = new CitycompanyVO();
			cityvo.setCitycompid(vo.getCityid());
			if (StringUtils.isNotEmpty(upperwayvo.getCityid())
					&& !"GDYD".equals(upperwayvo.getWayid())) { // 如果上级渠道中的地市公司不为空，并且上级渠道不是广东总公司
				if (!StringUtils.equals(vo.getCityid(), upperwayvo.getCityid())) {
					throw new BusinessException("", option
							+ "地市公司应该与上级渠道中的地市公司保持一致");
				}
			}
			if (!this.doQueryExsist(cityvo, user)) {
				throw new BusinessException("", option + "地市公司标识:"
						+ vo.getCityid() + "不存在");
			}

		}

		if (StringUtils.isNotEmpty(vo.getCountyid())) {
			if (StringUtils.isEmpty(vo.getCityid())) {
				throw new BusinessException("", option + "上级地市公司不能为空");
			}
			CntycompanyListVO cntlistvo = new CntycompanyListVO();
			cntlistvo.set_se_citycompid(vo.getCityid());
			cntlistvo.set_sk_countycompid(vo.getCountyid());
			CntycompanyDAO cntdao = (CntycompanyDAO) DAOFactory.build(
					CntycompanyDAO.class, user);

			if (StringUtils.isNotEmpty(upperwayvo.getCountyid())) {
				if (!StringUtils.equals(upperwayvo.getCountyid(), vo
						.getCountyid()))
					throw new BusinessException("", option + "县公司标识:"
							+ vo.getCountyid() + "应该与上级渠道中的县公司"+upperwayvo.getCountyid()+"保持一致");
			}
			if (cntdao.query(cntlistvo, cntdao.QUERY_TYPE_DATA).getDatas()
					.size() == 0) {
				throw new BusinessException("", option + "县公司标识:"
						+ vo.getCountyid() + "不存在,或不属于该地市公司");
			}
		}

		if (StringUtils.isNotEmpty(vo.getSvccode())) {
			if (StringUtils.isEmpty(vo.getCountyid())) {
				throw new BusinessException("", option + "上级县公司标识不能为空");
			}
			ServcentListVO svclistvo = new ServcentListVO();
			svclistvo.set_se_countyid(vo.getCountyid());
			svclistvo.set_se_svccode(vo.getSvccode());
			ServcentDAO cntdao = (ServcentDAO) DAOFactory.build(
					ServcentDAO.class, user);
			if (cntdao.query(svclistvo, cntdao.QUERY_TYPE_DATA).getDatas()
					.size() == 0) {
				throw new BusinessException("", option + "服务销售中心编码:"
						+ vo.getSvccode() + "不存在，或不属于该分公司"+vo.getCountyid());
			}
		}

		if (StringUtils.isNotEmpty(vo.getMareacode())) {
			if (StringUtils.isEmpty(vo.getSvccode())) {
				throw new BusinessException("", option + "服务销售中心编码不能为空");
			}
			MicroareaListVO micrlistvo = new MicroareaListVO();
			micrlistvo.set_se_macode(vo.getMareacode());
			micrlistvo.set_se_svccode(vo.getSvccode());
			MicroareaDAO dao = (MicroareaDAO) DAOFactory.build(
					MicroareaDAO.class, user);
			if (dao.query(micrlistvo, dao.QUERY_TYPE_DATA).getDatas().size() == 0) {
				throw new BusinessException("", option + "微区域编码:"
						+ vo.getMareacode() + "不存在，或不属于该服务销售中心"+vo.getSvccode());
			}
		}

		if (StringUtils.isNotEmpty(vo.getWaymagcode())
				&& !"true".equals(vo.getIsCooperator())) {
			PostinfoDAO postdao = (PostinfoDAO) DAOFactory.build(
					PostinfoDAO.class, user);
			PostinfoListVO postlistvo = new PostinfoListVO();
			postlistvo.set_ne_postkind("1");
			List postlist = (List) postdao.query(postlistvo,
					postdao.QUERY_TYPE_DATA).getDatas();
			EmployeeListVO emlistvo = new EmployeeListVO();
			emlistvo.set_ne_employeeid(vo.getWaymagcode());
			List inquery = new ArrayList();
			for (Iterator it = postlist.iterator(); it.hasNext();) {
				PostinfoVO postvo = (PostinfoVO) it.next();
				inquery.add(postvo.getPostid().toString());
			}
			emlistvo.set_nin_station(inquery);
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			if (dao.query(emlistvo, dao.QUERY_TYPE_DATA).getDatas().size() == 0) {
				throw new BusinessException("", option + "渠道经理的人员ID:"
						+ vo.getWaymagcode() + "不存在");
			}
		}

		if (StringUtils.isNotEmpty(vo.getLogiscode())) {
			WayVO wayVO = new WayVO();
			wayVO.setWayid(vo.getLogiscode());
			if (!this.doQueryExsist(wayVO, user)) {
				throw new BusinessException("", option + "所属物流商渠道编码:"
						+ vo.getLogiscode() + "不存在");
			}
		}

		if (StringUtils.isNotEmpty(vo.getChainhead())) {
			WayListVO waylistvo = new WayListVO();
			waylistvo.set_se_waytype("AG");
			waylistvo.set_se_waysubtype("DIS");
			waylistvo.set_ne_waystate(Short.valueOf("1"));
			waylistvo.set_se_wayid(vo.getChainhead());
			if (waydao.query(waylistvo).getRowCount() <= 0) {
				throw new BusinessException("", "所属合作商编码:" + vo.getChainhead()
						+ "不存在或者不是连锁经营合作商");
			}
		}

		// 判断固定参数
		if (StringUtils.isNotEmpty(vo.getSvbrchcode())) {
			if (!this.doCheckSystemParam("CH_SVBRCHTYPE", vo.getSvbrchcode(),
					user)) {
				throw new BusinessException("", option + "填写的服务厅类别为:"
						+ vo.getSvbrchcode() + "固定参数不存在");
			}
		}
		if (vo.getAdtypecode() != null && vo.getAdtypecode().intValue() > 0) {
			if (!this.doCheckSystemParam("CH_ADTYPE", vo.getAdtypecode()
					.toString(), user)) {
				throw new BusinessException("", option + "填写的区域类型编码为:"
						+ vo.getAdtypecode().toString() + "固定参数不存在");
			}
		}
		if (vo.getCatetype() != null && vo.getCatetype().intValue() > 0) {
			if (!this.doCheckSystemParam("CH_CATETYPE", vo.getCatetype()
					.toString(), user)) {
				throw new BusinessException("", option + "填写的连锁性质为:"
						+ vo.getCatetype().toString() + "固定参数不存在");
			}
		}
		if (vo.getFormtype() != null && vo.getFormtype().intValue() > 0) {
			if (!this.doCheckSystemParam("CH_FORMTYPE", vo.getFormtype()
					.toString(), user)) {
				throw new BusinessException("", option + "填写的业态类型为:"
						+ vo.getFormtype().toString() + "固定参数不存在");
			}
		}
		if (vo.getMainlayer() != null && vo.getMainlayer().intValue() > 0) {
			if (!this.doCheckSystemParam("CH_COPLAYER", vo.getMainlayer()
					.toString(), user)) {
				throw new BusinessException("", option + "填写的合作层级为:"
						+ vo.getMainlayer().toString() + "固定参数不存在");
			}
		}
		if (vo.getCooperator() != null && vo.getCooperator().intValue() > 0) {
			if (!this.doCheckSystemParam("CH_COOPERATOR", vo.getCooperator()
					.toString(), user)) {
				throw new BusinessException("", option + "填写的合作方为:"
						+ vo.getCooperator() + "固定参数不存在");
			}
		}
		if (StringUtils.isNotEmpty(vo.getCusttype())
				&& !"0".endsWith(vo.getCusttype())) {
			CustwaytypeVO custvo = new CustwaytypeVO();
			custvo.setCustwaytypecode(vo.getCusttype());
			if (!this.doQueryExsist(custvo, user)) {
				throw new BusinessException("", option + "分公司自定义类别为:"
						+ vo.getCusttype() + "不存在");
			}
		}
		if (vo.getCitylevel() != null && vo.getCitylevel().intValue() > 0) {
			if (!this.doCheckSystemParam("CH_CITYLEVEL", vo.getCitylevel()
					.toString(), user)) {
				throw new BusinessException("", option + "填写的城市级别为:"
						+ vo.getCitylevel().toString() + "固定参数不存在");
			}
		}
		if (StringUtils.isNotEmpty(vo.getBchlevel())
				&& !"0".equals(vo.getBchlevel())) {
			if (!this.doCheckSystemParam("CH_BCHLEVEL", vo.getBchlevel(), user)) {
				throw new BusinessException("", option + "填写的渠道等级(服务厅级别编码)为:"
						+ vo.getBchlevel() + "固定参数不存在");
			}
		}
		if (vo.getWaystate() != null && vo.getWaystate().intValue() > 0) {
			if (!this.doCheckSystemParam("CH_VALIDFLAG", vo.getWaystate()
					.toString(), user)) {
				throw new BusinessException("", option + "填写的渠道状态为:"
						+ vo.getWaystate().toString() + "固定参数不存在");
			}
		}
		if (vo.getPrtsource() != null && vo.getPrtsource().longValue() > 0) {
			if (!this.doCheckSystemParam("CH_PRTSOURCE", vo.getPrtsource()
					.toString(), user)) {
				throw new BusinessException("", option + "填写的物业来源分类为:"
						+ vo.getPrtsource().toString() + "固定参数不存在");
			}
		}
		if (vo.getIsconnected() != null && vo.getIsconnected().longValue() > 0) {
			if (!this.doCheckSystemParam("CH_ISCONNECTED", vo.getIsconnected()
					.toString(), user)) {
				throw new BusinessException("", option + " 填写的是否联网为:"
						+ vo.getIsconnected().toString() + "固定参数不存在");
			}
		}
		if (vo.getConnecttype() != null && vo.getConnecttype().longValue() > 0) {
			if (!this.doCheckSystemParam("CH_CONNECTTYPE", vo.getConnecttype()
					.toString(), user)) {
				throw new BusinessException("", option + "填写的联网方式为:"
						+ vo.getConnecttype().toString() + " 固定参数不存在");
			}
		}
		if (vo.getRunmode() != null && vo.getRunmode().longValue() > 0) {
			if (!this.doCheckSystemParam("CH_RUNMODE", vo.getRunmode()
					.toString(), user)) {
				throw new BusinessException("", option + "填写的经营模式为:"
						+ vo.getRunmode().toString() + " 固定参数不存在");
			}
		}
		if (vo.getIscoreway() != null && vo.getIscoreway().longValue() > 0) {
			if (!this.doCheckSystemParam("CH_ISCOREWAY", vo.getIscoreway()
					.toString(), user)) {
				throw new BusinessException("", option + "填写的是否中心渠道为:"
						+ vo.getIscoreway().toString() + " 固定参数不存在");
			}
		}
		if (vo.getStarlevel() != null && vo.getStarlevel().longValue() > 0) {
			if (!this.doCheckSystemParam("CH_STARLEVEL", vo.getStarlevel()
					.toString(), user)) {
				throw new BusinessException("", option + "填写的星级为:"
						+ vo.getStarlevel().toString() + "固定参数不存在");
			}
		}
		if (vo.getPt() != null && vo.getPt().longValue() > 0) {
			if (!this.doCheckSystemParam("CH_PT", vo.getPt().toString(), user)) {
				throw new BusinessException("", option + "填写的排他性为:"
						+ vo.getPt().toString() + "固定参数不存在");
			}
		}
		if (vo.getSignstatus() != null && vo.getSignstatus().longValue() > 0) {
			if (!this.doCheckSystemParam("CH_SIGNSTATUS", vo.getSignstatus()
					.toString(), user)) {
				throw new BusinessException("", option + "填写的签约状态为:"
						+ vo.getSignstatus().toString() + "固定参数不存在");
			}
		}
		if (vo.getIsstraitprd() != null && vo.getIsstraitprd().intValue() > 0) {
			if (!this.doCheckSystemParam("CH_STRAITPRD", vo.getIsstraitprd()
					.toString(), user)) {
				throw new BusinessException("", option + "填写的是否直供为:"
						+ vo.getIsstraitprd().toString() + "固定参数不存在");
			}
		}
		if (vo.getTaxtype() != null && vo.getTaxtype().intValue() > 0) {
			if (!this.doCheckSystemParam("CH_STTAXTYPE", vo.getTaxtype()
					.toString(), user)) {
				throw new BusinessException("", option + "填写的扣税方式为:"
						+ vo.getTaxtype().toString() + "固定参数不存在");
			}
		}
		if (vo.getBuztypecode() != null && vo.getBuztypecode().intValue() > 0) {
			if (!this.doCheckSystemParam("CH_BUZTYPE", vo.getBuztypecode()
					.toString(), user)) {
				throw new BusinessException("", option + "填写的商圈类型为:"
						+ vo.getBuztypecode().toString() + "固定参数不存在");
			}
		}

	}

	// 查询相应的VO是否在库表中存在
	private boolean doQueryExsist(Object vo, User user) throws Exception {
		BaseDAO dao = new BaseDAO(vo.getClass(), user.getCityid());
		SessionFactory sessionFactory = SessionUtil.obtainSessionFactory(dao
				.getDbFlag());
		ClassMetadata meadata = sessionFactory.getClassMetadata(vo.getClass());
		Serializable pk = meadata.getIdentifier(vo, EntityMode.POJO);
		if (dao.findByPk(pk) == null) {
			return false;
		}
		return true;
	}

	private boolean doCheckSystemParam(String groupid, String dictid, User user)
			throws Exception {
		DictitemVO vo = new DictitemVO();
		BaseDAO dao = new BaseDAO(DictitemVO.class, user.getCityid());
		;
		vo.setGroupid(groupid);
		vo.setDictid(dictid);
		vo = (DictitemVO) dao.findByPk(vo);
		if (vo == null) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param vo
	 * @param flag   增删改查标志               
	 * @param opract 同步方向0：boss同步给客服1：客服同步给boss  2: BOSS同步给业务支撑综合应用平台
	 * @param user
	 * @throws Exception
	 */
	public void doCreateWaySyn(WayVO vo, String flag,Short opract, User user)
			throws Exception {
		WaysynVO synVO = new WaysynVO();
		synVO.setOpract(opract);
		synVO.setOprtype(flag);
		synVO.setOprcode(user.getOpercode());
		synVO.setOprtime(new Date(System.currentTimeMillis()));
		synVO.setWayid(vo.getWayid());
		synVO.setWayname(vo.getWayname());
		synVO.setUpperwayid(vo.getUpperwayid());
		synVO
				.setCityid(SessionFactoryRouter.conversionCityid(user
						.getCityid()));
		synVO.setWaytype(vo.getWaytype());
		synVO.setWaystate(vo.getWaystate());
		getDelegate().doCreate(synVO, user);
	}

	private WaysynDelegate getDelegate() throws Exception {
		if (delegate == null) {
			return new WaysynDelegate();
		} else {
			return delegate;
		}
	}

	public DataPackage doQueryEmployee(WayListVO params, User user)
			throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		DataPackage dp = dao.queryEmployee(params, user.getWayid());
		return dp;
	}
	public DataPackage doQueryAllSubWays(WayListVO params,User user)throws Exception
	{
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return dao.queryAllSubways(params, user.getWayid());
	}

	public String doQueryWaybyCityid(String cityid,User user) throws Exception {
		// TODO Auto-generated method stub
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayVO wayvo=dao.queryWaybyCityid(cityid);
		if(wayvo!=null){
			return wayvo.getWayid();
		}
		return null;
	}
	
	public DataPackage doQueryAllUpperWays(WayListVO params, String basewayid,
			User user) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return dao.queryAllUpperWays(params, basewayid);
	}
	
	public List doQuerySharedUpperWay(String wayid, User user) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return dao.querySharedUpperWay(wayid);
	}
	
}
