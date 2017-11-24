/**
 * auto-generated code
 * Wed Aug 10 16:07:59 CST 2011
 */
package com.gmcc.pboss.business.sales.orderorderproce;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.way.AGWayVO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderOrderproceDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OrderOrderproceDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public OrderOrderproceDAO(){
        super(OrderOrderproceVO.class);
    }
    
    public DataPackage queryProce(Map<String,String> conditionMap, OrderOrderproceDBParam param) throws Exception {
    	
    	StringBuffer queryStringBuffer = new StringBuffer();
    	queryStringBuffer.append("select ROWNUM as rowcountid ,COUNTYID,PAYTYPE,countrecamt,sumrecamt from (");
    	queryStringBuffer.append(" select a.COUNTYID, a.PAYTYPE, count(*) as countrecamt , sum(a.RECAMT) as sumrecamt ");
    	queryStringBuffer.append("  from FX_SW_ORDER a, FX_RU_ORDERPROCE b ");
    	queryStringBuffer.append("  where a.FLOWID = b.FLOWID  ");
    	queryStringBuffer.append(" and a.ORDERSTATE = b.INSTATE ");
    	queryStringBuffer.append(" and b.OUTSTATE = 'CHARGED' ");
    	
    	String starttimeStr = conditionMap.get("starttimeStr");
    	String endtimeStr = conditionMap.get("endtimeStr");
    	if(!StringUtils.isEmpty(starttimeStr) && !StringUtils.isEmpty(endtimeStr))
    	{
    		queryStringBuffer.append(" and a.CREATETIME   <= to_date('" + endtimeStr + "','yyyy-MM-dd hh24:mi:ss') ");
        	queryStringBuffer.append(" and a.CREATETIME   >= to_date('" + starttimeStr + "','yyyy-MM-dd hh24:mi:ss') ");
    	}
    	String COUNTYID = conditionMap.get("COUNTYID");
    	if(!StringUtils.isEmpty(COUNTYID))
    	{
    		queryStringBuffer.append(" and a.COUNTYID = '" + COUNTYID + "' ");
    	}
    	String WAYTYPE=conditionMap.get("WAYTYPE");
    	if(!StringUtils.isEmpty(WAYTYPE))
    	{
    		queryStringBuffer.append(" a.PAYTYPE = = '" + WAYTYPE + "' ");
    		
    	}
    	queryStringBuffer.append(" group by a.COUNTYID, a.PAYTYPE ) ");
    	return queryBySql(queryStringBuffer.toString(), param);
    	
    }
    
public DataPackage queryDetail(Map<String,String> conditionMap, OrderOrderproceDBParam param) throws Exception {
    	
		param.setSelectFieldsString("wayid,orderid,countyid,paytype,recamt");
	
    	StringBuffer queryStringBuffer = new StringBuffer();
//    	queryStringBuffer.append("select ROWNUM as rowcountid ,COUNTYID,PAYTYPE,countrecamt,sumrecamt from (");
    	queryStringBuffer.append(" select a.wayid ,a.orderid, a.COUNTYID, a.PAYTYPE,  a.RECAMT ");
    	queryStringBuffer.append("  from FX_SW_ORDER a, FX_RU_ORDERPROCE b ");
    	queryStringBuffer.append("  where a.FLOWID = b.FLOWID  ");
    	queryStringBuffer.append(" and a.ORDERSTATE = b.INSTATE ");
    	queryStringBuffer.append(" and b.OUTSTATE = 'CHARGED' ");
    	
    	String starttimeStr = conditionMap.get("starttimeStr");
    	String endtimeStr = conditionMap.get("endtimeStr");
    	if(!StringUtils.isEmpty(starttimeStr) && !StringUtils.isEmpty(endtimeStr))
    	{
    		queryStringBuffer.append(" and a.CREATETIME   <= to_date('" + endtimeStr + "','yyyy-MM-dd hh24:mi:ss') ");
        	queryStringBuffer.append(" and a.CREATETIME   >= to_date('" + starttimeStr + "','yyyy-MM-dd hh24:mi:ss') ");
    	}
    	String COUNTYID = conditionMap.get("COUNTYID");
    	if(!StringUtils.isEmpty(COUNTYID))
    	{
    		queryStringBuffer.append(" and a.COUNTYID = '" + COUNTYID + "' ");
    	}
    	String WAYTYPE=conditionMap.get("WAYTYPE");
    	if(!StringUtils.isEmpty(WAYTYPE))
    	{
    		queryStringBuffer.append(" and a.PAYTYPE = = '" + WAYTYPE + "' ");
    		
    	}
    	
    	DataPackage tempDp = queryBySql(queryStringBuffer.toString(), param);
    	List list = tempDp.getDatas();
//    	queryStringBuffer.append(" group by a.COUNTYID, a.PAYTYPE ) ");
    	
    	DataPackage resultDp = new DataPackage();
		List collection = new ArrayList();
		for(int i = 0;i<list.size();i++) {
			OrderOrderproceVO oopVO = new OrderOrderproceVO();
			Map map = (Map)list.get(i);
			BeanUtils.copyProperties(oopVO, map);
			collection.add(oopVO);
		}
		resultDp.setDatas(collection);
		resultDp.setRowCount(tempDp.getRowCount());
		resultDp.setPageNo(tempDp.getPageNo());
		resultDp.setPageSize(tempDp.getPageSize());
		return resultDp;
    	
    	
    }
    
}
