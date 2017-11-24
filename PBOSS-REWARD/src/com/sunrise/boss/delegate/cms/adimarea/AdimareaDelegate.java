/**
 * auto-generated code
 * Thu Apr 05 10:00:59 CST 2007
 */
package com.sunrise.boss.delegate.cms.adimarea;

import java.io.Serializable;
import java.util.List;

import com.sunrise.boss.business.cms.adimarea.control.AdimareaControl;
import com.sunrise.boss.business.cms.adimarea.control.AdimareaControlBean;
import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaListVO;
import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: AdimareaDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
public class AdimareaDelegate {

	private static AdimareaControl control;

	public AdimareaDelegate() throws Exception {
		control = (AdimareaControl) ControlFactory
				.build(AdimareaControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public AdimareaVO doCreate(AdimareaVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(AdimareaVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public AdimareaVO doUpdate(AdimareaVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public AdimareaVO doFindByPk(Serializable pk, User user) throws Exception {
		return (AdimareaVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(AdimareaListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}
	
	public DataPackage doQueryByOprcode(AdimareaListVO params, User user) throws Exception {
		return control.doQueryByOprcode(params, user);
	}
	
	public AdimareaVO doChangeStatus(AdimareaVO vo, User user) throws Exception {
		return control.doChangeStatus(vo, user);
	}
	
	public boolean judgeIfReasonable(AdimareaListVO params,
			String contentuppercode, User user) throws Exception {
		return control.judgeIfReasonable(params, contentuppercode, user);
	}

	public Long doAddupTotalppn(AdimareaListVO listvo, User user) throws Exception {
		return control.doAddupTotalppn(listvo, user);
	}

	public Long doAddupResippn(AdimareaListVO listvo, User user) throws Exception {
		return control.doAddupResippn(listvo, user);
	}

	public Long doAddupNonresippn(AdimareaListVO listvo, User user) throws Exception {
		return control.doAddupNonresippn(listvo, user);
	}

	public Long doAddupAdarea(AdimareaListVO listvo, User user) throws Exception {
		return control.doAddupAdarea(listvo, user);
	}

	public Long doAddupGmccusers(AdimareaListVO listvo, User user) throws Exception {
		return control.doAddupGmccusers(listvo, user);
	}

	public Long doAddupCucusers(AdimareaListVO listvo, User user) throws Exception {
		return control.doAddupCucusers(listvo, user);
	}

	public Long doAddupCtcusers(AdimareaListVO listvo, User user) throws Exception {
		return control.doAddupCtcusers(listvo, user);
	}

	public Long doAddupHandphones(AdimareaListVO listvo, User user) throws Exception {
		return control.doAddupHandphones(listvo, user);
	}
	public List doQueryUpperada(String adacode,User user) throws Exception{
		return control.doQueryUpperada(adacode, user);
	}
	public void doChgAdacodeofOrg(String orgcode,String adacode,User user) throws Exception{
		control.doChgAdacodeofOrg(orgcode, adacode, user);
	}
}
