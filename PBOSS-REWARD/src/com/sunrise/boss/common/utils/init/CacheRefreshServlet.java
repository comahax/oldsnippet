package com.sunrise.boss.common.utils.init;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.common.utils.CacheUtil;
import com.sunrise.boss.ui.commons.WebConstant;


public class CacheRefreshServlet extends HttpServlet {
	private static final Log log = LogFactory.getLog(CacheRefreshServlet.class);

	public void doGet(HttpServletRequest request, HttpServletResponse respone)
			throws ServletException, IOException {
		service(request, respone);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse respone)
			throws ServletException, IOException {
		service(request, respone);
	}

	/***************************************************************************
	 * if cacahename=dict refresh Dict Cache if cacahename=purview refresh
	 * Purview Data Cache
	 */
	public void service(HttpServletRequest request, HttpServletResponse respone)
			throws ServletException, IOException {
		try {
			// WebConstant.CACHE_SELECT_PARAMETER_NAME=cacahename
			String flag = request.getParameter(WebConstant.CACHE_SELECT_PARAMETER_NAME);
			CacheUtil cUtil = new CacheUtil();
			
			PrintWriter out = respone.getWriter();
			
			if (flag.equalsIgnoreCase("dict")) {
				cUtil.refreshDictCache();
			}
			else if (flag.equalsIgnoreCase("purview")) {
				cUtil.refershPurviewData(); // 暂时没有用
			}
			out.println("Cache Refresh Success on:" + new Date());
		} catch (Exception ne) {
			log.error(ne);
		}
	}

}