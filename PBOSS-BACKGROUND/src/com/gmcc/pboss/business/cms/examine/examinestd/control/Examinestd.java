package com.gmcc.pboss.business.cms.examine.examinestd.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.examinestd.persistent.ExaminestdListVO;
import com.gmcc.pboss.business.cms.examine.examinestd.persistent.ExaminestdVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;


/**
 * <p>Title: ExaminestdControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Examinestd extends AbstractControl {
    public ExaminestdVO doCreate(ExaminestdVO vo)
        throws Exception;

    public void doRemove(ExaminestdVO vo)
        throws Exception;

    public ExaminestdVO doUpdate(ExaminestdVO vo)
        throws Exception;

    public ExaminestdVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(ExaminestdListVO params)
        throws Exception;

}
