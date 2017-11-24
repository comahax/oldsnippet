package com.sunrise.boss.ui.cms.bbc.subtracti;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;
import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class SubtractiCheck extends BaseCheckFormat {

	public SubtractiCheck(){
		
	}
	
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}
	
	public void checkLine(String line, int rowCount, User user) throws Exception {
		
		String[] content =StringUtils.splitPreserveAllTokens(line, "|");
		
		if (content.length != 3) {
			throw new Exception("�ϴ�������������,ӦΪ2��,��鿴˵������!");
		}
		if(StringUtils.isEmpty(content[0].trim())){
			throw new BusinessException("","����֧�����ҵ����벻��Ϊ��");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","�Ƴ��·ݲ���Ϊ��");
		}
		
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 18, true)) {
					throw new Exception("[����֧�����ҵ�����]���ܴ���18λ");
				}
				break;
			case 1:
				if (!CheckUtil.checkString(content[i], 6,true)) {
					throw new Exception("[�Ƴ��·�]���ܴ���6λ");
				}
				SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
				format.setLenient(false);
				if(content[i].length() != 6){
					throw new BusinessException("", "[�Ƴ��·�]���Ϸ�,���ȱ���Ϊ6λ!");
				}
				
				if(!NumberUtils.isNumber(content[i])){
					throw new BusinessException("", "[�Ƴ��·�]���Ϸ�,ֻ��Ϊ����!");
				}
					
				try {
					format.parse(content[i]);
				} catch (Exception e) {
					throw new BusinessException("", "[�Ƴ��·�]���Ϸ�,ӦΪ6λ��������!");
				}
				String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
				if (!content[i].matches(regex)) {
					throw new BusinessException("", "[�Ƴ��·�]���Ϸ�,�·ݷ�ΧӦΪ[01-12]!");
				}
				break;
			}	
		}
	}
	
}
