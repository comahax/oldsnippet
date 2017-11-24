/**
 * auto-generated code
 * Mon Jun 02 17:52:17 CST 2008
 */
package com.sunrise.boss.business.resmanage.oprresmanage.audit.control;

import java.util.List;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: AuditControl
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
 * @author
 * @version 1.0
 */
public interface AuditControl extends AbstractControl {
	public void doPermit(List audits, User user) throws Exception;
	public void doReject(List audits, User user) throws Exception;
	public void doConfirm(List audits, User user) throws Exception;
}
