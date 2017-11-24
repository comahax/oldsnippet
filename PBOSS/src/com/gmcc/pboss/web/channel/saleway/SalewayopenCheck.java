package com.gmcc.pboss.web.channel.saleway;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class SalewayopenCheck extends BaseCheckFormat {

	public SalewayopenCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount,User user) throws Exception {
		// TODO Auto-generated method stub
		String[] contents=new String[2];
		if(line.indexOf("|")>0){
			contents=StringUtils.splitPreserveAllTokens(line,'|');
		}else{
			contents[0]=line;
		}
		
		if(contents.length<1){
			throw new Exception("��������Ҫ��ͨ����������");
		}
		if (StringUtils.isBlank(contents[0])
				|| contents[0].trim().length() > 18) {
			throw new Exception("[��������]����Ϊ�ջ����18λ");
		}
		Way way=(Way)BOFactory.build(WayBO.class, user);
		WayVO vo= way.doFindByPk(contents[0].trim());
		if(vo==null){
			throw new Exception("�����������������");
		}else{
			if("AG".equals(vo.getWaytype()))
			{
				if(!"SAGT".equals(vo.getWaysubtype()) && !"PSAL".equals(vo.getWaysubtype()) && !"FD".equals(vo.getWaysubtype()) && !"FDS".equals(vo.getWaysubtype())&& !"VWAY".equals(vo.getWaysubtype()))
				{
					throw new Exception("��[����]���͵��������ܿ�ͨ������Ϣ����");
				}
			}else
			{
				throw new Exception("��[�������]���͵��������ܿ�ͨ������Ϣ����");
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		String text="JFJM000001|";
		String[] content=StringUtils.splitPreserveAllTokens(text, '|');
		System.out.println(text.indexOf("|"));
	}
}
