/**
 * auto-generated code
 * Sat Sep 05 16:02:03 CST 2009
 */
package com.gmcc.pboss.control.resource.numtypedef;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.numtypedef.NumtypedefDBParam;
import com.gmcc.pboss.business.resource.numtypedef.NumtypedefVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Numtypedef </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Numtypedef extends AbstractControl {
    public NumtypedefVO doCreate(NumtypedefVO vo) throws Exception;

    public void doRemoveByVO(NumtypedefVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public NumtypedefVO doUpdate(NumtypedefVO vo) throws Exception;

    public NumtypedefVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(NumtypedefDBParam params) throws Exception;
    public void doRemoveJoinNumsortrule(String[] selectArray) throws Exception;

}
