/**
 * auto-generated code
 * Sun Oct 18 20:50:56 CST 2009
 */
package com.gmcc.pboss.control.channel.waycompctlog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.waycompctlog.WaycompctlogDBParam;
import com.gmcc.pboss.business.channel.waycompctlog.WaycompctlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Waycompctlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Waycompctlog extends AbstractControl {
    public WaycompctlogVO doCreate(WaycompctlogVO vo) throws Exception;

    public void doRemoveByVO(WaycompctlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WaycompctlogVO doUpdate(WaycompctlogVO vo) throws Exception;

    public WaycompctlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WaycompctlogDBParam params) throws Exception;

}
