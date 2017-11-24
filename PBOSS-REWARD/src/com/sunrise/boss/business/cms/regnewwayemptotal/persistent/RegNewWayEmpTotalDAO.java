/**
* auto-generated code
* Thu Feb 24 15:31:21 CST 2011
*/
package com.sunrise.boss.business.cms.regnewwayemptotal.persistent;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;

/**
 * <p>Title: RegNewWayEmpTotalDAO</p>
 * <p>Description: Data Access Object for RegNewWayEmpTotalVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class RegNewWayEmpTotalDAO extends BaseDAO {

    /**
     * default constructor
     */
    public RegNewWayEmpTotalDAO(){
        super(RegNewWayEmpTotalVO.class);
    }
    
    public  DataPackage  queryAMT(RegNewWayEmpTotalListVO param)throws Exception {
    	
    	StringBuffer queryStringBuffer = new StringBuffer();
    	queryStringBuffer.append(" select  wayid  , wayname, countyid, starlevel,count(*) as AMT from  (  ");
    	queryStringBuffer.append(" select DISTINCT a.wayid, c.wayname, c.waymagcode, c.countyid, c.starlevel,d.employeename,e.employeename AS name,d.officeTel," +
    								"a.mobile,a.brand,a.opnid,a.oprtime,a.SEQID,a.OPRCODE,c.SVCCODE,d.EMPLOYEEID ");
//    	queryStringBuffer.append(" from common.CH_PW_REGISTERNEW a, ch_pw_way c, ch_pw_employee d,CH_PW_EMPLOYEE e ");
    	queryStringBuffer.append(" from CH_PW_REGISTERNEW a, ch_pw_way c, ch_pw_employee d,CH_PW_EMPLOYEE e ");
    	queryStringBuffer.append(" where  a.wayid = c.wayid ");
    	queryStringBuffer.append("  and a.OPRCODE = d.EMPLOYEEID ");
    	queryStringBuffer.append(" and e.EMPLOYEEID = c.WAYMAGCODE ");
    	
    	// 参数备份
    	RegNewWayEmpTotalListVO empTotalDBParam=new RegNewWayEmpTotalListVO();
    	BeanUtils.copyProperties(empTotalDBParam, param);
    	
    	String magCode=param.get_se_waymagcode();
    	param.set_se_waymagcode(null);
    	if(!StringUtils.isEmpty(magCode))
    	{
    		queryStringBuffer.append(" and c.waymagcode = '" + magCode + "' ");
    	}
    	String SVCCODE = param.get_se_svccode();
    	param.set_se_svccode(null);
    	if(!StringUtils.isEmpty(SVCCODE))
    	{
    		queryStringBuffer.append(" and c.SVCCODE = '" + SVCCODE + "' ");
    	}
    	String minTime=param.get_dnl_oprtime();
		String maxTime=param.get_dnm_oprtime();
		param.set_dnl_oprtime(null);
		param.set_dnm_oprtime(null);
    	if(!StringUtils.isEmpty(minTime) && !StringUtils.isEmpty(maxTime))
    	{
    		queryStringBuffer.append(" and a.oprtime  <= to_date('" + maxTime + "','yyyy-MM-dd hh24:mi:ss') ");
        	queryStringBuffer.append(" and a.oprtime  >= to_date('" + minTime + "','yyyy-MM-dd hh24:mi:ss') ");
    	}
    	String brand=param.get_ne_brand();
    	param.set_ne_brand(null);
    	if(!StringUtils.isEmpty(brand) )
    	{
    		queryStringBuffer.append(" and a.brand = '" + brand + "' ");
    	}
    	
    	// 网点编码
		String wayid = param.get_se_wayid();
		if(!StringUtils.isEmpty(wayid))
		{
			queryStringBuffer.append(" and a.WAYID = '" + wayid + "' ");
			param.set_se_wayid(null);
		}
		// 分公司
		String countyid = param.get_se_countyid();
		if(!StringUtils.isEmpty(countyid))
		{
			queryStringBuffer.append(" and c.COUNTYID = '" + countyid + "' ");
			param.set_se_countyid(null);
		}
    	
    	queryStringBuffer.append(" ) group by wayid,wayname,countyid,starlevel ");
    	queryStringBuffer.append(" order by wayid,wayname,countyid,starlevel ");
    	
    	DataPackage dp = queryBySql(queryStringBuffer.toString(), param);
    	// 参数还原
    	BeanUtils.copyProperties(param, empTotalDBParam);
    	
		return dp;
   
	}
    
}
