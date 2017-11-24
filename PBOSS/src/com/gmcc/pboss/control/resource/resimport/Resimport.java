/**
 * auto-generated code
 * Fri Sep 25 15:01:17 CST 2009
 */
package com.gmcc.pboss.control.resource.resimport;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.resimport.ResimportDBParam;
import com.gmcc.pboss.business.resource.resimport.ResimportVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Resimport </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Resimport extends AbstractControl {
    public ResimportVO doCreate(ResimportVO vo) throws Exception;

    public void doRemoveByVO(ResimportVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ResimportVO doUpdate(ResimportVO vo) throws Exception;

    public ResimportVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ResimportDBParam params) throws Exception;

}
