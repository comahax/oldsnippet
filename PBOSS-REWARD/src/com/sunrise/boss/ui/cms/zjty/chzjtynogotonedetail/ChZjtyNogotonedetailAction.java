/**
* auto-generated code
* Tue Jul 09 12:03:37 CST 2013
*/
package com.sunrise.boss.ui.cms.zjty.chzjtynogotonedetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sunrise.boss.business.cms.zjty.chzjtynogotonedetail.persistent.ChZjtyNogotonedetailListVO;
import com.sunrise.boss.business.cms.zjty.chzjtynogotonedetail.persistent.ChZjtyNogotonedetailVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.cms.zjty.chzjtynogotonedetail.ChZjtyNogotonedetailDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2NameConfiger;

/**
 * <p>Title: ChZjtyNogotonedetailAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChZjtyNogotonedetailAction extends BaseAction {
    public ChZjtyNogotonedetailAction() {
            setVoClass(ChZjtyNogotonedetailVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "recid"; 
    }

	@Override
	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// 判断CH_ZJTY_PROTOKEN令牌
		ACLDelegate aclDelegate = new ACLDelegate();
		boolean protoken = aclDelegate.checkPermission(user.getOpercode(), "CH_ZJTY_PROTOKEN");
		request.setAttribute("protoken", protoken);
		
    	ChZjtyNogotonedetailForm form = (ChZjtyNogotonedetailForm) actionForm;
		if (form.isQuery()) {
			ChZjtyNogotonedetailListVO listVO = new ChZjtyNogotonedetailListVO();
			BeanUtils.copyProperties(listVO, form);
			ChZjtyNogotonedetailDelegate delegate = new ChZjtyNogotonedetailDelegate();
			DataPackage dp = new DataPackage();
			if (!protoken) {
				String cityid = user.getCityid();
				String _sk_cityid = Code2NameConfiger.getName("CITYIDNUM2NMAME", cityid, cityid).toString();
				listVO.set_sk_city(_sk_cityid);
				dp = delegate.doQueryByView(listVO, user);
			} else {
				dp = delegate.doQueryByView(listVO, user);
			}
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		}
    	return actionMapping.findForward("list");
	}

	@Override
	protected ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String cityid = user.getCityid();
		String _sk_cityid = Code2NameConfiger.getName("CITYIDNUM2NMAME", cityid, cityid).toString();
		ChZjtyNogotonedetailForm form = (ChZjtyNogotonedetailForm) actionForm;
		ChZjtyNogotonedetailListVO listVO = new ChZjtyNogotonedetailListVO();
		BeanUtils.copyProperties(listVO, form);
		listVO.set_sk_city(_sk_cityid);
		ChZjtyNogotonedetailDelegate delegate = new ChZjtyNogotonedetailDelegate();
		delegate.doDelete(listVO, user);
		return doList(actionMapping, actionForm, request, response, user);
	}

	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		this.doList(actionMapping, actionForm, request, response, user);
		return actionMapping.findForward("exptotal");
	}

}
