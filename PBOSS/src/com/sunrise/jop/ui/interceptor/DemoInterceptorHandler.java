package com.sunrise.jop.ui.interceptor;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.jop.infrastructure.dproxy.InterceptorHandler;

/**
 * 
 * @author He Kun
 *
 */
public class DemoInterceptorHandler extends InterceptorHandler {
	
	private static final Log log = LogFactory.getLog(DemoInterceptorHandler.class);
	
    private static List interceptors = new ArrayList(3);
    
    public void registerInterceptors() {
    	//registerInterceptor(Code2NameCacheInterceptor.class);
    }
    
    /**
     * @return List interceptors
     */
    public List getInterceptors()  {    	
    	if(log.isDebugEnabled()) log.debug("DemoInterceptorHandler getInterceptors...");
    	return interceptors;
    }
}
