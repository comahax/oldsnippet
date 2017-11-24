package com.sunrise.boss.ui.commons.taglib;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>
 * Title: PageNavTag
 * </p>
 * <p>
 * Description: ��ҳ��ǩ������
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author WODEN
 * @version 1.0
 */
public class PageNavTag extends TagSupport {
	private String dpName;

	private static final String PAGE_NAV_JSP_PATH = "/commons/pageNav.jsp";

	private static final String TOTAL_PAGE_NAME = "totalPage";

	private static final String CURRENT_PAGE_NAME = "currentPage";

	public void setDpName(String dpName) {
		this.dpName = dpName;
	}

	public int doStartTag() throws JspTagException {

		try {
			DataPackage bean = (DataPackage) pageContext.getRequest()
					.getAttribute(dpName);
			
			if (null == bean)
				return SKIP_BODY;

			int currentPage = bean.getPageNo();
			int totalPage = (int) Math.ceil(((double) bean.getRowCount())
					/ ((double) bean.getPageSize()));

			pageContext.getRequest().setAttribute(TOTAL_PAGE_NAME,
					new Integer(totalPage));
			pageContext.getRequest().setAttribute(CURRENT_PAGE_NAME,
					new Integer(currentPage));
			pageContext.include(PAGE_NAV_JSP_PATH);
		} catch (Exception ex) {
			// �粶���쳣,����ʾ��ҳ��Ϣ,���ᵼ���κ��ƻ��Ե�����
			// ���ﲻ��Ҫ���κ�����.
		}

		return SKIP_BODY;
	}
}
