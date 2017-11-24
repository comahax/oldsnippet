/**
 * auto-generated code
 * Mon Sep 04 20:34:08 CST 2006
 */
package com.sunrise.boss.business.zifee.eboxdisc.control;

import java.io.Serializable;

import com.sunrise.boss.business.zifee.eboxdisc.persistent.EboxdiscListVO;
import com.sunrise.boss.business.zifee.eboxdisc.persistent.EboxdiscVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.zifee.commons.ResultBean;

/**
 * <p>
 * Title: EboxdiscControl
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
 * @author eboxdisc
 * @version 1.0
 */
public interface EboxdiscControl extends AbstractControl {
	public EboxdiscVO doCreate(EboxdiscVO vo, User user) throws Exception;

	public void doRemove(EboxdiscVO vo, User user) throws Exception;

	public EboxdiscVO doUpdate(EboxdiscVO vo, User user) throws Exception;

	public EboxdiscVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(EboxdiscListVO params, User user)
			throws Exception;

	public DataPackage doBatchquery(EboxdiscListVO params, User user)
			throws Exception;

	public Long getEboxdiscSeq(User user) throws Exception;

	public EboxdiscVO buildVO(String[] fields, User user, String oprtype)
			throws Exception;

	public ResultBean doCheck(String[] fields, User user, String oprtype)
			throws Exception;

}
