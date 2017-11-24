/**
 * auto-generated code
 * Wed Jul 01 17:28:07 CST 2009
 */
package com.gmcc.pboss.control.channel.waysyn;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.waysyn.WaysynDBParam;
import com.gmcc.pboss.business.channel.waysyn.WaysynVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Waysyn </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface Waysyn extends AbstractControl {
    public WaysynVO doCreate(WaysynVO vo) throws Exception;

    public void doRemoveByVO(WaysynVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WaysynVO doUpdate(WaysynVO vo) throws Exception;

    public WaysynVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WaysynDBParam params) throws Exception;

}
