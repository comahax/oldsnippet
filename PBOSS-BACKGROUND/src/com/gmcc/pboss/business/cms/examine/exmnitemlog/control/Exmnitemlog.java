package com.gmcc.pboss.business.cms.examine.exmnitemlog.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.exmnitemlog.persistent.ExmnitemlogListVO;
import com.gmcc.pboss.business.cms.examine.exmnitemlog.persistent.ExmnitemlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ExmnitemlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Exmnitemlog extends AbstractControl {
    public ExmnitemlogVO doCreate(ExmnitemlogVO vo)
        throws Exception;

    public void doRemove(ExmnitemlogVO vo)
        throws Exception;

    public ExmnitemlogVO doUpdate(ExmnitemlogVO vo)
        throws Exception;

    public ExmnitemlogVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(ExmnitemlogListVO params)
        throws Exception;

}
