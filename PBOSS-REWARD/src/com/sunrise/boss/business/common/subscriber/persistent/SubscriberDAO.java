/**
 * auto-generated code
 * Tue Aug 22 21:42:23 CST 2006
 */
package com.sunrise.boss.business.common.subscriber.persistent;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: SubscriberDAO
 * </p>
 * <p>
 * Description: Data Access Object for SubscriberVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author xqy
 * @version 1.0
 */
public class SubscriberDAO extends BaseDAO {

	/**
	 * default constructor
	 */
	static public final String SUBS_STATE_NORMAL = "US10"; // 正常

	static public final String SUBS_STATE_CANCEL = "US20"; // 销户

	static public final String SUBS_STATE_PRECAN = "US22"; // 预销户

	static public final String SUBS_STATE_NONACT = "US28"; // 未激活

	static public final String SUBS_STATE_STOP = "US30"; // 停机

	static public final String SUBS_STATE_INVALID = "US20,US28"; // 无效用户状态

	static public final String SUBS_STATE_VALID = "US10,US22,US30,US531";// 有效用户状态
	
	static public final String GSUBS_STATE_STOP = "US532"; // 集团产品停用
	
	static public final String GSUBS_STATE_PRECAN = "US531"; // 集团预约销户
	
	static public final String GSUBS_STATE_VALID = "US10,US22,US30,US531,US532"; //有效用户状态(包括普通用户和集团用户)

	public SubscriberDAO() {
		super(SubscriberVO.class);
	}

	public String GetServnumBySubsid(java.lang.Long subsid) throws Exception {
		// BaseListVO lvo = new BaseListVO();
		// lvo.getQueryConditions().put("_ne_subsid",subsid);

		SubscriberVO vo = (SubscriberVO) findByPk(subsid);
		return vo.getServnumber();
	}

	public String GetServnumByAcctid(java.lang.Long acctid) throws Exception {
		BaseListVO lvo = new BaseListVO();
		lvo.getQueryConditions().put("_ne_acctid", acctid);

		DataPackage pkg = query(lvo, 0);
		List list = (ArrayList) pkg.getDatas();
		if (list.size() < 1)
			throw new Exception("No record found!");
		String[] itemstatus = SUBS_STATE_VALID.split(",");
		for (int i = 0; i < list.size(); i++) {
			SubscriberVO vo = (SubscriberVO) list.get(i);
	//		String tempstatus = vo.getStatus();
			for (int j = 0; j < itemstatus.length; j++) {
				if (vo.getStatus().equals(itemstatus[j])) {
					return vo.getServnumber();
				}
			}
		}
		SubscriberVO vo= (SubscriberVO)list.get(0);
		return vo.getServnumber();
		
	}
	
	

	
	public String GetServnumByCustid(java.lang.Long custid) throws Exception {
		BaseListVO lvo = new BaseListVO();
		lvo.getQueryConditions().put("_ne_custid", custid);
		String Servnum = "";
		DataPackage pkg = query(lvo, 0);		
		if(null != pkg && null !=  pkg.getDatas() &&  pkg.getDatas().size() > 0){
			List list = (List) pkg.getDatas();			
			SubscriberVO vo = (SubscriberVO) list.get(0);
			Servnum = vo.getServnumber();
		}else{
			throw new Exception("No record found!");
		}
		return Servnum;		
	}

	public Long GetAcctidByServnum(java.lang.String servnumber)
			throws Exception {
		SubscriberVO vo = this.FindByServnum(servnumber);
		return vo.getAcctid();
	}

	public Long GetSubsidByServnum(java.lang.String servnumber)
			throws Exception {
		SubscriberVO vo = this.FindByServnum(servnumber);
		return vo.getSubsid();
	}

	/* add by xiefufeng */
	public Long GetCustidByServnum(String servnumber) throws Exception {
		SubscriberVO vo = this.FindByServnum(servnumber);
		return vo.getCustid();
	}

	public SubscriberVO FindByServnum(java.lang.String servnumber)
			throws Exception {
		BaseListVO lvo = new BaseListVO();
		lvo.getQueryConditions().put("_se_servnumber", servnumber);

		DataPackage pkg = query(lvo, 0);
		List list = (ArrayList) pkg.getDatas();
		if (list.size() < 1)
			throw new Exception("No record found!");
		String[] itemstatus = SUBS_STATE_VALID.split(",");
		for (int i = 0; i < list.size(); i++) {
			SubscriberVO vo = (SubscriberVO) list.get(i);
	//		String tempstatus = vo.getStatus();
			for (int j = 0; j < itemstatus.length; j++) {
				if (vo.getStatus().equals(itemstatus[j])) {
					return vo;
				}
			}
		}		
		return (SubscriberVO) list.get(0);
	}
	
	// 通过集团产品号码或者普通个人号码找用户资料
	// add by xff 20070524
	public SubscriberVO FindByGServnum(java.lang.String servnumber)
	throws Exception {
		BaseListVO lvo = new BaseListVO();
		lvo.getQueryConditions().put("_se_servnumber", servnumber);
		
		DataPackage pkg = query(lvo, 0);
		List list = (ArrayList) pkg.getDatas();
		if (list.size() < 1)
			throw new Exception("No record found!");
		String[] itemstatus = GSUBS_STATE_VALID.split(",");
		for (int i = 0; i < list.size(); i++) {
			SubscriberVO vo = (SubscriberVO) list.get(i);
			for (int j = 0; j < itemstatus.length; j++) {
				if (vo.getStatus().equals(itemstatus[j])) {
					return vo;
				}
			}
		}		
		return (SubscriberVO) list.get(0);
	}
	
	//add by cwl
	 public Long getValidSusbidByServnumber(Object params ,User user) throws Exception{
		 Long subsid = ( Long)queryUniqueByNamedSqlQuery("getvalidsubsid", params ,Long.class);
    	return subsid;
    }
	
}
