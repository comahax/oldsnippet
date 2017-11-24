package com.gmcc.pboss.web.sales.comdisscale;


import java.io.File;
import java.util.HashMap;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.ui.User;

public class ComdisscaleCheck extends BaseCheckFormat {
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		//分公司|微区域|星级|套卡品牌|销量阀值
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 7) {
			throw new Exception("上传数据列数不对,应为6列,请查看说明帮助!");
		}
		if (StringUtils.isEmpty(content[0])) {
			throw new Exception("分公司不能为空");
		}
		if (StringUtils.isEmpty(content[1])) {
			throw new Exception("微区域不能为空");
		}
		if (StringUtils.isEmpty(content[2])) {
			throw new Exception("星级不能为空");
		}
		try{
			Integer.parseInt(content[2]);
		}catch(Exception e){
			throw new Exception("星级只能是数字");
		}
		if (StringUtils.isEmpty(content[3])) {
			throw new Exception("套卡品牌不能为空");
		}
		if (StringUtils.isEmpty(content[4])) {
			throw new Exception("商品种类不能为空");
		}
		if (StringUtils.isEmpty(content[5])) {
			throw new Exception("分配比例不能为空");
		}
	}
}
