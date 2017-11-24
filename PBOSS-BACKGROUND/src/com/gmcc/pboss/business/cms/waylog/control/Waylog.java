package com.gmcc.pboss.business.cms.waylog.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.waylog.persistent.WaylogListVO;
import com.gmcc.pboss.business.cms.waylog.persistent.WaylogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: WaylogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public interface Waylog extends AbstractControl {
    public WaylogVO doCreate(WaylogVO vo)
        throws Exception;

    public void doRemove(WaylogVO vo)
        throws Exception;

    public WaylogVO doUpdate(WaylogVO vo)
        throws Exception;

    public WaylogVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(WaylogListVO params)
        throws Exception;

}
