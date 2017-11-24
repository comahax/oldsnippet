/**
 * auto-generated code
 * Sun Feb 03 10:40:37 CST 2008
 */
package com.sunrise.boss.ui.cms.reward.citydata;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.cms.reward.citydata.persistent.CitydataListVO;
import com.sunrise.boss.business.cms.reward.citydata.persistent.CitydataVO;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.cms.reward.citydata.CitydataDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: CitydataAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author Cai Jianhui
 * @version 1.0
 */
public class CitydataAction extends BaseDelegateAction {
	public CitydataAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(CitydataVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[1];
		pkNameArray[0] = "seq";
	}

	public ActionForward doCheck(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		int result = 0;
		try {
			CitydataDelegate delegate = new CitydataDelegate();
			CitydataListVO listVO = new CitydataListVO();
//			listVO.getQueryConditions().put("_se_calcmonth", getLastmonth());
//			listVO.getQueryConditions().put("_ne_state", "0");
			if (delegate.doQuery(listVO, user).getRowCount() > 0) {
				result = 1;
			}
		} catch (Exception e) {
			result = -1;
		}
		PrintWriter writer = response.getWriter();
		writer.write("<script>parent.upload(" + result + ");</script>");
		writer.close();
		return null;
	}
	
	private String getLastmonth() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
		calendar.set(Calendar.DATE, 1);
		return sdf.format(calendar.getTime()).substring(0, 6);
	}
}
