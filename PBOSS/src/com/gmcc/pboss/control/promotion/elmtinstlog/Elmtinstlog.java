/**
 * auto-generated code
 * Thu Sep 17 14:55:57 CST 2009
 */
package com.gmcc.pboss.control.promotion.elmtinstlog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.elmtinstlog.ElmtinstlogDBParam;
import com.gmcc.pboss.business.promotion.elmtinstlog.ElmtinstlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Elmtinstlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Elmtinstlog extends AbstractControl {
    public ElmtinstlogVO doCreate(ElmtinstlogVO vo) throws Exception;

    public void doRemoveByVO(ElmtinstlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ElmtinstlogVO doUpdate(ElmtinstlogVO vo) throws Exception;

    public ElmtinstlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ElmtinstlogDBParam params) throws Exception;

}
