package com.sunrise.boss.ui.cms.bbc.mmopn;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchMmopnCheck extends BaseCheckFormat {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public BatchMmopnCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new BusinessException("",
					"要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (rowCount > 10000) {
			throw new Exception("文件行数不能超过10000行");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");

		// 检查列数
		if (items.length != 13) {
			throw new Exception("上传数据列数不对,应为12列,请查看说明帮助!");
		}
		if (!CheckUtil.checkString(items[0], 18, false)) {
			throw new Exception("[业务编码]长度不能超过18位且不能为空");
		}
		if (!CheckUtil.checkString(items[1], 22, false)) {
			throw new Exception("[业务名称]长度不能超过22位且不能为空");
		}
		if (!CheckUtil.checkString(items[2], 6, false)) {
			throw new Exception("[企业代码]长度不能超过6位且不能为空");
		}
		if (!CheckUtil.checkString(items[3], 10, false)) {
			throw new Exception("[计费业务代码]长度不能超过10位且不能为空");
		}
		if (!CheckUtil.checkNum(items[4], 3, false)) {
			throw new Exception("[计酬方式]长度不能超过3位必须为数字且不能为空");
		}
		if(!CheckUtil.getInstance().checkDictitem("CH_ACCTYPE", items[4].trim(), user))
		{
			throw new Exception("固定参数[计酬方式]的值不正确");
		}
		if (!CheckUtil.checkDouble(items[5], 10, 4)) {
			throw new Exception("[酬金标准]整数部分不能超过10位,小数部分不能超过4位,且不能为空");
		}
		if("2".equals(items[4].trim()))
		{
			double rewardstd=new Double(items[5].trim()).doubleValue();
			if(rewardstd<=0 || rewardstd>1)
			{
				throw new Exception("[计酬方式]为按比例计算时,[酬金标准]必须在0与1之间");
			}
		}
		if (!CheckUtil.checkNum(items[6], 1, false)) {
			throw new Exception("[生效状态]长度不能超过1位,必须为数字且不能为空");
		}
		if(!"0".equals(items[6].trim()) && !"1".equals(items[6].trim()))
		{
			throw new Exception("固定参数[生效状态]的值不正确");
		}
		if (!CheckUtil.checkNum(items[7], 2, true)) {
			throw new Exception("[加载平台]长度不能超过2位且必须是数字");
		}
		if(!CheckUtil.getInstance().checkDictitem("CH_MMOSSRC", items[7].trim(), user))
		{
			throw new Exception("固定参数[加载平台]的值不正确");
		}
		if (!CheckUtil.checkString(items[8], 12, false)) {
			throw new Exception("[简码]长度不能超过12位且不能为空");
		}
		if (!CheckUtil.checkString(items[9], 128, true)) {
			throw new Exception("[WAP应用URL]长度不能超过128位");
		}
		if (!CheckUtil.checkString(items[10], 512, true)) {
			throw new Exception("[业务简介]长度不能超过512位");
		}
		if (!CheckUtil.checkString(items[11], 256, true)) {
			throw new Exception("[业务资费]长度不能超过256位");
		}
	}
}
