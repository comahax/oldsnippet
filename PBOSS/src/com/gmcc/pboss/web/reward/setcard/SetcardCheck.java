package com.gmcc.pboss.web.reward.setcard;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CityId;
import com.sunrise.jop.ui.User;

public class SetcardCheck extends BaseCheckFormat {
	private User user;

	@Override
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		user = (User) parameterMap.get("user");
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	@Override
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 7) {
			throw new Exception("上传列数不正确，应为6列!");
		}

		String wayid = content[0];
		if (StringUtils.isBlank(wayid)
				|| wayid.trim().getBytes("GBK").length > 30) {
			throw new Exception("渠道编码不能为空且长度不能大于30");
		}
		
		String sctvday = content[1];
		if (StringUtils.isBlank(sctvday)
				|| sctvday.trim().getBytes("GBK").length > 8) {
			throw new Exception("激活时间不能为空且长度不能大于8，格式为:yyyyMMdd");
		}
		
		String mobile = content[2];
		if (StringUtils.isBlank(mobile)
				|| mobile.trim().getBytes("GBK").length != 11) {
			throw new Exception("号码不能为空且长度为11位");
		}
		
		String cityid = content[3];
		if (StringUtils.isBlank(cityid)
				|| cityid.trim().getBytes("GBK").length > 2 ) {
			throw new Exception("地市不能为空且长度长度不能大于2，格式如：GZ");
		}
		
		if (!StringUtils.isBlank(cityid) 
				&& (CityId.getCityName(cityid)==null || CityId.getCityName(cityid)=="") ) {
			throw new Exception("地市格式不正确，应为大写拼音首字母，格式如：GZ");
		}
		
		String waytype = content[4];
		if (StringUtils.isBlank(waytype)
				|| waytype.trim().getBytes("GBK").length > 1) {
			throw new Exception("渠道类型不能为空且长度长度不能大于1，格式如：1(代表自有渠道)，2(代表社会渠道)");
		}
	}
}
