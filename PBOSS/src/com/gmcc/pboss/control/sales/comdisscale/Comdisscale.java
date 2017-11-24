/**
 * auto-generated code
 * Fri Jun 25 09:24:18 CST 2010
 */
package com.gmcc.pboss.control.sales.comdisscale;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.comdisscale.ComdisscaleDBParam;
import com.gmcc.pboss.business.sales.comdisscale.ComdisscaleVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Comdisscale </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zhangsiwei
 * @version 1.0
 */
public interface Comdisscale extends AbstractControl {
    public ComdisscaleVO doCreate(ComdisscaleVO vo) throws Exception;

    public void doRemoveByVO(ComdisscaleVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ComdisscaleVO doUpdate(ComdisscaleVO vo) throws Exception;

    public ComdisscaleVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ComdisscaleDBParam params) throws Exception;
    
    public boolean checkDisscale(ComdisscaleVO vo) throws Exception;
    
    public boolean isExist(ComdisscaleVO vo) throws Exception;

    public DataPackage isExistb(ComdisscaleVO vo) throws Exception;

    public boolean checkRale(ComdisscaleVO vo) throws Exception;
}
