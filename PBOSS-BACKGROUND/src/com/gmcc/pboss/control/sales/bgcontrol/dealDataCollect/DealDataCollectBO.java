package com.gmcc.pboss.control.sales.bgcontrol.dealDataCollect;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.SecurityPass;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductDBParam;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductVO;
import com.gmcc.pboss.business.sales.bankrecord.BankrecordDBParam;
import com.gmcc.pboss.business.sales.bankrecord.BankrecordVO;
import com.gmcc.pboss.business.sales.bankrecordsum.BankrecordsumVO;
import com.gmcc.pboss.business.sales.bankshop.BankshopDBParam;
import com.gmcc.pboss.business.sales.bankshop.BankshopVO;
import com.gmcc.pboss.common.bankunite.BankUniteProcessCom;
import com.gmcc.pboss.common.bankunite.model.queryhistory.request.QhInfoReq;
import com.gmcc.pboss.common.bankunite.model.queryhistory.request.QhQuery_transReq;
import com.gmcc.pboss.common.bankunite.model.queryhistory.request.QhReq;
import com.gmcc.pboss.common.bankunite.model.queryhistory.response.QhRes;
import com.gmcc.pboss.common.bankunite.model.queryhistory.response.QhRet_detailsRes;
import com.gmcc.pboss.control.sales.bankdeduct.BankdeductBO;
import com.gmcc.pboss.control.sales.bankrecord.BankrecordBO;
import com.gmcc.pboss.control.sales.bankrecordsum.BankrecordsumBO;
import com.gmcc.pboss.control.sales.bankshop.Bankshop;
import com.gmcc.pboss.control.sales.bankshop.BankshopBO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class DealDataCollectBO extends AbstractControlBean implements DealDataCollect {
	
	private static Logger log = Logger.getLogger(DealDataCollectBO.class);
	
	public void doProcess(String date) throws Exception {
		//���ݵ��б�ʶ��ѯ�����̻���Ϣ�� (FX_CB_BANKSHOP)��ȡ�����̻���Ϣ
		Bankshop bankshopBO = (BankshopBO)BOFactory.build(BankshopBO.class,user);
		BankshopDBParam bankshopDBParam = new BankshopDBParam();
		bankshopDBParam.set_se_cityid(user.getCityid());		
		DataPackage bankshopDP = bankshopBO.doQuery(bankshopDBParam);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
		
		//��ȡ�����ļ�������
		String proFile = "/DealDataCollectProcess.properties";
		InputStream is = this.getClass().getResourceAsStream(proFile);
		Properties properties = new Properties();
		properties.load(is);
		is.close();
		String xml_user = properties.getProperty(user.getCityid() + "_username");
		String xml_pwd = properties.getProperty(user.getCityid() + "_password");
		String page_size = properties.getProperty("page_size");
		
		if(xml_pwd != null && !"".equals(xml_pwd)){
			xml_pwd = new String(SecurityPass.decode(SecurityPass.hex2byte(xml_pwd), 
					SecurityPass.hex2byte("70469B26CBF1E575")));
		}
		
		if(date == null || "".equals(date)){
			//ǰһ��
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, -1);
			
			date = sdfDate.format(calendar.getTime());
			Integer.valueOf(page_size);
		}else{
			try {
				sdfDate.parse(date);
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e);
				
				throw e;
			}
		}
		
		String begin_date = date;
		String end_date = date;
		
		if(bankshopDP.getRowCount()>0){
			Iterator it = bankshopDP.getDatas().iterator();
			
			QhInfoReq info = new QhInfoReq();				//��װͷ��
			info.setTrx_code("200002");						//���״���
			info.setVersion("03");							//�汾
			info.setData_type(Short.valueOf((short)2));		//���ݸ�ʽ
	        info.setReq_sn("");								//������ˮ��
	        info.setUser_name(xml_user);					//�û���
	        info.setUser_pass(xml_pwd);						//�û�����
	        info.setSigned_msg("");							//ǩ����Ϣ
	        
	        Long successcount = 0L;							//�ɹ�����
	        Long failurecount = 0L;							//ʧ������
	        Long amterrcount = 0L;							//����������
	        Double localamt = 0D;							//�����ܽ��
	        Double bankamt = 0D;							//�����ܽ��
	        java.util.Date recordate = null;				//��������
	        java.util.Date creatdate = new Date();			//¼��ʱ��
			
			while(it.hasNext()){
				BankshopVO bsVO=(BankshopVO)it.next();
				try {
					log.info("============��ʼ������̻���Ϊ==================="+bsVO.getShopnum());
					
					//�������з�װ�������á����ջ���ʷ��ѯ���󡿽ӿڲ�ѯ���콻�׼�¼				
					QhQuery_transReq query_trans = new QhQuery_transReq();	//��װbody
					query_trans.setMerchant_id(bsVO.getShopnum());			//�̻�ID
					query_trans.setQuery_sn("");							//Ҫ��ѯ�Ľ�����ˮ
					query_trans.setBegin_date(begin_date);					//��ʼ����
					query_trans.setEnd_date(end_date);						//��������
					query_trans.setPage_num(Integer.valueOf(1));			//ҳ��
					query_trans.setPage_size(Integer.valueOf(page_size));	//ÿҳ��¼��
					query_trans.setResult_type((short)1);					//��ѯ����
					query_trans.setNeed_detail((short)1);					//�Ƿ��ѯ��ϸ
					query_trans.setQuery_remark("");						//��ѯ��ע
					
					int page_sum = 1;
					int queCount = 1;//��ǰ��ѯҳ��
					
					QhReq req = new QhReq();				
					req.setInfo(info);
					req.setQuery_trans(query_trans);
					BankUniteProcessCom bankUniteProcessCom = new BankUniteProcessCom();
					bankUniteProcessCom.initPropertie(user.getCityid());
					bankUniteProcessCom.setLog(log);
					
					while(queCount <= page_sum){
						query_trans.setPage_num(queCount);			//ҳ��
						QhRes qhRes = (QhRes)bankUniteProcessCom.sendMsg(req, true, QhRes.class);				
						if(page_sum == 1){
							page_sum = qhRes.getQuery_trans().getPage_sum().intValue();
						}
						log.info("�̻��ţ�"+bsVO.getShopnum() + "����ǰ��ѯ��ҳ����" + queCount);
						
						if(qhRes != null && !"".equals(qhRes) && qhRes.getRet_details() != null 
								&& !"".equals(qhRes.getRet_details()) && qhRes.getRet_details().size() > 0){
							for(int i=0 ; i<qhRes.getRet_details().size() ; i++){
								QhRet_detailsRes qhRet_detailsRes = qhRes.getRet_details().get(i);
								String sn = qhRet_detailsRes.getSn();//��¼���
								if(sn != null && !"".equals(sn)){
									//������Ϣ�����״̬ȡֵ
									BankdeductBO bankdeductBO = (BankdeductBO)BOFactory.build(BankdeductBO.class,user);
									BankdeductDBParam bankdeductDBParam = new BankdeductDBParam();
									bankdeductDBParam.set_ne_deductid(Long.parseLong(sn));
									DataPackage bankdeductDP = bankdeductBO.doQuery(bankdeductDBParam);
									String recordinfo = null;//������Ϣ
									Short recordstate = null;//����״̬
									BankdeductVO bankdeductVO = null;
									if(bankdeductDP.getRowCount() > 0){
										bankdeductVO = (BankdeductVO)bankdeductDP.getDatas().get(0);
									}
									if(bankdeductVO == null)
										continue;
									bankdeductVO.setDeductamt(0D);
									if("0000".equals(qhRet_detailsRes.getRet_code())){
										//��������Ϊ0000����ʾ�ɹ�
										recordinfo = "�ɹ�/�ɹ���" + qhRet_detailsRes.getAmount()/100 + "/" + 
													bankdeductVO.getDeductamt() + "��";
									}else{
										recordinfo = "ʧ��/ʧ�ܣ�" + qhRet_detailsRes.getAmount()/100 + "/" + 
													bankdeductVO.getDeductamt() + "��";
									}
									
									if((qhRet_detailsRes.getRet_code() != null 
											&& qhRet_detailsRes.getRet_code().equals(bankdeductVO.getRespcode()))
											&& (qhRet_detailsRes.getAmount().doubleValue()/100 == bankdeductVO.getDeductamt())){
										recordstate = 1;
									}
									if(!"0000".equals(qhRet_detailsRes.getRet_code()) &&
											!"0000".equals(bankdeductVO.getRespcode())){
										recordstate = 0;
									}
									if(qhRet_detailsRes.getRet_code() != null 
											&& !qhRet_detailsRes.getRet_code().equals(bankdeductVO.getRespcode())){
										recordstate = 3;
									}
									if(qhRet_detailsRes.getRet_code() != null 
											&& qhRet_detailsRes.getRet_code().equals(bankdeductVO.getRespcode()) && 
											(qhRet_detailsRes.getAmount().doubleValue() != bankdeductVO.getDeductamt())){
										recordstate = 2;
									}
									
									if("0000".equals(qhRet_detailsRes.getRet_code())){
										 successcount = successcount + 1;
									}else{
										failurecount = failurecount + 1;
									}							
									if(recordstate == 2){
										amterrcount = amterrcount + 1;
									}
									if("0000".equals(bankdeductVO.getRespcode())){
										 localamt = localamt + bankdeductVO.getDeductamt();
									}
									if("0000".equals(qhRet_detailsRes.getRet_code())){
										bankamt = bankamt + qhRet_detailsRes.getAmount();
									}
									if(begin_date != null && !"".equals(begin_date)){
										recordate = sdfDate.parse(begin_date);
									}
									
									//���ݷ��صļ�¼��ţ�SN����ѯ���л��۽��׼�¼��(FX_SW_BANKRECORD)
									BankrecordBO bankrecordBO = (BankrecordBO)BOFactory.build(BankrecordBO.class,user);
									BankrecordDBParam bankrecordDBParam = new BankrecordDBParam();
									bankrecordDBParam.set_ne_deductid(sn);//��¼���
									DataPackage bankrecordDP = bankrecordBO.doQuery(bankrecordDBParam);
									if(bankrecordDP.getRowCount()>0){//����
										BankrecordVO bankrecordVO = (BankrecordVO)bankrecordDP.getDatas().get(0);
										bankrecordVO.setOrafileid(""+qhRet_detailsRes.getOrafile_id());//
										
										//bankrecordVO.setDeductid(Long.parseLong(sn));//��¼���
										bankrecordVO.setAccount(qhRet_detailsRes.getAccount());//�˺�
										bankrecordVO.setAccountname(qhRet_detailsRes.getAccount_name());//�˺���
										bankrecordVO.setAmount(qhRet_detailsRes.getAmount());//���
										bankrecordVO.setCustuserid(qhRet_detailsRes.getCust_userid());//�Զ����û���
										if(qhRet_detailsRes.getComplete_time() != null && !"".equals(qhRet_detailsRes.getComplete_time())) {
											if (qhRet_detailsRes.getComplete_time().length() == 14) {
												bankrecordVO.setCompletetime(sdf.parse(qhRet_detailsRes.getComplete_time()));//���ʱ��
											} else if (qhRet_detailsRes.getComplete_time().length() == 8) {
												bankrecordVO.setCompletetime(sdfDate.parse(qhRet_detailsRes.getComplete_time()));//���ʱ��
											} else {
												log.error(sn + "���ʱ���ʽ����ȷ:" + qhRet_detailsRes.getComplete_time());
											}
										}
										bankrecordVO.setRemark(qhRet_detailsRes.getRemark());//��ע
										bankrecordVO.setRetcode(qhRet_detailsRes.getRet_code());//������
										bankrecordVO.setErrmsg(qhRet_detailsRes.getErr_msg());//�����ı�
										
										bankrecordVO.setShopnum(bsVO.getShopnum());//�̻���
										bankrecordVO.setCountyid(bsVO.getCountyid());//�ֹ�˾
										//bankrecordVO.setCreatdate(new Date());//����ʱ��
										
										bankrecordVO.setRecordinfo(recordinfo);//������Ϣ
										bankrecordVO.setRecordstate(recordstate);//����״̬
										
										bankrecordBO.doUpdate(bankrecordVO);
									}else{//����
										BankrecordVO bankrecordVO = new BankrecordVO();
										bankrecordVO.setOrafileid(""+qhRet_detailsRes.getOrafile_id());//
										
										bankrecordVO.setDeductid(Long.parseLong(sn));//��¼���
										bankrecordVO.setAccount(qhRet_detailsRes.getAccount());//�˺�
										bankrecordVO.setAccountname(qhRet_detailsRes.getAccount_name());//�˺���
										bankrecordVO.setAmount(qhRet_detailsRes.getAmount().doubleValue());//���
										bankrecordVO.setCustuserid(qhRet_detailsRes.getCust_userid());//�Զ����û���
										if(qhRet_detailsRes.getComplete_time() != null && !"".equals(qhRet_detailsRes.getComplete_time())) {
											if (qhRet_detailsRes.getComplete_time().length() == 14) {
												bankrecordVO.setCompletetime(sdf.parse(qhRet_detailsRes.getComplete_time()));//���ʱ��
											} else if (qhRet_detailsRes.getComplete_time().length() == 8) {
												bankrecordVO.setCompletetime(sdfDate.parse(qhRet_detailsRes.getComplete_time()));//���ʱ��
											} else {
												log.error(sn + "���ʱ���ʽ����ȷ:" + qhRet_detailsRes.getComplete_time());
											}
										}
										bankrecordVO.setRemark(qhRet_detailsRes.getRemark());//��ע
										bankrecordVO.setRetcode(qhRet_detailsRes.getRet_code());//������
										bankrecordVO.setErrmsg(qhRet_detailsRes.getErr_msg());//�����ı�
										
										bankrecordVO.setShopnum(bsVO.getShopnum());//�̻���
										bankrecordVO.setCountyid(bsVO.getCountyid());//�ֹ�˾
										bankrecordVO.setCreatdate(new Date());//����ʱ��
										
										bankrecordVO.setRecordinfo(recordinfo);//������Ϣ
										bankrecordVO.setRecordstate(recordstate);//����״̬
										
										bankrecordBO.doCreate(bankrecordVO);
									}
								}
							}
						}
						queCount++;
					}
				} catch (Exception e) {
					log.error(e.getMessage());
					e.printStackTrace();
					log.info("========�쳣===============������̻���Ϊ========"+bsVO.getShopnum());
					continue;
				}
			}
				
			
			BankrecordsumBO bankrecordsumBO = (BankrecordsumBO)BOFactory.build(BankrecordsumBO.class,user);
			BankrecordsumVO bankrecordsumVO = new BankrecordsumVO();
			bankrecordsumVO.setSuccesscount(successcount);
			bankrecordsumVO.setFailurecount(failurecount);
			bankrecordsumVO.setAmterrcount(amterrcount);
			bankrecordsumVO.setLocalamt(localamt);
			bankrecordsumVO.setBankamt(bankamt/100);
			bankrecordsumVO.setRecordate(recordate);
			bankrecordsumVO.setCreatdate(creatdate);
			
			int zeroCount = 0;			
			if(successcount.longValue() == 0 ){
				zeroCount++;
			}
			if(failurecount.longValue() == 0 ){
				zeroCount++;
			}
			if(amterrcount.longValue() == 0 ){
				zeroCount++;
			}
			if(localamt.longValue() == 0 ){
				zeroCount++;
			}
			if(bankamt.doubleValue() == 0 ){
				zeroCount++;
			}			
			if(zeroCount != 5){
				bankrecordsumBO.doCreate(bankrecordsumVO);
			}
		}
		
	}

}
