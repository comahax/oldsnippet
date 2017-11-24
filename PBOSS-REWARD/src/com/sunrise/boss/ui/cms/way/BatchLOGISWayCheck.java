package com.sunrise.boss.ui.cms.way;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountListVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountVO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.cms.bchcontact.BchcontactDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.wayaccount.WayaccountDelegate;
import com.sunrise.boss.delegate.cms.waycompact.WaycompactDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

/**
 * �����̼��check
 * 
 * @author zhaowen
 * 
 */
public class BatchLOGISWayCheck extends BaseCheckFormat {

	private WayDelegate delegate;

	private BchcontactDelegate bchdelegate;

	private WaycompactDelegate comdelegate;

	private WayaccountDelegate accdelegate;

	public BatchLOGISWayCheck() {
		super();
		try {
			delegate = new WayDelegate();
			bchdelegate = new BchcontactDelegate();
			comdelegate = new WaycompactDelegate();
			accdelegate = new WayaccountDelegate();
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
		for (int i = 0; i < items.length; i++) {
			items[i] = items[i] == null ? "" : items[i].trim();
		}
		// �������
		if (items.length != 30) {
			throw new Exception("�ϴ�������������,ӦΪ30��,��鿴˵������!");
		}
		WayVO wayVO = new WayVO();
		BchcontactVO bchcontactVO = new BchcontactVO();
		WaycompactVO waycompactVO = new WaycompactVO();
		WayaccountVO wayaccountVO = new WayaccountVO();
		// ��������0
		String regex="^[a-zA-Z][a-zA-z0-9-]{0,18}$";
		if (StringUtils.isBlank(items[0]) || !items[0].matches(regex)) {
			throw new Exception("���������ʽ����ȷ�򳤶ȳ�����ȷ��ΧΪ1~18");
		}
		wayVO.setWayid(items[0]);
		bchcontactVO.setWayid(items[0]);
		waycompactVO.setWayid(items[0]);
		wayaccountVO.setWayid(items[0]);

		wayVO = delegate.doFindByPk(wayVO.getWayid(), user);

		if (wayVO == null) {
			// ��������1
			// ��������1
			if (StringUtils.isEmpty(items[1])
					|| items[1].getBytes().length >256) {
				throw new Exception("�������Ʋ���Ϊ���ҳ��Ȳ��ܴ���256");
			}

			// �ϼ���������2
			if (!(items[2].getBytes().length>18 || "".equals(items[2])|| (items[2].indexOf("-") != -1))) {
				throw new Exception("�ϼ����������ʽ������ȷ���ȷ�ΧΪ1~18");
			}

			// ������3
			if (!items[3].matches("\\d{0,2}")) {
				throw new Exception("������������ȷΪ0-2λ����");
			}

			// ���й�˾4
			if (items[4].getBytes().length > 14) {
				throw new Exception("���й�˾���Ȳ��ܴ���14");
			}

			// �ֹ�˾5
			if (items[5].getBytes().length > 14) {
				throw new Exception("�ֹ�˾���Ȳ��ܴ���14");
			}

			// ������������6
			if (items[6].getBytes().length > 14) {
				throw new Exception("�����������ĳ��Ȳ��ܴ���14");
			}

			// ΢����7
			if (items[7].getBytes().length > 14) {
				throw new Exception("΢���򳤶Ȳ��ܴ���14");
			}

			// ��������8
			if (items[8].getBytes().length > 18) {
				throw new Exception("�����������Ȳ��ܴ���18");
			}

			// ����ֵ11
			if (!StringUtils.isEmpty(items[9])) {
				int i = items[9].indexOf(".");
				String flatitude = items[9].substring(0, i);
				String blatitude = items[9].substring(i + 1);
				if (!items[9].matches("[\\d.\\d]{1,10}")
						|| flatitude.length() != 3
						|| Double.valueOf(items[9]).doubleValue() <= 100
						|| Double.valueOf(items[9]).doubleValue() >= 130) {
					throw new Exception(
							"���ȸ�ʽ����ֵ��Χ���ԣ�����Ϊ100��130֮�䣬������Ϊ3λ��С��Ϊ6λ��");
				}
			} else {
				throw new Exception("���ȸ�ʽ����ֵ��Χ���ԣ�����Ϊ100��130֮�䣬������Ϊ3λ��С��Ϊ6λ��");
			}

			// γ��ֵ12
			if (!StringUtils.isEmpty(items[10])) {
				int i = items[10].indexOf(".");
				String flongtitude = items[10].substring(0, i);
				String blongtitude = items[10].substring(i + 1);
				if (!items[10].matches("[\\d.\\d]{1,9}")
						|| flongtitude.length() != 2
						|| blongtitude.length() != 6
						|| Double.valueOf(items[10]).doubleValue() <= 18
						|| Double.valueOf(items[10]).doubleValue() >= 26) {
					throw new Exception("γ�ȸ�ʽ����ֵ��Χ���ԣ�����Ϊ18��26֮�䣬������Ϊ2λ��С��Ϊ6λ��");
				}
			} else {
				throw new Exception("γ�ȸ�ʽ����ֵ��Χ���ԣ�����Ϊ18��26֮�䣬������Ϊ2λ��С��Ϊ6λ��");
			}

			// ��ϸ��ַ9
			if (items[11].getBytes().length > 128) {
				throw new Exception("��ϸ��ַ���Ȳ��ܴ���128");
			}
		} else {
			// ��������1
			if (!StringUtils.isEmpty(items[1])
					&& items[1].getBytes().length > 256) {
				throw new Exception("�������Ʋ���Ϊ���ҳ��Ȳ��ܴ���256");
			}

			// �ϼ���������2
			if (!items[2].matches("\\w{0,18}")) {
				throw new Exception("�������볤�ȳ�����ȷ��ΧΪ1~18");
			}

			// ������3
			if (!items[3].matches("\\d{0,2}")) {
				throw new Exception("������������ȷΪ0-2λ����");
			}

			// ���й�˾4
			if (items[4].getBytes().length > 14) {
				throw new Exception("���й�˾���Ȳ��ܴ���14");
			}

			// �ֹ�˾5
			if (items[5].getBytes().length > 14) {
				throw new Exception("�ֹ�˾���Ȳ��ܴ���14");
			}

			// ������������6
			if (items[6].getBytes().length > 14) {
				throw new Exception("�����������ĳ��Ȳ��ܴ���14");
			}

			// ΢����7
			if (items[7].getBytes().length > 14) {
				throw new Exception("΢���򳤶Ȳ��ܴ���14");
			}

			// ��������8
			if (items[8].getBytes().length > 18) {
				throw new Exception("�����������Ȳ��ܴ���18");
			}

			// ����ֵ11
			if (!StringUtils.isEmpty(items[9])) {
				int i = items[9].indexOf(".");
				String flatitude = items[9].substring(0, i);
				String blatitude = items[9].substring(i + 1);
				if (!items[9].matches("[\\d.\\d]{1,10}")
						|| flatitude.length() != 3
						|| Double.valueOf(items[9]).doubleValue() <= 100
						|| Double.valueOf(items[9]).doubleValue() >= 130) {
					throw new Exception(
							"���ȸ�ʽ����ֵ��Χ���ԣ�����Ϊ100��130֮�䣬������Ϊ3λ��С��Ϊ6λ��");
				}
			}

			// γ��ֵ12
			if (!StringUtils.isEmpty(items[10])) {
				int i = items[10].indexOf(".");
				String flongtitude = items[10].substring(0, i);
				String blongtitude = items[10].substring(i + 1);
				if (!items[10].matches("[\\d.\\d]{1,9}")
						|| flongtitude.length() != 2
						|| blongtitude.length() != 6
						|| Double.valueOf(items[10]).doubleValue() <= 18
						|| Double.valueOf(items[10]).doubleValue() >= 26) {
					throw new Exception("γ�ȸ�ʽ����ֵ��Χ���ԣ�����Ϊ18��26֮�䣬������Ϊ2λ��С��Ϊ6λ��");
				}
			}

			// ��ϸ��ַ9
			if (items[11].getBytes().length > 128) {
				throw new Exception("��ϸ��ַ���Ȳ��ܴ���128");
			}
		}

		// ����������12-------------------------------------------
		bchcontactVO = bchdelegate.doFindByPk(bchcontactVO.getWayid(), user);
		if (bchcontactVO == null) {
			if (!StringUtils.isEmpty(items[12])
					&& items[12].getBytes().length > 64) {
				throw new Exception("�������������Ȳ���Ϊ���Ҳ��ܴ���64");
			}

			// ��������ϵ�绰13
			if (!StringUtils.isEmpty(items[13])
					&& items[13].getBytes().length > 20) {
				throw new Exception("��������ϵ�绰��ʽ����");
			}

			// �����˵�������14
			if (!StringUtils.isEmpty(items[14])
					&& !items[14]
							.matches("[_a-zA-Z\\d\\-\\.]+@[_a-zA-Z\\d\\-]+(\\.[_a-zA-Z\\d\\-]+)+")) {
				throw new Exception("�����˵��������ʽ����");
			}

			// ҵ����ϵ������13
			if (!StringUtils.isEmpty(items[15])
					&& items[15].getBytes().length > 64) {
				throw new Exception("ҵ����ϵ����������Ϊ���ҳ��Ȳ��ܴ���64");
			}

			// ҵ����ϵ����ϵ�绰16
			if (!StringUtils.isEmpty(items[16])
					&& items[16].getBytes().length > 20) {
				throw new Exception("ҵ������ϵ�绰��ʽ����");
			}

			// ҵ����ϵ�˵�������17
			if (!StringUtils.isEmpty(items[17])
					&& !items[17]
							.matches("[_a-zA-Z\\d\\-\\.]+@[_a-zA-Z\\d\\-]+(\\.[_a-zA-Z\\d\\-]+)+")) {
				throw new Exception("ҵ����ϵ�˵��������ʽ����");
			}
		}
		// ��ͬ����18---------------------------------------------------------------------
		waycompactVO = comdelegate.doFindByPk(waycompactVO.getWayid(), user);
		if (waycompactVO == null) {
			if (!items[18].matches("\\w{1,17}")) {
				throw new Exception("��ͬ���볤���д�,��ȷ��Χ1~17");
			}

			// ��ͬ����19
			if (StringUtils.isEmpty(items[19])
					|| items[19].getBytes().length > 255) {
				throw new Exception("��ͬ���Ʋ���Ϊ���ҳ��Ȳ��ܴ���255");
			}

			// ǩ���ͬʱ��20
			Date d1 = null;
			try {
				d1 = format.parse(items[20]);
			} catch (Exception e) {
				throw new Exception("ǩ���ͬʱ���ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
			}

			// ��ͬ������21
			Date d2 = null;
			try {
				d2 = format.parse(items[21]);
			} catch (Exception e) {
				throw new Exception("��ͬ�����ո�ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
			}

			// �ж������Ⱥ�
			if (d2.before(d1)) {
				throw new Exception("��ͬ�����ո�����ǩ���ͬʱ�䣬��������");
			}

			// ���˴���20
			if (!StringUtils.isEmpty(items[22])
					&& items[22].getBytes().length > 64) {
				throw new Exception("���˴����Ȳ��ܴ���64");
			}

			// Ӫҵִ�ձ��23
			if (StringUtils.isEmpty(items[23])
					|| items[23].getBytes().length > 64) {
				throw new Exception("Ӫҵִ�ձ�ų��Ȳ��ܴ���64����Ϊ��");
			}

			// ��Ӫ�������ͱ���24
			if (!items[24].matches("\\d{0,2}")) {
				throw new Exception("��Ӫ�������ͣ���ȷΪ0-2λ����");
			} else {
				checkJYQY(items[24], user);
			}

			// ��Ӫ��Χ25
			if (!items[25].matches("\\d{0,2}")) {
				throw new Exception("��Ӫ��Χ����ȷΪ0-2λ����");
			}
		} else {
			if (!items[18].matches("\\w{0,17}")) {
				throw new Exception("��ͬ���볤���д�,��ȷ��Χ1~17");
			}

			// ��ͬ����19
			if (!StringUtils.isEmpty(items[19])
					&& items[19].getBytes().length > 255) {
				throw new Exception("��ͬ���Ʋ���Ϊ���ҳ��Ȳ��ܴ���255");
			}

			// ǩ���ͬʱ��20
			Date d1 = null;
			if (!StringUtils.isEmpty(items[20])) {
				try {
					d1 = format.parse(items[20]);
				} catch (Exception e) {
					throw new Exception("ǩ���ͬʱ���ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
				}
			}

			// ��ͬ������21
			Date d2 = null;
			if (!StringUtils.isEmpty(items[21])) {

				try {
					d2 = format.parse(items[21]);
				} catch (Exception e) {
					throw new Exception("��ͬ�����ո�ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
				}
			}

			// �ж������Ⱥ�
			if (!StringUtils.isEmpty(items[22])) {
				if (d2.before(d1)) {
					throw new Exception("��ͬ�����ո�����ǩ���ͬʱ�䣬��������");
				}
			}
			// ���˴���20
			if (!StringUtils.isEmpty(items[22])
					&& items[22].getBytes().length > 64) {
				throw new Exception("���˴����Ȳ��ܴ���64");
			}

			// Ӫҵִ�ձ��23
			if (!StringUtils.isEmpty(items[23])
					&& items[23].getBytes().length > 64) {
				throw new Exception("Ӫҵִ�ձ�ų��Ȳ��ܴ���64����Ϊ��");
			}

			// ��Ӫ�������ͱ���24
			if (!items[24].matches("\\d{0,2}")) {
				throw new Exception("��Ӫ�������ͣ���ȷΪ0-2λ����");
			} else {
				checkJYQY(items[24], user);
			}

			// ��Ӫ��Χ25
			if (!items[25].matches("\\d{0,2}")) {
				throw new Exception("��Ӫ��Χ����ȷΪ0-2λ����");
			}
		}

		// �ʻ���ʶ26------------------------------------------------------
		WayaccountListVO acclistvo = new WayaccountListVO();
		acclistvo.set_ne_accid(new Integer(1));
		acclistvo.set_se_wayid(items[0]);
		DataPackage accdp = (DataPackage) accdelegate.doQuery(acclistvo, user);
		List acclist = (List) accdp.getDatas();
		if (acclist.size() == 0) {
			// �����ʺ�28
			if (StringUtils.isEmpty(items[26])
					|| items[26].getBytes().length > 50) {
				throw new Exception("�����ʺų��Ȳ��ܴ���50");
			}
			// ��������27
			if (StringUtils.isEmpty(items[27])
					|| items[27].getBytes().length > 128) {
				throw new Exception("�������в�Ϊ�ܿ��ҳ��Ȳ��ܴ���128");
			}
			// �����˺�����29
			if (items[28] == null || "".equals(items[28].trim())) {
				throw new Exception("�����˺����Ʋ���Ϊ��");
			}
			// �����˺�����29
			if (StringUtils.isEmpty(items[28])
					|| items[28].getBytes().length > 50) {
				throw new Exception("�����˺����Ƴ��Ȳ��ܴ���50");
			}

			// ���������֤����30
			if (items[29].getBytes().length > 32) {
				throw new Exception("���������֤���볤�Ȳ��ܴ���32");
			}
		} else {
			// �����ʺ�28
			if (!StringUtils.isEmpty(items[26])
					&& items[26].getBytes().length > 50) {
				throw new Exception("�����ʺų��Ȳ��ܴ���50");
			}
			// ��������27
			if (!StringUtils.isEmpty(items[27])
					&& items[27].getBytes().length > 128) {
				throw new Exception("�������в�Ϊ�ܿ��ҳ��Ȳ��ܴ���128");
			}
			// �����˺�����29
			if (!StringUtils.isEmpty(items[28])
					&& items[28].getBytes().length > 50) {
				throw new Exception("�����˺����Ƴ��Ȳ��ܴ���50");
			}

			// ���������֤����30
			if (items[29].getBytes().length > 32) {
				throw new Exception("���������֤���볤�Ȳ��ܴ���32");
			}
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

	// test
	public static void main(String[] args) throws Exception {
		String string = "18.123456";
		int i = string.indexOf(".");
		String flongtitude = string.substring(0, i);
		String blongtitude = string.substring(i + 1);
		if (!string.matches("[\\d.\\d]{1,9}") || flongtitude.length() != 2
				|| blongtitude.length() != 6
				|| Integer.valueOf(flongtitude).intValue() <= 18
				|| Integer.valueOf(flongtitude).intValue() >= 26) {
			throw new Exception("���ȸ�ʽ����ֵ��Χ���ԣ�����Ϊ100��130֮�䣬������Ϊ3λ��С��Ϊ6λ��");
		}
	}
}