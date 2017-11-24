package com.gmcc.pboss.control.channel.way;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.bchcontact.BchcontactVO;
import com.gmcc.pboss.business.channel.cooperator.CooperatorVO;
import com.gmcc.pboss.business.channel.way.AGWayVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.channel.waycompact.WaycompactVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;

public interface AGWay extends AbstractControl {
	
	public int doCreate(AGWayVO vo, DBAccessUser user) throws Exception;

	public int doUpdate(AGWayVO vo, DBAccessUser user) throws Exception;

	public void doDelete(WayVO vo, DBAccessUser user) throws Exception;

	public WayVO doFindByPk(Serializable pk, DBAccessUser user) throws Exception;

	/**
	 * 新增社会渠道信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean doAgcreate(WayVO newVO, CooperatorVO cooperatorvo,
			WaycompactVO waycompactvo, WayaccountVO wayaccountvo,
			BchcontactVO bchcontactvo, DBAccessUser user) throws Exception;

	/**
	 * 修改社会渠道信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean doAgupdate(WayVO oldVO, WayVO newVO,
			CooperatorVO cooperatorvo, WaycompactVO waycompactvo,
			WayaccountVO wayaccountvo, BchcontactVO bchcontactvo,
			boolean upperwayfalg, DBAccessUser user) throws Exception;

	public void doSetservice(String wayid, DBAccessUser user) throws Exception;

	public boolean doCancelService(String employeeID, DBAccessUser user, String flag)
			throws Exception;

	public boolean doHasRecords(String employieeID, DBAccessUser user) throws Exception;
	
	public WayVO doLogsCreate(AGWayVO vo, DBAccessUser user) throws Exception;
	
	public WayVO doLogsUpdate(AGWayVO vo, DBAccessUser user) throws Exception ;
	
	public WayVO doEditLogs(WayVO oldVO, AGWayVO agvo, DBAccessUser user) throws Exception;
	
	public int doUpdateState(AGWayVO vo, DBAccessUser user) throws Exception;
}
