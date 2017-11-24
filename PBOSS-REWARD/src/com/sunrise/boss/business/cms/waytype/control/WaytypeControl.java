/**
* auto-generated code
* Fri Aug 25 11:24:52 CST 2006
*/
package com.sunrise.boss.business.cms.waytype.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waytype.persistent.WaytypeVO;
import com.sunrise.boss.business.cms.waytype.persistent.WaytypeListVO;

import java.io.Serializable;

/**
 * <p>Title: WaytypeControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public interface WaytypeControl extends AbstractControl {
    public WaytypeVO doCreate(WaytypeVO vo, User user)
        throws Exception;

    public void doRemove(WaytypeVO vo, User user)
        throws Exception;

    public WaytypeVO doUpdate(WaytypeVO vo, User user)
        throws Exception;

    public WaytypeVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(WaytypeListVO params, User user)
        throws Exception;

	public  boolean isAGBranch(String subType, User user) throws Exception;

	public  boolean isAG(String type, User user) throws Exception;

	public  boolean isETBranch(String subType, User user) throws Exception;

	public  boolean isET(String type, User user) throws Exception;

}
