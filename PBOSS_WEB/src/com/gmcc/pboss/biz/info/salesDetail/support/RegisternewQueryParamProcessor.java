package com.gmcc.pboss.biz.info.salesDetail.support;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

/**
 * 新业务销售明细-查询参数处理器CH_PW_REGISTERNEW
 * @author Administrator
 *
 */
public class RegisternewQueryParamProcessor 
			extends DefaultHqlQueryProcessor implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		RegisternewQueryParameter p = (RegisternewQueryParameter)parameter;
		
		StringBuffer hql = new StringBuffer();
		//HQL
		//hql.append("select new com.gmcc.pboss.biz.info.salesDetail.model.RegisternewDetail(");
		//hql.append(" r.wayid,w.wayname,w.countyid,w.starlevel,e.employeename,e.officetel,");
		//hql.append(" r.mobile,r.brand,r.opnid,o.opnname,to_char(r.oprtime,'yyyy-MM-dd hh24:mi:ss') as oprtime )");//to_char(r.oprtime,'yyyy-MM-dd hh24:mi:ss') as oprtime
		//hql.append(" from com.gmcc.pboss.biz.info.salesDetail.model.ChPwRegisternew r,");
		//hql.append(" com.gmcc.pboss.biz.info.node.model.Way w,");
		//hql.append(" com.gmcc.pboss.member.model.Employee e,");
		//hql.append(" com.gmcc.pboss.biz.info.salesDetail.model.ChPwOperationsms o");
		//hql.append(" where r.wayid=w.wayid and r.oprcode=e.oprcode and r.opnid=o.id.opnid  and o.id.opntype='2' and o.id.smsno='10086111'");
		
		hql.append("select r.WAYID,w.WAYNAME,w.COUNTYID,to_char(w.STARLEVEL),e.EMPLOYEENAME,e.OFFICETEL,r.MOBILE,");
		hql.append("	to_char(r.BRAND),r.OPNID,o.OPNNAME,to_char(r.OPRTIME, 'yyyy-MM-dd hh24:mi:ss')");
		hql.append("  from CH_PW_REGISTERNEW r,CH_PW_WAY w,CH_PW_EMPLOYEE e,");
		hql.append("	(select opnid,opnname from CH_PW_OPERATIONSMS where opntype=2 and smsno='10086111' and cityid=:cityid) o");
		hql.append("  where r.WAYID = w.WAYID");
		hql.append("	and r.OPRCODE = e.employeeid");
		hql.append("	and r.OPNID = o.OPNID(+)");
		
		//地市码--业务编码必须满足 opntype=2,smsno=10086111,cityid=当前登录人员地市
		if(StringUtils.isNotEmpty(p.getCityid()));{
			//hql.append(" and o.id.cityid = :cityid ");
			hql.append(" and r.cityid = :cityid ");
		}
		//网店编码
		if(StringUtils.isNotEmpty(p.getWayid())){
			hql.append(" and r.wayid = :wayid ");
		}	
		//店员-工号
		if(StringUtils.isNotEmpty(p.getOprcode())){
			hql.append(" and r.oprcode =:oprcode ");
		}
		//分公司
		if(StringUtils.isNotEmpty(p.getCountyid())){
			hql.append(" and w.countyid =:countyid ");
		}
		//销售服务中
		if(StringUtils.isNotEmpty(p.getSvccode())){
			hql.append(" and w.svccode =:svccode ");
		}
		//业务编码
		if(StringUtils.isNotEmpty(p.getOpnid())){
			hql.append(" and r.opnid =:opnid ");
		}
		//品牌
		if(StringUtils.isNotEmpty(p.getBrand())){
			hql.append(" and r.brand =:brand ");
		}
		//登记起始时间
		//登记结束时间
		if(p.getStartDate()!=null && p.getEndDate()!=null){
			//hql.append(" and r.oprtime between :start and :end");//20110513--可执行但处理方式不是很好
			hql.append(" and r.oprtime between to_date(:start,'yyyy-mm-dd hh24:mi:ss') and to_date(:end,'yyyy-mm-dd hh24:mi:ss')");
		}
		hql.append(" order by r.seqid");
		
		return hql.toString();
	}

	@Override
	public String[] getParamEncloseName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void process(Query query, QueryParameter parameter) {
		// TODO Auto-generated method stub
		RegisternewQueryParameter p = (RegisternewQueryParameter)parameter;
		//地市码--业务编码必须满足 opntype=2,smsno=10086111,cityid=当前登录人员地市
		if(StringUtils.isNotEmpty(p.getCityid()));{
			query.setString("cityid",p.getCityid());
		}
		//网店编码
		if(StringUtils.isNotEmpty(p.getWayid())){
			query.setString("wayid", p.getWayid());
		}
		//店员-人员编码，CH_PW_REGISTERNEW中oprcode与人员表id对应
		if(StringUtils.isNotEmpty(p.getOprcode())){
			query.setString("oprcode", p.getOprcode());
		}
		//分公司
		if(StringUtils.isNotEmpty(p.getCountyid())){
			query.setString("countyid", p.getCountyid());
		}
		//销售服务中
		if(StringUtils.isNotEmpty(p.getSvccode())){
			query.setString("svccode", p.getSvccode());
		}
		//业务编码
		if(StringUtils.isNotEmpty(p.getOpnid())){
			query.setString("opnid", p.getOpnid().trim());
		}
		//品牌
		if(StringUtils.isNotEmpty(p.getBrand())){
			query.setShort("brand", Short.parseShort(p.getBrand()));
		}
		//登记起始时间
		//登记结束时间
		if(p.getStartDate()!=null && p.getEndDate()!=null){
			/**20110513--可执行但处理方式不是很好
			query.setDate("start", p.getStartDate());
			Date end = p.getEndDate();	
			//通过下面的时间设置方式，无法将时间数据映射到Oracle,
			//只能映射日期数据，且时间默认为零点
			//end = DateUtils.addHours(end, 23);
			//end = DateUtils.addMinutes(end, 59);
			//end = DateUtils.addSeconds(end, 59);
			end = DateUtils.addDays(end, 1);
			query.setDate("end", end);
			**/
			String start = (new java.sql.Date(p.getStartDate().getTime())).toString()+" 00:00:00";
			String end = (new java.sql.Date(p.getEndDate().getTime())).toString()+" 23:59:59";
			query.setString("start", start);
			query.setString("end", end);
		}
	}
}
