package com.gmcc.pboss.biz.basic.dictItem.dao.hibernate;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

import org.hibernate.Query;

import com.gmcc.pboss.biz.basic.dictItem.dao.DictItemDao;
import com.gmcc.pboss.biz.basic.dictItem.support.DictItemQueryParameter;
import com.gmcc.pboss.biz.basic.dictItem.support.processor.DicItemQueryProcessor;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.model.constant.SaDbDictitem;

public class DictItemDaoHibernate extends BaseHqlQueryDao implements DictItemDao {
	public DictItemDaoHibernate() {
		super(SaDbDictitem.class);
	}

	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate#getAll()
	 */
	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		QueryResult reslt = this.getAll(new DicItemQueryProcessor(), new DictItemQueryParameter());
		return reslt.getData();
	}
	
	//查询IM_PR_COMCATEGORYRELA表，获取商品种类-资源类别组合
	//key-商品种类，value-资源列别
	public Map<String,String> getComcatoAndRestype(){
		Query query = this.getSession().getNamedQuery("com.gmcc.pboss.biz.basic.dictItem.model.getComcatoAndRestype");
		List<Object[]> list = (List<Object[]>)query.list();
		Map<String,String> comCatoAndRestype = new HashMap<String,String>();
		if(list!=null && list.size()>0){
			for(Iterator<Object[]> it=list.iterator();it.hasNext();){
				Object[] obj = it.next();
				comCatoAndRestype.put((String)obj[0], (String)obj[1]);
			}
		}		
		return comCatoAndRestype;
	}
	
	
}
