/**
 * auto-generated code
 * Mon Nov 23 16:35:24 CST 2009
 */
package com.gmcc.pboss.control.channel.wayapplylog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.wayapplylog.WayapplylogDBParam;
import com.gmcc.pboss.business.channel.wayapplylog.WayapplylogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Wayapplylog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Wayapplylog extends AbstractControl {
    public WayapplylogVO doCreate(WayapplylogVO vo) throws Exception;

    public void doRemoveByVO(WayapplylogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WayapplylogVO doUpdate(WayapplylogVO vo) throws Exception;

    public WayapplylogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WayapplylogDBParam params) throws Exception;

}
