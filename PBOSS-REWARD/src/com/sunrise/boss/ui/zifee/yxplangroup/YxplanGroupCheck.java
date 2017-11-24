package com.sunrise.boss.ui.zifee.yxplangroup;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;



public class YxplanGroupCheck extends BaseCheckFormat {
	
	private String type=null;
	
	public YxplanGroupCheck(String type) {
		super();
		this.type=type;
	}
 
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}
	
	/**
	 * �ļ��е����ݼ��
	 */
	public void checkLine(String line, int rowCount) throws Exception {

		if (rowCount > 10000) {
			throw new Exception("�ļ��������ܳ���10000��");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		String[] items = StringUtils.split(line,"|");
		
		if(this.type.equals("ADD")||this.type.equals("DELETE")){
//			 �������
			if (items.length != 2) {
				throw new Exception("�ϴ�������������,ӦΪ2��,��鿴˵������!");
			}
			for (int i=0;i<items.length;i++){
				switch(i){
				case 0:
					if (!items[i].matches("[0-9]{1,14}")){
						throw new Exception("[Ӫ���������ʶ]��������Ϊ����");
					}
					break;
				
				//Ӫ��������ʶ1
				case 1:
					if (!items[i].matches("[0-9]{14}")){
						throw new Exception("[Ӫ��������ʶ]��������Ϊ14λ����");
					}
				break;
				}
			}
		}else if(this.type.equals("QUERY_GROUP")){
//			 �������
			if(!line.endsWith("|")){
				throw new Exception("�ϴ�������������,ӦΪ1��,���ԡ�|����β,��鿴˵������!");
			}
			if (items.length != 1) {
				throw new Exception("�ϴ�������������,ӦΪ1��,��鿴˵������!");
			}
			if (!items[0].matches("[0-9]{1,14}")){
				throw new Exception("[Ӫ���������ʶ]��������Ϊ����");
			}
		}else if(this.type.equals("QUERY_MEM")){
//			 �������
			if(!line.endsWith("|")){
				throw new Exception("�ϴ�������������,ӦΪ1��,���ԡ�|����β,��鿴˵������!");
			}
			if (items.length != 1) {
				throw new Exception("�ϴ�������������,ӦΪ1��,��鿴˵������!");
			}
			if (!items[0].matches("[0-9]{1,14}")){
				throw new Exception("[Ӫ��������ʶ]��������Ϊ����");
			}
		}else if(this.type.equals("QUERY_ALL")){
			
		}
	}
}
