package com.gmcc.pboss.menu.dao.hibernate;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Query;

import com.gmcc.pboss.menu.model.SaDbWebfunctionitem;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.menu.dao.SaDbWebfunctionitemDao;
public class SaDbWebfunctionitemDaoHibernate extends BaseDaoHibernate 
			implements SaDbWebfunctionitemDao{

	public SaDbWebfunctionitemDaoHibernate(){
		super(SaDbWebfunctionitem.class);
	}
	
	/**
	 * ���ݵ�¼��Ա���ͻ�ȡ�˵���
	 * type 0-��Ա��1-������3-�����̣�4-��������
	 * @param type ���ݵ�¼��Ա��isnet�ֶ�ȷ���˵���ѯ������type
	 * 	isnet=0��1 ȡtype=0��1�Ĳ˵���isnet=4ȡtype=0��4�Ĳ˵�
	 * @return KEY-funcid:String  VALUE-ArrayList<SaDbWebfunctionitem>
	 */
	public Map getMenuMap(short type){
		if(type==0){//��Ա��������ͬ�Ĳ˵��ɼ���
			type=1;
		}
		Query sqlQuery = this.getSession().getNamedQuery("com.gmcc.pboss.menu.model.SaDbWebfunctionitem.getMenu");
		sqlQuery.setShort("type", type);
		List<SaDbWebfunctionitem> menuItem = sqlQuery.list();
		
		Map map = new HashMap<String,ArrayList<SaDbWebfunctionitem>>();
		ArrayList<SaDbWebfunctionitem> children = null;
		SaDbWebfunctionitem item = null;
		for(int i=0;i<menuItem.size();i++){
			item = menuItem.get(i);
			String parentId = item.getParentid();
			if(parentId.equals("-1")){//�����Ԫ�أ���Ԫ��û�и���  parentId==null
				continue;
			}
			if(map.containsKey(parentId)){
				children = (ArrayList)map.get(parentId);
				children.add(item);
				map.put(parentId,children);
			}
			else{
				children = new ArrayList<SaDbWebfunctionitem>();
				children.add(item);
				map.put(parentId, children);
			}
		}
		return map;
	}
	
	public List getAllMenu(){
		Query sqlQuery = this.getSession().getNamedQuery("com.gmcc.pboss.menu.model.SaDbWebfunctionitem.getAllMenu");
		List<SaDbWebfunctionitem> menuItem = sqlQuery.list();
		return menuItem;
	}
}
