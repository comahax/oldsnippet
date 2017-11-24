package net.gmcc.pboss.pboss4crmservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.XPP3Reader;

import net.gmcc.pboss.comswebservice.COMSWebService;
import net.gmcc.pboss.comswebservice.COMSWebServicePort;
import net.gmcc.pboss.pboss4crmservice.PBOSSServicePort;
import net.gmcc.pboss.pboss4crmservice.Msgreqheader;;

/**
 * 纯代码调用Web Service 好处是不需要配置文件即可直接调用
 * 
 * @author maxim
 * 
 */
public abstract class XmlTestTemplate {
	public static final String MESSAGE_HEADER = "MsgReqHeader";//MessageHeader
	public static final String MESSAGE_BODY = "MsgBody";//MessageBody
	public String xmlPath = "D:\\Projects_2\\hsc_main_gmcc\\xml";
	public static PBOSSServicePort client;
	public static COMSWebServicePort client2;

	//原测试方式
//	static{
//		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
//		//本机服务
//		//factory.setAddress("http://localhost:2001/services/HscService");
//		factory.setAddress("http://localhost:9083/services/PBOSS4CRMService");//2001
//		//仿真割接服务
//		//factory.setAddress("http://10.244.150.122:9005/Nodehsc/services/HscService?wsdl");
//		//factory.setAddress("http://localhost:9080/Nodehsc/services/HscService?wsdl");
//		//惠州UAT机服务
//		//factory.setAddress("http://10.246.54.70:9080/hsc-crm-uat/services/HscService?wsdl");
//		//生产机映射地址
//		//factory.setAddress("http://10.243.215.93:100/Nodehsc/services/HscService?wsdl");
//		//factory.setAddress("http://10.251.35.243:100/Nodehsc/services/HscService?wsdl");
//		//生产机物理地址
//		//factory.setAddress("http://10.243.210.108:100/Nodehsc/services/HscService?wsdl");
//		//IHS直连地址
//		//factory.setAddress("http://10.243.215.94:100/Nodehsc/services/HscService?wsdl");
//	
//		factory.setServiceClass(PBOSSServicePort.class);
//		client = (PBOSSServicePort) factory.create();
//	}
	
	/**
	 * 下面的配置与PBOSSServicePort_PBOSSServiceSoap_Server一起使用
	 * 由于PBOSSServicePort_PBOSSServiceSoap_Server不能启动Spring配置，所以仅能连通，不能测试业务
	 */
	private static final QName SERVICE_NAME = new QName("http://www.gmcc.net/pboss/PBOSS4CRMService/", "PBOSS4CRMService");
	static{
		URL wsdlURL = PBOSS4CRMService.WSDL_LOCATION;
        PBOSS4CRMService ss = new PBOSS4CRMService(wsdlURL, SERVICE_NAME);
        //PBOSSServicePort port = ss.getPBOSSServiceSoap(); 
        client = ss.getPBOSSServiceSoap(); 
	}
	
	private static final QName SERVICE_NAME2 = new QName("http://www.gmcc.net/pboss/COMSWebService/","COMSWebService");
	static {
		URL wsdlURL = COMSWebService.WSDL_LOCATION;
		COMSWebService ss = new COMSWebService(wsdlURL, SERVICE_NAME2);
		client2 = ss.getCOMSWebServiceSOAP();
	}

	public void service() {

		StringBuffer content = new StringBuffer(); // 请求报文
		File file = new File(xmlPath);
		FileReader fr = null;
		BufferedReader br = null;
		try {
			if (file.isDirectory()) {
				File files[] = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					content = new StringBuffer("");
					if (!files[i].isDirectory()) {
						fr = new FileReader(files[i]);
						br = new BufferedReader(fr);
						try {
							String s = "";
							while ((s = br.readLine()) != null) {
								content.append(s);
							}
							String response = this.doService(client, content.toString());
							System.out.println(response);
							if (fr != null) {
								fr.close();
							}
							if (br != null) {
								br.close();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			} else {
				content = new StringBuffer("");
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				try {
					String s = "";
					while ((s = br.readLine()) != null) {
						content.append(s);
					}
					String response = this.doService(client, content.toString());
					System.out.println(response);
					if (fr != null) {
						fr.close();
					}
					if (br != null) {
						br.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract String doService(PBOSSServicePort client, String xml);

	public abstract Object parseRequest(String xml);

	public Msgreqheader parseRequestHeader(String xml) {
		Msgreqheader reqheader = new Msgreqheader();
		Document doc;
		try {
			doc = new XPP3Reader().read(new StringReader(xml));
			Element eReqheader = doc.getRootElement().element(MESSAGE_HEADER);
//			requestHeader.setMsisdn(eMessageHeader.elementText("Msisdn"));
//			requestHeader.setAreaNo(eMessageHeader.elementText("AreaNo"));
//			requestHeader.setCommandId(eMessageHeader.elementText("CommandId"));
//			requestHeader.setVersion(eMessageHeader.elementText("Version"));
//			requestHeader.setTransID(eMessageHeader.elementText("TransID"));
//			requestHeader.setLogID(eMessageHeader.elementText("LogID"));
//			requestHeader.setSeqID(eMessageHeader.elementText("SeqID"));
//			requestHeader.setMaxSeqId(eMessageHeader.elementText("MaxSeqId"));
//			requestHeader.setRecdate(eMessageHeader.elementText("Recdate"));
//			requestHeader.setInterFrom(eMessageHeader.elementText("InterFrom"));
//			requestHeader.setOperID(eMessageHeader.elementText("OperID"));
			reqheader.setMenuid(eReqheader.elementText("menuid"));
			reqheader.setProcessCode(eReqheader.elementText("process_code"));
			reqheader.setVerifyCode(eReqheader.elementText("verify_code"));
			reqheader.setReqTime(eReqheader.elementText("req_time"));
			reqheader.setReqSeq(eReqheader.elementText("req_seq"));
			reqheader.setUnicontact(eReqheader.elementText("unicontact"));
			reqheader.setTestflag(eReqheader.elementText("testflag"));
			
			Msgreqheader.Route route = new Msgreqheader.Route();
			Element eRoute = eReqheader.element("route");
			route.setRouteType(eRoute.elementText("route_type"));
			route.setRouteValue(eRoute.elementText("route_value"));
			reqheader.setRoute(route);
			
			Msgreqheader.Channelinfo channel = new Msgreqheader.Channelinfo();
			Element eChannel = eReqheader.element("channelinfo");
			channel.setChannelid(eChannel.elementText("channelid"));
			channel.setOperatorid(eChannel.elementText("operatorid"));
			channel.setUnitid(eChannel.elementText("unitid"));
			reqheader.setChannelinfo(channel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reqheader;
	}

	public void setXmlPath(String path) {
		xmlPath = path;
	}

}
