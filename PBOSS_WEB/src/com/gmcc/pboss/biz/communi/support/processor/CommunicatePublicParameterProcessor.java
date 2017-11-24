package com.gmcc.pboss.biz.communi.support.processor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang.time.DateUtils;
import org.hibernate.Query;

import com.gmcc.pboss.biz.communi.support.CommunicatePlateauParameter;
import com.gmcc.pboss.common.config.CommunicateConfigLoader;
import com.gmcc.pboss.common.config.FileConfigAdapter;
import com.gmcc.pboss.common.dictionary.CommunicateConfig;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.DateUtil;

public class CommunicatePublicParameterProcessor extends DefaultHqlQueryProcessor implements QueryParameterProcessor{

	@Override
	public String getHql(QueryParameter parameter) {
		
		StringBuffer hqlSb = new StringBuffer();
		hqlSb.append(" select info ");
		hqlSb.append(" from ChPwAdvinfo info ");
		hqlSb.append(" where  info.enddate >= :curdate ");
		hqlSb.append(" and info.imgLogoPath is not null ");
		hqlSb.append(" and info.type=:type and info.state=3 ");
		hqlSb.append(" order by releasetime desc ");
		
		return hqlSb.toString();
	}

	@Override
	public String[] getParamEncloseName() {
		return null;
	}

	@Override
	public void process(Query query, QueryParameter parameter) {
		CommunicatePlateauParameter param = (CommunicatePlateauParameter)parameter;
		query.setParameter("type", Long.parseLong(param.getType()));
		query.setParameter("curdate", DateUtils.truncate(new Date(), 1));
		
		parameter.setAction(QueryAction.ALL);
		if(CommunicateConfigLoader.PROPS.contains(CommunicateConfig.DOWNLOAD_ALL))
			parameter.setAll_size(Integer.parseInt(CommunicateConfigLoader.PROPS.getProperty(CommunicateConfig.DOWNLOAD_ALL)));
		else
			parameter.setAll_size(100);
	}
}
