/**
 * 
 */
package com.sunrise.boss.business.admin.operator.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.admin.operator.persistent.OperatorDAO;
import com.sunrise.boss.business.admin.operator.persistent.OperatorListVO;
import com.sunrise.boss.business.admin.operator.persistent.OperatorVO;
import com.sunrise.boss.business.cms.way.persistent.WayDAO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.rightmanage.operrole.persistent.OperroleListVO;
import com.sunrise.boss.business.rightmanage.operrole.persistent.OperroleVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: GDIBOSS
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Hanny Yeung
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/admin/operator/control/OperatorControlBean"
 *           name="OperatorControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class OperatorControlBean extends AbstractControlBean implements
		OperatorControl {

	public OperatorVO doCreate(OperatorVO vo, User user) throws Exception {
		try {
			OperatorDAO dao = (OperatorDAO) DAOFactory.build(OperatorDAO.class,
					user);
			return (OperatorVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(OperatorVO vo, User user) throws Exception {
		try {
			OperatorDAO dao = (OperatorDAO) DAOFactory.build(OperatorDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public OperatorVO doUpdate(OperatorVO vo, User user) throws Exception {
		try {
			OperatorDAO dao = (OperatorDAO) DAOFactory.build(OperatorDAO.class,
					user);
			return (OperatorVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public OperatorVO doFindByPk(Serializable pk, User user) throws Exception {
		OperatorDAO dao = (OperatorDAO) DAOFactory.build(OperatorDAO.class,
				user);
		return (OperatorVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OperatorListVO params, User user)
			throws Exception {
		OperatorDAO dao = (OperatorDAO) DAOFactory.build(OperatorDAO.class,
				user);
		return dao.query(params);
	}

	/**
	 * 将员工ID（工号）转换成中文名字
	 * 
	 * @param id
	 *            员工ID
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public String changeIdToName(String id, User user) throws Exception {
		OperatorVO vo = (OperatorVO) doFindByPk(id, user);
		if (vo == null) {
			return id;
		}
		return vo.getOpername();
	}

	/**
	 * 将员工ID集合转换中中文名字，并以List形式返回
	 * 
	 * @param ids
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List changeIdsToNames(String[] ids, User user) throws Exception {
		List list = new ArrayList();
		for (int i = 0; i < ids.length; i++) {
			list.add(changeIdToName(ids[i], user));
		}
		return list;
	}

	/**
	 * 验证工号是否属于指定渠道
	 * 
	 * @param operCode
	 *            验证工号
	 * @param wayId
	 *            验证渠道
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean verifyOperator(String operCode, String wayId, User user)
			throws Exception {
		//if (StringUtils.isBlank(operCode)) {
		//	throw new Exception("验证工号不能为空！");
	//	}
		//if (StringUtils.isBlank(wayId)) {
		//	throw new Exception("验证渠道不能为空！");
	//	}
		OperatorDAO dao = (OperatorDAO) DAOFactory.build(OperatorDAO.class,
				user);
		OperatorListVO listVO = new OperatorListVO();
		listVO.set_se_operid(operCode);
		listVO.set_se_orgid(wayId);
		return dao.query(listVO).getDatas().size() > 0 ? true : false;
	}

	public boolean verifyOperator(String[] operCodes, String wayId, User user)
			throws Exception {
		boolean valid = true;
		if (operCodes.length == 1 && StringUtils.equals(operCodes[0], "*")) {
			return valid;
		}
		try {
			OperatorDAO dao = (OperatorDAO) DAOFactory.build(OperatorDAO.class,
					user);
			List list = Arrays.asList(operCodes);
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				if (!verifyOperator((String) iter.next(), wayId, user)) {
					valid = false;
					break;
				}
			}
		} catch (Exception ex) {
			valid = false;
			throw ex;
		}
		return valid;
	}
	/**
     * 根据角色标识查找操作员用户列表
     * @param roleids
     * @param params TODO
     * @return
     * @throws Exception
     */
    public DataPackage doQueryOperatorList(String roleids, OperatorListVO param,User user) throws Exception{
    	OperatorDAO dao = (OperatorDAO) DAOFactory.build(OperatorDAO.class,user);
    	OperroleListVO operroleDBParam=new OperroleListVO();
    	operroleDBParam.set_se_operid(param.get_se_operid());
    	List list=new ArrayList();
    	String[] roleidArray=roleids.split(",");
    	for(int i=0;i<roleidArray.length;i++){
    		list.add(roleidArray[i]);
    	}
    	operroleDBParam.set_sin_roleid(list);
    	Object params[] = {
    			param, operroleDBParam
   	        };
   	        Class vos[] = {
   	        		OperatorVO.class, OperroleVO.class
   	        };
   	        String joins[][] = {
   	            {
   	                "operid", "operid"
   	            }
   	        };
   	     DataPackage data= dao.query2(params, vos, joins);
   	     Collection objects=data.getDatas();
   	     List showData=new  ArrayList();
   	     OperatorVO opVo=null;
   	     Iterator it=objects.iterator();
   	     Object[] objs=null;
   	     while(it.hasNext()){
   	    	objs=(Object[])it.next();
	        	if(objs[0] instanceof OperatorVO){
	        		showData.add((OperatorVO)objs[0]);
   	        	}else{
   	        		showData.add((OperatorVO)objs[1]);
   	        	}
   	     }
   	     data.setDatas(showData);
   	     return data;
    }
    
    public String doQuerycountyid(String operid, User user)throws Exception{
    	String countyid = null;
    	OperatorDAO dao = (OperatorDAO) DAOFactory.build(OperatorDAO.class,user);
    	OperatorVO ovo = (OperatorVO)dao.findByPk(operid);
    	if(ovo!=null && ovo.getOrgid()!=null && !"".equals(ovo.getOrgid().trim())){
    		WayDAO wdao = (WayDAO) DAOFactory.build(WayDAO.class,user);
    		WayVO wvo = (WayVO)wdao.findByPk(ovo.getOrgid().trim());
    		if(wvo!=null && wvo.getCountyid()!=null && !"".equals(wvo.getCountyid().trim())){
    			countyid = wvo.getCountyid().trim();
    		}
    	}    	
    	return countyid;
    }
}
