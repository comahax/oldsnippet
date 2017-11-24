/**
 * auto-generated code
 * Tue Oct 13 14:18:20 CST 2009
 */
package com.gmcc.pboss.control.sales.wayassistant;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.wayassistant.WayassistantDBParam;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Wayassistant </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Wayassistant extends AbstractControl {
    public WayassistantVO doCreate(WayassistantVO vo) throws Exception;

    public void doRemoveByVO(WayassistantVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WayassistantVO doUpdate(WayassistantVO vo) throws Exception;

    public WayassistantVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WayassistantDBParam params) throws Exception;
    
    /*
     * 获取可发起订购canorder=1的渠道
     */
    public DataPackage doQueryCanorder() throws Exception;

}
