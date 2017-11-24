package com.sunrise.boss.ui.cms.yytwayproemployee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class YYTWayproemployeebatchCheck extends BaseCheckFormat {
	public YYTWayproemployeebatchCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user) throws Exception {
		String[] content =StringUtils.splitPreserveAllTokens(line, "|");
		
		if (content.length != 18) {//17
			throw new Exception("上传数据列数不对,应为17列,请查看说明帮助!");
		}
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","操作代码不能为空");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","手机号码不能为空");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","所属渠道编码不能为空");
		}
		if(StringUtils.isEmpty(content[3])){
			throw new BusinessException("","人员姓名不能为空");
		}
		if(StringUtils.isEmpty(content[4])){
			throw new BusinessException("","人员代号不能为空");
		}
		if(StringUtils.isEmpty(content[5])){
			throw new BusinessException("","状态不能为空");
		}
		if(StringUtils.isEmpty(content[8])){
			throw new BusinessException("","注册日期不能为空");
		}
		if(StringUtils.isEmpty(content[9])){
			throw new BusinessException("","停用日期不能为空");
		}
		if(StringUtils.isEmpty(content[10])){
			throw new BusinessException("","是否加入全员代理不能为空");
		}
		if(StringUtils.isEmpty(content[11])){
			throw new BusinessException("","是否加入十万种子计划不能为空");
		}
		if(StringUtils.isEmpty(content[12])){
			throw new BusinessException("","是否内部员工不能为空");
		}
		if(StringUtils.isEmpty(content[13])){
			throw new BusinessException("","专员身份不能为空");
		}
		if(StringUtils.isEmpty(content[16])){
			throw new BusinessException("","BOSS工号不能为空");
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < content.length; i++) {
			switch (i) {
			// 渠道编码
			case 0:
				if (!content[i].matches("[0,1]{1}")) {
					throw new Exception("[操作代码]只能为0或1");
				}
				break;
			case 1:
//				if (!CheckUtil.checkString(content[i], 15)) {
//					throw new Exception("[手机号码]不能大于15位");
//				}
				if(content[i].trim().length()!=11){
					throw new Exception("[手机号码]必须为11位");
				}
				if(!NumberUtils.isDigits(content[i])){
					throw new Exception("[手机号码]必须为数字");
				}
				break;
			case 2:
				if (!CheckUtil.checkString(content[i], 18)) {
					throw new Exception("[所属渠道编码]不能大于18位");
				}
				break;
			case 3:
				if (!CheckUtil.checkString(content[i], 30, true)) {
					throw new Exception("[人员姓名]不能大于30位");
				}
				break;
			case 4:
				if (!CheckUtil.checkString(content[i], 40)) {
					throw new Exception("[人员代号]不能大于40位");
				}
				break;
			case 5:
				if (!content[i].matches("[0,1]{1}")) {
					throw new Exception("[状态]只能为0或1");
				}
				break;
			case 6:
				if (!CheckUtil.checkString(content[i], 18, true)) {
					throw new Exception("[身份证号码]不能大于18位");
				}
				break;
			case 7:
				if (!CheckUtil.checkString(content[i], 128, true)) {
					throw new Exception("[个人电子邮箱]不能大于128位");
				}
				break;
			case 8:
				try {
					sf.parse(content[i]);
				} catch (ParseException pe) {
					throw new Exception("[注册日期]格式不对,应为yyyy-MM-dd");
				}
			case 9:
				try {
					sf.parse(content[i]);
				} catch (ParseException pe) {
					throw new Exception("[停用日期]格式不对,应为yyyy-MM-dd");
				}
				break;
			case 10:
				if (!content[i].matches("[0,1]{1}")) {
					throw new Exception("[是否加入全员代理]只能为0或1");
				}
				break;
			case 11:
				if (!content[i].matches("[0,1]{1}")) {
					throw new Exception("[是否加入十万种子计划]只能为0或1");
				}
				break;
			case 12:
				if (!content[i].matches("[0,1]{1}")) {
					throw new Exception("[是否内部员工]只能为0或1");
				}
				break;
			case 13:
				if(StringUtils.isNotBlank(content[i])){
					if (!content[i].matches("[1-9]{1}") && !content[i].matches("[1][0-9]{1}") && !"20".equals(content[i].trim())) {
						throw new Exception("[专员身份]属性值不正确");
					}
				}
				break;
			case 14:
				if(StringUtils.isNotBlank(content[i]) && !CheckUtil.checkString(content[i], 512)){
					throw new Exception("专员身份注释的长度不能超过512位");
				}
				if (("7".equals(content[i-1]) || "8".equals(content[i-1])) && StringUtils.isBlank(content[i])) {
					throw new Exception("[专员身份]为[营业厅][分公司]人员时,[专员身份注释]的属性值不能为空");
				}
				break;
			case 15:
				if (StringUtils.isNotBlank(content[i]) && !content[i].matches("[1-5]{1}")) {
					throw new Exception("[成员属性]只能为1到5之间的数字，或者为空");
				}
				break;
			case 16:
				if(StringUtils.isNotBlank(content[i]) && !CheckUtil.checkString(content[i], 15)){
					throw new Exception("BOSS工号的长度不能超过15位");
				}
				break;
			}
		}
	}
	public static void main(String []args) throws Exception {
		for(int i=1;i<=40;i++)
		{
				System.out.print(i+"\t");
				System.out.println(!(i+"").matches("[1-9]{1}") && !(i+"").matches("[1][0-9]{1}") && !"20".equals(i+""));
		}
	}
}
