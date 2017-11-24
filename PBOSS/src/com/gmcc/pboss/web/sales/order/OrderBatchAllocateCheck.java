package com.gmcc.pboss.web.sales.order;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.sunrise.jop.ui.User;

public class OrderBatchAllocateCheck extends BaseCheckFormat{
	public OrderBatchAllocateCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 3) {
			throw new Exception("[ " + line+ " ] ,列数不正确,正确列数为2");
		} 
		if (!CheckUtil.checkString(content[0],18,false)) {
			throw new Exception( "订单编号要求字符类型，最长18位，且不能为空");
		}
		if (CheckUtil.isEmpty(content[1])){
			throw new Exception("商品种类及数量不能为空");
		}
	}  

}
