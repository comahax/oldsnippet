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
 * ��Ȩ������
 * ���ĵ��İ�Ȩ����ݺ�����֧���������޹�˾���С�
 * δ���ù��ݺ�����֧���������޹�˾��������׼����������������ġ����á�������ĵ���
 */


public class BankUniteProcess {
	
		private static Log log = LogFactory.getLog(BankUniteProcess.class);
		
		//���Ի�������ַ
		private static final String SERVER_URL = "http://59.41.103.98:9080/PDS/ProcessServlet";
		/**
		 * ��֤ǩ����Ϣ
		 */
		private boolean verifySign(String strXML) {
			//ǩ��
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
		 * ����ǩ��
		 * comment here
		 * @param strData
		 * @return
		 * @since gnete-ora 0.0.0.1
		 */
		private String signMsg(String strData) {
			String strRnt = "";
			//ǩ��
			Crypt  crypt = new Crypt( );
			String pathPfx = System.getProperty("user.dir")+"\\data\\bankunite\\TESTUSER.pfx";
//			String pathPfx = "D:\\pdscert\\ORA@TEST1.pfx";
			String strMsg = strData.replaceAll("<SIGNED_MSG></SIGNED_MSG>", "");
			System.out.println("ǩ��ԭ��:"+strMsg);
			if (crypt.SignMsg(strMsg, pathPfx, "123456")) {			
				String signedMsg = crypt.getLastSignMsg();
				strRnt = strData.replaceAll("<SIGNED_MSG></SIGNED_MSG>", "<SIGNED_MSG>"+signedMsg+"</SIGNED_MSG>");
				System.out.println("�����ױ���:"+strRnt);
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
//				sb.append("<TRANS_DETAIL><SN>").append((i+1)+"").append("</SN><E_USER_CODE/><BANK_CODE>105</BANK_CODE><ACCOUNT_TYPE>00</ACCOUNT_TYPE><ACCOUNT_NO>60138270140042110025555</ACCOUNT_NO><ACCOUNT_NAME>����6666</ACCOUNT_NAME><PROVINCE>�㶫</PROVINCE><CITY>����</CITY><BANK_NAME>����</BANK_NAME><ACCOUNT_PROP>0</ACCOUNT_PROP><AMOUNT>1</AMOUNT><CURRENCY>CNY</CURRENCY><PROTOCOL/><PROTOCOL_USERID/><ID_TYPE/><ID/><TEL/><CUST_USERID/><REMARK>��������</REMARK></TRANS_DETAIL>");
				sb.append("<TRANS_DETAIL><SN>").append((i+1)+"").append("</SN><BANK_CODE>105</BANK_CODE><ACCOUNT_NO>60138270140042110025555</ACCOUNT_NO><ACCOUNT_NAME>����6666</ACCOUNT_NAME><AMOUNT>1</AMOUNT><REMARK>��������</REMARK></TRANS_DETAIL>");
			}
			sb.append(strEnd);
			return sb.toString();
		}
		
		/**
		 * ��������
		 * comment here
		 * @since gnete-ora 0.0.0.1
		 */
		private void PayReq( ) {
			String req = System.currentTimeMillis()+"";
//			req="1237";
			//������
			String strSendData = "<?xml version=\"1.0\" encoding=\"GBK\"?><GZELINK><INFO><TRX_CODE>100002</TRX_CODE><VERSION>04</VERSION><DATA_TYPE>2</DATA_TYPE><LEVEL>0</LEVEL><USER_NAME>operator</USER_NAME><USER_PASS>1</USER_PASS><REQ_SN>"+ req +"</REQ_SN><SIGNED_MSG></SIGNED_MSG></INFO><BODY><TRANS_SUM><BUSINESS_CODE>00600</BUSINESS_CODE><MERCHANT_ID>001053110000001</MERCHANT_ID><SUBMIT_TIME>20090416120000</SUBMIT_TIME><TOTAL_ITEM>2</TOTAL_ITEM><TOTAL_SUM>1000000001</TOTAL_SUM></TRANS_SUM><TRANS_DETAILS><TRANS_DETAIL><SN>0001</SN><E_USER_CODE/><BANK_CODE>105</BANK_CODE><ACCOUNT_TYPE>00</ACCOUNT_TYPE><ACCOUNT_NO>60138270140042110021</ACCOUNT_NO><ACCOUNT_NAME>����</ACCOUNT_NAME><PROVINCE>�㶫</PROVINCE><CITY>����</CITY><BANK_NAME>����</BANK_NAME><ACCOUNT_PROP>0</ACCOUNT_PROP><AMOUNT>1000000000</AMOUNT><CURRENCY>CNY</CURRENCY><PROTOCOL/><PROTOCOL_USERID/><ID_TYPE/><ID/><TEL/><CUST_USERID/><REMARK>��������</REMARK></TRANS_DETAIL><TRANS_DETAIL><SN>0002</SN><E_USER_CODE/><BANK_CODE>105</BANK_CODE><ACCOUNT_TYPE>00</ACCOUNT_TYPE><ACCOUNT_NO>324354546464</ACCOUNT_NO><ACCOUNT_NAME>����</ACCOUNT_NAME><PROVINCE>�㶫</PROVINCE><CITY>����</CITY><BANK_NAME>����</BANK_NAME><ACCOUNT_PROP>0</ACCOUNT_PROP><AMOUNT>1</AMOUNT><CURRENCY>CNY</CURRENCY><PROTOCOL/><PROTOCOL_USERID/><ID_TYPE/><ID/><TEL/><CUST_USERID/><REMARK>��������</REMARK></TRANS_DETAIL></TRANS_DETAILS></BODY></GZELINK>";
			HttpClient httpClient = new HttpClient( );
			//url
			PostMethod postMethod =
				new PostMethod(SERVER_URL);
			//���ñ���
			httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"GBK");
			
			strSendData = this.signMsg(strSendData);
			
			postMethod.setRequestBody(strSendData);
			try {
				long start = System.currentTimeMillis();
				//ִ��getMethod
				int statusCode = httpClient.executeMethod(postMethod);
//				System.out.println("cost:"+(System.currentTimeMillis()-start));
				//ʧ��
				if (statusCode != HttpStatus.SC_OK) {
					log.error(
						"Method failed: " + postMethod.getStatusLine());
					//��ȡ���� 
					byte[] responseBody = postMethod.getResponseBody();
					//��������
					String strResp = new String(responseBody, "GBK");
					log.error(strResp);				
				}
				else {
//					//��ȡ���� 
					byte[] responseBody = postMethod.getResponseBody();
//					
					String strResp = new String(responseBody, "GBK");
					System.out.println("����������:" + strResp);
					//��ǩ
					if (this.verifySign(strResp)) {
						log.info("��ǩ��ȷ��������������صı���");
					}
				}
				System.out.println("cost:"+(System.currentTimeMillis()-start));
			} catch (HttpException e) {
				//�����������쳣��������Э�鲻�Ի��߷��ص�����������
				log.error("Please check your provided http address!", e);
				e.printStackTrace( );
			} catch (IOException e) {
				//���������쳣
				log.error(e);
			} catch (Exception e) {
				log.error(e);
			} finally {
				//�ͷ�����
				postMethod.releaseConnection();
			}
			
		}
		
		/**
		 * ������֤
		 * comment here
		 * @since gnete-ora 0.0.0.1
		 */
		private void ValidReq( ) {
			String req = System.currentTimeMillis()+"";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String strNow = sdf.format(new Date());
			String strSum = "2";
			//������
			String strSendData = "<?xml version=\"1.0\" encoding=\"GBK\"?><GZELINK><INFO><TRX_CODE>100003</TRX_CODE><VERSION>04</VERSION><DATA_TYPE>2</DATA_TYPE><LEVEL>0</LEVEL><USER_NAME>tkvalid</USER_NAME><USER_PASS>1</USER_PASS><REQ_SN>"+ req +"</REQ_SN><SIGNED_MSG></SIGNED_MSG></INFO><BODY><TRANS_SUM><BUSINESS_CODE>10600</BUSINESS_CODE><MERCHANT_ID>256983416413545</MERCHANT_ID><SUBMIT_TIME>"+strNow+"</SUBMIT_TIME><TOTAL_ITEM>1</TOTAL_ITEM><TOTAL_SUM>"+strSum+"</TOTAL_SUM></TRANS_SUM><TRANS_DETAILS><TRANS_DETAIL><SN>0001</SN><E_USER_CODE/><BANK_CODE>105</BANK_CODE><ACCOUNT_TYPE>00</ACCOUNT_TYPE><ACCOUNT_NO>60138270140042110-021</ACCOUNT_NO><ACCOUNT_NAME>����</ACCOUNT_NAME><PROVINCE>�㶫</PROVINCE><CITY>����</CITY><BANK_NAME>����</BANK_NAME><ACCOUNT_PROP>0</ACCOUNT_PROP><AMOUNT>"+strSum+"</AMOUNT><CURRENCY>CNY</CURRENCY><PROTOCOL/><PROTOCOL_USERID/><ID_TYPE/><ID/><TEL/><CUST_USERID/><REMARK>��������</REMARK></TRANS_DETAIL></TRANS_DETAILS></BODY></GZELINK>";		
			HttpClient httpClient = new HttpClient( );
			//url
			PostMethod postMethod =
				new PostMethod(SERVER_URL);
			//���ñ���
			httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"GBK");
			
			strSendData = this.signMsg(strSendData);

			log.info(strSendData);
			
			postMethod.setRequestBody(strSendData);
			try {
				long start = System.currentTimeMillis();
				//ִ��getMethod
				int statusCode = httpClient.executeMethod(postMethod);
//				System.out.println("cost:"+(System.currentTimeMillis()-start));
				//ʧ��
				if (statusCode != HttpStatus.SC_OK) {
					log.error(
						"Method failed: " + postMethod.getStatusLine());
					//��ȡ���� 
					byte[] responseBody = postMethod.getResponseBody();
					//��������
					String strResp = new String(responseBody, "GBK");
					log.error(strResp);				
				}
				else {
					//��ȡ���� 
					byte[] responseBody = postMethod.getResponseBody();
					
					String strResp = new String(responseBody, "GBK");
					log.info("����������:" + strResp);
					//��ǩ
					if (this.verifySign(strResp)) {
						log.info("��ǩ��ȷ��������������صı���");
					}
				}
				System.out.println("cost:"+(System.currentTimeMillis()-start));
			} catch (HttpException e) {
				//�����������쳣��������Э�鲻�Ի��߷��ص�����������
				log.error("Please check your provided http address!", e);
				e.printStackTrace( );
			} catch (IOException e) {
				//���������쳣
				log.error(e);
			} catch (Exception e) {
				log.error(e);
			} finally {
				//�ͷ�����
				postMethod.releaseConnection();
			}
			
		}
		
		public static void main(String[] args) {
			BankUniteProcess tp = new BankUniteProcess( );
			tp.PayReq( );
		}
	}
