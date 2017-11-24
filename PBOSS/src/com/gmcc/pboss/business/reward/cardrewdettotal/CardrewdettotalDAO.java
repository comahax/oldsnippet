/**
 * auto-generated code
 * Tue Oct 18 19:25:01 CST 2011
 */
package com.gmcc.pboss.business.reward.cardrewdettotal;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: CardrewdettotalDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CardrewdettotalDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public CardrewdettotalDAO(){
        super(CardrewdettotalVO.class);
    }
    
    public DataPackage doGroup(Map<String, String> conditionMap,
    		CardrewdettotalDBParam params) throws Exception {
    	
    	StringBuffer queryStringBuffer = new StringBuffer();
    	
		queryStringBuffer.append(" select   ROWNUM as rowcountid ,WAYID,REWARDTYPE, rechargemonth, activemonth,CMONTH, rewardtotal from ( ");
		queryStringBuffer.append(" select WAYID,REWARDTYPE, rechargemonth, activemonth,CMONTH, sum(REWARDNUM) as rewardtotal from ( ");
		queryStringBuffer.append(" select WAYID,REWARDTYPE, to_char(RECHARGETIME, 'yyyyMM') as rechargemonth,to_char(ACTIVETIME, 'yyyyMM') as activemonth,CMONTH,REWARDNUM");
    	queryStringBuffer.append(" from CH_ADT_CARDREWDET where 1=1 ");
    	String lactive=conditionMap.get("lactive");
    	if(!StringUtils.isEmpty(lactive)&&lactive!=null){
    		queryStringBuffer.append(" and ACTIVETIME  >= to_date('" + lactive + "','yyyy-MM-dd hh24:mi:ss') ");
    	}
    	String mactive=conditionMap.get("mactive");
    	if(!StringUtils.isEmpty(mactive)&&mactive!=null){
    		queryStringBuffer.append(" and ACTIVETIME  <= to_date('" + mactive + "','yyyy-MM-dd hh24:mi:ss') ");
    	}
    	String lrecharge=conditionMap.get("lrecharge");
    	if(!StringUtils.isEmpty(lrecharge)&&lrecharge!=null){
    		queryStringBuffer.append(" and RECHARGETIME  >= to_date('" + lrecharge + "','yyyy-MM-dd hh24:mi:ss') ");
    	}
    	String mrecharge=conditionMap.get("mrecharge");
    	if(!StringUtils.isEmpty(mrecharge)&&mrecharge!=null){
    		queryStringBuffer.append(" and RECHARGETIME  <= to_date('" + mrecharge + "','yyyy-MM-dd hh24:mi:ss') ");
    	}
    	String wayid = conditionMap.get("wayid");
    	if(!StringUtils.isEmpty(wayid)&&wayid!=null)
    	{
    		queryStringBuffer.append(" and wayid = '" + wayid + "' ");
    	}
    	queryStringBuffer.append(" ) group by wayid, REWARDTYPE, rechargemonth, activemonth, CMONTH,REWARDNUM  ");
    	queryStringBuffer.append(" order by wayid, REWARDTYPE, rechargemonth, activemonth, CMONTH,REWARDNUM ) ");
    	
		return queryBySql(queryStringBuffer.toString(), params);
    }
    
}
