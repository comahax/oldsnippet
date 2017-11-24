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
	 * 根据登录人员类型获取菜单项
	 * type 0-店员，1-店主，3-配送商，4-渠道经理
	 * @param type 根据登录人员的isnet字段确定菜单查询的类型type
	 * 	isnet=0或1 取type=0和1的菜单；isnet=4取type=0和4的菜单
	 * @return KEY-funcid:String  VALUE-ArrayList<SaDbWebfunctionitem>
	 */
	public Map getMenuMap(short type){
		if(type==0){//店员店主有相同的菜单可见性
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
			if(parentId.equals("-1")){//处理根元素，根元素没有父亲  parentId==null
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
