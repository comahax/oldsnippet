package com.gmcc.pboss.biz.basic.dictItem.dao;

import java.util.Map;

import com.gmcc.pboss.common.dao.BaseDao;

public interface DictItemDao extends BaseDao {
	
	//��ѯIM_PR_COMCATEGORYRELA����ȡ��Ʒ����-��Դ������
	//key-��Ʒ���࣬value-��Դ�б�
	public Map<String,String> getComcatoAndRestype();

}
