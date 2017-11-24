package com.sunrise.boss.delegate.admin.code2name;

import java.util.Map;

import com.sunrise.boss.business.admin.code2name.control.Code2NameControl;
import com.sunrise.boss.business.admin.code2name.control.Code2NameControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

public class Code2NameDelegate {
	private Code2NameControl control;

	public Code2NameDelegate() throws Exception {
		control = (Code2NameControl) ControlFactory
				.build(Code2NameControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public Object translateCode(String voName, String codeName, String nameName,
			Object codeValue, String dbFlag) throws Exception {
		return control.translateCode(voName, codeName, nameName, codeValue,
				dbFlag);
	}
	
	public Map valueList( String voName , String codeName, String nameName 
			,String dbFlag ) throws Exception{
		return control.valueList(voName, codeName, nameName, 
				dbFlag);
	}
}
