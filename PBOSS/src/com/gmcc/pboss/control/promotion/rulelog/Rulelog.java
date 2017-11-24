/**
 * auto-generated code
 * Thu Sep 17 14:57:06 CST 2009
 */
package com.gmcc.pboss.control.promotion.rulelog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.rulelog.RulelogDBParam;
import com.gmcc.pboss.business.promotion.rulelog.RulelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Rulelog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Rulelog extends AbstractControl {
    public RulelogVO doCreate(RulelogVO vo) throws Exception;

    public void doRemoveByVO(RulelogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RulelogVO doUpdate(RulelogVO vo) throws Exception;

    public RulelogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RulelogDBParam params) throws Exception;

}
