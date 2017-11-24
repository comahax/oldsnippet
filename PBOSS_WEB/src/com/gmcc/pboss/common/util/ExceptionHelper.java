package com.gmcc.pboss.common.util;

import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class ExceptionHelper {

	protected static final Log logger = LogFactory.getLog(ExceptionHelper.class);
    public void process(HttpServletRequest request, HttpServletResponse response) {
        String strCaption = ""; // 标题
        String strTitle = ""; // 信息
//        System.out.println(">>>>>>>>>>>in it");
        Throwable systemException = (Throwable) request.getAttribute("exception");
        if (systemException == null) {
            systemException = (Throwable) request
                    .getAttribute("javax.servlet.error.exception");
        }

        if (systemException != null && systemException.getCause() != null) {
            systemException = systemException.getCause();
        }

        strCaption = "内部错误";
        strTitle = "未知错误";
        if (systemException != null) {
            systemException.printStackTrace();
                strTitle = "系统内部错误" + "：" + systemException.getMessage();

                logger.error(strTitle);
        }

        request.setAttribute("caption", strCaption);
        request.setAttribute("title", strTitle);
    }
    
    public void process(HttpServletRequest request, HttpServletResponse response,java.lang.Throwable exception) {
    	if (exception==null){
    		//从Action返回的异常
    		this.process(request, response);
    		return;
    	}
        String strTitle = "未知错误";
        Throwable systemException = exception;
        StringWriter s = new StringWriter();//输出流
        if (systemException != null) {
            	systemException.printStackTrace();
            	systemException.printStackTrace(new PrintWriter(s));
                strTitle = systemException.getMessage();
                
                logger.error(strTitle);
        }

        request.setAttribute("title", "内部错误");
        request.setAttribute("exceptionStack", s.toString());
    }
}
