package com.gmcc.pboss.business.cms.examine.exmnauditlog.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.exmnauditlog.persistent.ExmnauditlogListVO;
import com.gmcc.pboss.business.cms.examine.exmnauditlog.persistent.ExmnauditlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ExmnauditlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Exmnauditlog extends AbstractControl {
    public ExmnauditlogVO doCreate(ExmnauditlogVO vo)
        throws Exception;

    public void doRemove(ExmnauditlogVO vo)
        throws Exception;

    public ExmnauditlogVO doUpdate(ExmnauditlogVO vo)
        throws Exception;

    public ExmnauditlogVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(ExmnauditlogListVO params)
        throws Exception;

}
