/**
 * auto-generated code
 * Mon Aug 16 15:40:34 CST 2010
 */
package com.gmcc.pboss.control.resource.resinfostat;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.resinfostat.ResinfostatDBParam;
import com.gmcc.pboss.business.resource.resinfostat.ResinfostatVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Resinfostat </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zhangsiwei
 * @version 1.0
 */
public interface Resinfostat extends AbstractControl {
    public ResinfostatVO doCreate(ResinfostatVO vo) throws Exception;

    public void doRemoveByVO(ResinfostatVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ResinfostatVO doUpdate(ResinfostatVO vo) throws Exception;

    public ResinfostatVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ResinfostatDBParam params) throws Exception;

}
