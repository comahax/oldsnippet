package com.gmcc.pboss.business.cms.examine.coefrevision.control;

import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.coefrevision.persistent.CoefrevisionListVO;
import com.gmcc.pboss.business.cms.examine.coefrevision.persistent.CoefrevisionVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: CoefrevisionControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Coefrevision extends AbstractControl {
    public CoefrevisionVO doCreate(CoefrevisionVO vo)
        throws Exception;

    public void doRemove(CoefrevisionVO vo)
        throws Exception;

    public CoefrevisionVO doUpdate(CoefrevisionVO vo)
        throws Exception;

    public CoefrevisionVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(CoefrevisionListVO params)
        throws Exception;

}
