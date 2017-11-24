package com.gmcc.pboss.biz.info.reward.payment.dao.hibernate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.criterion.Property;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gmcc.pboss.biz.info.reward.payment.dao.PaymentConfigDao;
import com.gmcc.pboss.biz.info.reward.payment.model.ChCwConfig;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;

public class PaymentConfigDaoHibernate extends BaseDaoHibernate implements
		PaymentConfigDao {

	public PaymentConfigDaoHibernate() {
		// …Ë÷√÷˜±Ì
		super(ChCwConfig.class);
	}

	public ChCwConfig getConfigByQuery(String key) {
		String hql = "from com.gmcc.pboss.biz.info.reward.payment.model.ChCwConfig c where c.key=:key";
		Query query = this.getSession().createQuery(hql);
		query.setString("key", key);
		ChCwConfig config = (ChCwConfig) query.uniqueResult();

		// if (config != null && config.getKey() != null) {
		// System.out.println(config.getKey());
		// System.out.println(config.getValue());
		// System.out.println(config.getExplain());
		// }

		return config;
	}

	public ChCwConfig getConfigBySql(String key) {
		ChCwConfig config = new ChCwConfig();

		String sql = "select * from CH_CW_CONF c where c.key=:key";
		Query query = this.getSession().createSQLQuery(sql);
		query.setString("key", key);
		List<Object[]> list = (List<Object[]>) query.list();

		if (list.size() > 0) {
			Object[] obj = list.get(0);
			config.setKey((String) obj[0]);
			config.setValue((String) obj[1]);
			config.setExplain((String) obj[2]);
		}

		return config;
	}

	public ChCwConfig getConfigByCriteria(String key) {
		Criteria criteria = this.getSession().createCriteria(
				this.getPersistentClass());
		criteria.add(Property.forName("key").eq(key));
		List<ChCwConfig> result = criteria.list();
		if (result.size() > 0) {
			return result.get(0);
		}
		return null;
	}

	public boolean updateConfig1(String key, String value) {
		boolean flag = false;

		try {
			Session session = this.getSession();
			Transaction tx = session.beginTransaction();
			Connection conn = session.connection();
			PreparedStatement ps = conn
					.prepareStatement("update com.gmcc.pboss.biz.info.reward.payment.model.ChCwConfig set value=:value where key=:key ");

			ps.executeUpdate();

			tx.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	public boolean updateConfig(ChCwConfig config) {
		boolean flag = false;
		try {
			super.update(config);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
