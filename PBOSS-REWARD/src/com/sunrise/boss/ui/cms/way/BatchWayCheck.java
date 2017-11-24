package com.sunrise.boss.ui.cms.way;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.cms.common.AuditUtils;
import com.sunrise.boss.business.cms.custwaytype.persistent.CustwaytypeListVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.waytype.persistent.WaytypeListVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.cms.custwaytype.CustwaytypeDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.waytype.WaytypeDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchWayCheck extends BaseCheckFormat {
	private static WayDelegate delegate;

	private String newFlag = "true";

	public BatchWayCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public WayDelegate getDelegate() throws Exception {
		if (delegate == null) {
			return new WayDelegate();
		} else {
			return delegate;
		}
	}

	private static final String item[] = { "��������", "��������", "�ϼ�����", "Ӫҵ���ʶ",
			"�Ƿ���", "�������", "���������", "�ֹ�˾�Զ�������������", "���м���", "�����ȼ�", "����MIS����",
			"��ҵ��Դ����", "�Ƿ�����", "������ʽ", "��Ӫģʽ", "�Ƿ���������", "�Ǽ�", "������", "�����ܵ����",
			"ǩԼ״̬", "Ӫҵ��Ա����", "������Ա����", "�ն�����", "γ��", "����", "����״̬", "�����м����",
			"��Ӫ��־" };

	/*
	 * (non-Javadoc) �̶������ɹ���ģ����
	 * 
	 * @see com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat#checkLine(java.lang.String,
	 *      int)
	 */
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (null == line || "".equals(line)) {
			return;
		}
		String[] items = line.split("\\|");
		// �������
		if (items.length != 28) {
			throw new Exception("�ϴ���������:" + items.length + "����ȷ,ӦΪ28��,��鿴˵������!");
		}

		// \��������0
		this.ckString(items[0], item[0], 18, "notnull");
		if(StringUtils.isNotBlank(items[0]))
		{
			if(!AuditUtils.doCheckWayidStyle(items[0]))
			{
				throw new Exception("���������ʽ����ȷ,Ӧ��ֻ������ĸ��ͷ��ֻ�ܰ�����ĸ,���ֺ�-�ַ�");
			}
		}
		WayVO vo = getDelegate().doFindByPk(items[0].trim(), user);
		if (vo == null) {
			newFlag = "true";
		} else {
			newFlag = "false";
		}

		// \��������1
		this.ckString(items[1], item[1], 256, "no");
		// �ϼ���������2
		this.ckString(items[2], item[2], 18, "no", newFlag);
		this.doCheckWayID(items[2].trim(), item[2], user);
		// Ӫҵ���ʶ3
		this.ckString(items[3], item[3], 10);
		// \�Ƿ���4??
		this.ckString(items[4].trim(), item[4], 32, "no", newFlag);
		this.doCheckSystemParam("CH_DSTISKEYSTEP", items[4].trim(), user,
				item[4]);
		// \ �������5
		this.ckString(items[5], item[5], 4, "no", newFlag);
		if (StringUtils.isNotEmpty(items[5].trim())) {
			this.doCheckWayType(items[5].trim(), user, item[5]);
		}
		// ���������6
		this.ckString(items[6], item[6], 4);
		if (StringUtils.isNotEmpty(items[6].trim())) {
			if (StringUtils.isEmpty(items[5].trim())) {
				throw new Exception("���������ֵ����������������ֵ");
			} else if (StringUtils.isNotEmpty(items[5].trim())) {
				this.doCheckSubWayType(items[6].trim(), items[5].trim(), user,
						item[6]);
			}
		}
		// ��������������������������AG�������������������"��Լ�����SAGT"��"ָ��רӪ��PSAL"��"������Ӫ������DIS"
		// ����޸ĳɲ���������ʵ����������Ӫ������
		if ( "ET".equals(items[5].trim())) {
			throw new Exception("�˲˵�������¼��[��Ӫ]������Ϣ,�뵽��ز˵�¼��!");
		}
		if("AG".equals(items[5].trim()))
		{
			if( !"TEMI".equals(items[6].trim()) && !"ITF".equals(items[6].trim()) && !"ECF".equals(items[6].trim()))
			{
				throw new BusinessException("","[������㣬������]��������,��ȥר�ŵ������˵�����¼��!");
			}
		}
		// // ʵ�������Ѿ�������"D4S","D5S","D6S"
		// if ("ET".equals(items[5].trim())) {
		// if ("D4S".equals(items[6].trim()) || "D5S".equals(items[6].trim())
		// || "D6S".equals(items[6].trim())) {
		// throw new Exception("ʵ��������\"D4S\",\"D5S\",\"D6S\"�Ѿ��޸�Ϊ\"G100\"");
		// }
		// }
		// �ֹ�˾�Զ�������������7
		this.ckString(items[7], item[7], 4);
		this.checkCustomerWay(items[7].trim(), item[7], user);
		// \ ��������8
		// this.ckString(items[8], item[8], 14, "no", newFlag);
		// \ �й�˾9
		// this.ckString(items[9], item[9], 14, "no", newFlag);
		// �ع�˾10
		// this.ckString(items[10], item[10], 14);
		// ���м���8
		this.ckNumber(items[8], item[8], 3);
		this.doCheckSystemParam("CH_CITYLEVEL", items[8].trim(), user, item[8]);
		// ��������12
		// this.ckNumber(items[12], item[12], 3);
		// �����ȼ�13
		this.ckString(items[9], item[9], 4);
		this.doCheckSystemParam("CH_BCHLEVEL", items[9].trim(), user, item[9]);
		// ����MIS����10
		this.ckString(items[10], item[10], 12);
		// ��ҵ��Դ����11
		this.ckNumber(items[11], item[11], 2);
		this
				.doCheckSystemParam("CH_PRTSOURCE", items[11].trim(), user,
						item[1]);
		// �Ƿ�����12---------------------------------------------------------------------
		this.ckNumber(items[12], item[12], 2);
		this.doCheckSystemParam("CH_ISCONNECTED", items[12].trim(), user,
				item[12]);
		// ������ʽ13
		this.ckNumber(items[13], item[13], 2);
		this.doCheckSystemParam("CH_CONNECTTYPE", items[13].trim(), user,
				item[13]);
		// ��Ӫģʽ14
		this.ckNumber(items[14], item[14], 2);
		this.doCheckSystemParam("CH_RUNMODE", items[14].trim(), user, item[14]);
		// �Ƿ���������15
		this.ckNumber(items[15], item[15], 2);
		this.doCheckSystemParam("CH_ISCOREWAY", items[15].trim(), user,
				item[19]);
		// �Ǽ�16
		this.ckNumber(items[16], item[16], 2);
		this.doCheckSystemParam("CH_STARLEVEL", items[16].trim(), user,
				item[16]);
		// ������17
		this.ckNumber(items[17], item[17], 2);
		this.doCheckSystemParam("CH_PT", items[17].trim(), user, item[17]);
		// �����ܵ����18
		this.ckString(items[18], item[18], 18);
		// ǩԼ״̬19
		this.ckNumber(items[19], item[19], 2);
		this.doCheckSystemParam("CH_SIGNSTATUS", items[19].trim(), user,
				item[19]);
		// Ӫҵ��Ա����20------------------------------------------------------
		this.ckNumber(items[20], item[20], 4);
		// ������Ա����21
		this.ckNumber(items[21], item[21], 4);
		// �ն�����22
		this.ckNumber(items[22], item[22], 4);
		// \ γ��23
		String regex = "^\\d{2}.\\d{6}$";
		this.ckString(items[23], item[23], 15, "no", newFlag);
		if (!"".equals(items[23].trim()) && !items[23].trim().matches(regex)) {
			throw new Exception(item[23] + "ֵ:" + items[23] + " ��ֵ��д����ȷ,"
					+ item[23] + "������2λ����λ��6С��λ");
		} else if (!"".equals(items[23].trim())) {
			int latitude = Integer.parseInt(items[23].trim().substring(0, 2));
			if (latitude < 18 || latitude > 26) {
				throw new Exception(item[23] + "ֵ������18��26֮��");
			}
		}
		// \ ����24
		this.ckString(items[24], item[24], 15, "no", newFlag);
		regex = "^\\d{3}.\\d{6}$";
		if (!"".equals(items[24].trim()) && !items[24].trim().matches(regex)) {
			throw new Exception(item[24] + "ֵ:" + items[24] + "��ֵ��д����ȷ,"
					+ item[24] + "������3λ���ּ�6λС��λ");
		} else if (!"".equals(items[24].trim())) {
			int latitude = Integer.parseInt(items[24].trim().substring(0, 3));
			if (latitude < 100 || latitude > 130) {
				throw new Exception(item[24] + "ֵ������100��130֮��");
			}
		}
		// \ ����״̬25
		this.ckNumber(items[25], item[25], 3, "no", newFlag);
		this.doCheckSystemParam("CH_VALIDFLAG", items[25].trim(), user,
				item[25]);
		// �����м����26
		this.ckString(items[26], item[26], 20);
		// \ ��Ӫ��־27
		this.ckString(items[27], item[27], 4, "no", newFlag);
		this.doCheckSystemParam("CH_WAY_RUNTYPE", items[27].trim(), user,
				item[27]);
		this.newFlag = "true";
	}

	public static void main(String args[]) throws Exception {
		try {
			for (int i = 0; i < item.length; i++) {
				System.out.println(i + ":" + item[i] + "\t");
			}

		} catch (Exception w) {
			w.printStackTrace();
		}
	}

	private void ckString(String item, String msg, int length, String isnull)
			throws Exception {
		if ("NOTNULL".equalsIgnoreCase(isnull)
				|| "NO".startsWith(isnull.toUpperCase())) {
			if (StringUtils.isEmpty(item.trim())) {
				throw new Exception(msg + "����Ϊ��");
			} else {
				ckString(item, msg, length);
			}
		}
	}

	private void ckString(String item, String msg, int length, String isnull,
			String newFlag) throws Exception {
		if ("true".equals(newFlag)) {
			this.ckString(item, msg, length, isnull);
		} else {
			this.ckString(item, msg, length);
		}
	}

	private void ckString(String item, String msg, int length) throws Exception {
		if (item.trim().getBytes("GBK").length > length) {
			throw new Exception(msg + ":" + item + " �ó��Ȳ��ܴ���" + length + "λ");
		}
	}

	private void ckNumber(String item, String msg, int length) throws Exception {
		String regex = "-?\\d{1," + length + "}";
		if (!"".equals(item.trim()) && !item.trim().matches(regex)) {
			throw new Exception(msg + ":" + item + " �������Ϊ���֣��ҳ��Ȳ��ܴ���" + length
					+ "λ");
		}
	}

	private void ckNumber(String item, String msg, int length, String isnull)
			throws Exception {
		if ("NOTNULL".equalsIgnoreCase(isnull)
				|| "NO".startsWith(isnull.toUpperCase())) {
			if (StringUtils.isEmpty(item.trim())) {
				throw new Exception(msg + "����Ϊ��");
			} else {
				ckNumber(item, msg, length);
			}
		}
	}

	private void ckNumber(String item, String msg, int length, String isnull,
			String newFlag) throws Exception {
		if ("true".equals(newFlag)) {
			this.ckNumber(item, msg, length, isnull);
		} else {
			this.ckNumber(item, msg, length);
		}
	}

	private void doCheckSystemParam(String groupid, String dictid, User user,
			String msg) throws Exception {
		DictitemDelegate delegate = new DictitemDelegate();
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid(groupid.trim());
		listVO.set_se_dictid(dictid.trim());
		if (delegate.doQuery(listVO, user).getRowCount() <= 0) {
			throw new Exception("��д�Ĺ̶�����:" + msg + "��ֵ:" + dictid + "����ȷ");
		}
	}

	private void doCheckWayType(String waytype, User user, String msg)
			throws Exception {
		WaytypeDelegate delegate = new WaytypeDelegate();
		WaytypeListVO listVO = new WaytypeListVO();
		listVO.set_se_waytypecode(waytype.trim());
		listVO.set_se_uppercode("-1");
		if (delegate.doQuery(listVO, user).getRowCount() <= 0) {
			throw new Exception("��д�� " + msg + " ��ֵ:" + waytype + "����ȷ");
		}
	}

	// ����ϼ�����
	private void doCheckWayID(String wayid, String msg, User user)
			throws Exception {
		WayDelegate delegate = new WayDelegate();
		WayListVO listVO = new WayListVO();
		listVO.set_se_wayid(wayid);
		if (delegate.doQuery(listVO, user).getRowCount() <= 0) {
			throw new Exception("��д�� " + msg + " ��ֵ:" + wayid + "����ȷ");
		}
	}

	private void doCheckSubWayType(String waytype, String uppperWaytype,
			User user, String msg) throws Exception {
		WaytypeDelegate delegate = new WaytypeDelegate();
		WaytypeListVO listVO = new WaytypeListVO();
		listVO.set_se_waytypecode(waytype.trim());
		listVO.set_se_uppercode(uppperWaytype.trim());
		if (delegate.doQuery(listVO, user).getRowCount() <= 0) {
			throw new Exception("��д��" + msg + "��ֵ:" + waytype + "����ȷ,���߸�����:"
					+ waytype + "�����ڸ��ϼ�����:" + uppperWaytype);
		}
	}

	private void checkCustomerWay(String code, String msg, User user)
			throws Exception {
		CustwaytypeDelegate delegate = new CustwaytypeDelegate();
		CustwaytypeListVO listVO = new CustwaytypeListVO();
		listVO.set_se_custwaytypecode(code.trim());
		if (delegate.doQuery(listVO, user).getRowCount() <= 0) {
			throw new Exception("��д��" + msg + "��ֵ:" + code + "����ȷ");
		}

	}
}
