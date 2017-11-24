package com.gmcc.pboss.control.resource.resalarmrule;


import java.io.Serializable;

import com.gmcc.pboss.business.resource.resalarmrule.ResalarmruleDBParam;
import com.gmcc.pboss.business.resource.resalarmrule.ResalarmruleVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Resalarmrule </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Resalarmrule extends AbstractControl {
    public ResalarmruleVO doCreate(ResalarmruleVO vo) throws Exception;

    public void doRemoveByVO(ResalarmruleVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ResalarmruleVO doUpdate(ResalarmruleVO vo) throws Exception;

    public ResalarmruleVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ResalarmruleDBParam params) throws Exception;

}
