package com.sunrise.boss.delegate.resmanage.common.tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.delegate.resmanage.common.tag.Node.ParamInfo;
import com.sunrise.boss.ui.commons.User;

public class ResCommonChkDelegate {
	public boolean checkPermission(String delegate, String params, User user)
			throws Exception {
		if (!StringUtils.isEmpty(delegate)) {
			Object dt = ResCommonChkConfig.getDtObj(delegate);
			String method = ResCommonChkConfig.getMethodName(delegate);
			List args = new ArrayList();
			Map paramMap = analyzeNameandvalue(params);
			List paramList = ResCommonChkConfig.getParamInfos(delegate);
			if (paramList != null && paramList.size() > 0){
				for (Iterator it = paramList.iterator();it.hasNext();){
					ParamInfo pi = (ParamInfo)it.next();
					String value = pi.getValue();
					if ("".equals(value)){
						value = null;
					}
					if (paramMap.containsKey(pi.getName())){
						 value = (String)paramMap.get(pi.getName());
						args.add(parseValue(value,pi.getType()));
					}else {
						args.add(value);
					}
				}
			}
			args.add(user);
			return ((Boolean)MethodUtils.invokeMethod(dt, method, args.toArray())).booleanValue();
		}
		return true;
	}

	private Map analyzeNameandvalue(String nameandvalues) throws Exception{
		Map map = new HashMap();
		if (!StringUtils.isEmpty(nameandvalues)){
			String[] filters = nameandvalues.split("\\;");
			for (int i=0;i < filters.length; i++){
				String[] namevalue = filters[i].split("\\:");
				String name = filters[0];
				Object value = null;
				if (filters.length > 1){
					value = filters[1];
				}
				map.put(name, value);
			}
		}
		return map;
	}
	
	private Object parseValue(String value,String type){
		// TODO ´ýÍêÉÆ
		return value;
	}
}
