/**
 * auto-generated code
 * Wed Feb 24 15:46:47 CST 2010
 */
package com.gmcc.pboss.business.cms.examine.exmnstddtl.control;

import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.exmnstddtl.persistent.ExmnstddtlListVO;
import com.gmcc.pboss.business.cms.examine.exmnstddtl.persistent.ExmnstddtlVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Exmnstddtl </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Exmnstddtl extends AbstractControl {
    public ExmnstddtlVO doCreate(ExmnstddtlVO vo) throws Exception;

    public void doRemoveByVO(ExmnstddtlVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ExmnstddtlVO doUpdate(ExmnstddtlVO vo) throws Exception;

    public ExmnstddtlVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ExmnstddtlListVO params) throws Exception;
    
    public DataPackage doQueryBySql(String queryString, ExmnstddtlListVO params) throws Exception;
    
    public DataPackage doQueryByNameSql(String queryString, ExmnstddtlListVO params) throws Exception;

}
