package com.gmcc.pboss.control.resource.resalarmrulelog;


import java.io.Serializable;

import com.gmcc.pboss.business.resource.resalarmrulelog.ResalarmrulelogDBParam;
import com.gmcc.pboss.business.resource.resalarmrulelog.ResalarmrulelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Resalarmrulelog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Resalarmrulelog extends AbstractControl {
    public ResalarmrulelogVO doCreate(ResalarmrulelogVO vo) throws Exception;

    public void doRemoveByVO(ResalarmrulelogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ResalarmrulelogVO doUpdate(ResalarmrulelogVO vo) throws Exception;

    public ResalarmrulelogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ResalarmrulelogDBParam params) throws Exception;

}
