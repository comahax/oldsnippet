/**
 * auto-generated code
 * Thu Dec 29 08:58:06 CST 2011
 */
package com.gmcc.pboss.control.channel.bondform;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.bondform.BondformDBParam;
import com.gmcc.pboss.business.channel.bondform.BondformVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;


/**
 * <p>Title: Bondform </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public interface Bondform extends AbstractControl {
    public BondformVO doCreate(BondformVO vo) throws Exception;

    public void doRemoveByVO(BondformVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public BondformVO doUpdate(BondformVO vo) throws Exception;

    public BondformVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(BondformDBParam params) throws Exception;
    
	public String doSubmitboss(String formid,String boss,User user) throws Exception ;
	
	public String doSendinfor(String formid,User user) throws Exception ;
	
	public String doMvaccount(String formid,User user) throws Exception;
		


}
