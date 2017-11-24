package com.sunrise.boss.ui.cms.dcord;

import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

/**
 * @author cx-yz
 * 
 */
public class BatchDcordCheck extends BaseCheckFormat {
	WayDelegate delegate = null;

	public BatchDcordCheck() {
		super();
		try {
			delegate = new WayDelegate();
		} catch (Exception e) {
			e.printStackTrace();
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

		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		// �������
		if (items.length != 7 && items.length != 3) {
			throw new Exception("��ʽ�����ֶ���������鿴�ļ���ʽ˵��!");
		}

		if (items.length == 7) {
			if (items[0] == null || "".equals(items[0].trim())) {
				throw new Exception("�������벻��Ϊ��");
			} else {
				WayVO vo = delegate.doFindByPk(items[0], user);
				if (vo == null) {
					throw new Exception("���������������������");
				}
				if (vo.getCityid() == null || !vo.getCityid().equals(SessionFactoryRouter.conversionCityid(user.getCityid()))) {
					throw new Exception("�����������������뵱ǰ�����������в�һ��");
				}
			}

			if (items[2] == null || "".equals(items[2].trim())) {
				throw new Exception("��������ֶβ���Ϊ���ұ��������֣����ܳ��ַ������ַ�");
			} else {
				String s = items[2].trim();
				if (!s.equals("1") && !s.equals("2") && !s.equals("3")) {
					throw new Exception("��������ֶ�ֻ����1��2��3�е���ֵ");
				}
			}

			if (!checkDate(items[3])) {
				throw new Exception("ҵ�����¸�ʽ����ȷ������Ϊ6λ�����ָ�ʽ����ݼ��·ݣ���201208");
			}

			if (!checkDate(items[4])) {
				throw new Exception("�����·ݸ�ʽ����ȷ������Ϊ6λ�����ָ�ʽ����ݼ��·ݣ���201208");
			}

			if (items[5] == null || "".equals(items[5].trim())) {
				throw new Exception("����״̬�ֶβ���Ϊ���ұ���������");
			} else {
				String stat = items[5].trim();
				if (!stat.equals("0") && !stat.equals("3") && !stat.equals("4")) {
					throw new Exception("����״̬�ֶ�ֻ����0��3��4�е���ֵ");
				}
			}
		} else if (items.length == 3) {
			if (items[0] == null || "".equals(items[0].trim())) {
				throw new Exception("���кŲ���Ϊ��");
			} else {
				if (!items[0].trim().matches("\\d*")) {
					throw new Exception("���кű���Ϊ����");
				}
			}

			if (items[1] == null || "".equals(items[1].trim())) {
				throw new Exception("����״̬�ֶβ���Ϊ���ұ���������");
			} else {
				String stat = items[1].trim();
				if (!stat.equals("0") && !stat.equals("3") && !stat.equals("4")) {
					throw new Exception("����״̬�ֶ�ֻ����0��3��4�е���ֵ");
				}
			}
		}
	}

	/**
	 * У�����ڸ�ʽ��YYYYMM
	 * 
	 * @param date
	 * @return
	 */
	private boolean checkDate(String date) {
		if (date == null || "".equals(date.trim())) {
			return false;
		} else if (!date.trim().matches("[0-9]{6}")) {
			return false;
		} else {
			int year = Integer.parseInt(date.trim().substring(0, 4));
			int month = Integer.parseInt(date.trim().substring(4));
			if (year < 1000 || month < 1 || month > 12) {
				return false;
			} else {
				return true;
			}
		}
	}
}
