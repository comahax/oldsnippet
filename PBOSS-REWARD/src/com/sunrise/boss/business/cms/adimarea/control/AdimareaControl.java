/**
 * auto-generated code
 * Thu Apr 05 10:00:59 CST 2007
 */
package com.sunrise.boss.business.cms.adimarea.control;

import java.io.Serializable;
import java.util.List;

import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaListVO;
import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: AdimareaControl
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author Ye Daoe
 * @version 1.0
 */
public interface AdimareaControl extends AbstractControl {
	public AdimareaVO doCreate(AdimareaVO vo, User user) throws Exception;

	public void doRemove(AdimareaVO vo, User user) throws Exception;

	public AdimareaVO doUpdate(AdimareaVO vo, User user) throws Exception;

	public AdimareaVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(AdimareaListVO params, User user) throws Exception;
	
	public DataPackage doQueryByOprcode(AdimareaListVO params, User user) throws Exception;
	
	public AdimareaVO doChangeStatus(AdimareaVO vo, User user) throws Exception;
	
	public boolean judgeIfReasonable(AdimareaListVO params,String contentuppercode,User user) 
		throws Exception;

	public Long doAddupTotalppn(AdimareaListVO listvo, User user) throws Exception;

	public Long doAddupResippn(AdimareaListVO listvo, User user) throws Exception;

	public Long doAddupNonresippn(AdimareaListVO listvo, User user) throws Exception;

	public Long doAddupAdarea(AdimareaListVO listvo, User user) throws Exception;

	public Long doAddupGmccusers(AdimareaListVO listvo, User user) throws Exception;

	public Long doAddupCucusers(AdimareaListVO listvo, User user) throws Exception;

	public Long doAddupCtcusers(AdimareaListVO listvo, User user) throws Exception;

	public Long doAddupHandphones(AdimareaListVO listvo, User user) throws Exception;
	
	public List doQueryUpperada(String adacode,User user) throws Exception;
	
	public void doChgAdacodeofOrg(String orgcode,String adacode,User user) throws Exception;
}
