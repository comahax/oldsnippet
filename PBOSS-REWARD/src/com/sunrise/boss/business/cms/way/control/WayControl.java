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
	 * 获取GMCC顶级渠道
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public WayVO getWayOfGMCC(User user) throws Exception;

	/**
	 * 获取取区域中心渠道
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
	 * 获取市公司渠道
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
	 * 获取县公司渠道
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
	 * 获取顶级渠道, 即无父渠道的渠道. 并不是GMCC直属渠道
	 * 
	 * @param countyid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public DataPackage getFirstLevelWays(User user) throws Exception;

	/**
	 * 获取某个渠道的直属子渠道
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public DataPackage getSubways(String wayid, User user) throws Exception;

	/**
	 * 不分层获取某个渠道的所有子渠道
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public DataPackage getAllSubways(String wayid, User user) throws Exception;

	/**
	 * 判断是否是某个渠道的直属子渠道
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
	 * 判断是否是某个渠道的子渠道(不论直属,非直属)
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
	 * 判断是否是GMCC直属型渠道
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public boolean isGMCCDirectWay(String wayid, User user) throws Exception;

	/**
	 * 判断是否是区域中心直属型渠道
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public boolean isCenterDirectWay(String wayid, User user) throws Exception;

	/**
	 * 判断是否是市公司直属型渠道
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public boolean isCitycomDirectWay(String wayid, User user) throws Exception;

	/**
	 * 判断是否是县公司直属型渠道
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
	 * 判断某个渠道是否存在
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 * @throws RemoteException
	 */
	public boolean isWayExist(String wayid, User user) throws Exception;

	/**
	 * 判断自定义类别是否被渠道使用
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
	 * 判断渠道类别是否被渠道使用
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
	 * 查询竞争对手自营渠道信息管理
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
	 * 查询零售渠道信息管理
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
	 * 查询指定渠道的所有直接上级渠道
	 * 
	 * @param baseWayid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryAllUpperWays(WayListVO params, String basewayid,
			User user) throws Exception;
	
	/**
	 * 查找所有直接上级共享渠道
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List doQuerySharedUpperWay(String wayid, User user) throws Exception;
}
