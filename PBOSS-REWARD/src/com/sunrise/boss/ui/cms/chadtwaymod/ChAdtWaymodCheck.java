package com.sunrise.boss.ui.cms.chadtwaymod;

import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;
import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class ChAdtWaymodCheck extends BaseCheckFormat {

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("", "要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	@Override
	public void checkLine(String line, int rowCount, User user) throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");

		if (content.length != 7) {
			throw new Exception("上传数据列数不对,应为6列,请查看说明帮助!");
		}
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","渠道编码不能为空");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","[VI形象]不能为空");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","[面积]不能为空");
		}
		if(StringUtils.isEmpty(content[3])){
			throw new BusinessException("","[门头广告（宣传）]不能为空");
		}
		if(StringUtils.isEmpty(content[4])){
			throw new BusinessException("","[手机背板（宣传）]不能为空");
		}
		if(StringUtils.isEmpty(content[5])){
			throw new BusinessException("","[基础宣传类（宣传）]不能为空");
		}

		for (int i = 0; i < content.length - 1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 18, true)) {
					throw new Exception("[渠道编码]不能大于18位");
				}
				break;
			case 1:
				if (!CheckUtil.checkDouble(content[i], 3, 2)) {
					throw new Exception("[VI形象]整数部分不能超过3位,小数部分不能超过2位");
				}
				break;
			case 2:
				if (!CheckUtil.checkDouble(content[i], 3, 2)) {
					throw new Exception("[面积]整数部分不能超过3位,小数部分不能超过2位");
				}
				break;
			case 3:
				if (!CheckUtil.checkDouble(content[i], 3, 2)) {
					throw new Exception("[门头广告（宣传）]整数部分不能超过3位,小数部分不能超过2位");
				}
				break;
			case 4:
				if (!CheckUtil.checkDouble(content[i], 3, 2)) {
					throw new Exception("[手机背板（宣传）]整数部分不能超过3位,小数部分不能超过2位");
				}
				break;
			case 5:
				if (!CheckUtil.checkDouble(content[i], 3, 2)) {
					throw new Exception("[基础宣传类（宣传）]整数部分不能超过3位,小数部分不能超过2位");
				}
				break;
			}
		}
	}

}
