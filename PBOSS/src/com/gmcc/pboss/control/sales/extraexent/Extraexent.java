/**
 * auto-generated code
 * Thu Jun 16 17:11:00 CST 2011
 */
package com.gmcc.pboss.control.sales.extraexent;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.extraexent.ExtraexentDBParam;
import com.gmcc.pboss.business.sales.extraexent.ExtraexentVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Extraexent </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public interface Extraexent extends AbstractControl {
    public ExtraexentVO doCreate(ExtraexentVO vo) throws Exception;

    public void doRemoveByVO(ExtraexentVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ExtraexentVO doUpdate(ExtraexentVO vo) throws Exception;

    public ExtraexentVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ExtraexentDBParam params) throws Exception;

}
