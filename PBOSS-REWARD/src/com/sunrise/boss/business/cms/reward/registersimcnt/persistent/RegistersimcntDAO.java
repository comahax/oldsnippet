/**
* auto-generated code
* Mon Feb 21 10:37:21 CST 2011
*/
package com.sunrise.boss.business.cms.reward.registersimcnt.persistent;

import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * <p>Title: RegistersimcntDAO</p>
 * <p>Description: Data Access Object for RegistersimcntVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class RegistersimcntDAO extends BaseDAO {

    /**
     * default constructor
     */
    public RegistersimcntDAO(){
        super(RegistersimcntVO.class);
    }
    
    public DataPackage doQuerycnt(RegistersimcntListVO param) 
		throws Exception{
		StringBuffer queryStringBuffer = new StringBuffer();
		queryStringBuffer.append(" SELECT ROWNUM AS SEQID,T.* FROM (SELECT WAYID,WAYNAME,COUNTYID,STARLEVEL,COUNT(*) CNT FROM ( ");
		queryStringBuffer.append(" SELECT DISTINCT A.WAYID,A.SEQID,A.OPRCODE,C.WAYNAME,C.WAYMAGCODE,C.COUNTYID,C.STARLEVEL,C.SVCCODE,D.EMPLOYEEID,D.EMPLOYEENAME,null AS NAME,D.OFFICETEL,A.MOBILE,A.BRAND,A.OPNID,A.OPRTIME,B.ACTIVEDATE ");
		queryStringBuffer.append(" FROM CH_PW_REGISTERSIM A,FX_SN_NOACTINFO B,CH_PW_WAY C,CH_PW_EMPLOYEE D ");
		queryStringBuffer.append(" WHERE A.WAYID = C.WAYID ");
		queryStringBuffer.append(" AND A.OPRCODE = D.EMPLOYEEID ");
//		queryStringBuffer.append(" AND E.EMPLOYEEID = C.WAYMAGCODE ");
		queryStringBuffer.append(" AND B.MOBILENO(+) = A.MOBILE AND A.CITYID = :CITYID ");
		// 参数备份
		RegistersimcntListVO paramcnt = new RegistersimcntListVO();
		BeanUtils.copyProperties(paramcnt, param);
		// 登记时间
		String starttime = param.get_dnl_oprtime();
		String endtime = param.get_dnm_oprtime();
		if(!StringUtils.isEmpty(starttime) && !StringUtils.isEmpty(endtime))
		{
//			queryStringBuffer.append(" and A.OPRTIME  <= to_date('" + endtime + "','yyyy-MM-dd hh24:mi:ss') ");
//	    	queryStringBuffer.append(" and A.OPRTIME  >= to_date('" + starttime + "','yyyy-MM-dd hh24:mi:ss') ");
	    	queryStringBuffer.append(" and A.OPRTIME  <= :endtime ");
	    	queryStringBuffer.append(" and A.OPRTIME  >= :starttime ");
	    	param.getQueryConditions().put("endtime", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(endtime.toString()));
	    	param.getQueryConditions().put("starttime", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(starttime.toString()));
	    	param.set_dnl_oprtime(null);
	    	param.set_dnm_oprtime(null);
		}
		// 激活时间
		String starttime1 = param.get_dnl_activedate();
		String endtime1 = param.get_dnm_activedate();
		if(!StringUtils.isEmpty(starttime1) && !StringUtils.isEmpty(endtime1))
		{
//			queryStringBuffer.append(" and B.ACTIVEDATE  <= to_date('" + endtime1 + "','yyyy-MM-dd hh24:mi:ss') ");
//	    	queryStringBuffer.append(" and B.ACTIVEDATE  >= to_date('" + starttime1 + "','yyyy-MM-dd hh24:mi:ss') ");
	    	queryStringBuffer.append(" and B.ACTIVEDATE(+)  <= :endtime1 ");
	    	queryStringBuffer.append(" and B.ACTIVEDATE(+)  >= :starttime1 ");
	    	param.getQueryConditions().put("endtime1", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(endtime1.toString()));
	    	param.getQueryConditions().put("starttime1", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(starttime1.toString()));
	    	param.set_dnl_activedate(null);
	    	param.set_dnm_activedate(null);
		}
		// 销售服务中心
		String svccode = param.get_se_svccode();
		if(!StringUtils.isEmpty(svccode))
		{
			queryStringBuffer.append(" and C.SVCCODE = '" + svccode + "' ");
			param.set_se_svccode(null);
		}
		// 所属渠道经理
		String waymagcode  = param.get_se_waymagcode();
		if(!StringUtils.isEmpty(waymagcode))
		{
			queryStringBuffer.append(" and C.WAYMAGCODE = '" + waymagcode  + "' ");
			param.set_se_waymagcode(null);
		}
		// 品牌
		String brand = param.get_ne_brand();
		if(!StringUtils.isEmpty(brand))
		{
			queryStringBuffer.append(" and A.BRAND = '" + brand + "' ");
			param.set_ne_brand(null);
		}
		// 网点编码
		String wayid = param.get_se_wayid();
		if(!StringUtils.isEmpty(wayid))
		{
			queryStringBuffer.append(" and A.WAYID = '" + wayid + "' ");
			param.set_se_wayid(null);
		}
		// 分公司
		String countyid = param.get_se_countyid();
		if(!StringUtils.isEmpty(countyid))
		{
			queryStringBuffer.append(" and C.COUNTYID = '" + countyid + "' ");
			param.set_se_countyid(null);
		}
		queryStringBuffer.append(") group by  WAYID,WAYNAME,COUNTYID,STARLEVEL  order by  WAYID) T ");
		
		DataPackage dp = queryBySql(queryStringBuffer.toString(), param);
		// 参数还原
		BeanUtils.copyProperties(param, paramcnt);
		
		return dp;
    }
}
