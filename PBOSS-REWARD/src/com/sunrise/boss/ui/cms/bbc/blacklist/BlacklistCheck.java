package com.sunrise.boss.ui.cms.bbc.blacklist;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BlacklistCheck extends BaseCheckFormat {

	public BlacklistCheck(){
		
	}
	
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}
	
	public void checkLine(String line, int rowCount, User user) throws Exception {
		
		String[] content =StringUtils.splitPreserveAllTokens(line, "|");
		
		if (content.length != 6) {
			throw new Exception("�ϴ�������������,ӦΪ5��,��鿴˵������!");
		}

		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","ҵ�����Ʋ���Ϊ��");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","�ֻ����벻��Ϊ��");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","���˷�ʽ����Ϊ��");
		}
		if(StringUtils.isEmpty(content[3])){
			throw new BusinessException("","����ʱ�䲻��Ϊ��");
		}
		if(StringUtils.isEmpty(content[4])){
			throw new BusinessException("","ͣ��ʱ�䲻��Ϊ��");
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 20, true)) {
					throw new Exception("[ҵ������]���ܴ���20λ");
				}
				break;
			case 1:
				if (!CheckUtil.checkString(content[i], 15, true)) {
					throw new Exception("[�ֻ�����]���ܴ���15λ");
				}
				break;
			case 2:
				if (!CheckUtil.checkString(content[i], 20, true)) {
					throw new Exception("[���˷�ʽ]���ܴ���20λ");
				}
				break;
			case 3:
				if (content[i].trim().length()!=10) {
					throw new Exception("[����ʱ��]���ȱ���Ϊ10λ");
				}
				try {
					sf.parse(content[i]);
				} catch (Exception pe) {
					throw new Exception("[����ʱ��]��ʽ����,ӦΪyyyy-MM-dd");
				}
				break;
			case 4:
				if (content[i].trim().length()!=10) {
					throw new Exception("[ͣ��ʱ��]���ȱ���Ϊ10λ");
				}
				try {
					sf.parse(content[i]);
				} catch (Exception pe) {
					throw new Exception("[ͣ��ʱ��]��ʽ����,ӦΪyyyy-MM-dd");
				}
				break;
			}
	}
	}
}
