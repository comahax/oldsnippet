/**
 * auto-generated code
 * Mon Nov 30 15:49:57 CST 2009
 */
package com.gmcc.pboss.control.sales.reqcomcate;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import com.gmcc.pboss.business.sales.reqcomcate.ReqcomcateDBParam;
import com.gmcc.pboss.business.sales.reqcomcate.ReqcomcateVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Reqcomcate </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Reqcomcate extends AbstractControl {
    public ReqcomcateVO doCreate(ReqcomcateVO vo) throws Exception;

    public void doRemoveByVO(ReqcomcateVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ReqcomcateVO doUpdate(ReqcomcateVO vo) throws Exception;

    public ReqcomcateVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ReqcomcateDBParam params) throws Exception;
    
    public void doBuildOrderList(String wayid, String mobile, String orderid, Map<String, Integer> dataMap, Date date) throws Exception;

}
