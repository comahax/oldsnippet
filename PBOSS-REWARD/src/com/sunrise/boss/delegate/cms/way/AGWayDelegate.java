package com.sunrise.boss.delegate.cms.way;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactVO;
import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorVO;
import com.sunrise.boss.business.cms.way.control.AGWayControl;
import com.sunrise.boss.business.cms.way.control.AGWayControlBean;
import com.sunrise.boss.business.cms.way.persistent.AGWayVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountVO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

public class AGWayDelegate {
	private static AGWayControl control;

	public AGWayDelegate() throws Exception {
		control = (AGWayControl) ControlFactory.build(AGWayControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public int doCreate(AGWayVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public int doUpdate(AGWayVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public void doDelete(WayVO vo, User user) throws Exception {
		control.doDelete(vo, user);
	}

	public WayVO doFindByPk(Serializable pk, User user) throws Exception {
		return control.doFindByPk(pk, user);
	}

	/**
	 * 新增社会渠道信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean doAgcreate(WayVO newVO, CooperatorVO cooperatorvo,
			WaycompactVO waycompactvo, WayaccountVO wayaccountvo,
			BchcontactVO bchcontactvo, User user) throws Exception {
		return control.doAgcreate(newVO, cooperatorvo, waycompactvo,
				wayaccountvo, bchcontactvo, user);
	}

	/**
	 * 修改社会渠道信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean doAgupdate(WayVO oldVO, WayVO newVO,
			CooperatorVO cooperatorvo, WaycompactVO waycompactvo,
			WayaccountVO wayaccountvo, BchcontactVO bchcontactvo,
			boolean upperwayfalg, User user) throws Exception {
		return control.doAgupdate(oldVO, newVO, cooperatorvo, waycompactvo,
				wayaccountvo, bchcontactvo, upperwayfalg, user);
	}

	public void doSetservice(String wayid, User user) throws Exception {
		control.doSetservice(wayid, user);
	}

	public boolean doCancelService(String employeeID, User user)
			throws Exception {
		return control.doCancelService(employeeID, user);
	}

	public boolean doHasRecords(String employeeID, User user) throws Exception {
		return control.doHasRecords(employeeID, user);
	}
}
