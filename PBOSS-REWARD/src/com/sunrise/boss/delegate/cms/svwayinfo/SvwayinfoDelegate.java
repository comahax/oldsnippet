package com.sunrise.boss.delegate.cms.svwayinfo;

import com.sunrise.boss.business.cms.svwayinfo.control.SvwayinfoControl;
import com.sunrise.boss.business.cms.svwayinfo.control.SvwayinfoControlBean;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

public class SvwayinfoDelegate {
	private SvwayinfoControl control;
	public SvwayinfoDelegate() throws Exception{
		control = (SvwayinfoControl) ControlFactory.build(SvwayinfoControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
	}
	
	public DataPackage doQuery(WayListVO waylistvo,User user) throws Exception{
		return control.doQuery(waylistvo, user);
	}
	public WayVO doCreate(WayVO vo,User user) throws Exception{
		return control.doCreate(vo, user);
	}
	public WayVO doUpdate(WayVO vo,User user) throws Exception{
		return control.doUpdate(vo, user);
	}
	public void doRemove(WayVO vo,User user) throws Exception{
		control.doRemove(vo, user);
	}
	public Object doFindByPk(String pk,User user) throws Exception{
		return control.doFindByPk(pk, user);
	}
	public WayVO doZjtyway(WayVO vo,User user) throws Exception{
		return control.doZjtyway(vo, user);
	}
}
