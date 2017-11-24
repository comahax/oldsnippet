package com.sunrise.boss.ui.cms.reward.chadtwayspecialreward;

import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class ChAdtWayspecialrewardCheck extends BaseCheckFormat {

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("", "要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (null == line || "".equals(line)) {
			return;
		}
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 3) {
			throw new Exception("上传数据列数不对,应为2列");
		}
		if (StringUtils.isBlank(content[0])) {
			throw new Exception("[渠道编码]不能为空");
		}
		if (StringUtils.isBlank(content[1])) {
			throw new Exception("[渠道类型]不能为空");
		}
		
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 18, true)) {
					throw new Exception("[渠道编码]不能大于18位");
				}
				break;
			case 1:
				if (!CheckUtil.checkString(content[i], 8, true)) {
					throw new Exception("[渠道编码]不能大于8位");
				}
				break;
			
			}
		}
		
	}

}
