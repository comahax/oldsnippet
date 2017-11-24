/**
 * auto-generated code
 * Wed Oct 21 19:54:26 CST 2009
 */
package com.gmcc.pboss.control.channel.custwaytype;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeDBParam;
import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Custwaytype </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Custwaytype extends AbstractControl {
    public CustwaytypeVO doCreate(CustwaytypeVO vo) throws Exception;

    public void doRemoveByVO(CustwaytypeVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CustwaytypeVO doUpdate(CustwaytypeVO vo) throws Exception;

    public CustwaytypeVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CustwaytypeDBParam params) throws Exception;

}
