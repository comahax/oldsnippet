package net.gmcc.pboss.pboss4crmservice;

public class EmpsynTest2 extends XmlTestTemplate {
	public static void main(String[] args){
		EmpsynTest2 test = new EmpsynTest2();
		test.doService();
		System.exit(0);
	}
	
	public void doService() {
		// TODO Auto-generated method stub
		Empsynreq request = new Empsynreq();
		Msgreqheader head = new Msgreqheader();
		Empsynreq.Msgbody body = new Empsynreq.Msgbody();
		Empsynreq.Msgbody.Empinfo empinfo = new Empsynreq.Msgbody.Empinfo();
		request.setMsgreqheader(head);
		body.setEmpinfo(empinfo);
		request.setMsgbody(body);
		
		
		head.setMenuid("menuid_emp");
		head.setProcessCode("empsyn");
		head.setVerifyCode("verify_code_emp");
		head.setReqTime("20120207095945");
		head.setReqSeq("req_seq_emp000000000000000000000");
		head.setUnicontact("unicontact_emp");
		head.setTestflag("1");		
		Msgreqheader.Route route = new Msgreqheader.Route();
		route.setRouteType("0");
		route.setRouteValue("760");
		head.setRoute(route);		
		Msgreqheader.Channelinfo channel = new Msgreqheader.Channelinfo();
		channel.setChannelid("channelid_emp");
		channel.setOperatorid("operatorid_emp");
		channel.setUnitid("unitid_emp");
		head.setChannelinfo(channel);
		
		empinfo.setOprtype("update");
		empinfo.setEmployeeid("ZS100369612++");
		empinfo.setOprcode("assistant");
		empinfo.setEmployeename("中国心xin");
		empinfo.setBirthday("19140808080818");
		empinfo.setSex("0");
		empinfo.setEdulevel("1");
		empinfo.setNativehome("2");
		empinfo.setPolivisage("3");
		empinfo.setDepartment("4");
		empinfo.setServoffice("5");
		empinfo.setStation("6");
		empinfo.setJoblevel("7");
		empinfo.setIntime("20101027000000");
		empinfo.setWorktime("32");
		empinfo.setHereworktime("16");
		empinfo.setEmploytype("1");
		empinfo.setCompany("re");
		empinfo.setTelephone("13560697434");
		empinfo.setOfficetel("13560697434");
		empinfo.setOuttime("20101227000000");
		empinfo.setOutresult("离职去向");
		empinfo.setHomeaddr("家庭地址");
		empinfo.setCardid("445122198808083736");
		empinfo.setWayid("TDZS1211002");
		empinfo.setWaytype("AG");
		empinfo.setPvtemail("assistant@hao.com");
		empinfo.setOfcphone("公司专用联系方式");
		empinfo.setOfcemail("公司专用电子邮箱");
		empinfo.setSpeciality("专业");
		empinfo.setCityid("ZS");
		empinfo.setCountyid("ZSCQ");
		empinfo.setSvccode("服务销售");
		empinfo.setPosittype("岗位级别");
		empinfo.setContacttype("0");
		empinfo.setEmpstatus("1");
		empinfo.setActbank("2");
		empinfo.setActno("3");
		empinfo.setActname("4");
		empinfo.setActpid("5");
		empinfo.setBail("6");
		empinfo.setGradschool("7");
		empinfo.setGradtime("20101227000000");
		empinfo.setIsmarried("9");
		empinfo.setOutreason("11");
		empinfo.setTrainlevel("12");
		empinfo.setHobby("13");
		empinfo.setCharacter("14");
		empinfo.setAsses("1");
		empinfo.setWorkhistry("1");
		empinfo.setPrizeorpunish("1");
		empinfo.setEmpass("1");
		empinfo.setRight("1");
		empinfo.setIsnet("0");
		empinfo.setNetpass("1");
		empinfo.setIsopen("2");
		empinfo.setSelectmobile("123");
		empinfo.setSubname("20101027000000");
		empinfo.setRegdate("20101227000000");
		empinfo.setEmpattr("1");
		empinfo.setEmpattrmemo("1");
		empinfo.setIstenseed("1");
		empinfo.setIsinternal("1");


		Empsynrsp response = client.empsyn(request);
		Msgrspheader rsphead = response.getMsgrspheader();
		String rsp = "menuid:"+rsphead.getMenuid()+"\nprocess_code:"+rsphead.getProcessCode()+"\n";
		rsp += "verify_code:"+rsphead.getVerifyCode()+"\nreq_time:"+rsphead.getRespTime()+"\n";
		rsp += "sequence.req_seq:"+rsphead.getSequence().getReqSeq()+"\nsequence.operation_seq:"+rsphead.getSequence().getOperationSeq()+"\n";
		rsp += "=======================================================\n";
		rsp += "retinfo.rettype:"+rsphead.getRetinfo().getRetype()+"\nretinfo.retcode:"+rsphead.getRetinfo().getRetcode()+"\nretinfo.msg:"+rsphead.getRetinfo().getRetmsg()+"\n";
		rsp += "=======================================================";
		System.out.print("服务"+rsphead.getProcessCode()+"响应信息：\n"+rsp);
		
		
		
	}

	@Override
	public String doService(PBOSSServicePort client, String xml) {
		// TODO Auto-generated method stub
		Empsynreq request = new Empsynreq();
		Msgreqheader head = new Msgreqheader();
		Empsynreq.Msgbody body = new Empsynreq.Msgbody();
		Empsynreq.Msgbody.Empinfo empinfo = new Empsynreq.Msgbody.Empinfo();
		request.setMsgreqheader(head);
		body.setEmpinfo(empinfo);
		request.setMsgbody(body);
		
		
		head.setMenuid("menuid_emp");
		head.setProcessCode("process_code_emp");
		head.setVerifyCode("verify_code_emp");
		head.setReqTime("20120207095945");
		//head.setReqSeq("req_seq_emp000000000000000000000");
		head.setUnicontact("unicontact_emp");
		head.setTestflag("1");		
		Msgreqheader.Route route = new Msgreqheader.Route();
		route.setRouteType("0");
		route.setRouteValue("760");
		head.setRoute(route);		
		Msgreqheader.Channelinfo channel = new Msgreqheader.Channelinfo();
		channel.setChannelid("channelid_emp");
		channel.setOperatorid("operatorid_emp");
		channel.setUnitid("unitid_emp");
		head.setChannelinfo(channel);
		
		empinfo.setOprtype("update");
		empinfo.setEmployeeid("ZS100369612++");
		empinfo.setOprcode("assistant");
		empinfo.setEmployeename("中国");
		empinfo.setBirthday("19140808080818");
		empinfo.setSex("0");
		empinfo.setEdulevel("1");
		empinfo.setNativehome("2");
		empinfo.setPolivisage("3");
		empinfo.setDepartment("4");
		empinfo.setServoffice("5");
		empinfo.setStation("6");
		empinfo.setJoblevel("7");
		empinfo.setIntime("20101027000000");
		empinfo.setWorktime("32");
		empinfo.setHereworktime("16");
		empinfo.setEmploytype("1");
		empinfo.setCompany("re");
		empinfo.setTelephone("13560697434");
		empinfo.setOfficetel("13560697434");
		empinfo.setOuttime("20101227000000");
		empinfo.setOutresult("离职去向");
		empinfo.setHomeaddr("家庭地址");
		empinfo.setCardid("445122198808083736");
		empinfo.setWayid("TDZS1211002");
		empinfo.setWaytype("AG");
		empinfo.setPvtemail("assistant@hao.com");
		empinfo.setOfcphone("公司专用联系方式");
		empinfo.setOfcemail("公司专用电子邮箱");
		empinfo.setSpeciality("专业");
		empinfo.setCityid("ZS");
		empinfo.setCountyid("ZSCQ");
		empinfo.setSvccode("服务销售");
		empinfo.setPosittype("岗位级别");
		empinfo.setContacttype("0");
		empinfo.setEmpstatus("1");
		empinfo.setActbank("2");
		empinfo.setActno("3");
		empinfo.setActname("4");
		empinfo.setActpid("5");
		empinfo.setBail("6");
		empinfo.setGradschool("7");
		empinfo.setGradtime("20101227000000");
		empinfo.setIsmarried("9");
		empinfo.setOutreason("11");
		empinfo.setTrainlevel("12");
		empinfo.setHobby("13");
		empinfo.setCharacter("14");
		empinfo.setAsses("1");
		empinfo.setWorkhistry("1");
		empinfo.setPrizeorpunish("1");
		empinfo.setEmpass("1");
		empinfo.setRight("1");
		empinfo.setIsnet("0");
		empinfo.setNetpass("1");
		empinfo.setIsopen("2");
		empinfo.setSelectmobile("123");
		empinfo.setSubname("20101027000000");
		empinfo.setRegdate("20101227000000");
		empinfo.setEmpattr("1");
		empinfo.setEmpattrmemo("1");
		empinfo.setIstenseed("1");
		empinfo.setIsinternal("1");


		Empsynrsp response = client.empsyn(request);
		Msgrspheader rsphead = response.getMsgrspheader();
		String rsp = "menuid:"+rsphead.getMenuid()+"\nprocess_code:"+rsphead.getProcessCode()+"\n";
		rsp += "verify_code:"+rsphead.getVerifyCode()+"\nreq_time:"+rsphead.getRespTime()+"\n";
		rsp += "sequence.req_seq:"+rsphead.getSequence().getReqSeq()+"\nsequence.operation_seq:"+rsphead.getSequence().getOperationSeq()+"\n";
		rsp += "=======================================================\n";
		rsp += "retinfo.rettype:"+rsphead.getRetinfo().getRetype()+"\nretinfo.retcode:"+rsphead.getRetinfo().getRetcode()+"\nretinfo.msg:"+rsphead.getRetinfo().getRetmsg()+"\n";
		rsp += "=======================================================";
		return "服务"+rsphead.getProcessCode()+"响应信息：\n"+rsp;
		
		
		
	}

	@Override
	public Object parseRequest(String xml) {
		// TODO Auto-generated method stub
		return null;
	}

}
