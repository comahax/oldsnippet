package com.gmcc.pboss.business.cms.examine.exmnrslt.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.exmnrslt.persistent.ExmnrsltListVO;
import com.gmcc.pboss.business.cms.examine.exmnrslt.persistent.ExmnrsltVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ExmnrsltControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Exmnrslt extends AbstractControl {
    public ExmnrsltVO doCreate(ExmnrsltVO vo)
        throws Exception;

    public void doRemove(ExmnrsltVO vo)
        throws Exception;

    public ExmnrsltVO doUpdate(ExmnrsltVO vo)
        throws Exception;

    public ExmnrsltVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(ExmnrsltListVO params)
        throws Exception;

}
