package com.sunrise.boss.ui.cms.chadtclassplatformtdinfo;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class ChAdtClassplatformtdinfoCheck extends BaseCheckFormat {
	public ChAdtClassplatformtdinfoCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user) throws Exception {
		String[] content =StringUtils.splitPreserveAllTokens(line, "|");
		
		if (content.length != 7) {
			throw new Exception("�ϴ�������������,ӦΪ6��,��鿴˵������!");
		}
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","�ն�Ʒ��ID����Ϊ��");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","BOSS��ƷID����Ϊ��");
		}
		if(StringUtils.isEmpty(content[3])){
			throw new BusinessException("","�����ڿ�ʼʱ�䲻��Ϊ��");
		}
		if(StringUtils.isEmpty(content[4])){
			throw new BusinessException("","�����ڽ���ʱ�䲻��Ϊ��");
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		// �����ڿ�ʼʱ��
		if (content[3] != null && !"".equals(content[3])) {
			try {
				format.parse(content[3]);
			} catch (Exception e) {
				throw new Exception("�����ڿ�ʼʱ���ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
			}
		} else {
			throw new Exception("�����ڿ�ʼʱ�䲻�ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
		}
		
		//�����ڽ���ʱ��
		if (content[4] != null && !"".equals(content[4])) {
			try {
				format.parse(content[4]);
			} catch (Exception e) {
				throw new Exception("�����ڽ���ʱ���ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
			}
		} else {
			throw new Exception("�����ڽ���ʱ�䲻�ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
		}
		
		
		if (!CheckUtil.checkString(content[5], 256,true)) {
			throw new Exception("[��ע]���ܳ���256���ַ�");
		}
		
	
	}
	
	
}
