/**
 * auto-generated code
 * Wed Jul 08 10:58:48 CST 2009
 */
package com.gmcc.pboss.control.channel.servcent;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.servcent.ServcentDBParam;
import com.gmcc.pboss.business.channel.servcent.ServcentVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Servcent </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Servcent extends AbstractControl {
    public ServcentVO doCreate(ServcentVO vo) throws Exception;

    public void doRemoveByVO(ServcentVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ServcentVO doUpdate(ServcentVO vo) throws Exception;

    public ServcentVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ServcentDBParam params) throws Exception;

}
