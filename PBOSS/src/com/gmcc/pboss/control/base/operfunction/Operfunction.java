/**
 * auto-generated code
 * Tue Sep 08 16:02:06 CST 2009
 */
package com.gmcc.pboss.control.base.operfunction;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.base.operfunction.OperfunctionDBParam;
import com.gmcc.pboss.business.base.operfunction.OperfunctionVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Operfunction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Operfunction extends AbstractControl {
    public OperfunctionVO doCreate(OperfunctionVO vo) throws Exception;

    public void doRemoveByVO(OperfunctionVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OperfunctionVO doUpdate(OperfunctionVO vo) throws Exception;

    public OperfunctionVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OperfunctionDBParam params) throws Exception;
    
    public void doBatchSave(List funcList, List operList) throws Exception;
}
