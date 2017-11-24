package com.gmcc.pboss.common.nosect.dao.hibernat;

import java.util.List;

import org.hibernate.Criteria;

import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.common.nosect.dao.NosectDao;
import com.gmcc.pboss.common.nosect.support.processor.NosectParameterProcessor;
import com.gmcc.pboss.model.common.ImPrNosect;

/**
 * ���˹�˾Ӫ���з���
 * @author yuwenjun
 * @date 2010-3-1
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * �������ֻ���������ز�ѯ
 */
public class NosetDaoHibernate extends BaseDaoHibernate implements NosectDao {

	public NosetDaoHibernate() {
		super(ImPrNosect.class);
	}

	public String getCityByNo(String mobileNo) {
		// TODO Auto-generated method stub
//		this.getAll();
		
		Criteria criteria = getSession().createCriteria(this.getPersistentClass());
		NosectParameterProcessor processor = new NosectParameterProcessor();
		processor.processCityQuery(criteria,mobileNo);
		
		List datas = criteria.list();
		if (datas.size()>0){
			//���ص�һ��ֵ
			ImPrNosect rtn = (ImPrNosect)datas.get(0);
			return rtn.getBossarea();
		}else{
			//û���ҵ�������null
			return null;
		}
	}

}
