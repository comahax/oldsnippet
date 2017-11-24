package com.sunrise.boss.ui.cms.waystrarewardstd;

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

public class WaystrarewardstdCheck extends BaseCheckFormat {
	public WaystrarewardstdCheck() {
		// TODO Auto-generated constructor stub
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
			throw new BusinessException("","�������벻��Ϊ��");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","����׼����Ϊ��");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","������Ͳ���Ϊ��");
		}
		if(StringUtils.isEmpty(content[3])){
			throw new BusinessException("","˵����ע����Ϊ��");
		}
		
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 20, true)) {
					throw new Exception("[��������]���ܴ���18λ");
				}
				break;
			case 1:
				if (!CheckUtil.checkDouble(content[i], 8, 2)) {
					throw new Exception("[����׼]�������ֲ��ܳ���8λ,С�����ֲ��ܳ���2λ");
				}
				
				break;
			case 2:
				if (!CheckUtil.checkString(content[i], 2,true)) {
					throw new Exception("[�������]���ܴ���2λ");
				}
				break;
			case 3:
				if (!CheckUtil.checkString(content[i], 256,true)) {
					throw new Exception("[˵����ע]���ܳ���256���ַ�");
				}
				break;
			
			
			}
		}
	}
	
	
}
