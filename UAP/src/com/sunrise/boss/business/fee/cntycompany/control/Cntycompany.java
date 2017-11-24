/**
* auto-generated code
* Fri Aug 25 11:16:40 CST 2006
*/
package com.sunrise.boss.business.fee.cntycompany.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.cntycompany.persistent.CntycompanyDBParam;
import com.sunrise.boss.business.fee.cntycompany.persistent.CntycompanyVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;


/**
 * <p>Title: CntycompanyControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public interface Cntycompany extends AbstractControl {
    public CntycompanyVO doCreate(CntycompanyVO vo)
        throws Exception;

    public void doRemove(CntycompanyVO vo)
        throws Exception;

    public CntycompanyVO doUpdate(CntycompanyVO vo)
        throws Exception;

    public CntycompanyVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(CntycompanyDBParam params)
        throws Exception;

}
