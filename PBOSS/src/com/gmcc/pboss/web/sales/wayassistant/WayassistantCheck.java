package com.gmcc.pboss.web.sales.wayassistant;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;


import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;

import com.gmcc.pboss.control.channel.way.WayBO;

import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class WayassistantCheck extends BaseCheckFormat {
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}

	}

	// �ҳ�ÿ�����ݺ�����ݽ���У��
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		// TODO Auto-generated method stub
		// �������
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 7) {
			throw new Exception("��Ʒ����������Ϣ��д������,��鿴����˵��!");
		}
		// ÿ���ֶζ�Ҫ�ж��Ƿ�Ϊ�պ���Ч��Լ���������̱��Ҫ�ж��Ƿ����
		// �Ժ����̱������У��
		if (content[0] == null || this.isEmpty(content[0])) {
			throw new Exception("�����̱��벻����Ϊ��!");
		} else {
			WayBO waybo = (WayBO) BOFactory.build(
					WayBO.class, user);
			WayVO wayvo = waybo
					.doFindByPk(content[0]);
			if(wayvo==null)
			{
				throw new Exception("�����̱��벻����!");
			}
		}
		
		// ���Ƿ�ɷ��𶩹��ֶ�У��
		if(content[1]==null||this.isEmpty(content[1])){
			throw new Exception("�Ƿ�ɷ��𶩹�������Ϊ�գ�");
		}
		else{
			int conorder=-1;
			try{
				conorder=Integer.parseInt(content[1]);
			}catch(Exception e){
				throw new Exception("�Ƿ�ɷ��𶩹�ֻ�������֣�");
			}
			if(conorder!=0&&conorder!=1){
				throw new Exception("�Ƿ�ɷ��𶩹�ֻ��Ϊ1��0��");
			}
			
		}
		

		// ���Ƿ��ӡ��Ʊ�ֶ�У��
		if(content[2]==null||this.isEmpty(content[2])){
			throw new Exception("�Ƿ��ӡ��Ʊ������Ϊ�գ�");
		}
		else{
			int printinvoice=-1;
			try{
				printinvoice=Integer.parseInt(content[2]);
			}catch(Exception e){
				throw new Exception("�Ƿ��ӡ��Ʊֻ�������֣�");
			}
			if(printinvoice!=0 && printinvoice!=1){
				throw new Exception("�Ƿ��ӡ��Ʊֻ��Ϊ1��0��");
			}
			
		}
		
		
		// �Խɷѷ�ʽ�ֶ�У��
		if(content[3]==null||this.isEmpty(content[3])){
			throw new Exception("�ɷѷ�ʽ������Ϊ�գ�");
		}
		else{
			String 	paytype=content[3];
			if(!paytype.equals("ADPAY") && !paytype.equals("BANK") && !paytype.equals("CASH") && !paytype.equals("POS")){
				throw new Exception("�ɷѷ�ʽ�������벻��ȷ��");
			}
		}
		
		// ���ͻ���ʽ�ֶ�У��
		if(content[4]==null||this.isEmpty(content[4])){
			throw new Exception("�ͻ���ʽ������Ϊ�գ�");
		}
		else{
			String 	delitype=content[4];
			if(!delitype.equals("ARRIVEPAY") && !delitype.equals("PAYFIRST")){
				throw new Exception("�ͻ���ʽ�������벻��ȷ��");
			}
		}
		
		
		// ���Ƿ�ɶ��������ֶ�У��
		if(content[5]==null||this.isEmpty(content[5])){
			throw new Exception("�Ƿ�ɶ������Ų�����Ϊ�գ�");
		}
		else{
			int orderbetterno=-1;
			try{
				orderbetterno=Integer.parseInt(content[5]);
			}catch(Exception e){
				throw new Exception("�Ƿ�ɶ��������������");
			}
			if(orderbetterno!=0&&orderbetterno!=1){
				throw new Exception("�Ƿ�ɶ�������ֻ��Ϊ1��0��");
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
