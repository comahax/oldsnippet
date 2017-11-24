package com.sunrise.boss.ui.kdkhzld.chpwbroadlist;

import java.util.HashMap;

import org.apache.struts.upload.FormFile;

import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;

public class ChPwBroadlistBatchCheck extends BaseCheckFormat {
	
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
		
	}
	
	public void checkLine(String line, int rowCount, User user) throws Exception {
		
		String[] content =StringSplit.split(line, "|");
		
		if (content.length != 1) {
			throw new BusinessException("","�ļ���ʽ���ԣ�����ֻ��1��");
		}
		
		if(content[0] == null || "".equals(content[0])){
			throw new BusinessException("","���������벻��Ϊ��");
		}
		
		if(content[0].length() > 11){
			throw new BusinessException("","���������룬���ܳ���11λ");
		}
		try {
			Long.parseLong(content[0]);
		} catch (Exception e) {
			throw new BusinessException("","���������룬ֻ��Ϊ11λ����");
		}
	}
}
