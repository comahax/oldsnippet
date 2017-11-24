/**
 * auto-generated code
 * Sat Dec 18 20:30:44 CST 2010
 */
package com.gmcc.pboss.business.sales.orderresdetwayorderdetail;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderresdetWayOrderDetailDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OrderresdetWayOrderDetailDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public OrderresdetWayOrderDetailDAO(){
        super(OrderresdetWayOrderDetailVO.class);
    }
    
    public DataPackage doQueryOrderresdetWayOrderDetail(Map<String,String> conditionMap, OrderresdetWayOrderDetailDBParam param) 
	throws Exception{
    	StringBuffer queryStringBuffer = new StringBuffer();
    	queryStringBuffer.append(" select  ROWNUM as rowcountid , ORDERID, COUNTYID, SVCCODE, MAREACODE,STARLEVEL ,WAYID ,COMCATEGORY , COMID, COMPRICE,ACTPRICE, countvalue from ( ");
    	queryStringBuffer.append(" select a.ORDERID, b.COUNTYID, c.SVCCODE, b.MAREACODE, b.STARLEVEL, b.WAYID, a.COMCATEGORY, a.COMID, a.COMPRICE, a.ACTPRICE, count(*) as countvalue ");
    	queryStringBuffer.append(" from FX_SW_ORDERRESDET a, FX_SW_ORDER b, CH_PW_WAY c ");
    	queryStringBuffer.append(" where a.ORDERID = b.ORDERID ");
    	queryStringBuffer.append("  and b.WAYID = c.WAYID ");
    	queryStringBuffer.append(" and b.ORDERSTATE = 'FINISHED' ");
    	
    	String starttimeStr = conditionMap.get("starttimeStr");
    	String endtimeStr = conditionMap.get("endtimeStr");
    	if(!StringUtils.isEmpty(starttimeStr) && !StringUtils.isEmpty(endtimeStr))
    	{
    		queryStringBuffer.append(" and b.RECORDTIME  <= to_date('" + endtimeStr + "','yyyy-MM-dd hh24:mi:ss') ");
        	queryStringBuffer.append(" and b.RECORDTIME  >= to_date('" + starttimeStr + "','yyyy-MM-dd hh24:mi:ss') ");
    	}
    	
    	String COUNTYID = conditionMap.get("COUNTYID");
    	if(!StringUtils.isEmpty(COUNTYID))
    	{
    		queryStringBuffer.append(" and b.COUNTYID = '" + COUNTYID + "' ");
    	}
    	String SVCCODE = conditionMap.get("SVCCODE");
    	if(!StringUtils.isEmpty(SVCCODE))
    	{
    		queryStringBuffer.append(" and c.SVCCODE = '" + SVCCODE + "' ");
    	}
    	String MAREACODE  = conditionMap.get("MAREACODE ");
    	if(!StringUtils.isEmpty(MAREACODE ))
    	{
    		queryStringBuffer.append(" and b.MAREACODE  = '" + MAREACODE  + "' ");
    	}
    	String WAYID = conditionMap.get("WAYID ");
    	if(!StringUtils.isEmpty(WAYID))
    	{
    		queryStringBuffer.append("  and b.WAYID = :WAYID '" + WAYID + "' ");
    	}
    	String ORDERID = conditionMap.get("ORDERID ");
    	if(!StringUtils.isEmpty(ORDERID))
    	{
    		queryStringBuffer.append(" and a.ORDERID = :ORDERID '" + ORDERID + "' ");
    	}
    	String COMCATEGORY  = conditionMap.get("COMCATEGORY  ");
    	if(!StringUtils.isEmpty(COMCATEGORY ))
    	{
    		queryStringBuffer.append(" and a.COMCATEGORY =  '" + COMCATEGORY  + "' ");
    	}
    	queryStringBuffer.append(" group by a.ORDERID, b.COUNTYID, c.SVCCODE, b.MAREACODE, b.STARLEVEL, b.WAYID, a.COMCATEGORY, a.COMID, a.COMPRICE, a.ACTPRICE ");
    	queryStringBuffer.append(" order by a.ORDERID, b.COUNTYID, c.SVCCODE, b.MAREACODE, b.STARLEVEL, b.WAYID, a.COMCATEGORY, a.COMID, a.COMPRICE, a.ACTPRICE )");
    	
		return queryBySql(queryStringBuffer.toString(), param);
    }
    
}
