package com.gmcc.pboss.business.cms.examine.coefrevisionlog.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.coefrevisionlog.persistent.CoefrevisionlogListVO;
import com.gmcc.pboss.business.cms.examine.coefrevisionlog.persistent.CoefrevisionlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: CoefrevisionlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Coefrevisionlog extends AbstractControl {
    public CoefrevisionlogVO doCreate(CoefrevisionlogVO vo)
        throws Exception;

    public void doRemove(CoefrevisionlogVO vo)
        throws Exception;

    public CoefrevisionlogVO doUpdate(CoefrevisionlogVO vo)
        throws Exception;

    public CoefrevisionlogVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(CoefrevisionlogListVO params)
        throws Exception;

}
