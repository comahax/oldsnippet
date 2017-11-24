package com.gmcc.pboss.control.channel.zjty.zjtywayinfo;

import java.util.Collection;

import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.zjty.zjtywayinfo.ZjtywayinfoVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;


public interface Zjtywayinfo extends AbstractControl {
	public DataPackage doQuery(WayDBParam waylistvo,DBAccessUser user) throws Exception;
	public WayVO doCreate(WayVO vo,DBAccessUser user) throws Exception;
	public WayVO doUpdate(WayVO vo,DBAccessUser user) throws Exception;
	public void doRemove(WayVO vo,DBAccessUser user) throws Exception;
	public void doMulsave(ZjtywayinfoVO vo,DBAccessUser user) throws Exception;
	public void doMulupdate(ZjtywayinfoVO vo,DBAccessUser user) throws Exception;
	public Object doFindByPk(String pk, DBAccessUser user) throws Exception;
	public DataPackage doQueryZjty(Collection coll,DBAccessUser user)throws Exception ;
}
