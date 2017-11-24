package com.gmcc.pboss.control.base.dictgroup;


import java.io.Serializable;

import com.gmcc.pboss.business.base.dictgroup.DictgroupDBParam;
import com.gmcc.pboss.business.base.dictgroup.DictgroupVO;
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

public interface Dictgroup extends AbstractControl{
	
	public DictgroupVO doCreate(DictgroupVO vo)throws Exception;
	
	public void doRemoveByVO(DictgroupVO vo)throws Exception;
	
	public void doRemoveByPK(Serializable pk)throws Exception;
	
	public DictgroupVO doUpdate(DictgroupVO vo)throws Exception;
	
	public DictgroupVO doFindByPk(Serializable pk)throws Exception;
	
	public DataPackage doQuery(DictgroupDBParam params)throws Exception;
}
