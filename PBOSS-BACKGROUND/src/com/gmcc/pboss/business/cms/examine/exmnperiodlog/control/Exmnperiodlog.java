package com.gmcc.pboss.business.cms.examine.exmnperiodlog.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.exmnperiodlog.persistent.ExmnperiodlogListVO;
import com.gmcc.pboss.business.cms.examine.exmnperiodlog.persistent.ExmnperiodlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ExmnperiodlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Exmnperiodlog extends AbstractControl {
    public ExmnperiodlogVO doCreate(ExmnperiodlogVO vo)
        throws Exception;

    public void doRemove(ExmnperiodlogVO vo)
        throws Exception;

    public ExmnperiodlogVO doUpdate(ExmnperiodlogVO vo)
        throws Exception;

    public ExmnperiodlogVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(ExmnperiodlogListVO params)
        throws Exception;

}
