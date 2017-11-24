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
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		delegate = (WayBO) BOFactory.build(WayBO.class,user);
//		有两个split的方法
//		String[] fields = StringUtils.splitPreserveAllTokens(line, "|");
//		String[] content = StringUtils.split(line, "|");
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != (8+1)) {
			throw new Exception("上传数据列数不对,应为8列,请查看说明帮助!");
		}
		if (StringUtils.isEmpty(content[0])) {
			throw new Exception("号码不能为空");
		}
		if (StringUtils.isEmpty(content[1])) {
			throw new Exception("购销渠道编码不能为空");
		}
		if(delegate.doFindByPk(content[1].trim())==null)
		{
			throw new Exception("[购销渠道编码]在系统中不存在");
		}

		if (!CheckUtil.checkDate(content[2], "yyyy-MM-dd HH:mm:ss", false)) {
			throw new Exception("激活时间不能为空,，正确格式为[yyyy-MM-dd HH:mm:ss]");
		}
		if (StringUtils.isEmpty(content[3])) {
			throw new Exception("充值金额不能为空");
		}
		int pos2=content[3].trim().indexOf(".");
		if(pos2==-1){
			if(content[3].trim().length()>12||Float.parseFloat(content[3].trim())<0)
				throw new Exception("充值金额:必须是数字类型并且整数部分不能超过12位，小数部分不能超过4位。");
		}else{
			if(pos2>12||(content[3].length()-pos2)>5||Float.parseFloat(content[3].trim())<0)
				throw new Exception("充值金额:必须是数字类型并且整数部分不能超过12位，小数部分不能超过4位。");
		}
		if (!CheckUtil.checkDate(content[4], "yyyy-MM-dd HH:mm:ss", false)) {
			throw new Exception("充值时间不能为空");
		}
		if (StringUtils.isEmpty(content[5])) {
			throw new Exception("结算金额不能为空");
		}
		int pos3=content[5].trim().indexOf(".");
		if(pos3==-1){
			if(content[5].trim().length()>12||Float.parseFloat(content[5].trim())<0)
				throw new Exception("结算金额:必须是数字类型并且整数部分不能超过12位，小数部分不能超过4位。");
		}else{
			if(pos3>12||(content[5].length()-pos3)>5||Float.parseFloat(content[5].trim())<0)
				throw new Exception("结算金额:必须是数字类型并且整数部分不能超过12位，小数部分不能超过4位。");
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		if (content[6] != null && !"".equals(content[6])) {
			try {
				format.parse(content[6]);
			} catch (Exception e) {
				throw new Exception("计发酬金月不能为空，正确格式为[yyyyMM]");
			}
		} else {
			throw new Exception("计发酬金月不能为空，正确格式为[yyyyMM]");
		}
		if (StringUtils.isEmpty(content[7])||!"1".equals(content[7].trim())) {
			throw new Exception("酬金类型不能为空,且必须为1");
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