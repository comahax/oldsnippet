package com.gmcc.pboss.web.channel.employee;

import java.io.File;
import java.util.HashMap;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class EmployeeCheck extends BaseCheckFormat {
	public void checkFile(File file, HashMap parameterMap, String contentType)
	throws Exception {
	if (!"text/plain".equalsIgnoreCase(contentType)) {
		throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
	}
}
	

	public void checkLine(String line, int rowCount, User user)
		throws Exception {
	// TODO Auto-generated method stub
	String[] content = StringUtils.splitPreserveAllTokens(line, "|");
	if (content.length !=34) {
		throw new Exception("��"+rowCount+"��:[ "+line+ " ] ,��������ȷ,��ȷ����Ϊ33");
	}
	if(StringUtils.isEmpty(content[1]))
		throw new Exception("��"+rowCount+"��:[ "+line+ " ] ,��������Ϊ��");
	if(StringUtils.isEmpty(content[13]))
		throw new Exception("��"+rowCount+"��:[ "+line+ " ] ,���й�˾����Ϊ��");
	if(StringUtils.isEmpty(content[17]))
		throw new Exception("��"+rowCount+"��:[ "+line+ " ] ,����������������������Ϊ��");
	if(StringUtils.isEmpty(content[19]))
		throw new Exception("��"+rowCount+"��:[ "+line+ " ] ,��λ����Ϊ��");
	if (StringUtils.isEmpty(content[7]))
		throw new Exception("��"+rowCount+"��:[ "+line+ " ] ,���֤���벻��Ϊ��");
	if (StringUtils.isEmpty(content[9]))
		throw new Exception("��"+rowCount+"��:[ "+line+ " ] ,���˵������䲻��Ϊ��");
	if (StringUtils.isEmpty(content[14]))
		throw new Exception("��"+rowCount+"��:[ "+line+ " ] ,�ֹ�˾����Ϊ��");
//	if (StringUtils.isEmpty(content[15]))
//		throw new Exception("��"+rowCount+"��:[ "+line+ " ] ,�����������Ĳ���Ϊ��");
	if (StringUtils.isEmpty(content[28]))
		throw new Exception("��"+rowCount+"��:[ "+line+ " ] ,�ù�״̬����Ϊ��");
	if (StringUtils.isEmpty(content[32]))
		throw new Exception("��"+rowCount+"��:[ "+line+ " ] ,�����ֻ����벻��Ϊ��");
	checkParameter(content,user);
	}
	
	private void checkParameter(String[] fields, User user) throws Exception {
		Dictitem delegate = (Dictitem)BOFactory.build(DictitemBO.class, user);
		DictitemVO vo = new DictitemVO();
		if (StringUtils.isNotBlank(fields[3])) {
			// �Ա�
			vo.setGroupid("CH_SEX");
			vo.setDictid(fields[3]);
			if (delegate.doFindByPk(vo) == null) {
				throw new Exception("�Ƿ��Ա���ο�˵��");
			}
		}
		if (StringUtils.isNotBlank(fields[5])) {
			// ������ò
			vo.setGroupid("CH_POLIVISAGE");
			vo.setDictid(fields[5]);
			if (delegate.doFindByPk(vo) == null) {
				throw new Exception("�Ƿ�������ò����ο�˵��");
			}
		}
		if (StringUtils.isNotBlank(fields[11])) {
			// �Ļ��̶�
			vo.setGroupid("CH_EDULEVEL");
			vo.setDictid(fields[11]);
			if (delegate.doFindByPk(vo) == null) {
				throw new Exception("�Ƿ��Ļ��̶ȣ���ο�˵��");
			}
		}
		if (StringUtils.isNotBlank(fields[19])) {
			// ��λ
			if (!"60".equals(fields[19])&&!"64".equals(fields[19])&&!"65".equals(fields[19])) {
				throw new Exception("�Ƿ���λ����ο�˵��");
			}
		}
		if (StringUtils.isNotBlank(fields[20])) {
			// ��λ����
			if (!"1".equals(fields[20])) {
				throw new Exception("�Ƿ���λ������ο�˵��");
			}
		}
		if (StringUtils.isNotBlank(fields[21])) {
			// ְ��
			vo.setGroupid("CH_JOBLEVEL");
			vo.setDictid(fields[21]);
			if (delegate.doFindByPk(vo) == null) {
				throw new Exception("�Ƿ�ְ������ο�˵��");
			}
		}
		if (StringUtils.isNotBlank(fields[26])) {
			// �Ͷ���ϵ
			vo.setGroupid("CH_CONTACTTYPE");
			vo.setDictid(fields[26]);
			if (delegate.doFindByPk(vo) == null) {
				throw new Exception("�Ƿ��Ͷ���ϵ����ο�˵��");
			}
		}
		if (StringUtils.isNotBlank(fields[27])) {
			// �ù�����
			vo.setGroupid("CH_EMPLOYTYPE");
			vo.setDictid(fields[27]);
			if (delegate.doFindByPk(vo) == null) {
				throw new Exception("�Ƿ��ù����ʣ���ο�˵��");
			}
		}
		if (StringUtils.isNotBlank(fields[28])) {
			// �ù�״̬
			vo.setGroupid("CH_EMPSTATUS");
			vo.setDictid(fields[28]);
			if (delegate.doFindByPk(vo) == null) {
				throw new Exception("�Ƿ��ù�״̬����ο�˵��");
			}
		}
		if (StringUtils.isNotBlank(fields[31])) {
			// ����״̬
			vo.setGroupid("CH_ISMARRIED");
			vo.setDictid(fields[31]);
			if (delegate.doFindByPk(vo) == null) {
				throw new Exception("�Ƿ�����״̬����ο�˵��");
			}
		}
		// ���֤����
		if (fields[7].length() != 15 && fields[7].length() != 18) {			
			throw new Exception("���֤���볤�ȱ���Ϊ15��18λ");
		}
		// ���˵�������
		if (!isVaildEmail(fields[9])) {
			throw new Exception("���˵��������ʽ���ԣ�����д��");
		}
	}

	private boolean isEmpty(String checkStr) throws Exception {
	if (checkStr != null) {
		return StringUtils.isBlank(checkStr);
	} else {
		throw new Exception("����ַ���Ϊ��!");
	}
	}
	
	public static boolean isVaildEmail(String email){ 
	     String emailPattern="[_a-zA-Z\\d\\-\\.]+@[_a-zA-Z\\d\\-]+(\\.[_a-zA-Z\\d\\-]+)+"; 
	     boolean result=Pattern.matches(emailPattern, email); 
	     return result; 
	}
}
