package com.sunrise.boss.ui.cms.costcard;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchCostcardCheck extends BaseCheckFormat {
	private WayDelegate wayDelegate;

	private OperationDelegate operDelegate;

	public BatchCostcardCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	private WayDelegate getWayDelegate() throws Exception {
		if (wayDelegate == null) {
			return new WayDelegate();
		} else {
			return wayDelegate;
		}
	}

	private OperationDelegate getOperDelegate() throws Exception {
		if (operDelegate == null) {
			return new OperationDelegate();
		} else {
			return operDelegate;
		}

	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (rowCount > 50000) {
			throw new Exception("�ļ��������ܳ���50000��");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		// �������
		if (items.length != 5) {
			throw new Exception("�ϴ�������������,ӦΪ4��,��鿴˵������!");
		}
		String[] columns = { "[��������]", "[�����·�]", "[ҵ����]", "[��������(��)]" };
		for (int i = 0; i < items.length - 2; i++) {
			if ("".equals(items[i].trim()) || items[i] == null) {
				throw new Exception(columns[i] + "����Ϊ��");
			}

		}
		try { // 
			if (items[0].trim().length() > 18)
				throw new Exception("[��������]���Ȳ��ܴ���18λ");
			if (!"".equals(items[0].trim())) {
				WayVO vo = getWayDelegate().doFindByPk(items[0].trim(), user);
				if (vo == null) {
					throw new Exception(columns[0] + " : " + items[0].trim()
							+ " ��ϵͳ�в�����");
				}
			}
			if (!"".equals(items[1].trim())) {
				if (items[1].trim().length() != 6)
					throw new Exception("[�����·�]���Ȳ���,Ӧ����6λ");
				if (!items[1].trim().matches("\\d{6}")) {
					throw new Exception("[�����·�]������[YYYYMM]��ʽ");
				}
				long year = new Long(items[1].trim().substring(0, 4))
						.longValue();
				long month = new Long(items[1].trim().substring(4)).longValue();
				if (year < 0) {
					throw new Exception("[���]:" + year + "������[YYYY]��ʽ");
				}
				if (month > 12 || month < 0) {
					throw new Exception("[�·�]:" + month + "������ȷ������[MM]��ʽ");
				}
			}
			if (items[2].trim().length() > 18) {
				throw new Exception(columns[2] + ":" + items[2].trim()
						+ "���Ȳ��ܴ���18λ");
			}
			if (!"".equals(items[2].trim())) {
				OperationVO operVO = getOperDelegate().doFindByPk(
						items[2].trim(), user);
				if (operVO == null) {
					throw new Exception(columns[2] + " : " + items[2].trim()
							+ " ��ϵͳ�в�����");
				}
			}
			if (!"".equals(items[3].trim())) {
				try {
					new Long(items[3].trim());
				} catch (Exception ex) {
					throw new Exception(columns[3] + " : " + items[3].trim()
							+ "����Ϊ����");
				}
			}
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}
}
