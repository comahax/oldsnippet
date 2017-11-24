package com.gmcc.pboss.biz.info.missioner.recommend.success.support;

import java.text.SimpleDateFormat;

import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class MissionerQueryParamProcessor extends DefaultHqlQueryProcessor
	implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		MissionerQueryParameter p = (MissionerQueryParameter)parameter;
		StringBuffer hql = new StringBuffer();
		
		/*
		 * --查询明细字段： 序号  校验规则  发生业务编码  发生业务名称  结算业务编码  
		 * --结算业务名称  结算月份  渠道编码  渠道名称  业务发生时间  专员号码  业务发生号码  
         * --业务量  酬金类型  业务来源  成员属性  元数据流水号
         * --市公司管理员
		 */
		hql.append("select * from (");
		
		hql.append("(select d.seq,d.ruleid,d.opnid,o.name,d.calcopnid,o2.name calname,d.calcmonth,d.wayid,w.wayname,d.oprtime, ");
		hql.append(" d.oprcode,d.mobile,d.busivalue,d.rewardtype,d.ossrc,e.empattr2,d.srcseq ");
		hql.append(" from ch_bbc_allsalesday d,ch_pw_way w,ch_pw_employee e,ch_bbc_operation o,ch_bbc_operation o2 ");
		hql.append(" where d.wayid = w.WAYID and d.oprcode = e.telephone  and d.opnid = o.opnid and d.calcopnid = o2.opnid ");
		
		hql.append(" and d.oprcode =:oprcode " );//联系电话
		
		if(p.getWayid() != null && !"".equals(p.getWayid())){//所属代理商编码
			hql.append(" and d.wayid =:wayid " );
		}
		
		if(p.getWayname() != null && !"".equals(p.getWayname())){//所属代理商名称
			hql.append(" and w.wayname =:wayname " );
		}
		
		if(p.getOpnid() != null && !"".equals(p.getOpnid())){//业务编码
			hql.append(" and d.opnid =:opnid " );
		}
		
		if(p.getOpnname() != null && !"".equals(p.getOpnname())){//业务名称
			hql.append(" and o.name =:name " );
		}
		
		if(p.getOprtimeFrom() != null && !"".equals(p.getOprtimeFrom())){//业务发生时间
			hql.append(" and d.oprtime >=to_date(:oprtimeFrom,'yyyy-MM-dd hh24miss') " );
		}
		if(p.getOprtimeTo() != null && !"".equals(p.getOprtimeTo())){//业务发生时间
			hql.append(" and d.oprtime <=to_date(:oprtimeTo,'yyyy-MM-dd hh24miss') " );
		}
		
		hql.append(" ) ");
		
		hql.append(" union ");
		
		hql.append(" (select v.seq,v.ruleid,v.opnid,o.name,v.calcopnid,o2.name calname,v.calcmonth,v.wayid,w.wayname,v.oprtime, ");
		hql.append(" v.oprcode,v.mobile,v.busivalue,v.rewardtype,v.ossrc,e.empattr2,v.srcseq ");
		hql.append(" from ch_bbc_allsaleshis_view v,ch_pw_way w,ch_pw_employee e,ch_bbc_operation o,ch_bbc_operation o2 ");
		hql.append(" where v.WAYID = w.WAYID  and v.OPRCODE = e.telephone  and v.OPNID = o.opnid  and v.calcopnid = o2.opnid ");
		
		hql.append(" and v.oprcode =:oprcode " );//联系电话
		
		if(p.getWayid() != null && !"".equals(p.getWayid())){//所属代理商编码
			hql.append(" and v.wayid >=:wayid " );
		}
		
		if(p.getWayname() != null && !"".equals(p.getWayname())){//所属代理商名称
			hql.append(" and w.wayname =:wayname " );
		}
		
		if(p.getOpnid() != null && !"".equals(p.getOpnid())){//业务编码
			hql.append(" and v.opnid =:opnid " );
		}
		
		if(p.getOpnname() != null && !"".equals(p.getOpnname())){//业务名称
			hql.append(" and o.name =:name " );
		}
		
		if(p.getOprtimeFrom() != null && !"".equals(p.getOprtimeFrom())){//业务发生时间
			hql.append(" and v.oprtime >=to_date(:oprtimeFrom,'yyyy-MM-dd hh24miss') " );
		}
		if(p.getOprtimeTo() != null && !"".equals(p.getOprtimeTo())){//业务发生时间
			hql.append(" and v.oprtime <=to_date(:oprtimeTo,'yyyy-MM-dd hh24miss') " );
		}
		
		hql.append(" ) ");
		
		hql.append(")");
		
		return hql.toString();
	}

	@Override
	public String[] getParamEncloseName() {
		
		return null;
	}

	@Override
	public void process(Query query, QueryParameter parameter) {
		MissionerQueryParameter p = (MissionerQueryParameter)parameter;
		
		query.setString("oprcode", p.getTelephone());//联系电话
		
		if(p.getWayid() != null && !"".equals(p.getWayid())){//所属代理商编码
			query.setString("wayid", p.getWayid());
		}
		
		if(p.getWayname() != null && !"".equals(p.getWayname())){//所属代理商名称
			query.setString("wayname", p.getWayname());
		}
		
		if(p.getOpnid() != null && !"".equals(p.getOpnid())){//业务编码
			query.setString("opnid", p.getOpnid());
		}
		
		if(p.getOpnname() != null && !"".equals(p.getOpnname())){//业务名称
			query.setString("name", p.getOpnname());
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		if(p.getOprtimeFrom() != null && !"".equals(p.getOprtimeFrom())){//业务发生时间			
			String oprtimeFrom = sdf.format(p.getOprtimeFrom()) +" 000000";
			query.setString("oprtimeFrom", oprtimeFrom);
			
		}
		if(p.getOprtimeTo() != null && !"".equals(p.getOprtimeTo())){//业务发生时间
			String oprtimeTo = sdf.format(p.getOprtimeTo())+" 235959";
			query.setString("oprtimeTo", oprtimeTo);
		}	
		
	}

}
