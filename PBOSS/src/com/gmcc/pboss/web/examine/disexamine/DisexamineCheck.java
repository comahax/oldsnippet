package com.gmcc.pboss.web.examine.disexamine;

import java.io.File;
import java.util.HashMap; 
import org.apache.commons.lang.StringUtils;  
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;  
import com.sunrise.jop.ui.User;

public class DisexamineCheck extends BaseCheckFormat {

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {

		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 4) {
			throw new Exception("��" + rowCount + "��:[ " + line
					+ " ] ,��������ȷ,��ȷ����Ϊ4");
		}
		if (StringUtils.isEmpty(content[0])) {
			throw new Exception("��" + rowCount + "��:[ " + line + " ] ,�����̲���Ϊ��");
		}
		if (StringUtils.isEmpty(content[1])) {
			throw new Exception("��" + rowCount + "��:[ " + line + " ] ,�������ڲ���Ϊ��");
		}
		if (StringUtils.isEmpty(content[2])) {
			throw new Exception("��" + rowCount + "��:[ " + line + " ] ,�۷�����Ϊ��");
		}
		if (StringUtils.isEmpty(content[3])) {
			throw new Exception("��" + rowCount + "��:[ " + line + " ] ,ԭ����Ϊ��");
		}  
		checkParameter(content, user);

	}

	 /* 
	  * 1)	�ļ���ʽ���
              ������Ҫ���ַ����ͣ���󳤶�18λ����������Ҫ���ʽΪyyyyMM����󳤶�6λ���۷����Ϊ��ֵ���ͣ������16λ�������̡��������ڡ��۷�����˵������Ϊ�ա�
              ���ͨ���������һ������ͨ������ʾ�����ļ��кʹ�����������ֹ�ļ��ϴ���
         2)	�ļ�����
              ��������Ϣ��飺���������̲�ѯ������CH_PW_WAY�����������������д����ԭ�������̲����ڡ������ش�����һ����¼�����������һ����
              �������ڼ�飺��������Ҫ��Ϊ���£�������Ǳ�������д����ԭ�򡰿������ڲ�Ϊ���¡������ش�����һ����¼�����������һ���� 
	  */
	private void checkParameter(String[] fields, User user) throws Exception {
 
		//������
		if (StringUtils.isNotBlank(fields[0])) { 
			if (fields[0].trim().length() >18 ) {
				throw new Exception("������Ҫ���ַ����ͣ���󳤶�18λ");
			} 
			/*
			 Way wayBO = (Way)BOFactory.build(WayBO.class,user);
			 WayVO wayVO = wayBO.doFindByPk(fields[0]);
			 if (("").equals(wayVO) && null==wayVO ) {
				 throw new Exception("�����̲�����");
			 }
			*/
		} 
		//��������
		if (StringUtils.isNotBlank(fields[1])) {  
		     	if (fields[1].trim().length() !=6 ) {
				     throw new Exception("��������Ҫ���ʽΪyyyyMM����󳤶�6λ");
			      }
		}
		//�۷����
		if (StringUtils.isNotBlank(fields[2])) { 
			if (fields[2].length()>16 || Double.parseDouble(fields[2])<0 ) {
				throw new Exception("�۷����Ϊ��ֵ���ͣ������16λ");
			}
		} 
	}

	private boolean isEmpty(String checkStr) throws Exception {
		if (checkStr != null) {
			return StringUtils.isBlank(checkStr);
		} else {
			throw new Exception("����ַ���Ϊ��!");
		}
	}

}
