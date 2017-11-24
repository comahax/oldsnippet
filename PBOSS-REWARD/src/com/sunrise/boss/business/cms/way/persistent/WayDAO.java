/**
 * auto-generated code Thu Aug 24 15:28:14 CST 2006
 */
package com.sunrise.boss.business.cms.way.persistent;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: WayDAO
 * </p>
 * <p>
 * Description: Data Access Object for WayVO
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
public class WayDAO extends BaseLogDAO {

	/**
	 * default constructor
	 */
	public WayDAO() {
		super(WayVO.class);
	}

	public void flushSession() {
		Session session = SessionUtil.currentSession(getDbFlag());
		session.flush();
		session.clear();
	}

	public DataPackage queryUpperWaysAndMeByIdOrName(String queryText,
			boolean showDisabled) {
		Session session = SessionUtil.currentSession(getDbFlag());

		Query query = session.getNamedQuery("queryUpperWaysAndMeByIdOrName");

		query.setParameter("idorname", "%" + queryText + "%");
		if (!showDisabled)
			query.setParameter("waystate", new Short((short) 1));
		else
			query.setParameter("waystate", new Short((short) 0));

		List list = query.list();

		DataPackage dataPack = new DataPackage();
		dataPack.setDatas(list);
		dataPack.setPageNo(0);
		dataPack.setPageSize(0);
		dataPack.setRowCount(list.size());
		return dataPack;
	}
	
	public WayVO queryWaybyCityid(String cityid) throws Exception{
		Session session = SessionUtil.currentSession(getDbFlag());
		Query query=session.getNamedQuery("getwaybycityid");
		query.setString("cityid", cityid);
		List list=query.list();
		if(list.size()>0){
			return (WayVO)list.get(0);
		}
		return null;
	}
	
	public boolean checkisNetWork(String wayid) throws Exception{
		Session session = SessionUtil.currentSession(getDbFlag());
		Query query = session.getNamedQuery("checkisnetwork");
		query.setString("basewayid", wayid);
		List list=query.list();
		if(list.size()>0){
			Long number=(Long)list.get(0);
			if(number.intValue()>0){
				return true;
			}
		}
		return false;
	}
	
	public List queryNetWork(String wayid) throws Exception{
		Session session = SessionUtil.currentSession(getDbFlag());
		Query query = session.getNamedQuery("querynetwork");
		query.setString("basewayid", wayid);
		List list=query.list();
		return list;
	}

	public List getSubways(String upperwayid) throws Exception {
		WayListVO listVO = new WayListVO();
		ArrayList field = new ArrayList();
		field.add("wayid");
		field.add("upperwayid");
		listVO.setSelectFields(field);
		listVO.set_se_upperwayid(upperwayid);
		return (List) query(listVO).getDatas();
	}

	/**
	 * 社会渠道查询，查询操作员可以浏览的记录 add by yjr
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryByOprcode(WayListVO params, String baseWayid)
			throws Exception {
		Session session = SessionUtil.currentSession(getDbFlag());

		SQLQuery query = (SQLQuery) session
				.getNamedQuery("boss.cms.queryWayByUser");
		String queryString = query.getQueryString();
		params.getQueryConditions().put("basewayid", baseWayid);
		return queryBySql(queryString, params, 0);
	}

	/**
	 * 查询竞争对手自营渠道信息管理 yuanweihai
	 * 
	 * @param params
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage queryRvwaycnt(WayListVO params, String baseWayid)
			throws Exception {
		Session session = SessionUtil.currentSession(getDbFlag());
		WayVO wayvo = (WayVO) findByPk(baseWayid);
		if (wayvo == null) {
			return new DataPackage();
		}
		SQLQuery query = (SQLQuery) session
				.getNamedQuery("boss.cms.queryRvwaycnt");
		StringBuffer queryString = new StringBuffer(query.getQueryString());
		if (wayvo.getMareacode() != null) {
			queryString.append(" and mareacode='" + wayvo.getMareacode() + "'");
		} else if (wayvo.getSvccode() != null) {
			queryString.append(" and svccode='" + wayvo.getSvccode() + "'");

		} else if (wayvo.getCountyid() != null) {
			queryString.append(" and countyid='" + wayvo.getCountyid() + "'");
		} else if (wayvo.getCityid() != null) {
			queryString.append(" and cityid='" + wayvo.getCityid() + "'");
		}
		return queryBySql(queryString.toString(), params, 0);
	}

	/**
	 * 得到该(wayid)渠道是否属于当前渠到的下属(实体)渠道
	 */

	public DataPackage getIsupperwayid(String basewayid, String wayid)
			throws Exception {
		Session session = SessionUtil.currentSession(getDbFlag());
		WayListVO listVO = new WayListVO();
		SQLQuery query = (SQLQuery) session
				.getNamedQuery("boss.cms.queryUpperWayidNum");
		String queryString = query.getQueryString();
		listVO.getQueryConditions().put("basewayid", basewayid);
		listVO.getQueryConditions().put("wayid", wayid);
		return queryBySql(queryString, listVO, 0);

	}

	/**
	 * 查询零售渠道信息管理
	 * 
	 * @param params
	 * @param baseWayid
	 * @return
	 * @throws Exception
	 */
	public DataPackage querySaleway(WayListVO params, String baseWayid)
			throws Exception {
		params.getQueryConditions().put("basewayid", baseWayid);
		return queryByNamedSqlQuery("boss.cms.querySaleway", params, 0);
	}

	/**
	 * 查询当前渠道已经共享（ISSHARE=1）的所有上级渠道（包括当前渠道）
	 * 
	 * @param wayid
	 * @return
	 * @throws Exception
	 */
	public List querySharedUpperWay(String wayid) throws Exception {
		BaseListVO listVO = new BaseListVO();
		listVO.set_pagesize("0");
		listVO.getQueryConditions().put("wayid", wayid);

		DataPackage dp = queryByNamedSqlQuery("boss.cms.querySharedUpperWay",
				listVO);

		return (List) dp.getDatas();
	}

	public DataPackage queryAllSubways(String basewayid) throws Exception {
		WayListVO params = new WayListVO();
		params.set_pagesize("0");
		params.getQueryConditions().put("basewayid", basewayid);
		return queryByNamedSqlQuery("boss.cms.queryAllSubWay", params, 0);
	}
	public DataPackage queryAllSubways(WayListVO params,String basewayid) throws Exception {
		params.getQueryConditions().put("basewayid", basewayid);
		return queryByNamedSqlQuery("boss.cms.queryAllSubWay", params, 0);
	}
	/**
	 * 查询所有当前渠道的子渠道 boss.cms.querySvwayinfo
	 * 
	 * @param params
	 * @param baseWayid
	 * @return DataPackage
	 * @throws Exception
	 */
	public DataPackage queryEmployee(WayListVO params, String baseWayid)
			throws Exception {
		params.getQueryConditions().put("basewayid", baseWayid);
		return queryByNamedSqlQuery("boss.cms.querySvwayinfo", params, 0);
	}
	
	public void registerLog(String methodName, Object vo ,User user) throws Exception {				
		Class voClass = vo.getClass();

		if(vo instanceof OperationLog) {
			OperationLog operationLog = (OperationLog)vo;
			Class logVOClass = operationLog.logVOClass();
			Object logvo = logVOClass.newInstance();
			registerOperationLog(methodName, vo, logvo,user);
		}		
	}
	
	/**
	 * 查询指定渠道的所有直接上级渠道
	 * @param basewayid
	 * @return
	 */
	public DataPackage queryAllUpperWays(WayListVO params, String basewayid) throws Exception {
		if (StringUtils.isEmpty(basewayid)) {
			throw new Exception("指定渠道不能为空!");
		}
		params.getQueryConditions().put("basewayid", basewayid);
		return queryByNamedSqlQuery("boss.cms.queryAllUpperWays", params, 0);
	}
}
