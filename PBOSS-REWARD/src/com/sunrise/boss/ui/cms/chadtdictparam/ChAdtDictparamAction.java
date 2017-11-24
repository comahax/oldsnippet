/**
* auto-generated code
* Tue Feb 22 09:29:17 CST 2011
*/
package com.sunrise.boss.ui.cms.chadtdictparam;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamListVO;
import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamVO;
import com.sunrise.boss.business.cms.citycompany.persistent.CitycompanyListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.chadtdictparam.ChAdtDictparamDelegate;
import com.sunrise.boss.delegate.cms.citycompany.CitycompanyDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.cms.reward.faildataquery.FaildataqueryForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChAdtDictparamAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class ChAdtDictparamAction extends BaseDelegateAction {
    public ChAdtDictparamAction() {
            setVoClass(ChAdtDictparamVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "dkey"; 
//           pkNameArray[1] = "dvalue"; 
    }
    
    /**
	 * 查询
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChAdtDictparamForm form=(ChAdtDictparamForm)actionForm;
		ChAdtDictparamDelegate dictparamDelegate=new ChAdtDictparamDelegate();
		ChAdtDictparamVO dictparamVO=new ChAdtDictparamVO();
		dictparamVO.setDkey("BBC_SMSCONFIRM");
		ChAdtDictparamVO dictparamVO1 =dictparamDelegate.doFindByPk(dictparamVO.getDkey(), user);
		if(Integer.parseInt(dictparamVO1.getDvalue())==1){
			form.setChecked("true");
		}else{
			form.setChecked("false");
		}
		
		return (actionMapping.findForward("list"));
	}
    
    protected ActionForward doSave(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		
    	ChAdtDictparamForm form=(ChAdtDictparamForm)actionForm;
		ChAdtDictparamDelegate dictparamDelegate=new ChAdtDictparamDelegate();
		ChAdtDictparamVO dictparamVO=new ChAdtDictparamVO();
		dictparamVO.setDkey("BBC_SMSCONFIRM");
		ChAdtDictparamVO dictparamVO1 =dictparamDelegate.doFindByPk(dictparamVO.getDkey(), user);
		BeanUtils.copyProperties(dictparamVO, dictparamVO1);
		
		if(form.getChecked()!=null){
			dictparamVO.setDvalue("1");
    	}else{
    		dictparamVO.setDvalue("0");
    	}
		dictparamDelegate.doUpdate(dictparamVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "设置保存成功");
		
//		request.setAttribute("flag", 1);
		
        return (actionMapping.findForward("list"));
 	}
    
}
