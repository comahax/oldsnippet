/**
 * auto-generated code
 * Thu Aug 24 15:28:14 CST 2006
 */
package com.sunrise.boss.business.cms.way.control;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

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
public interface WayControl extends AbstractControl {

	public WayVO doEdit(WayVO oldVO, WayVO newVO, User user) throws Exception;

	public WayVO doCreate(WayVO vo, User user) throws Exception;

	public void doRemove(WayVO vo, User user) throws Exception;

	public WayVO doUpdate(WayVO vo, User user) throws Exception;

	public WayVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(WayListVO params, User user) throws Exception;

	public DataPackage getWaysOfHeadquarter(User user) throws Exception;

	/**
	 * ��ȡGMCC��������
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public WayVO getWayOfGMCC(User user) throws Exception;

	/**
	 * ��ȡȡ������������
	 * 
	 * @param centerid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public DataPackage getWaysOfCenter(String centerid, User user)
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
	public DataPackage getWaysOfCitycom(String cityid, User user)
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
	public DataPackage getWaysOfCountycom(String countyid, User user)
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
	public DataPackage getFirstLevelWays(User user) throws Exception;

	/**
	 * ��ȡĳ��������ֱ��������
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public DataPackage getSubways(String wayid, User user) throws Exception;

	/**
	 * ���ֲ��ȡĳ������������������
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public DataPackage getAllSubways(String wayid, User user) throws Exception;

	/**
	 * �ж��Ƿ���ĳ��������ֱ��������
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public boolean isDirectSubwayOf(String wayid, String uppperwayid, User user)
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
	public boolean isSubwayOf(String wayid, String uppperwayid, User user)
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
	public boolean isGMCCDirectWay(String wayid, User user) throws Exception;

	/**
	 * �ж��Ƿ�����������ֱ��������
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public boolean isCenterDirectWay(String wayid, User user) throws Exception;

	/**
	 * �ж��Ƿ����й�˾ֱ��������
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public boolean isCitycomDirectWay(String wayid, User user) throws Exception;

	/**
	 * �ж��Ƿ����ع�˾ֱ��������
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public boolean isCountycomDirectWay(String wayid, User user)
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
	public boolean isWayExist(String wayid, User user) throws Exception;

	/**
	 * �ж��Զ�������Ƿ�����ʹ��
	 * 
	 * @param custtype
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public DataPackage getByCusttype(String custtype, User user)
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
	public DataPackage getByWaytype(String custtype, User user)
			throws Exception;

	public WayVO getUpperWay(String wayid, User user) throws Exception;

	public WayVO getCitycomDirectWayByWay(String wayid, User user)
			throws Exception;

	public WayVO getCountycomDirectWayByWay(String wayid, User user)
			throws Exception;

	public DataPackage queryUpperWaysAndMeByIdOrName(String queryText,
			boolean showDisabled, User user) throws Exception;

	public DataPackage doQueryByOprcode(WayListVO params, User user)
			throws Exception;

	/**
	 * ��ѯ����������Ӫ������Ϣ����
	 * 
	 * @param params
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryRvwaycnt(WayListVO params, User user)
			throws Exception;

	public boolean isAGWay(String wayid, String subtype, User user)
			throws Exception;

	/**
	 * ��ѯ����������Ϣ����
	 * 
	 * @param params
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQuerysaleway(WayListVO params, User user)
			throws Exception;

	public DataPackage doQueryEmployee(WayListVO params, User user)
			throws Exception;
	public DataPackage doQueryAllSubWays(WayListVO params, User user)
			throws Exception;
	
	public boolean doCheckisNetWork(String wayid,User user) throws Exception;
	public List doQueryNetWork(String wayid,User user) throws Exception;
	public String doQueryWaybyCityid(String cityid,User user) throws Exception;
	
	/**
	 * ��ѯָ������������ֱ���ϼ�����
	 * 
	 * @param baseWayid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryAllUpperWays(WayListVO params, String basewayid,
			User user) throws Exception;
	
	/**
	 * ��������ֱ���ϼ���������
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List doQuerySharedUpperWay(String wayid, User user) throws Exception;
}
