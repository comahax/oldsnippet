package com.sunrise.boss.ui.cms.et.chzdetadjust;

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

public class ChZdEtadjustCheck extends BaseCheckFormat {
	public ChZdEtadjustCheck() {
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
			throw new BusinessException("","�������벻��Ϊ��");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","ƽ̨�̲���Ϊ��");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","�ն��ͺŲ���Ϊ��");
		}
		if(StringUtils.isEmpty(content[3])){
			throw new BusinessException("","���ڲ������Ϊ��");
		}
		if(StringUtils.isEmpty(content[4])){
			throw new BusinessException("","������Ч���β���Ϊ��");
		}
		
		// �����·�
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMDD");
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 32, true)) {
					throw new Exception("[��������]���ܴ���32λ");
				}
				break;
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				if(StringUtils.isNotEmpty(content[i])){
					if (!CheckUtil.checkDouble(content[i], 10, 2)||((content[i].trim().indexOf(".") == -1 && content[i].trim().length() > 1))) {
						throw new Exception("[���ڲ�����]�������ֲ��ܳ���10λ,С�����ֲ��ܳ���2λ");
					}
				}
				break;
			case 4:
				if (content[i].trim().length() != 8){
					throw new Exception("[������Ч����]���ȱ���Ϊ8λ.");
				}
				String regex = "^([1-9]\\d{3}[0][1-9]([0][1]|[1][6]))|([1-9]\\d{3}[1][0-2]([0][1]|[1][6]))$";
				if (!content[i].matches(regex)) {
					throw new BusinessException("", "[������Ч����]���Ϸ�,�·ݷ�ΧӦΪ[01-12],�޶������λΪ01����16!");
				}
				try {
					sf.parse(content[i]);
				} catch (Exception pe) {
					throw new Exception("[������Ч����]��ʽ����,ӦΪyyyyMMDD");
				}
				break;
			case 5:
				
				break;

			
			}
		}
	}
	
	
}
