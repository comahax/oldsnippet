/**
 * auto-generated code
 * Tue Oct 13 14:27:11 CST 2009
 */
package com.gmcc.pboss.control.sales.monamtchgrule;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.monamtchgrule.MonamtchgruleDBParam;
import com.gmcc.pboss.business.sales.monamtchgrule.MonamtchgruleVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Monamtchgrule </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Monamtchgrule extends AbstractControl {
    public MonamtchgruleVO doCreate(MonamtchgruleVO vo) throws Exception;

    public void doRemoveByVO(MonamtchgruleVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public MonamtchgruleVO doUpdate(MonamtchgruleVO vo) throws Exception;

    public MonamtchgruleVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(MonamtchgruleDBParam params) throws Exception;
    
    public boolean doCheckActrate(MonamtchgruleVO vo,DataPackage dp) throws Exception;

}
