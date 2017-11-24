package com.sunrise.boss.ui.commons.taglib.code2name.impl;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2name;

/**
 * 资源台帐服务厅台帐查询用到
 * 用来格式化日期
 * @author Zeng Wenqu
 *
 */
public class TrantDate implements Code2name{
	public String translate(Object code, User user) throws Exception {
		String datetime = code.toString();////2007-03-11 19:26:34.0
		String dealtime = datetime.substring(0,10);
		String[] datearr = dealtime.split("-");
		String result_str = datearr[0]+"年"+datearr[1]+"月"+datearr[2]+"日";
		return result_str;
	}
}
