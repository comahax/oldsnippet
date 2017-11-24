package com.gmcc.pboss.business.cms.examine.examinestdlog.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.examinestdlog.persistent.ExaminestdlogListVO;
import com.gmcc.pboss.business.cms.examine.examinestdlog.persistent.ExaminestdlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ExaminestdlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Examinestdlog extends AbstractControl {
    public ExaminestdlogVO doCreate(ExaminestdlogVO vo)
        throws Exception;

    public void doRemove(ExaminestdlogVO vo)
        throws Exception;

    public ExaminestdlogVO doUpdate(ExaminestdlogVO vo)
        throws Exception;

    public ExaminestdlogVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(ExaminestdlogListVO params)
        throws Exception;

}
