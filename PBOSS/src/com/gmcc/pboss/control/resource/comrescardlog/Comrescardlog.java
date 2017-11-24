/**
 * auto-generated code
 * Wed Sep 02 16:33:10 CST 2009
 */
package com.gmcc.pboss.control.resource.comrescardlog;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.comrescardlog.ComrescardlogDBParam;
import com.gmcc.pboss.business.resource.comrescardlog.ComrescardlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Comrescardlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Comrescardlog extends AbstractControl {
    public ComrescardlogVO doCreate(ComrescardlogVO vo) throws Exception;

    public void doRemoveByVO(ComrescardlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ComrescardlogVO doUpdate(ComrescardlogVO vo) throws Exception;

    public ComrescardlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ComrescardlogDBParam params) throws Exception;

}
