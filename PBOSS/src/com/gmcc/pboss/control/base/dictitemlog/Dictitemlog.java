/**
 * auto-generated code
 * Mon Sep 07 10:52:58 CST 2009
 */
package com.gmcc.pboss.control.base.dictitemlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.dictitemlog.DictitemlogDBParam;
import com.gmcc.pboss.business.base.dictitemlog.DictitemlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Dictitemlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Dictitemlog extends AbstractControl {
    public DictitemlogVO doCreate(DictitemlogVO vo) throws Exception;

    public void doRemoveByVO(DictitemlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public DictitemlogVO doUpdate(DictitemlogVO vo) throws Exception;

    public DictitemlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(DictitemlogDBParam params) throws Exception;

}
