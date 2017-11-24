/**
 * auto-generated code
 * Thu Dec 09 16:37:06 CST 2010
 */
package com.gmcc.pboss.control.base.webfunctionitemlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.webfunctionitemlog.WebfunctionitemlogDBParam;
import com.gmcc.pboss.business.base.webfunctionitemlog.WebfunctionitemlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Webfunctionitemlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public interface Webfunctionitemlog extends AbstractControl {
    public WebfunctionitemlogVO doCreate(WebfunctionitemlogVO vo) throws Exception;

    public void doRemoveByVO(WebfunctionitemlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WebfunctionitemlogVO doUpdate(WebfunctionitemlogVO vo) throws Exception;

    public WebfunctionitemlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WebfunctionitemlogDBParam params) throws Exception;

}
