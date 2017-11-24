package com.gmcc.pboss.common.util;

import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class ExceptionHelper {

	protected static final Log logger = LogFactory.getLog(ExceptionHelper.class);
    public void process(HttpServletRequest request, HttpServletResponse response) {
        String strCaption = ""; // ����
        String strTitle = ""; // ��Ϣ
//        System.out.println(">>>>>>>>>>>in it");
        Throwable systemException = (Throwable) request.getAttribute("exception");
        if (systemException == null) {
            systemException = (Throwable) request
                    .getAttribute("javax.servlet.error.exception");
        }

        if (systemException != null && systemException.getCause() != null) {
            systemException = systemException.getCause();
        }

        strCaption = "�ڲ�����";
        strTitle = "δ֪����";
        if (systemException != null) {
            systemException.printStackTrace();
                strTitle = "ϵͳ�ڲ�����" + "��" + systemException.getMessage();

                logger.error(strTitle);
        }

        request.setAttribute("caption", strCaption);
        request.setAttribute("title", strTitle);
    }
    
    public void process(HttpServletRequest request, HttpServletResponse response,java.lang.Throwable exception) {
    	if (exception==null){
    		//��Action���ص��쳣
    		this.process(request, response);
    		return;
    	}
        String strTitle = "δ֪����";
        Throwable systemException = exception;
        StringWriter s = new StringWriter();//�����
        if (systemException != null) {
            	systemException.printStackTrace();
            	systemException.printStackTrace(new PrintWriter(s));
                strTitle = systemException.getMessage();
                
                logger.error(strTitle);
        }

        request.setAttribute("title", "�ڲ�����");
        request.setAttribute("exceptionStack", s.toString());
    }
}
