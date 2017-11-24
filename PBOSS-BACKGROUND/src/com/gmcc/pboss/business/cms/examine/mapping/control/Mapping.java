package com.gmcc.pboss.business.cms.examine.mapping.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.mapping.persistent.MappingListVO;
import com.gmcc.pboss.business.cms.examine.mapping.persistent.MappingVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: MappingControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Mapping extends AbstractControl {
    public MappingVO doCreate(MappingVO vo)
        throws Exception;

    public void doRemove(MappingVO vo)
        throws Exception;

    public MappingVO doUpdate(MappingVO vo)
        throws Exception;

    public MappingVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(MappingListVO params)
        throws Exception;

    public String doQueryToCheck(MappingListVO params) throws Exception ;

}
