package com.gmcc.pboss.web.channel.zjty.employee;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.sunrise.jop.ui.User;

/**
 * ���������Ա������
 * @author wefrogll
 * @version 1.0 2009-11-20
 */
public class ZjtyPeopleCheck extends BaseCheckFormat{

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
	if (content.length !=20) {
		throw new Exception("��"+rowCount+"��:[ "+line+ " ] ,��������ȷ,��ȷ����Ϊ19");	
	}
	if(!CheckUtil.checkString(content[1], 11,false))
	{
	throw new Exception("[���������]����Ϊ1~11");
	}
	if(!CheckUtil.checkString(content[2], 30,false))
	{
	throw new Exception("[����]����Ϊ1~30");
	}
	// ��������
		if (StringUtils.isNotBlank(content[3])) {
			try {
				stringToDate(content[3], "yyyy-MM-dd");
			} catch (Exception ex) {
				throw new Exception("[��������]��ʽ����ȷ");
			}
		}
	if(!CheckUtil.checkNum(content[4], 3,false))
	{
	throw new Exception("[�Ա�]Ϊ����,����Ϊ1~3");
	}
	//�����֤���룧�޸�Ϊ����ҳ��ȱ���Ϊ15/18λ
	if(content[5].trim().length()!=15 && content[5].trim().length()!=18 )
	{
	throw new Exception("[���֤����]���ȱ���Ϊ15/18λ");
	}
	if(!CheckUtil.checkString(content[8], 14,false))
	{
	throw new Exception("[���й�˾]����Ϊ1~14");
	}
	if(!CheckUtil.checkString(content[9], 14,false))
	{
	throw new Exception("[�ֹ�˾]����Ϊ1~14");
	}
	if(!CheckUtil.checkString(content[11], 18,false))
	{
	throw new Exception("[��������]����Ϊ1~18");
	}
	if (!CheckUtil.checkString(content[12], 10, false)) {
			throw new Exception("[��ְʱ��]����Ϊ1~10");
		} else {
			try {
				stringToDate(content[12], "yyyy-MM-dd");
			} catch (Exception ex) {
				throw new Exception("[��ְʱ��]��ʽ����ȷ");
			}
		}
	if(!CheckUtil.checkNum(content[13], 3,false))
	{
	throw new Exception("[�Ͷ���ϵ]Ϊ����,����Ϊ1~3");
	}
	if(!CheckUtil.checkString(content[14], 3,false))
	{
	throw new Exception("[�ù�����]Ϊ����,����Ϊ1~3");
	}
	if(!CheckUtil.checkString(content[16], 3,false))
	{
	throw new Exception("[�ù�״̬]Ϊ����,����Ϊ1~3");
	}
	if(!CheckUtil.checkString(content[18], 15,false))
	{
		throw new Exception("[boss����]����Ϊ1~15");
	}
	}
	public Date stringToDate(String dateStr,String dateFormat) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		return format.parse(dateStr);
	}
}
