package net.gmcc.pboss.common.dynamicds;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 继承AbstractRoutingDataSource类,动态获取数据源
 * 
 *
 */
public class DynamicSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		System.out.println("------------------------数据源："+DynamicSourceHelper.getDataSourceUser());
		return DynamicSourceHelper.getDataSourceUser();
	}

}
