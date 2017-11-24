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
 * @description ��Դ�����Ϸ��Լ�鷽��
 * 
 */
public class CheckWayId {

	private static final Long wayNO = new Long(9); // �����ж�ϵͳ������־

	private static final String resource = "resource"; // ����������

	private static final String NOCheck = "0"; // �����������жϱ�־

	private CheckWayId() {

	}

	/**
	 * @description ��ϵͳ�������ѯ����ֵ
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
	 * @description ���ݲ���ֵ�ж��Ƿ���Ҫ���������жϣ���һ������Ϊ�ϼ��������ڶ���Ϊ�¼�����
	 *              ��������ȼ���ȷ����true�����򷵻�false
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
			throw new Exception("����" + highwayid + "������");
		}
		if (!CheckisWayExist(lowwayid, user)) {
			throw new Exception("����" + lowwayid + "������");
		}
		if (highwayid.equals(lowwayid))
			throw new Exception("����ʧ�ܣ�����" + highwayid + "��" + lowwayid + "��ͬ");
		if (result == null) {
			throw new Exception("ϵͳ����������û���Ƿ������������жϼ�¼�����ܽ���ҵ�����");
		} else if (!result.equals(NOCheck)) {
			WayControl control;
			try {
				control = (WayControl) ControlFactory
						.build(WayControlBean.class);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("���������ӿ�ʧ��");
			}
			return control.isDirectSubwayOf(lowwayid, highwayid, user);
		}
		return true;
	}

	/**
	 * @description �ж����������Ƿ����
	 * @param wayid
	 * @param user
	 * @return ���ڷ��� true �����ڷ��� false
	 * @throws Exception
	 */
	public static boolean CheckisWayExist(String wayid, User user)
			throws Exception {
		WayControl control;
		try {
			control = (WayControl) ControlFactory.build(WayControlBean.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("���������ӿ�ʧ��");
		}
		return control.isWayExist(wayid, user);
	}

	/**
	 * @description �ж��Ƿ���ĳ��������������(����ֱ��,��ֱ��)
	 * @param wayid
	 *            ������
	 * @param uppperwayid
	 *            ������
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
			throw new Exception("���������ӿ�ʧ��");
		}
		return control.isSubwayOf(wayid, upperwayid, user);
	}

	/**
	 * @description �жϲ���Ա�Ƿ�ӵ���޸ĸú���״̬��Ȩ��
	 * @param opercode
	 *            ����Ա����
	 * @param wayid
	 *            ������������
	 * @return
	 * @throws Exception
	 */
//	public static void chkNoStateChgPermission(User user, String wayid)
//			throws Exception {
//		ACLControl control;
//		try {
//			control = (ACLControl) ControlFactory.build(ACLControlBean.class);
//		} catch (Exception e) {
//			throw new Exception("����Ȩ���жϽӿ�ʧ��");
//		}
//
//		String rightCity = "NOSTATECHG_CITY";// �����޸��й�˾�������������ĺ����״̬
//		String rightCurrWay = "NOSTATECHG_CUURWAY";// ֻ�����޸ı������ĺ����״̬
//		String rightAllSubways = "NOSTATECHG_ALLSUBWAYS";// �����޸ı����������������������ĺ����״̬
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
//		throw new Exception("��ѡ������Դ��������[" + wayid
//				+ "],��û���޸ĸ�����������Դ״̬��Ȩ��,��ȷ�ϸ�Ȩ!");
//	}

	/**
	 * @description �жϵ�ǰ�û��Ƿ��в���ָ��������Դ��Ȩ�� �˷���֧������Ȩ�޿����жϣ������й�˾Ȩ�ޣ�����������������Ȩ�ޣ�������Ȩ��<br>
	 *              Ĭ�Ͼ��б�����Ȩ�ޣ����ֻ�����ӵ��С����������������ƣ�Լ�����Ӧ�����ƺ�׺�ֱ�Ϊ_CITY,_ALLSUBWAYS����ֻ�贫��ǰ׺���ɣ�����������޸�:
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
			throw new Exception("����Ȩ���жϽӿ�ʧ��!");
		}

		String rightCity = prefix + "_CITY";// �й�˾Ȩ��
		String rightAllSubways = prefix + "_ALLSUBWAYS";// ����������������Ȩ��

		if (control.checkPermission(user.getOpercode(), rightCity)) {
			return true;
		}

		if (control.checkPermission(user.getOpercode(), rightAllSubways)) {
			if (user.getWayid().equals(wayid)
					|| isSubwayOf(wayid, user.getWayid(), user)) {
				return true;
			}
		}

		// Ĭ�Ͼ��б�����Ȩ��
		if (user.getWayid().equals(wayid)) {
			return true;
		}

		return false;
	}

	/**
	 * @description �ж�ָ��wayid�Ƿ������
	 * @param wayid
	 * @param user
	 * @return �Ǵ����̷��� true,���Ǵ����̷��� false
	 * @throws Exception
	 */
//	public static boolean isAgent(String wayid, User user) throws Exception {
//		AgentnopoolrelaControl control;
//		try {
//			control = (AgentnopoolrelaControl) ControlFactory
//					.build(AgentnopoolrelaControlBean.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new Exception("���������ӿ�ʧ��");
//		}
//		return control.isAgent(wayid, user);
//	}

}