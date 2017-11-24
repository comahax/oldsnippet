package com.sunrise.boss.ui.commons.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.beanutils.PropertyUtils;

public class OrderImgTag extends TagSupport {
  private String form, field;

  public void setField(String field) {
    this.field = field;
  }

  public void setForm(String form) {
    this.form = form;
  }

  public int doStartTag() {
    return SKIP_BODY;
  }

  public int doEndTag() throws JspTagException {
    try {
      Object bean = pageContext.getRequest().getAttribute(form);
      String orderby = (String)PropertyUtils.getProperty(bean, "_orderby");
      String desc = (String)PropertyUtils.getProperty(bean, "_desc");
      if (orderby.equals(field)) {
        if (desc.length() == 0) {
          pageContext.getOut().print("<img src='" + ((HttpServletRequest)pageContext.getRequest()).getContextPath() + "/images/up.gif'>");
        }
        else {
          pageContext.getOut().print("<img src='" + ((HttpServletRequest)pageContext.getRequest()).getContextPath() + "/images/down.gif'>");
        }
      }
    }
    catch (Exception ex) {
    }

    return EVAL_PAGE;
  }
}
