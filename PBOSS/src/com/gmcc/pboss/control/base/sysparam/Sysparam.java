/**
 * auto-generated code
 * Wed Sep 02 17:01:06 CST 2009
 */
package com.gmcc.pboss.control.base.sysparam;

import java.io.Serializable;

import com.gmcc.pboss.business.base.sysparam.SysparamDBParam;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Sysparam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Sysparam extends AbstractControl {
    public SysparamVO doCreate(SysparamVO vo) throws Exception;

    public void doRemoveByVO(SysparamVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SysparamVO doUpdate(SysparamVO vo) throws Exception;

    public SysparamVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SysparamDBParam params) throws Exception;
    
    /**
	 * 根据系统标识[SYSTEMID]”“参数类型[PARAMTYPE]查询系统参数值
	 * @param systemid
	 * @param paramtype
	 * @return
	 * @throws Exception
	 */
    public String doFindByID(String systemid, String paramtype) throws Exception;
	
	public String doFindByID(Long systemid, String paramtype) throws Exception;

}
