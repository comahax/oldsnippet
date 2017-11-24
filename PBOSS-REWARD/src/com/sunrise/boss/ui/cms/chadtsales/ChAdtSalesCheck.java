package com.sunrise.boss.ui.cms.chadtsales;

import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;
import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class ChAdtSalesCheck extends BaseCheckFormat {

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("", "要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	@Override
	public void checkLine(String line, int rowCount, User user) throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");

		if (content.length != 5) {
			throw new Exception("上传数据列数不对,应为4列,请查看说明帮助!");
		}
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","[业务编码]不能为空");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","[连锁加盟渠道属性]不能为空");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","[销量]不能为空");
		}
		if(StringUtils.isEmpty(content[3])){
			throw new BusinessException("","[酬金标准]不能为空");
		}


		for (int i = 0; i < content.length - 1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 18, true)) {
					throw new Exception("[业务编码]不能大于18位");
				}
				break;
			case 1:
				if (!CheckUtil.checkString(content[i], 2, true)) {
					throw new Exception("[连锁加盟渠道属性]不能大于2位");
				}
				break;
			case 2:
				if (!CheckUtil.checkNum(content[i], 10)) {
					throw new Exception("[销量]应为整数且小于11位");
				}
				break;
			case 3:
				if (!CheckUtil.checkDouble(content[i], 16, 4)) {
					throw new Exception("[酬金标准]整数部分不能超过16位,小数部分不能超过4位");
				}
				break;
			}
		}
	}

}
