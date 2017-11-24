/**
 * auto-generated code
 * Thu Jul 14 20:18:52 CST 2011
 */
package com.gmcc.pboss.control.sales.wayassistantlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.wayassistantlog.WayassistantlogDBParam;
import com.gmcc.pboss.business.sales.wayassistantlog.WayassistantlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Wayassistantlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface Wayassistantlog extends AbstractControl {
    public WayassistantlogVO doCreate(WayassistantlogVO vo) throws Exception;

    public void doRemoveByVO(WayassistantlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WayassistantlogVO doUpdate(WayassistantlogVO vo) throws Exception;

    public WayassistantlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WayassistantlogDBParam params) throws Exception;

}
