package com.sunrise.boss.ui.cms.opntree;

import com.sunrise.boss.common.exception.business.BusinessException;

public class OpnTreeType {

	public static final String PW_TYPE = "pw";
	public static final String BBC_TYPE = "bbc";
	public static final String ZJTY_TYPE = "zjty";
	public static final String WAY_TYPE = "way";

	public static final String getTreeType(String type) throws Exception{
		type = type.toLowerCase();
		if(type.equals(PW_TYPE)){
			return PW_TYPE;
		}else if(type.equals(BBC_TYPE)){
			return BBC_TYPE;
		}else if(type.equals(ZJTY_TYPE)){
			return ZJTY_TYPE;
		}else if(type.equals(WAY_TYPE)){
			return WAY_TYPE;
		}else{
			throw new BusinessException("","该业务树暂时不支持该类型的业务!");
		}
	}
}
