package com.sunrise.boss.business.admin.code2name.control;

import java.util.Map;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.ui.commons.User;

public interface Code2NameControl extends AbstractControl {
	Object translateCode(String voName, String codeName, String nameName,
			Object codeValue, String dbFlag) throws Exception;
	public Map valueList( String voName, String codeName, String nameName,
			 String dbFlag) throws Exception;

}
