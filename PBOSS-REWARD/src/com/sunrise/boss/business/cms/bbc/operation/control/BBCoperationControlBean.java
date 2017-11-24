/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */
package com.sunrise.boss.business.cms.bbc.operation.control;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sunrise.boss.business.cms.bbc.operation.persistent.BBCoperationDAO;
import com.sunrise.boss.business.cms.bbc.operation.persistent.BBCoperationListVO;
import com.sunrise.boss.business.cms.bbc.operation.persistent.BBCoperationVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: OperationControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/bbc/operation/control/BBCoperationControlBean"
 *           name="BBCoperationControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class BBCoperationControlBean extends AbstractControlBean implements
		BBCoperationControl {

	public BBCoperationVO doCreate(BBCoperationVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			BBCoperationDAO dao = (BBCoperationDAO) DAOFactory.build(
					BBCoperationDAO.class, user);
			SimpleDateFormat startsdf=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
			SimpleDateFormat endsdf=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			vo.setStartdate(sdf.parse(startsdf.format(vo.getStartdate())));
			vo.setEnddate(sdf.parse(endsdf.format(vo.getEnddate())));
			vo.setState(Short.valueOf("1"));
			vo.setIsbusi(Short.valueOf("1"));
			return (BBCoperationVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(BBCoperationVO vo, User user) throws Exception {
		try {
			BBCoperationDAO dao = (BBCoperationDAO) DAOFactory.build(
					BBCoperationDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public BBCoperationVO doUpdate(BBCoperationVO vo, User user) throws Exception {
		try {
			BBCoperationDAO dao = (BBCoperationDAO) DAOFactory.build(
					BBCoperationDAO.class, user);
			SimpleDateFormat startsdf=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
			SimpleDateFormat endsdf=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			vo.setStartdate(sdf.parse(startsdf.format(vo.getStartdate())));
			vo.setEnddate(sdf.parse(endsdf.format(vo.getEnddate())));
			return (BBCoperationVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public BBCoperationVO doFindByPk(Serializable pk, User user) throws Exception {
		BBCoperationDAO dao = (BBCoperationDAO) DAOFactory.build(BBCoperationDAO.class,
				user);
		return (BBCoperationVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BBCoperationListVO params, User user)
			throws Exception {
		BBCoperationDAO dao = (BBCoperationDAO) DAOFactory.build(BBCoperationDAO.class,
				user);
		params=init(params);
		params.set_ne_isbusi("1");
		return dao.query(params);
	}
	
	public BBCoperationListVO init(BBCoperationListVO params){
		if(isNull(params.get_dnl_startdate())){
			params.set_dnl_startdate("1900-01-01 00:00:00");
		}else{
			params.set_dnl_startdate(params.get_dnl_startdate()+" 00:00:00");
		}
		if(isNull(params.get_dnl_enddate())){
			params.set_dnl_enddate("1900-01-01 00:00:00");
		}else{
			params.set_dnl_enddate(params.get_dnl_enddate()+" 00:00:00");
		}
		if(isNull(params.get_dnm_startdate())){
			params.set_dnm_startdate("2099-12-31 23:59:59");
		}else{
			params.set_dnm_startdate(params.get_dnm_startdate()+" 23:59:59");
		}
		if(isNull(params.get_dnm_enddate())){
			params.set_dnm_enddate("2099-12-31 23:59:59");
		}else{
			params.set_dnm_enddate(params.get_dnm_enddate()+" 23:59:59");
		}
		return params;
	}
	
	public boolean isNull(String str){
		if(null==str||"".equals(str)||"Пе".equals(str)){
			return true;
		}else{
			return false;
		}
	}
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		Date d=new Date();
//			System.out.println(sdf.format(d).toString());
	}
}


