package com.sunrise.boss.delegate.resmanage.nores.nosect;

import com.sunrise.boss.business.resmanage.nosect.control.NosectControl;
import com.sunrise.boss.business.resmanage.nosect.control.NosectControlBean;
import com.sunrise.boss.business.resmanage.nosect.persistent.NosectListVO;
import com.sunrise.boss.business.resmanage.nosect.persistent.NosectVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

public class NosectDelegate {

	private NosectControl control;
	
	public NosectDelegate() throws Exception{
		control = (NosectControl) ControlFactory.build(NosectControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}
	
	public NosectVO doCreate(NosectVO vo, User user)throws Exception{
		return control.doCteate(vo, user);
	}
	
	public NosectVO doUpdate(NosectVO vo, User user) throws Exception{
		return control.doUpdate(vo, user);
	}
	
	public DataPackage doFindNosect(NosectListVO listVO, User user)throws Exception{
		return control.doFindNosect(listVO, user);
	}
	
	public int doCheckNosectDuplicate(String beginno, String endno, User user)throws Exception{
		return control.doCheckNosectDuplicate(beginno, endno, user);
	}
	
	public NosectVO doFindByPk(Long nosectid, User user)throws Exception{
		return control.doFindByPk(nosectid, user);
	}
	
	public String doQueryCityID(String mobileNO,User user) throws Exception
	{
		return control.doQueryCityID(mobileNO,user);
	}
}
