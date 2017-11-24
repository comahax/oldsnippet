/**
 * auto-generated code
 * Tue Dec 07 10:33:29 CST 2010
 */
package com.gmcc.pboss.control.base.webfunctionitem;

import java.io.Serializable;

import com.gmcc.pboss.business.base.webfunctionitem.WebfunctionitemDBParam;
import com.gmcc.pboss.business.base.webfunctionitem.WebfunctionitemVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Webfunctionitem </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public interface Webfunctionitem extends AbstractControl {
    public WebfunctionitemVO doCreate(WebfunctionitemVO vo) throws Exception;

    public void doRemoveByVO(WebfunctionitemVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WebfunctionitemVO doUpdate(WebfunctionitemVO vo) throws Exception;

    public WebfunctionitemVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WebfunctionitemDBParam params) throws Exception;
    
    public DataPackage doQueryByNameSql(String querySqlName,WebfunctionitemDBParam param)  throws Exception;
    
    public DataPackage doQueryText(String queryText) throws Exception;

}
