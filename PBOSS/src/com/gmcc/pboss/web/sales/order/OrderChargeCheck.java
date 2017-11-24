package com.gmcc.pboss.web.sales.order;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class OrderChargeCheck extends BaseCheckFormat{

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
		String item[] = StringUtils.split(line,"|");
		if(item.length>3)
			throw new Exception("第"+rowCount+"行:[ "+line+ " ] , 列数不对,应为2列,请查看说明帮助!");
		if(!line.endsWith("|"))
			throw new Exception("第"+rowCount+"行:[ "+line+ " ] , 必须以 | 结束,请查看说明帮助!");
		if (item[0].length() > 18) {
			throw new Exception("第"+rowCount+"行:[ "+line+ " ] , 订单编号要求字符类型，最大长度18位");
		}
		if (item.length!=1){
			if(!StringUtils.isEmpty(item[1])){
				if(item[1].length() > 20){
					throw new Exception("POS流水号最大长度为20位!");
				}
			}
		}
	}
}
