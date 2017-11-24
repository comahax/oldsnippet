/**
 * auto-generated code
 * Tue Dec 14 15:42:11 CST 2010
 */
package com.gmcc.pboss.business.sales.wayfxsworder;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.sales.ressum.RessumDBParam;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: WayFxSwOrderDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class WayFxSwOrderDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public WayFxSwOrderDAO(){
        super(WayFxSwOrderVO.class);
    }
    
    /*
    public DataPackage query(WayFxSwOrderDBParam params) throws Exception {
    	params.setSelectFieldsString("COUNTYID,SVCCODE,MAREACODE," +
    			"RECAMT,ACTAMT,STARLEVEL,PAYTYPE,wayid,ORDERSTATE,RECORDTIME");
    	
    	if(null!=params.get_se_countyid()&&!"".equals(params.get_se_countyid())){
    		params.getQueryConditions().put("countyid", params.get_se_countyid());
    	}else{
    		params.getQueryConditions().put("countyid", "");
    	}
    	if(null!=params.get_se_svccode()&&!"".equals(params.get_se_svccode())){
    		params.getQueryConditions().put("SVCCODE", params.get_se_svccode());
    	}else{
    		params.getQueryConditions().put("SVCCODE", "");
    	}
    	if(null!=params.get_se_mareacode() &&!"".equals(params.get_se_mareacode())){
    		params.getQueryConditions().put("MAREACODE", params.get_se_mareacode());
    	}else{
    		params.getQueryConditions().put("MAREACODE", "");
    	}
    	if(null!=params.get_ne_starlevel() &&!"".equals(params.get_ne_starlevel())){
    		params.getQueryConditions().put("STARLEVEL", params.get_ne_starlevel());
    	}else{
    		params.getQueryConditions().put("STARLEVEL", "");
    	}
    	if(null!=params.get_dnl_recordtime() &&!"".equals(params.get_dnl_recordtime())){
    		params.getQueryConditions().put("BEGINTIME", params.get_dnl_recordtime());
    	}else{
    		params.getQueryConditions().put("BEGINTIME", "");
    	}
    	if(null!=params.get_dnm_recordtime() &&!"".equals(params.get_dnm_recordtime())){
    		params.getQueryConditions().put("ENDTIME", params.get_dnm_recordtime());
    	}else{
    		params.getQueryConditions().put("ENDTIME", "");
    	}
    	
    	return queryByNamedSqlQuery("QueryWayFxSwOrderVO", params);
    }
	*/
    public DataPackage doQueryWayFxOrder(Map<String,String> conditionMap, WayFxSwOrderDBParam param) throws Exception {
    	StringBuffer queryStringBuffer = new StringBuffer();
    	queryStringBuffer.append("select ROWNUM as rowcountid ,COUNTYID,SVCCODE,MAREACODE,STARLEVEL,PAYTYPE,sumrecamt,sumactamt from (");
    	queryStringBuffer.append("select a.COUNTYID, b.SVCCODE, a.MAREACODE, a.STARLEVEL, a.PAYTYPE, sum(a.RECAMT) as sumrecamt , sum(a.ACTAMT) as sumactamt");
    	queryStringBuffer.append(" from FX_SW_ORDER a, CH_PW_WAY b ");
    	queryStringBuffer.append(" where a.wayid  = b.wayid  ");
    	queryStringBuffer.append(" and a.orderstate = 'FINISHED' ");
    	
    	String starttimeStr = conditionMap.get("starttimeStr");
    	String endtimeStr = conditionMap.get("endtimeStr");
    	if(!StringUtils.isEmpty(starttimeStr) && !StringUtils.isEmpty(endtimeStr))
    	{
    		queryStringBuffer.append(" and a.RECORDTIME  <= to_date('" + endtimeStr + "','yyyy-MM-dd hh24:mi:ss') ");
        	queryStringBuffer.append(" and a.RECORDTIME  >= to_date('" + starttimeStr + "','yyyy-MM-dd hh24:mi:ss') ");
    	}
    	
    	String COUNTYID = conditionMap.get("COUNTYID");
    	if(!StringUtils.isEmpty(COUNTYID))
    	{
    		queryStringBuffer.append(" and a.COUNTYID = '" + COUNTYID + "' ");
    	}
    	String SVCCODE = conditionMap.get("SVCCODE");
    	if(!StringUtils.isEmpty(SVCCODE))
    	{
    		queryStringBuffer.append(" and b.SVCCODE = '" + SVCCODE + "' ");
    	}
    	String MAREACODE  = conditionMap.get("MAREACODE ");
    	if(!StringUtils.isEmpty(MAREACODE ))
    	{
    		queryStringBuffer.append(" and a.MAREACODE  = '" + MAREACODE  + "' ");
    	}
    	String STARLEVEL = conditionMap.get("STARLEVEL");
    	if(!StringUtils.isEmpty(STARLEVEL))
    	{
    		queryStringBuffer.append(" and a.STARLEVEL = '" + STARLEVEL + "' ");
    	}
    	queryStringBuffer.append(" group by a.COUNTYID, b.SVCCODE, a.MAREACODE, a.STARLEVEL, a.PAYTYPE ");
    	queryStringBuffer.append(" order by a.COUNTYID, b.SVCCODE, a.MAREACODE, a.STARLEVEL, a.PAYTYPE )");
    	
		return queryBySql(queryStringBuffer.toString(), param);
	}
    
}
