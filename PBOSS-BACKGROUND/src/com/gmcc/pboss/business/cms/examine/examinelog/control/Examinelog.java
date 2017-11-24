package com.gmcc.pboss.business.cms.examine.examinelog.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.examinelog.persistent.ExaminelogListVO;
import com.gmcc.pboss.business.cms.examine.examinelog.persistent.ExaminelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ExaminelogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Examinelog extends AbstractControl {
    public ExaminelogVO doCreate(ExaminelogVO vo)
        throws Exception;

    public void doRemove(ExaminelogVO vo)
        throws Exception;

    public ExaminelogVO doUpdate(ExaminelogVO vo)
        throws Exception;

    public ExaminelogVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(ExaminelogListVO params)
        throws Exception;

}
