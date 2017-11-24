package com.sunrise.boss.ui.cms.reward.assess;

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

public class AssessCheck extends BaseCheckFormat {
	public AssessCheck() {
		// TODO Auto-generated constructor stub
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
			throw new BusinessException("","�������벻��Ϊ��");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","�������Ͳ���Ϊ��");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","����ֵ����Ϊ��");
		}
		if(StringUtils.isEmpty(content[3])){
			throw new BusinessException("","�����·ݲ���Ϊ��");
		}
//		if(StringUtils.isEmpty(content[4])){
//			throw new BusinessException("","˵����ע����Ϊ��");
//		}
		
		// �����·�
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMM");
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 20, true)) {
					throw new Exception("[��������]���ܴ���20λ");
				}
				break;
			case 1:
				if (!CheckUtil.checkNum(content[i])) {
					throw new Exception("[��������]����Ϊ��������");
				}
				break;
			case 2:
				if (!CheckUtil.checkDouble(content[i], 8, 2)) {
					throw new Exception("[����ֵ]�������ֲ��ܳ���8λ,С�����ֲ��ܳ���2λ");
				}
				// ��¼�Ĺ�����ï���й�˾(668)�Ĺ���ʱ
//				if ("668".equals(user.getCityid())) {
//					Double dble = new Double("80.00");
//					Double kvalue = new Double(content[i].trim());
//					if (Double.compare(kvalue, dble) > 0) {
//						throw new Exception("[����ֵ]���ܴ���80");
//					}
//				}
				break;
			case 3:
				if (content[i].trim().length() != 6){
					throw new Exception("[����ʱ��]���ȱ���Ϊ6λ.");
				}
				String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
				if (!content[i].matches(regex)) {
					throw new BusinessException("", "[����ʱ��]���Ϸ�,�·ݷ�ΧӦΪ[01-12]!");
				}
				try {
					sf.parse(content[i]);
				} catch (Exception pe) {
					throw new Exception("[����ʱ��]��ʽ����,ӦΪyyyyMM");
				}
				break;
			case 4:
				if(!StringUtils.isEmpty(content[4])){
					if (!CheckUtil.checkString(content[i], 256,true)) {
						throw new Exception("[˵����ע]���ܳ���256���ַ�");
					}
				}
				break;
			
			
			}
		}
	}
	
	
}
