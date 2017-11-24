package com.gmcc.pboss.business.cms.examine.exmnitem.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.exmnitem.persistent.ExmnitemListVO;
import com.gmcc.pboss.business.cms.examine.exmnitem.persistent.ExmnitemVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ExmnitemControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Exmnitem extends AbstractControl {
    public ExmnitemVO doCreate(ExmnitemVO vo)
        throws Exception;

    public void doRemove(ExmnitemVO vo)
        throws Exception;

    public ExmnitemVO doUpdate(ExmnitemVO vo)
        throws Exception;

    public ExmnitemVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(ExmnitemListVO params)
        throws Exception;
    public DataPackage doQueryExmnitemList(ExmnitemListVO params)
    throws Exception ;
    public void doRemoveItem(Serializable pkVO, String itemcityid)
    throws Exception;

    
}
