package com.sunrise.boss.ui.resmanage.common.definition.impl;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.resmanage.common.definition.Definition;

public class ComidDefinition implements Definition{
	public String getDefinition(Object vo,String propertyName,Object code,User user)throws Exception{
		return "#COMSYSTEM";
	}
}
