/**
 * auto-generated code
 * Thu Nov 05 10:44:22 CST 2009
 */
package com.gmcc.pboss.control.channel.wayacctlog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.wayacctlog.WayacctlogDBParam;
import com.gmcc.pboss.business.channel.wayacctlog.WayacctlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Wayacctlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Wayacctlog extends AbstractControl {
    public WayacctlogVO doCreate(WayacctlogVO vo) throws Exception;

    public void doRemoveByVO(WayacctlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WayacctlogVO doUpdate(WayacctlogVO vo) throws Exception;

    public WayacctlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WayacctlogDBParam params) throws Exception;

}
