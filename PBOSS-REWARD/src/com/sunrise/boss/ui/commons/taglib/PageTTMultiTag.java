package com.sunrise.boss.ui.commons.taglib;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import com.sunrise.boss.common.base.db.DataPackage;

/**
 * 历史库迁移，新建分页标签，支持当前页和
 * @author baiming
 *
 */
public class PageTTMultiTag extends TagSupport {
	private String dpName;

	private static final String PAGE_DISPLAY_JSP_PATH = "/commons/pageTTMulti.jsp";
	private static final String CURRENT_PAGE_NAME = "currentPage";
	private static final String TOTAL_PAGE_NAME = "totalPage";

	public void setDpName(String dpName) {
		this.dpName = dpName;
	}

	public int doStartTag() throws JspTagException {

		try {
			DataPackage bean = (DataPackage) pageContext.getRequest().getAttribute(dpName);

			if (null == bean) {
				return SKIP_BODY;
			}

			int currentPage = bean.getPageNo();
			
			/** add by mys 20081203 start**/
			int totalPage = (int) Math.ceil(((double) bean.getRowCount())
					/ ((double) bean.getPageSize()));
			pageContext.getRequest().setAttribute(TOTAL_PAGE_NAME, new Integer(totalPage));
			/** add by mys 20081203  end**/
			
			pageContext.getRequest().setAttribute(CURRENT_PAGE_NAME, new Integer(currentPage));
			pageContext.include(PAGE_DISPLAY_JSP_PATH);
		} catch (Exception ex) {
			// 如捕获异常,则不显示分页信息,不会导致任何破坏性的问题
			// 这里不需要做任何事情.
		}

		return SKIP_BODY;
	}
}
