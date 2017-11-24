/**
 * auto-generated code
 * Mon Oct 19 19:01:27 CST 2009
 */
package com.gmcc.pboss.control.sales.activerate;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.activerate.ActiverateDBParam;
import com.gmcc.pboss.business.sales.activerate.ActiverateVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Activerate </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Activerate extends AbstractControl {
    public ActiverateVO doCreate(ActiverateVO vo) throws Exception;

    public void doRemoveByVO(ActiverateVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ActiverateVO doUpdate(ActiverateVO vo) throws Exception;

    public ActiverateVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ActiverateDBParam params) throws Exception;

}
