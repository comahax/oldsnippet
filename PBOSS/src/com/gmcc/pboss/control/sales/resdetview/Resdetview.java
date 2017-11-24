/**
 * auto-generated code
 * Sun Oct 18 15:07:09 CST 2009
 */
package com.gmcc.pboss.control.sales.resdetview;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.resdetview.ResdetviewDBParam;
import com.gmcc.pboss.business.sales.resdetview.ResdetviewVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Resdetview </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public interface Resdetview extends AbstractControl {
    public ResdetviewVO doCreate(ResdetviewVO vo) throws Exception;

    public void doRemoveByVO(ResdetviewVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ResdetviewVO doUpdate(ResdetviewVO vo) throws Exception;

    public ResdetviewVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ResdetviewDBParam params) throws Exception;

}
