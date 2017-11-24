/**
 * auto-generated code
 * Wed Oct 28 16:03:20 CST 2009
 */
package com.gmcc.pboss.control.channel.wayapply;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.flowname.FlownameVO;
import com.gmcc.pboss.business.channel.wayapply.WayapplyDBParam;
import com.gmcc.pboss.business.channel.wayapply.WayapplyVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: Wayapply
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
public interface Wayapply extends AbstractControl {
	public WayapplyVO doCreate(WayapplyVO vo) throws Exception;

	public void doRemoveByVO(WayapplyVO vo) throws Exception;

	public void doRemoveByPK(Serializable pk) throws Exception;

	public WayapplyVO doUpdate(WayapplyVO vo) throws Exception;

	public WayapplyVO doFindByPk(Serializable pk) throws Exception;

	public DataPackage doQuery(WayapplyDBParam params) throws Exception;

	public WayapplyVO doSave(WayapplyVO vo) throws Exception;

	public WayapplyVO doCancel(WayapplyVO vo,boolean isTask,Long rvcobjid) throws Exception;

	public WayapplyVO doPass(WayapplyVO vo,boolean isTask,Long rvcobjid) throws Exception;
	
	public FlownameVO doGetstepvo(String stepid) throws Exception ;
	
	public void doWayapply(String oprcode, WayapplyVO vo, DBAccessUser user, String uptype) throws Exception;
}
