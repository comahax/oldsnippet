/**
 * auto-generated code
 * Tue Jul 27 12:08:11 CST 2010
 */
package com.gmcc.pboss.control.resource.stkalarmstat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.resource.stkalarmstat.StkalarmstatDAO;
import com.gmcc.pboss.business.resource.stkalarmstat.StkalarmstatDBParam;
import com.gmcc.pboss.business.resource.stkalarmstat.StkalarmstatVO;
import com.gmcc.pboss.business.resource.stkalarmstat.StkalarmstatshowVO;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: StkalarmstatBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class StkalarmstatBO extends AbstractControlBean implements
		Stkalarmstat {

	public StkalarmstatVO doCreate(StkalarmstatVO vo) throws Exception {
		try {
			StkalarmstatDAO dao = (StkalarmstatDAO) DAOFactory.build(StkalarmstatDAO.class, user);
			// TODO set the pk */
			return (StkalarmstatVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(StkalarmstatVO vo) throws Exception {
		try {
			StkalarmstatDAO dao = (StkalarmstatDAO) DAOFactory.build(StkalarmstatDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			StkalarmstatDAO dao = (StkalarmstatDAO) DAOFactory.build(StkalarmstatDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public StkalarmstatVO doUpdate(StkalarmstatVO vo) throws Exception {
		try {
			StkalarmstatDAO dao = (StkalarmstatDAO) DAOFactory.build(StkalarmstatDAO.class,user);
			return (StkalarmstatVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public StkalarmstatVO doFindByPk(Serializable pk) throws Exception {
		StkalarmstatDAO dao = (StkalarmstatDAO) DAOFactory.build(StkalarmstatDAO.class,user);
		return (StkalarmstatVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(StkalarmstatDBParam params)
			throws Exception {
		StkalarmstatDAO dao = (StkalarmstatDAO) DAOFactory.build(StkalarmstatDAO.class,user);
		return dao.query(params);
	}
	
	public DataPackage doQueryDetails1(StkalarmstatDBParam params) throws Exception {
		StkalarmstatDAO dao = (StkalarmstatDAO) DAOFactory.build(StkalarmstatDAO.class, user);
		return dao.queryByNamedSqlQuery("com.gmcc.pboss.business.resource.stkalarmstat.Stkalarmstat1",params);
	}
	
	public DataPackage doQueryDetails2(StkalarmstatDBParam params) throws Exception {
		StkalarmstatDAO dao = (StkalarmstatDAO) DAOFactory.build(StkalarmstatDAO.class, user);
		return dao.queryByNamedSqlQuery("com.gmcc.pboss.business.resource.stkalarmstat.Stkalarmstat2",params);
	}
	
	public DataPackage doQueryStat(StkalarmstatDBParam params) throws Exception {
		StkalarmstatDAO dao = (StkalarmstatDAO) DAOFactory.build(StkalarmstatDAO.class, user);
		params.setSelectFieldsString("countyid,mareacode,redalarm,yelalarm");
		String querystring = "com.gmcc.pboss.business.resource.stkalarmstat.Stkalarmstatshow6";
		params.getQueryConditions().put("cityid", user.getCityid());
		if(StringUtils.isNotBlank(params.get_dnl_alarmdate()) && StringUtils.isBlank(params.get_dnm_alarmdate())){
			params.getQueryConditions().put("begindate", params.get_dnl_alarmdate());
			querystring = "com.gmcc.pboss.business.resource.stkalarmstat.Stkalarmstatshow4";
		}else if(StringUtils.isBlank(params.get_dnl_alarmdate()) && StringUtils.isNotBlank(params.get_dnm_alarmdate())){
			params.getQueryConditions().put("enddate", params.get_dnm_alarmdate());
			querystring = "com.gmcc.pboss.business.resource.stkalarmstat.Stkalarmstatshow5";
		}else if(StringUtils.isNotBlank(params.get_dnl_alarmdate()) && StringUtils.isNotBlank(params.get_dnm_alarmdate())){
			params.getQueryConditions().put("begindate", params.get_dnl_alarmdate());
			params.getQueryConditions().put("enddate", params.get_dnm_alarmdate());
			querystring = "com.gmcc.pboss.business.resource.stkalarmstat.Stkalarmstatshow3";
		}
		
		params.set_dnl_alarmdate(null);
		params.set_dnm_alarmdate(null);
		
		DataPackage dp1 = dao.queryByNamedSqlQuery(querystring, params);
		if(dp1 != null && dp1.getDatas().size()>0){
			List list = dp1.getDatas();
			List<StkalarmstatshowVO>  showlist = new ArrayList<StkalarmstatshowVO>();
			for(int i = list.size()-1;i>=0;i--){
				StkalarmstatshowVO showvo = new StkalarmstatshowVO();
				Map map = (Map)list.get(i);
				showvo.setCountyid((String)map.get("countyid"));
				showvo.setMareacode((String)map.get("mareacode"));
				showvo.setRedalarm(Long.parseLong((String)map.get("redalarm")));
				showvo.setYelalarm(Long.parseLong((String)map.get("yelalarm")));
				showlist.add(showvo);
			}
			dp1.setDatas(showlist);
		}
		return dp1;
	}
}
