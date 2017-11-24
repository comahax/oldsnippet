package com.sunrise.boss.business.resmanage.common;

import com.sunrise.boss.business.admin.acl.control.ACLControl;
import com.sunrise.boss.business.admin.acl.control.ACLControlBean;
import com.sunrise.boss.business.cms.way.control.WayControl;
import com.sunrise.boss.business.cms.way.control.WayControlBean;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamDAO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;

/**
 * 
 * @author Cscw
 * @version 1.0
 * @description 资源调拨合法性检查方法
 * 
 */
public class CheckWayId {

	private static final Long wayNO = new Long(9); // 渠道判断系统参数标志

	private static final String resource = "resource"; // 渠道参数名

	private static final String NOCheck = "0"; // 不进行渠道判断标志

	private CheckWayId() {

	}

	/**
	 * @description 从系统参数表查询参数值
	 * @param user
	 * @return String paramvalue
	 * @throws Exception
	 */
	public static String CheckYesOrNo(User user) throws Exception {
		SysparamDAO dao = (SysparamDAO) DAOFactory.build(SysparamDAO.class,
				user.getCityid());
		return dao.doFindByID(wayNO, resource);
	}

	/**
	 * @description 根据参数值判断是否需要进行渠道判断，第一个参数为上级渠道，第二个为下级渠道
	 *              如果渠道等级正确返回true，否则返回false
	 * @param highwayid
	 * @param lowwayid
	 * @param user
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean CheckWay(String highwayid, String lowwayid, User user)
			throws Exception {
		String result = CheckYesOrNo(user);
		if (!CheckisWayExist(highwayid, user)) {
			throw new Exception("渠道" + highwayid + "不存在");
		}
		if (!CheckisWayExist(lowwayid, user)) {
			throw new Exception("渠道" + lowwayid + "不存在");
		}
		if (highwayid.equals(lowwayid))
			throw new Exception("操作失败，渠道" + highwayid + "和" + lowwayid + "相同");
		if (result == null) {
			throw new Exception("系统参数表里面没有是否进行渠道层次判断记录，不能进行业务操作");
		} else if (!result.equals(NOCheck)) {
			WayControl control;
			try {
				control = (WayControl) ControlFactory
						.build(WayControlBean.class);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("建立渠道接口失败");
			}
			return control.isDirectSubwayOf(lowwayid, highwayid, user);
		}
		return true;
	}

	/**
	 * @description 判断输入渠道是否存在
	 * @param wayid
	 * @param user
	 * @return 存在返回 true 不存在返回 false
	 * @throws Exception
	 */
	public static boolean CheckisWayExist(String wayid, User user)
			throws Exception {
		WayControl control;
		try {
			control = (WayControl) ControlFactory.build(WayControlBean.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("建立渠道接口失败");
		}
		return control.isWayExist(wayid, user);
	}

	/**
	 * @description 判断是否是某个渠道的子渠道(不论直属,非直属)
	 * @param wayid
	 *            子渠道
	 * @param uppperwayid
	 *            父渠道
	 * @param user
	 * @return true or false
	 * @throws Exception
	 */
	public static boolean isSubwayOf(String wayid, String upperwayid, User user)
			throws Exception {
		WayControl control;
		try {
			control = (WayControl) ControlFactory.build(WayControlBean.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("建立渠道接口失败");
		}
		return control.isSubwayOf(wayid, upperwayid, user);
	}

	/**
	 * @description 判断操作员是否拥有修改该号码状态的权限
	 * @param opercode
	 *            操作员工号
	 * @param wayid
	 *            号码所属渠道
	 * @return
	 * @throws Exception
	 */
//	public static void chkNoStateChgPermission(User user, String wayid)
//			throws Exception {
//		ACLControl control;
//		try {
//			control = (ACLControl) ControlFactory.build(ACLControlBean.class);
//		} catch (Exception e) {
//			throw new Exception("建立权限判断接口失败");
//		}
//
//		String rightCity = "NOSTATECHG_CITY";// 允许修改市公司渠道所有渠道的号码的状态
//		String rightCurrWay = "NOSTATECHG_CUURWAY";// 只允许修改本渠道的号码的状态
//		String rightAllSubways = "NOSTATECHG_ALLSUBWAYS";// 允许修改本渠道及其所有下属渠道的号码的状态
//
//		if (control.checkPermission(user.getOpercode(), rightCity)) {
//			return;
//		}
//		if (control.checkPermission(user.getOpercode(), rightCurrWay)) {
//			if (user.getWayid().equals(wayid)) {
//				return;
//			}
//		}
//		if (control.checkPermission(user.getOpercode(), rightAllSubways)) {
//			if (user.getWayid().equals(wayid)
//					|| isSubwayOf(wayid, user.getWayid(), user)) {
//				return;
//			}
//		}
//
//		throw new Exception("所选号码资源属于渠道[" + wayid
//				+ "],你没有修改该渠道号码资源状态的权限,请确认赋权!");
//	}

	/**
	 * @description 判断当前用户是否有操作指定渠道资源的权限 此方法支持三级权限控制判断，即：市公司权限，本渠道及下属渠道权限，本渠道权限<br>
	 *              默认具有本渠道权限，因此只需增加地市、下属渠道两个令牌，约定其对应的令牌后缀分别为_CITY,_ALLSUBWAYS，故只需传递前缀即可，如号码属性修改:
	 *              NOPROCHG
	 * 
	 * @param prefix
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public static boolean checkWayPermission(String prefix, String wayid,
			User user) throws Exception {
		ACLControl control;
		try {
			control = (ACLControl) ControlFactory.build(ACLControlBean.class);
		} catch (Exception e) {
			throw new Exception("建立权限判断接口失败!");
		}

		String rightCity = prefix + "_CITY";// 市公司权限
		String rightAllSubways = prefix + "_ALLSUBWAYS";// 本渠道及下属渠道权限

		if (control.checkPermission(user.getOpercode(), rightCity)) {
			return true;
		}

		if (control.checkPermission(user.getOpercode(), rightAllSubways)) {
			if (user.getWayid().equals(wayid)
					|| isSubwayOf(wayid, user.getWayid(), user)) {
				return true;
			}
		}

		// 默认具有本渠道权限
		if (user.getWayid().equals(wayid)) {
			return true;
		}

		return false;
	}

	/**
	 * @description 判断指定wayid是否代理商
	 * @param wayid
	 * @param user
	 * @return 是代理商返回 true,不是代理商返回 false
	 * @throws Exception
	 */
//	public static boolean isAgent(String wayid, User user) throws Exception {
//		AgentnopoolrelaControl control;
//		try {
//			control = (AgentnopoolrelaControl) ControlFactory
//					.build(AgentnopoolrelaControlBean.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new Exception("建立渠道接口失败");
//		}
//		return control.isAgent(wayid, user);
//	}

}