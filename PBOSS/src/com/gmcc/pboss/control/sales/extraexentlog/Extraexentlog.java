/**
 * auto-generated code
 * Sun Jun 19 20:24:03 CST 2011
 */
package com.gmcc.pboss.control.sales.extraexentlog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.extraexentlog.ExtraexentlogDBParam;
import com.gmcc.pboss.business.sales.extraexentlog.ExtraexentlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Extraexentlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public interface Extraexentlog extends AbstractControl {
    public ExtraexentlogVO doCreate(ExtraexentlogVO vo) throws Exception;

    public void doRemoveByVO(ExtraexentlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ExtraexentlogVO doUpdate(ExtraexentlogVO vo) throws Exception;

    public ExtraexentlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ExtraexentlogDBParam params) throws Exception;

}
