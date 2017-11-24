package com.sunrise.boss.delegate.fee.common.eboxchg;

import com.sunrise.boss.business.fee.common.eboxchg.control.EboxchgControl;
import com.sunrise.boss.business.fee.common.eboxchg.control.EboxchgControlBean;
import com.sunrise.boss.business.fee.common.eboxchg.persistent.EboxchgListVO;
import com.sunrise.boss.business.fee.common.eboxchg.persistent.EboxchgVO;
import com.sunrise.boss.business.fee.dgrealprod.rbeboxchglog.persistent.RbEboxChgLogListVO;
import com.sunrise.boss.business.fee.persistent.eboxchglog.EboxChgLogListVO;
import com.sunrise.boss.business.fee.querybyno.dgeboxchglog.persistent.DgEboxChgLogListVO;
import com.sunrise.boss.business.fee.querybyno.eboxchgloghis.persistent.EboxChgLogHisListVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import java.io.Serializable;

public class EboxchgDelegate {
	private EboxchgControl control;

	public EboxchgDelegate() throws Exception {
		control = (EboxchgControl) ControlFactory
				.build(EboxchgControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public EboxchgVO doCreate(EboxchgVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(EboxchgVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public EboxchgVO doUpdate(EboxchgVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public EboxchgVO doFindByPk(Serializable pk, User user) throws Exception {
		return (EboxchgVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(EboxchgListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}
	
	
	public DataPackage queryEboxchglog(EboxChgLogListVO listVO,User user) throws Exception{
		return control.queryEboxchglog(listVO, user);
	}
	
	
    public DataPackage queryEboxChgLogHis(EboxChgLogHisListVO listVO,User user) throws Exception {
    	return control.queryEboxChgLogHis(listVO,user);
    }
	
    public DataPackage queryRbEboxChgLog(RbEboxChgLogListVO listVO,User user) throws Exception {
    	return control.queryRbEboxChgLog(listVO,user);
    }
    
    public DataPackage queryDgEboxChgLog(DgEboxChgLogListVO listVO,User user) throws Exception {
    	return control.queryDgEboxChgLog(listVO,user);
    }
	
}
