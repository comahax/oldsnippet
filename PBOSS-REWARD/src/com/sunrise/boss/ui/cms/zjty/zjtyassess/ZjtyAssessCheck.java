package com.sunrise.boss.ui.cms.zjty.zjtyassess;

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

public class ZjtyAssessCheck extends BaseCheckFormat {
	public ZjtyAssessCheck() {
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
			throw new BusinessException("","�Ƴ��·ݱ�ʶ����Ϊ��");
		}
		
		// �����·�
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMM");
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 32, true)) {
					throw new Exception("[��������]���ܴ���32λ");
				}
				break;
			case 1:
				if (content[i].trim().length() != 6){
					throw new Exception("[�Ƴ��·�]���ȱ���Ϊ6λ.");
				}
				String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
				if (!content[i].matches(regex)) {
					throw new BusinessException("", "[�Ƴ��·�]���Ϸ�,�·ݷ�ΧӦΪ[01-12]!");
				}
				try {
					sf.parse(content[i]);
				} catch (Exception pe) {
					throw new Exception("[�Ƴ��·�]��ʽ����,ӦΪyyyyMM");
				}
				break;
			case 2:
//				int pos5 = content[5].trim().indexOf(".");
//				if (pos5 == -1) { 
//					if (content[5].trim().length() > 5)
//						throw new Exception("ͳһ�ۼۣ��������ͣ�֧����λС��������λ��󳤶�5λ��С��λ��󳤶�2λ��Ҫ����ڵ���0");
//				} else if (pos5 > 5) {
//					    throw new Exception("ͳһ�ۼۣ��������ͣ�֧����λС��������λ��󳤶�5λ��С��λ��󳤶�2λ��Ҫ����ڵ���0");
//				} else if (content[5].substring(pos5+1,content[5].length()).length()>2){
//					    throw new Exception("ͳһ�ۼۣ��������ͣ�֧����λС��������λ��󳤶�5λ��С��λ��󳤶�2λ��Ҫ����ڵ���0");
//				}
				if(StringUtils.isNotEmpty(content[i])){
//					if(content[i].trim().indexOf(".") == -1 && content[i].trim().length() > 1){
//						throw new Exception("[������ϵ��]�������ֲ��ܳ���1λ");
//					}
					if (!CheckUtil.checkDouble(content[i], 1, 2)||((content[i].trim().indexOf(".") == -1 && content[i].trim().length() > 1))) {
						throw new Exception("[������ϵ��]�������ֲ��ܳ���1λ,С�����ֲ��ܳ���2λ");
					}
				}
				break;
			case 3:
				if(StringUtils.isNotEmpty(content[i])){
					if (!CheckUtil.checkDouble(content[i], 1, 2)||((content[i].trim().indexOf(".") == -1 && content[i].trim().length() > 1))) {
						throw new Exception("[�ۺ�����ϵ��]�������ֲ��ܳ���1λ,С�����ֲ��ܳ���2λ");
					}
				}
				break;
			case 4:
				if(StringUtils.isNotEmpty(content[i])){
					if (!CheckUtil.checkDouble(content[i], 1, 2)||((content[i].trim().indexOf(".") == -1 && content[i].trim().length() > 1))) {
						throw new Exception("[���ϵ��]�������ֲ��ܳ���1λ,С�����ֲ��ܳ���2λ");
					}
				}
				break;
			case 5:
				if(StringUtils.isNotEmpty(content[i])){
					if(!CheckUtil.checkNum(content[i], 6) || Integer.parseInt(content[i])<0){
							throw new Exception("[��Ա����]���ڵ����������,�Ҳ��ܳ���6λ");
					}
				}
				break;
//			case 2:
//				if (!CheckUtil.checkDouble(content[i], 1, 1)) {
//					throw new Exception("[ӳ������]�������ֲ��ܳ���1λ,С�����ֲ��ܳ���1λ,�Ҳ���Ϊ��");
//				}
//				break;
			
			}
		}
	}
	
	
}
