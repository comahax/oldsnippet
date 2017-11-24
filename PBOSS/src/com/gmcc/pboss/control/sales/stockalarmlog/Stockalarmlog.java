/**
 * auto-generated code
 * Wed Jun 23 08:53:40 CST 2010
 */
package com.gmcc.pboss.control.sales.stockalarmlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.stockalarmlog.StockalarmlogDBParam;
import com.gmcc.pboss.business.sales.stockalarmlog.StockalarmlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Stockalarmlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Stockalarmlog extends AbstractControl {
    public StockalarmlogVO doCreate(StockalarmlogVO vo) throws Exception;

    public void doRemoveByVO(StockalarmlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public StockalarmlogVO doUpdate(StockalarmlogVO vo) throws Exception;

    public StockalarmlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(StockalarmlogDBParam params) throws Exception;

}
