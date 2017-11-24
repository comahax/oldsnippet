package com.sunrise.boss.ui.commons.handler;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

import com.sunrise.boss.ui.commons.WebConstant;

public class StrutsExceptionHandler extends ExceptionHandler {
  public ActionForward execute(Exception ex,
                               ExceptionConfig config,
                               ActionMapping mapping,
                               ActionForm formInstance,
                               HttpServletRequest request,
                               HttpServletResponse response) throws
      ServletException {
    ActionForward forward = null;

    /* Get the path for the forward either from the exception element
     * or from the input attribute.
     */
    String path = null;
    if (config.getPath() != null) {
      path = config.getPath();
    }
    else {
      path = mapping.getInput();
    }

    // Construct the forward object
    forward = new ActionForward(path);

    // Fill the error message
    request.setAttribute(WebConstant.ERROR_SUMMARY, ex.getMessage());

    CharArrayWriter cw = new java.io.CharArrayWriter();
    PrintWriter pw = new java.io.PrintWriter(cw,true);
    ex.printStackTrace(pw);
    request.setAttribute(WebConstant.ERROR_DETAIL, cw.toString());

    return forward;
  }
}
