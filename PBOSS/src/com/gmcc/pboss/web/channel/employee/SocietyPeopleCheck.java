package com.gmcc.pboss.web.channel.employee;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * 社会渠道人员导入检查
 * @author wefrogll
 * @version 1.0 2009-11-20
 */
public class SocietyPeopleCheck extends BaseCheckFormat{
	private String param92 = "";
	private String resultStr = "";
	private long preLineCount = 0;
	private boolean customeFlag = false;
	
	public static String[] lineHead = { "人员ID", "公务机号码", "姓名", "出生日期", "性别",
			"身份证号码", "地市公司", "分公司", "渠道编码", "入职时间", "劳动关系", "用工性质", 
			"用工状态", "是否为店主", "手机号", "服务销售中心", "保证金", "空中选号手机号" };

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		User user = (User) parameterMap.get("user");
		Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class, user);
		param92 = sysparamBO.doFindByID("92", "channel");
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}
	

	public void checkLine(String line, int rowCount, User user) throws Exception {
		if (null == line || "".equals(line)) {
			return;
		}
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		for (int i = 0; i < content.length; i++) {
			content[i] = content[i].trim();
		}
		
		if (rowCount == 1 && param92.equals("1")) {
			if (lineHead[0].equals(content[0])) {
				customeFlag = true;
				checkHead(content);
				return;
			} else {
				customeFlag = false;
			}
		}
		if (!customeFlag) {
			int length = 19;
			if (param92.equals("1")) {
				length = 20;
			}
			
			if (content.length != length) {
				throw new Exception("第" + rowCount + "行:[ " + line + " ] ,列数不正确,正确列数为" + length);
			}
			if (!CheckUtil.checkString(content[1], 11, false)) {
				throw new Exception("[公务机号码]长度为1~11");
			}
			if (!CheckUtil.checkString(content[2], 30, false)) {
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
			if (!CheckUtil.checkNum(content[4], 3, false)) {
				throw new Exception("[性别]为数字,长度为1~3");
			}
			// ＇身份证号码＇修改为必填，且长度必须为15/18位
			if (content[5].trim().length() != 15 && content[5].trim().length() != 18) {
				throw new Exception("[身份证号码]长度必须为15/18位");
			}
			if (!CheckUtil.checkString(content[8], 14, false)) {
				throw new Exception("[地市公司]长度为1~14");
			}
			if (!CheckUtil.checkString(content[9], 14, false)) {
				throw new Exception("[分公司]长度为1~14");
			}
			if (!CheckUtil.checkString(content[11], 18, false)) {
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
			if (!CheckUtil.checkNum(content[13], 3, false)) {
				throw new Exception("[劳动关系]为数字,长度为1~3");
			}
			if (!CheckUtil.checkString(content[14], 3, false)) {
				throw new Exception("[用工性质]为数字,长度为1~3");
			}
			if (!CheckUtil.checkString(content[16], 3, false)) {
				throw new Exception("[用工状态]为数字,长度为1~3");
			}
			if (param92.equals("1")) {
				if (StringUtils.isNotBlank(content[19]) && !content[19].trim().equals("0") && !content[19].trim().equals("1")) {
					throw new Exception("[是否为店主]只能为0或1");
				}
			}
		} else if (rowCount > 1 && customeFlag) {
			if ("".equals(content[0])) {
				throw new Exception("自定义导入人员ID不能为空");
			}
			if (preLineCount != content.length) {
				throw new Exception("自定义导入后面的数据列数与文件头列数必须一致!");
			}
			int count = lineHead.length;
			String checkLine[] = new String[count];
			content = copyArr(checkLine, content);
			updatecheck(content, user);
		}
	}
	
	public Date stringToDate(String dateStr,String dateFormat) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		return format.parse(dateStr);
	}
	
	private void checkHead(String[] content) throws Exception {
		preLineCount = content.length;
		// 清空结果串上次检查的结果
		this.resultStr = "";
		for (int i = 0; i < content.length; i++) {
			boolean find = false;
			for (int j = 0; (!find && j < lineHead.length); j++) {
				if ("".equals(content[i])) {
					throw new Exception("自定义导入文件头中不允许有空,且最后没有竖线");
				}
				if (content[i].equals(lineHead[j])) {
					resultStr = resultStr + j + "|";
					find = true;
					continue;
				}
			}
			if (!find) {
				throw new Exception("自定义文件头:[" + content[i] + "]不正确!");
			}
		}
	}
	
	private String[] copyArr(String[] arr, String[] content) {
		String temArr[] = StringUtils.splitPreserveAllTokens(resultStr, "|");
		for (int i = 0; i < temArr.length - 1; i++) {
			int temp = new Integer(temArr[i]).intValue();
			arr[temp] = content[i];
		}
		return arr;
	}
	
	private void updatecheck(String[] content, User user) throws Exception {
		for (int i = 0; i < content.length; i++) {
			Employee delegate = (EmployeeBO) BOFactory.build(EmployeeBO.class, user);
			switch (i) {
			// 人员ID
			case 0:
				if (delegate.doFindByPk(content[i]) == null) {
					throw new Exception("系统不存在该人员ID:" + content[0] + " 请检查核对");
				}
				break;
			// 公务机号码
			case 1:
				if (content[i] != null) {
					if (content[i].getBytes("GBK").length != 11) {
						throw new Exception("[公务机号码]长度必须为11位");
					} else {
						delegate.checkOfficeTel(content[i], user);
					}
				}
				break;
			// 姓名
			case 2:
				if (content[i] != null && content[i].getBytes("GBK").length > 30) {
					throw new Exception("[姓名]长度不能大于30位");
				}
				break;
			// 出生日期
			case 3:
				if (content[i] != null && !CheckUtil.checkDate(content[i], "yyyy-MM-dd")) {
					throw new Exception("[出生日期]格式不正确，应该为yyyy-MM-dd");
				}
				break;
			// 性别
			case 4:
				if (content[i] != null && !content[i].equals("0")
						&& !content[i].equals("1")) {
					throw new Exception("[性别]必须为数字，且必须为0或1");
				}
				break;
			// 身份证号码
			case 5:
				if (content[i] != null && content[i].length() != 15 && content[i].length() != 18) {
					throw new Exception("[身份证号码]长度必须为15或18位");
				}
				break;
			// 地市公司
			case 6:
				if (content[i] != null && content[i].getBytes("GBK").length > 14) {
					throw new Exception("[地市公司]长度必须为1-14位");
				}
				break;
			// 分公司
			case 7:
				if (content[i] != null && content[i].getBytes("GBK").length > 14) {
					throw new Exception("[分公司]长度必须为1-14位");
				}
				break;
			// 渠道编码
			case 8:
				if (content[i] != null) {
					Way bo = (WayBO) BOFactory.build(WayBO.class, user);
					WayVO vo = bo.doFindByPk(content[i]);
					if (vo == null) {
						throw new Exception("[渠道编码]所属渠道编码不存在");
					}
				}
				break;
			// 入职时间
			case 9:
				if (content[i] != null && !CheckUtil.checkDate(content[i], "yyyy-MM-dd")) {
					throw new Exception("[入职时间]格式不正确，应该为yyyy-MM-dd");
				}
				break;
			// 劳动关系
			case 10:
				if (content[i] != null && !content[i].equals("0") && !content[i].equals("1")) {
					throw new Exception("[劳动关系]必须为数字，且必须为0或1");
				}
				break;
			// 用工性质
			case 11:
				if (content[i] != null && !content[i].equals("0") 
						&& !content[i].equals("1") && !content[i].equals("2") 
						&& !content[i].equals("3") && !content[i].equals("99")) {
					throw new Exception("[用工性质]必须为数字，且值必须为0、1、2、3、99");
				}
				break;
			// 用工状态
			case 12:
				if (content[i] != null && !content[i].equals("0") && !content[i].equals("1")) {
					throw new Exception("[用工状态]必须为数字，且必须为0或1");
				}
				break;
			// 是否为店主
			case 13:
				if (content[i] != null && !content[i].equals("0") && !content[i].equals("1")) {
					throw new Exception("[是否为店主]必须为数字，且必须为0或1");
				}
				break;
			// 保证金
			case 16:
				if (content[i] != null && !CheckUtil.checkDouble(content[i])) {
					throw new Exception("[保证金]必须为数字");
				}
				break;
			}
		}
	}
}
