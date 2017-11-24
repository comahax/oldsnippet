package com.sunrise.boss.ui.commons.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.taglibs.standard.tag.common.core.NullAttributeException;
import org.apache.taglibs.standard.tag.el.core.ExpressionUtil;

import com.sunrise.boss.delegate.resmanage.common.tag.ResCommonChkDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

public class ResCommonChkTag extends BodyTagSupport {
	private String nameandvalue;

	private String delegate;

	private String reverse = "false";

	public String getReverse() {
		return reverse;
	}

	public void setReverse(String reverse) {
		this.reverse = reverse;
	}

	public int doStartTag() {
		try {
			User user = (User) pageContext.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			String valuename = this.evaluateCondition("nameandvalue",
					nameandvalue);
			String delegate = this.evaluateCondition("delegate", this.delegate);

			if (new ResCommonChkDelegate().checkPermission(delegate, valuename,
					user)) {
				if (!reverse.equals("true")) {
					return EVAL_BODY_INCLUDE;
				}
			}else {
				if (reverse.equals("true")){
					return EVAL_BODY_INCLUDE;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspTagException {
		return SKIP_BODY;
	}

	private String evaluateCondition(String attr, String attrValue)
			throws JspException, NullAttributeException {
		String value = (String) ExpressionUtil.evalNotNull("ResCommonChk",
				attr, attrValue, Object.class, this, pageContext);
		return value;
	}

	public String getDelegate() {
		return delegate;
	}

	public void setDelegate(String delegate) {
		this.delegate = delegate;
	}

	public String getNameandvalue() {
		return nameandvalue;
	}

	public void setNameandvalue(String nameandvalue) {
		this.nameandvalue = nameandvalue;
	}
}
