package com.sunrise.boss.business.zifee.yxplan.control;

import java.io.Serializable;

import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanListVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;
import com.sunrise.boss.common.base.control.AbstractControl;

import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.zifee.commons.ResultBean;

public interface YxPlanControl extends AbstractControl {
	public YxPlanVO doCreate(YxPlanVO vo, User user) throws Exception;

	public void doRemove(YxPlanVO vo, User user) throws Exception;

	public YxPlanVO doUpdate(YxPlanVO vo, User user) throws Exception;

	public YxPlanVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(YxPlanListVO params, User user) throws Exception;

	public Long getYxplanSeq(User user) throws Exception;

	public YxPlanVO buildVO(String[] fields, User user) throws Exception;

	public ResultBean doCheck(String[] fields, User user) throws Exception;

	/**
	 * 
	 * @param oldid
	 * @param copyitem
	 * @param vo
	 * @param user
	 * @throws Exception
	 * @author Cai Jianhui
	 */
	public void doSinglecopy(String oldid, String copyitem, YxPlanVO vo,
			boolean f, String filename, User user) throws Exception;

	/**
	 * 批量新增营销方案
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public YxPlanVO doBatchCreate(YxPlanVO vo, User user) throws Exception;

	/**
	 * 批量更新营销方案
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public YxPlanVO doBatchUpdate(YxPlanVO vo, User user) throws Exception;

	public Long doGetYxplanID(User user) throws Exception;

	public String getAreacode(Long yxplanid, User user) throws Exception;

}
