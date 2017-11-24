/**
 * auto-generated code
 * Wed Oct 07 13:35:00 CST 2009
 */
package com.gmcc.pboss.control.channel.cooperator;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.cooperator.CooperatorDBParam;
import com.gmcc.pboss.business.channel.cooperator.CooperatorVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Cooperator </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Cooperator extends AbstractControl {
    public CooperatorVO doCreate(CooperatorVO vo) throws Exception;

    public void doRemoveByVO(CooperatorVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CooperatorVO doUpdate(CooperatorVO vo) throws Exception;

    public CooperatorVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CooperatorDBParam params) throws Exception;

}
