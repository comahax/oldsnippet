package com.gmcc.pboss.business.cms.examine.examine.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.examine.persistent.ExamineListVO;
import com.gmcc.pboss.business.cms.examine.examine.persistent.ExamineVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ExamineControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ExamineControl extends AbstractControl {
    public ExamineVO doCreate(ExamineVO vo)
        throws Exception;

    public void doRemove(ExamineVO vo)
        throws Exception;

    public ExamineVO doUpdate(ExamineVO vo)
        throws Exception;

    public ExamineVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(ExamineListVO params)
        throws Exception;
    public void doRemoveExamine(String selectValue)
    throws Exception;
    public DataPackage doQueryBySqlName(String sqlName,ExamineListVO param) 
    throws Exception;
    
    public DataPackage doQueryBySql(String queryString,ExamineListVO params) throws Exception;
}
