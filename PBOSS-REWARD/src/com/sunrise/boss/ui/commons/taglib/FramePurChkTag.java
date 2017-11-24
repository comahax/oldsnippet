package com.sunrise.boss.ui.commons.taglib;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * 用于资源管理部分帧页面的访问权限控制
 * 
 * @author David
 * 
 */
public class FramePurChkTag extends TagSupport {

	private String pageid;
	private ACLDelegate delegate;

	public String getPageid() {
		return pageid;
	}

	public void setPageid(String pageid) {
		this.pageid = pageid;
	}

	public FramePurChkTag() throws Exception {
		delegate = new ACLDelegate();
	}

	public int doStartTag() {
		try {
			User user = (User) pageContext.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			if (delegate.checkPermission(user.getOpercode(), this.pageid)) {
				return EVAL_BODY_INCLUDE;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspTagException {
		return SKIP_BODY;
	}
}
