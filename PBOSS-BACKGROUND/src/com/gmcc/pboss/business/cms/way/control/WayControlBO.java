package com.gmcc.pboss.business.cms.way.control;


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

import com.gmcc.pboss.business.cms.way.persistent.WayDAO;
import com.gmcc.pboss.business.cms.way.persistent.WayListVO;
import com.gmcc.pboss.business.cms.way.persistent.WayVO;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;


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
public class WayControlBO extends AbstractControlBean implements Way {

	private static Log log = LogFactory.getLog(WayControlBO.class);



	public WayVO doCreate(WayVO vo) throws Exception {
		try {
			// TODO set the pk */
			WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);			
			WayVO wayVO = (WayVO) dao.create(vo);			
			return wayVO;
		} catch (Exception ex) {

			if (log.isInfoEnabled())
				log.info("create way failed, wayid:" + vo.getWayid(), ex);
			
			throw new JOPException(ex);

		}
	}

	/**
	 * �߼�ɾ��������״̬��Ϊ -1
	 * 
	 * @param vo
	 * @param cityID
	 * @throws Exception
	 */
	public void doRemove(WayVO vo) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		vo.setWaystate(new Short("0"));
		dao.update(vo);
	}

	public WayVO doUpdate(WayVO vo) throws Exception {
		try {
			WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
			
			Session session = SessionUtils.currentSession(dao.getDbFlag());
			// session.evict(oldVO);
			WayVO newVO = (WayVO) session.merge(vo);
			session.flush();
			return newVO;
			// return (WayVO) dao.update(vo);
		} catch (Exception ex) {
			
			throw new JOPException(ex);
		}
	}

	

	public WayVO doFindByPk(Serializable pk) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return (WayVO) dao.findByPk(pk);
	}

	/**
	 * ֻ��ѯֱ�Ӻͼ�Ӵ����ڵ�ǰ�û���������������������.
	 */
	public DataPackage doQuery(WayListVO params) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		DataPackage dp = dao.query(params);
		return dp;
	}

	


	/**
	 * ��ȡ�ϼ�����
	 * 
	 * @param wayid
	 * @param cityID
	 * @return
	 * @throws Exception
	 */
	public WayVO getUpperWay(String wayid) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayVO wayVO = (WayVO) dao.findByPk(wayid);
		if (wayVO == null || wayVO.getUpperwayid() == null)
			return null;
		else
			return (WayVO) dao.findByPk(wayVO.getUpperwayid());
	}

	public DataPackage getWaysOfHeadquarter(String cityID) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayListVO wayListVO = new WayListVO();
		wayListVO.getQueryConditions().put("_sn_upperwayid", "");
		wayListVO.getQueryConditions().put("_sn_centerid", "");
		wayListVO.getQueryConditions().put("_sn_cityid", "");
		wayListVO.getQueryConditions().put("_sn_countyid", "");
		wayListVO.set_pagesize("0");
		return dao.query(wayListVO);
	}

	public WayVO getWayOfGMCC(String cityID) throws Exception {
		List list = (List) getWaysOfHeadquarter(cityID);
		if (list.size() > 0)
			return (WayVO) list.get(0);
		else
			return null;
	}

	public DataPackage getWaysOfCenter(String centerid)
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

	public DataPackage getWaysOfCitycom(String cityid)
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

	public DataPackage getWaysOfCountycom(String countyid)
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

	public DataPackage getFirstLevelWays(String cityID) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayListVO wayListVO = new WayListVO();
		wayListVO.getQueryConditions().put("_sn_upperwayid", "");
		wayListVO.set_pagesize("0");
		return dao.query(wayListVO);
	}

	public DataPackage getSubways(String wayid) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayListVO wayListVO = new WayListVO();
		wayListVO.set_se_upperwayid(wayid);
		wayListVO.set_pagesize("0"); // ��pagesize��Ϊ0ʱ���������ݣ�����ҳ
		wayListVO.set_orderby("wayid"); // ��������ؼ���Ϊ����������
		return dao.query(wayListVO);
	}

	
	/**
	 * �ж��Ƿ���ĳ��������ֱ��������
	 * 
	 * @param wayid
	 * @param cityID
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public boolean isDirectSubwayOf(String wayid, String upperwayid)
			throws Exception {
		WayVO wayVO = doFindByPk(wayid);
		if (wayVO == null)
			throw new JOPException("CMS-10101", "�Ҳ�������, �������� " + wayid,null);

		WayVO upperWayVO = doFindByPk(upperwayid);
		if (upperWayVO == null)
			throw new JOPException("CMS-10101", "�Ҳ�������, �������� "
					+ upperwayid,null);
		/**
		 * @modify by Cao Wei
		 * @time 09.23 11:51
		 * @description ��Դ���������ж�
		 */
		return wayVO.getUpperwayid() != null
				&& wayVO.getUpperwayid().equals(upperwayid);
	}

	/**
	 * �ж��Ƿ���ĳ��������������(����ֱ��,��ֱ��)
	 */
	public boolean isSubwayOf(String wayid, String uppperwayid)
			throws Exception {
		WayVO wayVO = doFindByPk(wayid);
		if (wayVO == null)
			throw new JOPException("CMS-10101", "�Ҳ�������, �������� " + wayid,null);

		WayVO wayVO2 = doFindByPk(uppperwayid);
		if (wayVO2 == null)
			throw new JOPException("CMS-10101", "�Ҳ�������, �������� "
					+ uppperwayid,null);

		if (wayid.equals(uppperwayid))
			throw new JOPException("CMS-10101", "������ͬ: �������� " + wayid
					+ ", �ϼ����� " + uppperwayid,null);
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
	 * �Ƿ�����������ֱ������
	 */
	public boolean isCenterDirectWay(String wayid) throws Exception {
		WayVO wayVO = doFindByPk(wayid);
		if (wayVO == null)
			throw new JOPException("CMS-10101", "�Ҳ�������, �������� " + wayid,null);

		return (wayVO.getCenterid() != null && wayVO.getCityid() == null
				&& wayVO.getCountyid() == null && wayVO.getUpperwayid() == null);
	}

	/**
	 * �ж��Ƿ����й�˾ֱ������
	 */
	public boolean isCitycomDirectWay(String wayid) throws Exception {
		WayVO wayVO = doFindByPk(wayid);
		if (wayVO == null)
			throw new JOPException("CMS-10101", "�Ҳ�������, �������� " + wayid,null);

		// BOSS1.0�� �й�˾ֱ����������Ϊ1, ���ô˹���. ʡ����������ֱ������,����Ϊ0.
		return (wayVO.getCityid() != null
				&& wayVO.getWaylevel().shortValue() == 1 && wayVO.getCountyid() == null // ���������,
		// ��ֱ������Ҳ���ع�˾����,
		// ��ʱ���δ��ж�,
		);
	}

	/**
	 * �ж��Ƿ����ع�˾ֱ������
	 */
	public boolean isCountycomDirectWay(String wayid)
			throws Exception {
		WayVO wayVO = doFindByPk(wayid);
		if (wayVO == null)
			throw new JOPException("CMS-10101", "�Ҳ�������, �������� " + wayid,null);

		String upperwayid = wayVO.getUpperwayid();
		if (upperwayid == null)
			return false; // û���ϼ�����������ֻ��ʡ��˾ֱ������,����������ع�˾ֱ������

		WayVO upperayVO = doFindByPk(upperwayid);
		if (upperayVO == null)
			throw new JOPException("CMS-10102", "�Ҳ��������ĸ�����, �������� " + wayid
					+ ", ����������:" + upperayVO,null);
		return upperayVO.getCityid() != null && upperayVO.getCountyid() == null;
	}

	/**
	 * �ж��Ƿ���GMCCֱ������
	 */
	public boolean isGMCCDirectWay(String wayid) throws Exception {
		WayVO wayVO = doFindByPk(wayid);
		if (wayVO == null)
			throw new JOPException("CMS-10101", "�Ҳ�������, �������� " + wayid,null);

		return (wayVO.getCenterid() == null && wayVO.getCityid() == null
				&& wayVO.getCountyid() == null && wayVO.getUpperwayid() == null);
	}

	/**
	 * �ж������Ƿ����
	 * 
	 * @param wayid
	 * @param cityID
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public boolean isWayExist(String wayid) throws Exception {
		WayVO wayVO = doFindByPk(wayid);
		if (wayVO == null)
			return false;
		else
			return true;
	}

	/**
	 * �ж��Զ�������Ƿ�����ʹ��
	 */
	public DataPackage getByCusttype(String custtype)
			throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayListVO wayListVO = new WayListVO();
		wayListVO.set_se_custtype(custtype);
		return dao.query(wayListVO);
	}

	/**
	 * �ж���������Ƿ�����ʹ��
	 */
	public DataPackage getByWaytype(String waytype) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayListVO wayListVO = new WayListVO();
		wayListVO.set_se_waytype(waytype);
		return dao.query(wayListVO);
	}

	/**
	 * ����һ���ض�����, ��ȡ�������й�˾��ֱ��(����)����
	 */
	public WayVO getCitycomDirectWayByWay(String wayid)
			throws Exception {
		WayVO wayVO = checkWayid(wayid);

		String cityid = wayVO.getCityid();
		if (cityid == null) {
			// throw new JOPException("CMS-10121","��ǰ�����������й�˾,��������:" +
			// wayid);
			// �����䱾��
			return wayVO;
		}

		WayListVO listVO = new WayListVO();
		listVO.set_se_cityid(cityid);
		listVO.getQueryConditions().put("_ne_waylevel", new Short((short) 1));

		List list = (List) (doQuery(listVO).getDatas());
		if (list.size() > 0)
			return (WayVO) list.get(0);

		return null;
	}

	/**
	 * ����һ���ض�����, ��ȡ�������ع�˾��ֱ��(����)����
	 */
	public WayVO getCountycomDirectWayByWay(String wayid)
			throws Exception {
		WayVO wayVO = checkWayid(wayid);

		String countyid = wayVO.getCountyid();
		if (countyid == null)
			throw new JOPException("CMS-10121", "��ǰ�����������ع�˾,��������:" + wayid,null);

		WayListVO listVO1 = new WayListVO();
		listVO1.set_se_countyid(countyid);

		WayListVO listVO2 = new WayListVO(); // ���й�˾
		listVO2.getQueryConditions().put("_snn_cityid", "");
		listVO2.getQueryConditions().put("_sn_countyid", "");

		WayDAO wayDAO = (WayDAO) DAOFactory.build(WayDAO.class, user);
		List list = (List) wayDAO.unionQuery(new Object[] { listVO1, listVO2 },
				new Class[] { WayListVO.class, WayListVO.class },
				new String[][] { { "upperwayid", "wayid" } }).getDatas();

		if (list.size() > 1) {
			throw new JOPException("CMS-10113",
					"���ݷǷ�, �ҵ������Ķ�������ϼ�����, ��������:" + wayid,null);
		}
		if (list.size() > 0)
			return (WayVO) list.get(0);

		return null;
	}

	private WayVO checkWayid(String wayid) throws Exception {
		WayVO wayVO = doFindByPk(wayid);
		if (wayVO == null)
			throw new JOPException("CMS-10101", "�Ҳ�������, �������� " + wayid,null);
		return wayVO;
	}

	public DataPackage queryUpperWaysAndMeByIdOrName(String queryText,
			boolean showDisabled) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return dao.queryUpperWaysAndMeByIdOrName(queryText, showDisabled);
	}
	
	public boolean doCheckisNetWork(String wayid,String cityID) throws Exception{
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return dao.checkisNetWork(wayid);
	}
	public List doQueryNetWork(String wayid,String cityID) throws Exception{
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		return dao.queryNetWork(wayid);
	}
	

	public WayVO doEdit(WayVO oldVO, WayVO newVO) throws Exception {
		this.doRemove(oldVO);
		this.doCreate(newVO);
		return null;
	}

	/**
	 * ���ݲ���Ա���ڵ�������ѯ�����������������¼
	 * 
	 * @param params
	 * @param cityID
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryByOprcode(WayListVO params)
			throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		
		return null;
	}

	/**
	 * ��ѯ����������Ӫ������Ϣ����
	 * 
	 * @param params
	 * @param cityID
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryRvwaycnt(WayListVO params)
			throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		
		return null;

	}

	/**
	 * �ж������Ƿ�Ϊ�������(AG)
	 * 
	 * @param wayid
	 * @return
	 * @throws Exception
	 */
	public boolean isAGWay(String wayid, String subtype)
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

	public DataPackage doQuerysaleway(WayListVO params)
			throws Exception {
		return null;
	}

	private boolean doCheckwayid(String upperwayid) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		Object object = dao.findByPk(upperwayid);
		if (object == null) {
			return false;
		}
		return true;
	}

	public DataPackage doQueryAllSubWays(WayListVO params)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public DataPackage doQueryAllUpperWays(WayListVO params, String basewayid,
			String cityID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public DataPackage doQueryEmployee(WayListVO params)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List doQuerySharedUpperWay(String wayid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String doQueryWaybyCityid(String cityid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public DataPackage getAllSubways(String wayid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String doQueryWaybyCityid(String cityid, String cityID2)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
