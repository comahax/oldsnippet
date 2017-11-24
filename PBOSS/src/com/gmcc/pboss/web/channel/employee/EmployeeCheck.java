package com.gmcc.pboss.web.channel.employee;

import java.io.File;
import java.util.HashMap;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class EmployeeCheck extends BaseCheckFormat {
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
	if (content.length !=34) {
		throw new Exception("第"+rowCount+"行:[ "+line+ " ] ,列数不正确,正确列数为33");
	}
	if(StringUtils.isEmpty(content[1]))
		throw new Exception("第"+rowCount+"行:[ "+line+ " ] ,姓名不能为空");
	if(StringUtils.isEmpty(content[13]))
		throw new Exception("第"+rowCount+"行:[ "+line+ " ] ,地市公司不能为空");
	if(StringUtils.isEmpty(content[17]))
		throw new Exception("第"+rowCount+"行:[ "+line+ " ] ,服务厅（所属渠道）不能为空");
	if(StringUtils.isEmpty(content[19]))
		throw new Exception("第"+rowCount+"行:[ "+line+ " ] ,岗位不能为空");
	if (StringUtils.isEmpty(content[7]))
		throw new Exception("第"+rowCount+"行:[ "+line+ " ] ,身份证号码不能为空");
	if (StringUtils.isEmpty(content[9]))
		throw new Exception("第"+rowCount+"行:[ "+line+ " ] ,个人电子邮箱不能为空");
	if (StringUtils.isEmpty(content[14]))
		throw new Exception("第"+rowCount+"行:[ "+line+ " ] ,分公司不能为空");
//	if (StringUtils.isEmpty(content[15]))
//		throw new Exception("第"+rowCount+"行:[ "+line+ " ] ,服务销售中心不能为空");
	if (StringUtils.isEmpty(content[28]))
		throw new Exception("第"+rowCount+"行:[ "+line+ " ] ,用工状态不能为空");
	if (StringUtils.isEmpty(content[32]))
		throw new Exception("第"+rowCount+"行:[ "+line+ " ] ,公务手机号码不能为空");
	checkParameter(content,user);
	}
	
	private void checkParameter(String[] fields, User user) throws Exception {
		Dictitem delegate = (Dictitem)BOFactory.build(DictitemBO.class, user);
		DictitemVO vo = new DictitemVO();
		if (StringUtils.isNotBlank(fields[3])) {
			// 性别
			vo.setGroupid("CH_SEX");
			vo.setDictid(fields[3]);
			if (delegate.doFindByPk(vo) == null) {
				throw new Exception("非法性别，请参看说明");
			}
		}
		if (StringUtils.isNotBlank(fields[5])) {
			// 政治面貌
			vo.setGroupid("CH_POLIVISAGE");
			vo.setDictid(fields[5]);
			if (delegate.doFindByPk(vo) == null) {
				throw new Exception("非法政治面貌，请参看说明");
			}
		}
		if (StringUtils.isNotBlank(fields[11])) {
			// 文化程度
			vo.setGroupid("CH_EDULEVEL");
			vo.setDictid(fields[11]);
			if (delegate.doFindByPk(vo) == null) {
				throw new Exception("非法文化程度，请参看说明");
			}
		}
		if (StringUtils.isNotBlank(fields[19])) {
			// 岗位
			if (!"60".equals(fields[19])&&!"64".equals(fields[19])&&!"65".equals(fields[19])) {
				throw new Exception("非法岗位，请参看说明");
			}
		}
		if (StringUtils.isNotBlank(fields[20])) {
			// 岗位级别
			if (!"1".equals(fields[20])) {
				throw new Exception("非法岗位级别，请参看说明");
			}
		}
		if (StringUtils.isNotBlank(fields[21])) {
			// 职级
			vo.setGroupid("CH_JOBLEVEL");
			vo.setDictid(fields[21]);
			if (delegate.doFindByPk(vo) == null) {
				throw new Exception("非法职级，请参看说明");
			}
		}
		if (StringUtils.isNotBlank(fields[26])) {
			// 劳动关系
			vo.setGroupid("CH_CONTACTTYPE");
			vo.setDictid(fields[26]);
			if (delegate.doFindByPk(vo) == null) {
				throw new Exception("非法劳动关系，请参看说明");
			}
		}
		if (StringUtils.isNotBlank(fields[27])) {
			// 用工性质
			vo.setGroupid("CH_EMPLOYTYPE");
			vo.setDictid(fields[27]);
			if (delegate.doFindByPk(vo) == null) {
				throw new Exception("非法用工性质，请参看说明");
			}
		}
		if (StringUtils.isNotBlank(fields[28])) {
			// 用工状态
			vo.setGroupid("CH_EMPSTATUS");
			vo.setDictid(fields[28]);
			if (delegate.doFindByPk(vo) == null) {
				throw new Exception("非法用工状态，请参看说明");
			}
		}
		if (StringUtils.isNotBlank(fields[31])) {
			// 婚姻状态
			vo.setGroupid("CH_ISMARRIED");
			vo.setDictid(fields[31]);
			if (delegate.doFindByPk(vo) == null) {
				throw new Exception("非法婚姻状态，请参看说明");
			}
		}
		// 身份证号码
		if (fields[7].length() != 15 && fields[7].length() != 18) {			
			throw new Exception("身份证号码长度必须为15或18位");
		}
		// 个人电子邮箱
		if (!isVaildEmail(fields[9])) {
			throw new Exception("个人电子邮箱格式不对，请重写。");
		}
	}

	private boolean isEmpty(String checkStr) throws Exception {
	if (checkStr != null) {
		return StringUtils.isBlank(checkStr);
	} else {
		throw new Exception("检查字符串为空!");
	}
	}
	
	public static boolean isVaildEmail(String email){ 
	     String emailPattern="[_a-zA-Z\\d\\-\\.]+@[_a-zA-Z\\d\\-]+(\\.[_a-zA-Z\\d\\-]+)+"; 
	     boolean result=Pattern.matches(emailPattern, email); 
	     return result; 
	}
}
