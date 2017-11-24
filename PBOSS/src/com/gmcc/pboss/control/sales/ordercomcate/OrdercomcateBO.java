/**
 * auto-generated code
 * Tue Oct 13 12:38:53 CST 2009
 */
package com.gmcc.pboss.control.sales.ordercomcate;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.sales.alaordercol.AlaordercolDBParam;
import com.gmcc.pboss.business.sales.alaordercol.AlaordercolVO;
import com.gmcc.pboss.business.sales.ordcomlog.OrdcomlogVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateDAO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateDBParam;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateStocksVO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateVO;
import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtDBParam;
import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.sales.alaordercol.Alaordercol;
import com.gmcc.pboss.control.sales.alaordercol.AlaordercolBO;
import com.gmcc.pboss.control.sales.comorder.Comorder;
import com.gmcc.pboss.control.sales.comorder.ComorderBO;
import com.gmcc.pboss.control.sales.ordcomlog.Ordcomlog;
import com.gmcc.pboss.control.sales.ordcomlog.OrdcomlogBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.realtimeamt.Realtimeamt;
import com.gmcc.pboss.control.sales.realtimeamt.RealtimeamtBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrdercomcateBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrdercomcateBO extends AbstractControlBean implements
		Ordercomcate {

	public OrdercomcateVO doCreate(OrdercomcateVO vo) throws Exception {
		try {
			OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class, user);
			// TODO set the pk */
			return (OrdercomcateVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrdercomcateVO vo) throws Exception {
		try {
			OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrdercomcateVO doUpdate(OrdercomcateVO vo) throws Exception {
		try {
			OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class,user);
			return (OrdercomcateVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrdercomcateVO doFindByPk(Serializable pk) throws Exception {
		OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class,user);
		return (OrdercomcateVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrdercomcateDBParam params)
			throws Exception {
		OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class,user);
		return dao.query(params);
	}

	public DataPackage doQueryByNameSql(String nameSql,OrdercomcateDBParam params)
			throws Exception {
		OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class,user);
		return dao.queryByNamedSqlQuery(nameSql, params);
	}

	public Long doQueryOrderamtByAllBrand(String orderid) throws Exception {
		OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class, user);
		return dao.queryOrderamtByAllBrand(orderid);
	}
	
	/**
     *�Կͻ������հ�SIM����������ͳ��
     * @param orderid
     * @return
     * @throws Exception
     */
	
	public DataPackage doquerySimamtByOrderID(String orderid) throws Exception {
		OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class, user);
		OrdercomcateDBParam params = new OrdercomcateDBParam();
		params.setSelectFieldsString("comcategory,simamt");
		params.getQueryConditions().put("orderid", orderid);
		DataPackage dp = dao.queryByNamedSqlQuery("querySimamtByOrderID", params);
		return dp;
	}
	
	public Long doQueryOrderamtByBrand(String orderid, String brand) throws Exception {
		OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class, user);
		return dao.queryOrderamtByBrand(orderid, brand);
	}
	/**
	 * ��Ʒ�����������޸�,��5.2.12.2	���������߼�
	 */
	public void doAmtadjSave(String recid, String orderamt,String memo) throws Exception {
		try {
			Ordercomcate bo = (Ordercomcate)BOFactory.build(OrdercomcateBO.class,user);
			OrdercomcateVO vo=bo.doFindByPk(Long.valueOf(recid));
			if(vo!=null){
				Comorder comorderBO = (Comorder)BOFactory.build(ComorderBO.class,user);
				String unitage=comorderBO.doGetUnitage(user.getCityid(), vo.getComcategory());
				if(Double.valueOf(orderamt)%Double.valueOf(unitage)>0){
					throw new JOPException("��������Ϊ��������������!");
				}
				
				
				Long oldOrderamt=vo.getOrderamt();
				vo.setOrderamt(Long.valueOf(orderamt));
				Double totalprice=Long.valueOf(orderamt)* vo.getUnitprice();
				vo.setTotalprice(totalprice);
				bo.doUpdate(vo);
				//�Զ�����Ʒ������ܼ۽��л��ܣ����¶�������Ӧ�ս��
				OrdercomcateDBParam ordercomcateDBParam=new OrdercomcateDBParam();
				ordercomcateDBParam.set_se_orderid(vo.getOrderid());
				List<OrdercomcateVO> ordercomcateList=bo.doQuery(ordercomcateDBParam).getDatas();
				Double totalpriceSum=0d;
				for(OrdercomcateVO ordercomVO:ordercomcateList){
					totalpriceSum+=ordercomVO.getTotalprice();
				}
				Order orderbo = (Order)BOFactory.build(OrderBO.class,user);
				OrderVO orderVO=orderbo.doFindByPk(vo.getOrderid());
				orderVO.setRecamt(totalpriceSum);
				orderbo.doUpdate(orderVO);
				//ʵʱ���������ݸ���
				if("CUSTORDER".equals(vo.getOrdercomtype())){//������Ʒ����Ϊ�ͻ�����
					Comcategoryrela comcategoryrelaBO= (Comcategoryrela)BOFactory.build(ComcategoryrelaBO.class,user);//��Ʒ��Ϲ�ϵBO
					ComcategoryrelaDBParam comcategoryrelaDBParam=new ComcategoryrelaDBParam();
					comcategoryrelaDBParam.set_se_comcategory(vo.getComcategory());
					List<ComcategoryrelaVO> comcategList=comcategoryrelaBO.doQuery(comcategoryrelaDBParam).getDatas();//��Ʒ����
					if(comcategList.size()==0){
						throw new JOPException("��Ʒ����["+vo.getComcategory()+"]��Ϲ�ϵ���ݲ�����");
					}
					ComcategoryrelaVO comcateg=comcategList.get(0);//ȡ��һ����Ʒ����
					if("COMRESSMP".equals(comcateg.getRestype())){
						Long amtadj=Long.valueOf(orderamt)-oldOrderamt;//������=�����󶩹���-����ǰ������
						if(amtadj!=0){//������������0�����
							Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
							String sysparamvalue12=sysparamBO.doFindByID("12", "pboss_fx");
							Realtimeamt realtimeamtBO= (Realtimeamt)BOFactory.build(RealtimeamtBO.class,user);//��Ʒ��Ϲ�ϵBO
							RealtimeamtDBParam realtimeamtDBParam=new RealtimeamtDBParam();
							realtimeamtDBParam.set_se_wayid(orderVO.getWayid());
							if("1".equals(sysparamvalue12)){//����Ʒ��
								realtimeamtDBParam.set_se_brand(comcateg.getBrand());
							}else{
								realtimeamtDBParam.set_se_brand("AllBrand");
							}
							List<RealtimeamtVO> realtimeamtList=realtimeamtBO.doQuery(realtimeamtDBParam).getDatas();
							if(realtimeamtList.size()==0){
								throw new JOPException("������ʵʱ���������ݲ�����");
							}
							for(RealtimeamtVO realtimeamtVO:realtimeamtList){
								Long nowstock=realtimeamtVO.getNowstock()==null?0:realtimeamtVO.getNowstock();
								
								realtimeamtVO.setNowstock((nowstock+amtadj)<0?0:nowstock+amtadj);//��ǰ�����=��ǰ�����+������
								if(orderVO.getCreatetime().getMonth()==new Date().getMonth()){//�����������ʱ���ڵ�ǰ��
									Long monordered=realtimeamtVO.getMonordered()==null?0:realtimeamtVO.getMonordered();
									realtimeamtVO.setMonordered(monordered+amtadj<0?0:monordered+amtadj);//�����Ѷ�����=�����Ѷ�����+������
								}
								if(orderVO.getCreatetime().getDate()==new Date().getDate()){//�����������ʱ���ڵ�ǰ��
									Long dayordered=realtimeamtVO.getDayordered()==null?0:realtimeamtVO.getDayordered();
									realtimeamtVO.setDayordered(dayordered+amtadj<0?0:dayordered+amtadj);//�����Ѷ�����=�����Ѷ�����+������
								}
								realtimeamtVO.setUptime(new Date());
								realtimeamtBO.doUpdate(realtimeamtVO);
							}
						}
					}
					//��������Ʒ�������ǰ�󼰱�ע��¼����������Ʒ����������־[FX_SW_ORDCOMLOG]�����У�������Ϣ�����Ϣ�����������ơ���Ʒ���ơ����ǰ�������������������ע�������¸�ʽ�����������ơ�����Ʒ���ơ����ǰ���������������������ע��
					//���浽��������Ʒ����������־[FX_SW_ORDCOMLOG]�����еġ�����[OTHERS]���ֶ���
					Ordcomlog ordcomlogBO = (Ordcomlog)BOFactory.build(OrdcomlogBO.class,user);
					OrdcomlogVO ordcomlogVO=new OrdcomlogVO();
					ordcomlogVO.setOprcode(user.getOprcode());//��������
					ordcomlogVO.setOptime(new Date());//����ʱ��
					ordcomlogVO.setOrderid(vo.getOrderid());//�������
					ordcomlogVO.setOrdcomid(vo.getRecid());//������Ʒ���
					ordcomlogVO.setAmtb(oldOrderamt);//���ǰ����
					ordcomlogVO.setAmta(Long.valueOf(orderamt));//���������
					ordcomlogVO.setMemo(memo);
					String camcategoryName = Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", vo.getComcategory(), user.getCityid());
					String others="["+orderVO.getWayid()+"��("+camcategoryName+","+oldOrderamt+","+orderamt+")��"+memo+"]";
					ordcomlogVO.setOthers(others);
					ordcomlogBO.doCreate(ordcomlogVO);
					//���ܵ�ͳ�Ƹ����߼�
					Date today = new Date();
					Date ordercreatetime = orderVO.getCreatetime();
					int diff = PublicUtils.compareDate(ordercreatetime, today);//��������ʱ���뵱ǰ��������
					boolean isnotsameday = ((diff==0 && ordercreatetime.getDate()!=today.getDate()) || (diff!=0));//�Ƿ���ͬһ��
					
					if("AUTO".equals(orderVO.getOrderave()) && isnotsameday){//����;��[ORDERAVE]�����ڡ��Զ�[AUTO]��,��������ʱ�䲻Ϊ����
						Alaordercol alaordercolBO = (Alaordercol)BOFactory.build(AlaordercolBO.class,user);
						AlaordercolDBParam alaordercolDBParam=new AlaordercolDBParam();
						SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				    	String nowDate = format.format(orderVO.getCreatetime());
						alaordercolDBParam.set_se_coldate(nowDate);
						alaordercolDBParam.set_se_macode(orderVO.getMareacode());
						alaordercolDBParam.set_ne_starlevel(orderVO.getStarlevel().toString());
						alaordercolDBParam.set_se_alarmlevel(orderVO.getAlarmlevel());
						alaordercolDBParam.set_se_brand(comcateg.getBrand());
						DataPackage aladp=alaordercolBO.doQuery(alaordercolDBParam);
						if(null!=aladp && aladp.getDatas().size()>0){
							AlaordercolVO alavo = (AlaordercolVO)aladp.getDatas().get(0);
							alavo.setAmount(alavo.getAmount()+(Long.valueOf(orderamt)-oldOrderamt));
							alavo.setUpdatetime(new Date());
							alaordercolBO.doUpdate(alavo);
						}
					}
				}
			}
		} catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}
	/**
	 * ��ѯ��˿�����������Ϣ
	 * @param orderids
	 * @return
	 * @throws Exception
	 */
	 public List<OrdercomcateStocksVO> doOrdercomcateStocksQuery(String[] orderids ) throws Exception {
		 OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class, user);
			return dao.doOrdercomcateStocksQuery(orderids);
	 }

	public DataPackage doQueryEmptySimRealTimeUpdateDayMonthCount(String wayid)
			throws Exception {
		 OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class, user);
//			return dao.doQueryEmptySimRealTimeUpdateDayMonthCount(wayid);
			OrdercomcateDBParam params = new OrdercomcateDBParam();
			params.setSelectFieldsString("comcategory,count");
			params.getQueryConditions().put("wayid", wayid);

			DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.doQueryEmptySimRealTimeUpdateDayMonthCount", params);
			return dp;
			
	}

	public DataPackage doQueryEmptySimRealTimeUpdateBuyCount(String wayid)
			throws Exception {
		 OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class, user);
		 OrdercomcateDBParam params = new OrdercomcateDBParam();
			params.setSelectFieldsString("comcategory,count");
			params.getQueryConditions().put("wayid", wayid);

			DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.doQueryEmptySimRealTimeUpdateBuyCount", params);
			return dp;
	}
	 
	 //�����������۽������ ��ͳ����Ʒ���ඩ��������
	 public DataPackage doQueryDataByOrderId (String orderid) throws Exception{
		 OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class, user); 
		 OrdercomcateDBParam param = new OrdercomcateDBParam ();   
		 param.getQueryConditions().put("ORDERID",orderid);  
		 param.setSelectFieldsString("comcategory,orderamt");
		 param.setSelectFieldsUseVOType(true);
		 param.set_pagesize("0");
		 return dao.queryByNamedSqlQuery("queryDataByOrderId",param);
	 } 
}
