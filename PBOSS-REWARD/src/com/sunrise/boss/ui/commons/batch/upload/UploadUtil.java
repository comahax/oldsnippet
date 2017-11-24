package com.sunrise.boss.ui.commons.batch.upload;

import org.apache.commons.lang.StringUtils;

/**
 * 修正StringUtils.split()在"||||"的情况下不能正确分列,处理后为空的字段用空格代替
 * @author liwenjing
 *
 */
public class UploadUtil {
	public static String[] splitLine(String line) {
		String[] items = null;
		if (null != line || !"".equals(line)) {
			StringBuffer sb = new StringBuffer(line);
			while (!(StringUtils.countMatches(sb.toString(), "||") == 0)) {
				int index = sb.indexOf("||");
				if (index != -1)
					sb.insert(index + 1, " ");
			}
			items = StringUtils.split(sb.toString(), "|");
		}
		return items;
	}
}
