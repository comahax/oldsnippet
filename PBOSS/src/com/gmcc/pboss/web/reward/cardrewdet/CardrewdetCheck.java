package com.gmcc.pboss.web.reward.cardrewdet;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class CardrewdetCheck extends BaseCheckFormat {
	
	private Way delegate;

	public void checkFile(File file,HashMap parameterMap,  String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		delegate = (WayBO) BOFactory.build(WayBO.class,user);
//		������split�ķ���
//		String[] fields = StringUtils.splitPreserveAllTokens(line, "|");
//		String[] content = StringUtils.split(line, "|");
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != (8+1)) {
			throw new Exception("�ϴ�������������,ӦΪ8��,��鿴˵������!");
		}
		if (StringUtils.isEmpty(content[0])) {
			throw new Exception("���벻��Ϊ��");
		}
		if (StringUtils.isEmpty(content[1])) {
			throw new Exception("�����������벻��Ϊ��");
		}
		if(delegate.doFindByPk(content[1].trim())==null)
		{
			throw new Exception("[������������]��ϵͳ�в�����");
		}

		if (!CheckUtil.checkDate(content[2], "yyyy-MM-dd HH:mm:ss", false)) {
			throw new Exception("����ʱ�䲻��Ϊ��,����ȷ��ʽΪ[yyyy-MM-dd HH:mm:ss]");
		}
		if (StringUtils.isEmpty(content[3])) {
			throw new Exception("��ֵ����Ϊ��");
		}
		int pos2=content[3].trim().indexOf(".");
		if(pos2==-1){
			if(content[3].trim().length()>12||Float.parseFloat(content[3].trim())<0)
				throw new Exception("��ֵ���:�������������Ͳ����������ֲ��ܳ���12λ��С�����ֲ��ܳ���4λ��");
		}else{
			if(pos2>12||(content[3].length()-pos2)>5||Float.parseFloat(content[3].trim())<0)
				throw new Exception("��ֵ���:�������������Ͳ����������ֲ��ܳ���12λ��С�����ֲ��ܳ���4λ��");
		}
		if (!CheckUtil.checkDate(content[4], "yyyy-MM-dd HH:mm:ss", false)) {
			throw new Exception("��ֵʱ�䲻��Ϊ��");
		}
		if (StringUtils.isEmpty(content[5])) {
			throw new Exception("�������Ϊ��");
		}
		int pos3=content[5].trim().indexOf(".");
		if(pos3==-1){
			if(content[5].trim().length()>12||Float.parseFloat(content[5].trim())<0)
				throw new Exception("������:�������������Ͳ����������ֲ��ܳ���12λ��С�����ֲ��ܳ���4λ��");
		}else{
			if(pos3>12||(content[5].length()-pos3)>5||Float.parseFloat(content[5].trim())<0)
				throw new Exception("������:�������������Ͳ����������ֲ��ܳ���12λ��С�����ֲ��ܳ���4λ��");
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		if (content[6] != null && !"".equals(content[6])) {
			try {
				format.parse(content[6]);
			} catch (Exception e) {
				throw new Exception("�Ʒ�����²���Ϊ�գ���ȷ��ʽΪ[yyyyMM]");
			}
		} else {
			throw new Exception("�Ʒ�����²���Ϊ�գ���ȷ��ʽΪ[yyyyMM]");
		}
		if (StringUtils.isEmpty(content[7])||!"1".equals(content[7].trim())) {
			throw new Exception("������Ͳ���Ϊ��,�ұ���Ϊ1");
		}
		
	}
	
//	public static void main(String[] args){
//		
//		int pos3="1235.3".indexOf(".");
//		System.out.println(pos3);
//		System.out.println("1235.3".length()-pos3);
//		
//	}
}