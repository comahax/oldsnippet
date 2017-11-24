package com.sunrise.jop.common.businesslog;

import com.sunrise.jop.common.commoncontrol.CommonControl;

public interface BusinessLogControl extends CommonControl{
	
	public abstract Class getVoClass();

    public abstract void setVoClass(Class class1);
	
	public abstract Object doLogCreate(Object obj)
    	throws Exception;
	
}
