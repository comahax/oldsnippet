package com.gmcc.pboss.biz.info.missioner.recommend.success.support;

import java.text.SimpleDateFormat;

import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class AgencyQueryParamProcessor extends DefaultHqlQueryProcessor
	implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		MissionerQueryParameter p = (MissionerQueryParameter)parameter;
		StringBuffer hql = new StringBuffer();
		
		/*
		 * --��ѯ��ϸ�ֶΣ� ���  У�����  ����ҵ�����  ����ҵ������  ����ҵ�����  
		 * --����ҵ������  �����·�  ��������  ��������  ҵ����ʱ��  רԱ����  ҵ��������  
         * --ҵ����  �������  ҵ����Դ  ��Ա����  Ԫ������ˮ��
         * --�й�˾����Ա
		 */
		hql.append("select * from (");
		
		hql.append("(select d.seq,d.ruleid,d.opnid,o.name,d.calcopnid,o2.name calname,d.calcmonth,d.wayid,w.wayname,d.oprtime, ");
		hql.append(" d.oprcode,d.mobile,d.busivalue,d.rewardtype,d.ossrc,e.empattr2,d.srcseq ");
		hql.append(" from ch_bbc_allsalesday d,ch_pw_way w,ch_pw_employee e,ch_bbc_operation o,ch_bbc_operation o2 ");
		hql.append(" where d.wayid = w.WAYID and d.oprcode = e.telephone  and d.opnid = o.opnid and d.calcopnid = o2.opnid ");
		
		hql.append(" and d.wayid =:wayid " );//������
		
		if(p.getOprcode() != null && !"".equals(p.getOprcode())){//רԱ����
			hql.append(" and d.oprcode =:oprcode " );
		}
		
		if(p.getEmpattr2() != null && !"".equals(p.getEmpattr2())){//��Ա����
			hql.append(" and e.empattr2 =:empattr2 " );
		}
		
		if(p.getOpnid() != null && !"".equals(p.getOpnid())){//ҵ�����
			hql.append(" and d.opnid =:opnid " );
		}
		
		if(p.getOpnname() != null && !"".equals(p.getOpnname())){//ҵ������
			hql.append(" and o.name =:name " );
		}
		
		if(p.getOprtimeFrom() != null && !"".equals(p.getOprtimeFrom())){//ҵ����ʱ��
			hql.append(" and d.oprtime >=to_date(:oprtimeFrom,'yyyy-MM-dd hh24miss') " );
		}
		if(p.getOprtimeTo() != null && !"".equals(p.getOprtimeTo())){//ҵ����ʱ��
			hql.append(" and d.oprtime <=to_date(:oprtimeTo,'yyyy-MM-dd hh24miss') " );
		}
		
		hql.append(" ) ");
		
		hql.append(" union ");
		
		hql.append(" (select v.seq,v.ruleid,v.opnid,o.name,v.calcopnid,o2.name calname,v.calcmonth,v.wayid,w.wayname,v.oprtime, ");
		hql.append(" v.oprcode,v.mobile,v.busivalue,v.rewardtype,v.ossrc,e.empattr2,v.srcseq ");
		hql.append(" from ch_bbc_allsaleshis_view v,ch_pw_way w,ch_pw_employee e,ch_bbc_operation o,ch_bbc_operation o2 ");
		hql.append(" where v.WAYID = w.WAYID  and v.OPRCODE = e.telephone  and v.OPNID = o.opnid  and v.calcopnid = o2.opnid ");
		
		hql.append(" and v.wayid =:wayid " );//������
		
		if(p.getOprcode() != null && !"".equals(p.getOprcode())){//רԱ����
			hql.append(" and v.oprcode =:oprcode " );
		}
		
		if(p.getEmpattr2() != null && !"".equals(p.getEmpattr2())){//��Ա����
			hql.append(" and e.empattr2 =:empattr2 " );
		}
		
		if(p.getOpnid() != null && !"".equals(p.getOpnid())){//ҵ�����
			hql.append(" and v.opnid =:opnid " );
		}
		
		if(p.getOpnname() != null && !"".equals(p.getOpnname())){//ҵ������
			hql.append(" and o.name =:name " );
		}
		
		if(p.getOprtimeFrom() != null && !"".equals(p.getOprtimeFrom())){//ҵ����ʱ��
			hql.append(" and v.oprtime >=to_date(:oprtimeFrom,'yyyy-MM-dd hh24miss') " );
		}
		if(p.getOprtimeTo() != null && !"".equals(p.getOprtimeTo())){//ҵ����ʱ��
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
		
		query.setString("wayid", p.getWayidAgency());//������
		
		if(p.getOprcode() != null && !"".equals(p.getOprcode())){//רԱ����
			query.setString("oprcode", p.getOprcode());
		}
		
		if(p.getEmpattr2() != null && !"".equals(p.getEmpattr2())){//��Ա����
			query.setString("empattr2", p.getEmpattr2());
		}
		
		if(p.getOpnid() != null && !"".equals(p.getOpnid())){//ҵ�����
			query.setString("opnid", p.getOpnid());
		}
		
		if(p.getOpnname() != null && !"".equals(p.getOpnname())){//ҵ������
			query.setString("name", p.getOpnname());
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		if(p.getOprtimeFrom() != null && !"".equals(p.getOprtimeFrom())){//ҵ����ʱ��			
			String oprtimeFrom = sdf.format(p.getOprtimeFrom()) +" 000000";
			query.setString("oprtimeFrom", oprtimeFrom);
			
		}
		if(p.getOprtimeTo() != null && !"".equals(p.getOprtimeTo())){//ҵ����ʱ��
			String oprtimeTo = sdf.format(p.getOprtimeTo())+" 235959";
			query.setString("oprtimeTo", oprtimeTo);
		}	
		
	}

}
