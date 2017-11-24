package com.sunrise.boss.business.cms.svwayinfo.control;

import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

public interface SvwayinfoControl extends AbstractControl {
	public DataPackage doQuery(WayListVO waylistvo,User user) throws Exception;
	public WayVO doCreate(WayVO vo,User user) throws Exception;
	public WayVO doUpdate(WayVO vo,User user) throws Exception;
	public void doRemove(WayVO vo,User user) throws Exception;
	public Object doFindByPk(String pk,User user) throws Exception;
	public WayVO doZjtyway(WayVO vo,User user) throws Exception;
}
