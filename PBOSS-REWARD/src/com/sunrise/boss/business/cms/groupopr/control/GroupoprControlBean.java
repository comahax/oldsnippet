/**
* auto-generated code
* Wed Sep 13 09:14:51 CST 2006
*/
package com.sunrise.boss.business.cms.groupopr.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeDAO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeVO;
import com.sunrise.boss.business.cms.groupopr.persistent.GroupoprVO;
import com.sunrise.boss.business.cms.groupopr.persistent.GroupoprDAO;
import com.sunrise.boss.business.cms.groupopr.persistent.GroupoprListVO;

/**
 * <p>Title: GroupoprControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/cms/groupopr/control/GroupoprControlBean"
*    name="GroupoprControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class GroupoprControlBean extends AbstractControlBean
    implements GroupoprControl {

    public GroupoprVO doCreate(GroupoprVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         GroupoprDAO dao = (GroupoprDAO) DAOFactory.build(GroupoprDAO.class, user );
         
         //检查是否已经存在相同的群组和人员关系
     	GroupoprListVO listVO = new GroupoprListVO();
    	listVO.set_ne_groupseq(vo.getGroupseq().toString());
    	listVO.set_se_oprseq(vo.getOprseq());
    	listVO.set_se_bossarea(vo.getBossarea());
    	DataPackage dp = dao.query(listVO);
    	
		if (dp.getDatas().size() > 0)
			throw new BusinessException("", "已经存在此信息，不能添加");

		if (vo.getBossarea()==null){
			if (user.getCityid()!=null){
				vo.setBossarea(user.getCityid());
			}else{
				throw new BusinessException("", "区域信息为空，不能添加");
			}
		}
			
		   return (GroupoprVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(GroupoprVO vo, User user)
        throws Exception {
        try{
         GroupoprDAO dao = (GroupoprDAO) DAOFactory.build(GroupoprDAO.class, user );
         dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public GroupoprVO doUpdate(GroupoprVO vo, User user)
        throws Exception {
        try{
         GroupoprDAO dao = (GroupoprDAO) DAOFactory.build(GroupoprDAO.class, user );
            return (GroupoprVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public GroupoprVO doFindByPk(Serializable pk, User user)
        throws Exception {
         GroupoprDAO dao = (GroupoprDAO) DAOFactory.build(GroupoprDAO.class, user );
        return (GroupoprVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(GroupoprListVO params, User user)
        throws Exception {
         GroupoprDAO dao = (GroupoprDAO) DAOFactory.build(GroupoprDAO.class, user );
        return dao.query(params);
    }
    
    /**
     * 根据得到的GroupoprVO的List转化为Employee的
     */
    public DataPackage doTranslateDP(DataPackage dp, User user)
       throws Exception {
        List list = (List) dp.getDatas();
        List result = null;
    	if (list!=null&&list.size() !=0){
    		EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class, user );
    		Iterator iter = list.iterator();
    		result = new ArrayList();
    		while (iter.hasNext()){
    			GroupoprVO groupoprVO =  (GroupoprVO)iter.next();
    			EmployeeVO employeeVO = (EmployeeVO) employeeDAO.findByPk((Serializable)groupoprVO.getOprseq());
    			if (employeeVO!=null){
    			   result.add(employeeVO);
    			}
    		}
    	}
    	
    	dp.setDatas(result);
        return dp;
    }
    
    //根据查询得到第一条值
    public GroupoprVO doFindByListVO(GroupoprListVO listVO, User user)  throws Exception {
    	GroupoprVO result = null;
        GroupoprDAO dao = (GroupoprDAO) DAOFactory.build(GroupoprDAO.class, user );
    	DataPackage dp = dao.query(listVO);
    	List list = (List) dp.getDatas();
    	if (list!=null&&list.size() !=0){
    		result = (GroupoprVO)list.get(0);
    	}
        return result;
    }
    
    //根据人员SEQ得到群组List
    public List doFindByOprSeq(String oprseq,User user) throws Exception {
        GroupoprDAO dao = (GroupoprDAO) DAOFactory.build(GroupoprDAO.class, user );
        GroupoprListVO listVO = new GroupoprListVO();
        listVO.set_se_oprseq(oprseq);
        DataPackage dp = dao.query(listVO);
        return (List)dp.getDatas();	
    }
}
