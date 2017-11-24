/**
 * auto-generated code
 * Thu Sep 03 15:32:51 CST 2009
 */
package com.gmcc.pboss.control.base.dictitem;

import java.io.Serializable;
import java.util.Collection;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: Dictitem </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Dictitem extends AbstractControl {
    public DictitemVO doCreate(DictitemVO vo) throws Exception;

    public void doRemoveByVO(DictitemVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public DictitemVO doUpdate(DictitemVO vo) throws Exception;

    public DictitemVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(DictitemDBParam params) throws Exception;
    
    public Collection doFindAll(User user) throws Exception;

}
