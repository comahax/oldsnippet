/**
 * auto-generated code
 * Fri Sep 25 15:12:44 CST 2009
 */
package com.gmcc.pboss.control.resource.compacklog;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.compacklog.CompacklogDBParam;
import com.gmcc.pboss.business.resource.compacklog.CompacklogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Compacklog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Compacklog extends AbstractControl {
    public CompacklogVO doCreate(CompacklogVO vo) throws Exception;

    public void doRemoveByVO(CompacklogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CompacklogVO doUpdate(CompacklogVO vo) throws Exception;

    public CompacklogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CompacklogDBParam params) throws Exception;

}
