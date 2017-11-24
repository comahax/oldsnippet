/**
 * auto-generated code
 * Thu Jul 08 15:13:51 CST 2010
 */
package com.gmcc.pboss.control.sales.timesectlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.timesectlog.TimesectlogDBParam;
import com.gmcc.pboss.business.sales.timesectlog.TimesectlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Timesectlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Timesectlog extends AbstractControl {
    public TimesectlogVO doCreate(TimesectlogVO vo) throws Exception;

    public void doRemoveByVO(TimesectlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public TimesectlogVO doUpdate(TimesectlogVO vo) throws Exception;

    public TimesectlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(TimesectlogDBParam params) throws Exception;

}
