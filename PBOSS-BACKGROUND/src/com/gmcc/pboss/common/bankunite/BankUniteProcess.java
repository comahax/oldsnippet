package com.gmcc.pboss.common.bankunite;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.EasyLink.security.Crypt;

/*
 * 版权声明：
 * 此文档的版权归广州好易联支付网络有限公司所有。
 * 未征得广州好易联支付网络有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */


public class BankUniteProcess {
	
		private static Log log = LogFactory.getLog(BankUniteProcess.class);
		
		//测试机公网地址
		private static final String SERVER_URL = "http://59.41.103.98:9080/PDS/ProcessServlet";
		/**
		 * 验证签名信息
		 */
		private boolean verifySign(String strXML) {
			//签名
			Crypt  crypt = new Crypt( );
			String pathCer = System.getProperty("user.dir")+"\\data\\bankunite\\TESTUSER.cer";
//			String pathCer = "D:\\pdscert\\ORA@TEST1.cer";
			int iStart = strXML.indexOf("<SIGNED_MSG>");
			if (iStart != -1) {
				int end = strXML.indexOf("</SIGNED_MSG>");
				String signedMsg = strXML.substring(iStart+12, end);
				String strMsg = strXML.substring(0, iStart) + strXML.substring(end+13);
				log.debug(signedMsg);
				log.debug(strMsg);
				
				if (crypt.VerifyMsg(signedMsg, strMsg, pathCer)) {
					log.info("verify ok");
					return true;
				}
				else {
					log.error(crypt.getLastErrMsg());
					log.error("verify error");
					return false;
				}
			}
			return true;
		}
		
		/**
		 * 数据签名
		 * comment here
		 * @param strData
		 * @return
		 * @since gnete-ora 0.0.0.1
		 */
		private String signMsg(String strData) {
			String strRnt = "";
			//签名
			Crypt  crypt = new Crypt( );
			String pathPfx = System.getProperty("user.dir")+"\\data\\bankunite\\TESTUSER.pfx";
//			String pathPfx = "D:\\pdscert\\ORA@TEST1.pfx";
			String strMsg = strData.replaceAll("<SIGNED_MSG></SIGNED_MSG>", "");
			System.out.println("签名原文:"+strMsg);
			if (crypt.SignMsg(strMsg, pathPfx, "123456")) {			
				String signedMsg = crypt.getLastSignMsg();
				strRnt = strData.replaceAll("<SIGNED_MSG></SIGNED_MSG>", "<SIGNED_MSG>"+signedMsg+"</SIGNED_MSG>");
				System.out.println("请求交易报文:"+strRnt);
			}
			else {
				log.error(crypt.getLastErrMsg());
				strRnt = strData;
			}
			return strRnt;
		}
		
		private String getContent(String strSendData, String strEnd, int cnt) {
			StringBuffer sb = new StringBuffer( );
			sb.append(strSendData);
			for (int i=0; i<cnt; i++) {
//				sb.append("<TRANS_DETAIL><SN>").append((i+1)+"").append("</SN><E_USER_CODE/><BANK_CODE>105</BANK_CODE><ACCOUNT_TYPE>00</ACCOUNT_TYPE><ACCOUNT_NO>60138270140042110025555</ACCOUNT_NO><ACCOUNT_NAME>张三6666</ACCOUNT_NAME><PROVINCE>广东</PROVINCE><CITY>广州</CITY><BANK_NAME>建行</BANK_NAME><ACCOUNT_PROP>0</ACCOUNT_PROP><AMOUNT>1</AMOUNT><CURRENCY>CNY</CURRENCY><PROTOCOL/><PROTOCOL_USERID/><ID_TYPE/><ID/><TEL/><CUST_USERID/><REMARK>保险理赔</REMARK></TRANS_DETAIL>");
				sb.append("<TRANS_DETAIL><SN>").append((i+1)+"").append("</SN><BANK_CODE>105</BANK_CODE><ACCOUNT_NO>60138270140042110025555</ACCOUNT_NO><ACCOUNT_NAME>张三6666</ACCOUNT_NAME><AMOUNT>1</AMOUNT><REMARK>保险理赔</REMARK></TRANS_DETAIL>");
			}
			sb.append(strEnd);
			return sb.toString();
		}
		
		/**
		 * 测试请求
		 * comment here
		 * @since gnete-ora 0.0.0.1
		 */
		private void PayReq( ) {
			String req = System.currentTimeMillis()+"";
//			req="1237";
			//请求报文
			String strSendData = "<?xml version=\"1.0\" encoding=\"GBK\"?><GZELINK><INFO><TRX_CODE>100002</TRX_CODE><VERSION>04</VERSION><DATA_TYPE>2</DATA_TYPE><LEVEL>0</LEVEL><USER_NAME>operator</USER_NAME><USER_PASS>1</USER_PASS><REQ_SN>"+ req +"</REQ_SN><SIGNED_MSG></SIGNED_MSG></INFO><BODY><TRANS_SUM><BUSINESS_CODE>00600</BUSINESS_CODE><MERCHANT_ID>001053110000001</MERCHANT_ID><SUBMIT_TIME>20090416120000</SUBMIT_TIME><TOTAL_ITEM>2</TOTAL_ITEM><TOTAL_SUM>1000000001</TOTAL_SUM></TRANS_SUM><TRANS_DETAILS><TRANS_DETAIL><SN>0001</SN><E_USER_CODE/><BANK_CODE>105</BANK_CODE><ACCOUNT_TYPE>00</ACCOUNT_TYPE><ACCOUNT_NO>60138270140042110021</ACCOUNT_NO><ACCOUNT_NAME>张三</ACCOUNT_NAME><PROVINCE>广东</PROVINCE><CITY>广州</CITY><BANK_NAME>建行</BANK_NAME><ACCOUNT_PROP>0</ACCOUNT_PROP><AMOUNT>1000000000</AMOUNT><CURRENCY>CNY</CURRENCY><PROTOCOL/><PROTOCOL_USERID/><ID_TYPE/><ID/><TEL/><CUST_USERID/><REMARK>保险理赔</REMARK></TRANS_DETAIL><TRANS_DETAIL><SN>0002</SN><E_USER_CODE/><BANK_CODE>105</BANK_CODE><ACCOUNT_TYPE>00</ACCOUNT_TYPE><ACCOUNT_NO>324354546464</ACCOUNT_NO><ACCOUNT_NAME>李四</ACCOUNT_NAME><PROVINCE>广东</PROVINCE><CITY>广州</CITY><BANK_NAME>建行</BANK_NAME><ACCOUNT_PROP>0</ACCOUNT_PROP><AMOUNT>1</AMOUNT><CURRENCY>CNY</CURRENCY><PROTOCOL/><PROTOCOL_USERID/><ID_TYPE/><ID/><TEL/><CUST_USERID/><REMARK>保险理赔</REMARK></TRANS_DETAIL></TRANS_DETAILS></BODY></GZELINK>";
			HttpClient httpClient = new HttpClient( );
			//url
			PostMethod postMethod =
				new PostMethod(SERVER_URL);
			//设置编码
			httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"GBK");
			
			strSendData = this.signMsg(strSendData);
			
			postMethod.setRequestBody(strSendData);
			try {
				long start = System.currentTimeMillis();
				//执行getMethod
				int statusCode = httpClient.executeMethod(postMethod);
//				System.out.println("cost:"+(System.currentTimeMillis()-start));
				//失败
				if (statusCode != HttpStatus.SC_OK) {
					log.error(
						"Method failed: " + postMethod.getStatusLine());
					//读取内容 
					byte[] responseBody = postMethod.getResponseBody();
					//处理内容
					String strResp = new String(responseBody, "GBK");
					log.error(strResp);				
				}
				else {
//					//读取内容 
					byte[] responseBody = postMethod.getResponseBody();
//					
					String strResp = new String(responseBody, "GBK");
					System.out.println("服务器返回:" + strResp);
					//验签
					if (this.verifySign(strResp)) {
						log.info("验签正确，处理服务器返回的报文");
					}
				}
				System.out.println("cost:"+(System.currentTimeMillis()-start));
			} catch (HttpException e) {
				//发生致命的异常，可能是协议不对或者返回的内容有问题
				log.error("Please check your provided http address!", e);
				e.printStackTrace( );
			} catch (IOException e) {
				//发生网络异常
				log.error(e);
			} catch (Exception e) {
				log.error(e);
			} finally {
				//释放连接
				postMethod.releaseConnection();
			}
			
		}
		
		/**
		 * 测试验证
		 * comment here
		 * @since gnete-ora 0.0.0.1
		 */
		private void ValidReq( ) {
			String req = System.currentTimeMillis()+"";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String strNow = sdf.format(new Date());
			String strSum = "2";
			//请求报文
			String strSendData = "<?xml version=\"1.0\" encoding=\"GBK\"?><GZELINK><INFO><TRX_CODE>100003</TRX_CODE><VERSION>04</VERSION><DATA_TYPE>2</DATA_TYPE><LEVEL>0</LEVEL><USER_NAME>tkvalid</USER_NAME><USER_PASS>1</USER_PASS><REQ_SN>"+ req +"</REQ_SN><SIGNED_MSG></SIGNED_MSG></INFO><BODY><TRANS_SUM><BUSINESS_CODE>10600</BUSINESS_CODE><MERCHANT_ID>256983416413545</MERCHANT_ID><SUBMIT_TIME>"+strNow+"</SUBMIT_TIME><TOTAL_ITEM>1</TOTAL_ITEM><TOTAL_SUM>"+strSum+"</TOTAL_SUM></TRANS_SUM><TRANS_DETAILS><TRANS_DETAIL><SN>0001</SN><E_USER_CODE/><BANK_CODE>105</BANK_CODE><ACCOUNT_TYPE>00</ACCOUNT_TYPE><ACCOUNT_NO>60138270140042110-021</ACCOUNT_NO><ACCOUNT_NAME>张三</ACCOUNT_NAME><PROVINCE>广东</PROVINCE><CITY>广州</CITY><BANK_NAME>建行</BANK_NAME><ACCOUNT_PROP>0</ACCOUNT_PROP><AMOUNT>"+strSum+"</AMOUNT><CURRENCY>CNY</CURRENCY><PROTOCOL/><PROTOCOL_USERID/><ID_TYPE/><ID/><TEL/><CUST_USERID/><REMARK>保险理赔</REMARK></TRANS_DETAIL></TRANS_DETAILS></BODY></GZELINK>";		
			HttpClient httpClient = new HttpClient( );
			//url
			PostMethod postMethod =
				new PostMethod(SERVER_URL);
			//设置编码
			httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"GBK");
			
			strSendData = this.signMsg(strSendData);

			log.info(strSendData);
			
			postMethod.setRequestBody(strSendData);
			try {
				long start = System.currentTimeMillis();
				//执行getMethod
				int statusCode = httpClient.executeMethod(postMethod);
//				System.out.println("cost:"+(System.currentTimeMillis()-start));
				//失败
				if (statusCode != HttpStatus.SC_OK) {
					log.error(
						"Method failed: " + postMethod.getStatusLine());
					//读取内容 
					byte[] responseBody = postMethod.getResponseBody();
					//处理内容
					String strResp = new String(responseBody, "GBK");
					log.error(strResp);				
				}
				else {
					//读取内容 
					byte[] responseBody = postMethod.getResponseBody();
					
					String strResp = new String(responseBody, "GBK");
					log.info("服务器返回:" + strResp);
					//验签
					if (this.verifySign(strResp)) {
						log.info("验签正确，处理服务器返回的报文");
					}
				}
				System.out.println("cost:"+(System.currentTimeMillis()-start));
			} catch (HttpException e) {
				//发生致命的异常，可能是协议不对或者返回的内容有问题
				log.error("Please check your provided http address!", e);
				e.printStackTrace( );
			} catch (IOException e) {
				//发生网络异常
				log.error(e);
			} catch (Exception e) {
				log.error(e);
			} finally {
				//释放连接
				postMethod.releaseConnection();
			}
			
		}
		
		public static void main(String[] args) {
			BankUniteProcess tp = new BankUniteProcess( );
			tp.PayReq( );
		}
	}
