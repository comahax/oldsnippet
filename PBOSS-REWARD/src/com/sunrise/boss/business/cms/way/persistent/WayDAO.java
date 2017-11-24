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
	 * ���������ѯ����ѯ����Ա��������ļ�¼ add by yjr
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
	 * ��ѯ����������Ӫ������Ϣ���� yuanweihai
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
	 * �õ���(wayid)�����Ƿ����ڵ�ǰ����������(ʵ��)����
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
	 * ��ѯ����������Ϣ����
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
	 * ��ѯ��ǰ�����Ѿ�����ISSHARE=1���������ϼ�������������ǰ������
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
	 * ��ѯ���е�ǰ������������ boss.cms.querySvwayinfo
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
	 * ��ѯָ������������ֱ���ϼ�����
	 * @param basewayid
	 * @return
	 */
	public DataPackage queryAllUpperWays(WayListVO params, String basewayid) throws Exception {
		if (StringUtils.isEmpty(basewayid)) {
			throw new Exception("ָ����������Ϊ��!");
		}
		params.getQueryConditions().put("basewayid", basewayid);
		return queryByNamedSqlQuery("boss.cms.queryAllUpperWays", params, 0);
	}
}
