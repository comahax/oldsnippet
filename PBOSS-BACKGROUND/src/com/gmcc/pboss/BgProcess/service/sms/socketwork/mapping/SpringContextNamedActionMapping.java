package com.gmcc.pboss.BgProcess.service.sms.socketwork.mapping;

import com.sunrise.jop.common.spring.SpringContextManager;

import open.tool.socketwork.Action;
import open.tool.socketwork.exception.ActionMappingException;
import open.tool.socketwork.mapping.NamedActionMapping;

/**
 * �ɴ�NamedActionMapping��find()������ȡ��Action������Spring��������,
 * ��Spring�����й�
 * @author zhangsiwei
 * @since 2010-09-02
 */
public class SpringContextNamedActionMapping extends NamedActionMapping {

	@Override
	public Action find(String cmdId) {
		try {
			Class<Action> actionClass = (Class<Action>) Class.forName(super.getPackageName() + ".CmdId" + cmdId + "Action");
			SpringContextManager.registerBean(actionClass.getName(), actionClass);
			return (Action)SpringContextManager.getBean(actionClass.getName());
		}catch(Exception ex) {
			throw new ActionMappingException(ex);
		}
	}

	
}
