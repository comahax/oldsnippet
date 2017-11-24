package com.gmcc.pboss.business.cms.examine.exmnitemdtl.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlListVO;
import com.gmcc.pboss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ExmnitemdtlControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Exmnitemdtl extends AbstractControl {
    public ExmnitemdtlVO doCreate(ExmnitemdtlVO vo)
        throws Exception;

    public void doRemove(ExmnitemdtlVO vo)
        throws Exception;

    public ExmnitemdtlVO doUpdate(ExmnitemdtlVO vo)
        throws Exception;

    public ExmnitemdtlVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(ExmnitemdtlListVO params)
        throws Exception;

    public void doRemoveDtl(Serializable pk,String cityid)
    throws Exception ;

}
