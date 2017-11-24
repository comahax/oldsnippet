/**
 * auto-generated code
 * Tue Oct 20 14:31:44 CST 2009
 */
package com.gmcc.pboss.control.sales.smpextramid;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.smpextramid.SmpextramidDBParam;
import com.gmcc.pboss.business.sales.smpextramid.SmpextramidVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Smpextramid </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public interface Smpextramid extends AbstractControl {
    public SmpextramidVO doCreate(SmpextramidVO vo) throws Exception;

    public void doRemoveByVO(SmpextramidVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SmpextramidVO doUpdate(SmpextramidVO vo) throws Exception;

    public SmpextramidVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SmpextramidDBParam params) throws Exception;

}
