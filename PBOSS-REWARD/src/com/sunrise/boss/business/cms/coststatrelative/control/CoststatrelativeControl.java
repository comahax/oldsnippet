/**
 * auto-generated code
 * Tue May 01 15:39:58 CST 2007
 */
package com.sunrise.boss.business.cms.coststatrelative.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.coststatrelative.persistent.CoststatrelativeVO;
import com.sunrise.boss.business.cms.coststatrelative.persistent.CoststatrelativeListVO;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * Title: CoststatrelativeControl
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
 * @author Cai Jianhui
 * @version 1.0
 */
public interface CoststatrelativeControl extends AbstractControl {
	public CoststatrelativeVO doCreate(CoststatrelativeVO vo, User user)
			throws Exception;

	public void doRemove(CoststatrelativeVO vo, User user) throws Exception;

	public CoststatrelativeVO doUpdate(CoststatrelativeVO vo, User user)
			throws Exception;

	public CoststatrelativeVO doFindByPk(Serializable pk, User user)
			throws Exception;

	public DataPackage doQuery(CoststatrelativeListVO params, User user)
			throws Exception;

	public void doSave(List strtitem, List scaleitem, Long ID, User user)
			throws Exception;
}
