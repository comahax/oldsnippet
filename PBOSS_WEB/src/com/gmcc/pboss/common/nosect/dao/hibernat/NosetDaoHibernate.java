package com.gmcc.pboss.common.nosect.dao.hibernat;

import java.util.List;

import org.hibernate.Criteria;

import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.common.nosect.dao.NosectDao;
import com.gmcc.pboss.common.nosect.support.processor.NosectParameterProcessor;
import com.gmcc.pboss.model.common.ImPrNosect;

/**
 * 从兴公司营账研发部
 * @author yuwenjun
 * @date 2010-3-1
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：手机号码归属地查询
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
			//反回第一个值
			ImPrNosect rtn = (ImPrNosect)datas.get(0);
			return rtn.getBossarea();
		}else{
			//没有找到，返回null
			return null;
		}
	}

}
