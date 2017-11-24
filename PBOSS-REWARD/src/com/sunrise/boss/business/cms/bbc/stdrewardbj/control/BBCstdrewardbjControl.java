/**
* auto-generated code
* Tue Aug 26 20:17:18 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.stdrewardbj.control;

import java.io.Serializable;
import java.util.List;

import com.sunrise.boss.business.cms.bbc.stdrewardbj.persistent.BBCstdrewardbjListVO;
import com.sunrise.boss.business.cms.bbc.stdrewardbj.persistent.BBCstdrewardbjVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BBCstdrewardbjControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface BBCstdrewardbjControl extends AbstractControl {
	public BBCstdrewardbjVO doCreate(BBCstdrewardbjVO vo, User user) throws Exception;

	public void doRemove(BBCstdrewardbjVO vo, User user) throws Exception;

	public BBCstdrewardbjVO doUpdate(BBCstdrewardbjVO vo, User user) throws Exception;

	public BBCstdrewardbjVO doFindByPk(Serializable pk, User user)
			throws Exception;

	public DataPackage doQuery(BBCstdrewardbjListVO params, User user)
			throws Exception;

	public void doSave(List list, User user) throws Exception;

//  市公司计件酬金上限设置 保存
	public void doSavecity(List list, User user) throws Exception;
}
