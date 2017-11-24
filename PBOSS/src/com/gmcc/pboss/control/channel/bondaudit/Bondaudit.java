/**
 * auto-generated code
 * Thu Dec 29 17:51:44 CST 2011
 */
package com.gmcc.pboss.control.channel.bondaudit;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.bondaudit.BondauditDAO;
import com.gmcc.pboss.business.channel.bondaudit.BondauditDBParam;
import com.gmcc.pboss.business.channel.bondaudit.BondauditVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Bondaudit </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public interface Bondaudit extends AbstractControl {
    public BondauditVO doCreate(BondauditVO vo) throws Exception;

    public void doRemoveByVO(BondauditVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public BondauditVO doUpdate(BondauditVO vo) throws Exception;

    public BondauditVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(BondauditDBParam params) throws Exception;

    public String doQuerySeq() throws Exception ;
}
