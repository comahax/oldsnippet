package com.gmcc.pboss.control.sales.bgcontrol.orderConfirmnotice;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.base.smstmpl.SmstmplDBParam;
import com.gmcc.pboss.business.base.smstmpl.SmstmplVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.sales.order.OrderDBParam;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateDBParam;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateVO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmDBParam;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.ordercomcate.Ordercomcate;
import com.gmcc.pboss.control.sales.ordercomcate.OrdercomcateBO;
import com.gmcc.pboss.control.sales.smsconfirm.Smsconfirm;
import com.gmcc.pboss.control.sales.smsconfirm.SmsconfirmBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class OrderConfirmnoticeBO extends AbstractControlBean implements OrderConfirmnotice {
	
	private Logger log = Logger.getLogger(OrderConfirmnoticeBO.class);
	
	public void doProcess() throws Exception {
		log.info("==================================����ȷ������ Begin==================================");
		//��ȡ����ȷ�����Ѷ�����������
		/**
		 * ����ȷ�����Ѷ�����������,��λΪ��,Ҫ����������,������ʱ����,��������
		 */
		Sysparam resBO = (Sysparam) BOFactory.build(SysparamBO.class, user);
		String confirmTime = resBO.doFindByID(64L, "pboss_fx");
		if (StringUtils.isEmpty(confirmTime)) {//modify by panyonghui
			confirmTime = "0";
		}
		try {
			if(Integer.parseInt(confirmTime) <= 0){
				log.info("����ȷ�����Ѷ���������������Ϊδ����");
				return;
			}
		} catch (Exception e) {
			log.info("����ȷ�����Ѷ�����������Ϊ������");
			return;
		}
		//��ȡ����ģ��
		SmstmplVO smstmplVO = this.doGetSmsTemplete();
		if(smstmplVO == null){
			log.info("�޷���������ģ������");
			return ;
		}
		//����ȷ������,��ѯ������FX_SW_ORDER����ƥ�䶩��״̬Ϊ��ȷ�ϣ��Ƿ�ȷ��Ϊ�񣬴���ʱ��������뵱ǰ���ڲ�ͬ������
		Order orderBO = (Order) BOFactory.build(OrderBO.class, user);
		OrderDBParam orderParam = new OrderDBParam();
		orderParam.set_se_orderstate("WAITCON");//����״̬Ϊ��ȷ��
		orderParam.set_nne_confirmflag("1");//�Ƿ�ȷ��Ϊ��,��Ϊ���ݿ���ֻ����confirmflag��ֵΪ��1��-��ʾ�ǣ�������Ϊ�����Դ˴��á��Ƿ�ȷ�ϲ�����1��
		Date currDate = new Date();
		orderParam.set_dne_createtime(PublicUtils.utilDateToStr(currDate));//����ʱ��������뵱ǰ���ڲ�ͬ
		orderParam.setDataOnly(true);
		orderParam.set_pagesize("0");
		DataPackage dPackage = orderBO.doQuery(orderParam);
		//�����ж��Ƿ��·�����
		List<OrderVO> orderList = dPackage.getDatas();
		if(!orderList.isEmpty()){
			Smsconfirm smsconfirmBO = (Smsconfirm) BOFactory.build(SmsconfirmBO.class, user);//����ȷ��
			//Cooperator cooperatorBO = (Cooperator) BOFactory.build(CooperatorBO.class, user);//��������������
			Employee employeeBO = (Employee) BOFactory.build(EmployeeBO.class, user);//������Ա������Ϣ
			Ordercomcate ordercomcateBO = (Ordercomcate) BOFactory.build(OrdercomcateBO.class, user);//������Ʒ����
			Comcategoryrela comcategoryrelaBO = (Comcategoryrela) BOFactory.build(ComcategoryrelaBO.class, user);//��Ʒ������Ϲ�ϵ
			Waitreq waitreqBO = (Waitreq) BOFactory.build(WaitreqBO.class, user);//���Ŵ�����
			
			ComcategoryrelaDBParam cDBParm = new ComcategoryrelaDBParam();
			cDBParm.setSelectFieldsString("comcategory,restype");//���ࡢ��Դ���
			cDBParm.setDataOnly(true);
			cDBParm.set_pagesize("0");
			//�������ࡢ��Դ���������ͳ��
			DataPackage  comcategorDP = comcategoryrelaBO.doLoadComCateAndResType(cDBParm);
			
			String noteNo = resBO.doFindByID(42L, "pboss_fx");//���ŷ��ͺ���
			
			String sendTimeParam = resBO.doFindByID("58", "pboss_fx");//����ʱ��������ʱ���ʽΪhh:mi��Ĭ��Ϊ8:30
			if(StringUtils.isEmpty(sendTimeParam)){
				sendTimeParam = "08:30";
			}
			String timePoint = sendTimeParam + ":00";
			
			Calendar calendar = Calendar.getInstance();
			//���ŷ���ʱ�䣬��ϵͳ������ȡĳ��ʱ��㣬Ȼ����װ��ϵͳ��ǰ���ڵ����ʱ���.//ȡ��ǰʱ���ȡ����9�㣬�������ʱ�䳬��9�㣬��������ȡ�ڶ��������9��
			Date senttime = PublicUtils.UtilStrToDate(PublicUtils.getMonthSomeTime(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, timePoint));
			/*if(currDate.after(senttime)){
				senttime = PublicUtils.getPreOrAfterDate(currDate, -1, 9);//��ȡ�ڶ����9��
			}*/
			for (OrderVO orderVO : orderList) {
				Date createDate = orderVO.getCreatetime();
				String orderid = orderVO.getOrderid();
				int dates = PublicUtils.compareDate(createDate, currDate);
				//ϵͳ��ǰ�����붩�������������С�ڵ��ڡ�����ȷ�����Ѷ����������������������һ��
				if(createDate.after(currDate) || Integer.parseInt(confirmTime) < dates){
					log.info("����[" + orderid + "]�Ѿ��������Ѷ�����������");
					continue;
				}else{
					//���·�������ȷ�ϱ��е�֪ͨʱ��
					/**
					 * ���ݶ�����š����ͣ�����ȷ�ϣ���״̬�����ظ�����ѯ��������ȷ�ϱ�FX_SW_SMSCONFIRM����
					 * ��������ݣ��޸�֪ͨʱ��Ϊ��ǰʱ�䣻��������ݣ�����һ�����ݷ�������ȷ�ϱ����ȡ������У�����ȡ����ȷ�ϣ�
					 * ȷ����ˮ��ȡ����ĩβ4λ�����ݺ����̱����ѯ�������������ϱ�CH_DST_COOPERATOR�����ֻ�����ȡ�ջ���ϵ���룻
					 * ����������ȡ������ţ�״̬ȡ���ظ���֪ͨʱ��ȡ��ǰʱ�䣻�ظ�ʱ��ͻظ��������գ�
					 */
					SmsconfirmDBParam smsParams = new SmsconfirmDBParam();
					smsParams.set_se_orderid(orderid);
					smsParams.set_se_type("ORDERCON");//����ȷ��
					smsParams.set_se_state("WAITREP");//���ظ�
					smsParams.setDataOnly(true);
					smsParams.set_pagesize("0");
					DataPackage smsDPackage = smsconfirmBO.doQuery(smsParams);
					List<SmsconfirmVO> smsconfirmList = smsDPackage.getDatas();
					
					//������Ա��
					EmployeeDBParam empParams = new EmployeeDBParam();
					empParams.set_se_wayid(orderVO.getWayid());
					empParams.set_ne_isnet("1");//�Ƿ����Ϊ��
					empParams.set_ne_empstatus("0");//�ù�״̬Ϊ�ڸ�
					empParams.setDataOnly(true);
					DataPackage empDPackage = employeeBO.doQuery(empParams);
					List<EmployeeVO> empList = empDPackage.getDatas();
					EmployeeVO employeeVO = null;
					if(!empList.isEmpty()){
						employeeVO = empList.get(0);
					}else{
						employeeVO = new EmployeeVO();
						employeeVO.setWayid(orderVO.getWayid());
					}
					//��ȡ���պ���
					String recno = employeeVO.getOfficetel();//���պ���
					if(StringUtils.isEmpty(recno) || recno.length() != 11){
						log.info("����[" + employeeVO.getWayid() + "]�޷�ȡ�õ����Ĺ��������,���߹�������볤�ȴ���.");
						continue;
					}
					
					if(!smsconfirmList.isEmpty()){
						for (SmsconfirmVO smsconfirmVO : smsconfirmList) {
							smsconfirmVO.setSendtime(currDate);
							smsconfirmBO.doUpdate(smsconfirmVO);
						}
					}else{
						SmsconfirmVO smsvo = new SmsconfirmVO();
						smsvo.setType("ORDERCON");
						smsvo.setStream(orderid.substring(orderid.length() - 4));
						//CooperatorVO cooperatorVO = cooperatorBO.doFindByPk(orderVO.getWayid());
						smsvo.setMobileno(recno);//�ֻ�����ȡ���������
						smsvo.setOrderid(orderid);
						smsvo.setState("WAITREP");
						smsvo.setSendtime(currDate);
						smsconfirmBO.doCreate(smsvo);
					}
					
					//���������滻
					String employeeName = employeeVO.getEmployeename();
					if(StringUtils.isEmpty(employeeName)){
						employeeName = "�ͻ�";
					}
					String noteDate = PublicUtils.formatUtilDate(createDate, "yyyyMMdd");//�����������ڣ���ʽ��ΪYYYYMMDD��ʽ
					OrdercomcateDBParam orderceDBParam = new OrdercomcateDBParam();
					orderceDBParam.set_se_orderid(orderid);
					orderceDBParam.setDataOnly(true);
					orderceDBParam.set_pagesize("0");
					DataPackage ordercDPackage = ordercomcateBO.doQuery(orderceDBParam);
					List<OrdercomcateVO> ordercList = ordercDPackage.getDatas();
					StringBuffer orderDesc = new StringBuffer("");//������Ʒ����
					List<Map<String, String>> comcategorList = comcategorDP.getDatas();
					if(!ordercList.isEmpty()){
						for (OrdercomcateVO ordercomcateVO : ordercList) {
							String category = ordercomcateVO.getComcategory();
							String categoryName = Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", category, user.getCityid());
							Long orderamt = ordercomcateVO.getOrderamt();
							String unitStr = "";//������Ʒ�����ѯ��Ʒ������Ϲ�ϵ��IM_PR_COMCATEGORYRELA����ȡ��Դ����׿���λΪ�ף���ֵ����λΪ��
							for (Map<String, String> map : comcategorList) {
								String category_ = map.get("comcategory");
								if(StringUtils.isNotEmpty(category_) && category_.equals(category)){
									String resType = map.get("restype");
									unitStr = "COMRESSMP".equals(resType) ? "��" : "��";
									break;
								}
							}
							orderDesc.append("," + categoryName + orderamt + unitStr);
						}
					}else{
						log.info("����[" + orderid + "]�޶�����Ʒ������Ϣ");
						continue;
					}
					Double ordersum = orderVO.getRecamt();//�ϼƽ��
					String stream = orderid.substring(orderid.length() - 4);//��ˮ��
					
					//��ȡ���ŷ��ͺ���
					if(StringUtils.isEmpty(noteNo)){
						log.info("��ȡ���ŷ��ͺ���ʧ�ܣ��������[" + orderid + "]");
						return;
					}
					
					//���Ͷ���֪ͨ
					String [] contentinfos = {
							employeeName, noteDate, orderDesc.substring(1), String.valueOf(ordersum), stream
					};
					//String content = replaceSyscontent(smstmplVO,contentinfos);
					Map<String,String> keyAndValue = new HashMap<String,String>();
					keyAndValue.put("CUSTNAME", contentinfos[0]);
					keyAndValue.put("YYYYMMDD", contentinfos[1]);
					keyAndValue.put("COMDESC", contentinfos[2]);
					keyAndValue.put("ORDERSUM", contentinfos[3]);
					keyAndValue.put("STREAM", contentinfos[4]);
					Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
					String sContent = smstmplVO.getScontent();
					String content = smstmplBO.doGenSMS("FX_ORDER_CONFIRMNOTICE",sContent,keyAndValue);
					
					//String content = "��ܰ��ʾ���𾴵�" + employeeName + ",����" + noteDate + "��������Ʒ[" + orderDesc.substring(1) + "]���ϼƽ��" + ordersum + "Ԫ���뼰ʱ�ظ�\"Y" + stream + "\"ȷ�϶�����";
					waitreqBO.doInsert3(new Short("3"), content, noteNo, recno,senttime);
				}
			}
		}
		log.info("==================================����ȷ������ End==================================");
	}
	
	/**
	 * ���������滻
	 * @param smstmplVO
	 * @param contentinfos
	 * @return
	 * @throws Exception
	 */
	private String replaceSyscontent(SmstmplVO smstmplVO ,String [] contentinfos) throws Exception {
		String syscontent = smstmplVO.getScontent();
		if(StringUtils.isEmpty(syscontent)){
			return "";
		}
		return syscontent.replaceAll("\\{CUSTNAME\\}", contentinfos[0])
						 .replaceAll("\\{YYYYMMDD\\}", contentinfos[1])
						 .replaceAll("\\{COMDESC\\}", contentinfos[2])
						 .replaceAll("\\{ORDERSUM\\}", contentinfos[3])
						 .replaceAll("\\{STREAM\\}", contentinfos[4]);
	}
	
	/*
	 * ��ȡ����ģ��
	 * ���ݱ�ʶ��FX_ORDER_CONFIRMNOTICE������Ч״̬��1��
	 * ��ѯ����ģ���CH_SMS_SMSTMPL������ȡģ�����ݣ���������ݻ�����Ϊ�գ�����ʾ���˳�
	 */
	private SmstmplVO doGetSmsTemplete() throws Exception {
		Smstmpl smstmplBO = (SmstmplBO) BOFactory.build(SmstmplBO.class, user);
		SmstmplDBParam param = new SmstmplDBParam();
		param.setDataOnly(true);
		param.set_se_sid("FX_ORDER_CONFIRMNOTICE");
		param.set_se_sstate("1");
		DataPackage dp = smstmplBO.doQuery(param);
		if (null == dp
				|| null == dp.getDatas()
				|| dp.getDatas().size() < 1
				|| ((SmstmplVO) dp.getDatas().get(0)).getScontent() == null
				|| "".equals(((SmstmplVO) dp.getDatas().get(0)).getScontent())){
			return null;
		}
		return (SmstmplVO) dp.getDatas().get(0);
	}
}
