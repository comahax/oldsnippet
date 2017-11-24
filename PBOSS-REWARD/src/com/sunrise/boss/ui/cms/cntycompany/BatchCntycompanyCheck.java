package com.sunrise.boss.ui.cms.cntycompany;

import java.util.HashMap;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.delegate.cms.cntycompany.CntycompanyDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;

public class BatchCntycompanyCheck extends BaseCheckFormat {
	public BatchCntycompanyCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
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
		// String[] items = line.split("\\|");
		String[] items = StringSplit.split(line, "|");
		// 检查列数
		if (items.length != 9) {
			throw new Exception("上传数据列数不对,应为9列,请查看说明帮助!");
		}
		CntycompanyDelegate delegate = new CntycompanyDelegate();
		if (items[0] == null || "".equals(items[0].trim())
				|| items[0].length() > 14)
			throw new Exception("[县公司标识]不能为空，也不能大于14位！");
		if (delegate.doFindByPk(items[0], user) == null) {// 新增
			if (items[1].length() > 14)
				throw new Exception("[市公司标识]过长！必须不大于14位");
			if (items[2].length() > 64)
				throw new Exception("[县公司名称]过长！必须不大于64位");
			try { // 检查items[3]是否为数字
				Double temp = Double.valueOf(items[3]);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("[县公司类型]类型不对(" + items[3] + "),应该是数字字符串!");
			}
			if (items[3].getBytes().length > 3)
				throw new Exception("[县公司类型]过长！必须不大于3位");
			if (items[4].length() > 64)
				throw new Exception("[法人代表]过长！必须不大于64位");

			if (items[5].length() > 5)
				throw new Exception("[计费用行政区代码]过长！必须不大于5位");
			if (items[6].length() > 18)
				throw new Exception("[行政区划编码]过长！必须不大于18位");
			if (items[7].length() > 15)
				throw new Exception("[办公地点经度]过长！必须不大于15位");
			if (items[8].length() > 15)
				throw new Exception("[办公地点纬度]过长！必须不大于15位");
		} else {
			if (!"null".equals(items[1]) && !"空".equals(items[1])
					&& !"".equals(items[1].trim())) {
				if (items[1].length() > 14)
					throw new Exception("[市公司标识]过长！必须不大于14位");
			}
			if (!"null".equals(items[2]) && !"空".equals(items[2])
					&& !"".equals(items[2].trim())) {
				if (items[2].length() > 64)
					throw new Exception("[县公司名称]过长！必须不大于64位");
			}
			if (!"null".equals(items[3]) && !"空".equals(items[3])
					&& !"".equals(items[3].trim())) {
				try { // 检查items[3]是否为数字
					Double temp = Double.valueOf(items[3]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[县公司类型]类型不对(" + items[3]
							+ "),应该是数字字符串!");
				}
				if (items[3].getBytes().length > 3)
					throw new Exception("[县公司类型]过长！必须不大于3位");
			}
			if (!"null".equals(items[4]) && !"空".equals(items[4])
					&& !"".equals(items[4].trim())) {
				if (items[4].length() > 64)
					throw new Exception("[法人代表]过长！必须不大于64位");
			}
			if (!"null".equals(items[5]) && !"空".equals(items[5])
					&& !"".equals(items[5].trim())) {
				if (items[5].length() > 5)
					throw new Exception("[计费用行政区代码]过长！必须不大于5位");
			}
			if (!"null".equals(items[6]) && !"空".equals(items[6])
					&& !"".equals(items[6].trim())) {
				if (items[6].length() > 18)
					throw new Exception("[行政区划编码]过长！必须不大于18位");
			}
			if (!"null".equals(items[7]) && !"空".equals(items[7])
					&& !"".equals(items[7].trim())) {
				if (Double.parseDouble(items[7]) > 130 || Double.parseDouble(items[7]) <100 || !items[7].matches("[0-9]{3}(.?)[0-9]{6}"))
					throw new Exception("[办公地点经度]精确到小数后6位,经度值在100 － 130 之间");
			}
			if (!"null".equals(items[8]) && !"空".equals(items[8])
					&& !"".equals(items[8].trim())) {
				if (Double.parseDouble(items[8]) > 26||Double.parseDouble(items[8]) <18 ||!items[8].matches("[0-9]{2}(.?)[0-9]{6}"))
					throw new Exception("[办公地点纬度]精确到小数后6位,纬度值在18 － 26 之间");
			}
		}
	}
}
