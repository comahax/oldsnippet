/**
 * auto-generated code
 * Thu Sep 17 14:50:45 CST 2009
 */
package com.gmcc.pboss.control.promotion.rule;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.rule.RuleDBParam;
import com.gmcc.pboss.business.promotion.rule.RuleVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Rule </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Rule extends AbstractControl {
    public RuleVO doCreate(RuleVO vo) throws Exception;

    public void doRemoveByVO(RuleVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RuleVO doUpdate(RuleVO vo) throws Exception;

    public RuleVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RuleDBParam params) throws Exception;

}
