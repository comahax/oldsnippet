package com.gmcc.pboss.control.base.operinfo;


import java.io.Serializable;

import com.gmcc.pboss.business.base.operinfo.OperinfoDBParam;
import com.gmcc.pboss.business.base.operinfo.OperinfoVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: Cmpsmscon
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

public interface Operinfo extends AbstractControl{
	
	public OperinfoVO doCreate(OperinfoVO vo)throws Exception;
	
	public void doRemoveByVO(OperinfoVO vo)throws Exception;
	
	public void doRemoveByPK(Serializable pk)throws Exception;
	
	public OperinfoVO doUpdate(OperinfoVO vo)throws Exception;
	
	public OperinfoVO doFindByPk(Serializable pk)throws Exception;
	
	public DataPackage doQuery(OperinfoDBParam params)throws Exception;
}
