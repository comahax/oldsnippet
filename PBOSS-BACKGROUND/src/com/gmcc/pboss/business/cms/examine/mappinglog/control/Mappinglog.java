package com.gmcc.pboss.business.cms.examine.mappinglog.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.mappinglog.persistent.MappinglogListVO;
import com.gmcc.pboss.business.cms.examine.mappinglog.persistent.MappinglogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: MappinglogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Mappinglog extends AbstractControl {
    public MappinglogVO doCreate(MappinglogVO vo)
        throws Exception;

    public void doRemove(MappinglogVO vo)
        throws Exception;

    public MappinglogVO doUpdate(MappinglogVO vo)
        throws Exception;

    public MappinglogVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(MappinglogListVO params)
        throws Exception;

}
