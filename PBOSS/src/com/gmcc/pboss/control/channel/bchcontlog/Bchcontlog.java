/**
 * auto-generated code
 * Sun Oct 18 20:53:55 CST 2009
 */
package com.gmcc.pboss.control.channel.bchcontlog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.bchcontlog.BchcontlogDBParam;
import com.gmcc.pboss.business.channel.bchcontlog.BchcontlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Bchcontlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Bchcontlog extends AbstractControl {
    public BchcontlogVO doCreate(BchcontlogVO vo) throws Exception;

    public void doRemoveByVO(BchcontlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public BchcontlogVO doUpdate(BchcontlogVO vo) throws Exception;

    public BchcontlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(BchcontlogDBParam params) throws Exception;

}
