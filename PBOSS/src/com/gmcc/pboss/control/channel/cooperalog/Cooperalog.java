/**
 * auto-generated code
 * Thu Aug 12 18:07:03 CST 2010
 */
package com.gmcc.pboss.control.channel.cooperalog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.cooperalog.CooperalogDBParam;
import com.gmcc.pboss.business.channel.cooperalog.CooperalogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Cooperalog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
public interface Cooperalog extends AbstractControl {
    public CooperalogVO doCreate(CooperalogVO vo) throws Exception;

    public void doRemoveByVO(CooperalogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CooperalogVO doUpdate(CooperalogVO vo) throws Exception;

    public CooperalogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CooperalogDBParam params) throws Exception;

}
