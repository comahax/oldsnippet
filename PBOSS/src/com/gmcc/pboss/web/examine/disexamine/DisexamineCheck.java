package com.gmcc.pboss.web.examine.disexamine;

import java.io.File;
import java.util.HashMap; 
import org.apache.commons.lang.StringUtils;  
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;  
import com.sunrise.jop.ui.User;

public class DisexamineCheck extends BaseCheckFormat {

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {

		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 4) {
			throw new Exception("第" + rowCount + "行:[ " + line
					+ " ] ,列数不正确,正确列数为4");
		}
		if (StringUtils.isEmpty(content[0])) {
			throw new Exception("第" + rowCount + "行:[ " + line + " ] ,配送商不能为空");
		}
		if (StringUtils.isEmpty(content[1])) {
			throw new Exception("第" + rowCount + "行:[ " + line + " ] ,考核周期不能为空");
		}
		if (StringUtils.isEmpty(content[2])) {
			throw new Exception("第" + rowCount + "行:[ " + line + " ] ,扣罚金额不能为空");
		}
		if (StringUtils.isEmpty(content[3])) {
			throw new Exception("第" + rowCount + "行:[ " + line + " ] ,原因不能为空");
		}  
		checkParameter(content, user);

	}

	 /* 
	  * 1)	文件格式检查
              配送商要求字符类型，最大长度18位；考核周期要求格式为yyyyMM，最大长度6位。扣罚金额为数值类型，最大最16位。配送商、考核周期、扣罚金额和说明都不为空。
              检查通过则进入下一步，不通过则提示出错文件行和错误描述，终止文件上传。
         2)	文件处理
              配送商信息检查：根据配送商查询渠道表（CH_PW_WAY），如果无数据则填写出错原因“配送商不存在”，返回处理下一条记录；否则继续下一步。
              考核周期检查：考核周期要求为本月，如果不是本月则填写出错原因“考核周期不为本月”，返回处理吓一跳记录；否则继续下一步。 
	  */
	private void checkParameter(String[] fields, User user) throws Exception {
 
		//配送商
		if (StringUtils.isNotBlank(fields[0])) { 
			if (fields[0].trim().length() >18 ) {
				throw new Exception("配送商要求字符类型，最大长度18位");
			} 
			/*
			 Way wayBO = (Way)BOFactory.build(WayBO.class,user);
			 WayVO wayVO = wayBO.doFindByPk(fields[0]);
			 if (("").equals(wayVO) && null==wayVO ) {
				 throw new Exception("配送商不存在");
			 }
			*/
		} 
		//考核周期
		if (StringUtils.isNotBlank(fields[1])) {  
		     	if (fields[1].trim().length() !=6 ) {
				     throw new Exception("考核周期要求格式为yyyyMM，最大长度6位");
			      }
		}
		//扣罚金额
		if (StringUtils.isNotBlank(fields[2])) { 
			if (fields[2].length()>16 || Double.parseDouble(fields[2])<0 ) {
				throw new Exception("扣罚金额为数值类型，最大最16位");
			}
		} 
	}

	private boolean isEmpty(String checkStr) throws Exception {
		if (checkStr != null) {
			return StringUtils.isBlank(checkStr);
		} else {
			throw new Exception("检查字符串为空!");
		}
	}

}
