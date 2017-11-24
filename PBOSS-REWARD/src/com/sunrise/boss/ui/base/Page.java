package com.sunrise.boss.ui.base;

import javax.servlet.http.HttpServletRequest;

import com.sunrise.boss.ui.commons.WebConstant;

public class Page {
	private Page() {
		super();
	}

	/**
	 * 设置分页条件
	 * @param request HttpServletRequest
	 * @param listForm BaseListForm
	 */
	static public void setPageSize(HttpServletRequest request,
			BaseActionForm listForm) {
		if (listForm.get_pageno() != null
				&& listForm.get_pageno().trim().length() != 0) {
			;
		} else {
			listForm.set_pageno(WebConstant.DEFAULT_PAGE);
		}
		if (listForm.get_pagesize() != null
				&& listForm.get_pagesize().trim().length() != 0) {
			;
		} else {
			if (request.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_LINES) == null) {
				listForm.set_pagesize(WebConstant.DEFAULT_LINES_PER_PAGE);
			} else {
				listForm.set_pagesize((String) request.getSession()
						.getAttribute(WebConstant.SESSION_ATTRIBUTE_LINES));
			}
		}
	}
}
