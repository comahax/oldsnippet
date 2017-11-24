package com.sunrise.boss.ui.cms.cardsalebusi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchCardsalebusiCheck extends BaseCheckFormat {

	private User user;

	public BatchCardsalebusiCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		user = (User) parameterMap.get("user");
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	/**
	 * 号码0|品牌1|建议零售价2|买断价格3|销售折扣4|激活时间5|渠道编码6|业务分类信息编码7
	 */
	public void checkLine(String line, int rowCount) throws Exception {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (rowCount > 10000) {
			throw new Exception("文件行数不能超过10000行");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		String[] fields = StringUtils.splitPreserveAllTokens(line, "|");
		// 检查列数
		if (fields.length != 8) {
			throw new Exception("上传数据列数不对,应为8列,请查看说明帮助!");
		}
		for (int i = 0; i < fields.length; i++) {
			switch (i) {
			case 0:
				if (fields[i].trim().equals("") || fields[i].trim().length() > 11 || !StringUtils.isNumeric(fields[0])) {
					throw new Exception("[号码]不能为空或者大于11位且必须是数字");
				}
				break;
			case 1:
				if (fields[i].trim().equals("")
						|| (!fields[i].matches("[0-9]")
						&& (new Integer(fields[i]).intValue() < 1 || new Integer(
								fields[i]).intValue() > 3))) {
					throw new Exception("[品牌]不能为空且必须是数字1 2 3");
				}
				break;
			case 2:
				if (!fields[i].trim().equals("")
						&& !fields[i].matches("[0-9]{1,16}(.?)[0-9]{0,2}")) {
					throw new Exception("[建议零售价]格式不对,正确为最多两位小数的16位数字之内且不能为空");
				}
				break;
			case 3:
				if (!fields[i].trim().equals("")
						&& !fields[i].matches("[0-9]{1,16}(.?)[0-9]{0,2}")) {
					throw new Exception("[买断价格]格式不对,正确为最多两位小数的16位数字之内且不能为空");
				}
				break;
			case 4:
				if (!fields[i].trim().equals("")
						&& !fields[i].matches("[0-9]{1,16}(.?)[0-9]{0,2}")) {
					throw new Exception("[销售折扣]格式不对,正确为最多两位小数的16位数字之内且不能为空");
				}
				break;
			case 5:
				try {
					date.parse(fields[i]);
				} catch (ParseException pe) {
					throw new Exception("[激活时间]格式不对,应为yyyy-MM-dd HH:mm:ss且不能为空");
				}
				break;
			case 6:
				if (fields[i].trim().equals("")
						|| fields[i].trim().length() > 18) {
					throw new Exception("[渠道编号]不能大于18位或者为空");
				}
				break;
			case 7:
				if (fields[i].trim().equals("")
						|| fields[i].trim().length() > 18) {
					throw new Exception("[业务分类信息编码]不能大于18位或者为空");
				}
				break;

			default:
				break;
			}
		}
	}
}
