package com.asisinfo.staff.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestHolder {
private static ThreadLocal<HttpServletRequest> local = new ThreadLocal<HttpServletRequest>();
	
	public static void setHttpServletRequest(HttpServletRequest request){
		local.set(request);
	}
	
	public static HttpServletRequest getHttpServletRequest(){
		return local.get();
	}

}
