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
		//根据地市标识查询银行商户信息表 (FX_CB_BANKSHOP)获取银行商户信息
		Bankshop bankshopBO = (BankshopBO)BOFactory.build(BankshopBO.class,user);
		BankshopDBParam bankshopDBParam = new BankshopDBParam();
		bankshopDBParam.set_se_cityid(user.getCityid());		
		DataPackage bankshopDP = bankshopBO.doQuery(bankshopDBParam);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
		
		//读取配置文件的内容
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
			//前一天
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
			
			QhInfoReq info = new QhInfoReq();				//封装头部
			info.setTrx_code("200002");						//交易代码
			info.setVersion("03");							//版本
			info.setData_type(Short.valueOf((short)2));		//数据格式
	        info.setReq_sn("");								//交易流水号
	        info.setUser_name(xml_user);					//用户名
	        info.setUser_pass(xml_pwd);						//用户密码
	        info.setSigned_msg("");							//签名信息
	        
	        Long successcount = 0L;							//成功数量
	        Long failurecount = 0L;							//失败数量
	        Long amterrcount = 0L;							//金额错误数量
	        Double localamt = 0D;							//本地总金额
	        Double bankamt = 0D;							//银联总金额
	        java.util.Date recordate = null;				//交易日期
	        java.util.Date creatdate = new Date();			//录入时间
			
			while(it.hasNext()){
				BankshopVO bsVO=(BankshopVO)it.next();
				try {
					log.info("============开始处理的商户号为==================="+bsVO.getShopnum());
					
					//逐条进行封装参数调用【当日或历史查询请求】接口查询当天交易记录				
					QhQuery_transReq query_trans = new QhQuery_transReq();	//封装body
					query_trans.setMerchant_id(bsVO.getShopnum());			//商户ID
					query_trans.setQuery_sn("");							//要查询的交易流水
					query_trans.setBegin_date(begin_date);					//开始日期
					query_trans.setEnd_date(end_date);						//结束日期
					query_trans.setPage_num(Integer.valueOf(1));			//页码
					query_trans.setPage_size(Integer.valueOf(page_size));	//每页记录数
					query_trans.setResult_type((short)1);					//查询类型
					query_trans.setNeed_detail((short)1);					//是否查询明细
					query_trans.setQuery_remark("");						//查询备注
					
					int page_sum = 1;
					int queCount = 1;//当前查询页数
					
					QhReq req = new QhReq();				
					req.setInfo(info);
					req.setQuery_trans(query_trans);
					BankUniteProcessCom bankUniteProcessCom = new BankUniteProcessCom();
					bankUniteProcessCom.initPropertie(user.getCityid());
					bankUniteProcessCom.setLog(log);
					
					while(queCount <= page_sum){
						query_trans.setPage_num(queCount);			//页码
						QhRes qhRes = (QhRes)bankUniteProcessCom.sendMsg(req, true, QhRes.class);				
						if(page_sum == 1){
							page_sum = qhRes.getQuery_trans().getPage_sum().intValue();
						}
						log.info("商户号："+bsVO.getShopnum() + "，当前查询的页数：" + queCount);
						
						if(qhRes != null && !"".equals(qhRes) && qhRes.getRet_details() != null 
								&& !"".equals(qhRes.getRet_details()) && qhRes.getRet_details().size() > 0){
							for(int i=0 ; i<qhRes.getRet_details().size() ; i++){
								QhRet_detailsRes qhRet_detailsRes = qhRes.getRet_details().get(i);
								String sn = qhRet_detailsRes.getSn();//记录序号
								if(sn != null && !"".equals(sn)){
									//对账信息与对账状态取值
									BankdeductBO bankdeductBO = (BankdeductBO)BOFactory.build(BankdeductBO.class,user);
									BankdeductDBParam bankdeductDBParam = new BankdeductDBParam();
									bankdeductDBParam.set_ne_deductid(Long.parseLong(sn));
									DataPackage bankdeductDP = bankdeductBO.doQuery(bankdeductDBParam);
									String recordinfo = null;//对账信息
									Short recordstate = null;//对账状态
									BankdeductVO bankdeductVO = null;
									if(bankdeductDP.getRowCount() > 0){
										bankdeductVO = (BankdeductVO)bankdeductDP.getDatas().get(0);
									}
									if(bankdeductVO == null)
										continue;
									bankdeductVO.setDeductamt(0D);
									if("0000".equals(qhRet_detailsRes.getRet_code())){
										//当返回码为0000是显示成功
										recordinfo = "成功/成功；" + qhRet_detailsRes.getAmount()/100 + "/" + 
													bankdeductVO.getDeductamt() + "；";
									}else{
										recordinfo = "失败/失败；" + qhRet_detailsRes.getAmount()/100 + "/" + 
													bankdeductVO.getDeductamt() + "；";
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
									
									//根据返回的记录序号（SN）查询银行划扣交易记录表(FX_SW_BANKRECORD)
									BankrecordBO bankrecordBO = (BankrecordBO)BOFactory.build(BankrecordBO.class,user);
									BankrecordDBParam bankrecordDBParam = new BankrecordDBParam();
									bankrecordDBParam.set_ne_deductid(sn);//记录序号
									DataPackage bankrecordDP = bankrecordBO.doQuery(bankrecordDBParam);
									if(bankrecordDP.getRowCount()>0){//更新
										BankrecordVO bankrecordVO = (BankrecordVO)bankrecordDP.getDatas().get(0);
										bankrecordVO.setOrafileid(""+qhRet_detailsRes.getOrafile_id());//
										
										//bankrecordVO.setDeductid(Long.parseLong(sn));//记录序号
										bankrecordVO.setAccount(qhRet_detailsRes.getAccount());//账号
										bankrecordVO.setAccountname(qhRet_detailsRes.getAccount_name());//账号名
										bankrecordVO.setAmount(qhRet_detailsRes.getAmount());//金额
										bankrecordVO.setCustuserid(qhRet_detailsRes.getCust_userid());//自定义用户号
										if(qhRet_detailsRes.getComplete_time() != null && !"".equals(qhRet_detailsRes.getComplete_time())) {
											if (qhRet_detailsRes.getComplete_time().length() == 14) {
												bankrecordVO.setCompletetime(sdf.parse(qhRet_detailsRes.getComplete_time()));//完成时间
											} else if (qhRet_detailsRes.getComplete_time().length() == 8) {
												bankrecordVO.setCompletetime(sdfDate.parse(qhRet_detailsRes.getComplete_time()));//完成时间
											} else {
												log.error(sn + "完成时间格式不正确:" + qhRet_detailsRes.getComplete_time());
											}
										}
										bankrecordVO.setRemark(qhRet_detailsRes.getRemark());//备注
										bankrecordVO.setRetcode(qhRet_detailsRes.getRet_code());//返回码
										bankrecordVO.setErrmsg(qhRet_detailsRes.getErr_msg());//错误文本
										
										bankrecordVO.setShopnum(bsVO.getShopnum());//商户号
										bankrecordVO.setCountyid(bsVO.getCountyid());//分公司
										//bankrecordVO.setCreatdate(new Date());//创建时间
										
										bankrecordVO.setRecordinfo(recordinfo);//对账信息
										bankrecordVO.setRecordstate(recordstate);//对账状态
										
										bankrecordBO.doUpdate(bankrecordVO);
									}else{//新增
										BankrecordVO bankrecordVO = new BankrecordVO();
										bankrecordVO.setOrafileid(""+qhRet_detailsRes.getOrafile_id());//
										
										bankrecordVO.setDeductid(Long.parseLong(sn));//记录序号
										bankrecordVO.setAccount(qhRet_detailsRes.getAccount());//账号
										bankrecordVO.setAccountname(qhRet_detailsRes.getAccount_name());//账号名
										bankrecordVO.setAmount(qhRet_detailsRes.getAmount().doubleValue());//金额
										bankrecordVO.setCustuserid(qhRet_detailsRes.getCust_userid());//自定义用户号
										if(qhRet_detailsRes.getComplete_time() != null && !"".equals(qhRet_detailsRes.getComplete_time())) {
											if (qhRet_detailsRes.getComplete_time().length() == 14) {
												bankrecordVO.setCompletetime(sdf.parse(qhRet_detailsRes.getComplete_time()));//完成时间
											} else if (qhRet_detailsRes.getComplete_time().length() == 8) {
												bankrecordVO.setCompletetime(sdfDate.parse(qhRet_detailsRes.getComplete_time()));//完成时间
											} else {
												log.error(sn + "完成时间格式不正确:" + qhRet_detailsRes.getComplete_time());
											}
										}
										bankrecordVO.setRemark(qhRet_detailsRes.getRemark());//备注
										bankrecordVO.setRetcode(qhRet_detailsRes.getRet_code());//返回码
										bankrecordVO.setErrmsg(qhRet_detailsRes.getErr_msg());//错误文本
										
										bankrecordVO.setShopnum(bsVO.getShopnum());//商户号
										bankrecordVO.setCountyid(bsVO.getCountyid());//分公司
										bankrecordVO.setCreatdate(new Date());//创建时间
										
										bankrecordVO.setRecordinfo(recordinfo);//对账信息
										bankrecordVO.setRecordstate(recordstate);//对账状态
										
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
					log.info("========异常===============处理的商户号为========"+bsVO.getShopnum());
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
