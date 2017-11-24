package com.sunrise.jop.ui.struts2;

import javax.servlet.http.HttpServletRequest;

import org.ajaxanywhere.AAUtils;
import org.apache.struts2.ServletActionContext;

public class AAUtilsForStruts2 {

	public AAUtilsForStruts2() {
		// TODO Auto-generated constructor stub
	}
	public static boolean isAjaxRequest(){
		HttpServletRequest request=ServletActionContext.getRequest();
		if(request!=null){
		return AAUtils.isAjaxRequest(request);
		}
		return false;
	}
	
	public static void addZonesToRefresh(String zoneid){
		HttpServletRequest request=ServletActionContext.getRequest();
		if(request!=null){
		AAUtils.addZonesToRefresh(request,zoneid);
		}
	}
}
