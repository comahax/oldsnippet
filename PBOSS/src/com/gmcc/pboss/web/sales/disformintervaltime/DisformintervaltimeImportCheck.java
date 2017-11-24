package com.gmcc.pboss.web.sales.disformintervaltime;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class DisformintervaltimeImportCheck extends BaseCheckFormat {
	
	//���͵�����ʱ�����������ϴ�
	
	public void checkFile(File file, HashMap parameterMap, String contentType)throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}
	
	public void checkLine(String line, int rowCount, User user)	throws Exception {
		// TODO Auto-generated method stub
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length!=5) {
			throw new Exception("�ϴ������ݸ�ʽ����ȷ,��鿴����˵��!");
		}
		if(content[0].equals("")){
			throw new Exception("�ֹ�˾���벻��Ϊ�գ�");
		}
		
		if(content[1].equals("")){
			throw new Exception("΢������벻��Ϊ��!");
		}
		
		if(content[2].equals("")){
			throw new Exception("�Ǽ�����Ϊ�գ�");
		}else{
			try{
				int starleve = Integer.parseInt(content[2]);
				if(starleve<0 || starleve>6){
					throw new Exception("�Ǽ�������0��6֮������֣�");
				}
			}catch(Exception e){
				throw new Exception("�Ǽ�������0��6֮������֣�");
			}
		}
		
		if(content[3].equals("")){
			throw new Exception("����ʱ�޲���Ϊ�գ�");
		}else{
			try{
				int interval = Integer.parseInt(content[3]);
				if(interval<0){
					throw new Exception("����ʱ�޲���Ϊ������");
				}
			}catch(Exception e){
				throw new Exception("����ʱ�ޱ���Ϊ���֣�");
			}
		}
	}
}
