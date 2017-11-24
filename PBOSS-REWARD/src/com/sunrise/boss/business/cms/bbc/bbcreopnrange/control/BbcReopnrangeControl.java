/**
 * auto-generated code
 * Sun Aug 15 11:34:09 CST 2010
 */
package com.sunrise.boss.business.cms.bbc.bbcreopnrange.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.bbcreopnrange.persistent.BbcReopnrangeVO;
import com.sunrise.boss.business.cms.bbc.bbcreopnrange.persistent.BbcReopnrangeListVO;

import java.io.Serializable;

/**
 * <p>Title: BbcReopnrangeControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface BbcReopnrangeControl extends AbstractControl {
	public BbcReopnrangeVO doCreate(BbcReopnrangeVO vo, User user)
			throws Exception;

	public void doRemove(BbcReopnrangeVO vo, User user) throws Exception;

	public BbcReopnrangeVO doUpdate(BbcReopnrangeVO vo, User user)
			throws Exception;

	public BbcReopnrangeVO doFindByPk(Serializable pk, User user)
			throws Exception;

	public DataPackage doQuery(BbcReopnrangeListVO params, User user)
			throws Exception;

	public DataPackage doQueryopnid(BbcReopnrangeListVO params, String opnid,
			String resertype, User user) throws Exception;

	public DataPackage doQueryrange(BbcReopnrangeListVO params,
			String resertype, User user) throws Exception;
}
