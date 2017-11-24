package com.sunrise.boss.web.common.batch.upload;

import org.apache.commons.lang.StringUtils;

/**
 * ����StringUtils.split()��"||||"������²�����ȷ����,�����Ϊ�յ��ֶ��ÿո����
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
