package com.sunrise.boss.ui.resmanage.common.definition;

import com.sunrise.boss.ui.commons.User;

public interface Definition {
	
	public String getDefinition(Object vo,String propertyName,Object code,User user)throws Exception;
}
