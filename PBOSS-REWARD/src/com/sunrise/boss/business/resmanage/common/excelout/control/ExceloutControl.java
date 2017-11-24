package com.sunrise.boss.business.resmanage.common.excelout.control;

import java.sql.ResultSet;
import java.util.List;

import com.sunrise.boss.business.resmanage.common.excelout.ExceloutRet;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.ui.commons.User;

public interface ExceloutControl extends AbstractControl{
	public ExceloutRet doQuery(Object params,List queryFields,Class voClass,ResultSet rs,User user) throws Exception;
	public int count(Object params, Class voClass,User user) throws Exception;
}
