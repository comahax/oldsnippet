/**
 * auto-generated code
 * Wed Jun 23 08:53:23 CST 2010
 */
package com.gmcc.pboss.control.sales.stockalarm;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.stockalarm.StockalarmDBParam;
import com.gmcc.pboss.business.sales.stockalarm.StockalarmVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Stockalarm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Stockalarm extends AbstractControl {
    public StockalarmVO doCreate(StockalarmVO vo) throws Exception;

    public void doRemoveByVO(StockalarmVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public StockalarmVO doUpdate(StockalarmVO vo) throws Exception;

    public StockalarmVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(StockalarmDBParam params) throws Exception;

}
