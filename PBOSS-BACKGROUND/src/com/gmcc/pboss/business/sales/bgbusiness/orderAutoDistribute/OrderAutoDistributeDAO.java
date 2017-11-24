package com.gmcc.pboss.business.sales.bgbusiness.orderAutoDistribute;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateVO;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;

public class OrderAutoDistributeDAO extends AbstractDAO {
	
	public OrderAutoDistributeDAO() {
		super(OrderVO.class);
	}
	
	public OrderVO getLatelyOrdersInComCate(Set<String> comCategory,String wayid) {
		StringBuffer hql = new StringBuffer("");
		hql.append("select {a.*} from FX_SW_ORDER a, FX_SW_ORDERCOMCATE b  where a.ORDERID = b.ORDERID  and a.WAYID = :WAYID ");
		if(comCategory.size() > 0) {
			hql.append(" and b.COMCATEGORY in ( ");
			StringBuffer temp = new StringBuffer();
			for(Iterator<String> it = comCategory.iterator();it.hasNext();) {
				temp.append("'").append(it.next()).append("',");
			}
			hql.append(temp.substring(0, temp.length()-1)).append(") ");
		}
		hql.append(" order by a.CREATETIME desc");
		Session session = SessionUtils.currentSession();
		SQLQuery query = session.createSQLQuery(hql.toString());
		query.setString("WAYID", wayid);
		query.addEntity("a", OrderVO.class);
		query.setFirstResult(0);
		query.setMaxResults(1);
		OrderVO orderVO= (OrderVO)query.uniqueResult();
		return orderVO;
		
	}

}
