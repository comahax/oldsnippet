/**
 * auto-generated code
 * Fri Oct 08 14:53:45 CST 2010
 */
package com.sunrise.boss.delegate.cms.reward.stdrewardut;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardut.persistent.StdrewardutVO;
import com.sunrise.boss.business.cms.reward.stdrewardut.persistent.StdrewardutListVO;
import com.sunrise.boss.business.cms.reward.stdrewardut.persistent.VStdrewardutVO;
import com.sunrise.boss.business.cms.reward.stdrewardut.control.StdrewardutControlBean;
import com.sunrise.boss.business.cms.reward.stdrewardut.control.StdrewardutControl;

import java.io.Serializable;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * <p>Title: StdrewardutDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class StdrewardutDelegate {

	private static StdrewardutControl control;

	public StdrewardutDelegate() throws Exception {
		control = (StdrewardutControl) ControlFactory
				.build(StdrewardutControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public StdrewardutVO doCreate(StdrewardutVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(StdrewardutVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public StdrewardutVO doUpdate(StdrewardutVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public StdrewardutVO doFindByPk(Serializable pk, User user)
			throws Exception {
		return (StdrewardutVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(StdrewardutListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}
	
	public DataPackage doQuerylist(StdrewardutListVO params, User user)
		throws Exception{
		return control.doQuerylist(params, user);
	}
	public DataPackage doQuerycitylist(StdrewardutListVO params, User user)
	throws Exception{
	return control.doQuerycitylist(params, user);
}

	public StdrewardutVO doBatchcreate(VStdrewardutVO vo, String[] selectcity,
			ArrayList list51, ArrayList list52, ArrayList list53, User user)
			throws Exception {
		return control.doBatchcreate(vo, selectcity, list51, list52, list53, user);
	}
	
	public StdrewardutVO doBatchupdate(VStdrewardutVO vo, String[] selectcity,
			ArrayList list51, ArrayList list52, ArrayList list53, User user)
			throws Exception {
		return control.doBatchupdate(vo, selectcity, list51, list52, list53, user);
	}

	public void doBatchremove(ArrayList regionlist, User user)throws Exception{
		control.doBatchremove(regionlist, user);
	}
	public StdrewardutVO doSavecity(StdrewardutVO stdrewardutVO, User user)throws Exception{
		return control.doSavecity(stdrewardutVO, user);
	}
	public void doDeletecity(String wayid,User user) throws Exception {
		 control.doDeletecity(wayid, user);
	}
	
}
