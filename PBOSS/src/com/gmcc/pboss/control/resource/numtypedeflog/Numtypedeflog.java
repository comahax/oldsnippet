/**
 * auto-generated code
 * Wed Sep 02 17:16:59 CST 2009
 */
package com.gmcc.pboss.control.resource.numtypedeflog;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.numtypedeflog.NumtypedeflogDBParam;
import com.gmcc.pboss.business.resource.numtypedeflog.NumtypedeflogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Numtypedeflog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Numtypedeflog extends AbstractControl {
    public NumtypedeflogVO doCreate(NumtypedeflogVO vo) throws Exception;

    public void doRemoveByVO(NumtypedeflogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public NumtypedeflogVO doUpdate(NumtypedeflogVO vo) throws Exception;

    public NumtypedeflogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(NumtypedeflogDBParam params) throws Exception;

}
