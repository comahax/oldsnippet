/**
 * auto-generated code
 * Wed Jul 01 17:31:08 CST 2009
 */
package com.gmcc.pboss.control.channel.bchcontact;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.bchcontact.BchcontactDBParam;
import com.gmcc.pboss.business.channel.bchcontact.BchcontactVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Bchcontact </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface Bchcontact extends AbstractControl {
    public BchcontactVO doCreate(BchcontactVO vo) throws Exception;

    public void doRemoveByVO(BchcontactVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public BchcontactVO doUpdate(BchcontactVO vo) throws Exception;

    public BchcontactVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(BchcontactDBParam params) throws Exception;

}
