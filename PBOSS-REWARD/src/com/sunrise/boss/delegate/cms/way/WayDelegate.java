/**
 * auto-generated code
 * Thu Aug 24 15:28:14 CST 2006
 */
package com.sunrise.boss.delegate.cms.way;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.employee.control.EmployeeControl;
import com.sunrise.boss.business.cms.employee.control.EmployeeControlBean;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeListVO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeVO;
import com.sunrise.boss.business.cms.way.control.WayControl;
import com.sunrise.boss.business.cms.way.control.WayControlBean;
import com.sunrise.boss.business.cms.way.persistent.AGWayVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

/**
 * <p>
 * Title: WayDelegate
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
public class WayDelegate {

	private static WayControl control;

	public WayDelegate() throws Exception {
		control = (WayControl) ControlFactory.build(WayControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public WayVO doEdit(WayVO oldVO, WayVO newVO, User user) throws Exception {
		return control.doEdit(oldVO, newVO, user);
	}

	public WayVO doCreate(WayVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(WayVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public WayVO doUpdate(WayVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public WayVO doFindByPk(Serializable pk, User user) throws Exception {
		return (WayVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(WayListVO params, User user) throws Exception {
		return control.doQuery(params, user);
	}

	public DataPackage getWayTree(WayListVO params, User user) throws Exception {
		return null;
	}

	public DataPackage getWaysOfHeadquarter(User user) throws Exception {
		return control.getWaysOfHeadquarter(user);
	}

	public DataPackage getWaysOfCenter(String centerid, User user)
			throws Exception {
		return control.getWaysOfCenter(centerid, user);
	}

	public DataPackage getWaysOfCitycom(String cityid, User user)
			throws Exception {
		return control.getWaysOfCitycom(cityid, user);
	}

	public DataPackage getWaysOfCountycom(String countyid, User user)
			throws Exception {
		return control.getWaysOfCountycom(countyid, user);
	}

	public DataPackage getSubways(String wayid, User user) throws Exception {
		return control.getSubways(wayid, user);
	}

	public DataPackage getAllSubways(String wayid, User user) throws Exception {
		return control.getSubways(wayid, user);
	}

	public boolean isSubwayOf(String wayid, String upperwayid, User user)
			throws Exception {
		return control.isSubwayOf(wayid, upperwayid, user);
	}

	public WayVO getWayOfGMCC(User user) throws Exception {
		return control.getWayOfGMCC(user);
	}

	public boolean isCenterDirectWay(String wayid, User user) throws Exception {
		return control.isCenterDirectWay(wayid, user);
	}

	public boolean isCitycomDirectWay(String wayid, User user) throws Exception {
		return control.isCitycomDirectWay(wayid, user);
	}

	public boolean isCountycomDirectWay(String wayid, User user)
			throws Exception {
		return control.isCountycomDirectWay(wayid, user);
	}

	public boolean isDirectSubwayOf(String wayid, String uppperwayid, User user)
			throws Exception {
		return control.isDirectSubwayOf(wayid, uppperwayid, user);
	}

	public boolean isGMCCDirectWay(String wayid, User user) throws Exception {
		return control.isGMCCDirectWay(wayid, user);
	}

	public boolean isWayExist(String wayid, User user) throws Exception {
		return control.isWayExist(wayid, user);
	}

	public DataPackage getFirstLevelWays(User user) throws Exception {
		return control.getFirstLevelWays(user);
	}

	public WayVO getUpperWay(String wayid, User user) throws Exception {
		return control.getUpperWay(wayid, user);
	}

	public DataPackage getByCusttype(String custtype, User user)
			throws Exception {
		return control.getByCusttype(custtype, user);
	}

	public DataPackage getByWaytype(String custtype, User user)
			throws Exception {
		return control.getByWaytype(custtype, user);
	}

	public WayVO getCitycomDirectWayByWay(String wayid, User user)
			throws Exception {
		return control.getCitycomDirectWayByWay(wayid, user);
	}

	public WayVO getCountycomDirectWayByWay(String wayid, User user)
			throws Exception {
		return control.getCountycomDirectWayByWay(wayid, user);
	}

	public DataPackage queryUpperWaysAndMeByIdOrName(String queryText,
			boolean showDisabled, User user) throws Exception {
		return control.queryUpperWaysAndMeByIdOrName(queryText, showDisabled,
				user);
	}

	public DataPackage doQueryByOprcode(WayListVO params, User user)
			throws Exception {
		return control.doQueryByOprcode(params, user);
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
		return control.doQueryRvwaycnt(params, user);

	}

	public boolean isAGWay(String wayid, String subtype, User user)
			throws Exception {
		return control.isAGWay(wayid, subtype, user);
	}

	/**
	 * 查询零售渠道信息管理
	 * 
	 * @param params
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQuerysaleway(WayListVO params, User user)
			throws Exception {
		DataPackage dp = new DataPackage();
		DataPackage dataPackage = control.doQuerysaleway(params, user);
		List list = (List) dataPackage.getDatas();
		Collection collection = new ArrayList();
		EmployeeControl employeeControl = (EmployeeControl) ControlFactory
				.build(EmployeeControlBean.class);
		for (int i = 0; i < list.size(); i++) {
			WayVO wayVO = (WayVO) list.get(i);
			AGWayVO agway = new AGWayVO();
			BeanUtils.copyProperties(agway, wayVO);
			EmployeeListVO listVO = new EmployeeListVO();
			listVO.set_se_wayid(wayVO.getWayid());
			listVO.set_ne_isnet("1");
			listVO.set_ne_empstatus("0");
			Iterator employee = employeeControl.doQuery(listVO, user)
					.getDatas().iterator();
			if (employee.hasNext()) {
				EmployeeVO employeevo = (EmployeeVO) employee.next();
				agway.setIsopen(employeevo.getIsopen());
				agway.setOfficetel(employeevo.getOfficetel());
			}
			collection.add(agway);
		}
		dp.setDatas(collection);
		dp.setRowCount(dataPackage.getRowCount());
		dp.setPageNo(dataPackage.getPageNo());
		dp.setPageSize(dataPackage.getPageSize());
		return dp;
	}

	public DataPackage queryEmployee(WayListVO params, User user)
			throws Exception {
		DataPackage dp = new DataPackage();
		DataPackage dataPackage = control.doQueryEmployee(params, user);
		List list = (List) dataPackage.getDatas();
		Collection collection = new ArrayList();
		EmployeeControl employeeControl = (EmployeeControl) ControlFactory
				.build(EmployeeControlBean.class);
		for (int i = 0; i < list.size(); i++) {
			WayVO wayVO = (WayVO) list.get(i);
			AGWayVO agway = new AGWayVO();
			BeanUtils.copyProperties(agway, wayVO);
			EmployeeListVO listVO = new EmployeeListVO();
			listVO.set_se_wayid(wayVO.getWayid());
			listVO.set_ne_isnet("1");
			listVO.set_ne_empstatus("0");
			Iterator employee = employeeControl.doQuery(listVO, user)
					.getDatas().iterator();
			if (employee.hasNext()) {
				EmployeeVO employeevo = (EmployeeVO) employee.next();
				agway.setIsopen(employeevo.getIsopen());
				agway.setOfficetel(employeevo.getOfficetel());
			}
			collection.add(agway);
		}
		dp.setDatas(collection);
		dp.setRowCount(dataPackage.getRowCount());
		dp.setPageNo(dataPackage.getPageNo());
		dp.setPageSize(dataPackage.getPageSize());
		return dp;
	}
	public DataPackage doQueryAllSubWays(WayListVO params,User user)throws Exception{
		return control.doQueryAllSubWays(params, user);
	}
	public boolean doCheckisNetWork(String wayid,User user) throws Exception{
		return control.doCheckisNetWork(wayid, user);
	}
	public List doQueryNetWork(String wayid,User user) throws Exception{
		return control.doQueryNetWork(wayid, user);
	}
	public String doQueryWaybyCityid(String cityid,User user) throws Exception{
		return control.doQueryWaybyCityid(cityid, user);
	}
	
	public DataPackage doQueryAllUpperWays(WayListVO params, String basewayid,
			User user) throws Exception {
		return control.doQueryAllUpperWays(params, basewayid, user);
	}
	
	/**
	 * 查找所有直接上级共享渠道
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List doQuerySharedUpperWay(String wayid, User user) throws Exception {
		return control.doQuerySharedUpperWay(wayid, user);
	}
}
