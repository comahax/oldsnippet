/**
* auto-generated code
* Sat Dec 08 10:23:53 CST 2012
*/
package com.sunrise.boss.ui.cms.reward.sgcreditstd3g;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.creditstd3g.persistent.Creditstd3gListVO;
import com.sunrise.boss.business.cms.reward.creditstd3g.persistent.Creditstd3gVO;
import com.sunrise.boss.business.cms.reward.creditstd3g.persistent.VCreditstd3gVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.reward.creditstd3g.Creditstd3gDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: Creditstd3gAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class SgCreditstd3gAction extends BaseAction {	
    public SgCreditstd3gAction() {
            setVoClass(Creditstd3gVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[2]; 
           pkNameArray[0] = "cityid"; 
           pkNameArray[1] = "wayattr"; 
    }
    
	/**
	 * 查询 商圈门店补贴酬金标准设置
	 */
	public ActionForward doListstdset(ActionMapping actionMapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		try{
			SgCreditstd3gForm form = (SgCreditstd3gForm)actionForm;
			Creditstd3gListVO listvo = new Creditstd3gListVO();
			//BeanUtils.copyProperties(listvo, form);
//			form.set_ne_cityid("751");
			setListVO(listvo, form);
						
			Creditstd3gDelegate delegate = new Creditstd3gDelegate();
			DataPackage dp = delegate.doQuerystdset(listvo, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		}catch(Exception ex){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
		}		
		return (actionMapping.findForward("liststdset"));
	}
    
	
	public ActionForward doEditstdset(ActionMapping actionMapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		try{
			String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
			String[] pkValueArray = pk.split("\\|");
			Creditstd3gDelegate delegate = new Creditstd3gDelegate();
			Creditstd3gListVO listvo = new Creditstd3gListVO();
			listvo.set_ne_cityid(pkValueArray[0]);
			listvo.set_se_wayattr(pkValueArray[1]);
			DataPackage dp = delegate.doQuerystdset(listvo, user);
			if(dp!=null && dp.getDatas()!=null && dp.getDatas().size()>0){
				VCreditstd3gVO vvo = (VCreditstd3gVO)dp.getDatas().iterator().next();
				BeanUtils.copyProperties(actionForm, vvo);
			}else{
				throw new Exception("根据主键"+pk+"无法查到数据");
			}
		}catch(Exception ex){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
		}
		return (actionMapping.findForward("contentstdset"));
	}
	
	public ActionForward doSavestdset(ActionMapping actionMapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		VCreditstd3gVO vvo = new VCreditstd3gVO();
		this.setSaveVO(vvo, actionForm);
		if(vvo.getRewardstd() > vvo.getRewardstdup()){
			throw new Exception("酬金标准不能超过省公司设置酬金上限");
		}
		Creditstd3gVO vo = new Creditstd3gVO();
		BeanUtils.copyProperties(vo, vvo);
		vo.setCityid(Short.parseShort("751"));
		Creditstd3gDelegate delegate = new Creditstd3gDelegate();
		delegate.doUpdate(vo, user);
		BeanUtils.copyProperties(actionForm, vo);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		
		return (actionMapping.findForward("contentstdset"));
	}
}
