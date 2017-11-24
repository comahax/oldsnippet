package com.gmcc.pboss.business.cms.examine.exmnitemdtllog.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.exmnitemdtllog.persistent.ExmnitemdtllogListVO;
import com.gmcc.pboss.business.cms.examine.exmnitemdtllog.persistent.ExmnitemdtllogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ExmnitemdtllogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Exmnitemdtllog extends AbstractControl {
    public ExmnitemdtllogVO doCreate(ExmnitemdtllogVO vo)
        throws Exception;

    public void doRemove(ExmnitemdtllogVO vo)
        throws Exception;

    public ExmnitemdtllogVO doUpdate(ExmnitemdtllogVO vo)
        throws Exception;

    public ExmnitemdtllogVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(ExmnitemdtllogListVO params)
        throws Exception;

}
