package com.sunrise.boss.common.export;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sunrise.jop.infrastructure.component.Code2Name;
import com.sunrise.jop.infrastructure.component.impl.DefaultCode2Name;

public class ExcelCodeToName {

	private static final Logger log = LoggerFactory.getLogger(ExcelCodeToName.class);
	
	public ExcelCodeToName(){
		log.info("ExcelCodeToName.class init ");
	}

	public String codeToName(String definition, String codevalue,String dbFlag) {
		Code2Name code2Name = new DefaultCode2Name();
		return code2Name.code2Name(definition, codevalue, dbFlag);
	}

}
