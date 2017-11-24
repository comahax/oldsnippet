package com.sunrise.boss.business.cms.audit.jhsmsrule.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.audit.jhsmsrule.persistent.JhSmsRuleListVO;
import com.sunrise.boss.business.cms.audit.jhsmsrule.persistent.JhSmsRuleVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: CompanyDelegate
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Hanny Yeung
 * @version 1.0
 */
public interface JhSmsRuleControl extends AbstractControl {
	public JhSmsRuleVO doCreate(JhSmsRuleVO vo, User user) throws Exception;

	public void doRemove(JhSmsRuleVO vo, User user) throws Exception;

	public JhSmsRuleVO doUpdate(JhSmsRuleVO vo, User user) throws Exception;

	public JhSmsRuleVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(JhSmsRuleListVO params, User user)
			throws Exception;
}
