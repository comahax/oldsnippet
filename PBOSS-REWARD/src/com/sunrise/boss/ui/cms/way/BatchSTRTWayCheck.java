package com.sunrise.boss.ui.cms.way;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaVO;
import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactVO;
import com.sunrise.boss.business.cms.common.AuditUtils;
import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountListVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountVO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.cms.adimarea.AdimareaDelegate;
import com.sunrise.boss.delegate.cms.bchcontact.BchcontactDelegate;
import com.sunrise.boss.delegate.cms.distribute.cooperator.CooperatorDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.wayaccount.WayaccountDelegate;
import com.sunrise.boss.delegate.cms.waycompact.WaycompactDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

/**
 * ������/������ CHECK
 * 
 * @author zhaowen
 * 
 */
public class BatchSTRTWayCheck extends BaseCheckFormat {

	private WayDelegate delegate;

	private BchcontactDelegate bchdelegate;

	private WaycompactDelegate comdelegate;

	private WayaccountDelegate accdelegate;

	private CooperatorDelegate coopdelegate;

	public BatchSTRTWayCheck() {
		super();
		try {
			delegate = new WayDelegate();
			bchdelegate = new BchcontactDelegate();
			comdelegate = new WaycompactDelegate();
			accdelegate = new WayaccountDelegate();
			coopdelegate = new CooperatorDelegate();
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (null == line || "".equals(line)) {
			return;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		for(int i=0;i<items.length;i++)
		{
			items[i]=items[i].trim();
		}
		// �������
		if (items.length != 49) {
			throw new Exception("�ϴ�������������,ӦΪ49��,��鿴˵������!");
		}
		WayVO wayVO = new WayVO();
		BchcontactVO bchcontactVO = new BchcontactVO();
		WaycompactVO waycompactVO = new WaycompactVO();
		WayaccountVO wayaccountVO = new WayaccountVO();
		CooperatorVO cooperatorvo = new CooperatorVO();// ������

		// ��������0
		if (items[0].getBytes("GBK").length > 18 || "".equals(items[0])) {
			throw new Exception("���������ʽ������ȷ��ΧΪ1~18");
		}else
		{
			if(!AuditUtils.doCheckWayidStyle(items[0]))
			{
				throw new Exception("���������ʽ����ȷ��ӦΪ��ĸ��ͷ��������ĸ���ֺ��ַ�-");
			}
		}

		wayVO.setWayid(items[0]);
		bchcontactVO.setWayid(items[0]);
		waycompactVO.setWayid(items[0]);
		wayaccountVO.setWayid(items[0]);
		cooperatorvo.setCooperauid(items[0]);

		wayVO = delegate.doFindByPk(wayVO.getWayid(), user);
		if (wayVO == null) {
			// ��������1
			if (StringUtils.isBlank(items[1])
					|| items[1].getBytes("GBK").length > 256) {
				throw new Exception("�������Ʋ���Ϊ���ҳ��Ȳ��ܴ���256");
			}

			// �ϼ���������2
			if (items[2].getBytes("GBK").length>18 ||StringUtils.isBlank(items[2])) {
				throw new Exception("�ϼ����������ʽ������ȷ��ΧΪ1~18");
			}

			// ������3
			if (!items[3].matches("\\d{0,2}")) {
				throw new Exception("������������ȷΪ0-2λ����");
			}

			// ���й�˾4
			if (items[4].getBytes("GBK").length > 14) {
				throw new Exception("���й�˾���Ȳ��ܴ���14");
			}

			// �ֹ�˾5
			if (items[5].getBytes("GBK").length > 14) {
				throw new Exception("�ֹ�˾���Ȳ��ܴ���14");
			}

			// ������������6
			if (items[6].getBytes("GBK").length > 14) {
				throw new Exception("�����������ĳ��Ȳ��ܴ���14");
			}

			// ΢����7
			if (items[7].getBytes("GBK").length > 14) {
				throw new Exception("΢���򳤶Ȳ��ܴ���14");
			}
			// ��˰��ʽ
			if (!items[8].matches("\\d{0,2}")) {
				throw new Exception("��˰��ʽ������ȷΪ0-2λ����");
			} else {
				// ����˰��ʽ
				checkKSFS(items[8], user);
			}
			// �����㼶
			if (!items[9].matches("\\d{0,2}")) {
				throw new Exception("�����㼶������ȷΪ0-2λ����");
			}

			// ��������10
			if (items[10].getBytes("GBK").length > 18) {
				throw new Exception("�����������Ȳ��ܴ���18");
			}

			// ����ֵ11
			if (!StringUtils.isBlank(items[11])) {
				int i = items[11].indexOf(".");
				String flatitude = items[11].substring(0, i);
				String blatitude = items[11].substring(i + 1);
				if (!items[11].matches("[\\d.\\d]{1,10}")
						|| flatitude.getBytes("GBK").length != 3 || blatitude.getBytes("GBK").length != 6
						|| Double.valueOf(items[11]).doubleValue() <= 100
						|| Double.valueOf(items[11]).doubleValue() >= 130) {
					throw new Exception(
							"���ȸ�ʽ����ֵ��Χ���ԣ�����Ϊ100��130֮�䣬������Ϊ3λ��С��Ϊ6λ��");
				}
			} else {
				throw new Exception("���ȸ�ʽ����ֵ��Χ���ԣ�����Ϊ100��130֮�䣬������Ϊ3λ��С��Ϊ6λ��");
			}

			// γ��ֵ12
			if (!StringUtils.isBlank(items[12])) {
				int i = items[12].indexOf(".");
				String flongtitude = items[12].substring(0, i);
				String blongtitude = items[12].substring(i + 1);
				if (!items[12].matches("[\\d.\\d]{1,9}")
						|| flongtitude.getBytes("GBK").length != 2
						|| blongtitude.getBytes("GBK").length != 6
						|| Double.valueOf(items[12]).doubleValue() <= 18
						|| Double.valueOf(items[12]).doubleValue() >= 26) {
					throw new Exception("γ�ȸ�ʽ����ֵ��Χ���ԣ�����Ϊ18��26֮�䣬������Ϊ2λ��С��Ϊ6λ��");
				}
			} else {
				throw new Exception("γ�ȸ�ʽ����ֵ��Χ���ԣ�����Ϊ18��26֮�䣬������Ϊ2λ��С��Ϊ6λ��");
			}

			// ��ϸ��ַ13
			if (items[13].getBytes("GBK").length > 128) {
				throw new Exception("��ϸ��ַ���Ȳ��ܴ���128");
			}
		} else {
			// ��������1
			if (!StringUtils.isBlank(items[1])
					&& items[1].getBytes("GBK").length > 256) {
				throw new Exception("�������Ʋ���Ϊ���ҳ��Ȳ��ܴ���256");
			}

			// �ϼ���������2
			if (items[2].getBytes("GBK").length>18) {
				throw new Exception("�ϼ��������볤�ȳ�����ȷ��ΧΪ1~18");
			}

			// ������3
			if (!items[3].matches("\\d{0,2}")) {
				throw new Exception("������������ȷΪ0-2λ����");
			}

			// ���й�˾4
			if (items[4].getBytes("GBK").length > 14) {
				throw new Exception("���й�˾���Ȳ��ܴ���14");
			}

			// �ֹ�˾5
			if (items[5].getBytes("GBK").length > 14) {
				throw new Exception("�ֹ�˾���Ȳ��ܴ���14");
			}

			// ������������6
			if (items[6].getBytes("GBK").length > 14) {
				throw new Exception("�����������ĳ��Ȳ��ܴ���14");
			}

			// ΢����7
			if (items[7].getBytes("GBK").length > 14) {
				throw new Exception("΢���򳤶Ȳ��ܴ���14");
			}
			// ��˰��ʽ
			if (!items[8].matches("\\d{0,2}")) {
				throw new Exception("��˰��ʽ������ȷΪ0-2λ����");
			} else {
				checkKSFS(items[8], user);
			}
			// �����㼶
			if (!items[9].matches("\\d{0,2}")) {
				throw new Exception("�����㼶������ȷΪ0-2λ����");
			}

			// ��������10
			if (items[10].getBytes("GBK").length > 18) {
				throw new Exception("�����������Ȳ��ܴ���18");
			}

			// ����ֵ11
			if (!StringUtils.isBlank(items[11])) {
				int i = items[11].indexOf(".");
				String flatitude = items[11].substring(0, i);
				String blatitude = items[11].substring(i + 1);
				if (!items[11].matches("[\\d.\\d]{1,10}")
						|| flatitude.getBytes("GBK").length != 3
						|| Double.valueOf(items[11]).doubleValue() <= 100
						|| Double.valueOf(items[11]).doubleValue() >= 130) {
					throw new Exception(
							"���ȸ�ʽ����ֵ��Χ���ԣ�����Ϊ100��130֮�䣬������Ϊ3λ��С��Ϊ6λ��");
				}
			}

			// γ��ֵ12
			if (!StringUtils.isBlank(items[12])) {
				int i = items[12].indexOf(".");
				String flongtitude = items[12].substring(0, i);
				String blongtitude = items[12].substring(i + 1);
				if (!items[12].matches("[\\d.\\d]{1,9}")
						|| flongtitude.getBytes("GBK").length != 2
						|| blongtitude.getBytes("GBK").length != 6
						|| Double.valueOf(items[12]).doubleValue() <= 18
						|| Double.valueOf(items[12]).doubleValue() >= 26) {
					throw new Exception("γ�ȸ�ʽ����ֵ��Χ���ԣ�����Ϊ18��26֮�䣬������Ϊ2λ��С��Ϊ6λ��");
				}
			}

			// ��ϸ��ַ13
			if (items[13].getBytes("GBK").length > 128) {
				throw new Exception("��ϸ��ַ���Ȳ��ܴ���128");
			}
		}

		// ����������14-------------------------------------------
		bchcontactVO = bchdelegate.doFindByPk(bchcontactVO.getWayid(), user);
		if (bchcontactVO == null) {
			if (StringUtils.isBlank(items[14])
					|| items[14].getBytes("GBK").length > 64) {
				throw new Exception("�������������Ȳ���Ϊ���Ҳ��ܴ���64");
			}

			// ��������ϵ�绰15
			if (StringUtils.isBlank(items[15])
					|| items[15].getBytes("GBK").length > 20) {
				throw new Exception("��������ϵ�绰��ʽ����");
			}

			// �����˵�������16
			if (!StringUtils.isBlank(items[16])
					&& !items[16]
							.matches("[_a-zA-Z\\d\\-\\.]+@[_a-zA-Z\\d\\-]+(\\.[_a-zA-Z\\d\\-]+)+")) {
				throw new Exception("�����˵��������ʽ����");
			}

			// ҵ����ϵ������17
			if (StringUtils.isBlank(items[17])
					|| items[17].getBytes("GBK").length > 64) {
				throw new Exception("ҵ����ϵ����������Ϊ���ҳ��Ȳ��ܴ���64");
			}

			// ҵ����ϵ����ϵ�绰18
			if (StringUtils.isBlank(items[18])
					|| items[18].getBytes("GBK").length > 20) {
				throw new Exception("ҵ������ϵ�绰��ʽ����");
			}

			// ҵ����ϵ�˵�������19
			if (!StringUtils.isBlank(items[19])
					&& !items[19]
							.matches("[_a-zA-Z\\d\\-\\.]+@[_a-zA-Z\\d\\-]+(\\.[_a-zA-Z\\d\\-]+)+")) {
				throw new Exception("ҵ����ϵ�˵��������ʽ����");
			}
			// ������λ
		} else {
			if (!StringUtils.isBlank(items[14])
					&& items[14].getBytes("GBK").length > 64) {
				throw new Exception("�������������Ȳ���Ϊ���Ҳ��ܴ���64");
			}

			// ��������ϵ�绰15
			if (!StringUtils.isBlank(items[15])
					&& items[15].getBytes("GBK").length > 20) {
				throw new Exception("��������ϵ�绰��ʽ����");
			}

			// �����˵�������16
			if (!StringUtils.isBlank(items[16])
					&& !items[16]
							.matches("[_a-zA-Z\\d\\-\\.]+@[_a-zA-Z\\d\\-]+(\\.[_a-zA-Z\\d\\-]+)+")) {
				throw new Exception("�����˵��������ʽ����");
			}

			// ҵ����ϵ������17
			if (!StringUtils.isBlank(items[17])
					&& items[17].getBytes("GBK").length > 64) {
				throw new Exception("ҵ����ϵ����������Ϊ���ҳ��Ȳ��ܴ���64");
			}

			// ҵ����ϵ����ϵ�绰18
			if (!StringUtils.isBlank(items[18])
					&& items[18].getBytes("GBK").length > 20) {
				throw new Exception("ҵ������ϵ�绰��ʽ����");
			}

			// ҵ����ϵ�˵�������19
			if (!StringUtils.isBlank(items[19])
					&& !items[19]
							.matches("[_a-zA-Z\\d\\-\\.]+@[_a-zA-Z\\d\\-]+(\\.[_a-zA-Z\\d\\-]+)+")) {
				throw new Exception("ҵ����ϵ�˵��������ʽ����");
			}

		}

		// ��ͬ����20---------------------------------------------------------------------
		waycompactVO = comdelegate.doFindByPk(waycompactVO.getWayid(), user);
		if (waycompactVO == null) {
			if (!items[20].matches("\\w{1,17}")) {
				throw new Exception("��ͬ���볤���д�,��ȷ��Χ1~17");
			}

			// ��ͬ����21
			if (StringUtils.isBlank(items[21])
					|| items[21].getBytes("GBK").length > 255) {
				throw new Exception("��ͬ���Ʋ���Ϊ���ҳ��Ȳ��ܴ���255");
			}

			// ǩ���ͬʱ��22
			Date d1 = null;
			try {
				d1 = format.parse(items[22]);
			} catch (Exception e) {
				throw new Exception("ǩ���ͬʱ���ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
			}

			// ��ͬ������21
			Date d2 = null;
			try {
				d2 = format.parse(items[23]);
			} catch (Exception e) {
				throw new Exception("��ͬ�����ո�ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
			}

			// �ж������Ⱥ�
			if (d2.before(d1)) {
				throw new Exception("��ͬ�����ո�����ǩ���ͬʱ�䣬��������");
			}

			// ���˴���24
			if (!StringUtils.isBlank(items[24])
					&& items[24].getBytes("GBK").length > 64) {
				throw new Exception("���˴����Ȳ��ܴ���64");
			}

			// Ӫҵִ�ձ��25
			if (StringUtils.isBlank(items[25])
					|| items[25].getBytes("GBK").length > 64) {
				throw new Exception("Ӫҵִ�ձ�Ų���Ϊ���ҳ��Ȳ��ܴ���64");
			}

			// ��Ӫ�������ͱ���26
			if (!items[26].matches("\\d{0,2}")) {
				throw new Exception("��Ӫ�������ͣ���ȷΪ0-2λ����");
			} else {
				// ��龭Ӫ�������ͱ���
				checkJYQY(items[26], user);
			}

			// ��Ӫ��Χ27
			if (!items[27].matches("\\d{0,2}")) {
				throw new Exception("��Ӫ��Χ����ȷΪ0-2λ����");
			}
		} else {
			if (!StringUtils.isBlank(items[20])
					&& !items[20].matches("\\w{0,17}")) {
				throw new Exception("��ͬ���볤���д�,��ȷ��Χ1~17");
			}

			// ��ͬ����21
			if (!StringUtils.isBlank(items[21])
					&& items[21].getBytes("GBK").length > 255) {
				throw new Exception("��ͬ���Ʋ���Ϊ���ҳ��Ȳ��ܴ���255");
			}

			// ǩ���ͬʱ��22
			Date d1 = null;
			if (!StringUtils.isBlank(items[22])) {
				try {
					d1 = format.parse(items[22]);
				} catch (Exception e) {
					throw new Exception("ǩ���ͬʱ���ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
				}
			}

			// ��ͬ������21
			Date d2 = null;
			if (!StringUtils.isBlank(items[23])) {
				try {
					d2 = format.parse(items[23]);
				} catch (Exception e) {
					throw new Exception("��ͬ�����ո�ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
				}
			}

			// ���˴���24
			if (!StringUtils.isBlank(items[24])
					&& items[24].getBytes("GBK").length > 64) {
				throw new Exception("���˴����Ȳ��ܴ���64");
			}

			// Ӫҵִ�ձ��25
			if (!StringUtils.isBlank(items[25])
					&& items[25].getBytes("GBK").length > 64) {
				throw new Exception("Ӫҵִ�ձ�Ų���Ϊ���ҳ��Ȳ��ܴ���64");
			}

			// ��Ӫ�������ͱ���26
			if (!items[26].matches("\\d{0,2}")) {
				throw new Exception("��Ӫ�������ͣ���ȷΪ0-2λ����");
			} else {
				// ��龭Ӫ�������ͱ����ֵ
				checkJYQY(items[26], user);
			}

			// ��Ӫ��Χ27
			if (!items[27].matches("\\d{0,2}")) {
				throw new Exception("��Ӫ��Χ����ȷΪ0-2λ����");
			}
		}
		// �ʻ���ʶ28------------------------------------------------------
		WayaccountListVO acclistvo = new WayaccountListVO();
		acclistvo.set_ne_accid(new Integer(1));
		acclistvo.set_se_wayid(items[0]);
		DataPackage accdp = (DataPackage) accdelegate.doQuery(acclistvo, user);
		List acclist = (List) accdp.getDatas();
		if (acclist.size() == 0) {

			// �����ʺ�28
			if (StringUtils.isBlank(items[28])
					|| items[28].getBytes("GBK").length > 50) {
				throw new Exception("�����ʺų��Ȳ��ܴ���50");
			}
			// ��������29
			if (StringUtils.isBlank(items[29])
					|| items[29].getBytes("GBK").length > 128) {
				throw new Exception("�������в�Ϊ�ܿ��ҳ��Ȳ��ܴ���128");
			}
			// �����˺�����(����)30
			if (items[30] == null || "".equals(items[30])) {
				throw new Exception("�����˺����Ʋ���Ϊ��!");
			}

			// �����˺�����30
			if (items[30].getBytes("GBK").length > 50) {
				throw new Exception("�����˺����Ƴ��Ȳ��ܴ���50");
			}

			// ���������֤����31
			if (items[31].getBytes("GBK").length > 32) {
				throw new Exception("���������֤���볤�Ȳ��ܴ���32");
			}

			if (!StringUtils.isBlank(items[32])
					&& items[32].getBytes("GBK").length > 128) {
				throw new Exception("�ͻ���ַ���Ȳ��ܳ���128");
			}

			// Ӫҵִ����Ч��
			if (items[36] != null && !"".equals(items[36])) {
				try {
					format.parse(items[36]);
				} catch (Exception e) {
					throw new Exception("Ӫҵִ����Ч�ڸ�ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
				}
			} else {
				throw new Exception("Ӫҵִ����Ч�ڸ�ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
			}
			// ��������
			if (items[38] != null && !"".equals(items[38])) {
				try {
					format.parse(items[38]);
				} catch (Exception e) {
					throw new Exception("�������ڸ�ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
				}
			} else {
				throw new Exception("�������ڸ�ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
			}

			if (items[39] != null && !"".equals(items[39])) {
				try {
					format.parse(items[39]);
				} catch (Exception e) {
					throw new Exception("��Чʱ���ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
				}
			} else {
				throw new Exception("��Чʱ���ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
			}

			if (items[40] != null && !"".equals(items[40])) {
				try {
					format.parse(items[40]);
				} catch (Exception e) {
					throw new Exception("ʧЧʱ���ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
				}
			} else {
				throw new Exception("ʧЧʱ���ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
			}
		} else {
			// �����ʺ�28
			if (!StringUtils.isBlank(items[28])
					&& items[28].getBytes("GBK").length > 50) {
				throw new Exception("�����ʺų��Ȳ��ܴ���50");
			}
			// ��������29
			if (!StringUtils.isBlank(items[29])
					&& items[29].getBytes("GBK").length > 128) {
				throw new Exception("�������в�Ϊ�ܿ��ҳ��Ȳ��ܴ���128");
			}
			// �����˺�����(����)30

			// �����˺�����30
			if (!StringUtils.isBlank(items[30])
					&& items[30].getBytes("GBK").length > 50) {
				throw new Exception("�����˺����Ƴ��Ȳ��ܴ���50");
			}

			// ���������֤����31
			if (items[31].getBytes("GBK").length > 32) {
				throw new Exception("���������֤���볤�Ȳ��ܴ���32");
			}

			// Ӫҵִ����Ч��
			if (items[36] != null && !"".equals(items[36])) {
				try {
					format.parse(items[36]);
				} catch (Exception e) {
					throw new Exception("Ӫҵִ����Ч�ڸ�ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
				}
			}
			// ��������
			if (items[38] != null && !"".equals(items[38])) {
				try {
					format.parse(items[38]);
				} catch (Exception e) {
					throw new Exception("�������ڸ�ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
				}
			}

			if (items[39] != null && !"".equals(items[39])) {
				try {
					format.parse(items[39]);
				} catch (Exception e) {
					throw new Exception("��Чʱ���ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
				}
			}
			if (items[40] != null && !"".equals(items[40])) {
				try {
					format.parse(items[40]);
				} catch (Exception e) {
					throw new Exception("ʧЧʱ���ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
				}
			}
		}

		if (!StringUtils.isBlank(items[33]) && items[33].getBytes("GBK").length > 32) {
			throw new Exception("�ջ���ϵ�˸�ʽ���ԣ����Ȳ��ܴ���32");
		}
		if (!StringUtils.isBlank(items[34]) && items[34].getBytes("GBK").length > 15) {
			throw new Exception("�ջ���ϵ�˺����ʽ���ԣ����Ȳ��ܴ���15");
		}
		if (!StringUtils.isBlank(items[35]) && items[35].getBytes("GBK").length > 20) {
			throw new Exception("�ջ���֤�������ʽ���ԣ����Ȳ��ܴ���20");
		}
		if (!StringUtils.isBlank(items[41]) && items[41].getBytes("GBK").length > 60) {
			throw new Exception("������λ��ʽ����,���Ȳ��ܳ���60!");
		}
		if (!StringUtils.isBlank(items[42]) && !items[42].matches("\\d{0,3}")) {
			throw new Exception("�����̼����ʽ����,������0-3λ������!");
		}
		if (!StringUtils.isBlank(items[42])) {
			checkCoplevel(items[42], user);
		}
		if (!StringUtils.isBlank(items[43]) && items[43].getBytes("GBK").length > 30) {
			throw new Exception("���̺Ÿ�ʽ����,���Ȳ��ܳ���30!");
		}
		if (!StringUtils.isBlank(items[44]) && !items[44].matches("\\d{0,3}")) {
			throw new Exception("֤������ʽ����,������0-3λ������!");
		}
		if (!StringUtils.isBlank(items[44])) {
			checkCertitype(items[44], user);
		}
		if (!StringUtils.isBlank(items[45]) && items[45].getBytes("GBK").length > 30) {
			throw new Exception("֤�������ʽ����,���Ȳ��ܳ���30!");
		}
		if (!StringUtils.isBlank(items[46]) && items[46].getBytes("GBK").length > 128) {
			throw new Exception("ע���ַ��ʽ����,���Ȳ��ܳ���128!");
		}
		if (!StringUtils.isBlank(items[47]) && !items[47].matches("\\d{0,14}")) {
			throw new Exception("ע���ʽ��ʽ����,������0-14λ������!");
		}
		if (!items[48].equals("0") && !items[48].equals("1")  ) {
			throw new Exception("����״̬������0��1!");
		}
	}

	// ����˰��ʽ
	public void checkKSFS(String item, User user) throws Exception {
		DictitemDelegate delegate = new DictitemDelegate();
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid("CH_STTAXTYPE");
		listVO.set_se_dictid(item);
		if (delegate.doQuery(listVO, user).getRowCount() <= 0) {
			throw new Exception("�̶�����[��˰��ʽ]��ֵ����ȷ");
		}
	}

	// ��龭Ӫ�������ͱ���
	public void checkJYQY(String item, User user) throws Exception {
		if ("".equals(item)) {
			return;
		}
		DictitemDelegate delegate = new DictitemDelegate();
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid("CH_ORGTYPE");
		listVO.set_se_dictid(item);
		if (delegate.doQuery(listVO, user).getRowCount() <= 0) {
			throw new Exception("�̶�����[�������ͱ���]��ֵ����ȷ");
		}
	}

	// ���̶����������̼���
	public void checkCoplevel(String item, User user) throws Exception {
		DictitemDelegate delegate = new DictitemDelegate();
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid("CH_COPLEVEL");
		listVO.set_se_dictid(item);
		if (delegate.doQuery(listVO, user).getRowCount() <= 0) {
			throw new Exception("�̶�����[�����̼���]��ֵ����ȷ");
		}
	}

	// ���̶�����֤������
	public void checkCertitype(String item, User user) throws Exception {
		DictitemDelegate delegate = new DictitemDelegate();
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid("IB_CERTITYPE");
		listVO.set_se_dictid(item);
		if (delegate.doQuery(listVO, user).getRowCount() <= 0) {
			throw new Exception("�̶�����[֤������]��ֵ����ȷ");
		}
	}

	// test
	public static void main(String[] args) throws Exception {
		// BatchSTRTWayCheck check = new BatchSTRTWayCheck();
		// String str =
		// "JFJMXXXXX|��������|JFJM00000|1|JM|JM|||5|0|1|123.23.45.02|123.23.45.02|���Ž���·101��|����|020-31647847|abcd@abc.com|����|0726-98564587|abc@xyz.com|45478|���Ժ�ͬ��Ϣ|1990-12-12|2006-01-02|����|abcde12323|1|1|98546|�й�����|��˾XX�ʻ�|1234567897894587|���ݴ��368��|����|13888888888|44052418203202235|2009-01-01|1000|2006-01-01";
		// try{
		// check.checkLine(str,0);
		// System.out.println("ok");
		// }catch(Exception e){
		// e.printStackTrace();
		// }
		// String str = "123";
		// System.out
		// .println(str.matches("\\d{0,3}"));
	}
}