package com.sunrise.boss.ui.cms.cityrecord;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;

public class CityrecordCheck extends BaseCheckFormat {
	public CityrecordCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user) throws Exception {
		String[] content =StringUtils.splitPreserveAllTokens(line, "|");
		
		if (content.length != 11) {
			throw new Exception("�ϴ�������������,ӦΪ10��,��鿴˵������!");
		}
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","�������벻��Ϊ��");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","ҵ����벻��Ϊ��");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","�����������Ϊ��");
		}
		if(StringUtils.isEmpty(content[4])){
			throw new BusinessException("","�����·ݲ���Ϊ��");
		}
		if(StringUtils.isEmpty(content[5])){
			throw new BusinessException("","ҵ����ʱ�䲻��Ϊ��");
		}
		if(StringUtils.isEmpty(content[6])){
			throw new BusinessException("","ҵ������ҵ��������Ϊ��");
		}
		if(StringUtils.isEmpty(content[7])){
			throw new BusinessException("","Ӧ�����ϼƲ���Ϊ��");
		}
		if(StringUtils.isEmpty(content[8])){
			throw new BusinessException("","����Ӧ�������Ϊ��");
		}
		if(StringUtils.isEmpty(content[9])){
			throw new BusinessException("","�������벻��Ϊ��");
		}
		
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 18, true)) {
					throw new Exception("[��������]���ܴ���18λ");
				}
				break;
			case 1:
				if (!CheckUtil.checkString(content[i], 18, true)) {
					throw new Exception("[ҵ�����]���ܴ���18λ");
				}
				
				break;
			case 2:
				if (!CheckUtil.checkString(content[i], 3,true)) {
					throw new Exception("[�������]���ܴ���3λ");
				}
				break;
			case 3:
				if (!CheckUtil.checkString(content[i], 32,true)) {
					throw new Exception("[�ֻ������IMEI��]���ܳ���32���ַ�");
				}
				break;
			case 4:
				if (!CheckUtil.checkString(content[i], 6,true)) {
					throw new Exception("[�����·�]���ܳ���6���ַ�");
				}
				break;
			
			
			
			}
		}
	}
	
	
}
