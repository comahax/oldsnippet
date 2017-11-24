package com.gmcc.pboss.business.cms.examine.exmnaudit.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.exmnaudit.persistent.ExmnauditListVO;
import com.gmcc.pboss.business.cms.examine.exmnaudit.persistent.ExmnauditVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ExmnauditControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Exmnaudit extends AbstractControl {
    public ExmnauditVO doCreate(ExmnauditVO vo)
        throws Exception;

    public void doRemove(ExmnauditVO vo)
        throws Exception;

    public ExmnauditVO doUpdate(ExmnauditVO vo)
        throws Exception;

    public ExmnauditVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(ExmnauditListVO params)
        throws Exception;

}
