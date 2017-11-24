package com.gmcc.pboss.web.reward.paydetail;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class PaydetailCheck extends BaseCheckFormat {

	private User user;

	@Override
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		user = (User) parameterMap.get("user");
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}
	
	@Override
	public void checkLine(String line, int rowCount, User user) throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 5) {
			throw new Exception("上传列数不正确，应为4列!");
		}

		String wayid = content[0].trim();
		Way way = (Way)BOFactory.build(WayBO.class, user);
		if (way.doFindByPk(wayid) == null) {
			throw new Exception("渠道编码须是BOSS渠道编码，请检查渠道编码是否正确!");
		}
		
		
		String opmonth = content[2].trim();
		boolean flag = DateUtil.chkIfYmFormat(opmonth);
		if (!flag) {
			throw new Exception("该业务月【" + opmonth + "】格式不对,应为yyyyMM");
			
		}
		
		String calcmonth = content[3].trim();
		flag = DateUtil.chkIfYmFormat(calcmonth);
		if (!flag) {
			throw new Exception("该结算月【" + calcmonth + "】格式不对,应为yyyyMM");
			
		}
		
	}

}
