package com.sunrise.boss.business.cms.way.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactVO;
import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorVO;
import com.sunrise.boss.business.cms.way.persistent.AGWayVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountVO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.ui.commons.User;

public interface AGWayControl extends AbstractControl {
	public int doCreate(AGWayVO vo, User user) throws Exception;

	public int doUpdate(AGWayVO vo, User user) throws Exception;

	public void doDelete(WayVO vo, User user) throws Exception;

	public WayVO doFindByPk(Serializable pk, User user) throws Exception;

	/**
	 * 新增社会渠道信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean doAgcreate(WayVO newVO, CooperatorVO cooperatorvo,
			WaycompactVO waycompactvo, WayaccountVO wayaccountvo,
			BchcontactVO bchcontactvo, User user) throws Exception;

	/**
	 * 修改社会渠道信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean doAgupdate(WayVO oldVO, WayVO newVO,
			CooperatorVO cooperatorvo, WaycompactVO waycompactvo,
			WayaccountVO wayaccountvo, BchcontactVO bchcontactvo,
			boolean upperwayfalg, User user) throws Exception;

	public void doSetservice(String wayid, User user) throws Exception;

	public boolean doCancelService(String employeeID, User user)
			throws Exception;

	public boolean doHasRecords(String employieeID, User user) throws Exception;
}
