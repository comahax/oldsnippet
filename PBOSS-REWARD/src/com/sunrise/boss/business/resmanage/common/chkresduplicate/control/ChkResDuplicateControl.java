package com.sunrise.boss.business.resmanage.common.chkresduplicate.control;

import com.sunrise.boss.business.resmanage.common.chkresduplicate.persistent.ChkResDuplicateVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.ui.commons.User;

/**
 * 2.2.3.17 ��Դ���������ظ��Լ��ģ��
 * 
 * @author David
 */
public interface ChkResDuplicateControl extends AbstractControl {

	public int doChkResDupl(ChkResDuplicateVO vo, User user) throws Exception;

}
