/**
* auto-generated code
* Thu Oct 23 11:41:56 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtyoperation.control;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.operation.persistent.OperationDAO;
import com.sunrise.boss.business.cms.operation.persistent.OperationListVO;
import com.sunrise.boss.business.cms.zjty.zjtyoperation.persistent.ZjtyOperationVO;
import com.sunrise.boss.business.cms.zjty.zjtyoperation.persistent.ZjtyOperationDAO;
import com.sunrise.boss.business.cms.zjty.zjtyoperation.persistent.ZjtyOperationListVO;

/**
 * <p>Title: ZjtyOperationControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtyoperation/control/ZjtyOperationControlBean"
 name="ZjtyOperationControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyOperationControlBean extends AbstractControlBean
    implements ZjtyOperationControl {

    public ZjtyOperationVO doCreate(ZjtyOperationVO vo, User user)
        throws Exception {
        try{
        	// TODO set the pk */
			ZjtyOperationDAO dao = (ZjtyOperationDAO) DAOFactory.build(
					ZjtyOperationDAO.class, user);
			if(StringUtils.isEmpty(vo.getParentid())){
				vo.setParentid("0");
			}
			
			vo = setFormatVO(vo, user);
			
			if (dao.findByPk(vo.getOpnid()) != null) {
				throw new BusinessException("", "有相同的记录存在!");
			}
			return (ZjtyOperationVO) dao.create(vo);
			
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    
    public void doRemove(ZjtyOperationVO vo, User user)
        throws Exception {
    	
		try {
			ZjtyOperationDAO dao = (ZjtyOperationDAO) DAOFactory.build(ZjtyOperationDAO.class, user);
			ZjtyOperationListVO listVO = new ZjtyOperationListVO();
			listVO.getQueryConditions().put("id", vo.getOpnid());
			Iterator i = (dao.queryByNamedSqlQuery("zjty.operation.downSearch", listVO)).getDatas().iterator();
			while(i.hasNext()){
				ZjtyOperationVO zjtyoperationVO = (ZjtyOperationVO)i.next();
				zjtyoperationVO.setState(new Short((short)-1));
				dao.update(zjtyoperationVO);
			}
			vo = (ZjtyOperationVO) dao.findByPk(vo);
			vo.setState(new Short((short)-1));
			dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
    }
    
    public ZjtyOperationVO doUpdate(ZjtyOperationVO vo, User user)
        throws Exception {
        try{
			ZjtyOperationDAO dao = (ZjtyOperationDAO) DAOFactory.build(ZjtyOperationDAO.class, user);
            return (ZjtyOperationVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ZjtyOperationVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyOperationDAO dao = (ZjtyOperationDAO) DAOFactory.build(ZjtyOperationDAO.class, user);
        return (ZjtyOperationVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ZjtyOperationListVO params, User user)
        throws Exception {
			ZjtyOperationDAO dao = (ZjtyOperationDAO) DAOFactory.build(ZjtyOperationDAO.class, user);
			params.set_orderby("opnid");
        return dao.query(params);
    }

	public DataPackage doQueryForTree(ZjtyOperationListVO params, User user)
			throws Exception {
			ZjtyOperationDAO dao = (ZjtyOperationDAO) DAOFactory.build(ZjtyOperationDAO.class, user);
        return dao.queryForTree(params);
	}
	public List doQueryupper(ZjtyOperationListVO params,User user) throws Exception{
		ZjtyOperationDAO dao = (ZjtyOperationDAO) DAOFactory.build(ZjtyOperationDAO.class,
				user);
		return dao.doQueryupper(params);
	}
	
	/**
	 * 整合vo
	 * @param str
	 * @param length
	 * @return
	 */
	public ZjtyOperationVO setFormatVO(ZjtyOperationVO vo, User user) throws Exception{
		String str = "";
		int level = getParentlevel(vo, user);
		if(level == 4){
			str=getFifthStr(vo.getParentid(),user);
			vo.setIsbusi(new Short("1"));
		}else{
			str = (getSubcount(vo, user) + 1) + "";
			for(int i = str.length(); i<2; i++){
				str = "0" + str;
			}
			vo.setIsbusi(new Short("0"));
			vo.setBusibelong(null);
		}
		str = vo.getParentid().substring(0, level*2) + str;
		for(int j = str.length(); j<13; j++){
			str = str + "0";
		}
		vo.setOpnid(str);
		vo.setState(new Short("1"));
		vo.setOpnlevel(new Short((short)(level+1)));
		return vo;
	}
	
	public String getFifthStr(String parentid, User user)throws Exception{
		ZjtyOperationDAO dao = (ZjtyOperationDAO) DAOFactory.build(ZjtyOperationDAO.class,user);
		return dao.getFifthStr(parentid);
	}
	/**
	 * 查询某个业务类型的子类型个数
	 * @param 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int getSubcount(ZjtyOperationVO vo, User user) throws Exception{
		ZjtyOperationDAO dao = (ZjtyOperationDAO) DAOFactory.build(ZjtyOperationDAO.class,user);
		ZjtyOperationListVO listVO = new ZjtyOperationListVO();
		listVO.set_se_parentid(vo.getParentid());
		return dao.query(listVO, 10).getRowCount();
	}
	
	
	/**
	 * 某个业务类型的级别
	 * @param vo
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int getParentlevel(ZjtyOperationVO vo, User user) throws Exception {
		ZjtyOperationDAO dao = (ZjtyOperationDAO) DAOFactory.build(ZjtyOperationDAO.class,user);
		ZjtyOperationListVO listVO = new ZjtyOperationListVO();
		listVO.getQueryConditions().put("upperid", vo.getParentid());
		return dao.queryByNamedSqlQuery("zjty.operation.upSearch", listVO, 10).getRowCount();		
	}
}
