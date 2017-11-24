package com.sunrise.boss.ui.cms.personalbusi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchPersonalbusiCheck extends BaseCheckFormat {
	public BatchPersonalbusiCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount) throws Exception {
		if (rowCount > 10000) {
			throw new Exception("�ļ��������ܳ���10000��");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		// �������
		if (items.length != 7) {
			throw new Exception("�ϴ�������������,ӦΪ6��,��鿴˵������!");
		}
		String[] columns = { "[����]", "[��������]", "[ҵ�������Ϣ����]", "[Ʒ��]", "[����ʱ��]", "[��������]","[��������]" };
		for (int i = 0; i < items.length - 1; i++) {
			if ("".equals(items[i].trim()) || items[i] == null) {
				throw new Exception(columns[i] + "����Ϊ��");
			}
		}
		try { // 
			if (!"".equals(items[0].trim())) {
				new Long(items[0].trim());
				if (items[0].trim().length() != 11) {
					throw new Exception("[����]Ӧ��Ϊ11λ����");
				}
			}
		} catch (Exception e) {
			throw new Exception("[����]Ӧ��Ϊ11λ����");
		}
		if (items[1].trim().length() > 18)
			throw new Exception("[��������]���Ȳ��ܴ���18λ");
		if (items[2].trim().length() > 18) {
			throw new Exception("[ҵ�������Ϣ����]���ܴ���18λ");
		}
		try { //  
			new Integer(items[3].trim());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("[Ʒ��]���Ͳ���(" + items[3] + "),Ӧ������������!");
		}
		try { //  
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			df.parse(items[4].trim());
		} catch (Exception e) {
			throw new Exception("[����ʱ��]���Ͳ���[" + items[4]
					+ "],Ӧ����[yyyy-MM-dd HH:mm:ss]��!");
		}
		if(items[5].trim().length()>1)
		{
			throw new Exception("[��������]���Ȳ���[" + items[5]
			                      					+ "],Ӧ����1λ");
		}
		if (!items[3].trim().matches("[123]")){
			throw new Exception("[Ʒ��]��ʽ����:ȡֵӦ��:1(ȫ��ͨ)2(������)3(���еش�)֮һ");
		}
		if(!items[5].trim().matches("[IUD]")){
			throw new Exception("[��������]��ʽ����:ȡֵӦ��:I(����)U(�޸�)D(ɾ����ȡ��)֮һ");
		}
	}
}
