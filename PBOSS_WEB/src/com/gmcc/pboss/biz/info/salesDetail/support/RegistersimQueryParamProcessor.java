package com.gmcc.pboss.biz.info.salesDetail.support;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class RegistersimQueryParamProcessor extends DefaultHqlQueryProcessor
		implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		RegistersimQueryParameter p = (RegistersimQueryParameter)parameter;
		
		StringBuffer hql = new StringBuffer();
		//下面是使用Oracle SQL的外连接查询
		/*hql.append("select " +
				"ttt.wayid,ttt.wayname,ttt.countyid,ttt.starlevel,ttt.employeename," +
				"ttt.officetel,ttt.mobile,ttt.brand,ttt.comname,ttt.comtype,ttt.comclassid,ttt.comprice,ttt.oprtime," +
				"TO_CHAR(n.activedate, 'yyyy-MM-dd hh24:mi:ss') AS activedate,ttt.mendfalg " +
				"from (");*/
		
		hql.append("select r.wayid,w.wayname,w.countyid,to_char(w.starlevel) as starlevel,e.employeename, ");
		hql.append("	e.officetel,r.mobile,to_char(r.brand) as brand,r.comname,to_char(r.comtype) as comtype,to_char(r.comclassid) as comclassid,to_char(r.comprice/100) as comprice, ");
		hql.append("	to_char(r.oprtime, 'yyyy-MM-dd hh24:mi:ss') as oprtime, ");
		hql.append("	TO_CHAR(n.activedate, 'yyyy-MM-dd hh24:mi:ss') AS activedate, ");
		hql.append("	to_char(r.mendfalg) as mendfalg ");
		hql.append(" from fx_sn_noactinfo n, ch_pw_employee e, ch_pw_way w, ch_pw_registersim r ");// fx_sn_noactinfo n
		
		/*hql.append(" (select mobileno, activedate from fx_sn_noactinfo ");
		hql.append(" where activedate>=to_date(:active3month,'yyyy-mm-dd hh24:mi:ss')");//使用命名参数更高效*/
		//在激活时间存在的情况下，减少子查询的数据量
		/*if(p.getActiveFrom()!=null && p.getActiveTo()!=null){
			//hql.append(" and n.activedate between :activeFrom and :activeTo");//20110513--可执行但处理方式不是很好
			hql.append(" and activedate between to_date(:activeFrom,'yyyy-mm-dd hh24:mi:ss') and to_date(:activeTo,'yyyy-mm-dd hh24:mi:ss') ");
		}*/
		//hql.append(") n");
		
		hql.append("  where r.mobile=n.mobileno(+) ");
		hql.append(" and n.activedate(+)>=to_date(:active3month,'yyyy-mm-dd hh24:mi:ss')");//使用命名参数更高效*/
		hql.append("	AND r.oprcode=e.employeeid ");
		hql.append("	AND r.wayid=w.wayid ");		
		
		if(p.getActiveFrom()!=null && p.getActiveTo()!=null){
			//hql.append(" and n.activedate between :activeFrom and :activeTo");//20110513--可执行但处理方式不是很好
			hql.append(" and (activedate between to_date(:activeFrom,'yyyy-mm-dd hh24:mi:ss') and to_date(:activeTo,'yyyy-mm-dd hh24:mi:ss')) ");
		}
		
		/***/
		//地市码
		if(StringUtils.isNotEmpty(p.getCityid()));{
			hql.append(" and r.cityid = :cityid ");
		}
		//网店编码
		if(StringUtils.isNotEmpty(p.getWayid())){
			hql.append(" and r.wayid = :wayid ");
		}	
		//店员-人员编码，套卡表的oprcode对应人员表的人员编码，非人员工号
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
		//套卡号码
		if(StringUtils.isNotEmpty(p.getMobile())){
			hql.append(" and r.mobile =:mobile ");
		}
		//品牌
		if(StringUtils.isNotEmpty(p.getBrand())){
			hql.append(" and r.brand =:brand ");
		}
		//商品类型
		if(StringUtils.isNotEmpty(p.getType())){
			hql.append(" and r.comclassid=:type ");
		}
		//登记方式
		if(StringUtils.isNotEmpty(p.getFlag())){
			hql.append(" and r.mendfalg =:flag");
		}
		//登记起始时间
		//登记结束时间
		if(p.getStartDate()!=null && p.getEndDate()!=null){
			//hql.append(" and r.oprtime between :start and :end");//20110513--可执行但处理方式不是很好
			hql.append(" and r.oprtime between to_date(:start,'yyyy-mm-dd hh24:mi:ss') and to_date(:end,'yyyy-mm-dd hh24:mi:ss')");
		}
	    
		hql.append(" order by r.seqid");
		
		/*hql.append("  ) ttt ");
		
		hql.append("  LEFT JOIN fx_sn_noactinfo n ");
		hql.append("  ON ttt.mobile = n.mobileno ");
		hql.append(" where activedate>=to_date(:active3month,'yyyy-mm-dd hh24:mi:ss')");//使用命名参数更高效
		*/
		//在激活时间存在的情况下，减少子查询的数据量
		/*if(p.getActiveFrom()!=null && p.getActiveTo()!=null){
			//hql.append(" and n.activedate between :activeFrom and :activeTo");//20110513--可执行但处理方式不是很好
			hql.append(" and (activedate between to_date(:activeFrom,'yyyy-mm-dd hh24:mi:ss') and to_date(:activeTo,'yyyy-mm-dd hh24:mi:ss')) ");
		}*/
		
		return hql.toString();
	}
	
	public String getCntHql(QueryParameter parameter){
		String countQueryString = " select count (*)  from ( "
			+ this.getHql(parameter)
			+ " )";
		return countQueryString;
	}

	@Override
	public String[] getParamEncloseName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void process(Query query, QueryParameter parameter) {
		// TODO Auto-generated method stub
		/***/
		RegistersimQueryParameter p = (RegistersimQueryParameter)parameter;
		//地市码--业务编码必须满足 opntype=1,smsno=10086111,cityid=当前登录人员地市
		if(StringUtils.isNotEmpty(p.getCityid()));{
			query.setString("cityid",p.getCityid());
		}
		//网店编码
		if(StringUtils.isNotEmpty(p.getWayid())){
			query.setString("wayid", p.getWayid());
		}
		//店员-工号
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
		//套卡号码
		if(StringUtils.isNotEmpty(p.getMobile())){
			query.setString("mobile", p.getMobile().trim());
		}
		//品牌
		if(StringUtils.isNotEmpty(p.getBrand())){
			query.setShort("brand", Short.parseShort(p.getBrand()));
		}
		//登记方式
		if(StringUtils.isNotEmpty(p.getFlag())){
			query.setByte("flag", Byte.parseByte(p.getFlag()));
		}
		//商品类型
		if(StringUtils.isNotEmpty(p.getType())){
			query.setInteger("type", Integer.parseInt(p.getType()));
		}
		//登记起始时间
		//登记结束时间
		if(p.getStartDate()!=null && p.getEndDate()!=null){
			String start = (new java.sql.Date(p.getStartDate().getTime())).toString()+" 00:00:00";
			String end = (new java.sql.Date(p.getEndDate().getTime())).toString()+" 23:59:59";
			query.setString("start", start);
			query.setString("end", end);
		}
		
		//激活时间不早于当前时间按3个月
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date(System.currentTimeMillis());		
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.set(Calendar.MONTH, c.get(Calendar.MONTH)-3);
		query.setString("active3month", sdf.format(c.getTime()));
		//激活起始时间
		//激活结束时间
		if(p.getActiveFrom()!=null && p.getActiveTo()!=null){
			String start = (new java.sql.Date(p.getActiveFrom().getTime())).toString()+" 00:00:00";
			String end = (new java.sql.Date(p.getActiveTo().getTime())).toString()+" 23:59:59";
			query.setString("activeFrom", start);
			query.setString("activeTo", end);
		}
		
	}

}
