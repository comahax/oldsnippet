/**
 * auto-generated code
 * Sat Aug 13 12:50:41 CST 2011
 */
package com.gmcc.pboss.control.sales.disformprint;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.disformprint.DisformprintDBParam;
import com.gmcc.pboss.business.sales.disformprint.DisformprintVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Disformprint </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public interface Disformprint extends AbstractControl {
    public DisformprintVO doCreate(DisformprintVO vo) throws Exception;

    public void doRemoveByVO(DisformprintVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public DisformprintVO doUpdate(DisformprintVO vo) throws Exception;

    public DisformprintVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(DisformprintDBParam params) throws Exception;
    
    public DataPackage doCountyComStat(DisformprintDBParam params) throws Exception;
    
    public DataPackage doQueryDisformDetail(DisformprintDBParam params) throws Exception;
    
    public int doQueryEmptySpan() throws Exception;

}
