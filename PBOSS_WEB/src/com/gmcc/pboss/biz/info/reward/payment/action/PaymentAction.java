/**
 * auto-generated code
 * 
 */
package com.gmcc.pboss.biz.info.reward.payment.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import com.gmcc.pboss.biz.info.reward.payment.model.Payment;
import com.gmcc.pboss.biz.info.reward.payment.service.PaymentService;
import com.gmcc.pboss.biz.info.reward.payment.support.PaymentQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.file.bean.ServerInfoBean;
import com.gmcc.pboss.common.file.util.FtpAccess;
import com.gmcc.pboss.common.support.QueryParameter;

/**
 * <p>
 * Title: PaymentAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class PaymentAction extends AbstractAction  {
		
	private PaymentQueryParameter parameter;
	private PaymentService paymentService;
	
	private Payment payment;
	private String rewardmonth;//付款月份
	
	private static ResourceBundle rs = null;
	public static String PATH;
	
	public String doStat() {
		this.setTitle(PageLoction.GD_REWARDPRO_PAYMENT);
//		 Payment payment = new Payment();
		//默认查询上个月的数据
		 SimpleDateFormat format = new SimpleDateFormat("yyyyMM"); 
		 Calendar objCalendar = Calendar.getInstance(); 
		 objCalendar.add(Calendar.MONTH, -1); 
		 format.format(objCalendar.getTime());
		 rewardmonth=(format.format(objCalendar.getTime()));
		return SUCCESS; 
	}
	
	public String doAjax() {
		this.setTitle(PageLoction.GD_REWARDPRO_PAYMENT);
		try {
			if (rewardmonth == null){
					//默认查询上个月的数据
					 SimpleDateFormat format = new SimpleDateFormat("yyyyMM"); 
					 Calendar objCalendar = Calendar.getInstance(); 
					 objCalendar.add(Calendar.MONTH, -1); 
					 format.format(objCalendar.getTime());
					 rewardmonth=(format.format(objCalendar.getTime()));
			}
			
			//SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
			
			String downloadFilePath  ="";// service.queryForPublicAffix(getCityid(), String.valueOf(publicParameter.getAdvinfoid()), publicParameter.getAffixid());
			rs = ResourceBundle.getBundle("pathinfo");
			PATH = rs.getString("downloadFile.filePath");
			
			StringBuffer filepath=new StringBuffer("");
			String path = PATH;
			filepath.append(path);
			LoginMember logMem = this.getMember();
			filepath.append("/adt/");
			filepath.append(logMem.getCityid().toLowerCase()+"/");
			filepath.append("src/collect/boss/statements/payment_");
			filepath.append(rewardmonth);
			filepath.append(".gz");
			
			
			downloadFilePath = filepath.toString();
			
			if(downloadFilePath!=null && !"".equals(downloadFilePath)){
				ServerInfoBean ftpInfo = ServerInfoBean.getInstance();
				FtpAccess.doDownloadFile(ftpInfo, downloadFilePath, getResponse());
				return SUCCESS;
			}
		} catch (Exception e) {
			logger.error("CommunicatePlateauAction.doFinishPendingTask:需要下载的文件不存在" );
			e.printStackTrace();
			return ERROR;
		}
		
		return SUCCESS;
	}

	
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public PaymentService getPaymentService() {
		return paymentService;
	}

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public String getRewardmonth() {
		return rewardmonth;
	}

	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}

}
