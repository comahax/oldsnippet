package com.sunrise.boss.delegate.zifee.yxplan;

import java.io.Serializable;

import com.sunrise.boss.business.zifee.yxplan.control.YxPlanControl;
import com.sunrise.boss.business.zifee.yxplan.control.YxPlanControlBean;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanListVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.zifee.commons.ResultBean;

public class YxPlanDelegate {
	private YxPlanControl control;

	public YxPlanDelegate() throws Exception {
		control = (YxPlanControl) ControlFactory.build(YxPlanControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public YxPlanVO doCreate(YxPlanVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(YxPlanVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public YxPlanVO doUpdate(YxPlanVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public YxPlanVO doFindByPk(Serializable pk, User user) throws Exception {
		return (YxPlanVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(YxPlanListVO params, User user) throws Exception {
		return control.doQuery(params, user);
	}

	public Long getYxplanSeq(User user) throws Exception {
		return control.getYxplanSeq(user);
	}

	public YxPlanVO buildVO(String[] fields, User user) throws Exception {
		return control.buildVO(fields, user);
	}

	public ResultBean doCheck(String[] fields, User user) throws Exception {
		return control.doCheck(fields, user);
	}

	/**
	 * 营销方案单个复制
	 * 
	 * @param oldid
	 * @param copyitem
	 * @param vo
	 * @param user
	 * @throws Exception
	 * @author Cai Jianhui
	 */
	public void doSinglecopy(String oldid, String copyitem, YxPlanVO vo,
			boolean f, String filename, User user) throws Exception {
		control.doSinglecopy(oldid, copyitem, vo, f, filename, user);
	}

	/**
	 * 批量新增营销方案
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public void doBatchCreate(YxPlanVO vo, User user) throws Exception {
		control.doBatchCreate(vo, user);
	}

	/**
	 * 批量更新营销方案
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public void doBatchUpdate(YxPlanVO vo, User user) throws Exception {
		control.doBatchUpdate(vo, user);
	}
	public Long doGetYxplanID(User user)throws Exception{
		return control.doGetYxplanID(user);
	}
	public String getAreacode(Long yxplanid, User user) throws Exception {
		return control.getAreacode(yxplanid, user);
	}
}
