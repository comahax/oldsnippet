package com.sunrise.boss.ui.cms.reward.citydata;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchCitydataCheck extends BaseCheckFormat {

	private User user;

	public BatchCitydataCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		user = (User) parameterMap.get("user");
		String fileName = file.getFileName();
		if (!fileName.substring(fileName.length() - 4).equalsIgnoreCase(".txt")) {
			// if (!file.getContentType().equals("text/plain"))
			// {System.out.println("file.getContentType()="+file.getContentType());
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	/**
	 * 发生业务编码|业务发生渠道|业务发生时间|业务发生BOSS工号|业务发生号码|号码发生业务量|品牌|酬金类型
	 */
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
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

		if (fields[0].trim().equals("") || fields[0].trim().length() > 18) {
			throw new Exception("[发生业务编码]不能为空或大于18位");
		}

		if (fields[7].trim().equals("") || !fields[7].matches("[0-8]{1}")) {
			throw new Exception("[酬金类型]要求为0-8之间一位数字，且不能为空");
		}
		if ("5".equals(fields[7]) || "6".equals(fields[7])) {
			if (fields[3].length() > 15 || fields[3].trim().equals("")) {
				throw new Exception(
						"“酬金类型”是BOSS授权类（全球通）业务酬金（基本酬金、奖励酬金），必须录入“业务发生BOSS工号”，且长度不大于15位");
			}
		}
		if (fields[1].trim().equals("") || fields[1].trim().length() > 18) {
			throw new Exception("[业务发生渠道]不能为空或大于18位");
		}
		try {
			date.parse(fields[2]);
		} catch (ParseException pe) {
			throw new Exception("[业务发生时间]格式不对,应为yyyyMMdd");
		}
		if (fields[4].trim().equals("") || fields[4].trim().length() > 11
				|| !StringUtils.isNumeric(fields[4])) {
			throw new Exception("[业务发生号码]不能为空或大于11位，并且必须是数字串");
		}
//		if (fields[5].trim().equals("")
//				|| !fields[5].matches("[0-9]{1,14}(.?)[0-9]{0,2}")) {
//			throw new Exception("[号码发生业务量]不能为空或大于14位");
//		}
		if (fields[5].trim().length() == 0) {
			throw new Exception("[号码发生业务量]不能为空");
		}
		try{
			NumberFormat f = new DecimalFormat("0.00");
			String s = f.format(new Double(fields[5].trim()));
			if (s.length() > 15) {
				throw new Exception("[号码发生业务量]格式检查不通过，要求为数字类型且整数位不能大于12位。");
			}
		} catch (Exception ex) {
			throw new Exception("[号码发生业务量]格式检查不通过，要求为数字类型且整数位不能大于12位。");
		}
		if (fields[6].trim().equals("") || fields[6].trim().length() > 1
				|| !StringUtils.isNumeric(fields[6])) {
			throw new Exception("[品牌]不能为空或大于1位");
		}
	}
}
