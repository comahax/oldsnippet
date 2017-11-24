/**
 * auto-generated code
 * Thu Jan 26 11:26:19 CST 2012
 */
package com.gmcc.pboss.control.sales.sellnotice;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.sellnotice.SellnoticeDBParam;
import com.gmcc.pboss.business.sales.sellnotice.SellnoticeVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Sellnotice </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public interface Sellnotice extends AbstractControl {
    public SellnoticeVO doCreate(SellnoticeVO vo) throws Exception;

    public void doRemoveByVO(SellnoticeVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SellnoticeVO doUpdate(SellnoticeVO vo) throws Exception;

    public SellnoticeVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SellnoticeDBParam params) throws Exception;
    
    public DataPackage doQueryByNamedSqlQuery(String name, DBQueryParam param) throws Exception;
    
    //网点销售进度查询
    public DataPackage doWayList(DataPackage tmp) throws Exception;
    
    //渠道经理销售进度查询
    public DataPackage doWayMagList(DataPackage tmp) throws Exception;
    
    //微区域销售进度查询
    public DataPackage doMareacodeList(DataPackage tmp) throws Exception;
    
    //分公司销售进度查询
    public DataPackage doCountyList(DataPackage tmp) throws Exception;

}
