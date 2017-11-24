package com.gmcc.pboss.business.cms.way.control;


import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import com.gmcc.pboss.business.cms.way.persistent.WayListVO;
import com.gmcc.pboss.business.cms.way.persistent.WayVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;


/**
 * <p>
 * Title: WayControl
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
public interface Way extends AbstractControl {

	public WayVO doEdit(WayVO oldVO, WayVO newVO) throws Exception;

	public WayVO doCreate(WayVO vo) throws Exception;

	public void doRemove(WayVO vo) throws Exception;

	public WayVO doUpdate(WayVO vo) throws Exception;

	public WayVO doFindByPk(Serializable pk) throws Exception;

	public DataPackage doQuery(WayListVO params) throws Exception;

	public DataPackage getWaysOfHeadquarter(String cityID) throws Exception;

	/**
	 * ��ȡGMCC��������
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public WayVO getWayOfGMCC(String cityID) throws Exception;

	/**
	 * ��ȡȡ������������
	 * 
	 * @param centerid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public DataPackage getWaysOfCenter(String centerid)
			throws Exception;

	/**
	 * ��ȡ�й�˾����
	 * 
	 * @param cityid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public DataPackage getWaysOfCitycom(String cityid)
			throws Exception;

	/**
	 * ��ȡ�ع�˾����
	 * 
	 * @param countyid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public DataPackage getWaysOfCountycom(String countyid)
			throws Exception;

	/**
	 * ��ȡ��������, ���޸�����������. ������GMCCֱ������
	 * 
	 * @param countyid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public DataPackage getFirstLevelWays(String cityID) throws Exception;

	/**
	 * ��ȡĳ��������ֱ��������
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public DataPackage getSubways(String wayid) throws Exception;

	/**
	 * ���ֲ��ȡĳ������������������
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public DataPackage getAllSubways(String wayid) throws Exception;

	/**
	 * �ж��Ƿ���ĳ��������ֱ��������
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public boolean isDirectSubwayOf(String wayid, String uppperwayid)
			throws Exception;

	/**
	 * �ж��Ƿ���ĳ��������������(����ֱ��,��ֱ��)
	 * 
	 * @param wayid
	 * @param uppperwayid
	 * @param direct
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public boolean isSubwayOf(String wayid, String uppperwayid)
			throws Exception;

	/**
	 * �ж��Ƿ���GMCCֱ��������
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public boolean isGMCCDirectWay(String wayid) throws Exception;

	/**
	 * �ж��Ƿ�����������ֱ��������
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public boolean isCenterDirectWay(String wayid) throws Exception;

	/**
	 * �ж��Ƿ����й�˾ֱ��������
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public boolean isCitycomDirectWay(String wayid) throws Exception;

	/**
	 * �ж��Ƿ����ع�˾ֱ��������
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public boolean isCountycomDirectWay(String wayid)
			throws Exception;

	/**
	 * �ж�ĳ�������Ƿ����
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public boolean isWayExist(String wayid) throws Exception;

	/**
	 * �ж��Զ�������Ƿ�����ʹ��
	 * 
	 * @param custtype
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public DataPackage getByCusttype(String custtype)
			throws Exception;

	/**
	 * �ж���������Ƿ�����ʹ��
	 * 
	 * @param custtype
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public DataPackage getByWaytype(String custtype)
			throws Exception;

	public WayVO getUpperWay(String wayid) throws Exception;

	public WayVO getCitycomDirectWayByWay(String wayid)
			throws Exception;

	public WayVO getCountycomDirectWayByWay(String wayid)
			throws Exception;

	public DataPackage queryUpperWaysAndMeByIdOrName(String queryText,
			boolean showDisabled) throws Exception;

	public DataPackage doQueryByOprcode(WayListVO params)
			throws Exception;

	/**
	 * ��ѯ����������Ӫ������Ϣ����
	 * 
	 * @param params
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryRvwaycnt(WayListVO params)
			throws Exception;

	public boolean isAGWay(String wayid, String subtype)
			throws Exception;

	/**
	 * ��ѯ����������Ϣ����
	 * 
	 * @param params
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQuerysaleway(WayListVO params)
			throws Exception;

	public DataPackage doQueryEmployee(WayListVO params)
			throws Exception;
	public DataPackage doQueryAllSubWays(WayListVO params)
			throws Exception;
	
	public boolean doCheckisNetWork(String wayid,String cityID) throws Exception;
	public List doQueryNetWork(String wayid,String cityID) throws Exception;
	public String doQueryWaybyCityid(String cityid,String cityID) throws Exception;
	
	/**
	 * ��ѯָ������������ֱ���ϼ�����
	 * 
	 * @param baseWayid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryAllUpperWays(WayListVO params, String basewayid,
			String cityID) throws Exception;
	
	/**
	 * ��������ֱ���ϼ���������
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List doQuerySharedUpperWay(String wayid) throws Exception;
}
