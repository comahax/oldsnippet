package com.sunrise.boss.business.resmanage.nosect.control;

import com.sunrise.boss.business.resmanage.nosect.persistent.NosectListVO;
import com.sunrise.boss.business.resmanage.nosect.persistent.NosectVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

public interface NosectControl extends AbstractControl {

	public NosectVO doCteate(NosectVO vo, User user)throws Exception;
	public NosectVO doUpdate(NosectVO vo, User user)throws Exception;
	public DataPackage doFindNosect(NosectListVO listVO, User user)throws Exception;
	public int doCheckNosectDuplicate(String beginno, String endno, User user)throws Exception;
	public NosectVO doFindByPk(Long nosectid, User user)throws Exception;
	public String doQueryCityID(String mobileNO,User user) throws Exception;
}
