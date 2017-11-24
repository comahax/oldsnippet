 /**
 * auto-generated code
 * Wed Oct 14 17:29:02 CST 2009
 */
package com.gmcc.pboss.control.sales.disform;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.com.ComDBParam;
import com.gmcc.pboss.business.resource.com.ComVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.business.sales.comprice.CompriceDBParam;
import com.gmcc.pboss.business.sales.comprice.CompriceVO;
import com.gmcc.pboss.business.sales.disform.DisformDAO;
import com.gmcc.pboss.business.sales.disform.DisformDBParam;
import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.business.sales.disform.GDisformDAO;
import com.gmcc.pboss.business.sales.disform.GDisformVO;
import com.gmcc.pboss.business.sales.disform.PDisformDAO;
import com.gmcc.pboss.business.sales.disform.PDisformVO;
import com.gmcc.pboss.business.sales.disform.SDisformDAO;
import com.gmcc.pboss.business.sales.disform.VDisformDAO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetVO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.com.ComBO;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.control.sales.comprice.CompriceBO;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderresdet.OrderresdetBO;
import com.gmcc.pboss.control.sales.smsconfirm.Smsconfirm;
import com.gmcc.pboss.control.sales.smsconfirm.SmsconfirmBO;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: DisformBO
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/jop/business/sales/disform/control/DisformBO"
 *           name="Disform" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class DisformBO extends AbstractControlBean implements Disform {
	public static final String DISFORM_SIGNED = "SIGNED";

	public DisformVO doCreate(DisformVO vo) throws Exception {
		try {
			DisformDAO dao = (DisformDAO) DAOFactory.build(DisformDAO.class,
					user);
			// TODO set the pk */
			return (DisformVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(DisformVO vo) throws Exception {
		try {
			DisformDAO dao = (DisformDAO) DAOFactory.build(DisformDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			DisformDAO dao = (DisformDAO) DAOFactory.build(DisformDAO.class,
					user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DisformVO doUpdate(DisformVO vo) throws Exception {
		try {
			DisformDAO dao = (DisformDAO) DAOFactory.build(DisformDAO.class,
					user);
			return (DisformVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	/**
	 * �������͵��Ͷ���״̬���������ݵ����Ŵ����ͱ�
	 */
	public void doUpdateOrder(DisformVO vo) throws Exception {
		try {
			DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class, user);
			OrderBO orderbo = (OrderBO) BOFactory.build(OrderBO.class, user);
			Smstmpl smsBO = (Smstmpl) BOFactory.build(SmstmplBO.class, user);
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			OrderVO ordervo = orderbo.doFindByPk(vo.getOrderid());
			if (ordervo != null) {
				ordervo.setSignstate("WAITSIGN");
				// ���¶���״̬
				orderbo.doUpdate(ordervo);
				// �������͵�״̬
				dfbo.doUpdate(vo);
			} else {
				throw new JOPException(" ������Ϣ������! ");
			}
			// ���Ÿ���汾 TODO
			EmployeeBO employbo = (EmployeeBO) BOFactory.build(
					EmployeeBO.class, user);
			EmployeeDBParam employparam = new EmployeeDBParam();
			employparam.set_se_wayid(ordervo.getWayid());
			// ����
			employparam.set_ne_isnet("1");
			// �ڸ�
			employparam.set_ne_empstatus("0");

			DataPackage emdp = employbo.doQuery(employparam);
			if (emdp != null && emdp.getDatas().size() > 0) {
				EmployeeVO empvo = (EmployeeVO) emdp.getDatas().get(0);
				String mobile = empvo.getOfficetel();
				// �����Ա���������ݻ�Ϊ�գ���Ĭ��ȡ���ͻ���
				if ("".equals(empvo.getEmployeename())
						|| null == empvo.getEmployeename()) {
					empvo.setEmployeename("�ͻ�");
				}
				// 8λ������yyyyMMdd
				String date = format.format(new Date());
				String year = date.substring(0, 4);
				String month = date.substring(4, 6);
				String day = date.substring(6, 8);
				// �ֹ�˾ȡ�Զ�����Ҫ��������ķ���
				String countryid = Code2NameUtils.code2Name("#CNTYCOMPANY",
						ordervo.getCountyid(), user.getCityid());
				//��������Ϣ����ȡ�������ţ������������Ϊ�� 
				String logisticsinfo = vo.getLogisticsno(); 
				if (null == logisticsinfo || ("").equals(logisticsinfo)) {
					logisticsinfo = " ";
				}
				String sId = "FX_ORDER_PARSIGNREM";
				Map<String, String> keyAndValue = new HashMap<String, String>();
				keyAndValue.put("CUSTNAME", empvo.getEmployeename());
				keyAndValue.put("YEAR", year);
				keyAndValue.put("MONTH", month);
				keyAndValue.put("DAY", day);
				keyAndValue.put("COUNTYID", countryid); 
				keyAndValue.put("LOGISTICSINFO", logisticsinfo);
				  
				// ���ɶ�������
				String content = smsBO.doGenSMS(sId, keyAndValue);
				if (!"".equals(mobile) && !"".equals(content)) {
					Waitreq waitreq = (Waitreq) BOFactory.build(
							WaitreqBO.class, user);
					waitreq.doInsert(Waitreq.SMS_FX, content, mobile);
				}
			}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DisformVO doFindByPk(Serializable pk) throws Exception {
		DisformDAO dao = (DisformDAO) DAOFactory.build(DisformDAO.class, user);
		return (DisformVO) dao.findByPk(pk);
	}

	/**
	 * ��ѯ���͵��б�����
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQuery(DisformDBParam params) throws Exception {
		DisformDAO dao = (DisformDAO) DAOFactory.build(DisformDAO.class, user);
		return dao.query(params);
	}

	/**
	 * ���͵��б��ѯ
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQuerydp(DisformDBParam params) throws Exception {
		VDisformDAO dao = (VDisformDAO) DAOFactory.build(VDisformDAO.class,
				user);
		return dao.doDisformList(params);
	}

	/**
	 * ��ѯ��ӡ���͵���Ϣ�����
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryPrint(DisformDBParam params) throws Exception {
		PDisformDAO dao = (PDisformDAO) DAOFactory.build(PDisformDAO.class,
				user);
		return dao.doDisformPrint(params);
	}

	public DataPackage doGatherPrintDp(DisformDBParam params) throws Exception {
		GDisformDAO dao = (GDisformDAO) DAOFactory.build(GDisformDAO.class,
				user);
		return dao.doGatherPrintDp(params);
	}

	/**
	 * ��ѯ��ӡ���͵��б�����
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryPrintDp(DisformDBParam params) throws Exception {
		PDisformDAO dao = (PDisformDAO) DAOFactory.build(PDisformDAO.class,
				user);
		return dao.doDisformPrintDp(params);
	}

	/**
	 * ��Ʒ��Ų�ѯ�����-"����-����(����)"
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doBatchnoBoxnumDp(OrderresdetDBParam params)
			throws Exception {
		PDisformDAO dao = (PDisformDAO) DAOFactory.build(PDisformDAO.class,
				user);
//		ComressmpDBParam smpparams = new ComressmpDBParam();
//		PDisformVO vo = new PDisformVO();
//		DataPackage dp = dao.doBatchnoBoxnumDp(params);
//		if(dp!=null||dp.getDatas().size()>0){
//			for(int i=0;i<dp.getDatas().size();i++){
//				vo = (PDisformVO) dp.getDatas().get(0);
//				smpparams.set_se_batchno(vo.getBatchno());
//				smpparams.set_se_boxnum(vo.getBoxnum());
//			}
//		}
		
		return dao.doBatchnoBoxnumDp(params);
//		return null;
	}

	/**
	 * ��Ʒ��Ų�ѯ�����-"���~��С(����)"
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doMinMaxComresidDp(OrderresdetDBParam params)
			throws Exception {
		PDisformDAO dao = (PDisformDAO) DAOFactory.build(PDisformDAO.class,
				user);
		return dao.doMinMaxComresidDp(params);
	}
	
	public DataPackage doQueryDisState(DisformDBParam params) throws Exception {
		SDisformDAO dao = (SDisformDAO) DAOFactory.build(SDisformDAO.class,
				user);
		return dao.doDisformState(params);
	}
	
	public DataPackage doQuerySignnum(DisformDBParam params) throws Exception{
		SDisformDAO dao = (SDisformDAO) DAOFactory.build(SDisformDAO.class,
				user);
		return dao.doQuerySignnum(params);
	}

	/**
	 * ��ѯ"���κ�-����(����)"��ͬ�ļ�¼��
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String doGetBatchnoBoxnum(PDisformVO vo) throws Exception {
		try {
			String result = "";
			String tempresult = "";
			DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class, user);
			ComressmpBO resbo = (ComressmpBO) BOFactory.build(
					ComressmpBO.class, user);
			OrderresdetDBParam detparams = new OrderresdetDBParam();
			
			ComressmpVO comressmpvo = new ComressmpVO();
			detparams.set_se_orderid(vo.getOrderid());
			detparams.set_se_ordercomtype(vo.getOrdercomtype());
			detparams.set_se_comcategory(vo.getComcategory());
			DataPackage dp = dfbo.doBatchnoBoxnumDp(detparams);
			if (dp != null && dp.getDatas().size() > 0) {
				for (int i = 0; i < dp.getDatas().size(); i++) {
					ComressmpDBParam resparams = new ComressmpDBParam();
					PDisformVO detvo = (PDisformVO) dp.getDatas().get(i);
					resparams.set_se_batchno(detvo.getBatchno());
					resparams.set_se_boxnum(detvo.getBoxnum());
					if (detvo.getInsideseq() == 0) {
						DataPackage comressmpdp = resbo.doQuery(resparams);
						comressmpvo = (ComressmpVO) comressmpdp.getDatas().get(
								0);
						detvo.setComresid(comressmpvo.getComresid());
					} else {
						resparams.set_ne_insideseq(detvo.getInsideseq()
								.toString());
						DataPackage comressmpdp = resbo.doQuery(resparams);
						comressmpvo = (ComressmpVO) comressmpdp.getDatas().get(
								0);
						detvo.setComresid(comressmpvo.getComresid());
					}
					tempresult = tempresult + detvo.getBatchno() + "-"
							+ detvo.getBoxnum() + "(" + detvo.getNum() + ")"
							+ " " + detvo.getComresid() + ",<br/>";
				}
				// ƴװ�����, ȥ�����һ�����š�
				result = tempresult.substring(0, tempresult.length() - 6) + "&nbsp;";
			}
			return result;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}

	}

	/**
	 * ��ѯ��С��Դ���~�����Դ���(����)
	 */
	public String doGetMinMaxComresid(PDisformVO vo) throws Exception {
		String result = "";
		OrderresdetBO detBO = (OrderresdetBO) BOFactory.build(OrderresdetBO.class, user);
		OrderresdetDBParam detparams = new OrderresdetDBParam();
		detparams.set_se_orderid(vo.getOrderid());
		detparams.set_se_ordercomtype(vo.getOrdercomtype());
		detparams.set_se_comcategory(vo.getComcategory());
		detparams.set_orderby("comresid");
		detparams.set_desc("0"); //����
		detparams.set_pagesize("0"); //��ѯ���У�����ҳ
		
		DataPackage dp = detBO.doQuery(detparams);
		if (dp != null && dp.getDatas().size() > 0) {
			long beginValue = -1;
			long preValue = -1;
			long nowValue = -1;
			for (int i = 0; i < dp.getDatas().size(); i++) {
				OrderresdetVO detVO = (OrderresdetVO) dp.getDatas().get(i);
				if (null != detVO.getComresid() && detVO.getComresid().trim().length() > 0) {
					nowValue = new Long(detVO.getComresid().trim()).longValue();
					if (beginValue == -1) { //�״�
						beginValue = nowValue;
						preValue = nowValue;
						continue;
					}
					if (nowValue == (preValue + 1)) { // ����
						preValue = nowValue;
					} else if (beginValue == preValue) {
						result += beginValue + "(1),\n";
						beginValue = nowValue;
						preValue = nowValue;
					} else {
						result += beginValue + "~" + preValue + "("+ (preValue-beginValue+1) +"),\n";
						beginValue = nowValue;
						preValue = nowValue;
					}
				}
			}
			
			if (beginValue > 0) { //�����
				if (beginValue == preValue) {
					result += beginValue + "(1),\n";
				} else {
					result += beginValue + "~" + preValue + "("+ (preValue-beginValue+1) +"),\n";
				}
				result = result.substring(0, result.length() - 2); //ƴװ�����, ȥ�����һ�����š�
			}
		}
		return result;
	}

	/**
	 * ��Ʒ������Ϲ�ϵ��IM_PR_COMCATEGORYRELA������ȡ��Ʒ���ࣻ������Ʒ�����ѯ��Ʒ�ۼ۱�FX_RU_COMPRICE����ƥ���ۼ����ַ�ʽΪ�������֡���ȡ�ۼ�1(price1)�ֶ�ֵ��
	 */
	public Double doQuerySellingprice(GDisformVO vo) throws Exception {
		try {
			Double sellingprice = new Double("0");
			ComcategoryrelaBO bo = (ComcategoryrelaBO) BOFactory.build(
					ComcategoryrelaBO.class, user);
			CompriceBO compricebo = (CompriceBO) BOFactory.build(
					CompriceBO.class, user);
			ComcategoryrelaDBParam params = new ComcategoryrelaDBParam();
			CompriceDBParam compriceparams = new CompriceDBParam();
			params.set_ne_comid(vo.getComid().toString());
			DataPackage dp = bo.doQuery(params);
			//���Ϊ��, ��Ĭ�����ۼ�Ϊ0
			if (dp != null && dp.getDatas().size() > 0) {
				ComcategoryrelaVO relavo = (ComcategoryrelaVO) dp.getDatas()
						.get(0);
				compriceparams.set_se_comcategory(relavo.getComcategory());
				compriceparams.set_se_pricediftype("NODIF");
				compriceparams.set_se_cityid(user.getCityid());
				DataPackage compricedp = compricebo.doQuery(compriceparams);
				//���Ϊ��, ��Ĭ�����ۼ�Ϊ0
				if (compricedp != null && compricedp.getDatas().size() > 0) {
					CompriceVO compricevo = (CompriceVO) compricedp.getDatas()
							.get(0);
					sellingprice = compricevo.getPrice1();
				} else {
					sellingprice = new Double("0");
				}
			} else {
				sellingprice = new Double("0");
			}
			return sellingprice;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	/**
	 * ��ѯ��Ʒ��(IM_PR_COM)��ȡ����Comprice
	 */
	public Long getQueryComprice(String comid) throws Exception {
		try {
			Long comprice = new Long(0);
			ComBO combo = (ComBO) BOFactory.build(ComBO.class, user);
			ComDBParam comparams = new ComDBParam();
			comparams.set_ne_comid(comid);
			DataPackage comdp = combo.doQuery(comparams);
			ComVO vo = (ComVO) comdp.getDatas().get(0);
			comprice = vo.getComprice();
			return comprice;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void dosSendMsg(DisformVO updatevo) throws Exception {
		Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
		String param72 = sysparamBO.doFindByID("72", "pboss_fx");
		
		if(param72 != null && "1".equals(param72)){
			try{
				//�������ݵ���������ȷ�ϱ�FX_SW_SMSCONFIRM��
				Smsconfirm smsconfirmBO = (SmsconfirmBO) BOFactory.build(SmsconfirmBO.class, user);
				SmsconfirmVO smsconfirmVO = new SmsconfirmVO();
				String orderid = updatevo.getOrderid();
				String subOrderID = "";
				if(orderid != null && orderid.length() >= 4){
					subOrderID = orderid.substring(orderid.length()-4);
				}
				String receTel = updatevo.getRecetel();//���պ���
				smsconfirmVO.setType("PARSIGN");//����ȡ������ǩ��
				smsconfirmVO.setStream(subOrderID);//ȷ����ˮ��ȡ����ĩβ4λ
				smsconfirmVO.setMobileno(receTel);//�ֻ�����ȡ���͵��е��ջ��˵绰
				smsconfirmVO.setOrderid(orderid);//����������ȡ�������
				smsconfirmVO.setState("WAITREP");//״̬ȡ���ظ�
				smsconfirmVO.setSendtime(new Date());//֪ͨʱ��ȡ��ǰʱ��
				
				
				//�ظ�ʱ��ͻظ���������
				
				smsconfirmBO.doCreate(smsconfirmVO);
				
				//�������ݵ����Ŵ����ͱ�(CH_SMS_WAITREQ)
				String param42 = sysparamBO.doFindByID("42", "pboss_fx");//���ͺ���
				if(param42 != null && !"".equals(param42)){
					
				}else{//������һ��
					return;
				}
				
				if(receTel != null && !"".equals(receTel)){
					
				}else{//������һ��
					return;
				}
				String recename = updatevo.getRecename();//�ͻ�����ȡ���͵��е��ջ�������
				if(recename != null && !"".equals(recename)){
					
				}else{
					recename = "�ͻ�";
				}
				//��������Ϣ����ȡ�������ţ������������Ϊ��
				String logisticsno = updatevo.getLogisticsno(); 
				if (null == logisticsno || ("").equals(logisticsno)) {
					logisticsno = " ";
				}
				
				//��������
				//�𾴵�{CUSTNAME}��{YEAR}��{MONTH}��{DAY}�����͵����ʣ������ţ�{ ORDERID }��
				//�Ƿ��յ����ظ�"Q{STREAM}"ȷ��ǩ�գ��ظ�"N{STREAM}"�ܾ�ǩ�ա��㶫�ƶ���
				Calendar calendar = Calendar.getInstance();		
				Map<String,String> map = new HashMap<String,String>();
				map.put("CUSTNAME", recename);
				map.put("YEAR", ""+calendar.get(Calendar.YEAR));
				map.put("MONTH", calendar.get(Calendar.MONTH)+1+"");
				map.put("DAY", ""+calendar.get(Calendar.DAY_OF_MONTH));
				map.put("ORDERID", orderid);
				map.put("STREAM", subOrderID);
				map.put("LOGISTICSINFO", logisticsno);
				Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
				String smsContent = smstmplBO.doGenSMS("FX_ORDER_PARSIGNCON", map);
				if( null == smsContent || "".equals(smsContent.trim())){//������һ��
					return;
				}
					
				Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
				waitreqBO.doInsert2(new Short("3"), smsContent, param42,receTel);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	   public void doComfirmSignMsg(DisformVO disformVO) throws Exception{  
		   Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
				try{ 
					Way wayBO = (WayBO)BOFactory.build(WayBO.class,user);				
					//�������ݵ����Ŵ����ͱ�(CH_SMS_WAITREQ)
					String param42 = sysparamBO.doFindByID("42", "pboss_fx");//���ͺ���
					if(param42 != null && !"".equals(param42)){
						
					}else{//������һ��
						return;
					}
					String wayid = disformVO.getDiscomcode(); //�����̱���
					WayVO wayVO = wayBO.doFindByPk(wayid);
					
					//����������
					String recename = null;
					if (wayVO!=null) {
						recename = wayVO.getWayname();
					}else{
						recename = "�ͻ�";
					}
					
					//���պ���    
					Employee employeeBO = (Employee) BOFactory.build(EmployeeBO.class, user);
					EmployeeDBParam employeeDBParam = new EmployeeDBParam();
					employeeDBParam.set_se_wayid(wayid);
					employeeDBParam.set_ne_isnet("3");// ������
					employeeDBParam.set_ne_empstatus("0");// �ڸ�
					String receTel = null;
					DataPackage dp1 = employeeBO.doQuery(employeeDBParam);
					if (null != dp1 && dp1.getDatas().size() > 0) {
						EmployeeVO vo = (EmployeeVO) dp1.getDatas().get(0);
						receTel = vo.getOfficetel();
						if (null == receTel || ("").equals(receTel)) {
							throw new JOPException ("�������ֻ����벻��Ϊ�գ�");
						}
					} 
					
					String orderid = disformVO.getOrderid(); 
					//��������Ϣ����ȡ�������ţ������������Ϊ��
					String logisticsno = disformVO.getLogisticsno(); 
					if (null == logisticsno || ("").equals(logisticsno)) {
						logisticsno = " ";
					}
					
					//��������
					//�𾴵�{CUSTNAME}��{YEAR}��{MONTH}��{DAY}�����͵����ʣ������ţ�{ ORDERID }��
					//�Ƿ��յ����ظ�"Q{STREAM}"ȷ��ǩ�գ��ظ�"N{STREAM}"�ܾ�ǩ�ա��㶫�ƶ���
					Calendar calendar = Calendar.getInstance();		
					Map<String,String> map = new HashMap<String,String>();
					map.put("CUSTNAME", recename);
					map.put("YEAR", ""+calendar.get(Calendar.YEAR));
					map.put("MONTH", calendar.get(Calendar.MONTH)+1+"");
					map.put("DAY", ""+calendar.get(Calendar.DAY_OF_MONTH));
					map.put("ORDERID", orderid);
					map.put("LOGISTICSINFO", logisticsno);
					Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
					String smsContent = smstmplBO.doGenSMS("FX_ORDER_COMPDIS", map);
					if( null == smsContent || "".equals(smsContent.trim())){//������һ��
						return;
					}
						
					Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
					waitreqBO.doInsert2(new Short("3"), smsContent, param42,receTel);
					
				}catch (Exception e) {
					e.printStackTrace();
				} 
		   
	   }
	   
	   public void doDealOrderBySys(String[] selectArray) throws Exception{
		   try{
			   
		   DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class,user); 
		   Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
			String paramvalue = sysparamBO.doFindByID(new Long("76"), "pboss_fx");
			//�������ֵΪ1ʱ��ִ�������������֪ͨ�����̣���������
			 if (paramvalue != null && "1".equals(paramvalue)) { 
				 for (int i = 0; i < selectArray.length; i++) {
					 DisformVO dfvo = dfbo.doFindByPk(new Long(selectArray[i])); 
					 if ( dfvo != null) {
						 this.doComfirmSignMsg(dfvo);
					 }
				 }
			 }
			 //�������ֵΪ1ʱ����¶�����Ķ���״̬Ϊ����ǩ�ա�
			 String sysvalue = sysparamBO.doFindByID(new Long("77"), "pboss_fx");
			 if ( sysvalue != null && "1".equals(sysvalue)) {
				 for (int i = 0; i < selectArray.length; i++) {
					 OrderBO orderbo = (OrderBO) BOFactory.build(OrderBO.class,user); 
					   DisformVO dfvo = dfbo.doFindByPk(new Long(selectArray[i]));
						OrderVO ordervo = orderbo.doFindByPk(dfvo.getOrderid());
						this.doUpdateOrderState(ordervo);
					}
			 }
		   
	   }catch (Exception e) {
			e.printStackTrace();
		} 

}
	   
	   public void doUpdateOrderState(OrderVO ordervo) throws Exception{
		   try{
			   OrderBO orderbo = (OrderBO) BOFactory.build(OrderBO.class,user); 
				if (ordervo != null) {
					if(ordervo.getOrderstate() != null && !ordervo.getOrderstate().equals("FINISHED")){
						ordervo.setOrderstate(DISFORM_SIGNED);
						ordervo.setStatechgtime(new Date());
						orderbo.doUpdate(ordervo);	
						
						// ��������Ϊ"pboss_fx"��������ʶΪ"84"���������ֵΪ1ʱ�ж��Ƿ�ɷ��𶩹�
						doUpdateWayassistant(ordervo);
						
						//Ȼ����á�������һ�������÷���������������
						orderbo.doNextProcess(ordervo.getOrderid());
					}
				}
		   }catch (Exception e) {
				e.printStackTrace();
			} 
		   }

	/**
	 * ��ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ"pboss_fx"��������ʶΪ"84"���������ֵΪ1ʱ
	 * ��ȡ�ö�����fx_sw_order���е��������������������ѯ��Ʒ����������Ϣ�� (FX_RU_WAYASSISTANT)��
	 * �ж��Ƿ�ɷ��𶩹�ֵ�Ƿ�Ϊ"1"����Ϊ"1"���޸ĳ�1����������
	 */
    public void doUpdateWayassistant(OrderVO ordervo) throws Exception {
		try {
			Sysparam sysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class, user);
			String sysvalue = sysparamBO.doFindByID(new Long("84"), "pboss_fx");
			if (sysvalue != null && "1".equals(sysvalue)) {
				WayassistantBO assistantbo = (WayassistantBO) BOFactory.build(WayassistantBO.class, user);
				WayassistantVO assistantvo = assistantbo.doFindByPk(ordervo.getWayid());
				if (assistantvo.getCanorder() != 1) {
					assistantvo.setCanorder(new Short("1"));
					assistantbo.doUpdate(assistantvo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}