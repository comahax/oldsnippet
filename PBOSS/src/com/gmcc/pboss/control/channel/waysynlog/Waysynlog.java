/**
 * auto-generated code
 * Wed Jul 01 17:02:51 CST 2009
 */
package com.gmcc.pboss.control.channel.waysynlog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.waysynlog.WaysynlogDBParam;
import com.gmcc.pboss.business.channel.waysynlog.WaysynlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Waysynlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface Waysynlog extends AbstractControl {
    public WaysynlogVO doCreate(WaysynlogVO vo) throws Exception;

    public void doRemoveByVO(WaysynlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WaysynlogVO doUpdate(WaysynlogVO vo) throws Exception;

    public WaysynlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WaysynlogDBParam params) throws Exception;

}
