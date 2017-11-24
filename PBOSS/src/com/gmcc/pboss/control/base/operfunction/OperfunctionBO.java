/**
 * auto-generated code
 * Tue Sep 08 16:02:06 CST 2009
 */
package com.gmcc.pboss.control.base.operfunction;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.gmcc.pboss.business.base.functionitem.FunctionitemDBParam;
import com.gmcc.pboss.business.base.functionitem.FunctionitemVO;
import com.gmcc.pboss.business.base.operfunction.OperfunctionDAO;
import com.gmcc.pboss.business.base.operfunction.OperfunctionDBParam;
import com.gmcc.pboss.business.base.operfunction.OperfunctionVO;
import com.gmcc.pboss.control.base.functionitem.Functionitem;
import com.gmcc.pboss.control.base.functionitem.FunctionitemBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OperfunctionBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/base/operfunction/control/OperfunctionBO"
*    name="Operfunction"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class OperfunctionBO extends AbstractControlBean implements
		Operfunction {

	public OperfunctionVO doCreate(OperfunctionVO vo) throws Exception {
		try {
			OperfunctionDAO dao = (OperfunctionDAO) DAOFactory.build(OperfunctionDAO.class, user);
			// TODO set the pk */
			return (OperfunctionVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OperfunctionVO vo) throws Exception {
		try {
			OperfunctionDAO dao = (OperfunctionDAO) DAOFactory.build(OperfunctionDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OperfunctionDAO dao = (OperfunctionDAO) DAOFactory.build(OperfunctionDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OperfunctionVO doUpdate(OperfunctionVO vo) throws Exception {
		try {
			OperfunctionDAO dao = (OperfunctionDAO) DAOFactory.build(OperfunctionDAO.class,user);
			return (OperfunctionVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OperfunctionVO doFindByPk(Serializable pk) throws Exception {
		OperfunctionDAO dao = (OperfunctionDAO) DAOFactory.build(OperfunctionDAO.class,user);
		return (OperfunctionVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OperfunctionDBParam params)
			throws Exception {
		OperfunctionDAO dao = (OperfunctionDAO) DAOFactory.build(OperfunctionDAO.class,user);
		return dao.query(params);
	}
	
	
	public void doBatchSave(List funcList, List operList) throws Exception{
		try {
			//OperfunctionDAO dao = (OperfunctionDAO) DAOFactory.build(OperfunctionDAO.class,user);
			Operfunction operfunction = (Operfunction)BOFactory.build(OperfunctionBO.class, user);
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
					for(Iterator ittOper = operList.iterator();ittOper.hasNext();){
						String operid = (String)ittOper.next();
						OperfunctionVO vo = new OperfunctionVO();
						vo.setOperid(operid);
						vo.setFunctionid(sonFuncid);
						if((OperfunctionVO) operfunction.doFindByPk(vo)==null){
							vo.setFlag((byte)1);
							vo.setStatus((byte)1);
							vo.setCreatedate(new Date());
							vo.setStatusdate(PublicUtils.UtilStrToDate("2099-12-31", "yyyy-MM-dd"));
							vo.setIsdefault((byte)1);
							operfunction.doCreate(vo);
						}
					}
				}
			}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
}
