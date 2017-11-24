package com.gmcc.pboss.common.interceptor;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.dictionary.HttpDictionary;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class RewardInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Object action = actionInvocation.getAction();
		
		AbstractAction abstractAction = (AbstractAction)action;
		LoginMember member =  abstractAction.getLogMember();
		
		String namespace = actionInvocation.getProxy().getNamespace();
		String actionName = actionInvocation.getProxy().getActionName();
		String url = namespace+"/"+actionName+".do";
		if("1".equals(member.getIsShowReward())){
			//只允许看本地酬金
			if("1".equals(member.getIsShowLocalReward())){
				if("/reward/localReward.do".equals(url)|| "/reward/localRewardDtl.do".equals(url)){
					return actionInvocation.invoke();
				}else{
					abstractAction.setRequestAttribute("message", ConfigUtil.getMessage("", 31));
					abstractAction.setRequestAttribute(HttpDictionary.BACK_URL, ServletActionContext.getRequest().getContextPath()+"/index.do");
					return "rewardDisabled";		
				}
			}else {//不允许看本地酬金
				if("/reward/localReward.do".equals(url)||"/reward/localRewardDtl.do".equals(url)){
					abstractAction.setRequestAttribute("message", ConfigUtil.getMessage("", 32));
					abstractAction.setRequestAttribute(HttpDictionary.BACK_URL, ServletActionContext.getRequest().getContextPath()+"/index.do");
					return "rewardDisabled";	
				}
				return actionInvocation.invoke();
			}
		}else{
			abstractAction.setRequestAttribute("message", ConfigUtil.getMessage("", 31));
			abstractAction.setRequestAttribute(HttpDictionary.BACK_URL, ServletActionContext.getRequest().getContextPath()+"/index.do");
			return "rewardDisabled";
		}
	}
}