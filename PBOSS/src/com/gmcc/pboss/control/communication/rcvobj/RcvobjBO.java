/**
 * auto-generated code
 * Tue Sep 29 10:15:34 CST 2009
 */
package com.gmcc.pboss.control.communication.rcvobj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.communication.advinfo.AdvinfoDBParam;
import com.gmcc.pboss.business.communication.advinfo.AdvinfoVO;
import com.gmcc.pboss.business.communication.rcvobj.RcvobjConstant;
import com.gmcc.pboss.business.communication.rcvobj.RcvobjDAO;
import com.gmcc.pboss.business.communication.rcvobj.RcvobjDBParam;
import com.gmcc.pboss.business.communication.rcvobj.RcvobjVO;
import com.gmcc.pboss.control.communication.advinfo.Advinfo;
import com.gmcc.pboss.control.communication.advinfo.AdvinfoBO;
import com.gmcc.pboss.control.communication.advinfo.AdvinfoConstant;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RcvobjBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/communication/rcvobj/control/RcvobjBO"
*    name="Rcvobj"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class RcvobjBO extends AbstractControlBean implements
		Rcvobj {

	public RcvobjVO doCreate(RcvobjVO vo) throws Exception {
		try {
			RcvobjDAO dao = (RcvobjDAO) DAOFactory.build(RcvobjDAO.class, user);
			// TODO set the pk */
			return (RcvobjVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RcvobjVO vo) throws Exception {
		try {
			RcvobjDAO dao = (RcvobjDAO) DAOFactory.build(RcvobjDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RcvobjDAO dao = (RcvobjDAO) DAOFactory.build(RcvobjDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RcvobjVO doUpdate(RcvobjVO vo) throws Exception {
		try {
			RcvobjDAO dao = (RcvobjDAO) DAOFactory.build(RcvobjDAO.class,user);
			return (RcvobjVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RcvobjVO doFindByPk(Serializable pk) throws Exception {
		RcvobjDAO dao = (RcvobjDAO) DAOFactory.build(RcvobjDAO.class,user);
		return (RcvobjVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RcvobjDBParam params)
			throws Exception {
		RcvobjDAO dao = (RcvobjDAO) DAOFactory.build(RcvobjDAO.class,user);
		return dao.query(params);
	}
	
	//通过标题模糊查询公告列表
	public List<AdvinfoVO> doGetAdvinfoListByTitle(String title) throws Exception{
		Advinfo advinfo = (Advinfo)BOFactory.build(AdvinfoBO.class,user);
		AdvinfoDBParam param = new AdvinfoDBParam();
		param.set_sk_title(title);
		param.set_pagesize("0");
		DataPackage dp = advinfo.doQuery(param);
		return dp.getDatas();
	}
	
	//通过公告id获取公告信息
	public AdvinfoVO doGetAdvinfoByAdvinfoid(String advinfoid) throws Exception {
		Advinfo advinfo = (Advinfo)BOFactory.build(AdvinfoBO.class,user);
		AdvinfoDBParam param = new AdvinfoDBParam();
		param.set_ne_advinfoid(advinfoid);
		DataPackage dp = advinfo.doQuery(param);
		if(null!=dp.getDatas()&&dp.getRowCount()>0){
			return (AdvinfoVO)dp.getDatas().get(0);
		}
		else{
			return null;
		}
	}
	
	public DataPackage doUnionQuery(Object[] params,Class[] classvo,String[][] joins)throws Exception {
		RcvobjDAO dao = (RcvobjDAO) DAOFactory.build(RcvobjDAO.class,user);
		return dao.unionQuery(params, classvo, joins);
	}
	
	//保存接收对象
	public void doSaveRcvobj(Long advinfoid, String desttype, String objinfo, Boolean createFlag, Boolean destChangeFlag)throws Exception {
		//新增
		if(createFlag)
		{
			//接收接收对象类型为全社会、全部签约渠道或者全部签约渠道及其店员
			if(desttype.equals(AdvinfoConstant.DESTTYPE_SOCIETY)||desttype.equals(AdvinfoConstant.DESTTYPE_WAY)||desttype.equals(AdvinfoConstant.DESTTYPE_WAY_EMPLOYEE))
			{
				RcvobjVO rcvobjVO = new RcvobjVO();
				rcvobjVO.setAdvinfoid(advinfoid);
				rcvobjVO.setState(RcvobjConstant.STATE_OPEN);
				rcvobjVO.setObjid("@All");
				doCreate(rcvobjVO);
			}
			else if(!StringUtils.isEmpty(objinfo))
			{
				String[] objidArray = objinfo.split(",");
				//接收接收对象类型为特定群组或者内部工号，objinfo按需要只是单个objid，这里便于扩展，也支持objinfo由“,”拼接objid
				if(desttype.equals(AdvinfoConstant.DESTTYPE_GROUP)||desttype.equals(AdvinfoConstant.DESTTYPE_INSIDE))
				{
					for(int i=0; i<objidArray.length; i++)
					{
						RcvobjVO rcvobjVO = new RcvobjVO();
						rcvobjVO.setAdvinfoid(advinfoid);
						rcvobjVO.setState(RcvobjConstant.STATE_OPEN);
						rcvobjVO.setObjid(objidArray[i]);
						doCreate(rcvobjVO);
					}
				}
				//接收接收对象类型为特定对象
				else
				{
					for(int i=0; i<objidArray.length; i++)
					{
						RcvobjVO rcvobjVO = new RcvobjVO();
						rcvobjVO.setAdvinfoid(advinfoid);
						rcvobjVO.setState(RcvobjConstant.STATE_OPEN);
						rcvobjVO.setObjid(String.valueOf(objidArray[i].split(" ")[0]));
						doCreate(rcvobjVO);
					}
				}
			}
		}
		//编辑
		else
		{
			//获取原有接收对象列表
			RcvobjDBParam param = new RcvobjDBParam();
			param.set_ne_advinfoid(String.valueOf(advinfoid));
			param.set_pagesize("0");
			DataPackage dp = doQuery(param);
			List<RcvobjVO> rcvobjList = dp.getDatas();
			
			//获取原有接收对象id列表
			List<String> objidOldList = new ArrayList<String>();
			for(int i=0; i<rcvobjList.size(); i++)
			{
				objidOldList.add(rcvobjList.get(i).getObjid());
			}
			
			//获取修改后的接收对象id列表
			List<String> objidNewList = new ArrayList<String>();
			//接收接收对象类型为全社会、全部签约渠道或者全部签约渠道及其店员
			if(desttype.equals(AdvinfoConstant.DESTTYPE_SOCIETY)||desttype.equals(AdvinfoConstant.DESTTYPE_WAY)||desttype.equals(AdvinfoConstant.DESTTYPE_WAY_EMPLOYEE))
			{
				objidNewList.add("@All");
			}
			else if(!StringUtils.isEmpty(objinfo))
			{
				String[] objidArray = objinfo.split(",");
				//接收接收对象类型为特定群组或者内部工号
				if(desttype.equals(AdvinfoConstant.DESTTYPE_GROUP)||desttype.equals(AdvinfoConstant.DESTTYPE_INSIDE))
				{
					for(int i=0; i<objidArray.length; i++)
					{
						objidNewList.add(objidArray[i]);
					}
				}
				//接收接收对象类型为特定对象
				else
				{
					for(int i=0; i<objidArray.length; i++)
					{
						objidNewList.add(objidArray[i].split(" ")[0]);
					}
				}
			}
			
			//删除接收对象id列表
			List<String> removeIdList = new ArrayList<String>();
			removeIdList.addAll(objidOldList);
			//插入接收对象id列表
			List<String> insertIdList = new ArrayList<String>();
			insertIdList.addAll(objidNewList);
			//接收对象id交集列表
			List<String> interIdList = new ArrayList<String>();

			//获取删除接收对象列表和插入接收对象id列表
			//当接收对象类型没有变化时，新选择的接收对象和原有的接收对象中重复的项，不再插入，删除原有的不重复的项
			//当接收对象类型变化时，则删除所有原有的接收对象，插入所有新选择的接收对象
			if(!destChangeFlag)
			{
				//获取交集列表
				for(int i=0; i<objidNewList.size(); i++)
				{
					for(int j=0; j<objidOldList.size(); j++)
					{
						if(objidOldList.get(j).equals(objidNewList.get(i)))
						{
							interIdList.add(objidOldList.get(j));
							break;
						}
					}
				}
				
				//通过接收对象id交集列表和原有接收对象id列表获取删除id列表
				removeIdList.removeAll(interIdList);
				//通过接收对象id交集列表和修改后的接收对象id列表获取插入id列表
				insertIdList.removeAll(interIdList);
			}
			
			//删除
			Long pk = -1L;
			DataPackage dp2 = new DataPackage();
			for(int i=0; i<removeIdList.size(); i++)
			{
				RcvobjDBParam param2 = new RcvobjDBParam();
				param2.set_se_objid(removeIdList.get(i));
				dp2 = doQuery(param2);
				if(dp2.getRowCount()>0)
				{
					pk = ((RcvobjVO)dp2.getDatas().get(0)).getRvcobjid();
					doRemoveByPK(pk);
				}
			}

			//插入
			for(int i=0; i<insertIdList.size(); i++)
			{
				RcvobjVO rcvobjVO = new RcvobjVO();
				rcvobjVO.setAdvinfoid(advinfoid);
				rcvobjVO.setState(RcvobjConstant.STATE_OPEN);
				rcvobjVO.setObjid(insertIdList.get(i));
				doCreate(rcvobjVO);
			}
		}
	}
}
