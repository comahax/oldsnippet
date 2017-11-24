/**
 * auto-generated code
 * Fri Oct 08 14:53:45 CST 2010
 */
package com.sunrise.boss.business.cms.reward.stdrewardut.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardut.persistent.StdrewardutVO;
import com.sunrise.boss.business.cms.reward.stdrewardut.persistent.StdrewardutListVO;
import com.sunrise.boss.business.cms.reward.stdrewardut.persistent.VStdrewardutVO;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * <p>Title: StdrewardutControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface StdrewardutControl extends AbstractControl {
	public StdrewardutVO doCreate(StdrewardutVO vo, User user) throws Exception;

	public void doRemove(StdrewardutVO vo, User user) throws Exception;

	public StdrewardutVO doUpdate(StdrewardutVO vo, User user) throws Exception;

	public StdrewardutVO doFindByPk(Serializable pk, User user)
			throws Exception;

	public DataPackage doQuery(StdrewardutListVO params, User user)
			throws Exception;

	public DataPackage doQuerylist(StdrewardutListVO params, User user)
			throws Exception;
	public DataPackage doQuerycitylist(StdrewardutListVO params, User user)
			throws Exception;
	public StdrewardutVO doBatchcreate(VStdrewardutVO vo, String[] selectcity,
			ArrayList list51, ArrayList list52, ArrayList list53, User user)
			throws Exception;

	public StdrewardutVO doBatchupdate(VStdrewardutVO vo, String[] selectcity,
			ArrayList list51, ArrayList list52, ArrayList list53, User user)
			throws Exception;

	public void doBatchremove(ArrayList regionlist, User user) throws Exception;
	public StdrewardutVO doSavecity(StdrewardutVO stdrewardutVO, User user)throws Exception;
	public void doDeletecity(String wayid,User user) throws Exception ;

}
