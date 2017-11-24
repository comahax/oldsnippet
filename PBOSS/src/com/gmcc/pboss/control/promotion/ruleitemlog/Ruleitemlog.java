/**
 * auto-generated code
 * Thu Sep 17 14:55:03 CST 2009
 */
package com.gmcc.pboss.control.promotion.ruleitemlog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.ruleitemlog.RuleitemlogDBParam;
import com.gmcc.pboss.business.promotion.ruleitemlog.RuleitemlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Ruleitemlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Ruleitemlog extends AbstractControl {
    public RuleitemlogVO doCreate(RuleitemlogVO vo) throws Exception;

    public void doRemoveByVO(RuleitemlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RuleitemlogVO doUpdate(RuleitemlogVO vo) throws Exception;

    public RuleitemlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RuleitemlogDBParam params) throws Exception;

}
