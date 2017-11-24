package com.gmcc.pboss.web.sales.ordercreate;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class CreateCheck extends BaseCheckFormat{

	@Override
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		// TODO Auto-generated method stub
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	@Override
	public void checkLine(String line, int rowCount ,User user) throws Exception {
		// TODO Auto-generated method stub
//		订单编号要求字符类型，最大长度18位。检查通过则进入下一步，不通过则提示出错文件行和错误描述，终止文件上传。
		String item[] = StringUtils.splitPreserveAllTokens(line,"|");
		if(item.length != 3)
			throw new Exception("上传数据列数不对,应为2列,请查看说明帮助!");
		
		for (int i = 0; i < item.length; i++) {
			
			switch (i) {
			// 渠道编码
			case 0:
				if ("".equals(item[i].trim())) {
					throw new Exception("[合作商编码]不能为空");
				}
				break;
			
			case 1:
				if ("".equals(item[i].trim())) {
					throw new Exception("[地市资源代码和订购数量]不能为空");
				}
				break;
			}
		}
		
	}
	
}
