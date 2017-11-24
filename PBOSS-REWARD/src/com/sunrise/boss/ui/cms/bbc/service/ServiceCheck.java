package com.sunrise.boss.ui.cms.bbc.service;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class ServiceCheck extends BaseCheckFormat {

	public ServiceCheck(){
		
	}
	
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}
	
	public void checkLine(String line, int rowCount, User user) throws Exception {
		
		String[] content =StringUtils.splitPreserveAllTokens(line, "|");
		
		if (content.length != 5) {
			throw new Exception("�ϴ�������������,ӦΪ4��,��鿴˵������!");
		}
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","ҵ�����Ʋ���Ϊ��");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","ҵ����벻��Ϊ��");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","��������׼����Ϊ��");
		}
		if(StringUtils.isEmpty(content[3])){
			throw new BusinessException("","��������׼����Ϊ��");
		}
		
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 50, true)) {
					throw new Exception("[ҵ������]���ܴ���50λ");
				}
				break;
			case 1:
				if (!CheckUtil.checkString(content[i], 12,true)) {
					throw new Exception("[ҵ�����]���ܴ���12λ");
				}
				break;
			case 2:
				if (!CheckUtil.checkDouble(content[i], 6, 2)) {
					throw new Exception("[��������׼]�������ֲ��ܳ���6λ,С�����ֲ��ܳ���2λ");
				}
				break;
			case 3:
				if (!CheckUtil.checkDouble(content[i], 6, 2)) {
					throw new Exception("[��������׼]�������ֲ��ܳ���6λ,С�����ֲ��ܳ���2λ");
				}
				break;
			}	
		}
	}
	
}
