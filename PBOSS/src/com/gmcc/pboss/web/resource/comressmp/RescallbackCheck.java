package com.gmcc.pboss.web.resource.comressmp;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.ui.User;

public class RescallbackCheck extends BaseCheckFormat {

	String flag = "";
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
		flag = parameterMap.get("callbacktype").toString();
		if ( flag == null
				|| "".equals(flag))
			throw new Exception("请选择要回收的资源类别!");
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		// TODO Auto-generated method stub
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 3) {
			throw new Exception("上传的数据格式不正确,请查看补充说明!");
		}
		if(flag.equals("EMPTYSIM")){
			 if (content[0].length() > 21)
					throw new Exception("空白卡序列号不能超过21位,请查看补充说明!");
		}else{	
		 if (content[0].length() > 32)
			throw new Exception("商品资源编号不能超过32位,请查看补充说明!");
		}
		if (content[1].length() > 18)
			throw new Exception("商品标识最大长度为18位,请查看补充说明!");
	}

	private boolean isEmpty(String checkStr) throws Exception {
		if (checkStr != null) {
			return StringUtils.isBlank(checkStr);
		} else {
			throw new Exception("检查字符串为空!");
		}
	}

}
