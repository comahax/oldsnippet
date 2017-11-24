/**
 * auto-generated code
 * Wed Sep 02 17:29:19 CST 2009
 */
package com.gmcc.pboss.control.resource.numsortrulelog;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.numsortrulelog.NumsortrulelogDBParam;
import com.gmcc.pboss.business.resource.numsortrulelog.NumsortrulelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Numsortrulelog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Numsortrulelog extends AbstractControl {
    public NumsortrulelogVO doCreate(NumsortrulelogVO vo) throws Exception;

    public void doRemoveByVO(NumsortrulelogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public NumsortrulelogVO doUpdate(NumsortrulelogVO vo) throws Exception;

    public NumsortrulelogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(NumsortrulelogDBParam params) throws Exception;

}
