/**
 * auto-generated code
 * Tue Oct 13 09:30:24 CST 2009
 */
package com.gmcc.pboss.business.sales.chargesum;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: CompriceDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChargesumDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public ChargesumDAO(){
        super(ChargesumVO.class);
    }
    
    public DataPackage doQueryChargesum(Map<String,String> conditionMap, ChargesumDBParam param) throws Exception {
    	StringBuffer queryStringBuffer = new StringBuffer();
    	queryStringBuffer.append("select b.wayid, a.paytype, sum(a.recamt) as recamt, sum(a.actamt) as actamt ");
    	queryStringBuffer.append(" from FX_SW_ORDER a, (select distinct(orderid),wayid from FX_SW_ORDERRESDET) b ");
    	queryStringBuffer.append(" where a.orderid = b.orderid ");
    	queryStringBuffer.append(" and a.orderstate = 'FINISHED' ");
    	
    	String wayid = conditionMap.get("wayid");
    	if(!StringUtils.isEmpty(wayid))
    	{
    		queryStringBuffer.append(" and b.wayid = '" + wayid + "' ");
    	}
    	
    	String starttimeStr = conditionMap.get("starttimeStr");
    	String endtimeStr = conditionMap.get("endtimeStr");
    	if(!StringUtils.isEmpty(starttimeStr) && !StringUtils.isEmpty(endtimeStr))
    	{
    		queryStringBuffer.append(" and a.statechgtime <= to_date('" + endtimeStr + "','yyyy-MM-dd hh24:mi:ss') ");
        	queryStringBuffer.append(" and a.statechgtime >= to_date('" + starttimeStr + "','yyyy-MM-dd hh24:mi:ss') ");
    	}
    	queryStringBuffer.append(" group by b.wayid, a.paytype ");
    	
		return queryBySql(queryStringBuffer.toString(), param);
	}
}
