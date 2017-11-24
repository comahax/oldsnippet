/**
 * auto-generated code
 * Wed Sep 08 17:44:18 CST 2010
 */
package com.gmcc.pboss.control.sales.vrealtimeamt;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.sales.orderpackdet.OrderpackdetVO;
import com.gmcc.pboss.business.sales.vrealtimeamt.VrealtimeamtDAO;
import com.gmcc.pboss.business.sales.vrealtimeamt.VrealtimeamtDBParam;
import com.gmcc.pboss.business.sales.vrealtimeamt.VrealtimeamtVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: VrealtimeamtBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
public class VrealtimeamtBO extends AbstractControlBean implements
		Vrealtimeamt {

	public VrealtimeamtVO doCreate(VrealtimeamtVO vo) throws Exception {
		try {
			VrealtimeamtDAO dao = (VrealtimeamtDAO) DAOFactory.build(VrealtimeamtDAO.class, user);
			// TODO set the pk */
			return (VrealtimeamtVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(VrealtimeamtVO vo) throws Exception {
		try {
			VrealtimeamtDAO dao = (VrealtimeamtDAO) DAOFactory.build(VrealtimeamtDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			VrealtimeamtDAO dao = (VrealtimeamtDAO) DAOFactory.build(VrealtimeamtDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public VrealtimeamtVO doUpdate(VrealtimeamtVO vo) throws Exception {
		try {
			VrealtimeamtDAO dao = (VrealtimeamtDAO) DAOFactory.build(VrealtimeamtDAO.class,user);
			return (VrealtimeamtVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new JOPException(ex);
		}
	}

	public VrealtimeamtVO doFindByPk(Serializable pk) throws Exception {
		VrealtimeamtDAO dao = (VrealtimeamtDAO) DAOFactory.build(VrealtimeamtDAO.class,user);
		return (VrealtimeamtVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(VrealtimeamtDBParam params)
			throws Exception {
		//Ĭ�ϲ�����Ʒ��
		//boolean djuge=false;
		VrealtimeamtDAO dao = (VrealtimeamtDAO) DAOFactory.build(VrealtimeamtDAO.class,user);
		/*//��ѯϵͳ����,���Ƿ���Ҫ����Ʒ��
		Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,user);
		SysparamVO listVO=new SysparamVO();
		listVO.setParamtype("pboss_fx");
		listVO.setSystemid(new Long("12"));
		listVO=sysparam.doFindByPk(listVO);
		if((listVO==null) || listVO!=null && "1".equals(listVO.getParamvalue()))
		{
			djuge=true;
		}
		
		if(djuge)
		{for (OrderpackdetVO vo : (List<OrderpackdetVO>) dp.getDatas()) {
		//��Ҫ����Ʒ��
*/		
		DataPackage dp= dao.queryByNamedSqlQuery("vrealtimeamtQuery", params);
		for(VrealtimeamtVO vo : (List<VrealtimeamtVO>) dp.getDatas()){
			//���¶�����
			Long monordered=(Long)(doGetMonordered(vo.getWayid(), vo.getComcategory()));
			vo.setMonordered(monordered);
			//���충����
			Long dayordered=(Long)(doGetDayordered(vo.getWayid(),vo.getComcategory()));
			vo.setDayordered(dayordered);
			//�����,���׿�ʱ����
			if("COMRESSMP".equals(vo.getRestype())){
			Long nowstock=(Long)(doGetNowstock(vo.getWayid(),vo.getComcategory()));
			vo.setNowstock(nowstock);
			//�ڶ������,���׿�ʱ����
			Long orderdstock=(Long)(doGetOrderstock(vo.getWayid(),vo.getComcategory()));
			vo.setOrderdstock(orderdstock);
			}
		}
		/*}
		else
		{
		//����Ҫ����Ʒ��
		return dao.queryByNamedSqlQuery("vrealtimeamt.with.way.nodjuge", params);
		}*/
		return dp;
	}
	/**
	 * ��ȡ���¶�����
	 * @param wayid
	 * @param comcategory
	 * @return
	 * @throws Exception
	 */
	public Object doGetMonordered(String wayid,String comcategory) throws Exception{
		VrealtimeamtDAO dao = (VrealtimeamtDAO) DAOFactory.build(VrealtimeamtDAO.class,user);
		VrealtimeamtDBParam param=new VrealtimeamtDBParam();
		param.getQueryConditions().put("WAYID", wayid);
		param.getQueryConditions().put("COMCATEGORY", comcategory);
		return dao.queryUniqueByNamedSqlQuery("vrealtimeamtMonthBook", param,Long.class);
	}
	
	/**
	 * ��ȡ���충����
	 * @param wayid
	 * @param comcategory
	 * @return
	 * @throws Exception
	 */
	public Object doGetDayordered(String wayid,String comcategory) throws Exception{
		VrealtimeamtDAO dao = (VrealtimeamtDAO) DAOFactory.build(VrealtimeamtDAO.class,user);
		VrealtimeamtDBParam param=new VrealtimeamtDBParam();
		param.getQueryConditions().put("WAYID", wayid);
		param.getQueryConditions().put("COMCATEGORY", comcategory);
		return dao.queryUniqueByNamedSqlQuery("vrealtimeamtTodayBook", param,Long.class);
	}
	
	/**
	 * ��ȡ�����
	 * @param wayid
	 * @param comcategory
	 * @return
	 * @throws Exception
	 */
	public Object doGetNowstock(String wayid,String comcategory) throws Exception{
		VrealtimeamtDAO dao = (VrealtimeamtDAO) DAOFactory.build(VrealtimeamtDAO.class,user);
		VrealtimeamtDBParam param=new VrealtimeamtDBParam();
		param.getQueryConditions().put("WAYID", wayid);
		param.getQueryConditions().put("COMCATEGORY", comcategory);
		return dao.queryUniqueByNamedSqlQuery("vrealtimeamtGoodsStore", param,Long.class);
	}
	/**
	 * ��ȡ�ڶ������
	 * @param wayid
	 * @param comcategory
	 * @return
	 * @throws Exception
	 */
	public Object doGetOrderstock(String wayid,String comcategory) throws Exception{
		VrealtimeamtDAO dao = (VrealtimeamtDAO) DAOFactory.build(VrealtimeamtDAO.class,user);
		VrealtimeamtDBParam param=new VrealtimeamtDBParam();
		param.getQueryConditions().put("WAYID", wayid);
		param.getQueryConditions().put("COMCATEGORY", comcategory);
		return dao.queryUniqueByNamedSqlQuery("vrealtimeamtPresaleGoodsStore", param,Long.class);
	}
	
}
