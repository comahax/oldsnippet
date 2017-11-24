package com.sunrise.boss.ui.example.batchtest;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.boss.ui.commons.batch.upload.ICheckFormat;

/**
 * �̳�BaseCheckFormat����ʵ��ICheckFormat�ӿ�
 * @author liminghao
 */
public class BatchtestCheck extends BaseCheckFormat {
	public BatchtestCheck() {
		super();
	}

	public void checkFile(FormFile file,HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	    if(null==parameterMap.get("oprtype")){
		      throw new Exception("�������������!");	
		}
	}

	public void checkLine(String line, int rowCount) throws Exception {
		if (rowCount > 10000) {
			throw new Exception("�ļ��������ܳ���10000��");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		String[] items = line.split("\\|");
		// �������
		if (items.length != 3) {
			throw new Exception("�ϴ�������������,ӦΪ3��,��鿴˵������!");
		}
		// ���λ��
		if (items[0].length() != 11) {
			throw new Exception("����λ�����ԣ�Ӧ��Ϊ11λ�ĺ���!");
		}

		// �������
		try { // ���items[0]�Ƿ�Ϊ����
			Long temp1 = Long.valueOf(items[0]);
		} catch (Exception e1) {
			throw new Exception("�ϴ����ݵĺ����������Ͳ���(" + items[0] + "),Ӧ���������ַ���!");
		}
		// �������
		try { // ���items[2]�Ƿ�Ϊ����
			Short temp = Short.valueOf(items[2]);
			if (temp.shortValue() != 0 && temp.shortValue() != 1) {
				throw new Exception("�ϴ����ݵ�״̬����,(" + items[2] + ")ӦΪ0��1");
			}
		} catch (Exception e1) {
			throw new Exception("�ϴ����ݵ�״̬����,(" + items[2] + ")ӦΪ0��1");
		}
	}
}