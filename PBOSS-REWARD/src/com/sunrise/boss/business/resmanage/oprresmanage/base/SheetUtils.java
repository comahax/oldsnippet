package com.sunrise.boss.business.resmanage.oprresmanage.base;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.admin.operator.persistent.OperatorDAO;
import com.sunrise.boss.business.admin.operator.persistent.OperatorVO;
import com.sunrise.boss.business.resmanage.com.persistent.ComVO;
import com.sunrise.boss.business.resmanage.common.pubdef.ResConstant;
import com.sunrise.boss.business.resmanage.oprresmanage.audit.persistent.AuditDAO;
import com.sunrise.boss.business.resmanage.oprresmanage.audit.persistent.AuditVO;
import com.sunrise.boss.business.resmanage.sheet.persistent.SheetDAO;
import com.sunrise.boss.business.resmanage.sheet.persistent.SheetVO;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: ManageComrescardControlBean
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
 * @author Cai Wanli
 * @version 1.0
 */
public final class SheetUtils {

	public final static Long[] COMRESCARD_COMCLASSID = new Long[] { new Long(0), new Long(4) };// 充值卡：刮卡类、电子充值券

	public final static Long[] COMRESSMP_COMCLASSID = new Long[] { new Long(3) };// 套卡:SIM套卡类

	public final static Long[] COMRESPHONE_COMCLASSID = new Long[] { new Long(1) }; // 手机: 手机类

	public final static Long[] OTHERCOMRES_COMCLASSID = new Long[] {
			new Long(2), new Long(5), new Long(6), new Long(99) };// 扩展资源：手机配件类、集团信息化产品产品设备、赠送商品、其他
	
	private static Map resstatusMap= new HashMap(10); 
	
	static {
			resstatusMap.put("101","IM_CALLSTATE");	//号码
			resstatusMap.put("100","IM_SIMSTATUS");	//	SIM卡
			resstatusMap.put("103","IM_JFCARDSTATE");	//	积分卡
			//resstatusMap.put("104","");	//	礼品资源
			resstatusMap.put("105","IM_COMSTATE");	//	商品扩展资源
			resstatusMap.put("106","IM_COMSTATE");	//	终端设备
			resstatusMap.put("108","IM_COMSTATE");	// 套卡
			resstatusMap.put("109","IM_COMSTATE");	// 充值卡
			resstatusMap.put("110","IM_EMPTYSIMSTATUS");	//	空白SIM卡
	}

	/**
	 * 把流通类型转化字符串表示,用于打印及页面显示
	 * 
	 * @param sheettype
	 * @return
	 */
	public static String getSheetTypeAsString(Long sheettype) {
		String rValue = "";
		if (ResConstant.SHEETTYPE_CC.equals(sheettype)) {
			rValue = "cc";
		} else if (ResConstant.SHEETTYPE_TC.equals(sheettype)) {
			rValue = "tc";
		} else if (ResConstant.SHEETTYPE_JJ.equals(sheettype)) {
			rValue = "jj";
		}
		return rValue;
	}

	/**
	 * 把流通类型转化字符串表示,用于打印
	 * 
	 * @param sheettype
	 * @return
	 */
	public static String transSheettypestring(String sheettype) {
		if ("cc".equals(sheettype)) {
			return "出仓";
		} else if ("tc".equals(sheettype)) {
			return "退仓";
		} else {
			return "交接";
		}
	}

	/**
	 * 把流通资源类型转化字符串表示,用于控制页面显示(用于组成资源文件的key)
	 * 
	 * @param sheetrestype
	 * @return
	 */
	public static String getSheetResTypeAsString(Long sheetrestype) {
		String rValue = "";
		if (ResConstant.SHEETRESTYPE_SIM.equals(sheetrestype)) {
			rValue = "sim";
		} else if (ResConstant.SHEETRESTYPE_EMPTYSIM.equals(sheetrestype)) {
			rValue = "emptysim";
		} else if (ResConstant.SHEETRESTYPE_VIPCARD.equals(sheetrestype)) {
			rValue = "vipcard";
		} else if (ResConstant.SHEETRESTYPE_COM.equals(sheetrestype)) {
			rValue = "com";
		}
		return rValue;
	}

	public static String getTableNameFromSheetrestype(Long sheetrestype,
			Long typeid, User user) throws Exception {
		String rValue = "";
		if (ResConstant.SHEETRESTYPE_SIM.equals(sheetrestype)) {
			rValue = "IM_PR_SIM";
		} else if (ResConstant.SHEETRESTYPE_EMPTYSIM.equals(sheetrestype)) {
			rValue = "IM_PR_EMPTYSIM";
		} else if (ResConstant.SHEETRESTYPE_VIPCARD.equals(sheetrestype)) {
			rValue = "IM_PR_VIPCARD";
		} else if (ResConstant.SHEETRESTYPE_COM.equals(sheetrestype)) {
			rValue = getComTableName(typeid, user);
		} else {
			throw new Exception("获取资源类型为'" + sheetrestype.toString()
					+ "'的资源所属的商品资源表出错!");
		}
		return rValue;
	}

	public static String getComTableName(Long comid, User user)
			throws Exception {
		String rValue = "";
		try {
			if (isComrescard(comid, user)) {
				rValue = "IM_FX_COMRESCARD";
			} else if (isComresphone(comid, user)) {
				rValue = "IM_PR_COMRESPHONE";
			} else if (isComressmp(comid, user)) {
				rValue = "IM_FX_COMRESSMP";
			} else if (isOthercomres(comid, user)) {
				rValue = "IM_PR_OTHERCOMRES";
			} else {
				throw new Exception("获取商品标识为'" + comid.toString()
						+ "'的资源所属的商品资源表出错!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("获取商品标识为'" + comid.toString()
					+ "'的资源所属的商品资源表出错!");

		}

		return rValue;
	}

	public static String getResidFromTableName(String tableName) {
		String rValue = "";
		if ("IM_PR_SIM".equals(tableName)) {
			rValue = "ICCID";
		} else if ("IM_PR_EMPTYSIM".equals(tableName)) {
			rValue = "EMPTYNO";
		} else if ("IM_PR_VIPCARD".equals(tableName)) {
			rValue = "VIPCARDNO";
		} else {
			rValue = "COMRESID";
		}
		return rValue;
	}

	/**
	 * 根据流通单的资源类型获取约定的资源类型
	 * 
	 * @param sheetrestype
	 * @param typeid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public static Long transSheetRestype2Restype(Long sheetrestype,
			Long typeid, User user) throws Exception {
		Long rValue = null;
		if (ResConstant.SHEETRESTYPE_SIM.equals(sheetrestype)) {
			rValue = ResConstant.RESTYPE_SIMCARD;
		} else if (ResConstant.SHEETRESTYPE_EMPTYSIM.equals(sheetrestype)) {
			rValue = ResConstant.RESTYPE_EMPTYSIMCARD;
		} else if (ResConstant.SHEETRESTYPE_VIPCARD.equals(sheetrestype)) {
			rValue = ResConstant.RESTYPE_JFCARD;
		} else if (ResConstant.SHEETRESTYPE_COM.equals(sheetrestype)) {
			ComVO comvo = (ComVO) new CommonDelegate(ComVO.class).doFindByPk(
					typeid, user);
			if (comvo != null) {
				rValue = comvo.getComtype();
			}
		}
		return rValue;
	}

	public static boolean containsProperty(Object bean, String propertyName)
			throws Exception {
		if (bean == null || StringUtils.isEmpty(propertyName)) {
			return false;
		}
		try {
			bean.getClass().getDeclaredField(propertyName);
		} catch (SecurityException e) {
			e.printStackTrace();
			throw e;
		} catch (NoSuchFieldException e) {
			Class cls = bean.getClass().getSuperclass();
			if (cls == null) {
				return false;
			} else {
				return containsProperty(cls.newInstance(), propertyName);
			}
		}
		return true;
	}

	/**
	 * 获取Resdtl.hbm.xml配置文件中的<sql-query>的名字
	 * 
	 * @param restype
	 * @param typeid
	 * @param user
	 * @return
	 */
	public static String getQueryName(Long restype, Long typeid, User user) {
		String rValue = "";
		if (ResConstant.SHEETRESTYPE_SIM.equals(restype)) {
			rValue = "querySimdtl";
		} else if (ResConstant.SHEETRESTYPE_EMPTYSIM.equals(restype)) {
			rValue = "queryEmptysimdtl";
		} else if (ResConstant.SHEETRESTYPE_VIPCARD.equals(restype)) {
			rValue = "queryVipcarddtl";
		} else if (ResConstant.SHEETRESTYPE_COM.equals(restype)) {
			rValue = getComQueryName(typeid, user);
		}
		return rValue;
	}

	/**
	 * 获取Resdtl.hbm.xml配置文件中商品资源的<sql-query>的名字
	 * 
	 * @param comid
	 * @param user
	 * @return
	 */
	public static String getComQueryName(Long comid, User user) {
		String rValue = "";
		try {

			if (isComrescard(comid, user)) {
				rValue = "queryComrescarddtl";
			} else if (isComresphone(comid, user)) {
				rValue = "queryComresphonedtl";
			} else if (isComressmp(comid, user)) {
				rValue = "queryComressmpdtl";
			} else if (isOthercomres(comid, user)) {
				rValue = "queryOthercomresdtl";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rValue;
	}

	/**
	 * 获得指定资源的名称(用于打印时,显示标题)
	 * 
	 * @param sheetrestype
	 * @param typeid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public static String getResName(Long sheetrestype, Long typeid, User user)
			throws Exception {
		String rValue = "资源";
		if (ResConstant.SHEETRESTYPE_SIM.equals(sheetrestype)) {
			if (typeid == null) {
				return "SIM卡";
			}
			rValue = getTransName(typeid, "IM_SIMTYPE", "SIM卡", user);
		} else if (ResConstant.SHEETRESTYPE_EMPTYSIM.equals(sheetrestype)) {
			if (typeid == null) {
				return "空白SIM卡";
			}
			rValue = getTransName(typeid, "IM_SIMTYPE", "空白SIM卡", user);
		} else if (ResConstant.SHEETRESTYPE_VIPCARD.equals(sheetrestype)) {
			if (typeid == null) {
				return "积分卡";
			}
			rValue = getTransName(typeid, "IM_VIPCARDTYPE", "积分卡", user);
		} else if (ResConstant.SHEETRESTYPE_COM.equals(sheetrestype)) {
			rValue = getComName(typeid, user);
		}
		return rValue;
	}

	public static String getTransName(Long typeid, String definition,
			String defaultRet, User user) throws Exception {
		String rValue = "";
		DictitemVO pk = new DictitemVO();
		pk.setDictid(typeid.toString());
		pk.setGroupid(definition);
		DictitemVO vo = (DictitemVO) new CommonDelegate(DictitemVO.class)
				.doFindByPk(pk, user);
		if (vo == null || StringUtils.isEmpty(vo.getDictname())) {
			return defaultRet;
		}
		rValue = vo.getDictname();
		return rValue;

	}

	public static String getComName(Long comid, User user) throws Exception {
		ComVO vo = (ComVO) new CommonDelegate(ComVO.class).doFindByPk(comid,
				user);
		if (vo != null && !StringUtils.isEmpty(vo.getComname())) {
			return vo.getComname();
		} else if (vo != null) {
			DictitemVO pk = new DictitemVO();
			pk.setDictid(vo.getComtype().toString());
			pk.setGroupid("IM_COMTYPE");
			DictitemVO dictvo = (DictitemVO) new CommonDelegate(
					DictitemVO.class).doFindByPk(pk, user);
			return dictvo.getDictname();
		} else {
			return "商品";
		}
	}

	// 是否为充值卡
	public static boolean isComrescard(Long comid, User user) throws Exception {
		ComVO comvo = (ComVO) new CommonDelegate(ComVO.class).doFindByPk(comid,
				user);
		Long comclassid = comvo.getComclassid();
		for (int i = 0; i < COMRESCARD_COMCLASSID.length; i++) {
			if (COMRESCARD_COMCLASSID[i].equals(comclassid)) {
				return true;
			}
		}
		return false;
	}

	// 是否为套卡
	public static boolean isComressmp(Long comid, User user) throws Exception {
		ComVO comvo = (ComVO) new CommonDelegate(ComVO.class).doFindByPk(comid,
				user);
		Long comclassid = comvo.getComclassid();
		for (int i = 0; i < COMRESSMP_COMCLASSID.length; i++) {
			if (COMRESSMP_COMCLASSID[i].equals(comclassid)) {
				return true;
			}
		}
		return false;
	}

	// 是否为终端设备
	public static boolean isComresphone(Long comid, User user) throws Exception {
		ComVO comvo = (ComVO) new CommonDelegate(ComVO.class).doFindByPk(comid,
				user);
		Long comclassid = comvo.getComclassid();
		for (int i = 0; i < COMRESPHONE_COMCLASSID.length; i++) {
			if (COMRESPHONE_COMCLASSID[i].equals(comclassid)) {
				return true;
			}
		}
		return false;
	}

	// 是否为商品扩展资源
	public static boolean isOthercomres(Long comid, User user) throws Exception {
		ComVO comvo = (ComVO) new CommonDelegate(ComVO.class).doFindByPk(comid,
				user);
		Long comclassid = comvo.getComclassid();
		for (int i = 0; i < OTHERCOMRES_COMCLASSID.length; i++) {
			if (OTHERCOMRES_COMCLASSID[i].equals(comclassid)) {
				return true;
			}
		}
		return false;
	}

/*	*//**
	 * 创建流通单
	 * 
	 * @param sheetrestype
	 * @param salesopr
	 * @param dao
	 * @param user
	 * @return
	 * @throws Exception
	 *//*
	public static SheetVO doCreateSheet(Long sheetrestype, Long sheettype,
			String salesopr, SheetDAO dao, User user) throws Exception {
		SheetVO vo = new SheetVO();
		String sheetid = getSheetid(sheettype, user);
		try {
			vo.setSheettype(sheettype);
			vo.setSheetid(sheetid);
			vo.setSheetrestype(sheetrestype);
			vo.setSalesopr(salesopr);// 营业员工号
			vo.setOprcode(user.getOpercode());
			vo.setOprtime(new Date());
			vo.setCreatetime(new Date());
			vo.setSheetstate(ResConstant.SHEETSTATE_CREATED);
			vo.setWayid(user.getWayid());
			dao.create(vo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("登记流通单号为'" + sheetid + "'的流通单表记录失败!");
		}
		return vo;
	}
*/
	/**
	 * 获得唯一的流通单号
	 * 
	 * @param sheettype
	 * @param user
	 * @return
	 * @throws Exception
	 *//*
	public static String getSheetid(Long sheettype, User user) throws Exception {
		String sheetid = "";
		try {
			sheetid = AutoMakeSheetId.getInstance().getSheetId(sheettype, user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("获取唯一流通单单号失败!");
		}
		return sheetid;
	}
*/
	/**
	 * 检查两个数字字符串是否连续,str2 = str1+1
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 *//*
	public static boolean isLast(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		if (new CommonMethod().getNum(str1, str2) != 2) {
			return false;
		}
		return true;
	}*/

	/**
	 * 更新流通单记录的流通单记录
	 * 
	 * @param vo
	 * @param dao
	 * @param user
	 * @throws Exception
	 */
	public static void updateSheet(SheetVO vo, SheetDAO dao, Long sheetstate,
			Long hasPrinted, User user) throws Exception {
		try {
			vo.setSheetstate(sheetstate);
			vo.setHasprinted(hasPrinted);
			vo.setOprtime(new Date());
			dao.update(vo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("更新流通单号为'" + vo.getSheetid() + "'的流通单表记录的状态失败!");
		}
	}

/*	*//**
	 * 获得营业员拥有的某一类型的资源
	 * 
	 * @param sheetrestype
	 * @param typeid
	 * @param oprcode
	 * @param user
	 * @return
	 * @throws Exception
	 *//*
	public static List getOprres(Long sheetrestype, String oprcode, User user)
			throws Exception {
		DataPackage dp = null;
		try {
			OprresstatusListVO listvo = new OprresstatusListVO();
			listvo.set_se_oprcode(oprcode);
			listvo.set_ne_sheetrestype(sheetrestype.toString());
			listvo.set_pagesize("0");
			OprresstatusDAO dao = (OprresstatusDAO) DAOFactory.build(
					OprresstatusDAO.class, user.getCityid());
			dp = dao.query(listvo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(" 获取营业员拥有的资源失败");
		}
		return (List) dp.getDatas();
	}*/

	/**
	 * 获得营业员拥有的某一类型的资源明细(具体到资源标识)
	 * 
	 * @param sheetrestype
	 *            资源类型
	 * @param typeid
	 *            资源标识
	 * @param oprcode
	 * @param user
	 * @return
	 * @throws Exception
	 */
	/*public static List getResdtl(Long sheetrestype, Long typeid,
			String oprcode, User user) throws Exception {
		ResdtlDAO dao = (ResdtlDAO) DAOFactory.build(ResdtlDAO.class, user
				.getCityid());
		String queryName = getQueryName(sheetrestype, typeid, user);
		ResdtlListVO listvo = new ResdtlListVO();
		listvo.set_pagesize("0");
		Map map = listvo.getQueryConditions();
		map.put("oprcode", oprcode);
		map.put("typeid", typeid);
		map.put("wayid", user.getWayid());

		DataPackage dp = dao.getResDetail(queryName, listvo);
		if (dp == null || dp.getDatas() == null || dp.getDatas().size() < 1) {
			throw new Exception("该营业员没有拥有类型为'"
					+ getResName(sheetrestype, typeid, user) + "'的资源");
		}
		return (List) dp.getDatas();
	}*/

	/**
	 * 生成对应流通单号的流通单明细
	 * 
	 * @param sheetid
	 *            唯一的流通单号
	 * @param sheetrestype
	 *            流通单资源类型
	 * @param typeid
	 *            资源标识
	 * @param salesopr
	 *            营业员工号(出仓单登记接收发放的资源的工员,退仓单登记退返资源的工号,交接单登记接受交接的工号)
	 * @param dao
	 * @param user
	 * @return 所有明细记录
	 * @throws Exception
	 */
	/*public static List doCreateSheetdtl(List resList, String sheetid,
			Long sheetrestype, Long typeid, SheetdtlDAO dao, User user)
			throws Exception {
		List rList = new ArrayList();
		try {
			if (resList != null && resList.size() > 0) {
				SheetdtlVO vo = null;
				ResdtlVO dtlvo = null;
				Iterator it = resList.iterator();
				// 对连续的资源编号登记为一条明细记录
				dtlvo = (ResdtlVO) it.next();
				String begno = dtlvo.getResid();
				String endno = begno;
				Long preState = dtlvo.getResstate();
				int resultFlag;
				while (it.hasNext()) {
					dtlvo = (ResdtlVO) it.next();
					String resid = dtlvo.getResid();

					*//**
					 * 先判断前后编号对应资源的状态是否一致,再判断编号是否连续，此处主要对库存态&非库存态进行区分<br>
					 * 由于空白卡的 可用&暂选 都属于库存状态，因此对于可用&暂选登记为一条记录<br>
					 * 后台程序已经对此部分做特殊处理(state=可用 or state=暂选 or 写卡作废)
					 *//*
					if ((resultFlag = checkResState(preState, dtlvo, sheetrestype)) > 0) {
						if (isLast(endno, resid)) {// 检查是否连续
							endno = resid;
							continue;
						}
					}
					vo = registerSheetdtl(sheetid, typeid, begno, endno, dao,
							resultFlag, user);
					rList.add(vo);
					begno = resid;
					endno = resid;
					preState = dtlvo.getResstate();
				}
				resultFlag = checkResState(preState, dtlvo, sheetrestype);
				vo = registerSheetdtl(sheetid, typeid, begno, endno, dao,
						resultFlag, user);
				rList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("登记流通单号为'" + sheetid + "',资源类型为'"
					+ sheetrestype.toString() + "',资源标识为'" + typeid.toString()
					+ "'的流通单明细表记录失败!");
		}
		return rList;
	}

	*//**
	 * 登记流通单明细时,库存状态和非库存状态的记录分开登记 两种状态的记录不能在同一个连续范围内
	 * 库存状态的记录可登记起始编号与终止编号不相同的连续段为一条明细 非库存状态的记录,每条记录登记一条明细
	 * 
	 * @param preState
	 * @param vo
	 * @param sheetrestype
	 * @return
	 *//*
	public static int checkResState(Long preState, ResdtlVO vo,
			Long sheetrestype) {
		List stockStatList = new ArrayList();// 库存态
		if (ResConstant.SHEETRESTYPE_SIM.equals(sheetrestype)) {
			stockStatList.add(ResConstant.SIMSTATE_CANUSE);
			// return checkResState(preState, vo.getResstate(),
			// ResConstant.SIMSTATE_CANUSE);
		} else if (ResConstant.SHEETRESTYPE_EMPTYSIM.equals(sheetrestype)) {
			stockStatList.add(ResConstant.EMPTYSIMSTATE_CANUSE);
			stockStatList.add(ResConstant.EMPTYSIMSTATE_TMPCHOOSE);
			stockStatList.add(ResConstant.EMPTYSIMSTATE_WRITERFAIL);
			// return checkResState(preState, vo.getResstate(),
			// ResConstant.EMPTYSIMSTATE_CANUSE);
		} else if (ResConstant.SHEETRESTYPE_VIPCARD.equals(sheetrestype)) {
			stockStatList.add(ResConstant.JFCARDSTATE_CANUSE);
			// return checkResState(preState, vo.getResstate(),
			// ResConstant.JFCARDSTATE_CANUSE);
		} else {
			stockStatList.add(ResConstant.COMSTATE_ONSALE);
			// return checkResState(preState, vo.getResstate(),
			// ResConstant.COMSTATE_ONSALE);
		}
		return checkResState(preState, vo.getResstate(), stockStatList);
	}*/

	/**
	 * 前后两个资源都为库存态返回2，前一编号属于库存，后一编号非库存返回-2<br>
	 * 前后两个资源都为非库存态返回1，前一编号非库存，后一编号库存返回-1
	 * 
	 * 两个编号的状态一致且前一编号状态为可用状态返回2,两个编号的状态不一致且前一编号状态为可用状态返回-2
	 * 两个编号的状态一致且前一编号状态为不可用状态返回1,两个编号的状态不一致且前一编号状态为不可用状态返回-1
	 * 
	 * @param preState
	 * @param resState
	 * @param stockStatList
	 *            库存态所包含的状态
	 * @return
	 */
	private static int checkResState(Long preState, Long resState, List stockStatList) {
		// if (legalState.equals(preState)) {
		// if (legalState.equals(resState)) {
		// return 2;
		// }
		// return -2;
		// } else {
		// if (!legalState.equals(resState)) {
		// return 1;
		// }
		// return -1;
		// }
		
		if (stockStatList.contains(preState)) {// 库存
			if (stockStatList.contains(resState)) { // 库存
				return 2;
			}
			return -2;
		}else {// 非库存
			if (!stockStatList.contains(resState)) { // 库存
				return 1;
			}
			return -1;
		}
	}

	/**
	 * 登记流通单明细表
	 * 
	 * @param sheetid
	 * @param typeid
	 * @param begresid
	 * @param endresid
	 * @param dao
	 * @param result
	 * @param user
	 * @return 明细记录
	 * @throws Exception
	 */
	/*public static SheetdtlVO registerSheetdtl(String sheetid, Long typeid,
			String begresid, String endresid, SheetdtlDAO dao, int result,
			User user) throws Exception {
		SheetdtlVO vo = new SheetdtlVO();
		vo.setSheetid(sheetid);
		vo.setTypeid(typeid);
		vo.setBegresid(begresid);
		vo.setEndresid(endresid);
		// 若该连续编号资源的状态为不可用,则result字段设为-1,以示区别
		if (Math.abs(result) == 1) {
			vo.setResult(new Long(-1));
		}
		dao.create(vo);
		return vo;
	}

	*//**
	 * 登记流通单记录对应原资源请求表
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 *//*
	public static void registerReqlog(List dtlList, SheetVO vo, User user)
			throws Exception {
		// List dList = getSheetdtl(vo.getSheetid(),user);
		Iterator it = dtlList.iterator();
		while (it.hasNext()) {
			SheetdtlVO dtlvo = (SheetdtlVO) it.next();
			// Object reqvo =
			// SheetUtils.getReqVO(vo.getSheetrestype(),dtlvo.getTypeid(),
			// user);
			// Object reqDAO = SheetUtils.getReqDAO(vo.getSheetrestype(),
			// dtlvo.getTypeid(), user);
			SheetreqVO reqvo = new SheetreqVO();
			SheetreqDAO dao = (SheetreqDAO) DAOFactory.build(SheetreqDAO.class,
					user.getCityid());
			setSheetreqVO(reqvo, dtlvo, vo, user);
			MethodUtils.invokeMethod(dao, "create", reqvo);
		}
	}

	*//**
	 * 获得对应流通单记录的明细
	 * 
	 * @param sheetid
	 * @param user
	 * @return
	 * @throws Exception
	 *//*
	public static List getSheetdtl(String sheetid, User user) throws Exception {
		SheetdtlDAO dao = (SheetdtlDAO) DAOFactory.build(SheetdtlDAO.class,
				user.getCityid());
		SheetdtlListVO listvo = new SheetdtlListVO();
		listvo.set_se_sheetid(sheetid);
		listvo.set_pagesize("0");
		DataPackage dp = dao.query(listvo);
		if (dp == null || dp.getDatas() == null && dp.getDatas().size() < 1) {
			throw new Exception("对应流通单没有资源明细可供回收!");
		}
		return (List) dp.getDatas();
	}

	*//**
	 * 
	 *//*
	public static void setSheetreqVO(SheetreqVO reqvo, SheetdtlVO dtlvo,
			SheetVO vo, User user) throws Exception {
		long num = new CommonMethod().getNum(dtlvo.getBegresid(), dtlvo
				.getEndresid());
		Long resoprtype = null;
		if (ResConstant.SHEETTYPE_CC.equals(vo.getSheettype())) {
			resoprtype = ResConstant.RESOPRTYPE_CC;
			reqvo.setInoprcode(vo.getSalesopr());
		} else if (ResConstant.SHEETTYPE_TC.equals(vo.getSheettype())) {
			resoprtype = ResConstant.RESOPRTYPE_TC;
			reqvo.setOutoprcode(vo.getSalesopr());
		} else if (ResConstant.SHEETTYPE_JJ.equals(vo.getSheettype())) {
			resoprtype = ResConstant.RESOPRTYPE_JJ;
			reqvo.setInoprcode(vo.getSalesopr());
			reqvo.setOutoprcode(vo.getOprcode());
		}
		reqvo.setBegno(dtlvo.getBegresid());
		reqvo.setEndno(dtlvo.getEndresid());
		reqvo.setComid(dtlvo.getTypeid());
		reqvo.setCreattime(new Date());
		reqvo.setNum(new Long(num));
		reqvo.setOprcode(vo.getOprcode());
		reqvo.setResoprtype(resoprtype);
		reqvo.setSendno(vo.getSheetid());
		reqvo.setSheetrestype(vo.getSheetrestype());
	}*/

	public static void registerAudit(String sheetid, String reqoprcode,
			String auditoprcode, String inoprcode, String outoprcode, User user)
			throws Exception {
		try {
			AuditDAO dao = (AuditDAO) DAOFactory.build(AuditDAO.class, user
					.getCityid());
			AuditVO vo = new AuditVO();
			vo.setReqoprcode(reqoprcode);
			vo.setSheetid(sheetid);
			vo.setAuditoprcode(auditoprcode);
			vo.setInoprcode(inoprcode);
			vo.setOutoprcode(outoprcode);
			vo.setState(ResConstant.AUDITSATE_NEEDAUDIT);
			vo.setCreatetime(new Date(System.currentTimeMillis()));

			// BaseDAO operatorDAO = new
			// BaseDAO(OperatorVO.class,user.getCityid());
			OperatorDAO operatorDAO = (OperatorDAO) DAOFactory.build(
					OperatorDAO.class, user.getCityid());
			OperatorVO queryvo = (OperatorVO) operatorDAO.findByPk(reqoprcode);
			if (null == queryvo) {
				throw new Exception("请求人" + reqoprcode
						+ " ,在操作员表(SA_SO_OPERATOR)中不存在");
			}

			vo.setWayid(queryvo.getOrgid());// 20081106请求人的所属的wayid

			dao.create(vo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("登记审核记录表出错!");
		}

	}
	public static String getResstatusName(String restype){
		Object status=resstatusMap.get(restype);
		if(status!=null){
			return status.toString();
		}
		return restype;
	}

}
