
import java.text.SimpleDateFormat;
import java.util.Date;

import net.gmcc.pboss.pboss4crmservice.Msgreqheader;
import net.gmcc.pboss.pboss4crmservice.PBOSSServicePort;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class Test1 {
	
	public static void main(String[] args){
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
    	factory.getInInterceptors().add(new LoggingInInterceptor()); 
    	factory.getOutInterceptors().add(new LoggingOutInterceptor()); 
    	factory.setAddress("http://localhost:2001/services/PBOSS4CRMService");
    	factory.setServiceClass(PBOSSServicePort.class);
    	PBOSSServicePort client = (PBOSSServicePort)factory.create();
    	
    	System.out.println("Invoking oprsyn...");
		// net.gmcc.pboss.pboss4crmservice.Oprsynreq _oprsyn_body = null;
		net.gmcc.pboss.pboss4crmservice.Oprsynreq request = new net.gmcc.pboss.pboss4crmservice.Oprsynreq();
		Msgreqheader head = new Msgreqheader();
		Msgreqheader.Channelinfo channel = new Msgreqheader.Channelinfo();
		channel.setChannelid("channelid+");
		channel.setOperatorid("operationid+");
		channel.setUnitid("unitid+");
		head.setChannelinfo(channel);
		head.setMenuid("menuid+");
		head.setProcessCode("processcode+");
		head.setReqSeq("reqseq+");
		head.setReqTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		Msgreqheader.Route route = new Msgreqheader.Route();
		route.setRouteType("routetype+");
		route.setRouteValue("routevalue+");
		head.setRoute(route);
		head.setTestflag("true");
		head.setUnicontact("unicontact+");
		head.setVerifyCode("verifycode+");
		request.setMsgreqheader(head);
		
		net.gmcc.pboss.pboss4crmservice.Oprsynreq.Msgbody body = new net.gmcc.pboss.pboss4crmservice.Oprsynreq.Msgbody();
		net.gmcc.pboss.pboss4crmservice.Oprsynreq.Msgbody.Oprinfo oprinfo = new net.gmcc.pboss.pboss4crmservice.Oprsynreq.Msgbody.Oprinfo();
		oprinfo.setOptime("test+");
        oprinfo.setOprcode("test+");
        oprinfo.setOprtype("test+");
        oprinfo.setOperid("test+");
        oprinfo.setRegion("test+");
        oprinfo.setOpername("test+");
        oprinfo.setPassword("test+");
        oprinfo.setPasschgdate("test+");
        oprinfo.setOpergroup("test+");
        oprinfo.setOpertype("test+");
        oprinfo.setOperlevel("test+");
        oprinfo.setIsmanager("test+");
        oprinfo.setOrgid("test+");
        oprinfo.setStarttime("test+");
        oprinfo.setMac("test+");
        oprinfo.setNotes("test+");
        oprinfo.setStatus("test+");
        oprinfo.setStatusdate("test+");
        oprinfo.setReleStaffId("test+");
        oprinfo.setStartUsingTime("test+");
        oprinfo.setSmnotityflag("test+");            
        oprinfo.setContactphone("contactphone+");
		oprinfo.setCreatedate("2012-02-10T12:13:14");
		oprinfo.setEnablegprs("enablegprs+");
		oprinfo.setEndtime("2012-12-20T23:59:59");
		oprinfo.setEndUsingTime("2012-12-18T00:00:00");
		oprinfo.setGprsendtime("2012-06-31T12:21:12");
		oprinfo.setGprsstarttime("2012-02-10T12:13:14");
		oprinfo.setIschkmac("false");
		oprinfo.setIsrestrict("true");
		oprinfo.setLogintype("logintype+");
		request.setMsgbody(body);
    	
    	net.gmcc.pboss.pboss4crmservice.Oprsynrsp _oprsyn__return = client.oprsyn(request);
		System.out.println(System.currentTimeMillis()+" oprsyn.result=" + _oprsyn__return.getMsgrspheader().getMenuid());
		
		System.exit(0);

	}

}
