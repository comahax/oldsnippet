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
	
	//测试机公网地址 压缩
	private static  String SERVER_URL_COM ;
	//不压缩
	private static  String SERVER_URL ;
	//安全认证文件路径
	private static String TESTUSERCER ;
	private static String TESTUSERPFX ;
	
	private Logger log;
	
	/*static {
		try {
			//读取配置文件的内容
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
			//读取配置文件的内容
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
	 * 压缩字符串为 byte[] 储存可以使用new sun.misc.BASE64Encoder().encodeBuffer(byte[] b)方法
	 * 保存为字符串
	 * 
	 * @param str 压缩前的文本
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
	 * 将压缩后的 byte[] 数据解压缩
	 * 
	 * @param compressed
	 *            压缩后的 byte[] 数据
	 * @return 解压后的字符串
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
	 * 验证签名信息
	 */
	private boolean verifySign(String strXML) {
		//签名
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
	 * 压缩数据
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
	 * 解压数据
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
		String pathPfx = TESTUSERPFX;
//		pathPfx = "D:\\update\\20090514\\MerCA\\Q26_XINHUA2.pfx";
//		pathPfx = "D:\\update\\20090514\\MerCA\\Q27_XINHUA4.pfx";
//		pathPfx = "D:\\pdscert\\Q51_HTA2.pfx";
		String strMsg = strData.replaceAll("<SIGNED_MSG></SIGNED_MSG>", "");
		log.info("签名原文:"+strMsg);
		if (crypt.SignMsg(strMsg, pathPfx, "123456")) {			
			String signedMsg = crypt.getLastSignMsg();
			strRnt = strData.replaceAll("<SIGNED_MSG></SIGNED_MSG>", "<SIGNED_MSG>"+signedMsg+"</SIGNED_MSG>");
			log.info("请求交易报文:"+strRnt);
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
//			sb.append("<TRANS_DETAIL><SN>").append((i+1)+"").append("</SN><E_USER_CODE/><BANK_CODE>105</BANK_CODE><ACCOUNT_TYPE>00</ACCOUNT_TYPE><ACCOUNT_NO>60138270140042110025555</ACCOUNT_NO><ACCOUNT_NAME>张三6666</ACCOUNT_NAME><PROVINCE>广东</PROVINCE><CITY>广州</CITY><BANK_NAME>建行</BANK_NAME><ACCOUNT_PROP>0</ACCOUNT_PROP><AMOUNT>1</AMOUNT><CURRENCY>CNY</CURRENCY><PROTOCOL/><PROTOCOL_USERID/><ID_TYPE/><ID/><TEL/><CUST_USERID/><REMARK>保险理赔</REMARK></TRANS_DETAIL>");
			sb.append("<TRANS_DETAIL><SN>").append((i+1)+"").append("</SN><BANK_CODE>105</BANK_CODE><ACCOUNT_NO>60138270140042110025555</ACCOUNT_NO><ACCOUNT_NAME>张三6666</ACCOUNT_NAME><AMOUNT>1</AMOUNT><REMARK>保险理赔</REMARK></TRANS_DETAIL>");
		}
		sb.append(strEnd);
		return sb.toString();
	}
	
	/**
	 * 
	 * comment here
	 * @param bCompress 是否压缩
	 * @since gnete-pds 0.0.0.1
	 */
	private String PayReq(boolean bCompress,String msg) throws Exception{
		String req = System.currentTimeMillis()+"";
//		req="1237";
		//请求报文
		String strSendData = msg;
		log.info("请求报文:" + msg);
		//返回报文
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
		//设置编码
		httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"GBK");
		
		strSendData = this.signMsg(strSendData);
		if (bCompress) {
			strSendData = this.compress(strSendData, bCompress);
		}
		postMethod.setRequestBody(strSendData);
		try {
			long start = System.currentTimeMillis();
			//执行getMethod
			int statusCode = httpClient.executeMethod(postMethod);
			log.info("cost:"+(System.currentTimeMillis()-start));
			//失败
			if (statusCode != HttpStatus.SC_OK) {
				//读取内容 
				byte[] responseBody = postMethod.getResponseBody();
				//处理内容
				String strResp = new String(responseBody, "GBK");
				
				strBackData = strResp;
				//System.out.println(strResp);				
			}
			else {
//				//读取内容 
				byte[] responseBody = postMethod.getResponseBody();
//				
				String strResp = new String(responseBody, "GBK");
				log.info("服务器返回:" + strResp);
				//
				if (bCompress) {
					
					strBackData=this.decompress(strResp, bCompress);					
					log.info("还原:"+this.decompress(strResp, bCompress));
				}				
				//验签
				if (!this.verifySign(strResp)) {
					
					//throw new Exception("验签正确，处理服务器返回的报文");
					//System.out.println("验签正确，处理服务器返回的报文");
				}
			}
			log.info("cost:"+(System.currentTimeMillis()-start));
		} catch (HttpException e) {
			//发生致命的异常，可能是协议不对或者返回的内容有问题
			e.printStackTrace( );
		} catch (IOException e) {
			//发生网络异常
			e.printStackTrace();
			throw new Exception(e.getMessage());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			//释放连接
			postMethod.releaseConnection();
		}
		
		return strBackData;
		
	}
	
	/**
	 * 测试请求
	 * comment here
	 * @since gnete-ora 0.0.0.1
	 */
	private void QueryReq(boolean bCompress) {
		String reqSN = "449871042910093EOD";
//		req="1237";
		//请求报文
		String strSendData = "<?xml version=\"1.0\" encoding=\"GBK\"?><GZELINK><INFO><TRX_CODE>200001</TRX_CODE><VERSION>04</VERSION><DATA_TYPE>2</DATA_TYPE><REQ_SN>" + reqSN + "</REQ_SN><USER_NAME>operator</USER_NAME><USER_PASS>1</USER_PASS><SIGNED_MSG></SIGNED_MSG></INFO><BODY><QUERY_TRANS><QUERY_SN>449871043010095EOD</QUERY_SN></QUERY_TRANS></BODY></GZELINK>";
//		String strSendData = "<?xml version=\"1.0\" encoding=\"GBK\"?><GZELINK><INFO><TRX_CODE>100001</TRX_CODE><VERSION>03</VERSION><DATA_TYPE>2</DATA_TYPE><LEVEL>0</LEVEL><USER_NAME>operator</USER_NAME><USER_PASS>1</USER_PASS><REQ_SN>"+reqSN+"</REQ_SN><SIGNED_MSG></SIGNED_MSG></INFO><BODY><TRANS_SUM><BUSINESS_CODE>10600</BUSINESS_CODE><MERCHANT_ID>000191400100013</MERCHANT_ID><SUBMIT_TIME>20091105155110</SUBMIT_TIME><TOTAL_ITEM>4</TOTAL_ITEM><TOTAL_SUM>19</TOTAL_SUM></TRANS_SUM><TRANS_DETAILS><TRANS_DETAIL><SN>0001</SN><E_USER_CODE/><BANK_CODE>01020000</BANK_CODE><ACCOUNT_TYPE>00</ACCOUNT_TYPE><ACCOUNT_NO>9558803602132597378</ACCOUNT_NO><ACCOUNT_NAME>陈霄峰</ACCOUNT_NAME><PROVINCE></PROVINCE><CITY></CITY><BANK_NAME></BANK_NAME><ACCOUNT_PROP>0</ACCOUNT_PROP><AMOUNT>4</AMOUNT><CURRENCY>CNY</CURRENCY><PROTOCOL/><PROTOCOL_USERID/><ID_TYPE/><ID/><TEL/><CUST_USERID/><RECKON_ACCOUNT>000191400100077</RECKON_ACCOUNT><REMARK></REMARK><RESERVED1/><RESERVED2/></TRANS_DETAIL><TRANS_DETAIL><SN>0002</SN><E_USER_CODE/><BANK_CODE>01020000</BANK_CODE><ACCOUNT_TYPE>00</ACCOUNT_TYPE><ACCOUNT_NO>9558803602138236567</ACCOUNT_NO><ACCOUNT_NAME>刘宁</ACCOUNT_NAME><PROVINCE></PROVINCE><CITY></CITY><BANK_NAME></BANK_NAME><ACCOUNT_PROP>0</ACCOUNT_PROP><AMOUNT>5</AMOUNT><CURRENCY>CNY</CURRENCY><PROTOCOL/><PROTOCOL_USERID/><ID_TYPE/><ID/><TEL/><CUST_USERID/><RECKON_ACCOUNT>000191400100077</RECKON_ACCOUNT><REMARK></REMARK><RESERVED1/><RESERVED2/></TRANS_DETAIL><TRANS_DETAIL><SN>0003</SN><E_USER_CODE/><BANK_CODE>03030000</BANK_CODE><ACCOUNT_TYPE>00</ACCOUNT_TYPE><ACCOUNT_NO>6226621201565544</ACCOUNT_NO><ACCOUNT_NAME>陈东南</ACCOUNT_NAME><PROVINCE></PROVINCE><CITY></CITY><BANK_NAME></BANK_NAME><ACCOUNT_PROP>0</ACCOUNT_PROP><AMOUNT>5</AMOUNT><CURRENCY>CNY</CURRENCY><PROTOCOL/><PROTOCOL_USERID/><ID_TYPE/><ID/><TEL/><CUST_USERID/><RECKON_ACCOUNT>000191400100077</RECKON_ACCOUNT><REMARK></REMARK><RESERVED1/><RESERVED2/></TRANS_DETAIL><TRANS_DETAIL><SN>0004</SN><E_USER_CODE/><BANK_CODE>01050000</BANK_CODE><ACCOUNT_TYPE>00</ACCOUNT_TYPE><ACCOUNT_NO>6227003324180018958</ACCOUNT_NO><ACCOUNT_NAME>栾望水</ACCOUNT_NAME><PROVINCE></PROVINCE><CITY></CITY><BANK_NAME></BANK_NAME><ACCOUNT_PROP>0</ACCOUNT_PROP><AMOUNT>5</AMOUNT><CURRENCY>CNY</CURRENCY><PROTOCOL/><PROTOCOL_USERID/><ID_TYPE/><ID/><TEL/><CUST_USERID/><RECKON_ACCOUNT></RECKON_ACCOUNT><REMARK></REMARK><RESERVED1/><RESERVED2/></TRANS_DETAIL></TRANS_DETAILS></BODY></GZELINK>";
		HttpClient httpClient = new HttpClient( );
		//url
		PostMethod postMethod = null;
		if (bCompress) {
			postMethod = new PostMethod(SERVER_URL_COM);
		}
		else {
			postMethod = new PostMethod(SERVER_URL);
		}
		 
		//设置编码
		httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"GBK");
		
		strSendData = this.signMsg(strSendData);
		if (bCompress) {
			strSendData = compress(strSendData, bCompress);
		}
		postMethod.setRequestBody(strSendData);
		try {
			long start = System.currentTimeMillis();
			//执行getMethod
			int statusCode = httpClient.executeMethod(postMethod);
//			System.out.println.println("cost:"+(System.currentTimeMillis()-start));
			//失败
			if (statusCode != HttpStatus.SC_OK) {
				log.info(
					"Method failed: " + postMethod.getStatusLine());
				//读取内容 
				byte[] responseBody = postMethod.getResponseBody();
				//处理内容
				String strResp = new String(responseBody, "GBK");
				log.info(strResp);				
			}
			else {
//				//读取内容 
				byte[] responseBody = postMethod.getResponseBody();
//				
				String strResp = new String(responseBody, "GBK");
				log.info("服务器返回:" + strResp);
				if (bCompress) {					
					strResp = decompress(strResp, bCompress);
					log.info("还原:" + strResp);
				}
				//验签
				if (this.verifySign(strResp)) {
					log.info("验签正确，处理服务器返回的报文");
				}
			}
			log.info("cost:"+(System.currentTimeMillis()-start));
		} catch (HttpException e) {
			//发生致命的异常，可能是协议不对或者返回的内容有问题
			e.printStackTrace( );
		} catch (IOException e) {
			//发生网络异常
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
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
	private void ValidReq(boolean bCompress) {
		String req = System.currentTimeMillis()+"";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String strNow = sdf.format(new Date());
		String strSum = "2";
		//请求报文
		String strSendData = "<?xml version=\"1.0\" encoding=\"GBK\"?><GZELINK><INFO><TRX_CODE>100003</TRX_CODE><VERSION>04</VERSION><DATA_TYPE>2</DATA_TYPE><LEVEL>0</LEVEL><USER_NAME>tkvalid</USER_NAME><USER_PASS>1</USER_PASS><REQ_SN>"+ req +"</REQ_SN><SIGNED_MSG></SIGNED_MSG></INFO><BODY><TRANS_SUM><BUSINESS_CODE>10600</BUSINESS_CODE><MERCHANT_ID>256983416413545</MERCHANT_ID><SUBMIT_TIME>"+strNow+"</SUBMIT_TIME><TOTAL_ITEM>1</TOTAL_ITEM><TOTAL_SUM>"+strSum+"</TOTAL_SUM></TRANS_SUM><TRANS_DETAILS><TRANS_DETAIL><SN>0001</SN><E_USER_CODE/><BANK_CODE>105</BANK_CODE><ACCOUNT_TYPE>00</ACCOUNT_TYPE><ACCOUNT_NO>60138270140042110-021</ACCOUNT_NO><ACCOUNT_NAME>张三</ACCOUNT_NAME><PROVINCE>广东</PROVINCE><CITY>广州</CITY><BANK_NAME>建行</BANK_NAME><ACCOUNT_PROP>0</ACCOUNT_PROP><AMOUNT>"+strSum+"</AMOUNT><CURRENCY>CNY</CURRENCY><PROTOCOL/><PROTOCOL_USERID/><ID_TYPE/><ID/><TEL/><CUST_USERID/><REMARK>保险理赔</REMARK></TRANS_DETAIL></TRANS_DETAILS></BODY></GZELINK>";		
		HttpClient httpClient = new HttpClient( );
		//url
		PostMethod postMethod = null;
		if (bCompress) {
			postMethod = new PostMethod(SERVER_URL_COM);
		}
		else {
			postMethod = new PostMethod(SERVER_URL);
		}
		//设置编码
		httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"GBK");
		
		strSendData = this.signMsg(strSendData);
		if (bCompress) {
			strSendData = compress(strSendData, bCompress);
		}
		
		postMethod.setRequestBody(strSendData);
		try {
			long start = System.currentTimeMillis();
			//执行getMethod
			int statusCode = httpClient.executeMethod(postMethod);
//			System.out.println.println("cost:"+(System.currentTimeMillis()-start));
			//失败
			if (statusCode != HttpStatus.SC_OK) {
				log.info(
					"Method failed: " + postMethod.getStatusLine());
				//读取内容 
				byte[] responseBody = postMethod.getResponseBody();
				//处理内容
				String strResp = new String(responseBody, "GBK");
				log.info(strResp);				
			}
			else {
				//读取内容 
				byte[] responseBody = postMethod.getResponseBody();
				
				String strResp = new String(responseBody, "GBK");
				log.info("服务器返回:" + strResp);
				if (bCompress) {
					strResp = this.decompress(strResp, bCompress);
					log.info("还原:"+strResp);
				}
				//验签
				if (this.verifySign(strResp)) {
					log.info("验签正确，处理服务器返回的报文");
				}
			}
			log.info("cost:"+(System.currentTimeMillis()-start));
		} catch (HttpException e) {
			//发生致命的异常，可能是协议不对或者返回的内容有问题
			e.printStackTrace( );
		} catch (IOException e) {
			//发生网络异常
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//释放连接
			postMethod.releaseConnection();
		}
		
	}
	

	/**
	 * 
	 * @param baseRequest 发送报文信息
	 * @param bo  是否压缩报文
	 * @param cls 接收返回报文的类
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
