package com.gmcc.pboss.biz.info.reward.payment.support.processor;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.gmcc.pboss.biz.info.reward.payment.support.PaymentManageQueryParameter;
import com.gmcc.pboss.biz.info.salesDetail.support.RegisternewQueryParameter;
import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class PaymentManageQueryParamProcessor extends DefaultHqlQueryProcessor
		implements QueryParameterProcessor {

	@Override
	public String[] getParamEncloseName() {
		return null;
	}

	/**
	 * dao�̳�BaseHqlQueryDao������getAll������ʹ�õ� hql����Query��ʽ
	 */
	@Override
	public String getHql(QueryParameter parameter) {
		PaymentManageQueryParameter param = (PaymentManageQueryParameter) parameter;

		// ������ĳ������
		if (StringUtils.isEmpty(param.getCityid())) {
			return null;
		}

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT P.OPTYPE, P.PAYMONTH, P.STYPE, P.PAYEE, P.PAYSUM,");
		sql.append("DBMS_LOB.SUBSTR(P.DEDUCTION, 0, DBMS_LOB.GETLENGTH(P.DEDUCTION)) DEDUCTION,");
		sql.append("P.BATCH, P.SEQ,P.WAYID, P.BANK,P.DEPOSITBANK, P.ACCOUNT, P.BILLNUMBER,");
		sql.append("P.COUNTYID, P.PUBPRI, P.RATE, P.UPOPRCODE,");
		sql.append("DECODE(P.CHECKEDFLAG,'ischecked','�����','δ���') CHECKEDFLAG ");

		sql.append("FROM CH_CW_PAYMENT P ");
		// hql.append("LEFT JOIN (SELECT LTYPE, STYPE ");
		// hql.append("FROM CH_CW_STYPE ");
		// hql.append("WHERE CITYID = :cityid OR CITYID = 'GD') S ");
		// hql.append("ON P.STYPE = S.STYPE ");
		sql.append("WHERE 1 = 1 ");

		// ҵ�����
		if (StringUtils.isNotEmpty(param.getOptype())) {
			sql.append("AND P.OPTYPE = :OPTYPE ");
		}
		// �Թ���˽
		if (StringUtils.isNotEmpty(param.getPubpri())) {
			sql.append("AND P.PUBPRI =:PUBPRI ");
		}
		// У���ʶ
		if (StringUtils.isNotEmpty(param.getCheckedflag())) {
			sql.append("AND P.CHECKEDFLAG =:CHECKEDFLAG ");
		}
		// �տλ
		if (StringUtils.isNotEmpty(param.getPayee())) {
			sql.append("AND P.PAYEE =:PAYEE ");
		}
		// ҵ��������
		if (StringUtils.isNotEmpty(param.getWayid())) {
			sql.append("AND P.WAYID =:WAYID ");
		}
		// ��������
		if (StringUtils.isNotEmpty(param.getLtype())) {
			sql.append("AND S.LTYPE =:LTYPE ");
		}

		// С������
		if (StringUtils.isNotEmpty(param.getStype())) {
			sql.append("AND P.STYPE =:STYPE ");
		}
		// �����·�
		if (StringUtils.isNotEmpty(param.getPaymonth())) {
			sql.append("AND P.PAYMONTH =:PAYMONTH ");
		}
		// ���κ�
		if (StringUtils.isNotEmpty(param.getBatch())) {
			sql.append("AND P.BATCH =:BATCH ");
		}

		sql.append("ORDER BY P.SEQ");

		return sql.toString();
	}

	@Override
	public void process(Query query, QueryParameter parameter) {
		PaymentManageQueryParameter param = (PaymentManageQueryParameter) parameter;

		// �����򡰵��С��� ��ҵ�����͡������Թ�/��˽��������˱�ʶ��

		if (StringUtils.isNotEmpty(param.getOptype())) {
			query.setString("OPTYPE", param.getOptype());
		}

		if (StringUtils.isNotEmpty(param.getPubpri())) {
			query.setString("PUBPRI", param.getPubpri());
		}

		if (StringUtils.isNotEmpty(param.getCheckedflag())) {
			query.setString("CHECKEDFLAG", param.getCheckedflag());
		}

		// ����ѡ����տλ���ơ������������롱���������ࡱ�������С�ࡱ
		if (StringUtils.isNotEmpty(param.getPayee())) {
			query.setString("PAYEE", param.getPayee());
		}

		if (StringUtils.isNotEmpty(param.getWayid())) {
			query.setString("WAYID", param.getWayid());
		}

		// if (StringUtils.isNotEmpty(param.getLtype())) {
		// query.setString("LTYPE", param.getLtype());
		// }

		if (StringUtils.isNotEmpty(param.getStype())) {
			query.setString("STYPE", param.getStype());
		}

		// ʱ�����������·ݡ�
		if (StringUtils.isNotEmpty(param.getPaymonth())) {
			query.setString("PAYMONTH", param.getPaymonth());
		}

		// ��������Ρ�
		if (StringUtils.isNotEmpty(param.getBatch())) {
			query.setString("BATCH", param.getBatch());
		}
	}

	public void process(Criteria criteria, QueryParameter parameter) {
		PaymentManageQueryParameter param = (PaymentManageQueryParameter) parameter;

		if (StringUtils.isNotEmpty(param.getOptype())) {
			criteria.add(Restrictions.eq("OPTYPE", param.getOptype()));
		}

		if (StringUtils.isNotEmpty(param.getPubpri())) {
			criteria.add(Restrictions.eq("PUBPRI", param.getPubpri()));
		}

		if (StringUtils.isNotEmpty(param.getCheckedflag())) {
			criteria.add(Restrictions.eq("CHECKEDFLAG", param.getCheckedflag()));
		}

		if (StringUtils.isNotEmpty(param.getPayee())) {
			criteria.add(Restrictions.like("PAYEE", param.getPayee()));
		}

		if (StringUtils.isNotEmpty(param.getWayid())) {
			criteria.add(Restrictions.eq("WAYID", param.getWayid()));
		}

		// if (StringUtils.isNotEmpty(param.getLtype())) {
		// criteria.add(Restrictions.like("LTYPE", param.getLtype()));
		// }

		if (StringUtils.isNotEmpty(param.getStype())) {
			criteria.add(Restrictions.like("STYPE", param.getStype()));
		}

		if (StringUtils.isNotEmpty(param.getPaymonth())) {
			criteria.add(Restrictions.eq("PAYMONTH", param.getPaymonth()));
		}

		if (StringUtils.isNotEmpty(param.getBatch())) {
			criteria.add(Restrictions.like("BATCH", param.getBatch()));
		}
	}
}
