/**
 * auto-generated code
 * Mon Sep 14 14:22:16 CST 2009
 */
package com.gmcc.pboss.control.promotion.elmttmpl;

import java.io.Serializable;
import com.gmcc.pboss.business.promotion.elmttmpl.ElmttmplDBParam;
import com.gmcc.pboss.business.promotion.elmttmpl.ElmttmplVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Elmttmpl </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author linli
 * @version 1.0
 */
public interface Elmttmpl extends AbstractControl {
    public ElmttmplVO doCreate(ElmttmplVO vo) throws Exception;

    public void doRemoveByVO(ElmttmplVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ElmttmplVO doUpdate(ElmttmplVO vo) throws Exception;

    public ElmttmplVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ElmttmplDBParam params) throws Exception;
}
