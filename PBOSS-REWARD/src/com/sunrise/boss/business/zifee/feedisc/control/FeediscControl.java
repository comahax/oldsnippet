/**
 * auto-generated code
 * Wed Aug 23 16:41:06 CST 2006
 */
package com.sunrise.boss.business.zifee.feedisc.control;

import java.rmi.*;
import java.io.Serializable;

import com.sunrise.boss.business.zifee.feedisc.persistent.FeediscListVO;
import com.sunrise.boss.business.zifee.feedisc.persistent.FeediscVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.zifee.commons.ResultBean;

/**
 * <p>
 * Title: FeediscControl
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
 * @author feedisc
 * @version 1.0
 */
public interface FeediscControl extends AbstractControl {
	public FeediscVO doCreate(FeediscVO vo, User user) throws Exception;

	public void doRemove(FeediscVO vo, User user) throws Exception;

	public FeediscVO doUpdate(FeediscVO vo, User user) throws Exception;

	public FeediscVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(FeediscListVO params, User user)
			throws Exception;

	public ResultBean doCheck(String[] fields, User user) throws Exception;

	public FeediscVO buildVO(String[] fields, User user) throws Exception;

	/**
	 * 批量新增
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public FeediscVO doBatchCreate(FeediscVO vo, User user) throws Exception;

	/**
	 * 批量更新
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public FeediscVO doBatchUpdate(FeediscVO vo, User user) throws Exception;
}
