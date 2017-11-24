/**
 * auto-generated code
 * Thu Jan 26 11:27:21 CST 2012
 */
package com.gmcc.pboss.control.sales.sellnoticelog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.sellnoticelog.SellnoticelogDBParam;
import com.gmcc.pboss.business.sales.sellnoticelog.SellnoticelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Sellnoticelog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public interface Sellnoticelog extends AbstractControl {
    public SellnoticelogVO doCreate(SellnoticelogVO vo) throws Exception;

    public void doRemoveByVO(SellnoticelogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SellnoticelogVO doUpdate(SellnoticelogVO vo) throws Exception;

    public SellnoticelogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SellnoticelogDBParam params) throws Exception;

}
