/**
 * auto-generated code
 * Wed Sep 09 09:17:44 CST 2009
 */
package com.gmcc.pboss.control.resource.simpleboss;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.simpleboss.SimplebossDBParam;
import com.gmcc.pboss.business.resource.simpleboss.SimplebossVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Simpleboss </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author linli
 * @version 1.0
 */
public interface Simpleboss extends AbstractControl {
    public SimplebossVO doCreate(SimplebossVO vo) throws Exception;

    public void doRemoveByVO(SimplebossVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SimplebossVO doUpdate(SimplebossVO vo) throws Exception;

    public SimplebossVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SimplebossDBParam params) throws Exception;

}
