package com.sunrise.boss.ui.cms.chadtclassplatformtdstd;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class ChAdtClassplatformtdstdCheck extends BaseCheckFormat {
	public ChAdtClassplatformtdstdCheck() {
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
			throw new BusinessException("","BOSS��ƷID����Ϊ��");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","������Ͳ���Ϊ��");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","�Ƴ��ʶ����Ϊ��");
		}
		
		if(StringUtils.isEmpty(content[5])){
			throw new BusinessException("","����׼����Ϊ��");
		}
		
		//�������
		if (content[1] != null && !"".equals(content[1])) {
			try {
				if(Short.parseShort(content[1]) != 1){
					if(Short.parseShort(content[1]) != 2){
						throw new Exception("������Ͳ��ԣ���ȷΪ1��2");
					}					
				}
				
			} catch (Exception e) {
				throw new Exception("������Ͳ��ԣ���ȷΪ1��2");
			}
		} else {
			throw new Exception("������Ͳ��ԣ���ȷΪ1��2");
		}
		
		
		//�Ƴ��ʶ
		if (content[1] != null && !"".equals(content[1])) {
			try {
				if(Short.parseShort(content[1]) != 1){
					if(Short.parseShort(content[1]) != 2){
						throw new Exception("�Ƴ��ʶ���ԣ���ȷΪ1��2");
					}					
				}
			} catch (Exception e) {
				throw new Exception("�Ƴ��ʶ���ԣ���ȷΪ1��2");
			}
		} else {
			throw new Exception("�Ƴ��ʶ���ԣ���ȷΪ1��2");
		}

	}
	
	
}
