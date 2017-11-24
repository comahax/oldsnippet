/**
 * auto-generated code
 * Sat Dec 18 09:48:51 CST 2010
 */
package com.gmcc.pboss.business.sales.orderresdetwayorder;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderresdetWayOrderDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OrderresdetWayOrderDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public OrderresdetWayOrderDAO(){
        super(OrderresdetWayOrderVO.class);
    }
    
    public DataPackage doQueryOrderresdetWayOrder(Map<String,String> conditionMap, OrderresdetWayOrderDBParam param) throws Exception {
    	StringBuffer queryStringBuffer = new StringBuffer();
//    	queryStringBuffer.append("select  ROWNUM as rowcountid , COUNTYID, SVCCODE, MAREACODE, STARLEVEL,COMNAME , COMPRICE, ACTPRICE, countvalue from (");
//    	queryStringBuffer.append("select b.COUNTYID, c.SVCCODE, b.MAREACODE, b.STARLEVEL, d.COMNAME, a.COMPRICE, a.ACTPRICE, count(*) as countvalue");
//    	queryStringBuffer.append(" from FX_SW_ORDERRESDET a, FX_SW_ORDER b, CH_PW_WAY c, IM_PR_COM d");
    	queryStringBuffer.append(" select  ROWNUM as rowcountid , COUNTYID, SVCCODE, MAREACODE, STARLEVEL,RESTYPE ,COMCATEGORY ,COMID , COMPRICE, ACTPRICE, countvalue from (");
    	queryStringBuffer.append(" select b.COUNTYID, c.SVCCODE, b.MAREACODE, b.STARLEVEL, a.RESTYPE, a.COMCATEGORY, a.COMID, a.COMPRICE, a.ACTPRICE, count(*) as countvalue");
    	queryStringBuffer.append(" from FX_SW_ORDERRESDET a, FX_SW_ORDER b, CH_PW_WAY c ");
    	queryStringBuffer.append(" where a.ORDERID = b.ORDERID ");
    	queryStringBuffer.append(" and b.WAYID = c.WAYID ");
    	queryStringBuffer.append(" and b.ORDERSTATE = 'FINISHED' ");
//    	queryStringBuffer.append(" and  a.COMID = d.COMID ");
    	
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
    	String STARLEVEL = conditionMap.get("STARLEVEL");
    	if(!StringUtils.isEmpty(STARLEVEL))
    	{
    		queryStringBuffer.append(" and b.STARLEVEL = '" + STARLEVEL + "' ");
    	}
//    	queryStringBuffer.append(" group by b.COUNTYID, c.SVCCODE, b.MAREACODE, b.STARLEVEL, d.COMNAME, a.COMPRICE, a.ACTPRICE ");
//    	queryStringBuffer.append(" order by b.COUNTYID, c.SVCCODE, b.MAREACODE, b.STARLEVEL, d.COMNAME, a.COMPRICE, a.ACTPRICE )");
    	queryStringBuffer.append(" group by b.COUNTYID, c.SVCCODE, b.MAREACODE, b.STARLEVEL, a.RESTYPE, a.COMCATEGORY, a.COMID, a.COMPRICE, a.ACTPRICE ");
    	queryStringBuffer.append(" order by b.COUNTYID, c.SVCCODE, b.MAREACODE, b.STARLEVEL, a.RESTYPE, a.COMCATEGORY, a.COMID, a.COMPRICE, a.ACTPRICE )");
    	
		return queryBySql(queryStringBuffer.toString(), param);
	}
    
}
