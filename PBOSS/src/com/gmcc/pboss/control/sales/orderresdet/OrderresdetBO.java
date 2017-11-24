/**
 * auto-generated code
 * Tue Oct 13 15:13:34 CST 2009
 */
package com.gmcc.pboss.control.sales.orderresdet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.cooperator.CooperatorVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.com.ComVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.resource.compack.CompackDAO;
import com.gmcc.pboss.business.resource.compack.CompackDBParam;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.comrescard.ComrescardDBParam;
import com.gmcc.pboss.business.resource.comrescard.ComrescardVO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.business.resource.emptysim.EmptysimDBParam;
import com.gmcc.pboss.business.resource.emptysim.EmptysimVO;
import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.business.sales.extraexent.ExtraexentVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateDBParam;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateVO;
import com.gmcc.pboss.business.sales.orderpackdet.OrderpackdetVO;
import com.gmcc.pboss.business.sales.orderplan.OrderplanVO;
import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.business.sales.orderproce.OrderproceVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDAO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetVO;
import com.gmcc.pboss.common.utils.tools.TiedComInfo;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.cooperator.Cooperator;
import com.gmcc.pboss.control.channel.cooperator.CooperatorBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.promotion.spproposal.Spproposal;
import com.gmcc.pboss.control.promotion.spproposal.SpproposalBO;
import com.gmcc.pboss.control.resource.com.Com;
import com.gmcc.pboss.control.resource.com.ComBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.comrescard.Comrescard;
import com.gmcc.pboss.control.resource.comrescard.ComrescardBO;
import com.gmcc.pboss.control.resource.comressmp.Comressmp;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.control.resource.emptysim.Emptysim;
import com.gmcc.pboss.control.resource.emptysim.EmptysimBO;
import com.gmcc.pboss.control.sales.comorder.Comorder;
import com.gmcc.pboss.control.sales.comorder.ComorderBO;
import com.gmcc.pboss.control.sales.disform.Disform;
import com.gmcc.pboss.control.sales.disform.DisformBO;
import com.gmcc.pboss.control.sales.extraexent.Extraexent;
import com.gmcc.pboss.control.sales.extraexent.ExtraexentBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.ordercomcate.Ordercomcate;
import com.gmcc.pboss.control.sales.ordercomcate.OrdercomcateBO;
import com.gmcc.pboss.control.sales.orderpackdet.Orderpackdet;
import com.gmcc.pboss.control.sales.orderpackdet.OrderpackdetBO;
import com.gmcc.pboss.control.sales.orderplan.Orderplan;
import com.gmcc.pboss.control.sales.orderplan.OrderplanBO;
import com.gmcc.pboss.control.sales.orderproce.Orderproce;
import com.gmcc.pboss.control.sales.orderproce.OrderproceBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.exception.business.SaleException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderresdetBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderresdetBO extends AbstractControlBean implements
		Orderresdet {

	public OrderresdetVO doCreate(OrderresdetVO vo) throws Exception {
		try {
			OrderresdetDAO dao = (OrderresdetDAO) DAOFactory.build(OrderresdetDAO.class, user);
			// TODO set the pk */
			return (OrderresdetVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrderresdetVO vo) throws Exception {
		try {
			OrderresdetDAO dao = (OrderresdetDAO) DAOFactory.build(OrderresdetDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrderresdetDAO dao = (OrderresdetDAO) DAOFactory.build(OrderresdetDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderresdetVO doUpdate(OrderresdetVO vo) throws Exception {
		try {
			OrderresdetDAO dao = (OrderresdetDAO) DAOFactory.build(OrderresdetDAO.class,user);
			return (OrderresdetVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderresdetVO doFindByPk(Serializable pk) throws Exception {
		OrderresdetDAO dao = (OrderresdetDAO) DAOFactory.build(OrderresdetDAO.class,user);
		return (OrderresdetVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrderresdetDBParam params)
			throws Exception {
		OrderresdetDAO dao = (OrderresdetDAO) DAOFactory.build(OrderresdetDAO.class,user);
		return dao.query(params);
	}
	 /**
     * ��ѯ����Ʒ���࣬���Σ����ŷ��鶩����Դ��ϸ��Ϣ
     * @return
     * @throws Exception
     */
    public DataPackage doQueryOrderresdetGroupView(OrderresdetDBParam param) throws Exception {
    	OrderresdetDAO dao = (OrderresdetDAO) DAOFactory.build(OrderresdetDAO.class,user);
    	
		return dao.doQueryOrderresdetGroupView(param);
    }
	/**
	 * ��ֵ����ȡ
	 * @param comcate ������Ʒ����
	 * @param comcateg ��Ʒ�����ϵ
	 * @param paramMap ����MAP��
	 * @param drawPara ҳ��ָ����ֵ����ȡ��Χ
	 * @return
	 * @throws Exception
	 */
	private  Map doComrescardResdraw(OrdercomcateVO comcate,ComcategoryrelaVO comcateg,String sysparamvalue38,Map<String,Object> paramMap,Map drawPara) throws Exception {
		Map<String,Object> returnMap=new HashMap<String,Object>();
		List<String> residList=new ArrayList<String>();
		Long orderamt=comcate.getOrderamt();
		String comcategory=comcate.getComcategory();
		String camcategoryName = "";//��Ʒ��������
		String ordercomtype=comcate.getOrdercomtype();//������Ʒ����
		camcategoryName = Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", comcategory, user.getCityid());
		if(paramMap!=null){//paramMap
			orderamt=(Long)paramMap.get("orderamt");
			comcategory=(String)paramMap.get("comcategory");
		}
		Comrescard comrescardBO=(Comrescard)BOFactory.build(ComrescardBO.class,user);//��ֵ����ԴBO
		ComrescardDBParam comrescardDBParam=new ComrescardDBParam();
		comrescardDBParam.set_ne_comstate((short)1);
		comrescardDBParam.set_pagesize(String.valueOf(orderamt));
		
		comrescardDBParam.setDrawPara(drawPara);
		
		String countyid=null;//���������ֹ�˾
		String svccode=null;//����Ӫ������
		String upperwayid=null;//�ϼ�����
		String mareacode=null;//΢����
		Order orderbo = (Order)BOFactory.build(OrderBO.class,user);
		OrderVO orderVO=orderbo.doFindByPk(comcate.getOrderid());
		String extraexent=null;
		if("9".equals(sysparamvalue38)){
			Extraexent extraexentBO=(Extraexent)BOFactory.build(ExtraexentBO.class,user);//�ֹ�˾��Դ��ȡBO
			ExtraexentVO extraexentVO=new ExtraexentVO();
			extraexentVO.setCityid(user.getCityid());
			extraexentVO.setCountyid(orderVO.getCountyid());
			extraexentVO=extraexentBO.doFindByPk(extraexentVO);
			if(extraexentVO==null){
				String countyname=Code2NameUtils.code2Name("#CNTYCOMPANY", orderVO.getCountyid(), user.getCityid());
				returnMap.put("message", "�ֹ�˾["+countyname+"]��Դ��ȡ��Χ��Ϣȱʧ");
				returnMap.put("errorCode","SALE-203006");
				returnMap.put("value", countyname);
				return returnMap;
			}
			extraexent=extraexentVO.getExtraexent();
				
		}
		Way way = (Way) BOFactory.build(WayBO.class, user);
		if("1".equals(sysparamvalue38)||"1".equals(extraexent)){////�޶��ֹ�˾��Դ
			countyid=orderVO.getCountyid();
			if(countyid==null || "".equals(countyid)){
				returnMap.put("message", "�����ֹ�˾��Ϣȱʧ");
				returnMap.put("errorCode","SALE-203004");
				return returnMap;
			}
		}else if("2".equals(sysparamvalue38)||"2".equals(extraexent)){
			
			WayVO wayvo=way.doFindByPk(orderVO.getWayid());
			svccode=wayvo.getSvccode();
			if(svccode==null || "".equals(svccode)){
				returnMap.put("message", "�����̹�������Ӫ��������Ϣȱʧ");
				returnMap.put("errorCode","SALE-203002");
				return returnMap;
			}
		}else if("3".equals(sysparamvalue38)||"3".equals(extraexent)){
			WayVO wayvo=way.doFindByPk(orderVO.getWayid());
			upperwayid=wayvo.getUpperwayid();
			if(upperwayid==null || "".equals(upperwayid)){
				returnMap.put("message", "�������ϼ�������Ϣȱʧ");
				returnMap.put("errorCode","SALE-203003");
				return returnMap;
			}
			comrescardDBParam.set_se_wayid(upperwayid);
			
		}else if("4".equals(sysparamvalue38)||"4".equals(extraexent)){
			/*WayVO wayvo=way.doFindByPk(orderVO.getWayid());
			mareacode=wayvo.getMareacode();*/
			mareacode=orderVO.getMareacode();
			if(mareacode==null || "".equals(mareacode)){
				returnMap.put("message", "����΢������Ϣȱʧ");
				returnMap.put("errorCode","SALE-203005");
				return returnMap;
			}
		}
		
		//���ݵ��б�ʶ����Ʒ״̬�����ۣ�����Ʒ���ࡢ����������ѯ��ֵ����Դ��IM_FX_COMRESCARD������Ʒ������Ϲ�ϵ�������κ���Ʒ��Դ�������
		List<Object[]> comrescardList=comrescardBO.doQueryByComcategory(comrescardDBParam, comcategory,countyid,svccode,mareacode).getDatas();//��ֵ����Դ��ѯ����
		if(comrescardList.size()==0){
			String memo = setComcate(comrescardDBParam, comcategory);
			returnMap.put("memo", memo);
			returnMap.put("ordercomcateVO", comcate);
			
			returnMap.put("message", "��Ʒ��Դ["+camcategoryName+"]������");
			returnMap.put("errorCode","SALE-202001");
			returnMap.put("value", comcategory);
			returnMap.put("comcode", comcategory);
			return returnMap;
		}
		if(comrescardList.size()<comcate.getOrderamt()){
			String memo = setComcate(comrescardDBParam, comcategory);
			returnMap.put("memo", memo);
			returnMap.put("ordercomcateVO", comcate);
			
			returnMap.put("message", "��Ʒ��Դ["+camcategoryName+"]��治��");
			returnMap.put("errorCode","SALE-202004");
			returnMap.put("value", comcategory);
			returnMap.put("comcode", comcategory);
			return returnMap;
		}
		ComrescardVO comrescardVO=null;//��ֵ��VO
		OrderresdetVO orderresdetVO=null;//������Դ��ϸVO
		Com comBO=(Com)BOFactory.build(ComBO.class,user);//��Ʒ����BO
		ComVO comVO=null;
		for(Object[] objArray:comrescardList){
			comrescardVO=(ComrescardVO)objArray[1];//��ֵ��
			comVO=comBO.doFindByPk(comrescardVO.getComid());
			//�޸ĳ�ֵ����Դ״̬Ϊ��ȡ̬
			comrescardVO.setComstate((short)10);
			comrescardBO.doUpdate(comrescardVO);
			orderresdetVO=new OrderresdetVO();
			orderresdetVO.setOrderid(comcate.getOrderid());//�������
			orderresdetVO.setOrdercomtype(ordercomtype);//������Ʒ����
			orderresdetVO.setComcategory(comcategory);//��Ʒ����
			orderresdetVO.setRestype(comcateg.getRestype());//��Դ���
			orderresdetVO.setComid(comrescardVO.getComid());
			orderresdetVO.setComresid(comrescardVO.getComresid());//��Ʒ��Դ���
			orderresdetVO.setBatchno(comrescardVO.getBatchno());//����
			orderresdetVO.setWayid(comrescardVO.getWayid());//����ID
			orderresdetVO.setBrand((String)objArray[0]);
			orderresdetVO.setComprice(comVO.getComprice()==null?0:comVO.getComprice()*0.01);//��Ʒԭ��
			orderresdetVO.setActprice(comcate.getUnitprice());//ʵ���ۼ�
			this.doCreate(orderresdetVO);
			residList.add(String.valueOf(comrescardVO.getComresid()));//��¼��ԴID����Ʒ��ʶ���ֻ����룩
		}
		returnMap.put("residList", residList);
		return returnMap;
	}
	
	/**
	 * ǰ̨�趨��ȡ��Χʱ����¼��memo��
	 * 
	 * @param comcate
	 * @param comrescardDBParam
	 * @param comcategory
	 * @throws Exception
	 */
	private String setComcate(ComrescardDBParam comrescardDBParam,String comcategory) throws Exception {
		String memo = "";
				
		Map drawPara = comrescardDBParam.getDrawPara();
		if(drawPara != null && !"".equals(drawPara)){
			if(drawPara.containsKey(comcategory)){
				List numDou = (List)drawPara.get(comcategory);
				
				for (int i = 0; i < numDou.size(); i++) {
					String[] item = (String[])numDou.get(i);
					memo = memo + item[0] + "-" + item[1] + ",";
				}				
			}
		}
		if(!"".equals(memo))
			memo = memo.substring(0, memo.length() - 1);
		
		return memo;
		
	}
	/**
	 * �հ�SIM����ȡ
	 * @param comcate ������Ʒ����
	 * @param comcateg ��Ʒ�����ϵ
	 * @param paramMap ����MAP��
	
	 * @return
	 * @throws Exception
	 */
	private  Map doEmptysimResdraw(OrdercomcateVO comcate,ComcategoryrelaVO comcateg,String sysparamvalue38,Map<String,Object> paramMap) throws Exception {
		Map<String,Object> returnMap=new HashMap<String,Object>();
		List<String> residList=new ArrayList<String>();
		Long orderamt=comcate.getOrderamt();
		String comcategory=comcate.getComcategory();
		String camcategoryName = "";//��Ʒ��������
		String ordercomtype=comcate.getOrdercomtype();//������Ʒ����
		camcategoryName = Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", comcategory, user.getCityid());
		if(paramMap!=null){//paramMap
			orderamt=(Long)paramMap.get("orderamt");
			comcategory=(String)paramMap.get("comcategory");
		}
		Emptysim emptysimBO=(Emptysim)BOFactory.build(EmptysimBO.class,user);//��ֵ����ԴBO
		EmptysimDBParam emptysimDBParam=new EmptysimDBParam();
		emptysimDBParam.set_ne_comid(comcateg.getComid());
		emptysimDBParam.set_ne_usestate("1");
		emptysimDBParam.set_pagesize(String.valueOf(orderamt));
		
		
		
		String countyid=null;//���������ֹ�˾
		String svccode=null;//����Ӫ������
		String upperwayid=null;//�ϼ�����
		String mareacode=null;//΢����
		Order orderbo = (Order)BOFactory.build(OrderBO.class,user);
		OrderVO orderVO=orderbo.doFindByPk(comcate.getOrderid());
		String extraexent=null;
		if("9".equals(sysparamvalue38)){
			Extraexent extraexentBO=(Extraexent)BOFactory.build(ExtraexentBO.class,user);//�ֹ�˾��Դ��ȡBO
			ExtraexentVO extraexentVO=new ExtraexentVO();
			extraexentVO.setCityid(user.getCityid());
			extraexentVO.setCountyid(orderVO.getCountyid());
			extraexentVO=extraexentBO.doFindByPk(extraexentVO);
			if(extraexentVO==null){
				String countyname=Code2NameUtils.code2Name("#CNTYCOMPANY", orderVO.getCountyid(), user.getCityid());
				returnMap.put("message", "�ֹ�˾["+countyname+"]��Դ��ȡ��Χ��Ϣȱʧ");
				returnMap.put("errorCode","SALE-203006");
				returnMap.put("value", countyname);
				return returnMap;
			}
			extraexent=extraexentVO.getExtraexent();
				
		}
		Way way = (Way) BOFactory.build(WayBO.class, user);
		if("1".equals(sysparamvalue38)||"1".equals(extraexent)){////�޶��ֹ�˾��Դ
			countyid=orderVO.getCountyid();
			if(countyid==null || "".equals(countyid)){
				returnMap.put("message", "�����ֹ�˾��Ϣȱʧ");
				returnMap.put("errorCode","SALE-203004");
				return returnMap;
			}
		}else if("2".equals(sysparamvalue38)||"2".equals(extraexent)){
			
			WayVO wayvo=way.doFindByPk(orderVO.getWayid());
			svccode=wayvo.getSvccode();
			if(svccode==null || "".equals(svccode)){
				returnMap.put("message", "�����̹�������Ӫ��������Ϣȱʧ");
				returnMap.put("errorCode","SALE-203002");
				return returnMap;
			}
		}else if("3".equals(sysparamvalue38)||"3".equals(extraexent)){
			WayVO wayvo=way.doFindByPk(orderVO.getWayid());
			upperwayid=wayvo.getUpperwayid();
			if(upperwayid==null || "".equals(upperwayid)){
				returnMap.put("message", "�������ϼ�������Ϣȱʧ");
				returnMap.put("errorCode","SALE-203003");
				return returnMap;
			}
			emptysimDBParam.set_se_wayid(upperwayid);
			
		}else if("4".equals(sysparamvalue38)||"4".equals(extraexent)){
			/*WayVO wayvo=way.doFindByPk(orderVO.getWayid());
			mareacode=wayvo.getMareacode();*/
			mareacode=orderVO.getMareacode();
			if(mareacode==null || "".equals(mareacode)){
				returnMap.put("message", "����΢������Ϣȱʧ");
				returnMap.put("errorCode","SALE-203005");
				return returnMap;
			}
		}
		
		//���ݵ��б�ʶ����Ʒ״̬�����ۣ�����Ʒ��ʶ������������ѯ�հ�SIM����Դ�������κźͿհ�SIM�����к�����
		List<EmptysimVO> emptysimList=emptysimBO.doQueryByComcategory(emptysimDBParam,countyid,svccode,mareacode).getDatas();//�հ�SIM����Դ��ѯ����
		if(emptysimList.size()==0){
			
			returnMap.put("message", "��Ʒ��Դ["+camcategoryName+"]������");
			returnMap.put("errorCode","SALE-202001");
			returnMap.put("value", comcategory);
			returnMap.put("comcode", comcategory);
			return returnMap;
		}
		if(emptysimList.size()<comcate.getOrderamt()){
			
			returnMap.put("message", "��Ʒ��Դ["+camcategoryName+"]��治��");
			returnMap.put("errorCode","SALE-202004");
			returnMap.put("value", comcategory);
			returnMap.put("comcode", comcategory);
			return returnMap;
		}
		
		EmptysimVO emptysimVO=null;//�հ�SIM��VO
		OrderresdetVO orderresdetVO=null;//������Դ��ϸVO
		Com comBO = (Com) BOFactory.build(ComBO.class, user);// ��Ʒ����BO
		ComVO comVO = new ComVO();
		for(EmptysimVO obj:emptysimList){
			emptysimVO=obj;//�հ�SIM��
			//�޸Ŀհ�SIM����Դ״̬Ϊ��ȡ̬
			emptysimVO.setUsestate((short)10);
			emptysimBO.doUpdate(emptysimVO);
			comVO = comBO.doFindByPk(emptysimVO.getComid());
			orderresdetVO=new OrderresdetVO();
			orderresdetVO.setOrderid(comcate.getOrderid());//�������
			orderresdetVO.setOrdercomtype(ordercomtype);//������Ʒ����
			orderresdetVO.setComcategory(comcategory);//��Ʒ����
			orderresdetVO.setComid(emptysimVO.getComid());//��Ʒ��ʶ
			orderresdetVO.setRestype(comcateg.getRestype());//��Դ���
			orderresdetVO.setWayid(emptysimVO.getWayid());//����ID
			orderresdetVO.setEmptyno(emptysimVO.getEmptyno());//�հ׿����к�
			orderresdetVO.setBatchno(emptysimVO.getBatchno());//��Ʒ����
			orderresdetVO.setComprice(comVO.getComprice() == null ? 0 : comVO.getComprice() * 0.01);//��Ʒԭ��
			orderresdetVO.setActprice(comcate.getUnitprice());//ʵ���ۼ�
			this.doCreate(orderresdetVO);
			//residList.add(String.valueOf(comrescardVO.getComresid()));//��¼��ԴID����Ʒ��ʶ���ֻ����룩
		}
		//returnMap.put("residList", residList);
		return returnMap;
	}
	
	/**
	 * �׿���ȡ
	 * @param brandMap Ʒ��MAP
	 * @param sysparamvalue21 ���������̲���
	 * @param comcate ������Ʒ����
	 * @param comcateg ��Ʒ�����ϵ
	 * @param nosect �����ŶΣ�ָ���Ŷκ�ѭ���Ŷβ��У�����ΪNULL��
	 * @param isCycsect �Ƿ�ѭ���Ŷβ�ѯ
	 * @param isRandom	�����ȡ
	 * @param paramMap ����MAP��
	 * @return
	 * @throws Exception
	 */
	private Map doComressmpResdraw(Map brandMap,String sysparamvalue21,String sysparamvalue38,OrdercomcateVO comcate,ComcategoryrelaVO comcateg,String nosect,boolean isCycsect,boolean isRandom,Map<String,Object> paramMap) throws Exception{
		//boolean isRandom=true;
		Map<String,Object> returnMap=new HashMap<String,Object>();
		List<String> residList=new ArrayList<String>();
		OrderresdetVO orderresdetVO=null;//������Դ��ϸVO
		//CompackVO compackVO=null;//��Ʒ��VO
		//DiscomresVO discomresVO=null;//��������ԴVO
		OrderpackdetVO orderpackdetVO=null;
		CompackDBParam compackDBParam=new CompackDBParam();
		ComressmpDBParam comressmpDBParam=new ComressmpDBParam();
		Order orderbo = (Order)BOFactory.build(OrderBO.class,user);
		Compack compackBO=(Compack)BOFactory.build(CompackBO.class,user);//��Ʒ��BO
		Comressmp comressmpBO=(Comressmp)BOFactory.build(ComressmpBO.class,user);//�׿���ԴBO
		Orderpackdet orderpackdetBO=(Orderpackdet)BOFactory.build(OrderpackdetBO.class,user);//�׿���ԴBO
		OrderVO orderVO=orderbo.doFindByPk(comcate.getOrderid());
		List<ComressmpVO> comressmpList=null;//�׿���ѯ����
		List<CompackVO> compackListZ=null;//������Ʒ����ѯ����
		List<CompackVO> compackListY=null;//������Ʒ����ѯ����
		List<CompackVO> compackListRandom=null;//�������Ʒ����ѯ����
		List<CompackVO> compackListZH=null;//���ƥ����������ѯ����
		Long orderamt=comcate.getOrderamt();
		String comcategory=comcate.getComcategory();
		String ordercomtype=comcate.getOrdercomtype();//������Ʒ����
		if(paramMap!=null && paramMap.get("boxAmtY")==null){//paramMap
			orderamt=(Long)paramMap.get("orderamt");
			comcategory=(String)paramMap.get("comcategory");
		}
		String resuse="";
		//�ͻ�������Ӧ�ճ�����
		if("CUSTORDER".equals(comcate.getOrdercomtype())){
			resuse="NORMAL";
		}
		//ϵͳ���۶�Ӧ���ר��
		else if("SYSTIEIN".equals(comcate.getOrdercomtype())){
			resuse="TIEIN";
		}
		//ϵͳ���Ͷ�Ӧ����ר�á�
		else if("SYSGIFT".equals(comcate.getOrdercomtype())){
			resuse="PRESENT";
		}
		//����;��Ϊ����ʱ����Ӧ����
		if("URGENT".equals(orderVO.getOrderave())){
			resuse="URGENT";
		}
		
		//�����׿�Ʒ�Ʋ�ѯƷ�ư���СMAP���������������ʾ���׿�Ʒ��[xxx]����С����δ���á������ء�
		String brandName = Code2NameUtils.code2Name("$FX_SMPBRAND", comcateg.getBrand(), user.getCityid());
		if(!brandMap.containsKey(comcateg.getBrand())){
			returnMap.put("message", "�׿�Ʒ�ư���С["+brandName+"]����δ����");
			returnMap.put("errorCode","SALE-201003");
			returnMap.put("value", brandName);
			returnMap.put("brandName", brandName);
			return returnMap;
		}
		Long brandamt=(Long)brandMap.get(comcateg.getBrand());
		long boxAmtZ=orderamt/brandamt;//��Ʒ������
		long boxAmtY=orderamt%brandamt;//����
		if(isCycsect){//Ϊѭ���Ŷγ�ȡ��ʱ��������ȡΪ1,������ȡ����
			if(paramMap!=null && paramMap.get("boxAmtY")!=null){//���
				boxAmtZ=0;
				boxAmtY=(Long)paramMap.get("boxAmtY");
			}else{//����
				boxAmtZ=1;
				boxAmtY=0;
			}
		}
		
		//������Ʒ���ࡢ��Ʒ�����������׿�Ʒ�ư���С������״̬�����ۣ�����Դ��;���������������������̣�������ʱʡ�ԣ���
		//��ȡ��������ѯ��Ʒ����IM_PR_COMPACK���������κͰ�������
		compackDBParam.set_se_comcategory(comcategory);//��Ʒ����
		compackDBParam.set_se_packstate("1");//��״̬
		
		
		compackDBParam.set_se_resuse(resuse);//��Դ��;
		compackDBParam.set_orderby("batchno,boxnum");
		compackDBParam.set_desc("0");
		if("1".equals(sysparamvalue21)){//������Դ�Ƿ����������
			compackDBParam.set_se_discomcode(sysparamvalue21);//������
			Way way = (Way) BOFactory.build(WayBO.class, user);
			WayDBParam params = new WayDBParam();
			params.set_se_wayid(orderVO.getWayid());
			params.set_se_waytype("AG");
			DataPackage dp = way.doQuery(params);
			compackDBParam.set_se_discomcode(((WayVO)dp.getDatas().get(0)).getLogiscode()==null?" ":((WayVO)dp.getDatas().get(0)).getLogiscode()); 
		}
		String countyid=null;//���������ֹ�˾
		String svccode=null;//����Ӫ������
		String upperwayid=null;//�ϼ�����
		String mareacode=null;//΢����
		String extraexent=null;
		if("9".equals(sysparamvalue38)){//������Դ�Ƿ��޶���Դ,9--��ѯ�ֹ�˾��Դ��ȡ��Χ�� (FX_EXTRAEXENT)����ȡ��ȡ��Χֵ
			Extraexent extraexentBO=(Extraexent)BOFactory.build(ExtraexentBO.class,user);//�ֹ�˾��Դ��ȡBO
			ExtraexentVO extraexentVO=new ExtraexentVO();
			extraexentVO.setCityid(user.getCityid());
			extraexentVO.setCountyid(orderVO.getCountyid());
			extraexentVO=extraexentBO.doFindByPk(extraexentVO);
			if(extraexentVO==null){
				String countyname=Code2NameUtils.code2Name("#CNTYCOMPANY", orderVO.getCountyid(), user.getCityid());
				returnMap.put("message", "�ֹ�˾["+countyname+"]��Դ��ȡ��Χ��Ϣȱʧ");
				returnMap.put("errorCode","SALE-203006");
				returnMap.put("value", countyname);
				return returnMap;
			}
			extraexent=extraexentVO.getExtraexent();
				
		}
		Way way = (Way) BOFactory.build(WayBO.class, user);
		if("1".equals(sysparamvalue38)||"1".equals(extraexent)){//�޶��ֹ�˾��Դ
			countyid=orderVO.getCountyid();
			if(countyid==null || "".equals(countyid)){
				returnMap.put("message", "�����ֹ�˾��Ϣȱʧ");
				returnMap.put("errorCode","SALE-203004");
				return returnMap;
			}
		}else if("2".equals(sysparamvalue38)||"2".equals(extraexent)){//�޶�����Ӫ������
			WayVO wayvo=way.doFindByPk(orderVO.getWayid());
			svccode=wayvo.getSvccode();
			if(svccode==null || "".equals(svccode)){
				returnMap.put("message", "�����̹�������Ӫ��������Ϣȱʧ");
				returnMap.put("errorCode","SALE-203002");
				return returnMap;
			}
		}else if("3".equals(sysparamvalue38)||"3".equals(extraexent)){//�޶���Դ��������Ϊ���������̵��ϼ�����
			WayVO wayvo=way.doFindByPk(orderVO.getWayid());
			upperwayid=wayvo.getUpperwayid();
			if(upperwayid==null || "".equals(upperwayid)){
				returnMap.put("message", "�������ϼ�������Ϣȱʧ");
				returnMap.put("errorCode","SALE-203003");
				return returnMap;
			}
			compackDBParam.set_se_wayid(upperwayid);
		}else if("4".equals(sysparamvalue38)||"4".equals(extraexent)){//�޶�΢����
			mareacode=orderVO.getMareacode();
			if(mareacode==null || "".equals(mareacode)){
				returnMap.put("message", "����΢������Ϣȱʧ");
				returnMap.put("errorCode","SALE-203005");
				return returnMap;
			}
		}
		if(nosect!=null){
			compackDBParam.set_se_nosect(nosect);//�����Ŷ�
		}
		compackDBParam.set_se_storarea(orderVO.getStorarea());//��������
		String camcategoryName = "";//��Ʒ��������
		camcategoryName = Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", comcategory, user.getCityid());
		long boxZcount=0;
		long random=0;
		if(boxAmtZ>0){
			compackDBParam.set_ne_amount(new Short(brandamt+""));//��Ʒ�����������׿�Ʒ�ư���С��
			
			if(isRandom){ //�������ȡʱ
				/*������Ʒ���ࡢ��Ʒ�����������׿�Ʒ�ư���С������״̬�����ۣ�����Դ��;���������������������̣�������ʱʡ�ԣ���
				 * ��Դ�������������޶��ֹ�˾ʱʡ�ԣ��޶��ֹ�˾ʱ�޶���Դ���������ķֹ�˾Ϊ������Ϣ�ķֹ�˾������Ʒ����IM_PR_COMPACK������ͳ�Ʋ�ѯ
				 */
				compackDBParam.setCountOnly(true);
				if(countyid==null && svccode==null && mareacode==null){//���޶��ֹ�˾�ͷ��޶�����Ӫ������\΢������Դ��ѯ��Ʒ��
					boxZcount=compackBO.doQuery(compackDBParam).getRowCount();
				}else{//�޶��ֹ�˾��Դ��ѯ��Ʒ��
					boxZcount= compackBO.doQueryCompackResdraw(compackDBParam, countyid,svccode,mareacode).getRowCount();
				}
				if(boxZcount==0){//�����������0����ʾ��������ȡ��SALE-202001��������Ʒ������봫�룩�����أ�
					returnMap.put("message","��Ʒ��Դ["+camcategoryName+"]������");
					returnMap.put("errorCode","SALE-202001");
					returnMap.put("value", comcategory);
					returnMap.put("comcode", comcategory);
					return returnMap;
				}else if(boxZcount<boxAmtZ){//�����Ʒ��ͳ������С�ڴ���ȡ����������ʾ��������ȡ��SALE-202004��������Ʒ������봫�룩�����ء�
					returnMap.put("message", "��Ʒ��Դ["+camcategoryName+"]��治��");
					returnMap.put("errorCode","SALE-202004");
					returnMap.put("value", comcategory);
					returnMap.put("comcode", comcategory);
					return returnMap;
				}
				random=new Random().nextInt((int)(boxZcount-boxAmtZ+1));
				compackDBParam.setCountOnly(false);
				
			}
			compackDBParam.set_pagesize(String.valueOf(random+boxAmtZ));//��ѯ��¼��
			
			if(countyid==null && svccode==null && mareacode==null){//���޶��ֹ�˾�ͷ��޶�����Ӫ������\΢������Դ��ѯ��Ʒ��
				compackListZ=compackBO.doQuery(compackDBParam).getDatas();
			}else{//�޶��ֹ�˾��Դ��ѯ��Ʒ��
				compackListZ= compackBO.doQueryCompackResdraw(compackDBParam, countyid,svccode,mareacode).getDatas();
			}
			//�������������ʾ����Ʒ��Դ[��Ʒ�������]�����ꡱ������
			if(compackListZ.size()==0 ){
				returnMap.put("message","��Ʒ��Դ["+camcategoryName+"]������");
				returnMap.put("errorCode","SALE-202001");
				returnMap.put("value", comcategory);
				returnMap.put("comcode", comcategory);
				return returnMap;
			}
			//�����������������ʾ����Ʒ��Դ[��Ʒ�������]��治�㡱������
			if(compackListZ.size()<boxAmtZ){
				returnMap.put("message", "��Ʒ��Դ["+camcategoryName+"]��治��");
				returnMap.put("errorCode","SALE-202004");
				returnMap.put("value", comcategory);
				returnMap.put("comcode", comcategory);
				return returnMap;
			}
		}
		
		//�����Ʒ��Դ���������������\
		boolean isBoxYZ=false;//����Ƿ�������
		Map<Long,Long> drawMap = new HashMap<Long, Long>();//���ƥ���������������ص�map
		Set<Long> keySet = null;
		long totalsum = 0;//����MAP������Ʒ����
		
		if(boxAmtY>0){
			//������Ʒ������������������������1����������ͬ�����г�ȡ
			compackDBParam.set_ne_amount(new Short(boxAmtY+""));
			compackDBParam.set_pagesize("1");
			//compackListY=compackBO.doQuery(compackDBParam).getDatas();
			if(countyid==null && svccode==null && mareacode==null){//���޶��ֹ�˾�ͷ��޶�����Ӫ������\΢������Դ��ѯ��Ʒ��
				compackListY=compackBO.doQuery(compackDBParam).getDatas();
			}else{//�޶��ֹ�˾��Դ��ѯ��Ʒ��
				compackListY= compackBO.doQueryCompackResdraw(compackDBParam, countyid,svccode,mareacode).getDatas();
			}
			
			
			if(compackListY.size()==0){
				//���û������������Ʒ����������ƥ��������ȡ����
				CompackDBParam cpdbparam = new CompackDBParam();
				BeanUtils.copyProperties(cpdbparam, compackDBParam);//����һ��compackDBParam�����ƥ����������ʹ�ã��Է��ƻ�ԭ�е�compackDBParam
				cpdbparam.set_ne_amount(null);
				drawMap = this.getResdrawMapByCombinMatchRemainder(comcategory, boxAmtY, brandamt,cpdbparam,countyid,svccode,mareacode);
				//���ݷ���MAP����Ʒ�����Ƿ������������������MAP�������г�ȡ��
				keySet=drawMap.keySet();
				for(Long key : keySet){
					totalsum = totalsum + drawMap.get(key);
				}
				//�������������������Ʒ���������׿�Ʒ�ư���С������������1���г�ȡ
				if(!(totalsum==boxAmtY)){
					compackDBParam.set_ne_amount(new Short(brandamt+""));//��Ʒ�����������׿�Ʒ�ư���С��
					if(isRandom){ //�������ȡʱ
						if((random==boxZcount-boxAmtZ)&& random!=0){
							random--;
						}
					}
					compackDBParam.set_pagesize(String.valueOf(random+boxAmtZ+1));//��ѯ��¼��+1
					
					//compackListZ=compackBO.doQuery(compackDBParam).getDatas();
					if(countyid==null && svccode==null && mareacode==null){//���޶��ֹ�˾�ͷ��޶�����Ӫ������\΢������Դ��ѯ��Ʒ��
						compackListZ=compackBO.doQuery(compackDBParam).getDatas();
					}else{//�޶��ֹ�˾��Դ��ѯ��Ʒ��
						compackListZ= compackBO.doQueryCompackResdraw(compackDBParam, countyid,svccode,mareacode).getDatas();
					}
					if(compackListZ.size()<(boxAmtZ+1)){
						returnMap.put("message", "��Ʒ��Դ["+camcategoryName+"]��治��");
						returnMap.put("errorCode","SALE-202004");
						returnMap.put("value", comcategory);
						returnMap.put("comcode", comcategory);
						return returnMap;
					}
					isBoxYZ=true;
				}
			}
		}
		if(isRandom){//�����ȡʱ
			if(random!=0){
				compackDBParam.set_ne_amount(new Short(brandamt+""));
				compackDBParam.set_pagesize(random+"");//��ѯ�����
				if(countyid==null && svccode==null && mareacode==null){//���޶��ֹ�˾�ͷ��޶�����Ӫ������\΢������Դ��ѯ��Ʒ��
					compackListRandom=compackBO.doQuery(compackDBParam).getDatas();
				}else{//�޶��ֹ�˾��Դ��ѯ��Ʒ��
					compackListRandom= compackBO.doQueryCompackResdraw(compackDBParam, countyid,svccode,mareacode).getDatas();
				}
			}
		}
		Com comBO=(Com)BOFactory.build(ComBO.class,user);//��Ʒ����BO
		ComVO comVO=null;
		if(compackListZ!=null  && compackListZ.size()>0){//����������ʱ��
			if(compackListRandom!=null)
				compackListZ.removeAll(compackListRandom);//ȥ�������������
			int count=1;
			for(CompackVO compackVO:compackListZ){
				if(!isBoxYZ || (isBoxYZ && count!=compackListZ.size())){//������������
					compackVO.setPackstate("10");
					compackBO.doUpdate(compackVO);
					comressmpDBParam.set_se_batchno(compackVO.getBatchno());//����
					comressmpDBParam.set_se_boxnum(compackVO.getBoxnum());//����
					comressmpDBParam.set_ne_comstate((short)1);
					comressmpDBParam.set_pagesize(brandamt+"");//��ѯ�׿�Ʒ�ư���С�����ļ�¼
					comressmpList=comressmpBO.doQuery(comressmpDBParam).getDatas();
					if(comressmpList==null || comressmpList.size()==0 ){
						returnMap.put("errorCode","SALE-203001");
						returnMap.put("value", brandName);
						returnMap.put("message", "��Ʒ����Դ������ʵ���׿���Դ������һ�£�");
						return returnMap;
					}
					for(ComressmpVO comressmpVO:comressmpList){
						comVO=comBO.doFindByPk(comressmpVO.getComid());
						comressmpVO.setComstate((short)10);//����Ϊ��ȡ̬
						comressmpBO.doUpdate(comressmpVO);
						orderresdetVO=new OrderresdetVO();
						orderresdetVO.setOrderid(comcate.getOrderid());//�������
						orderresdetVO.setOrdercomtype(comcate.getOrdercomtype());//������Ʒ����
						orderresdetVO.setComcategory(comcategory);//��Ʒ����
						orderresdetVO.setRestype(comcateg.getRestype());//��Դ���
						orderresdetVO.setComid(comressmpVO.getComid());//��Ʒ��ʶ
						orderresdetVO.setWayid(comressmpVO.getWayid());//����ID
						orderresdetVO.setComresid(comressmpVO.getComresid());//��Ʒ��Դ���
						orderresdetVO.setBatchno(comressmpVO.getBatchno());//����
						orderresdetVO.setBoxnum(comressmpVO.getBoxnum());//����
						orderresdetVO.setBrand(comressmpVO.getBrand());//Ʒ��
						orderresdetVO.setComprice(comVO.getComprice()==null?0:comVO.getComprice()*0.01);//��Ʒԭ��
						orderresdetVO.setActprice(comcate.getUnitprice());//ʵ���ۼ�
						this.doCreate(orderresdetVO);
						residList.add(String.valueOf(comressmpVO.getComresid()));//��¼��ԴID����Ʒ��ʶ���ֻ����룩
					}
					//������Ʒ����ϸ
					orderpackdetVO=new OrderpackdetVO();
					orderpackdetVO.setOrderid(orderVO.getOrderid());//�������
					orderpackdetVO.setComcategory(comcategory);//��Ʒ����
					orderpackdetVO.setBatchno(compackVO.getBatchno());//��Ʒ����
					orderpackdetVO.setBoxnum(compackVO.getBoxnum());//����
					orderpackdetBO.doCreate(orderpackdetVO);
					count++;
				}else{//���������������ʱ
					compackVO.setAmount((short) (compackVO.getAmount()-boxAmtY));//������Ʒ����������ԭ����-��ȡ��������
					compackBO.doUpdate(compackVO);
					comressmpDBParam.set_se_batchno(compackVO.getBatchno());//����
					comressmpDBParam.set_se_boxnum(compackVO.getBoxnum());//����
					comressmpDBParam.set_ne_comstate((short)1);//����״̬
					comressmpDBParam.set_pagesize(String.valueOf(boxAmtY));//��ѯ���������ļ�¼
					comressmpDBParam.set_orderby("insideseq");//�������������
					comressmpDBParam.set_desc("0");
					comressmpList=comressmpBO.doQuery(comressmpDBParam).getDatas();
					if(comressmpList==null || comressmpList.size()==0){
						returnMap.put("errorCode","SALE-203001");
						returnMap.put("value", brandName);
						returnMap.put("message", "��Ʒ����Դ������ʵ���׿���Դ������һ�£�");
						return returnMap;
					}
					for(ComressmpVO comressmpVO:comressmpList){
						comVO=comBO.doFindByPk(comressmpVO.getComid());
						comressmpVO.setComstate((short)10);//����Ϊ��ȡ̬
						comressmpBO.doUpdate(comressmpVO);
						orderresdetVO=new OrderresdetVO();
						orderresdetVO.setOrderid(comcate.getOrderid());//�������
						orderresdetVO.setOrdercomtype(comcate.getOrdercomtype());//������Ʒ����
						orderresdetVO.setComcategory(comcategory);//��Ʒ����
						orderresdetVO.setRestype(comcateg.getRestype());//��Դ���
						orderresdetVO.setComid(comressmpVO.getComid());//��Ʒ��ʶ
						orderresdetVO.setComresid(comressmpVO.getComresid());//��Ʒ��Դ���
						orderresdetVO.setBatchno(comressmpVO.getBatchno());//����
						orderresdetVO.setBoxnum(comressmpVO.getBoxnum());//����
						orderresdetVO.setWayid(comressmpVO.getWayid());//����ID
						orderresdetVO.setBrand(comressmpVO.getBrand());//Ʒ��
						orderresdetVO.setComprice(comVO.getComprice()==null?0:comVO.getComprice()*0.01);//��Ʒԭ��
						orderresdetVO.setActprice(comcate.getUnitprice());//ʵ���ۼ�
						this.doCreate(orderresdetVO);
						residList.add(String.valueOf(comressmpVO.getComresid()));//��¼��ԴID����Ʒ��ʶ���ֻ����룩
					}
				}
			}
		}
		if(compackListY!=null && compackListY.size()>0){//������������ʱ��
			for(CompackVO compackVO:compackListY){
				compackVO.setPackstate("10");
				compackVO.setAmount((short)0);
				compackBO.doUpdate(compackVO);
				comressmpDBParam.set_se_batchno(compackVO.getBatchno());//����
				comressmpDBParam.set_se_boxnum(compackVO.getBoxnum());//����
				comressmpDBParam.set_ne_comstate((short)1);
				comressmpDBParam.set_pagesize(String.valueOf(boxAmtY));//��ѯ���������ļ�¼
				comressmpList=comressmpBO.doQuery(comressmpDBParam).getDatas();
				if(comressmpList==null || comressmpList.size()==0 ){
					returnMap.put("errorCode","SALE-203001");
					returnMap.put("value", brandName);
					returnMap.put("message", "��Ʒ����Դ������ʵ���׿���Դ������һ�£�");
					return returnMap;
				}
				for(ComressmpVO comressmpVO:comressmpList){
					comVO=comBO.doFindByPk(comressmpVO.getComid());
					comressmpVO.setComstate((short)10);//����Ϊ��ȡ̬
					comressmpBO.doUpdate(comressmpVO);
					orderresdetVO=new OrderresdetVO();
					orderresdetVO.setOrderid(comcate.getOrderid());//�������
					orderresdetVO.setOrdercomtype(comcate.getOrdercomtype());//������Ʒ����
					orderresdetVO.setComcategory(comcategory);//��Ʒ����
					orderresdetVO.setRestype(comcateg.getRestype());//��Դ���
					orderresdetVO.setComid(comressmpVO.getComid());//��Ʒ��ʶ
					orderresdetVO.setComresid(comressmpVO.getComresid());//��Ʒ��Դ���
					orderresdetVO.setBatchno(comressmpVO.getBatchno());//����
					orderresdetVO.setBoxnum(comressmpVO.getBoxnum());//����
					orderresdetVO.setWayid(comressmpVO.getWayid());//����ID
					orderresdetVO.setBrand(comressmpVO.getBrand());//Ʒ��
					orderresdetVO.setComprice(comVO.getComprice()==null?0:comVO.getComprice()*0.01);//��Ʒԭ��
					orderresdetVO.setActprice(comcate.getUnitprice());//ʵ���ۼ�
					this.doCreate(orderresdetVO);
					residList.add(String.valueOf(comressmpVO.getComresid()));//��¼��ԴID����Ʒ��ʶ���ֻ����룩
				}
				/*//������Ʒ����ϸ--����������Ҫ�Ǽǵ���Ʒ����ϸ
				orderpackdetVO=new OrderpackdetVO();
				orderpackdetVO.setOrderid(orderVO.getOrderid());//�������
				orderpackdetVO.setComcategory(comcategory);//��Ʒ����
				orderpackdetVO.setBatchno(compackVO.getBatchno());//��Ʒ����
				orderpackdetVO.setBoxnum(compackVO.getBoxnum());//����
				orderpackdetBO.doCreate(orderpackdetVO);*/
			}
		}
		//�������ƥ������map��ȡ
		if(totalsum==boxAmtY && boxAmtY>0){
			for(Long key : keySet){
				compackDBParam.set_ne_amount(new Short(key+""));
				boolean flagtemp = (drawMap.get(key)/key == 0);//drawMap��Ҫ��ȡ�������Ƿ�С�ڴ�ɢ���Ĵ�С,true-�ǣ�false-��
				compackDBParam.set_pagesize(flagtemp?"1":String.valueOf(drawMap.get(key)/key));//���Ҫ��ȡ�������Ƿ�С�ڴ�ɢ���Ĵ�С��ȡ1������ȡ���ǵ���
				compackDBParam.setSelectFields(null);
				if(countyid==null && svccode==null && mareacode==null){//���޶��ֹ�˾�ͷ��޶�����Ӫ������\΢������Դ��ѯ��Ʒ��
					compackListZH=compackBO.doQuery(compackDBParam).getDatas();
				}else{//�޶��ֹ�˾��Դ��ѯ��Ʒ��
					compackListZH= compackBO.doQueryCompackResdraw(compackDBParam, countyid,svccode,mareacode).getDatas();
				}
				if(compackListZH!=null && compackListZH.size()>0){//�����ƥ��������ȡ����ʱ��
					for(CompackVO compackVO:compackListZH){
						if(!flagtemp){
							compackVO.setPackstate("10");
						}
						compackVO.setAmount(flagtemp?new Short((key-drawMap.get(key))+""):0);
						compackBO.doUpdate(compackVO);
						comressmpDBParam.set_se_batchno(compackVO.getBatchno());//����
						comressmpDBParam.set_se_boxnum(compackVO.getBoxnum());//����
						comressmpDBParam.set_ne_comstate((short)1);
						comressmpDBParam.set_pagesize(flagtemp?String.valueOf(drawMap.get(key)):String.valueOf(key));//�����ȡ����С��ɢ����С��������ȡ�����ļ�¼�����򣬰�ɢ����С����
						comressmpList=comressmpBO.doQuery(comressmpDBParam).getDatas();
						if(comressmpList==null || comressmpList.size()==0 ){
							returnMap.put("errorCode","SALE-203001");
							returnMap.put("value", brandName);
							returnMap.put("message", "��Ʒ����Դ������ʵ���׿���Դ������һ�£�");
							return returnMap;
						}
						for(ComressmpVO comressmpVO:comressmpList){
							comVO=comBO.doFindByPk(comressmpVO.getComid());
							comressmpVO.setComstate((short)10);//����Ϊ��ȡ̬
							comressmpBO.doUpdate(comressmpVO);
							orderresdetVO=new OrderresdetVO();
							orderresdetVO.setOrderid(comcate.getOrderid());//�������
							orderresdetVO.setOrdercomtype(comcate.getOrdercomtype());//������Ʒ����
							orderresdetVO.setComcategory(comcategory);//��Ʒ����
							orderresdetVO.setRestype(comcateg.getRestype());//��Դ���
							orderresdetVO.setComid(comressmpVO.getComid());//��Ʒ��ʶ
							orderresdetVO.setComresid(comressmpVO.getComresid());//��Ʒ��Դ���
							orderresdetVO.setBatchno(comressmpVO.getBatchno());//����
							orderresdetVO.setBoxnum(comressmpVO.getBoxnum());//����
							orderresdetVO.setWayid(comressmpVO.getWayid());//����ID
							orderresdetVO.setBrand(comressmpVO.getBrand());//Ʒ��
							orderresdetVO.setComprice(comVO.getComprice()==null?0:comVO.getComprice()*0.01);//��Ʒԭ��
							orderresdetVO.setActprice(comcate.getUnitprice());//ʵ���ۼ�
							this.doCreate(orderresdetVO);
							residList.add(String.valueOf(comressmpVO.getComresid()));//��¼��ԴID����Ʒ��ʶ���ֻ����룩
						}
					}
				}
			}
		}
		
		returnMap.put("residList", residList);
		return returnMap;
	}
	public boolean deal(OrderVO order, DBAccessUser user){
		try {
			OrderresdetDBParam orderresdetDBParam=new OrderresdetDBParam();
			orderresdetDBParam.set_se_orderid(order.getOrderid());
			String retMes=this.doResdraw(orderresdetDBParam,true);//��ȡ����
			if("������Դ��ȡ�ɹ���".equals(retMes)){
				return true;
			}else{
				Order orderBO = (Order)BOFactory.build(OrderBO.class,user);
				order.setMemo(retMes);
				orderBO.doUpdate(order);
				return false;
			}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
	/**
	 * ������Դ��ȡ
	 * @param orderresdetDBParam
	 * @return ������Ϣ
	 * @throws Exception
	 */
	public String doResdraw(OrderresdetDBParam orderresdetDBParam,boolean isUpdateOrder) throws Exception {
		Map returnMap=null;
		try {
			Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
			//������Դ�Ƿ����������
			String sysparamvalue21=sysparamBO.doFindByID("21", "pboss_fx");
			if(StringUtils.isEmpty(sysparamvalue21)){
				//throw new Exception( "������Դ�Ƿ���������̲���δ����");
				throw new SaleException("SALE-201001");
			}
			//�Ƿ��޶��ֹ�˾��Դ
			String sysparamvalue38=sysparamBO.doFindByID("38", "pboss_fx");
			if(StringUtils.isEmpty(sysparamvalue38)){
				throw new SaleException("SALE-201008");
			}
			//�����׿�Ʒ�ư���С
			String sysparamvalue5=sysparamBO.doFindByID("5", "pboss_fx");
			if(StringUtils.isEmpty(sysparamvalue5)){
				//throw new Exception(  "�׿�Ʒ�ư���С����δ����");
				throw new SaleException("SALE-201002");
			}
			
			String[] values= StringUtils.splitPreserveAllTokens(sysparamvalue5, "|");
			Map<String,Long> brandMap=new HashMap<String,Long>();
			String[] vals=null;
			for(String val:values){
				if(!"".equals(val)){
					vals=val.split(":");
					if(vals[1] == null || "".equals(vals[1]) || !PublicUtils.isInteger(String.valueOf(vals[1])) || Long.valueOf(vals[1])<=0 ){
						//throw new Exception(  "�׿�Ʒ�ư���С���ô���Ҫ��Ϊ����0������");
						throw new SaleException("SALE-201004");
					}
					brandMap.put(vals[0],Long.valueOf(vals[1]));
				}
			}
			//������Դ��ȡģʽ
			String sysparamvalue24=sysparamBO.doFindByID("24", "pboss_fx");
			if(StringUtils.isEmpty(sysparamvalue24)|| "".equals(sysparamvalue24)){
				sysparamvalue24="SEQUENCE";//����޼�¼��Ĭ��ȡ��SEQUENCE��
			}
			//����ָ���Ŷ�
			String sysparamvalue25=sysparamBO.doFindByID("25", "pboss_fx");
			if((StringUtils.isEmpty(sysparamvalue25)||"".equals(sysparamvalue25)) &&(sysparamvalue24.equals("FIXSECT") || sysparamvalue24.equals("CYCSECT"))){
				throw new SaleException("SALE-201006");
			}
			//��ȡ��Ʒ������Ϣ
			Ordercomcate ordercomcateBO = (Ordercomcate)BOFactory.build(OrdercomcateBO.class,user);
			OrdercomcateDBParam ordercomcateDBParam=new OrdercomcateDBParam();
			ordercomcateDBParam.set_se_orderid(orderresdetDBParam.get_se_orderid());
			DataPackage comdp =ordercomcateBO.doQuery(ordercomcateDBParam);
			Order orderBO = (Order)BOFactory.build(OrderBO.class,user);
			OrderVO orderVO=orderBO.doFindByPk(orderresdetDBParam.get_se_orderid());
			List<OrdercomcateVO> comdpList=comdp.getDatas();//������Ʒ���༯��
			
			ComcategoryrelaDBParam comcategoryrelaDBParam=new ComcategoryrelaDBParam();
			List<ComcategoryrelaVO> comcategList=null;//��Ʒ��Ϲ�ϵ��ѯ����
			Comcategoryrela comcategoryrelaBO= (Comcategoryrela)BOFactory.build(ComcategoryrelaBO.class,user);//��Ʒ��Ϲ�ϵBO
			Orderresdet orderresdetBO=(Orderresdet)BOFactory.build(OrderresdetBO.class,user);//������Դ��ϸBO
			
			List<TiedComInfo> tiedComInfos=null;
			Spproposal spproposalBO= (Spproposal)BOFactory.build(SpproposalBO.class,user);//��������BO
			String message=null;
			for(OrdercomcateVO comcate:comdpList){
				comcategoryrelaDBParam.set_se_comcategory(comcate.getComcategory());
				comcategList=comcategoryrelaBO.doQuery(comcategoryrelaDBParam).getDatas();//��Ʒ����
				if(comcategList.size()==0){
					throw new SaleException("SALE-201008");
				}
				if(comcategList.size()>0){
					ComcategoryrelaVO comcateg=comcategList.get(0);//ȡ��һ����Ʒ����
					//��ֵ��
					if("COMRESCARD".equals(comcateg.getRestype())){
						returnMap=this.doComrescardResdraw(comcate, comcateg,sysparamvalue38,null,orderresdetDBParam.getDrawPara());//��ֵ����ȡ
						if(returnMap.get("message")!=null){//���ش�����Ϣ
							//throw new Exception((String)returnMap.get("message"));
							String value=(String)returnMap.get("value");
							SaleException se = new SaleException((String)returnMap.get("errorCode"),value);
							if(returnMap.get("comcode")!=null){
								if(returnMap.get("memo")!=null && !"".equals(returnMap.get("memo"))){
									if(returnMap.get("ordercomcateVO") != null && 
											!"".equals(returnMap.get("ordercomcateVO"))){
										OrdercomcateVO ordercomcateVO = (OrdercomcateVO)returnMap.get("ordercomcateVO");
										ordercomcateVO.setMemo((String)returnMap.get("memo"));
										se.setRtnObject(ordercomcateVO);
									}
								}
								se.setComcode((String)returnMap.get("comcode"));
							}
							throw se;
							
						}
						List residList=(List)returnMap.get("residList");//������Դ��ϸID����
						
						//��������--����
						tiedComInfos=spproposalBO.doTieInSale(orderVO.getWayid(), comcateg.getComcategory(), residList);
						if(tiedComInfos!=null && tiedComInfos.size()>0){
							message=this.doTiedComResdraw(tiedComInfos, "SYSTIEIN", brandMap, sysparamvalue21, sysparamvalue38,orderVO, comcateg, false);
							/*if(!"".equals(message))
								throw new Exception(message);*/
						}
						//��������--����
						tiedComInfos=spproposalBO.doPresentingB(orderVO.getWayid(), comcateg.getComcategory(), residList);
						if(tiedComInfos!=null && tiedComInfos.size()>0){
							message=this.doTiedComResdraw(tiedComInfos, "SYSGIFT", brandMap, sysparamvalue21, sysparamvalue38,orderVO, comcateg, false);
							/*if(!"".equals(message))
								throw new Exception(message);*/
						}
						
						
					}
					//�׿�
					else if("COMRESSMP".equals(comcateg.getRestype())){
						List residList=null;
						if("SEQUENCE".equals(sysparamvalue24)){//˳���ȡ
							returnMap=this.doComressmpResdraw( brandMap, sysparamvalue21,sysparamvalue38, comcate, comcateg,null,false,false,null);
						}else if("RANDOM".equals(sysparamvalue24)){//�����ȡ
							returnMap=this.doComressmpResdraw( brandMap, sysparamvalue21,sysparamvalue38, comcate, comcateg, null,false,true,null);
						}else if("FIXSECT".equals(sysparamvalue24)){//ָ���Ŷ�
							if(sysparamvalue25.split(",").length>1){
								throw new SaleException("SALE-201007");
							}
							returnMap=this.doComressmpResdraw( brandMap, sysparamvalue21, sysparamvalue38,comcate, comcateg,sysparamvalue25,false,false,null);
						}else if("CYCSECT".equals(sysparamvalue24)){//ѭ���Ŷ�
							String[] cycsectNums=sysparamvalue25.split(",");
							List<String> cycsectNumList=new ArrayList<String>();
							for(String cycsectNum:cycsectNums){
								cycsectNumList.add(cycsectNum);
							}
							Long brandamt=(Long)brandMap.get(comcateg.getBrand());
							long boxAmtZ=comcate.getOrderamt()/brandamt;
							long boxAmtY=comcate.getOrderamt()%brandamt;
							returnMap=this.doCycsectResdraw( brandMap, sysparamvalue21,sysparamvalue38, comcate, comcateg,cycsectNumList,new ArrayList(),boxAmtZ,boxAmtY);//ѭ���Ŷγ�ȡ
						}
						
						if(returnMap!=null){
							if(returnMap.get("message")!=null){//���ش�����Ϣ
								String value=(String)returnMap.get("value");
								SaleException se = new SaleException((String)returnMap.get("errorCode"),value);
								if(returnMap.get("comcode")!=null)
									se.setComcode((String)returnMap.get("comcode"));
								if(returnMap.get("brandName")!=null)
									se.setBrandname((String)returnMap.get("brandName"));
								throw se;
							}
							residList=(List)returnMap.get("residList");//������Դ��ϸID����
						}
						

						//��������--����
						tiedComInfos=spproposalBO.doTieInSale(orderVO.getWayid(), comcateg.getComcategory(), residList);
						if(tiedComInfos!=null && tiedComInfos.size()>0){
							message=this.doTiedComResdraw(tiedComInfos, "SYSTIEIN", brandMap, sysparamvalue21,sysparamvalue38, orderVO, comcateg, false);
							/*if(!"".equals(message))
								throw new Exception(message);*/
						}
						//��������--����
						tiedComInfos=spproposalBO.doPresentingB(orderVO.getWayid(), comcateg.getComcategory(), residList);
						if(tiedComInfos!=null && tiedComInfos.size()>0){
							message=this.doTiedComResdraw(tiedComInfos, "SYSGIFT", brandMap, sysparamvalue21,sysparamvalue38, orderVO, comcateg, false);
							/*if(!"".equals(message))
								throw new Exception(message);*/
						}
					}
					//�հ�SIM��
					else if("EMPTYSIM".equals(comcateg.getRestype())){
						returnMap=this.doEmptysimResdraw(comcate, comcateg,sysparamvalue38,null);//�հ�SIM������ȡ
						if(returnMap.get("message")!=null){//���ش�����Ϣ
							//throw new Exception((String)returnMap.get("message"));
							String value=(String)returnMap.get("value");
							SaleException se = new SaleException((String)returnMap.get("errorCode"),value);
							if(returnMap.get("comcode")!=null){
								se.setComcode((String)returnMap.get("comcode"));
							}
							throw se;
							
						}
					/*	List residList=(List)returnMap.get("residList");//������Դ��ϸID����
						
						//��������--����
						tiedComInfos=spproposalBO.doTieInSale(orderVO.getWayid(), comcateg.getComcategory(), residList);
						if(tiedComInfos!=null && tiedComInfos.size()>0){
							message=this.doTiedComResdraw(tiedComInfos, "SYSTIEIN", brandMap, sysparamvalue21, sysparamvalue38,orderVO, comcateg, false);
							if(!"".equals(message))
								throw new Exception(message);
						}
						//��������--����
						tiedComInfos=spproposalBO.doPresentingB(orderVO.getWayid(), comcateg.getComcategory(), residList);
						if(tiedComInfos!=null && tiedComInfos.size()>0){
							message=this.doTiedComResdraw(tiedComInfos, "SYSGIFT", brandMap, sysparamvalue21, sysparamvalue38,orderVO, comcateg, false);
							if(!"".equals(message))
								throw new Exception(message);
						}*/
						
						
					}
				}
			}
			
			if(isUpdateOrder){
				comdp = ordercomcateBO.doQuery(ordercomcateDBParam);
				comdpList = comdp.getDatas();// ������Ʒ���༯��
				Double sumTotalprice = 0d;
				for (OrdercomcateVO comcate : comdpList) {
					sumTotalprice += comcate.getTotalprice();// ���ܶ�����Ʒ������ܼ�
				}
				orderVO.setRecamt(sumTotalprice);//����Ӧ�ս��
				orderVO.setOrderstate("EXTRAED");//����״̬Ϊ�ѳ�ȡ
				orderVO.setStatechgtime(new Date());//���ʱ��Ϊ��ǰʱ��
				orderBO.doUpdate(orderVO);
				/*
				 * �������ݵ�������Դ���͵���FX_SW_DISFORM��
				 
				Disform disformBO = (DisformBO)BOFactory.build(DisformBO.class,user);
				DisformVO disformVO = new DisformVO();
				disformVO.setOrderid(orderVO.getOrderid());//�������
				disformVO.setRecewayid(orderVO.getWayid());//�ջ�����ȡ�����̱���
				Way wayBO = (WayBO)BOFactory.build(WayBO.class,user);
				WayVO wayVO = wayBO.doFindByPk(orderVO.getWayid());
				disformVO.setDiscomcode(wayVO.getLogiscode() == null ?" ":wayVO.getLogiscode());
				//���ݺ����̱����ѯ�������������ϱ�
				Cooperator cooperatorBO = (Cooperator)BOFactory.build(CooperatorBO.class,user);
				CooperatorVO cooperatorVO=cooperatorBO.doFindByPk(orderVO.getWayid());
				
				if(cooperatorVO!=null){
					disformVO.setReceadd(cooperatorVO.getSendaddr()==null?" ":cooperatorVO.getSendaddr());//��ȡ�ջ��˵�ַ�����ͻ���ַ��
					disformVO.setRecename(cooperatorVO.getRecpers()==null?" ":cooperatorVO.getRecpers());//�ջ������������ջ���ϵ��
					disformVO.setRecetel(cooperatorVO.getRecconntel()==null?" ":cooperatorVO.getRecconntel());//�ջ��˵绰�����ջ���ϵ���룩
				}else{
					disformVO.setReceadd(" ");//����
					disformVO.setRecename(" ");//����
					disformVO.setRecetel(" ");//����
				}
				//����ʱ��ȡ��ǰʱ�䣬Ҫ���ʹ�ʱ��ȡ��ǰʱ���48Сʱ�����͵�״̬ȡ����������ע�������˺ͷ���ʱ������
				Calendar calenDar = Calendar.getInstance();
				disformVO.setCreatetime(calenDar.getTime());
				calenDar.add(Calendar.HOUR, 48);
				disformVO.setArrivetime(calenDar.getTime());
				disformVO.setDisstate("WAITOUT");//���͵�״̬ȡ������
				disformBO.doCreate(disformVO);*/
			}
			return "������Դ��ȡ�ɹ���";
		} catch (SaleException ex) {
			/*if(returnMap != null && returnMap.get("comcode")!=null
					&& returnMap.get("memo")!=null && !"".equals(returnMap.get("memo"))){
				OrdercomcateVO ordercomcateVO = (OrdercomcateVO)returnMap.get("ordercomcateVO");
				if(ordercomcateVO != null && !"".equals(ordercomcateVO)){
					
				}
			}*/
			throw ex;
		}catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}
	

	/**
	 * �������/���͵ĳ�ȡ����
	 * ��������ƥ�䣺��Ʒ��Դ��ȡ��ɺ󣬵��ô�������������/���ͣ��ӿڷ�����
	 * ����/������Դ��ȡ��������ڴ���/������Դ������Ҫ�ٴν��г�ȡ����ȡ�߼��ο�����ĳ�ֵ������Ʒ����ȡ�߼���
	 * ͬʱ�������ݵ�������Ʒ�����FX_SW_ORDERCOMCATE���Ͷ������ô���������FX_SW_ORDERPLAN����
	 * @param brandMap Ʒ��MAP
	 * @param sysparamvalue21 ���������̲���
	 * @param comcateg ��Ʒ�����ϵ
	 * @param comcate ������Ʒ����
	 * @param nosect �����ŶΣ�ָ���Ŷκ�ѭ���Ŷβ��У�����ΪNULL��
	 * @param isCycsect �Ƿ�ѭ���Ŷβ�ѯ
	 * @param paramMap ����MAP��
	 * @throws Exception
	 */
	public  String doTiedComResdraw(List<TiedComInfo> tiedComInfos,String ordercomtype,Map brandMap,String sysparamvalue21,String sysparamvalue38,OrderVO orderVo,ComcategoryrelaVO comcateg, boolean isbatchResdraw) throws Exception{
		try {
			Map<String,Long> tiedComMap=disposalTiedComInfo(orderVo.getOrderid(),tiedComInfos);
			Map<String,Object> paramMap=new HashMap<String,Object>();
			Set<String> keySet=tiedComMap.keySet();
			Map returnMap=null;
			OrdercomcateVO ordercomcateVO=null;
			Ordercomcate ordercomcateBO = (Ordercomcate)BOFactory.build(OrdercomcateBO.class,user);
			Comorder comorderBO = (Comorder)BOFactory.build(ComorderBO.class,user);
			ComcategoryrelaDBParam comcategoryrelaDBParam=new ComcategoryrelaDBParam();
			List<ComcategoryrelaVO> comcategList=null;//��Ʒ��Ϲ�ϵ��ѯ����
			Comcategoryrela comcategoryrelaBO= (Comcategoryrela)BOFactory.build(ComcategoryrelaBO.class,user);//��Ʒ��Ϲ�ϵBO
			for(String key:keySet){
				//�������ݵ�������Ʒ�����
				ordercomcateVO=new OrdercomcateVO();
				ordercomcateVO.setOrderid(orderVo.getOrderid());
				ordercomcateVO.setComcategory(key);
				ordercomcateVO.setOrdercomtype(ordercomtype);
				ordercomcateVO.setOrderamt(tiedComMap.get(key));
				ordercomcateVO.setUnitprice(comorderBO.doGetUnitprice(orderVo.getWayid(), key));
				String mestype="����";
				if(!"SYSGIFT".equals(ordercomtype)){
					ordercomcateVO.setTotalprice(ordercomcateVO.getUnitprice()*tiedComMap.get(key));
				}else{
					ordercomcateVO.setTotalprice(0d);
					mestype="����";
				}
				ordercomcateBO.doCreate(ordercomcateVO);
				
				paramMap.put("comcategory", key);
				paramMap.put("orderamt",tiedComMap.get(key));
				comcategoryrelaDBParam.set_se_comcategory(ordercomcateVO.getComcategory());
				comcategList=comcategoryrelaBO.doQuery(comcategoryrelaDBParam).getDatas();//��Ʒ����
				if(comcategList.size()>0){
					ComcategoryrelaVO tiedComInfoComcateg=comcategList.get(0);//ȡ��һ����Ʒ����
					if("COMRESCARD".equals(tiedComInfoComcateg.getRestype())){
						returnMap=this.doComrescardResdraw(ordercomcateVO, tiedComInfoComcateg,sysparamvalue38,paramMap,null);
					}else if("COMRESSMP".equals(tiedComInfoComcateg.getRestype())){
						returnMap=this.doComressmpResdraw(brandMap, sysparamvalue21,sysparamvalue38, ordercomcateVO, tiedComInfoComcateg,  null, false,false, paramMap);
					}
					
					if(returnMap.get("message")!=null){//���ش�����Ϣ
						if(isbatchResdraw){//��������ȡ��ʱ��
							return mestype+(String)returnMap.get("message");
						}
						//������ȡʱ
						String value=(String)returnMap.get("value");
						String errorCode=(String)returnMap.get("errorCode");
						SaleException se =null;
						if("����".equals(mestype)){
							if("SALE-202001".equals(errorCode)){
								se= new SaleException("SALE-202002",value);
							}else{
								se= new SaleException("SALE-202005",value);
							}
						}else{
							if("SALE-202001".equals(errorCode)){
								se= new SaleException("SALE-202003",value);
							}else{
								se= new SaleException("SALE-202006",value);
							}
						}
						if(returnMap.get("comcode")!=null)
							se.setComcode((String)returnMap.get("comcode"));
						if(returnMap.get("brandName")!=null)
							se.setBrandname((String)returnMap.get("brandName"));
						throw se;
					}
				}
				
			}
		} catch (SaleException ex) {
			throw ex;
		}catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
		return "";
	}

	/**
	 * �������/������Դ����Ʒ��������Ʒ����������
	 * @param tiedComInfos
	 * @returns
	 */
	private Map<String,Long> disposalTiedComInfo(String orderid,List<TiedComInfo> tiedComInfos)throws Exception{
		Orderplan orderplanBO = (Orderplan)BOFactory.build(OrderplanBO.class,user);
		OrderplanVO orderplanVO=null;
		Map<String,Long> map=new HashMap<String,Long>();
		for(TiedComInfo tiedComInfo:tiedComInfos){
			if(map.containsKey(tiedComInfo.getTComCategory())){
				map.put(tiedComInfo.getTComCategory(), map.get(tiedComInfo.getTComCategory())+tiedComInfo.getTQuantity());
			}else{
				map.put(tiedComInfo.getTComCategory(),Long.valueOf(tiedComInfo.getTQuantity()));
			}
			//�������ô���������FX_SW_ORDERPLAN��
			orderplanVO=new OrderplanVO();
			orderplanVO.setOrderid(orderid);
			orderplanVO.setRuleid(tiedComInfo.getRuleid());
			orderplanVO.setSaleplan(tiedComInfo.getPid());
			orderplanBO.doCreate(orderplanVO);
		}
		return map;
	}
	/**
	 * ������Դ������ȡ
	 * @param parameterMap ������ȡ����
	 * @param orderid  ������
	 * @return ������Ϣ
	 * @throws Exception
	 */
	public String doBatchResdraw(Map parameterMap,String orderid) throws Exception {
		
		/*
		Session session = SessionUtils.currentSession(user.getCityid());
		// ��ȡ��ǰflush ģʽ
		FlushMode preMode = session.getFlushMode();
		
		// ���ڴ��������п��ܶ�ͬһ����(��־û�����)���С����º��ٲ�ѯ�����������־û�����ı��
		// Hibernate���ö����־Ϊ������(�������ݿⲻͬ����),��flushģʽΪĬ�ϵ�AUTOʱ��
		// Hibernate�ڽ��в�ѯ֮ǰ���жϻ����еĳ־û������Ƿ������ݣ�����ͬ��(flush)�����ݿ⣬����
		// ��ͬ�����ݿ⡣
		// ��ͬ�������ݿ⣬���ѯ�������������û��ʵ���ύ�������ݡ�
		
		// ����ǰsession��flushģʽ��AUTO���ó�MANUAL����ֹHibernate�Զ�ͬ�����ݿ⣬��Ϊ�ֹ�flush
		session.setFlushMode(FlushMode.MANUAL);
		*/
		/**
		 * ��ҵ���Ƿ��������������Ҫ�����������������˲��ڴ������޶�session���Զ�flush.
		 */
		try {
			Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
			//������Դ�Ƿ����������
			String sysparamvalue21=sysparamBO.doFindByID("21", "pboss_fx");
			if(StringUtils.isEmpty(sysparamvalue21)){
				throw new Exception(orderid+"|������Դ�Ƿ���������̲���δ����|");
			}
			//�Ƿ��޶��ֹ�˾��Դ
			String sysparamvalue38=sysparamBO.doFindByID("38", "pboss_fx");
			if(StringUtils.isEmpty(sysparamvalue38)){
				throw new Exception(orderid+"|�Ƿ��޶��ֹ�˾��Դ����δ����|");
			}
			//�����׿�Ʒ�ư���С
			String sysparamvalue5=sysparamBO.doFindByID("5", "pboss_fx");
			if(StringUtils.isEmpty(sysparamvalue5)){
				throw new Exception(orderid+"|�׿�Ʒ�ư���С����δ����|");
			}
			String[] values= StringUtils.splitPreserveAllTokens(sysparamvalue5, "|");
			Map<String,Long> brandMap=new HashMap<String,Long>();
			String[] vals=null;
			for(String val:values){
				if(!"".equals(val)){
					vals=val.split(":");
					if(vals[1] == null || "".equals(vals[1]) || !PublicUtils.isInteger(String.valueOf(vals[1])) || Long.valueOf(vals[1])<=0 ){
						throw new Exception(  "�׿�Ʒ�ư���С���ô���Ҫ��Ϊ����0������");
					}
					brandMap.put(vals[0],Long.valueOf(vals[1]));
				}
			}
			
			Order orderBO = (Order)BOFactory.build(OrderBO.class,user);
			OrderVO orderVO=orderBO.doFindByPk(orderid);
			if(orderVO==null){
				throw new Exception(orderid+"|����������|");
			}
			Orderproce orderproceBO = (Orderproce)BOFactory.build(OrderproceBO.class,user);
			OrderproceDBParam orderproceDBParam=new OrderproceDBParam();
			orderproceDBParam.set_ne_flowid(String.valueOf(orderVO.getFlowid()));
			orderproceDBParam.set_se_outstate("EXTRAED");//�ѳ�ȡ
			DataPackage data=orderproceBO.doQuery(orderproceDBParam);
			List<OrderproceVO> list=data.getDatas();
			String instate="";
			for(OrderproceVO obj:list){
				instate=obj.getInstate();
				break;
			}
			if(!instate.equals(orderVO.getOrderstate())){
				throw new Exception(orderid+"|����״̬����ȷ|");
			}
			
			//��ȡ��Ʒ������Ϣ
			Ordercomcate ordercomcateBO = (Ordercomcate)BOFactory.build(OrdercomcateBO.class,user);
			OrdercomcateDBParam ordercomcateDBParam=new OrdercomcateDBParam();
			OrderresdetDBParam orderresdetDBParam=new OrderresdetDBParam();
			orderresdetDBParam.set_se_orderid(orderid);
			ordercomcateDBParam.set_se_orderid(orderresdetDBParam.get_se_orderid());
			DataPackage comdp =ordercomcateBO.doQuery(ordercomcateDBParam);
			List<OrdercomcateVO> comdpList=comdp.getDatas();
			
			ComcategoryrelaDBParam comcategoryrelaDBParam=new ComcategoryrelaDBParam();
			List<ComcategoryrelaVO> comcategList=null;//��Ʒ��Ϲ�ϵ��ѯ����
			Comcategoryrela comcategoryrelaBO= (Comcategoryrela)BOFactory.build(ComcategoryrelaBO.class,user);//��Ʒ��Ϲ�ϵBO
			Orderresdet orderresdetBO=(Orderresdet)BOFactory.build(OrderresdetBO.class,user);//������Դ��ϸBO
			Map returnMap=null;
			List<TiedComInfo> tiedComInfos=null;
			Spproposal spproposalBO= (Spproposal)BOFactory.build(SpproposalBO.class,user);//��������BO
			String message=null;
			for(OrdercomcateVO comcate:comdpList){
				comcategoryrelaDBParam.set_se_comcategory(comcate.getComcategory());
				comcategList=comcategoryrelaBO.doQuery(comcategoryrelaDBParam).getDatas();//��Ʒ����
				if(comcategList.size()>0){
					ComcategoryrelaVO comcateg=comcategList.get(0);//ȡ��һ����Ʒ����
					//��ֵ��
					if("COMRESCARD".equals(comcateg.getRestype())){
						returnMap=this.doComrescardResdraw(comcate, comcateg,sysparamvalue38, null,null);//��ֵ����ȡ
						if(returnMap.get("message")!=null){//���ش�����Ϣ
							throw new Exception(orderid+"|"+(String)returnMap.get("message")+"|");
						}
						List residList=(List)returnMap.get("residList");//������Դ��ϸID����
						//��������--����
						tiedComInfos=spproposalBO.doTieInSale(orderVO.getWayid(), comcateg.getComcategory(), residList);
						if(tiedComInfos!=null && tiedComInfos.size()>0){
							message=this.doTiedComResdraw(tiedComInfos, "SYSTIEIN", brandMap, sysparamvalue21,sysparamvalue38, orderVO, comcateg, true);
							if(!"".equals(message))
								throw new Exception(orderid+"|"+message+"|");
						}
						//��������--����
						tiedComInfos=spproposalBO.doPresentingB(orderVO.getWayid(), comcateg.getComcategory(), residList);
						if(tiedComInfos!=null && tiedComInfos.size()>0){
							message=this.doTiedComResdraw(tiedComInfos, "SYSGIFT", brandMap, sysparamvalue21,sysparamvalue38, orderVO, comcateg, true);
							if(!"".equals(message))
								throw new Exception(orderid+"|"+message+"|");
						}
					}
					//�׿�
					else if("COMRESSMP".equals(comcateg.getRestype())){
						returnMap=null;
						List residList=null;
						if("SEQUENCE".equals(parameterMap.get("resextratype"))){//˳���ȡ
							returnMap=this.doComressmpResdraw( brandMap, sysparamvalue21,sysparamvalue38, comcate, comcateg,null,false,false,null);
						}else if("RANDOM".equals(parameterMap.get("resextratype"))){//�����ȡ
							returnMap=this.doComressmpResdraw( brandMap, sysparamvalue21,sysparamvalue38, comcate, comcateg, null,false,true,null);
						}else if("FIXSECT".equals(parameterMap.get("resextratype"))){//ָ���Ŷ�
							if(((String) parameterMap.get("fixsectNum")).split(",").length>1){
								throw new Exception(orderid+"|����[��Դ��ȡָ���Ŷ�]���ô�������ϵ����Ա|");
							}
							returnMap=this.doComressmpResdraw( brandMap, sysparamvalue21, sysparamvalue38,comcate, comcateg,(String) parameterMap.get("fixsectNum"),false,false,null);
						}else if("CYCSECT".equals(parameterMap.get("resextratype"))){//ѭ���Ŷ�
							String[] cycsectNums=((String) parameterMap.get("cycsectNum")).split(",");
							List<String> cycsectNumList=new ArrayList<String>();
							for(String cycsectNum:cycsectNums){
								cycsectNumList.add(cycsectNum);
							}
							Long brandamt=(Long)brandMap.get(comcateg.getBrand());
							long boxAmtZ=comcate.getOrderamt()/brandamt;
							long boxAmtY=comcate.getOrderamt()%brandamt;
							returnMap=this.doCycsectResdraw( brandMap, sysparamvalue21,sysparamvalue38, comcate, comcateg,cycsectNumList,new ArrayList(),boxAmtZ,boxAmtY);//ѭ���Ŷγ�ȡ
						}
						
						if(returnMap!=null){
							if(returnMap.get("message")!=null){//���ش�����Ϣ
								throw new Exception(orderid+"|"+(String)returnMap.get("message")+"|");
							}
							residList=(List)returnMap.get("residList");//������Դ��ϸID����
						}
						
						//��������--����
						tiedComInfos=spproposalBO.doTieInSale(orderVO.getWayid(), comcateg.getComcategory(), residList);
						if(tiedComInfos!=null && tiedComInfos.size()>0){
							message=this.doTiedComResdraw(tiedComInfos, "SYSTIEIN", brandMap, sysparamvalue21,sysparamvalue38, orderVO, comcateg, true);
							if(!"".equals(message))
								throw new Exception(orderid+"|"+message+"|");
						}
						//��������--����
						tiedComInfos=spproposalBO.doPresentingB(orderVO.getWayid(), comcateg.getComcategory(), residList);
						if(tiedComInfos!=null && tiedComInfos.size()>0){
							message=this.doTiedComResdraw(tiedComInfos, "SYSGIFT", brandMap, sysparamvalue21, sysparamvalue38,orderVO, comcateg, true);
							if(!"".equals(message))
								throw new Exception(orderid+"|"+message+"|");
						}
						
					}
					//�հ�SIM��
					else if("EMPTYSIM".equals(comcateg.getRestype())){
						returnMap=this.doEmptysimResdraw(comcate, comcateg,sysparamvalue38,null);//�հ�SIM������ȡ
						if(returnMap.get("message")!=null){//���ش�����Ϣ
							throw new Exception(orderid+"|"+(String)returnMap.get("message")+"|");
						}
					}
					
				}
			}
			
			comdp = ordercomcateBO.doQuery(ordercomcateDBParam);
			comdpList = comdp.getDatas();// ������Ʒ���༯��
			Double sumTotalprice = 0d;
			for (OrdercomcateVO comcate : comdpList) {
				sumTotalprice += comcate.getTotalprice();// ���ܶ�����Ʒ������ܼ�
			}
			orderVO.setRecamt(sumTotalprice);//����Ӧ�ս��
			orderVO.setOrderstate("EXTRAED");//����״̬Ϊ�ѳ�ȡ
			orderVO.setStatechgtime(new Date());//���ʱ��Ϊ��ǰʱ��
			orderBO.doUpdate(orderVO);
			
			/*
			 * �������ݵ�������Դ���͵���FX_SW_DISFORM��
			 
			Disform disformBO = (DisformBO)BOFactory.build(DisformBO.class,user);
			DisformVO disformVO = new DisformVO();
			disformVO.setOrderid(orderVO.getOrderid());//�������
			disformVO.setRecewayid(orderVO.getWayid());//�ջ�����ȡ�����̱���
			Way wayBO = (WayBO)BOFactory.build(WayBO.class,user);
			WayVO wayVO = wayBO.doFindByPk(orderVO.getWayid());
			disformVO.setDiscomcode(wayVO.getLogiscode() == null ?" ":wayVO.getLogiscode());
			//���ݺ����̱����ѯ�������������ϱ�
			Cooperator cooperatorBO = (Cooperator)BOFactory.build(CooperatorBO.class,user);
			CooperatorVO cooperatorVO=cooperatorBO.doFindByPk(orderVO.getWayid());
			
			if(cooperatorVO!=null){
				disformVO.setReceadd(cooperatorVO.getSendaddr()==null?" ":cooperatorVO.getSendaddr());//��ȡ�ջ��˵�ַ�����ͻ���ַ��
				disformVO.setRecename(cooperatorVO.getRecpers()==null?" ":cooperatorVO.getRecpers());//�ջ������������ջ���ϵ��
				disformVO.setRecetel(cooperatorVO.getRecconntel()==null?" ":cooperatorVO.getRecconntel());//�ջ��˵绰�����ջ���ϵ���룩
			}else{
				disformVO.setReceadd(" ");//����
				disformVO.setRecename(" ");//����
				disformVO.setRecetel(" ");//����
			}
			//����ʱ��ȡ��ǰʱ�䣬Ҫ���ʹ�ʱ��ȡ��ǰʱ���48Сʱ�����͵�״̬ȡ����������ע�������˺ͷ���ʱ������
			Calendar calenDar = Calendar.getInstance();
			disformVO.setCreatetime(calenDar.getTime());
			calenDar.add(Calendar.HOUR, 48);
			disformVO.setArrivetime(calenDar.getTime());
			disformVO.setDisstate("WAITOUT");//���͵�״̬ȡ������
			disformBO.doCreate(disformVO);*/
			
			return "������Դ��ȡ�ɹ�";
		} catch (SaleException ex) {
			throw ex;
		}catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
		
	}
	/**
	 * ѭ���Ŷγ�ȡ����
	 * @param brandMap Ʒ��MAP
	 * @param sysparamvalue21 ���������̲���
	 * @param comcate ������Ʒ����
	 * @param comcateg ��Ʒ�����ϵ
	 * @param cycsectNumList ѭ���Ŷ�LIST
	 * @param residList �ɹ���Դ��LIST
	 * @param boxAmtZ  ��������
	 * @param boxAmtY  �������
	 * @return
	 */
	public Map doCycsectResdraw(Map brandMap,String sysparamvalue21,String sysparamvalue38,OrdercomcateVO comcate,ComcategoryrelaVO comcateg,List<String> cycsectNumList,List residList,long boxAmtZ,long boxAmtY){
		try {
			Map map=null;
			Map<String,Object> paramMap=null;
			List<String> list=new ArrayList<String>();
			list.addAll(cycsectNumList);
			for(String cycsectNum:cycsectNumList){
				if(boxAmtZ==0){
					if(boxAmtY>0){
						paramMap=new HashMap<String,Object>();
						paramMap.put("boxAmtY", boxAmtY);
					}else{
						break;//��������ȡ��ʱ���������ѭ��
					}
				}
				map=this.doComressmpResdraw( brandMap, sysparamvalue21, sysparamvalue38, comcate, comcateg,cycsectNum,true,false,paramMap);
				if(map.get("message")!=null){//���ش�����Ϣ
					list.remove(cycsectNum);
					if(list.size()==0){
						return map;
						//throw new Exception(comcate.getOrderid()+"|"+(String)map.get("message")+"|");
					}
				}else{
					if(boxAmtZ>0)
						boxAmtZ--;
					else
						boxAmtY=0;//����������0
					residList.addAll((List)map.get("residList"));//��ѭ���ļ��Ͻ��з�װ
				}
			}
			if(boxAmtZ==0 && boxAmtY==0){
				map.put("residList", residList);
				return map;
			}else{
				return this.doCycsectResdraw(brandMap, sysparamvalue21,sysparamvalue38, comcate, comcateg, list, residList,boxAmtZ,boxAmtY);
			}
		} catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}
	
	/**
	 * ���ƥ����������
	 * @param comcategory ��Ʒ����
	 * @param boxAmtY ����
	 * @param brandamt Ʒ�ư���С
	 * @param compackDBParam  ��ѯ����
	 * @return
	 */
	private Map getResdrawMapByCombinMatchRemainder(String comcategory,long boxAmtY,Long brandamt,CompackDBParam compackDBParam,String countyid,String svccode,String mareacode) throws Exception{
		Map<Long,Long> sanMap = new HashMap<Long,Long>();//ɢ��
		
		CompackDAO dao = (CompackDAO) DAOFactory.build(CompackDAO.class,user);
		//CompackDBParam param = new CompackDBParam();
		compackDBParam.setQueryAll(true);
		compackDBParam.setDataOnly(true);
		Map<String,String> conditionMap = new HashMap<String,String>();
		conditionMap.put("BRANDAMT", String.valueOf(brandamt));
		compackDBParam.setQueryConditions(conditionMap);
		compackDBParam.setSelectFieldsString("AMOUNT,NUM");
		DataPackage dp = dao.querySanMapByCount(compackDBParam,brandamt,countyid,svccode,mareacode);
		if( null != dp && dp.getDatas().size()>0 ){
			String amount = null;
			String num = null;
			for(Map<String,String> map:(List<Map<String,String>>) dp.getDatas()){
				amount =map.get("AMOUNT");
				num = map.get("NUM");
				sanMap.put(new Long(amount), new Long(num)*new Long(amount));
			}
		}
		
		Map<Long,Long> drawMap = new HashMap<Long,Long>();//���Ҫ���صĳ�ȡ��
		Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
		String unitagetemp = comorder.doGetUnitage(user.getCityid(), comcategory);//��������
		Short unitage = new Short(unitagetemp);//��������
		
		for(int i=1;i<=(boxAmtY/unitage);i++){
			for(int j=1;j<=(brandamt/unitage-1);j++){
				if(sanMap.containsKey(Long.parseLong(unitage*j+""))){
					long n=sanMap.get(Long.parseLong(unitage*j+"")).longValue();
					if(n-unitage.longValue()==0){
						sanMap.remove(Long.parseLong(unitage*j+""));
					}else{
						sanMap.put(new Long(unitage*j), (Long)(n-unitage));
					}
					if(drawMap.containsKey(Long.parseLong(unitage*j+""))){
						long n2 = drawMap.get(Long.parseLong(unitage*j+"")).longValue();
						drawMap.put(new Long(unitage*j), (Long)(n2+unitage));
					}else{
						drawMap.put(new Long(unitage*j), (Long)(unitage.longValue()));
					}
					break;
				}else{
					continue;
				}
			}
		}
		return drawMap;
	}

	public DataPackage doQueryExp(OrderresdetDBParam params) throws Exception {
		OrderresdetDAO dao = (OrderresdetDAO) DAOFactory.build(OrderresdetDAO.class,user);
		params.setSelectFieldsString("orderid, wayid, detid, comid, comcategory, batchno, boxnum, comresid");
		return dao.queryByNamedSqlQuery("sales.orderresdet.resdetbatchexport", params);
	}
	
}
