package com.sunrise.boss.ui.resmanage.comrescard.batchintask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.resmanage.common.ResUploadFileAction;

public class ImportComrescardTaskAction extends ResUploadFileAction {

	protected void setFilecode(HashMap map, User user) {
		this.filecode = "COMRESCARD_1_0";
	}

	protected List getParamList(HashMap map, User user) throws Exception {

		List list = new ArrayList();
		addParam(list, "comid", (String) map.get("comid"));
		addParam(list, "comactive", (String) map.get("comactive"));
		addParam(list, "comstate", (String) map.get("comstate"));
		addParam(list, "wayid", (String) map.get("wayid"));
		
		// 前台输入价格以元为单位，转换为分传递给后台程序
		String price = (String) map.get("price");
		if (StringUtils.isNotBlank(price)) {
			price  = String.valueOf((long)(Double.parseDouble(price)*100));	
		}
		addParam(list, "price", price);
		
		// 前台输入折后价格以元为单位，转换为分传递给后台程序
		String comdisc = (String) map.get("comdisc");
		if (StringUtils.isNotBlank(comdisc)) {
			comdisc  = String.valueOf((long)(Double.parseDouble(comdisc)*100));
		}
		addParam(list, "comdisc", comdisc);
		
		addParam(list, "source", (String) map.get("source"));
		addParam(list, "starttime", (String) map.get("starttime"));
		addParam(list, "validperiod", (String) map.get("validperiod"));
		addParam(list, "comkeep", (String) map.get("comkeep"));

		return list;
	}
}
