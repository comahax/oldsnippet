package com.sunrise.jop.ui.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

/**
 * <p>Title: GDIBOSS</p>
 * <p/>
 * <p>Description: </p>
 * <p/>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p/>
 * <p>Company: sunrise Tech Ltd.</p>
 *
 * @author gaven
 * @version 1.0
 */
public class EncodingFilter extends HttpServlet implements Filter {
    private FilterConfig filterConfig;
    private String targetEncoding = "utf-8";

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException {
        try {
            request.setCharacterEncoding(targetEncoding);
            response.setCharacterEncoding(targetEncoding);
            filterChain.doFilter(request, response);
        }
        catch (Exception sx) {
            filterConfig.getServletContext().log(sx.getMessage());
            sx.printStackTrace();
            throw new ServletException(sx);
        }
    }

    public void destroy() {
        filterConfig = null;
        targetEncoding = null;
    }
}
