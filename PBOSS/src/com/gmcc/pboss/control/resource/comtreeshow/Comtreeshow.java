/**
 * auto-generated code
 * Wed Sep 09 09:21:23 CST 2009
 */
package com.gmcc.pboss.control.resource.comtreeshow;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.comtreeshow.ComtreeshowDBParam;
import com.gmcc.pboss.business.resource.comtreeshow.ComtreeshowVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Comtreeshow </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author linli
 * @version 1.0
 */
public interface Comtreeshow extends AbstractControl {
    public ComtreeshowVO doCreate(ComtreeshowVO vo) throws Exception;

    public void doRemoveByVO(ComtreeshowVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ComtreeshowVO doUpdate(ComtreeshowVO vo) throws Exception;

    public ComtreeshowVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ComtreeshowDBParam params) throws Exception;

}
