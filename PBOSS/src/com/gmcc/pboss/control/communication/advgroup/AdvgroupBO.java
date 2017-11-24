/**
 * auto-generated code
 * Tue Sep 29 10:21:01 CST 2009
 */
package com.gmcc.pboss.control.communication.advgroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.gmcc.pboss.business.communication.advgroup.AdvgroupDAO;
import com.gmcc.pboss.business.communication.advgroup.AdvgroupDBParam;
import com.gmcc.pboss.business.communication.advgroup.AdvgroupVO;
import com.gmcc.pboss.business.communication.advgroup.AdvgroupVOHelper;
import com.gmcc.pboss.business.communication.advgroupobj.AdvgroupobjDBParam;
import com.gmcc.pboss.business.communication.advgroupobj.AdvgroupobjVO;
import com.gmcc.pboss.control.communication.advgroupobj.Advgroupobj;
import com.gmcc.pboss.control.communication.advgroupobj.AdvgroupobjBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: AdvgroupBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/communication/advgroup/control/AdvgroupBO"
*    name="Advgroup"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class AdvgroupBO extends AbstractControlBean implements
		Advgroup {

	public AdvgroupVO doCreate(AdvgroupVO vo) throws Exception {
		try {
			AdvgroupDAO dao = (AdvgroupDAO) DAOFactory.build(AdvgroupDAO.class, user);
			// TODO set the pk */
			return (AdvgroupVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(AdvgroupVO vo) throws Exception {
		try {
			AdvgroupDAO dao = (AdvgroupDAO) DAOFactory.build(AdvgroupDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			AdvgroupDAO dao = (AdvgroupDAO) DAOFactory.build(AdvgroupDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AdvgroupVO doUpdate(AdvgroupVO vo) throws Exception {
		try {
			AdvgroupDAO dao = (AdvgroupDAO) DAOFactory.build(AdvgroupDAO.class,user);
			return (AdvgroupVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public AdvgroupVO doFindByPk(Serializable pk) throws Exception {
		AdvgroupDAO dao = (AdvgroupDAO) DAOFactory.build(AdvgroupDAO.class,user);
		return (AdvgroupVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(AdvgroupDBParam params)
			throws Exception {
		AdvgroupDAO dao = (AdvgroupDAO) DAOFactory.build(AdvgroupDAO.class,user);
		return dao.query(params);
	}
	
	public DataPackage doUnionQuery(Object[] params,Class[] classvo,String[][] joins)throws Exception {
		AdvgroupDAO dao = (AdvgroupDAO) DAOFactory.build(AdvgroupDAO.class,user);
		return dao.unionQuery(params, classvo, joins);
	}
	
	//保存群组
	public Long doSaveGroup(AdvgroupVOHelper helper, Boolean createFlag) throws Exception
	{
		AdvgroupVO advgroupVO = new AdvgroupVO();
		BeanUtils.copyProperties(advgroupVO, helper);
		if(createFlag)
		{
			advgroupVO = doCreate(advgroupVO);
		}
		else
		{
			doUpdate(advgroupVO);
		}
		
		
		//保存到群组对象表
		Advgroupobj advgroupobj = (Advgroupobj)BOFactory.build(AdvgroupobjBO.class, user);
		if(!createFlag)
		{
			Long pk = -1L;
			AdvgroupobjDBParam param2 = new AdvgroupobjDBParam();
			param2.set_ne_groupid(String.valueOf(helper.getGroupid()));
			param2.set_pagesize("0");
			DataPackage dp2 = advgroupobj.doQuery(param2);
			List advgroupobjList = dp2.getDatas();
			for(int i=0; i<advgroupobjList.size(); i++)
			{
				pk = ((AdvgroupobjVO)advgroupobjList.get(i)).getGroupoid();
				advgroupobj.doRemoveByPK(pk);
			}
		}
		
		String objinfo = helper.getObjinfo();
		if(null!=objinfo && !objinfo.equals(""))
		{
			String[] objidArray = objinfo.split(",");
			for(int i=0; i<objidArray.length; i++)
			{
				AdvgroupobjVO advgroupobjVO = new AdvgroupobjVO();
				advgroupobjVO.setGroupid(advgroupVO.getGroupid());
				advgroupobjVO.setOid(objidArray[i].split(" ")[0]);
				advgroupobj.doCreate(advgroupobjVO);
			}
		}
		
		return advgroupVO.getGroupid();
	}
	
	//删除群组
    public void doDeleteGroup(Set<String> groupidSet) throws Exception{
    	String groupid = new String();
		//删除群组
		for(Iterator<String> iter = groupidSet.iterator(); iter.hasNext();)
		{
			groupid = iter.next();
			doRemoveByPK(Long.valueOf(groupid));
		}
		
		//删除对应群组人员
		Advgroupobj advgroupobj = (Advgroupobj)BOFactory.build(AdvgroupobjBO.class, user);
		AdvgroupobjDBParam param = new AdvgroupobjDBParam();
		DataPackage dp = new DataPackage();
		
		List<AdvgroupobjVO> advgroupobjList = new ArrayList();
		Long oid = -1L; 
		for(Iterator<String> iter = groupidSet.iterator(); iter.hasNext();)
		{
			groupid = iter.next();
			
			param.set_ne_groupid(groupid);
			param.set_pagesize("0");
			dp = advgroupobj.doQuery(param);
			advgroupobjList = dp.getDatas();
			
			if(dp.getRowCount()>0)
			{
				for(AdvgroupobjVO advgroupobjVO : advgroupobjList)
				{
					advgroupobj.doRemoveByPK(advgroupobjVO.getGroupoid());
				}
			}
		}
    }
    
	 //删除群组人员
	public void doDeleteGroupobj(Set<String> groupidSet, List<String> groupoidList) throws Exception{
		try {
			//删除群组人员，群组人员列表id为：群组id+";"+群组人员id
			Advgroupobj advgroupobj = (Advgroupobj)BOFactory.build(AdvgroupobjBO.class, user);
			AdvgroupobjDBParam param = new AdvgroupobjDBParam();
			param.set_sin_oid(groupoidList);
			param.set_pagesize("0");
			DataPackage dp = advgroupobj.doQuery(param);
			List<AdvgroupobjVO> advgroupobjList = dp.getDatas();
			
			for(AdvgroupobjVO advgroupobjVO : advgroupobjList)
			{
				advgroupobj.doRemoveByPK(advgroupobjVO.getGroupoid());
			}
			
			//如果群组里的所有群组人员都删除了，则删除该群组
			String groupid = new String();
			param = new AdvgroupobjDBParam();
			for(Iterator<String> iter = groupidSet.iterator(); iter.hasNext();)
			{
				groupid = iter.next();
				param.set_ne_groupid(groupid);
				dp = advgroupobj.doQuery(param);
				if(dp.getRowCount()==0)
				{
					doRemoveByPK(Long.valueOf(groupid));
				}
			}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
	
}
