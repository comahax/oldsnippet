/**
 * auto-generated code
 * Sun Oct 18 20:23:20 CST 2009
 */
package com.gmcc.pboss.control.channel.waylog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.waylog.WaylogDBParam;
import com.gmcc.pboss.business.channel.waylog.WaylogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Waylog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Waylog extends AbstractControl {
    public WaylogVO doCreate(WaylogVO vo) throws Exception;

    public void doRemoveByVO(WaylogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WaylogVO doUpdate(WaylogVO vo) throws Exception;

    public WaylogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WaylogDBParam params) throws Exception;

}
