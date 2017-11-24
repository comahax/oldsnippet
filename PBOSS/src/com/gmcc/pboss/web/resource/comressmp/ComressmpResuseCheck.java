package com.gmcc.pboss.web.resource.comressmp;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.ui.User;

public class ComressmpResuseCheck extends BaseCheckFormat {
public void checkFile(File file, HashMap parameterMap, String contentType)
	throws Exception {
	if (!"text/plain".equalsIgnoreCase(contentType)) {
		throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
	}
	if(parameterMap.get("resuse")==null || "".equals(parameterMap.get("resuse")))
		throw new Exception("请选择要更新的资源用途!");
}

public void checkLine(String line, int rowCount, User user)
	throws Exception {
// TODO Auto-generated method stub
String[] content = StringUtils.splitPreserveAllTokens(line, "|");
if (content.length !=3) {
	throw new Exception("上传的数据格式不正确,请查看补充说明!");
}
if(content[0].length()>30)
	throw new Exception("商品批次不能超过30位,请查看补充说明!");
if (content[1].length()> 30 )
	throw new Exception("包号最大长度为30位,请查看补充说明!");
}

private boolean isEmpty(String checkStr) throws Exception {
if (checkStr != null) {
	return StringUtils.isBlank(checkStr);
} else {
	throw new Exception("检查字符串为空!");
}
}
}
