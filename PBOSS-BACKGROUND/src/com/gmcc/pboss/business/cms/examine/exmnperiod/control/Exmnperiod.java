package com.gmcc.pboss.business.cms.examine.exmnperiod.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.exmnperiod.persistent.ExmnperiodListVO;
import com.gmcc.pboss.business.cms.examine.exmnperiod.persistent.ExmnperiodVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;


/**
 * <p>Title: ExmnperiodControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Exmnperiod extends AbstractControl {
    public ExmnperiodVO doCreate(ExmnperiodVO vo)
        throws Exception;

    public void doRemove(ExmnperiodVO vo)
        throws Exception;

    public ExmnperiodVO doUpdate(ExmnperiodVO vo)
        throws Exception;

    public ExmnperiodVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(ExmnperiodListVO params)
        throws Exception;

}
