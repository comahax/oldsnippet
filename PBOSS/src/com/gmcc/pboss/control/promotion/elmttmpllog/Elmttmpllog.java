/**
 * auto-generated code
 * Mon Sep 14 14:23:48 CST 2009
 */
package com.gmcc.pboss.control.promotion.elmttmpllog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.elmttmpllog.ElmttmpllogDBParam;
import com.gmcc.pboss.business.promotion.elmttmpllog.ElmttmpllogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Elmttmpllog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author linli
 * @version 1.0
 */
public interface Elmttmpllog extends AbstractControl {
    public ElmttmpllogVO doCreate(ElmttmpllogVO vo) throws Exception;

    public void doRemoveByVO(ElmttmpllogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ElmttmpllogVO doUpdate(ElmttmpllogVO vo) throws Exception;

    public ElmttmpllogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ElmttmpllogDBParam params) throws Exception;

}
