package com.gmcc.pboss.menu.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.menu.model.SaDbWebfunctionitem;

public interface SaDbWebfunctionitemDao extends BaseDao {	
	/**
	 * ���ݵ�¼��Ա���ͻ�ȡ�˵���
	 * @param type ���ݵ�¼��Ա��isnet�ֶ�ȷ���˵���ѯ������type
	 * 	isnet=0��1 ȡtype=0��1�Ĳ˵���isnet=4ȡtype=0��4�Ĳ˵�
	 * @return KEY-funcid:String  VALUE-ArrayList<SaDbWebfunctionitem>
	 */
	public Map getMenuMap(short type);
	
	public List getAllMenu();
	
}
