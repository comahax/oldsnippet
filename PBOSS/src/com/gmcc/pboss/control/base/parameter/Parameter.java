package com.gmcc.pboss.control.base.parameter;


import java.io.Serializable;

import com.gmcc.pboss.business.base.parameter.ParameterDBParam;
import com.gmcc.pboss.business.base.parameter.ParameterVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: Parameter
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author 
 * @version 1.0
 */

public interface Parameter extends AbstractControl{
	
	public ParameterVO doCreate(ParameterVO vo)throws Exception;
	
	public void doRemoveByVO(ParameterVO vo)throws Exception;
	
	public void doRemoveByPK(Serializable pk)throws Exception;
	
	public ParameterVO doUpdate(ParameterVO vo)throws Exception;
	
	public ParameterVO doFindByPk(Serializable pk)throws Exception;
	
	public DataPackage doQuery(ParameterDBParam params)throws Exception;
}
