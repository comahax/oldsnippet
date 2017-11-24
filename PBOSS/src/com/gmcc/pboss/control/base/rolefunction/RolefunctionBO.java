/**
 * auto-generated code
 * Tue Sep 01 21:01:30 CST 2009
 */
package com.gmcc.pboss.control.base.rolefunction;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.gmcc.pboss.business.base.functionitem.FunctionitemDBParam;
import com.gmcc.pboss.business.base.functionitem.FunctionitemVO;
import com.gmcc.pboss.business.base.rolefunction.RolefunctionDAO;
import com.gmcc.pboss.business.base.rolefunction.RolefunctionDBParam;
import com.gmcc.pboss.business.base.rolefunction.RolefunctionVO;
import com.gmcc.pboss.control.base.functionitem.Functionitem;
import com.gmcc.pboss.control.base.functionitem.FunctionitemBO;
import com.gmcc.pboss.control.base.role.Role;
import com.gmcc.pboss.control.base.role.RoleBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: RolefunctionBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/base/rolefunction/control/RolefunctionBO"
*    name="Rolefunction"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class RolefunctionBO extends AbstractControlBean implements
		Rolefunction {

	public RolefunctionVO doCreate(RolefunctionVO vo) throws Exception {
		try {
			RolefunctionDAO dao = (RolefunctionDAO) DAOFactory.build(RolefunctionDAO.class, user);
			// TODO set the pk */
			return (RolefunctionVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RolefunctionVO vo) throws Exception {
		try {
			RolefunctionDAO dao = (RolefunctionDAO) DAOFactory.build(RolefunctionDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RolefunctionDAO dao = (RolefunctionDAO) DAOFactory.build(RolefunctionDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RolefunctionVO doUpdate(RolefunctionVO vo) throws Exception {
		try {
			RolefunctionDAO dao = (RolefunctionDAO) DAOFactory.build(RolefunctionDAO.class,user);
			return (RolefunctionVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RolefunctionVO doFindByPk(Serializable pk) throws Exception {
		RolefunctionDAO dao = (RolefunctionDAO) DAOFactory.build(RolefunctionDAO.class,user);
		return (RolefunctionVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RolefunctionDBParam params,User user)
			throws Exception {
		RolefunctionDAO dao = (RolefunctionDAO) DAOFactory.build(RolefunctionDAO.class,user);
		Role role = (Role)BOFactory.build(RoleBO.class, user);
		params.getQueryConditions().put("loginwayid", user.getWayid());
		params.getQueryConditions().put("logincityid", user.getCityid());
		if(!role.doIfAdmin()){
			return dao.queryByNamedSqlQuery("system.rolefunctionLimitedQuery", params);
		}else{
			return dao.queryByNamedSqlQuery("system.rolefunctionWithoutLimitedQuery", params);
		}
	}
	
	public void doBatchSave(List funcList, List roleList) throws Exception{
		try {
			//RolefunctionDAO dao = (RolefunctionDAO) DAOFactory.build(RolefunctionDAO.class,user);
			Rolefunction rolefunction = (Rolefunction)BOFactory.build(RolefunctionBO.class, user);
			for(Iterator ittFunc = funcList.iterator();ittFunc.hasNext();){
				String funcid = (String) ittFunc.next();
				
				FunctionitemDBParam functionitemDBParam = new FunctionitemDBParam();
				functionitemDBParam.setQueryAll(true);
				functionitemDBParam.getQueryConditions().put("operid", user.getOprcode());
				Functionitem functionitem = (Functionitem) BOFactory.build(FunctionitemBO.class, user);
				String nameSql = "";
				if(CoreConfigInfo.IGNORE_MENU_PERM_FLAG){//测试环境
					nameSql = "system.functionitem.queryAllFunctionByParentId.test";
					functionitemDBParam.getQueryConditions().put("funcid", funcid);// 固定参数查询
				}else{//正式环境
					functionitemDBParam.getQueryConditions().put("funcid", funcid+"%");// 固定参数查询
					nameSql = "system.functionitem.queryAllFunctionByParentId";
				}
				functionitemDBParam.getQueryConditions().put("_snn_guiobject", "notnull"); //url不為null
				DataPackage functionitemDp = functionitem.doQueryByNameSql(nameSql, functionitemDBParam);
				for(Iterator ittFunctionItem = functionitemDp.getDatas().iterator(); ittFunctionItem.hasNext();){
					String sonFuncid = ((FunctionitemVO)ittFunctionItem.next()).getFuncid();
					for(Iterator ittRole = roleList.iterator();ittRole.hasNext();){
						String roleid = (String)ittRole.next();
						RolefunctionVO vo = new RolefunctionVO();
						vo.setItemid(roleid);
						vo.setFunctionid(sonFuncid);
						if((RolefunctionVO) rolefunction.doFindByPk(vo)==null){
							vo.setStatus((byte)1);
							vo.setCreatedate(new Date());
							vo.setStatusdate(PublicUtils.UtilStrToDate("2099-12-31", "yyyy-MM-dd"));
							vo.setOperatetype((byte)1);
							rolefunction.doCreate(vo);
						}
					}
				}
			}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
}
