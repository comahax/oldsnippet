/**
* auto-generated code
* Tue Nov 17 16:06:35 CST 2009
*/
package com.sunrise.boss.business.cms.examine.examinestd.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.examine.examinestd.persistent.ExaminestdListVO;
import com.sunrise.boss.business.cms.examine.examinestd.persistent.ExaminestdVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ExaminestdControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ExaminestdControl extends AbstractControl {
    public ExaminestdVO doCreate(ExaminestdVO vo, User user)
        throws Exception;

    public void doRemove(ExaminestdVO vo, User user)
        throws Exception;

    public ExaminestdVO doUpdate(ExaminestdVO vo, User user)
        throws Exception;

    public ExaminestdVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ExaminestdListVO params, User user)
        throws Exception;
    /**
     * 验证SQL合法
     */
    public int doValidateSQL(String sql, User user)throws Exception;
    public DataPackage doQueryExaminestdList(String exmnid, ExaminestdListVO params, User user)
    throws Exception ;

}
