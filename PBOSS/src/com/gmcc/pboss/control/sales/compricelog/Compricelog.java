/**
 * auto-generated code
 * Thu Jul 01 16:47:05 CST 2010
 */
package com.gmcc.pboss.control.sales.compricelog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.compricelog.CompricelogDBParam;
import com.gmcc.pboss.business.sales.compricelog.CompricelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Compricelog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface Compricelog extends AbstractControl {
    public CompricelogVO doCreate(CompricelogVO vo) throws Exception;

    public void doRemoveByVO(CompricelogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CompricelogVO doUpdate(CompricelogVO vo) throws Exception;

    public CompricelogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CompricelogDBParam params) throws Exception;

}
