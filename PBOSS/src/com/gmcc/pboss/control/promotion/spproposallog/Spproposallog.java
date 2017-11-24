/**
 * auto-generated code
 * Thu Sep 17 14:53:18 CST 2009
 */
package com.gmcc.pboss.control.promotion.spproposallog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.spproposallog.SpproposallogDBParam;
import com.gmcc.pboss.business.promotion.spproposallog.SpproposallogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Spproposallog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Spproposallog extends AbstractControl {
    public SpproposallogVO doCreate(SpproposallogVO vo) throws Exception;

    public void doRemoveByVO(SpproposallogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SpproposallogVO doUpdate(SpproposallogVO vo) throws Exception;

    public SpproposallogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SpproposallogDBParam params) throws Exception;

}
