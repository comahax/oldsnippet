package com.sunrise.boss.business.common.menu.control;

import java.io.Serializable;
import java.util.Map;

import com.sunrise.boss.business.common.menu.persistent.MenuitemDAO;
import com.sunrise.boss.business.common.menu.persistent.MenuitemDBParam;
import com.sunrise.boss.business.common.menu.persistent.MenuitemVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: FunctionitemBO </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lidl
 * @version 1.0
 */
public class MenuitemBO extends AbstractControlBean implements Menuitem {
	
	public DataPackage doQueryItem(Map map) throws Exception {
		System.out.println("进入FunctionitemBO.doQueryItem(Map map)方法！！！");
		try {
			MenuitemDBParam params =new MenuitemDBParam();
			MenuitemDAO dao = (MenuitemDAO) DAOFactory.build(MenuitemDAO.class,user);
//			params.setSelectFieldsString("groupid,custgrouptype,creditlevel,corpscope,unitkind,vocaionkind1,emplyeenum,paymode");
			params.setQueryConditions(map);
			params.setDataOnly(true);
			params.setQueryAll(true);
			DataPackage dp=dao.queryByNamedSqlQuery("common.functionitem.toMenu",params);
			return dp;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public DataPackage doQueryBySqlname(String sqlname , MenuitemDBParam params)throws Exception {
		try {
			System.out.println("进入doQueryBySqlname（），sqlname："+sqlname);
			MenuitemDAO dao = (MenuitemDAO) DAOFactory.build(MenuitemDAO.class,user);
			DataPackage dp = dao.queryByNamedSqlQuery(sqlname,params);
			return dp;
		} catch (Exception ex) {
			throw ex;
		}
	}

	public MenuitemVO doCreate(MenuitemVO vo) throws Exception {
		try {
			MenuitemDAO dao = (MenuitemDAO) DAOFactory.build(MenuitemDAO.class, user);
			// TODO set the pk */
			return (MenuitemVO) dao.create(vo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void doRemoveByVO(MenuitemVO vo) throws Exception {
		try {
			MenuitemDAO dao = (MenuitemDAO) DAOFactory.build(MenuitemDAO.class,user);
			vo = doFindByPk(vo);
			dao.remove(vo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			MenuitemDAO dao = (MenuitemDAO) DAOFactory.build(MenuitemDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public MenuitemVO doUpdate(MenuitemVO vo) throws Exception {
		try {
			MenuitemDAO dao = (MenuitemDAO) DAOFactory.build(MenuitemDAO.class,user);
			return (MenuitemVO) dao.update(vo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public MenuitemVO doFindByPk(Serializable pk) throws Exception {
		try {
			MenuitemDAO dao = (MenuitemDAO) DAOFactory.build(MenuitemDAO.class,user);
			return (MenuitemVO) dao.findByPk(pk);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public DataPackage doQuery(MenuitemDBParam params) throws Exception {
		try {
			MenuitemDAO dao = (MenuitemDAO) DAOFactory.build(MenuitemDAO.class,user);
			return dao.query(params);
		} catch (Exception ex) {
			throw ex;
		}		
	}

//	public List doQueryMenuByOperId(String operId) throws Exception {
//		try{
//			EibRuOperfunctionitemDAO dao = (EibRuOperfunctionitemDAO)DAOFactory.build(EibRuOperfunctionitemDAO.class, user);
//			EibRuOperfunctionitemDBParam params = new EibRuOperfunctionitemDBParam();
//			params.setDataOnly(true);
//			params.setQueryAll(true);
//			params.set_se_operid(operId);
//			return dao.query(params).getDatas();
//		}catch(Exception ex){
//			throw ex;
//		}
//	}
}
