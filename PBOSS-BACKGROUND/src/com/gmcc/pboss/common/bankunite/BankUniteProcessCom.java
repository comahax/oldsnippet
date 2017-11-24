package com.gmcc.pboss.common.bankunite;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.zip.ZipInputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;

import com.EasyLink.security.Crypt;
import com.gmcc.pboss.common.bankunite.model.base.request.BaseRequest;
import com.gmcc.pboss.common.bankunite.model.base.response.BaseResponse;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;



public class BankUniteProcessCom {
	
	//���Ի�������ַ ѹ��
	private static  String SERVER_URL_COM ;
	//��ѹ��
	private static  String SERVER_URL ;
	//��ȫ��֤�ļ�·��
	private static String TESTUSERCER ;
	private static String TESTUSERPFX ;
	
	private Logger log;
	
	/*static {
		try {
			//��ȡ�����ļ�������
			String proFile = "/DealDataCollectProcess.properties";
			InputStream is = BankUniteProcessCom.class.getResourceAsStream(proFile);
			Properties properties = new Properties();
			
			properties.load(is);
			is.close();

			TESTUSERCER = properties.getProperty("testusercer");
			TESTUSERPFX = properties.getProperty("testuserpfx");
			SERVER_URL_COM = properties.getProperty("server_url_com");
			SERVER_URL = properties.getProperty("server_url");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 

	}*/
	
	public void initPropertie(String cityid) {
		try {
			//��ȡ�����ļ�������
			String proFile = "/DealDataCollectProcess.properties";
			InputStream is = BankUniteProcessCom.class.getResourceAsStream(proFile);
			Properties properties = new Properties();
			
			properties.load(is);
			is.close();

			TESTUSERCER = properties.getProperty("testusercer");
			TESTUSERPFX = properties.getProperty(cityid + "_testuserpfx");
			SERVER_URL_COM = properties.getProperty("server_url_com");
			SERVER_URL = properties.getProperty("server_url");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * ѹ���ַ���Ϊ byte[] �������ʹ��new sun.misc.BASE64Encoder().encodeBuffer(byte[] b)����
	 * ����Ϊ�ַ���
	 * 
	 * @param str ѹ��ǰ���ı�
	 * 
	 * @return
	 */
	private final byte[] compresszip(String str) {
		if (str == null)
			return null;

		byte[] compressed;
		ByteArrayOutputStream out = null;
		java.util.zip.ZipOutputStream zout = null;

		try {
			out = new ByteArrayOutputStream();
			zout = new java.util.zip.ZipOutputStream(out);
			zout.putNextEntry(new java.util.zip.ZipEntry("0"));
			zout.write(str.getBytes());
			zout.closeEntry();
			compressed = out.toByteArray();
		} catch (IOException e) {
			compressed = null;
		} finally {
			if (zout != null) {
				try {
					zout.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}

		return compressed;
	}

	/**
	 * ��ѹ����� byte[] ���ݽ�ѹ��
	 * 
	 * @param compressed
	 *            ѹ����� byte[] ����
	 * @return ��ѹ����ַ���
	 */
	private final String decompresszip(byte[] compressed) {
		if (compressed == null)
			return null;

		ByteArrayOutputStream out = null;
		ByteArrayInputStream in = null;
		ZipInputStream zin = null;
		String decompressed;
		try {
			out = new ByteArrayOutputStream();
			in = new ByteArrayInputStream(compressed);
			zin = new ZipInputStream(in);
			java.util.zip.ZipEntry entry = zin.getNextEntry();
			byte[] buffer = new byte[1024];
			int offset = -1;
			while ((offset = zin.read(buffer)) != -1) {
				out.write(buffer, 0, offset);
			}
			decompressed = out.toString();
		} catch (IOException e) {
			decompressed = null;
		} finally {
			if (zin != null) {
				try {
					zin.close();
				} catch (IOException e) {
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}

		return decompressed;
	} 
	
	/**
	 * ��֤ǩ����Ϣ
	 */
	private boolean verifySign(String strXML) {
		//ǩ��
		Crypt  crypt = new Crypt( );
		String pathCer = TESTUSERCER;
		int iStart = strXML.indexOf("<SIGNED_MSG>");
		if (iStart != -1) {
			int end = strXML.indexOf("</SIGNED_MSG>");
			String signedMsg = strXML.substring(iStart+12, end);
			String strMsg = strXML.substring(0, iStart) + strXML.substring(end+13);
			log.info(signedMsg);
			log.info(strMsg);
			
			if (crypt.VerifyMsg(signedMsg, strMsg, pathCer)) {
				log.info("verify ok");
				return true;
			}
			else {
				log.info(crypt.getLastErrMsg());
				log.info("verify error");
				return false;
			}
		}
		return true;
	}
	
	/**
	 * ѹ������
	 * comment here
	 * @param strData
	 * @param bCompress
	 * @return
	 * @since gnete-pds 0.0.0.1
	 */
	private String compress(String strData, boolean bCompress) {
		String strRnt = strData;
		if (bCompress) {
			strRnt = new sun.misc.BASE64Encoder().encode(this.compresszip(strData));
		}
		return strRnt;
	}
	
	/**
	 * ��ѹ����
	 * comment here
	 * @param strData
	 * @param bCompress
	 * @return 
	 * @since gnete-pds 0.0.0.1
	 */
	private String decompress(String strData, boolean bCompress) {
		String strRnt = strData;
		if (bCompress) {
			try {
				strRnt = this.decompresszip(new sun.misc.BASE64Decoder().decodeBuffer(strData));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return strRnt;
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
		String pathPfx = TESTUSERPFX;
//		pathPfx = "D:\\update\\20090514\\MerCA\\Q26_XINHUA2.pfx";
//		pathPfx = "D:\\update\\20090514\\MerCA\\Q27_XINHUA4.pfx";
//		pathPfx = "D:\\pdscert\\Q51_HTA2.pfx";
		String strMsg = strData.replaceAll("<SIGNED_MSG></SIGNED_MSG>", "");
		log.info("ǩ��ԭ��:"+strMsg);
		if (crypt.SignMsg(strMsg, pathPfx, "123456")) {			
			String signedMsg = crypt.getLastSignMsg();
			strRnt = strData.replaceAll("<SIGNED_MSG></SIGNED_MSG>", "<SIGNED_MSG>"+signedMsg+"</SIGNED_MSG>");
			log.info("�����ױ���:"+strRnt);
		}
		else {
			log.info(crypt.getLastErrMsg());
			strRnt = strData;
		}
		return strRnt;
	}
	
	private String getContent(String strSendData, String strEnd, int cnt) {
		StringBuffer sb = new StringBuffer( );
		sb.append(strSendData);
		for (int i=0; i<cnt; i++) {
//			sb.append("<TRANS_DETAIL><SN>").append((i+1)+"").append("</SN><E_USER_CODE/><BANK_CODE>105</BANK_CODE><ACCOUNT_TYPE>00</ACCOUNT_TYPE><ACCOUNT_NO>60138270140042110025555</ACCOUNT_NO><ACCOUNT_NAME>����6666</ACCOUNT_NAME><PROVINCE>�㶫</PROVINCE><CITY>����</CITY><BANK_NAME>����</BANK_NAME><ACCOUNT_PROP>0</ACCOUNT_PROP><AMOUNT>1</AMOUNT><CURRENCY>CNY</CURRENCY><PROTOCOL/><PROTOCOL_USERID/><ID_TYPE/><ID/><TEL/><CUST_USERID/><REMARK>��������</REMARK></TRANS_DETAIL>");
			sb.append("<TRANS_DETAIL><SN>").append((i+1)+"").append("</SN><BANK_CODE>105</BANK_CODE><ACCOUNT_NO>60138270140042110025555</ACCOUNT_NO><ACCOUNT_NAME>����6666</ACCOUNT_NAME><AMOUNT>1</AMOUNT><REMARK>��������</REMARK></TRANS_DETAIL>");
		}
		sb.append(strEnd);
		return sb.toString();
	}
	
	/**
	 * 
	 * comment here
	 * @param bCompress �Ƿ�ѹ��
	 * @since gnete-pds 0.0.0.1
	 */
	private String PayReq(boolean bCompress,String msg) throws Exception{
		String req = System.currentTimeMillis()+"";
//		req="1237";
		//������
		String strSendData = msg;
		log.info("������:" + msg);
		//���ر���
		String strBackData = null;
		HttpClient httpClient = new HttpClient( );
		//url
		PostMethod postMethod = null;
		if (bCompress) {
			postMethod = new PostMethod(SERVER_URL_COM);
		}
		else {
			postMethod = new PostMethod(SERVER_URL);
		}
		//���ñ���
		httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"GBK");
		
		strSendData = this.signMsg(strSendData);
		if (bCompress) {
			strSendData = this.compress(strSendData, bCompress);
		}
		postMethod.setRequestBody(strSendData);
		try {
			long start = System.currentTimeMillis();
			//ִ��getMethod
			int statusCode = httpClient.executeMethod(postMethod);
			log.info("cost:"+(System.currentTimeMillis()-start));
			//ʧ��
			if (statusCode != HttpStatus.SC_OK) {
				//��ȡ���� 
				byte[] responseBody = postMethod.getResponseBody();
				//��������
				String strResp = new String(responseBody, "GBK");
				
				strBackData = strResp;
				//System.out.println(strResp);				
			}
			else {
//				//��ȡ���� 
				byte[] responseBody = postMethod.getResponseBody();
//				
				String strResp = new String(responseBody, "GBK");
				log.info("����������:" + strResp);
				//
				if (bCompress) {
					
					strBackData=this.decompress(strResp, bCompress);					
					log.info("��ԭ:"+this.decompress(strResp, bCompress));
				}				
				//��ǩ
				if (!this.verifySign(strResp)) {
					
					//throw new Exception("��ǩ��ȷ��������������صı���");
					//System.out.println("��ǩ��ȷ��������������صı���");
				}
			}
			log.info("cost:"+(System.currentTimeMillis()-start));
		} catch (HttpException e) {
			//�����������쳣��������Э�鲻�Ի��߷��ص�����������
			e.printStackTrace( );
		} catch (IOException e) {
			//���������쳣
			e.printStackTrace();
			throw new Exception(e.getMessage());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			//�ͷ�����
			postMethod.releaseConnection();
		}
		
		return strBackData;
		
	}
	
	/**
	 * ��������
	 * comment here
	 * @since gnete-ora 0.0.0.1
	 */
	private void QueryReq(boolean bCompress) {
		String reqSN = "449871042910093EOD";
//		req="1237";
		//������
		String strSendData = "<?xml version=\"1.0\" encoding=\"GBK\"?><GZELINK><INFO><TRX_CODE>200001</TRX_CODE><VERSION>04</VERSION><DATA_TYPE>2</DATA_TYPE><REQ_SN>" + reqSN + "</REQ_SN><USER_NAME>operator</USER_NAME><USER_PASS>1</USER_PASS><SIGNED_MSG></SIGNED_MSG></INFO><BODY><QUERY_TRANS><QUERY_SN>449871043010095EOD</QUERY_SN></QUERY_TRANS></BODY></GZELINK>";
//		String strSendData = "<?xml version=\"1.0\" encoding=\"GBK\"?><GZELINK><INFO><TRX_CODE>100001</TRX_CODE><VERSION>03</VERSION><DATA_TYPE>2</DATA_TYPE><LEVEL>0</LEVEL><USER_NAME>operator</USER_NAME><USER_PASS>1</USER_PASS><REQ_SN>"+reqSN+"</REQ_SN><SIGNED_MSG></SIGNED_MSG></INFO><BODY><TRANS_SUM><BUSINESS_CODE>10600</BUSINESS_CODE><MERCHANT_ID>000191400100013</MERCHANT_ID><SUBMIT_TIME>20091105155110</SUBMIT_TIME><TOTAL_ITEM>4</TOTAL_ITEM><TOTAL_SUM>19</TOTAL_SUM></TRANS_SUM><TRANS_DETAILS><TRANS_DETAIL><SN>0001</SN><E_USER_CODE/><BANK_CODE>01020000</BANK_CODE><ACCOUNT_TYPE>00</ACCOUNT_TYPE><ACCOUNT_NO>9558803602132597378</ACCOUNT_NO><ACCOUNT_NAME>������</ACCOUNT_NAME><PROVINCE></PROVINCE><CITY></CITY><BANK_NAME></BANK_NAME><ACCOUNT_PROP>0</ACCOUNT_PROP><AMOUNT>4</AMOUNT><CURRENCY>CNY</CURRENCY><PROTOCOL/><PROTOCOL_USERID/><ID_TYPE/><ID/><TEL/><CUST_USERID/><RECKON_ACCOUNT>000191400100077</RECKON_ACCOUNT><REMARK></REMARK><RESERVED1/><RESERVED2/></TRANS_DETAIL><TRANS_DETAIL><SN>0002</SN><E_USER_CODE/><BANK_CODE>01020000</BANK_CODE><ACCOUNT_TYPE>00</ACCOUNT_TYPE><ACCOUNT_NO>9558803602138236567</ACCOUNT_NO><ACCOUNT_NAME>����</ACCOUNT_NAME><PROVINCE></PROVINCE><CITY></CITY><BANK_NAME></BANK_NAME><ACCOUNT_PROP>0</ACCOUNT_PROP><AMOUNT>5</AMOUNT><CURRENCY>CNY</CURRENCY><PROTOCOL/><PROTOCOL_USERID/><ID_TYPE/><ID/><TEL/><CUST_USERID/><RECKON_ACCOUNT>000191400100077</RECKON_ACCOUNT><REMARK></REMARK><RESERVED1/><RESERVED2/></TRANS_DETAIL><TRANS_DETAIL><SN>0003</SN><E_USER_CODE/><BANK_CODE>03030000</BANK_CODE><ACCOUNT_TYPE>00</ACCOUNT_TYPE><ACCOUNT_NO>6226621201565544</ACCOUNT_NO><ACCOUNT_NAME>�¶���</ACCOUNT_NAME><PROVINCE></PROVINCE><CITY></CITY><BANK_NAME></BANK_NAME><ACCOUNT_PROP>0</ACCOUNT_PROP><AMOUNT>5</AMOUNT><CURRENCY>CNY</CURRENCY><PROTOCOL/><PROTOCOL_USERID/><ID_TYPE/><ID/><TEL/><CUST_USERID/><RECKON_ACCOUNT>000191400100077</RECKON_ACCOUNT><REMARK></REMARK><RESERVED1/><RESERVED2/></TRANS_DETAIL><TRANS_DETAIL><SN>0004</SN><E_USER_CODE/><BANK_CODE>01050000</BANK_CODE><ACCOUNT_TYPE>00</ACCOUNT_TYPE><ACCOUNT_NO>6227003324180018958</ACCOUNT_NO><ACCOUNT_NAME>����ˮ</ACCOUNT_NAME><PROVINCE></PROVINCE><CITY></CITY><BANK_NAME></BANK_NAME><ACCOUNT_PROP>0</ACCOUNT_PROP><AMOUNT>5</AMOUNT><CURRENCY>CNY</CURRENCY><PROTOCOL/><PROTOCOL_USERID/><ID_TYPE/><ID/><TEL/><CUST_USERID/><RECKON_ACCOUNT></RECKON_ACCOUNT><REMARK></REMARK><RESERVED1/><RESERVED2/></TRANS_DETAIL></TRANS_DETAILS></BODY></GZELINK>";
		HttpClient httpClient = new HttpClient( );
		//url
		PostMethod postMethod = null;
		if (bCompress) {
			postMethod = new PostMethod(SERVER_URL_COM);
		}
		else {
			postMethod = new PostMethod(SERVER_URL);
		}
		 
		//���ñ���
		httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"GBK");
		
		strSendData = this.signMsg(strSendData);
		if (bCompress) {
			strSendData = compress(strSendData, bCompress);
		}
		postMethod.setRequestBody(strSendData);
		try {
			long start = System.currentTimeMillis();
			//ִ��getMethod
			int statusCode = httpClient.executeMethod(postMethod);
//			System.out.println.println("cost:"+(System.currentTimeMillis()-start));
			//ʧ��
			if (statusCode != HttpStatus.SC_OK) {
				log.info(
					"Method failed: " + postMethod.getStatusLine());
				//��ȡ���� 
				byte[] responseBody = postMethod.getResponseBody();
				//��������
				String strResp = new String(responseBody, "GBK");
				log.info(strResp);				
			}
			else {
//				//��ȡ���� 
				byte[] responseBody = postMethod.getResponseBody();
//				
				String strResp = new String(responseBody, "GBK");
				log.info("����������:" + strResp);
				if (bCompress) {					
					strResp = decompress(strResp, bCompress);
					log.info("��ԭ:" + strResp);
				}
				//��ǩ
				if (this.verifySign(strResp)) {
					log.info("��ǩ��ȷ��������������صı���");
				}
			}
			log.info("cost:"+(System.currentTimeMillis()-start));
		} catch (HttpException e) {
			//�����������쳣��������Э�鲻�Ի��߷��ص�����������
			e.printStackTrace( );
		} catch (IOException e) {
			//���������쳣
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
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
	private void ValidReq(boolean bCompress) {
		String req = System.currentTimeMillis()+"";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String strNow = sdf.format(new Date());
		String strSum = "2";
		//������
		String strSendData = "<?xml version=\"1.0\" encoding=\"GBK\"?><GZELINK><INFO><TRX_CODE>100003</TRX_CODE><VERSION>04</VERSION><DATA_TYPE>2</DATA_TYPE><LEVEL>0</LEVEL><USER_NAME>tkvalid</USER_NAME><USER_PASS>1</USER_PASS><REQ_SN>"+ req +"</REQ_SN><SIGNED_MSG></SIGNED_MSG></INFO><BODY><TRANS_SUM><BUSINESS_CODE>10600</BUSINESS_CODE><MERCHANT_ID>256983416413545</MERCHANT_ID><SUBMIT_TIME>"+strNow+"</SUBMIT_TIME><TOTAL_ITEM>1</TOTAL_ITEM><TOTAL_SUM>"+strSum+"</TOTAL_SUM></TRANS_SUM><TRANS_DETAILS><TRANS_DETAIL><SN>0001</SN><E_USER_CODE/><BANK_CODE>105</BANK_CODE><ACCOUNT_TYPE>00</ACCOUNT_TYPE><ACCOUNT_NO>60138270140042110-021</ACCOUNT_NO><ACCOUNT_NAME>����</ACCOUNT_NAME><PROVINCE>�㶫</PROVINCE><CITY>����</CITY><BANK_NAME>����</BANK_NAME><ACCOUNT_PROP>0</ACCOUNT_PROP><AMOUNT>"+strSum+"</AMOUNT><CURRENCY>CNY</CURRENCY><PROTOCOL/><PROTOCOL_USERID/><ID_TYPE/><ID/><TEL/><CUST_USERID/><REMARK>��������</REMARK></TRANS_DETAIL></TRANS_DETAILS></BODY></GZELINK>";		
		HttpClient httpClient = new HttpClient( );
		//url
		PostMethod postMethod = null;
		if (bCompress) {
			postMethod = new PostMethod(SERVER_URL_COM);
		}
		else {
			postMethod = new PostMethod(SERVER_URL);
		}
		//���ñ���
		httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"GBK");
		
		strSendData = this.signMsg(strSendData);
		if (bCompress) {
			strSendData = compress(strSendData, bCompress);
		}
		
		postMethod.setRequestBody(strSendData);
		try {
			long start = System.currentTimeMillis();
			//ִ��getMethod
			int statusCode = httpClient.executeMethod(postMethod);
//			System.out.println.println("cost:"+(System.currentTimeMillis()-start));
			//ʧ��
			if (statusCode != HttpStatus.SC_OK) {
				log.info(
					"Method failed: " + postMethod.getStatusLine());
				//��ȡ���� 
				byte[] responseBody = postMethod.getResponseBody();
				//��������
				String strResp = new String(responseBody, "GBK");
				log.info(strResp);				
			}
			else {
				//��ȡ���� 
				byte[] responseBody = postMethod.getResponseBody();
				
				String strResp = new String(responseBody, "GBK");
				log.info("����������:" + strResp);
				if (bCompress) {
					strResp = this.decompress(strResp, bCompress);
					log.info("��ԭ:"+strResp);
				}
				//��ǩ
				if (this.verifySign(strResp)) {
					log.info("��ǩ��ȷ��������������صı���");
				}
			}
			log.info("cost:"+(System.currentTimeMillis()-start));
		} catch (HttpException e) {
			//�����������쳣��������Э�鲻�Ի��߷��ص�����������
			e.printStackTrace( );
		} catch (IOException e) {
			//���������쳣
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//�ͷ�����
			postMethod.releaseConnection();
		}
		
	}
	

	/**
	 * 
	 * @param baseRequest ���ͱ�����Ϣ
	 * @param bo  �Ƿ�ѹ������
	 * @param cls ���շ��ر��ĵ���
	 * @return
	 * @throws Exception
	 */
	
	public  BaseResponse sendMsg(BaseRequest baseRequest,boolean bo,Class cls) throws Exception{
		String backdata = this.PayReq(bo, baseRequest.toXml(baseRequest));
		
		BaseResponse baseResponse = new BaseResponse();
		BaseResponse BaseResponse2 = (BaseResponse) baseResponse.readStringXml(backdata,cls);
		
		return BaseResponse2;
		
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	
	
	
}
