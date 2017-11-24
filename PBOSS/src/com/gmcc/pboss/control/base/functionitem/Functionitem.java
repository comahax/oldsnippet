/**
 * auto-generated code
 * Tue Jul 14 14:52:45 CST 2009
 */
package com.gmcc.pboss.control.base.functionitem;

import java.io.Serializable;

import com.gmcc.pboss.business.base.functionitem.FunctionitemDBParam;
import com.gmcc.pboss.business.base.functionitem.FunctionitemVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Functionitem </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Functionitem extends AbstractControl {
    public FunctionitemVO doCreate(FunctionitemVO vo) throws Exception;

    public void doRemoveByVO(FunctionitemVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public FunctionitemVO doUpdate(FunctionitemVO vo) throws Exception;

    public FunctionitemVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(FunctionitemDBParam params) throws Exception;
    
    public DataPackage doQueryByNameSql(String querySqlName,FunctionitemDBParam param)  throws Exception;
    
    /**
     * 
     * ²Ëµ¥¶àÑ¡Ê÷
     */
    public DataPackage doQueryText(String queryText) throws Exception;
}
