package com.gmcc.pboss.manager.support;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class ManagerNodeQueryParameterProcessor extends
		DefaultHqlQueryProcessor implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		ManagerNodeQueryParameter p = (ManagerNodeQueryParameter)parameter;
		
		StringBuffer hql = new StringBuffer();
		if(p.isPopup()){//�����򣬵�����ǰ�����µ��������㹩ѡ��
			hql.append(" from com.gmcc.pboss.biz.info.node.model.Way w where w.waymagcode = :waymagcode ");
			if(StringUtils.isNotEmpty(p.getWayname())){
				hql.append(" and w.wayname like :wayname ");
			}
			if(StringUtils.isNotEmpty(p.getWayid())){
				hql.append(" and w.wayid like :wayid ");
			}
		}
		else if(!StringUtils.isNotEmpty(p.getWayid())){//��ѯ������Ա�µ���������--������Ա�����б�
			//HQL
			/**
			hql.append(" from com.gmcc.pboss.biz.info.node.model.Way w");
			hql.append(" where w.waymagcode=:waymagcode ");
			if(StringUtils.isNotEmpty(p.getWayname())){
				hql.append(" and w.wayname like :wayname ");
			}
			*/
			//SQL--��������ʹ�������Ӳ�ѯ��һ��ʵ�ֲ�ѯ��ʹ��SQL����ʵ�֣�HQL�޷�ʵ��
			hql.append("select w.wayid,w.wayname,ee.officetel,to_char(w.starlevel),to_char(w.catetype),w.cityid,");
			hql.append(" w.countyid,w.svccode,to_char(w.formtype),w.address");
			hql.append(" from ch_pw_way w,");
			hql.append(" ( select w.wayid,e.officetel from ch_pw_way w,ch_pw_employee e where w.waymagcode=:waymagcode and w.wayid=e.wayid and e.isnet=1 and e.empstatus=0) ee");
			hql.append(" where w.wayid=ee.wayid(+) and w.waymagcode=:waymagcode ");
			if(StringUtils.isNotEmpty(p.getWayname())){
				hql.append(" and w.wayname like :wayname ");
			}
		}
		else{//��ѯĳ�����������
			hql.append("select new com.gmcc.pboss.manager.model.NodeDetail(w, a, c, co) ");
			hql.append(" from com.gmcc.pboss.biz.info.node.model.Way w, " +
					"com.gmcc.pboss.biz.info.node.model.WayAccount a, " +
					"com.gmcc.pboss.biz.info.node.model.Contact c, " +
					"com.gmcc.pboss.biz.info.node.model.ChDstCooperator co ");
			hql.append(" where w.wayid=a.wayid and w.wayid=c.wayid and w.wayid=co.cooperauid ");
			hql.append(" and w.wayid = :wayid ");
		}
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
		ManagerNodeQueryParameter p = (ManagerNodeQueryParameter)parameter;
		if(p.isPopup()){//�����򣬵�����ǰ�����µ��������㹩ѡ��
			query.setString("waymagcode", p.getWaymagcode());
			if(StringUtils.isNotEmpty(p.getWayname())){
				query.setString("wayname", "%"+p.getWayname().trim()+"%");
			}
			if(StringUtils.isNotEmpty(p.getWayid())){
				query.setString("wayid","%"+p.getWayid().trim()+"%");
			}
		}
		else if(!StringUtils.isNotEmpty(p.getWayid())){
			//��ѯ������Ա�µ���������--������Ա�����б�ʹ��
			query.setString("waymagcode", p.getWaymagcode());
			if(StringUtils.isNotEmpty(p.getWayname())){
				query.setString("wayname", "%"+p.getWayname().trim()+"%");
			}
		}
		else{//��ѯĳ�����������
			query.setString("wayid", p.getWayid());
		}
	}

}
