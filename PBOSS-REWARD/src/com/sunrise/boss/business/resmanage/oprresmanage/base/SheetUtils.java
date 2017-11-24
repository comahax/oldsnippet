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

	public final static Long[] COMRESCARD_COMCLASSID = new Long[] { new Long(0), new Long(4) };// ��ֵ�����ο��ࡢ���ӳ�ֵȯ

	public final static Long[] COMRESSMP_COMCLASSID = new Long[] { new Long(3) };// �׿�:SIM�׿���

	public final static Long[] COMRESPHONE_COMCLASSID = new Long[] { new Long(1) }; // �ֻ�: �ֻ���

	public final static Long[] OTHERCOMRES_COMCLASSID = new Long[] {
			new Long(2), new Long(5), new Long(6), new Long(99) };// ��չ��Դ���ֻ�����ࡢ������Ϣ����Ʒ��Ʒ�豸��������Ʒ������
	
	private static Map resstatusMap= new HashMap(10); 
	
	static {
			resstatusMap.put("101","IM_CALLSTATE");	//����
			resstatusMap.put("100","IM_SIMSTATUS");	//	SIM��
			resstatusMap.put("103","IM_JFCARDSTATE");	//	���ֿ�
			//resstatusMap.put("104","");	//	��Ʒ��Դ
			resstatusMap.put("105","IM_COMSTATE");	//	��Ʒ��չ��Դ
			resstatusMap.put("106","IM_COMSTATE");	//	�ն��豸
			resstatusMap.put("108","IM_COMSTATE");	// �׿�
			resstatusMap.put("109","IM_COMSTATE");	// ��ֵ��
			resstatusMap.put("110","IM_EMPTYSIMSTATUS");	//	�հ�SIM��
	}

	/**
	 * ����ͨ����ת���ַ�����ʾ,���ڴ�ӡ��ҳ����ʾ
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
	 * ����ͨ����ת���ַ�����ʾ,���ڴ�ӡ
	 * 
	 * @param sheettype
	 * @return
	 */
	public static String transSheettypestring(String sheettype) {
		if ("cc".equals(sheettype)) {
			return "����";
		} else if ("tc".equals(sheettype)) {
			return "�˲�";
		} else {
			return "����";
		}
	}

	/**
	 * ����ͨ��Դ����ת���ַ�����ʾ,���ڿ���ҳ����ʾ(���������Դ�ļ���key)
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
			throw new Exception("��ȡ��Դ����Ϊ'" + sheetrestype.toString()
					+ "'����Դ��������Ʒ��Դ�����!");
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
				throw new Exception("��ȡ��Ʒ��ʶΪ'" + comid.toString()
						+ "'����Դ��������Ʒ��Դ�����!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("��ȡ��Ʒ��ʶΪ'" + comid.toString()
					+ "'����Դ��������Ʒ��Դ�����!");

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
	 * ������ͨ������Դ���ͻ�ȡԼ������Դ����
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
	 * ��ȡResdtl.hbm.xml�����ļ��е�<sql-query>������
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
	 * ��ȡResdtl.hbm.xml�����ļ�����Ʒ��Դ��<sql-query>������
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
	 * ���ָ����Դ������(���ڴ�ӡʱ,��ʾ����)
	 * 
	 * @param sheetrestype
	 * @param typeid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public static String getResName(Long sheetrestype, Long typeid, User user)
			throws Exception {
		String rValue = "��Դ";
		if (ResConstant.SHEETRESTYPE_SIM.equals(sheetrestype)) {
			if (typeid == null) {
				return "SIM��";
			}
			rValue = getTransName(typeid, "IM_SIMTYPE", "SIM��", user);
		} else if (ResConstant.SHEETRESTYPE_EMPTYSIM.equals(sheetrestype)) {
			if (typeid == null) {
				return "�հ�SIM��";
			}
			rValue = getTransName(typeid, "IM_SIMTYPE", "�հ�SIM��", user);
		} else if (ResConstant.SHEETRESTYPE_VIPCARD.equals(sheetrestype)) {
			if (typeid == null) {
				return "���ֿ�";
			}
			rValue = getTransName(typeid, "IM_VIPCARDTYPE", "���ֿ�", user);
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
			return "��Ʒ";
		}
	}

	// �Ƿ�Ϊ��ֵ��
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

	// �Ƿ�Ϊ�׿�
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

	// �Ƿ�Ϊ�ն��豸
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

	// �Ƿ�Ϊ��Ʒ��չ��Դ
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
	 * ������ͨ��
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
			vo.setSalesopr(salesopr);// ӪҵԱ����
			vo.setOprcode(user.getOpercode());
			vo.setOprtime(new Date());
			vo.setCreatetime(new Date());
			vo.setSheetstate(ResConstant.SHEETSTATE_CREATED);
			vo.setWayid(user.getWayid());
			dao.create(vo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("�Ǽ���ͨ����Ϊ'" + sheetid + "'����ͨ�����¼ʧ��!");
		}
		return vo;
	}
*/
	/**
	 * ���Ψһ����ͨ����
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
			throw new Exception("��ȡΨһ��ͨ������ʧ��!");
		}
		return sheetid;
	}
*/
	/**
	 * ������������ַ����Ƿ�����,str2 = str1+1
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
	 * ������ͨ����¼����ͨ����¼
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
			throw new Exception("������ͨ����Ϊ'" + vo.getSheetid() + "'����ͨ�����¼��״̬ʧ��!");
		}
	}

/*	*//**
	 * ���ӪҵԱӵ�е�ĳһ���͵���Դ
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
			throw new Exception(" ��ȡӪҵԱӵ�е���Դʧ��");
		}
		return (List) dp.getDatas();
	}*/

	/**
	 * ���ӪҵԱӵ�е�ĳһ���͵���Դ��ϸ(���嵽��Դ��ʶ)
	 * 
	 * @param sheetrestype
	 *            ��Դ����
	 * @param typeid
	 *            ��Դ��ʶ
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
			throw new Exception("��ӪҵԱû��ӵ������Ϊ'"
					+ getResName(sheetrestype, typeid, user) + "'����Դ");
		}
		return (List) dp.getDatas();
	}*/

	/**
	 * ���ɶ�Ӧ��ͨ���ŵ���ͨ����ϸ
	 * 
	 * @param sheetid
	 *            Ψһ����ͨ����
	 * @param sheetrestype
	 *            ��ͨ����Դ����
	 * @param typeid
	 *            ��Դ��ʶ
	 * @param salesopr
	 *            ӪҵԱ����(���ֵ��Ǽǽ��շ��ŵ���Դ�Ĺ�Ա,�˲ֵ��Ǽ��˷���Դ�Ĺ���,���ӵ��Ǽǽ��ܽ��ӵĹ���)
	 * @param dao
	 * @param user
	 * @return ������ϸ��¼
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
				// ����������Դ��ŵǼ�Ϊһ����ϸ��¼
				dtlvo = (ResdtlVO) it.next();
				String begno = dtlvo.getResid();
				String endno = begno;
				Long preState = dtlvo.getResstate();
				int resultFlag;
				while (it.hasNext()) {
					dtlvo = (ResdtlVO) it.next();
					String resid = dtlvo.getResid();

					*//**
					 * ���ж�ǰ���Ŷ�Ӧ��Դ��״̬�Ƿ�һ��,���жϱ���Ƿ��������˴���Ҫ�Կ��̬&�ǿ��̬��������<br>
					 * ���ڿհ׿��� ����&��ѡ �����ڿ��״̬����˶��ڿ���&��ѡ�Ǽ�Ϊһ����¼<br>
					 * ��̨�����Ѿ��Դ˲��������⴦��(state=���� or state=��ѡ or д������)
					 *//*
					if ((resultFlag = checkResState(preState, dtlvo, sheetrestype)) > 0) {
						if (isLast(endno, resid)) {// ����Ƿ�����
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
			throw new Exception("�Ǽ���ͨ����Ϊ'" + sheetid + "',��Դ����Ϊ'"
					+ sheetrestype.toString() + "',��Դ��ʶΪ'" + typeid.toString()
					+ "'����ͨ����ϸ���¼ʧ��!");
		}
		return rList;
	}

	*//**
	 * �Ǽ���ͨ����ϸʱ,���״̬�ͷǿ��״̬�ļ�¼�ֿ��Ǽ� ����״̬�ļ�¼������ͬһ��������Χ��
	 * ���״̬�ļ�¼�ɵǼ���ʼ�������ֹ��Ų���ͬ��������Ϊһ����ϸ �ǿ��״̬�ļ�¼,ÿ����¼�Ǽ�һ����ϸ
	 * 
	 * @param preState
	 * @param vo
	 * @param sheetrestype
	 * @return
	 *//*
	public static int checkResState(Long preState, ResdtlVO vo,
			Long sheetrestype) {
		List stockStatList = new ArrayList();// ���̬
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
	 * ǰ��������Դ��Ϊ���̬����2��ǰһ������ڿ�棬��һ��ŷǿ�淵��-2<br>
	 * ǰ��������Դ��Ϊ�ǿ��̬����1��ǰһ��ŷǿ�棬��һ��ſ�淵��-1
	 * 
	 * ������ŵ�״̬һ����ǰһ���״̬Ϊ����״̬����2,������ŵ�״̬��һ����ǰһ���״̬Ϊ����״̬����-2
	 * ������ŵ�״̬һ����ǰһ���״̬Ϊ������״̬����1,������ŵ�״̬��һ����ǰһ���״̬Ϊ������״̬����-1
	 * 
	 * @param preState
	 * @param resState
	 * @param stockStatList
	 *            ���̬��������״̬
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
		
		if (stockStatList.contains(preState)) {// ���
			if (stockStatList.contains(resState)) { // ���
				return 2;
			}
			return -2;
		}else {// �ǿ��
			if (!stockStatList.contains(resState)) { // ���
				return 1;
			}
			return -1;
		}
	}

	/**
	 * �Ǽ���ͨ����ϸ��
	 * 
	 * @param sheetid
	 * @param typeid
	 * @param begresid
	 * @param endresid
	 * @param dao
	 * @param result
	 * @param user
	 * @return ��ϸ��¼
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
		// �������������Դ��״̬Ϊ������,��result�ֶ���Ϊ-1,��ʾ����
		if (Math.abs(result) == 1) {
			vo.setResult(new Long(-1));
		}
		dao.create(vo);
		return vo;
	}

	*//**
	 * �Ǽ���ͨ����¼��Ӧԭ��Դ�����
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
	 * ��ö�Ӧ��ͨ����¼����ϸ
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
			throw new Exception("��Ӧ��ͨ��û����Դ��ϸ�ɹ�����!");
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
				throw new Exception("������" + reqoprcode
						+ " ,�ڲ���Ա��(SA_SO_OPERATOR)�в�����");
			}

			vo.setWayid(queryvo.getOrgid());// 20081106�����˵�������wayid

			dao.create(vo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("�Ǽ���˼�¼�����!");
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
