/**
 * auto-generated code
 * Fri Jul 10 14:35:20 CST 2009
 */
package com.gmcc.pboss.control.base.operrole;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.operator.OperatorDAO;
import com.gmcc.pboss.business.base.operator.OperatorDBParam;
import com.gmcc.pboss.business.base.operator.OperatorVO;
import com.gmcc.pboss.business.base.operrole.OperroleDAO;
import com.gmcc.pboss.business.base.operrole.OperroleDBParam;
import com.gmcc.pboss.business.base.operrole.OperroleVO;
import com.gmcc.pboss.business.base.role.RoleDAO;
import com.gmcc.pboss.business.base.role.RoleDBParam;
import com.gmcc.pboss.control.base.operator.Operator;
import com.gmcc.pboss.control.base.operator.OperatorBO;
import com.gmcc.pboss.control.base.role.Role;
import com.gmcc.pboss.control.base.role.RoleBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: OperroleBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
/**
 * @ejb.bean 
 *           local-jndi-name="com/sunrise/jop/business/base/operrole/control/OperroleBO"
 *           name="Operrole" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class OperroleBO extends AbstractControlBean implements Operrole {

	public OperroleVO doCreate(OperroleVO vo) throws Exception {
		try {
			checkOperAndRole(vo);
			OperroleDAO dao = (OperroleDAO) DAOFactory.build(OperroleDAO.class, user);
			vo.setCreatedate(new Date());
			return (OperroleVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OperroleVO vo) throws Exception {
		try {
			OperroleDAO dao = (OperroleDAO) DAOFactory.build(OperroleDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OperroleDAO dao = (OperroleDAO) DAOFactory.build(OperroleDAO.class,
					user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OperroleVO doUpdate(OperroleVO vo) throws Exception {
		try {
			checkOperAndRole(vo);
			OperroleDAO dao = (OperroleDAO) DAOFactory.build(OperroleDAO.class,
					user);
			return (OperroleVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OperroleVO doFindByPk(Serializable pk) throws Exception {
		OperroleDAO dao = (OperroleDAO) DAOFactory.build(OperroleDAO.class,
				user);
		return (OperroleVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OperroleDBParam params,User user) throws Exception {
		OperroleDAO dao = (OperroleDAO) DAOFactory.build(OperroleDAO.class,
				user);
		Role role = (Role)BOFactory.build(RoleBO.class, user);
		if(role.doIfAdmin()){
			return dao.queryWithoutRoleLimited(params,user);
		}else{
			return dao.queryWithRoleLimited(params,user);
		}
	}
	
	public DataPackage doQuery(OperroleDBParam params) throws Exception {
		OperroleDAO dao = (OperroleDAO) DAOFactory.build(OperroleDAO.class,
				user);
		return  dao.query(params);
	}

	public void checkOperAndRole(OperroleVO vo) throws Exception {
		try {
			OperatorDAO dao = (OperatorDAO) DAOFactory.build(OperatorDAO.class,
					user);
			OperatorDBParam param = new OperatorDBParam();
			param.set_se_operid(vo.getOperid());
			
			List operList = dao.query(param).getDatas();
			if (operList.size() < 1) {
				throw new BusinessException("该操作员工号不存在!");
			}
			
			OperatorVO opervo = (OperatorVO)operList.get(0);
			if(!(opervo.getRegion().intValue() == Integer.parseInt(((User)user).getHwcityid()))){
				throw new BusinessException("只能导入本地市的工号!");
			}
			
			RoleDAO dao2 = (RoleDAO)DAOFactory.build(RoleDAO.class,
					user);
			RoleDBParam param2 = new RoleDBParam();
			param2.set_se_roleid(vo.getRoleid());
			
			List roleList = dao2.query(param2).getDatas();
			if (roleList.size()<1){
				throw new BusinessException("该角色编码不存在!");
			}
		} catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}
	/**
	 * 判断角色中是否存在操作员
	 * @param roleids
	 * @param operid
	 * @return
	 * @throws Exception
	 */
	public boolean doIsRoleInOperator(String roleids,String operid)throws Exception{
		OperroleDBParam params=new OperroleDBParam();
		List list=new ArrayList();
    	String[] roleidArray=roleids.split(",");
    	for(String roleid:roleidArray){
    		list.add(roleid);
    	}
		params.set_sin_roleid(list);
		params.set_se_operid(operid);
		OperroleDAO dao = (OperroleDAO) DAOFactory.build(OperroleDAO.class,user);
		int count=dao.count(params);
		if(count>0)
			return true;
		else
			return false;
	}
	
	public void doBatchSave(List roleList, List operList) throws Exception{
		try {
			//OperroleDAO dao = (OperroleDAO) DAOFactory.build(OperroleDAO.class,user);
			Operrole operrole = (Operrole)BOFactory.build(OperroleBO.class, user);
			for(Iterator ittRole = roleList.iterator();ittRole.hasNext();){
				String roleid = (String) ittRole.next();
				for(Iterator ittOper = operList.iterator();ittOper.hasNext();){
					String operid = (String)ittOper.next();
					OperroleVO vo = new OperroleVO();
					vo.setOperid(operid);
					vo.setRoleid(roleid);
					if((OperroleVO) operrole.doFindByPk(vo)==null){
						vo.setStatus((byte)1);
						vo.setCreatedate(new Date());
						vo.setStatusdate(PublicUtils.UtilStrToDate("2099-12-31", "yyyy-MM-dd"));
						operrole.doCreate(vo);
					}
				}
			}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
	
	public List<OperatorVO> getOperatorsByRoleId(String roleid) throws Exception {
		
		if(StringUtils.isEmpty(roleid)) 
			throw new BusinessException("参数[roleid] 不能为空");
		
		OperroleDBParam opparam = new OperroleDBParam();
		opparam.set_se_roleid(roleid);
		opparam.set_ne_status("1");
		DataPackage operroledp = this.doQuery(opparam);
		if(null==operroledp || operroledp.getDatas().size()==0){
			throw new BusinessException("角色编码 ["+roleid+"] 在角色工号表中没有相关联的工号");
		}
		Operator operator = (Operator)BOFactory.build(OperatorBO.class, user);
		List<OperroleVO> orlist = operroledp.getDatas();
		List<OperatorVO> oplist = new ArrayList<OperatorVO>();
		for(OperroleVO operrolevo : orlist){
			OperatorDBParam oparam = new OperatorDBParam();
			oparam.set_se_operid(operrolevo.getOperid());
			oparam.set_ne_status("1");
			DataPackage operatordp = operator.doQuery(oparam);
			List list = operatordp.getDatas();
			if(null != list && list.size()>0){
				oplist.add((OperatorVO)list.get(0));
			}
		}
		return oplist;
	}
}
