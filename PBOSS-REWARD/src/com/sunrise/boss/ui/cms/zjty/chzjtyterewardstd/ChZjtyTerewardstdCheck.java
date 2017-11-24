package com.sunrise.boss.ui.cms.zjty.chzjtyterewardstd;

import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;
import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.business.cms.zjty.chzjtyterewardstd.persistent.ChZjtyTerewardstdVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.zjty.chzjtyterewardstd.ChZjtyTerewardstdDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class ChZjtyTerewardstdCheck extends BaseCheckFormat {
	private String region;

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		region = parameterMap.get("_region").toString();
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("", "要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user) throws Exception {
		if (null == line || "".equals(line)) {
			return;
		} 
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 7) {
			throw new Exception("上传数据列数不对,应为6列,请查看说明帮助!");
		} 
		if (StringUtils.isEmpty(content[0]) || content[0].getBytes("GBK").length > 18) {
			throw new Exception("[终端机型]不能为空，并且长度最大为18");
		}
		if ( StringUtils.isEmpty((content[1])) || !CheckUtil.checkDoubleNum((content[1]))) {
			throw new Exception("[基准价]不能为空,并且只能大于等于0");
		}    
		if (StringUtils.isEmpty(content[2])) {
			throw new Exception("[酬金标准]不能为空，并且必需为数字");
		} else if (!CheckUtil.checkDouble(content[1], 16, 4)) {
			throw new Exception("[酬金标准]必需为数字，并且整数部分不能超过12位,小数部分不能超过4位");
		}
		if (StringUtils.isEmpty(content[3])) {
			throw new Exception("[酬金类型]不能为空，并且必需为整数");
		} else if (!content[3].trim().matches("(1|2|3|4|5|6|11|12|13|14)")) {
			throw new Exception("[酬金类型]必需为整数,应该为1、2、3、4、5、6、11、12、13|14中的一个数值");
		}
		if (StringUtils.isEmpty(content[4])) {
			throw new Exception("[计酬类型]不能为空，并且必需为整数");
		} else if (!content[4].trim().matches("[1-2]")) {
			throw new Exception("[计酬类型]必需为整数,且长度不能大于3");
		}
		if (StringUtils.isNotEmpty(content[5]) && content[5].getBytes("GBK").length > 128) {
			throw new Exception("[备注]长度最大为128");
		}
		
		ChZjtyTerewardstdVO newVo = new ChZjtyTerewardstdVO();
		newVo.setComid(content[0].trim());
		newVo.setRewardtype(Short.parseShort(content[3].trim()));
		if (region.equals("999")) {
			newVo.setCitycode(Short.parseShort("999"));
		} else {
			newVo.setCitycode(Short.parseShort(user.getCityid()));
		}
		ChZjtyTerewardstdDelegate delegate = new ChZjtyTerewardstdDelegate();
		ChZjtyTerewardstdVO vo = delegate.doFindByPk(newVo, user);
		if (vo != null) {
			throw new Exception("同个终端机型、同个酬金类型已存在相同记录!");
		}
	}

}
