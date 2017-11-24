/**
 * auto-generated code
 * Wed Dec 28 15:16:03 CST 2011
 */
package com.gmcc.pboss.control.examine.disexamine;

import java.io.Serializable;

import com.gmcc.pboss.business.examine.disexamine.DisexamineDBParam;
import com.gmcc.pboss.business.examine.disexamine.DisexamineVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Disexamine </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface Disexamine extends AbstractControl {
    public DisexamineVO doCreate(DisexamineVO vo) throws Exception;

    public void doRemoveByVO(DisexamineVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public DisexamineVO doUpdate(DisexamineVO vo) throws Exception;

    public DisexamineVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(DisexamineDBParam params) throws Exception;
    
    //µº»Î
    public void doDisexamineImport(String[] items) throws Exception;

}
