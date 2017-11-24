/**
 * auto-generated code
 * Thu Jul 08 15:12:12 CST 2010
 */
package com.gmcc.pboss.control.sales.timesect;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.timesect.TimesectDBParam;
import com.gmcc.pboss.business.sales.timesect.TimesectVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Timesect </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Timesect extends AbstractControl {
    public TimesectVO doCreate(TimesectVO vo) throws Exception;

    public void doRemoveByVO(TimesectVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public TimesectVO doUpdate(TimesectVO vo) throws Exception;

    public TimesectVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(TimesectDBParam params) throws Exception;

}
