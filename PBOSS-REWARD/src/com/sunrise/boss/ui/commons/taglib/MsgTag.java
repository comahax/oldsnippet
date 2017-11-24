package com.sunrise.boss.ui.commons.taglib;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import com.sunrise.boss.ui.commons.WebConstant;

public class MsgTag extends TagSupport {
  
  private static final String MSG_HEADER = "<tr><td><b><font color='red'>提示信息:</font></b>";
  private static final String MSG_FOOTER = "</td></tr>";  


  public int doStartTag() {
    return SKIP_BODY;
  }

  public int doEndTag() throws JspTagException {
    try {
      String msg = (String)pageContext.getRequest().getAttribute(
          WebConstant.PAGE_ATTRIBUTE_MESSAGE);
      if (msg != null && msg.trim().length() > 0) {
        pageContext.getOut().print(MSG_HEADER);
        pageContext.getOut().print(msg);
        pageContext.getOut().print(MSG_FOOTER);
      }
    }
    catch (Exception ex) {
    }

    return EVAL_PAGE;
  }
}
