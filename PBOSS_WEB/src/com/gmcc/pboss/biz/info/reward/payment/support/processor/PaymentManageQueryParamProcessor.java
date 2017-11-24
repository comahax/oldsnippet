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
	 * dao继承BaseHqlQueryDao，调用getAll方法，使用到 hql生成Query方式
	 */
	@Override
	public String getHql(QueryParameter parameter) {
		PaymentManageQueryParameter param = (PaymentManageQueryParameter) parameter;

		// 必须有某个地市
		if (StringUtils.isEmpty(param.getCityid())) {
			return null;
		}

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT P.OPTYPE, P.PAYMONTH, P.STYPE, P.PAYEE, P.PAYSUM,");
		sql.append("DBMS_LOB.SUBSTR(P.DEDUCTION, 0, DBMS_LOB.GETLENGTH(P.DEDUCTION)) DEDUCTION,");
		sql.append("P.BATCH, P.SEQ,P.WAYID, P.BANK,P.DEPOSITBANK, P.ACCOUNT, P.BILLNUMBER,");
		sql.append("P.COUNTYID, P.PUBPRI, P.RATE, P.UPOPRCODE,");
		sql.append("DECODE(P.CHECKEDFLAG,'ischecked','已审核','未审核') CHECKEDFLAG ");

		sql.append("FROM CH_CW_PAYMENT P ");
		// hql.append("LEFT JOIN (SELECT LTYPE, STYPE ");
		// hql.append("FROM CH_CW_STYPE ");
		// hql.append("WHERE CITYID = :cityid OR CITYID = 'GD') S ");
		// hql.append("ON P.STYPE = S.STYPE ");
		sql.append("WHERE 1 = 1 ");

		// 业务类别
		if (StringUtils.isNotEmpty(param.getOptype())) {
			sql.append("AND P.OPTYPE = :OPTYPE ");
		}
		// 对公对私
		if (StringUtils.isNotEmpty(param.getPubpri())) {
			sql.append("AND P.PUBPRI =:PUBPRI ");
		}
		// 校验标识
		if (StringUtils.isNotEmpty(param.getCheckedflag())) {
			sql.append("AND P.CHECKEDFLAG =:CHECKEDFLAG ");
		}
		// 收款单位
		if (StringUtils.isNotEmpty(param.getPayee())) {
			sql.append("AND P.PAYEE =:PAYEE ");
		}
		// 业渠道编码
		if (StringUtils.isNotEmpty(param.getWayid())) {
			sql.append("AND P.WAYID =:WAYID ");
		}
		// 大类名称
		if (StringUtils.isNotEmpty(param.getLtype())) {
			sql.append("AND S.LTYPE =:LTYPE ");
		}

		// 小类名称
		if (StringUtils.isNotEmpty(param.getStype())) {
			sql.append("AND P.STYPE =:STYPE ");
		}
		// 付款月份
		if (StringUtils.isNotEmpty(param.getPaymonth())) {
			sql.append("AND P.PAYMONTH =:PAYMONTH ");
		}
		// 批次号
		if (StringUtils.isNotEmpty(param.getBatch())) {
			sql.append("AND P.BATCH =:BATCH ");
		}

		sql.append("ORDER BY P.SEQ");

		return sql.toString();
	}

	@Override
	public void process(Query query, QueryParameter parameter) {
		PaymentManageQueryParameter param = (PaymentManageQueryParameter) parameter;

		// 下拉框“地市”、 “业务类型”、“对公/对私”，“审核标识”

		if (StringUtils.isNotEmpty(param.getOptype())) {
			query.setString("OPTYPE", param.getOptype());
		}

		if (StringUtils.isNotEmpty(param.getPubpri())) {
			query.setString("PUBPRI", param.getPubpri());
		}

		if (StringUtils.isNotEmpty(param.getCheckedflag())) {
			query.setString("CHECKEDFLAG", param.getCheckedflag());
		}

		// 输入选择框“收款单位名称”、“渠道编码”、“酬金大类”、“酬金小类”
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

		// 时间插件“付款月份”
		if (StringUtils.isNotEmpty(param.getPaymonth())) {
			query.setString("PAYMONTH", param.getPaymonth());
		}

		// 输入框“批次”
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
