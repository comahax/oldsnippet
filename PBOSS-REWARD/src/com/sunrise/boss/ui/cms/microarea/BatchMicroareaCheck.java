package com.sunrise.boss.ui.cms.microarea;

import java.util.HashMap;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.delegate.cms.microarea.MicroareaDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;

public class BatchMicroareaCheck extends BaseCheckFormat {
	public BatchMicroareaCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (rowCount > 10000) {
			throw new Exception("�ļ��������ܳ���10000��");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		// String[] items = line.split("\\|");
		String[] items = StringSplit.split(line, "|");
		// �������
		if (items.length != 9) {
			throw new Exception("�ϴ�������������,ӦΪ9��,��鿴˵������!");
		}
		MicroareaDelegate delegate = new MicroareaDelegate();
		if (items[0] == null || "".equals(items[0].trim())
				|| items[0].length() > 14)
			throw new Exception("[΢�������]����Ϊ�գ�Ҳ���ܴ���14λ!");
		if (delegate.doFindByPk(items[0], user) == null) {// ����
			if (items[1].length() > 14)
				throw new Exception("[�����������ı���]���������벻����14λ");
			if (items[2].length() > 64)
				throw new Exception("[΢��������]���������벻����64λ");
			try { // ���items[3]�Ƿ�Ϊ����
				Double temp = Double.valueOf(items[3]);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("[΢��������]���Ͳ���(" + items[3] + "),Ӧ���������ַ���!");
			}
			if (items[3].getBytes().length > 3)
				throw new Exception("[΢��������]���������벻����3λ");
			if (items[4].length() > 64)
				throw new Exception("[���˴���]���������벻����64λ");
			if (items[5].length() > 5)
				throw new Exception("[�Ʒ��������������]���������벻����5λ");
			if (items[6].length() > 18)
				throw new Exception("[������������]���������벻����18λ");
			if (items[7].length() > 15)
				throw new Exception("[�칫�ص㾭��]���������벻����15λ");
			if (items[8].length() > 15)
				throw new Exception("[�칫�ص�γ��]���������벻����15λ");
		} else {// �޸�
			if (!"null".equals(items[1]) && !"��".equals(items[1])
					&& !"".equals(items[1].trim())) {
				if (items[1].length() > 14)
					throw new Exception("[�����������ı���]���������벻����14λ");
			}
			if (!"null".equals(items[2]) && !"��".equals(items[2])
					&& !"".equals(items[2].trim())) {
				if (items[2].length() > 64)
					throw new Exception("[΢��������]���������벻����64λ");
			}
			if (!"null".equals(items[3]) && !"��".equals(items[3])
					&& !"".equals(items[3].trim())) {
				try { // ���items[3]�Ƿ�Ϊ����
					Double temp = Double.valueOf(items[3]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[΢��������]���Ͳ���(" + items[3]
							+ "),Ӧ���������ַ���!");
				}
				if (items[3].getBytes().length > 3)
					throw new Exception("[΢��������]���������벻����3λ");
			}
			if (!"null".equals(items[4]) && !"��".equals(items[4])
					&& !"".equals(items[4].trim())) {
				if (items[4].length() > 64)
					throw new Exception("[���˴���]���������벻����64λ");
			}
			if (!"null".equals(items[5]) && !"��".equals(items[5])
					&& !"".equals(items[5].trim())) {
				if (items[5].length() > 5)
					throw new Exception("[�Ʒ��������������]���������벻����5λ");
			}
			if (!"null".equals(items[6]) && !"��".equals(items[6])
					&& !"".equals(items[6].trim())) {
				if (items[6].length() > 18)
					throw new Exception("[������������]���������벻����18λ");
			}
			if (!"null".equals(items[7]) && !"��".equals(items[7])
					&& !"".equals(items[7].trim())) {
				if (Double.parseDouble(items[7]) > 130 || Double.parseDouble(items[7]) <100 || !items[7].matches("[0-9]{3}(.?)[0-9]{6}"))
					throw new Exception("[�칫�ص㾭��]��ȷ��С����6λ,����ֵ��100 �� 130 ֮��");
			}
			if (!"null".equals(items[8]) && !"��".equals(items[8])
					&& !"".equals(items[8].trim())) {
				if (Double.parseDouble(items[8]) > 26||Double.parseDouble(items[8]) <18 ||!items[8].matches("[0-9]{2}(.?)[0-9]{6}"))
					throw new Exception("[�칫�ص�γ��]��ȷ��С����6λ,γ��ֵ��18 �� 26 ֮��");
			}
		}
	}
}
