package com.gmcc.pboss.web.channel.checkedapply;

import java.io.File;
import java.util.HashMap; 
import org.apache.commons.lang.StringUtils; 

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class CheckedapplyCheck extends BaseCheckFormat {
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
		 
	}
	public void checkLine(String line, int rowCount, User user)throws Exception {

		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
//		if(("1").equals(content[2])){
	    if (content.length != 5) {
		   throw new Exception("[ " + line
				+ " ] ,��������ȷ,��ȷ����Ϊ4");
	     } 
//		}else{
//			if(content.length != 4 && content.length != 5){
//			  throw new Exception("��" + rowCount + "��:[ " + line
//						+ " ] ,��������ȷ,�������Ͳ�Ϊ1ʱ��ȷ�������3�У��������ݷǱ���");	
//			} 
//		} 
		if (content[0]!=null && content[0].trim().equals("")) {
			throw new Exception("�������벻��Ϊ��");
		}
		if (content[1]!=null && content[1].trim().equals("")) {
			throw new Exception("���˷�ʽ����Ϊ��");
		} else if (!("0").equals(content[1]) && !("1").equals(content[1])){
			throw new Exception("���˷�ʽ��ʽ���Ա�����0����1");
		}
		if (content[2]!=null && content[2].trim().equals("")) {
			throw new Exception("�������Ͳ���Ϊ��");
		}else if(!("0").equals(content[2]) && !("1").equals(content[2])){
			throw new Exception("�������͸�ʽ���Ա�����0����1");
		}
		if(("1").equals(content[2])){
		   if(content[3]!=null && content[3].trim().equals("")){
			   throw new Exception("��������Ϊ�˳�����ʱ���������ݲ���Ϊ��");	
			}else if(!("0").equals(content[3]) && !("1").equals(content[3])){
				throw new Exception("�������ݸ�ʽ���Ա�����0����1");
			}
		} 
}

}
