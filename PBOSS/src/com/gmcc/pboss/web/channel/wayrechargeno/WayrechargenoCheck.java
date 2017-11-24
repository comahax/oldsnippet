package com.gmcc.pboss.web.channel.wayrechargeno;

import java.io.File;
import java.util.HashMap;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class WayrechargenoCheck extends BaseCheckFormat {

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
//		有两个split的方法
//		String[] fields = StringUtils.splitPreserveAllTokens(line, "|");
//		String[] content = StringUtils.split(line, "|");
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != (2+1)) {
			throw new Exception("上传数据列数不对,应为2列,请查看说明帮助!");
		}
		if (StringUtils.isEmpty(content[0])) {
			throw new Exception("渠道编码不能为空");
		}
		if (StringUtils.isEmpty(content[1])) {
			throw new Exception("空中充值号码不能为空");
		}
		if (content[1].trim().length()!=11) {
			throw new Exception("空中充值号码必须为11位");
		}
		
		
	}
}