/**
 * auto-generated code
 * Wed Jul 01 17:30:11 CST 2009
 */
package com.gmcc.pboss.control.channel.waycompact;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.waycompact.WaycompactDBParam;
import com.gmcc.pboss.business.channel.waycompact.WaycompactVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Waycompact </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface Waycompact extends AbstractControl {
    public WaycompactVO doCreate(WaycompactVO vo) throws Exception;

    public void doRemoveByVO(WaycompactVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WaycompactVO doUpdate(WaycompactVO vo) throws Exception;

    public WaycompactVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WaycompactDBParam params) throws Exception;

}
