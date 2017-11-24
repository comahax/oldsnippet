/**
* auto-generated code
* Wed Feb 06 14:54:24 CST 2013
*/
package com.sunrise.boss.ui.fee.chadtrulerel;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.fee.chadtrulerel.persistent.ChAdtRulerelListVO;
import com.sunrise.boss.business.fee.chadtrulerel.persistent.ChAdtRulerelVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.fee.chadtrulerel.ChAdtRulerelDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChAdtRulerelAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lc
 * @version 1.0
 */
public class ChAdtRulerelAction extends BaseAction {
    public ChAdtRulerelAction() {
            setVoClass(ChAdtRulerelVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[4]; 
           pkNameArray[0] = "cityid"; 
           pkNameArray[1] = "ruleid"; 
           pkNameArray[2] = "ruleitemid"; 
           pkNameArray[3] = "rulemodeid"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	
    	ChAdtRulerelListVO rellistvo=new ChAdtRulerelListVO();
    	rellistvo.set_sql_condintion(" (RULEITEMID in ('ZJ_CZHY_NonBrandGotone','ZJ_CZHY_BrandGotone')) ");
    	rellistvo.set_se_cityid("759");
    	ChAdtRulerelDelegate de=new ChAdtRulerelDelegate();
    	DataPackage dp=de.doQuery(rellistvo, user);
//    	Iterator it = dp.getDatas().iterator();
//		while (it.hasNext()) {
//			ChAdtRulerelVO vo=(ChAdtRulerelVO)(it.next());
//			String p=vo.getParamer();
//			
//			String sb=new String();
//			
//			String[] content =StringUtils.splitPreserveAllTokens(p, "|");
//			for(int i=0;i<content.length;i++){
//				sb+=(content[i]);
//				if((i%10)==9)
//					sb+="<br>";
//			}
//				
//			vo.setParamer(sb);
//			
//		}
		
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
    	
    	return (actionMapping.findForward("list"));
    }
    
    protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	
    	ChAdtRulerelForm form=(ChAdtRulerelForm)actionForm;
    	try {
	    	String[] content =StringUtils.splitPreserveAllTokens(form.getParamer(), "|");
	
	    	if(content==null)
	    		throw new BusinessException("","参数个数不对!");
	    	else
	    	{
	    		if("ZJ_CZHY_NonBrandGotone".equals(form.getRuleitemid())){
	    			if(content.length!=21)
	    				throw new BusinessException("","参数个数不对!");
	    		}else{
	    			if(content.length!=21)
	    				throw new BusinessException("","参数个数不对!");
	    		}
	    	}
	    	
	    		
	    	ChAdtRulerelListVO rellistvo=new ChAdtRulerelListVO();
	    	rellistvo.set_se_ruleitemid(form.getRuleitemid());
	    	rellistvo.set_se_cityid("759");
	    	rellistvo.set_se_ruleid("czhy");
	    	
	    	ChAdtRulerelDelegate de=new ChAdtRulerelDelegate();
	    	DataPackage dp=de.doQuery(rellistvo, user);
	    	
	    	ChAdtRulerelVO vo=new ChAdtRulerelVO();
	    	vo.setCityid("759");
	    	vo.setRuleitemid(form.getRuleitemid());
	    	vo.setRuleid("czhy");
	    	vo.setParamer(form.getParamer());
	    	vo.setRulemodeid(Long.parseLong("0"));
	    	
	    	if(dp.getRowCount()==0)
	    		de.doCreate(vo, user);
	    	else
	    		de.doUpdate(vo, user);
//	    	if (WebConstant.COMMAND_STRING_EDIT.equalsIgnoreCase(form
//					.getCmdState())) {
//	    		de.doUpdate(vo, user);
//	    	}else{
//	    		de.doCreate(vo, user);
//	    	}
	    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		} catch (BusinessException be) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, be
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
    	
    	return actionMapping.findForward("content");
    	
    }
    
}
