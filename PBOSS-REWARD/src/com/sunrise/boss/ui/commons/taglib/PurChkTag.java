package com.sunrise.boss.ui.commons.taglib;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: Ȩ�޼���Զ����ǩ</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Gaven
 * @version 1.0
 */
public class PurChkTag extends TagSupport {
//  private OperpurrelaDelegate delegate;

  private String controlid;

  public String getControlid() {
    return controlid;
  }

  public void setControlid(String controlid) {
    this.controlid = controlid;
  }

  public PurChkTag() throws Exception {
//    delegate = new OperpurrelaDelegate();
  }

  public int doStartTag() {
    try {
      User user = (User) pageContext.getSession().
          getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
      
      //TODO: ��OperpurrelaDelegate���, ����Ȩ�޼�鹦��
//      if (controlid != null) {
//        if (delegate.checkPurview(controlid, user.getOpercode())) {
//          return  EVAL_BODY_INCLUDE;
//        }    	 
//      }
      return EVAL_BODY_INCLUDE;
    }
    catch (Exception ex) {
    }
    return SKIP_BODY;
  }

  public int doEndTag() throws JspTagException {
    return SKIP_BODY;
  }
}
