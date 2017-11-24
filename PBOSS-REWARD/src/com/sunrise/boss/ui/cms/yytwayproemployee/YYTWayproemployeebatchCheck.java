package com.sunrise.boss.ui.cms.yytwayproemployee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class YYTWayproemployeebatchCheck extends BaseCheckFormat {
	public YYTWayproemployeebatchCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user) throws Exception {
		String[] content =StringUtils.splitPreserveAllTokens(line, "|");
		
		if (content.length != 18) {//17
			throw new Exception("�ϴ�������������,ӦΪ17��,��鿴˵������!");
		}
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","�������벻��Ϊ��");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","�ֻ����벻��Ϊ��");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","�����������벻��Ϊ��");
		}
		if(StringUtils.isEmpty(content[3])){
			throw new BusinessException("","��Ա��������Ϊ��");
		}
		if(StringUtils.isEmpty(content[4])){
			throw new BusinessException("","��Ա���Ų���Ϊ��");
		}
		if(StringUtils.isEmpty(content[5])){
			throw new BusinessException("","״̬����Ϊ��");
		}
		if(StringUtils.isEmpty(content[8])){
			throw new BusinessException("","ע�����ڲ���Ϊ��");
		}
		if(StringUtils.isEmpty(content[9])){
			throw new BusinessException("","ͣ�����ڲ���Ϊ��");
		}
		if(StringUtils.isEmpty(content[10])){
			throw new BusinessException("","�Ƿ����ȫԱ������Ϊ��");
		}
		if(StringUtils.isEmpty(content[11])){
			throw new BusinessException("","�Ƿ����ʮ�����Ӽƻ�����Ϊ��");
		}
		if(StringUtils.isEmpty(content[12])){
			throw new BusinessException("","�Ƿ��ڲ�Ա������Ϊ��");
		}
		if(StringUtils.isEmpty(content[13])){
			throw new BusinessException("","רԱ��ݲ���Ϊ��");
		}
		if(StringUtils.isEmpty(content[16])){
			throw new BusinessException("","BOSS���Ų���Ϊ��");
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < content.length; i++) {
			switch (i) {
			// ��������
			case 0:
				if (!content[i].matches("[0,1]{1}")) {
					throw new Exception("[��������]ֻ��Ϊ0��1");
				}
				break;
			case 1:
//				if (!CheckUtil.checkString(content[i], 15)) {
//					throw new Exception("[�ֻ�����]���ܴ���15λ");
//				}
				if(content[i].trim().length()!=11){
					throw new Exception("[�ֻ�����]����Ϊ11λ");
				}
				if(!NumberUtils.isDigits(content[i])){
					throw new Exception("[�ֻ�����]����Ϊ����");
				}
				break;
			case 2:
				if (!CheckUtil.checkString(content[i], 18)) {
					throw new Exception("[������������]���ܴ���18λ");
				}
				break;
			case 3:
				if (!CheckUtil.checkString(content[i], 30, true)) {
					throw new Exception("[��Ա����]���ܴ���30λ");
				}
				break;
			case 4:
				if (!CheckUtil.checkString(content[i], 40)) {
					throw new Exception("[��Ա����]���ܴ���40λ");
				}
				break;
			case 5:
				if (!content[i].matches("[0,1]{1}")) {
					throw new Exception("[״̬]ֻ��Ϊ0��1");
				}
				break;
			case 6:
				if (!CheckUtil.checkString(content[i], 18, true)) {
					throw new Exception("[���֤����]���ܴ���18λ");
				}
				break;
			case 7:
				if (!CheckUtil.checkString(content[i], 128, true)) {
					throw new Exception("[���˵�������]���ܴ���128λ");
				}
				break;
			case 8:
				try {
					sf.parse(content[i]);
				} catch (ParseException pe) {
					throw new Exception("[ע������]��ʽ����,ӦΪyyyy-MM-dd");
				}
			case 9:
				try {
					sf.parse(content[i]);
				} catch (ParseException pe) {
					throw new Exception("[ͣ������]��ʽ����,ӦΪyyyy-MM-dd");
				}
				break;
			case 10:
				if (!content[i].matches("[0,1]{1}")) {
					throw new Exception("[�Ƿ����ȫԱ����]ֻ��Ϊ0��1");
				}
				break;
			case 11:
				if (!content[i].matches("[0,1]{1}")) {
					throw new Exception("[�Ƿ����ʮ�����Ӽƻ�]ֻ��Ϊ0��1");
				}
				break;
			case 12:
				if (!content[i].matches("[0,1]{1}")) {
					throw new Exception("[�Ƿ��ڲ�Ա��]ֻ��Ϊ0��1");
				}
				break;
			case 13:
				if(StringUtils.isNotBlank(content[i])){
					if (!content[i].matches("[1-9]{1}") && !content[i].matches("[1][0-9]{1}") && !"20".equals(content[i].trim())) {
						throw new Exception("[רԱ���]����ֵ����ȷ");
					}
				}
				break;
			case 14:
				if(StringUtils.isNotBlank(content[i]) && !CheckUtil.checkString(content[i], 512)){
					throw new Exception("רԱ���ע�͵ĳ��Ȳ��ܳ���512λ");
				}
				if (("7".equals(content[i-1]) || "8".equals(content[i-1])) && StringUtils.isBlank(content[i])) {
					throw new Exception("[רԱ���]Ϊ[Ӫҵ��][�ֹ�˾]��Աʱ,[רԱ���ע��]������ֵ����Ϊ��");
				}
				break;
			case 15:
				if (StringUtils.isNotBlank(content[i]) && !content[i].matches("[1-5]{1}")) {
					throw new Exception("[��Ա����]ֻ��Ϊ1��5֮������֣�����Ϊ��");
				}
				break;
			case 16:
				if(StringUtils.isNotBlank(content[i]) && !CheckUtil.checkString(content[i], 15)){
					throw new Exception("BOSS���ŵĳ��Ȳ��ܳ���15λ");
				}
				break;
			}
		}
	}
	public static void main(String []args) throws Exception {
		for(int i=1;i<=40;i++)
		{
				System.out.print(i+"\t");
				System.out.println(!(i+"").matches("[1-9]{1}") && !(i+"").matches("[1][0-9]{1}") && !"20".equals(i+""));
		}
	}
}
