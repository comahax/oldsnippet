/**
 * auto-generated code
 * Fri Jun 25 10:45:52 CST 2010
 */
package com.gmcc.pboss.control.sales.alaordercol;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.alaordercol.AlaordercolDBParam;
import com.gmcc.pboss.business.sales.alaordercol.AlaordercolVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Alaordercol </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface Alaordercol extends AbstractControl {
    public AlaordercolVO doCreate(AlaordercolVO vo) throws Exception;

    public void doRemoveByVO(AlaordercolVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public AlaordercolVO doUpdate(AlaordercolVO vo) throws Exception;

    public AlaordercolVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(AlaordercolDBParam params) throws Exception;
    public DataPackage doGroupQuery(AlaordercolDBParam params) throws Exception ;

}
