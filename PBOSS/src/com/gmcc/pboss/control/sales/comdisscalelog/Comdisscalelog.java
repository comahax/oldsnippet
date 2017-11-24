/**
 * auto-generated code
 * Thu Jul 01 16:27:16 CST 2010
 */
package com.gmcc.pboss.control.sales.comdisscalelog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.comdisscalelog.ComdisscalelogDBParam;
import com.gmcc.pboss.business.sales.comdisscalelog.ComdisscalelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Comdisscalelog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Comdisscalelog extends AbstractControl {
    public ComdisscalelogVO doCreate(ComdisscalelogVO vo) throws Exception;

    public void doRemoveByVO(ComdisscalelogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ComdisscalelogVO doUpdate(ComdisscalelogVO vo) throws Exception;

    public ComdisscalelogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ComdisscalelogDBParam params) throws Exception;

}
