/**
 * auto-generated code
 * Fri Mar 04 17:20:29 CST 2011
 */
package com.gmcc.pboss.control.channel.emodconfirm;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.emodconfirm.EmodconfirmDBParam;
import com.gmcc.pboss.business.channel.emodconfirm.EmodconfirmVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Emodconfirm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public interface Emodconfirm extends AbstractControl {
    public EmodconfirmVO doCreate(EmodconfirmVO vo) throws Exception;

    public void doRemoveByVO(EmodconfirmVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public EmodconfirmVO doUpdate(EmodconfirmVO vo) throws Exception;

    public EmodconfirmVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(EmodconfirmDBParam params) throws Exception;

}
