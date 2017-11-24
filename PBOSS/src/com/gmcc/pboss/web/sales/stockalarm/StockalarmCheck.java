package com.gmcc.pboss.web.sales.stockalarm;

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

public class StockalarmCheck extends BaseCheckFormat {

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 7) {
			throw new Exception("上传数据列数不对,应为6列,请查看说明帮助!");
		}
		if (StringUtils.isEmpty(content[0])) {
			throw new Exception("合作商编码不能为空");
		}
		if (StringUtils.isEmpty(content[1])) {
			throw new Exception("套卡品牌不能为空");
		}
		if (StringUtils.isEmpty(content[2])) {
			throw new Exception("最高库存不能为空");
		}
		if (StringUtils.isEmpty(content[3])) {
			throw new Exception("红色预警不能为空");
		}
		if (StringUtils.isEmpty(content[4])) {
			throw new Exception("黄色预警不能为空");
		}
		if (StringUtils.isEmpty(content[5])) {
			throw new Exception("更新途径不能为空");
		}
	}
}