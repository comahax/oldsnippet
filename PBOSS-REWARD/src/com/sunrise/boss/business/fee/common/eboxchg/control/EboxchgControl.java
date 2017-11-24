package com.sunrise.boss.business.fee.common.eboxchg.control;

import com.sunrise.boss.business.fee.common.eboxchg.persistent.EboxchgListVO;
import com.sunrise.boss.business.fee.common.eboxchg.persistent.EboxchgVO;
import com.sunrise.boss.business.fee.dgrealprod.rbeboxchglog.persistent.RbEboxChgLogListVO;
import com.sunrise.boss.business.fee.persistent.eboxchglog.EboxChgLogListVO;
import com.sunrise.boss.business.fee.querybyno.dgeboxchglog.persistent.DgEboxChgLogListVO;
import com.sunrise.boss.business.fee.querybyno.eboxchgloghis.persistent.EboxChgLogHisListVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import java.io.Serializable;

public interface EboxchgControl extends AbstractControl {
	
	public EboxchgVO doCreate(EboxchgVO vo, User user) throws Exception;

	public void doRemove(EboxchgVO vo, User user) throws Exception;

	public EboxchgVO doUpdate(EboxchgVO vo, User user) throws Exception;

	public EboxchgVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(EboxchgListVO params, User user) throws Exception;
	
	
	public DataPackage queryEboxchglog(EboxChgLogListVO listVO,User user) throws Exception;
	
	public DataPackage queryEboxChgLogHis(EboxChgLogHisListVO listVO,User user) throws Exception;
	
	public DataPackage queryRbEboxChgLog(RbEboxChgLogListVO listVO,User user) throws Exception;

	public DataPackage queryDgEboxChgLog(DgEboxChgLogListVO listVO,User user) throws Exception;
	
}
