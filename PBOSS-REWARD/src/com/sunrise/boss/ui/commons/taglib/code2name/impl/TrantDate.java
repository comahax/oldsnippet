package com.sunrise.boss.ui.commons.taglib.code2name.impl;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2name;

/**
 * ��Դ̨�ʷ�����̨�ʲ�ѯ�õ�
 * ������ʽ������
 * @author Zeng Wenqu
 *
 */
public class TrantDate implements Code2name{
	public String translate(Object code, User user) throws Exception {
		String datetime = code.toString();////2007-03-11 19:26:34.0
		String dealtime = datetime.substring(0,10);
		String[] datearr = dealtime.split("-");
		String result_str = datearr[0]+"��"+datearr[1]+"��"+datearr[2]+"��";
		return result_str;
	}
}
