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
 * 社会渠道人员导入检查
 * @author wefrogll
 * @version 1.0 2009-11-20
 */
public class ZjtyPeopleCheck extends BaseCheckFormat{

	public void checkFile(File file, HashMap parameterMap, String contentType)
	throws Exception {
	if (!"text/plain".equalsIgnoreCase(contentType)) {
		throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
	}
}
	

	public void checkLine(String line, int rowCount, User user)
		throws Exception {
	// TODO Auto-generated method stub
	String[] content = StringUtils.splitPreserveAllTokens(line, "|");
	if (content.length !=20) {
		throw new Exception("第"+rowCount+"行:[ "+line+ " ] ,列数不正确,正确列数为19");	
	}
	if(!CheckUtil.checkString(content[1], 11,false))
	{
	throw new Exception("[公务机号码]长度为1~11");
	}
	if(!CheckUtil.checkString(content[2], 30,false))
	{
	throw new Exception("[姓名]长度为1~30");
	}
	// 出生日期
		if (StringUtils.isNotBlank(content[3])) {
			try {
				stringToDate(content[3], "yyyy-MM-dd");
			} catch (Exception ex) {
				throw new Exception("[出生日期]格式不正确");
			}
		}
	if(!CheckUtil.checkNum(content[4], 3,false))
	{
	throw new Exception("[性别]为数字,长度为1~3");
	}
	//＇身份证号码＇修改为必填，且长度必须为15/18位
	if(content[5].trim().length()!=15 && content[5].trim().length()!=18 )
	{
	throw new Exception("[身份证号码]长度必须为15/18位");
	}
	if(!CheckUtil.checkString(content[8], 14,false))
	{
	throw new Exception("[地市公司]长度为1~14");
	}
	if(!CheckUtil.checkString(content[9], 14,false))
	{
	throw new Exception("[分公司]长度为1~14");
	}
	if(!CheckUtil.checkString(content[11], 18,false))
	{
	throw new Exception("[所属网点]长度为1~18");
	}
	if (!CheckUtil.checkString(content[12], 10, false)) {
			throw new Exception("[入职时间]长度为1~10");
		} else {
			try {
				stringToDate(content[12], "yyyy-MM-dd");
			} catch (Exception ex) {
				throw new Exception("[入职时间]格式不正确");
			}
		}
	if(!CheckUtil.checkNum(content[13], 3,false))
	{
	throw new Exception("[劳动关系]为数字,长度为1~3");
	}
	if(!CheckUtil.checkString(content[14], 3,false))
	{
	throw new Exception("[用工性质]为数字,长度为1~3");
	}
	if(!CheckUtil.checkString(content[16], 3,false))
	{
	throw new Exception("[用工状态]为数字,长度为1~3");
	}
	if(!CheckUtil.checkString(content[18], 15,false))
	{
		throw new Exception("[boss工号]长度为1~15");
	}
	}
	public Date stringToDate(String dateStr,String dateFormat) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		return format.parse(dateStr);
	}
}
