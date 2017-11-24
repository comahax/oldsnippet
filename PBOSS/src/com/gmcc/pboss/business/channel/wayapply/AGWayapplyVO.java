package com.gmcc.pboss.business.channel.wayapply;


/** @author Hibernate CodeGenerator */
public class AGWayapplyVO {

	/** identifier field */
	private String applyno;

	/** nullable persistent field */
	private String optime;

	/** nullable persistent field */
	private String auditstatus;

	/** nullable persistent field */
	private String description;

	/** nullable persistent field */
	private String wayid;

	/** nullable persistent field */
	private String wayname;

	/** nullable persistent field */
	private String waysubtype;

	/** nullable persistent field */
	private String upperwayid;

	/** nullable persistent field */
	private String starlevel;

	/** nullable persistent field */
	private String pt;

	/** nullable persistent field */
	private String waystate;

	/** nullable persistent field */
	private String cityid;

	/** nullable persistent field */
	private String countyid;

	/** nullable persistent field */
	private String svccode;

	/** nullable persistent field */
	private String mareacode;

	/** nullable persistent field */
	private String isstraitprd;

	/** nullable persistent field */
	private String adtypecode;

	/** nullable persistent field */
	private String adacode;

	/** nullable persistent field */
	private String formtype;

	/** nullable persistent field */
	private String starttime;

	/** nullable persistent field */
	private String buzarea;

	/** nullable persistent field */
	private String logiscode;

	/** nullable persistent field */
	private String waymagcode;

	/** nullable persistent field */
	private String bchlevel;

	/** nullable persistent field */
	private String officetel;

	/** nullable persistent field */
	private String alarmbizamount;

	/** nullable persistent field */
	private String address;

	/** nullable persistent field */
	private String latitude;

	/** nullable persistent field */
	private String longtitude;

	/** nullable persistent field */
	private String principal;

	/** nullable persistent field */
	private String principaltel;

	/** nullable persistent field */
	private String principalphone;

	/** nullable persistent field */
	private String principalemail;

	/** nullable persistent field */
	private String sendaddr;

	/** nullable persistent field */
	private String acctno;

	/** nullable persistent field */
	private String acctname;

	/** nullable persistent field */
	private String bankname;

	/** nullable persistent field */
	private String acctfid;

	/** nullable persistent field */
	private String deacctno;

	/** nullable persistent field */
	private String deacctname;

	/** nullable persistent field */
	private String debankname;

	/** nullable persistent field */
	private String accttype;

	/** nullable persistent field */
	private String intime;

	/** nullable persistent field */
	private String catetype;

	/** nullable persistent field */
	private String chainhead;

	/** nullable persistent field */
	private String recpers;

	/** nullable persistent field */
	private String recconntel;

	/** nullable persistent field */
	private String reccertno;

	/** nullable persistent field */
	private String signstatus;

	/** nullable persistent field */
	private String provcode;

	/** nullable persistent field */
	private String bailtype;

	/** nullable persistent field */
	private String servbound;

	/** nullable persistent field */
	private String compactno;

	/** nullable persistent field */
	private String compactname;

	/** nullable persistent field */
	private String begintime;

	/** nullable persistent field */
	private String endtime;

	/** nullable persistent field */
	private String signtime;

	/** nullable persistent field */
	private String compacttype;

	/** nullable persistent field */
	private String licenceno;

	/** nullable persistent field */
	private String bail;

	/** nullable persistent field */
	private String baillwrlmt;

	/** nullable persistent field */
	private String licvalidate;

	/** nullable persistent field */
	private String bailstatus;
	
	private String isunpb;

	/** nullable persistent field */
	private String isb2m;

	private String smsmobileno;

	private String nextstepid;

	private String stepid;
	
	//存放stepid最后一个数字，用来判断审批已经进行到第几步
	private String lastStepid;

	private String content;

	private String auditstatus_work;

	private String seqid;

	private String waytype;

	private String oprcode;

	private String debankid;

	private String destate;

	private String custtype;

	private String istietong;
	
	private String connecttype;
	
	private String sublayer;
	
	private String buztypecode;
	
	// 新增字段
	// 网点注册码
	private String regid;
	// 是否授权网点
	private String checked;
	// 是否接入空中充值平台
	private String iskzcz;
	// 星级分层
	private String starlev;
	// 全网统一渠道编码
	private String uniquewayid;
	// 乡镇
	private String town;
	// 渠道基础类型
	private String provtype;
	// 是否手机卖场
	private String mobilemall;
	// 前台营业面积（㎡）
	private String frontarea;
	// 运营商ISP接入方式
	private String ispconntype;
	// 合作层级
	private String mainlayer;
	// 业务联系号码
	private String buzphoneno;
	// 合作方
	private String cooperator;
	// 扣税方式
	private String taxtype;
	// 合作商类型
	private String distype;
	// 联系人
	private String linkman;
	// 联系电话
	private String linkmantel;
	// 业务联系人电子邮箱
	private String linkmanemail;
	// 合作单位
	private String company;
	// 合作商级别
	private String coplevel;
	// 工商号
	private String busnum;
	// 证件类别
	private String certitype;
	// 注册地址
	private String regadress;
	// 注册资金
	private String regcapital;
	// 公司类型
	private String companytype;
	// 职位
	private String brole;
	// 证件编码
	private String certinum;
	// 合作业务范围
	private String copbound;
	// 经营区域类型
	private String runareatype;
	// 管理模式
	private String calcumode;
	// 统一模式开始时间
	private String uniformtime;
	// 审批数据来源
	private String comefrom;	
	// 合同协议原件路径
	private String compactpath;
	// 营业执照文件路径
	private String licencepath;
	
	////查询登陆的工号是否有网点审批角色控制
	private String hasRight;
	
	//
	private String worktype;

	
    //新增是否top网点
    private String istop;
	
	public String getApplyno() {
		return applyno;
	}

	public void setApplyno(String applyno) {
		this.applyno = applyno;
	}

	public String getOptime() {
		return optime;
	}

	public void setOptime(String optime) {
		this.optime = optime;
	}

	public String getAuditstatus() {
		return auditstatus;
	}

	public void setAuditstatus(String auditstatus) {
		this.auditstatus = auditstatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public String getWaysubtype() {
		return waysubtype;
	}

	public void setWaysubtype(String waysubtype) {
		this.waysubtype = waysubtype;
	}

	public String getUpperwayid() {
		return upperwayid;
	}

	public void setUpperwayid(String upperwayid) {
		this.upperwayid = upperwayid;
	}

	public String getStarlevel() {
		return starlevel;
	}

	public void setStarlevel(String starlevel) {
		this.starlevel = starlevel;
	}

	public String getPt() {
		return pt;
	}

	public void setPt(String pt) {
		this.pt = pt;
	}

	public String getWaystate() {
		return waystate;
	}

	public void setWaystate(String waystate) {
		this.waystate = waystate;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getSvccode() {
		return svccode;
	}

	public void setSvccode(String svccode) {
		this.svccode = svccode;
	}

	public String getMareacode() {
		return mareacode;
	}

	public void setMareacode(String mareacode) {
		this.mareacode = mareacode;
	}

	public String getIsstraitprd() {
		return isstraitprd;
	}

	public void setIsstraitprd(String isstraitprd) {
		this.isstraitprd = isstraitprd;
	}

	public String getAdtypecode() {
		return adtypecode;
	}

	public void setAdtypecode(String adtypecode) {
		this.adtypecode = adtypecode;
	}

	public String getAdacode() {
		return adacode;
	}

	public void setAdacode(String adacode) {
		this.adacode = adacode;
	}

	public String getFormtype() {
		return formtype;
	}

	public void setFormtype(String formtype) {
		this.formtype = formtype;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getBuzarea() {
		return buzarea;
	}

	public void setBuzarea(String buzarea) {
		this.buzarea = buzarea;
	}

	public String getLogiscode() {
		return logiscode;
	}

	public void setLogiscode(String logiscode) {
		this.logiscode = logiscode;
	}

	public String getWaymagcode() {
		return waymagcode;
	}

	public void setWaymagcode(String waymagcode) {
		this.waymagcode = waymagcode;
	}

	public String getBchlevel() {
		return bchlevel;
	}

	public void setBchlevel(String bchlevel) {
		this.bchlevel = bchlevel;
	}

	public String getOfficetel() {
		return officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}

	public String getAlarmbizamount() {
		return alarmbizamount;
	}

	public void setAlarmbizamount(String alarmbizamount) {
		this.alarmbizamount = alarmbizamount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getPrincipaltel() {
		return principaltel;
	}

	public void setPrincipaltel(String principaltel) {
		this.principaltel = principaltel;
	}

	public String getPrincipalphone() {
		return principalphone;
	}

	public void setPrincipalphone(String principalphone) {
		this.principalphone = principalphone;
	}

	public String getPrincipalemail() {
		return principalemail;
	}

	public void setPrincipalemail(String principalemail) {
		this.principalemail = principalemail;
	}

	public String getSendaddr() {
		return sendaddr;
	}

	public void setSendaddr(String sendaddr) {
		this.sendaddr = sendaddr;
	}

	public String getAcctno() {
		return acctno;
	}

	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}

	public String getAcctname() {
		return acctname;
	}

	public void setAcctname(String acctname) {
		this.acctname = acctname;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getAcctfid() {
		return acctfid;
	}

	public void setAcctfid(String acctfid) {
		this.acctfid = acctfid;
	}

	public String getDeacctno() {
		return deacctno;
	}

	public void setDeacctno(String deacctno) {
		this.deacctno = deacctno;
	}

	public String getDeacctname() {
		return deacctname;
	}

	public void setDeacctname(String deacctname) {
		this.deacctname = deacctname;
	}

	public String getDebankname() {
		return debankname;
	}

	public void setDebankname(String debankname) {
		this.debankname = debankname;
	}

	public String getAccttype() {
		return accttype;
	}

	public void setAccttype(String accttype) {
		this.accttype = accttype;
	}

	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public String getCatetype() {
		return catetype;
	}

	public void setCatetype(String catetype) {
		this.catetype = catetype;
	}

	public String getChainhead() {
		return chainhead;
	}

	public void setChainhead(String chainhead) {
		this.chainhead = chainhead;
	}

	public String getRecpers() {
		return recpers;
	}

	public void setRecpers(String recpers) {
		this.recpers = recpers;
	}

	public String getRecconntel() {
		return recconntel;
	}

	public void setRecconntel(String recconntel) {
		this.recconntel = recconntel;
	}

	public String getReccertno() {
		return reccertno;
	}

	public void setReccertno(String reccertno) {
		this.reccertno = reccertno;
	}

	public String getSignstatus() {
		return signstatus;
	}

	public void setSignstatus(String signstatus) {
		this.signstatus = signstatus;
	}

	public String getProvcode() {
		return provcode;
	}

	public void setProvcode(String provcode) {
		this.provcode = provcode;
	}

	public String getBailtype() {
		return bailtype;
	}

	public void setBailtype(String bailtype) {
		this.bailtype = bailtype;
	}

	public String getServbound() {
		return servbound;
	}

	public void setServbound(String servbound) {
		this.servbound = servbound;
	}

	public String getCompactno() {
		return compactno;
	}

	public void setCompactno(String compactno) {
		this.compactno = compactno;
	}

	public String getCompactname() {
		return compactname;
	}

	public void setCompactname(String compactname) {
		this.compactname = compactname;
	}

	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getSigntime() {
		return signtime;
	}

	public void setSigntime(String signtime) {
		this.signtime = signtime;
	}

	public String getCompacttype() {
		return compacttype;
	}

	public void setCompacttype(String compacttype) {
		this.compacttype = compacttype;
	}

	public String getLicenceno() {
		return licenceno;
	}

	public void setLicenceno(String licenceno) {
		this.licenceno = licenceno;
	}

	public String getBail() {
		return bail;
	}

	public void setBail(String bail) {
		this.bail = bail;
	}

	public String getBaillwrlmt() {
		return baillwrlmt;
	}

	public void setBaillwrlmt(String baillwrlmt) {
		this.baillwrlmt = baillwrlmt;
	}

	public String getLicvalidate() {
		return licvalidate;
	}

	public void setLicvalidate(String licvalidate) {
		this.licvalidate = licvalidate;
	}

	public String getBailstatus() {
		return bailstatus;
	}

	public void setBailstatus(String bailstatus) {
		this.bailstatus = bailstatus;
	}

	public String getIsunpb() {
		return isunpb;
	}

	public void setIsunpb(String isunpb) {
		this.isunpb = isunpb;
	}

	public String getIsb2m() {
		return isb2m;
	}

	public void setIsb2m(String isb2m) {
		this.isb2m = isb2m;
	}

	public String getSmsmobileno() {
		return smsmobileno;
	}

	public void setSmsmobileno(String smsmobileno) {
		this.smsmobileno = smsmobileno;
	}

	public String getNextstepid() {
		return nextstepid;
	}

	public void setNextstepid(String nextstepid) {
		this.nextstepid = nextstepid;
	}

	public String getStepid() {
		return stepid;
	}

	public void setStepid(String stepid) {
		this.stepid = stepid;
	}

	public String getLastStepid() {
		return lastStepid;
	}

	public void setLastStepid(String lastStepid) {
		this.lastStepid = lastStepid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuditstatus_work() {
		return auditstatus_work;
	}

	public void setAuditstatus_work(String auditstatus_work) {
		this.auditstatus_work = auditstatus_work;
	}

	public String getSeqid() {
		return seqid;
	}

	public void setSeqid(String seqid) {
		this.seqid = seqid;
	}

	public String getWaytype() {
		return waytype;
	}

	public void setWaytype(String waytype) {
		this.waytype = waytype;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getDebankid() {
		return debankid;
	}

	public void setDebankid(String debankid) {
		this.debankid = debankid;
	}

	public String getDestate() {
		return destate;
	}

	public void setDestate(String destate) {
		this.destate = destate;
	}

	public String getCusttype() {
		return custtype;
	}

	public void setCusttype(String custtype) {
		this.custtype = custtype;
	}

	public String getIstietong() {
		return istietong;
	}

	public void setIstietong(String istietong) {
		this.istietong = istietong;
	}

	public String getConnecttype() {
		return connecttype;
	}

	public void setConnecttype(String connecttype) {
		this.connecttype = connecttype;
	}

	public String getSublayer() {
		return sublayer;
	}

	public void setSublayer(String sublayer) {
		this.sublayer = sublayer;
	}

	public String getBuztypecode() {
		return buztypecode;
	}

	public void setBuztypecode(String buztypecode) {
		this.buztypecode = buztypecode;
	}

	public String getRegid() {
		return regid;
	}

	public void setRegid(String regid) {
		this.regid = regid;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getIskzcz() {
		return iskzcz;
	}

	public void setIskzcz(String iskzcz) {
		this.iskzcz = iskzcz;
	}

	public String getStarlev() {
		return starlev;
	}

	public void setStarlev(String starlev) {
		this.starlev = starlev;
	}

	public String getUniquewayid() {
		return uniquewayid;
	}

	public void setUniquewayid(String uniquewayid) {
		this.uniquewayid = uniquewayid;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getProvtype() {
		return provtype;
	}

	public void setProvtype(String provtype) {
		this.provtype = provtype;
	}

	public String getMobilemall() {
		return mobilemall;
	}

	public void setMobilemall(String mobilemall) {
		this.mobilemall = mobilemall;
	}

	public String getFrontarea() {
		return frontarea;
	}

	public void setFrontarea(String frontarea) {
		this.frontarea = frontarea;
	}

	public String getIspconntype() {
		return ispconntype;
	}

	public void setIspconntype(String ispconntype) {
		this.ispconntype = ispconntype;
	}

	public String getMainlayer() {
		return mainlayer;
	}

	public void setMainlayer(String mainlayer) {
		this.mainlayer = mainlayer;
	}

	public String getBuzphoneno() {
		return buzphoneno;
	}

	public void setBuzphoneno(String buzphoneno) {
		this.buzphoneno = buzphoneno;
	}

	public String getCooperator() {
		return cooperator;
	}

	public void setCooperator(String cooperator) {
		this.cooperator = cooperator;
	}

	public String getTaxtype() {
		return taxtype;
	}

	public void setTaxtype(String taxtype) {
		this.taxtype = taxtype;
	}

	public String getDistype() {
		return distype;
	}

	public void setDistype(String distype) {
		this.distype = distype;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getLinkmantel() {
		return linkmantel;
	}

	public void setLinkmantel(String linkmantel) {
		this.linkmantel = linkmantel;
	}

	public String getLinkmanemail() {
		return linkmanemail;
	}

	public void setLinkmanemail(String linkmanemail) {
		this.linkmanemail = linkmanemail;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCoplevel() {
		return coplevel;
	}

	public void setCoplevel(String coplevel) {
		this.coplevel = coplevel;
	}

	public String getBusnum() {
		return busnum;
	}

	public void setBusnum(String busnum) {
		this.busnum = busnum;
	}

	public String getCertitype() {
		return certitype;
	}

	public void setCertitype(String certitype) {
		this.certitype = certitype;
	}

	public String getRegadress() {
		return regadress;
	}

	public void setRegadress(String regadress) {
		this.regadress = regadress;
	}

	public String getRegcapital() {
		return regcapital;
	}

	public void setRegcapital(String regcapital) {
		this.regcapital = regcapital;
	}

	public String getCompanytype() {
		return companytype;
	}

	public void setCompanytype(String companytype) {
		this.companytype = companytype;
	}

	public String getBrole() {
		return brole;
	}

	public void setBrole(String brole) {
		this.brole = brole;
	}

	public String getCertinum() {
		return certinum;
	}

	public void setCertinum(String certinum) {
		this.certinum = certinum;
	}

	public String getCopbound() {
		return copbound;
	}

	public void setCopbound(String copbound) {
		this.copbound = copbound;
	}

	public String getRunareatype() {
		return runareatype;
	}

	public void setRunareatype(String runareatype) {
		this.runareatype = runareatype;
	}

	public String getCalcumode() {
		return calcumode;
	}

	public void setCalcumode(String calcumode) {
		this.calcumode = calcumode;
	}

	public String getUniformtime() {
		return uniformtime;
	}

	public void setUniformtime(String uniformtime) {
		this.uniformtime = uniformtime;
	}

	public String getComefrom() {
		return comefrom;
	}

	public void setComefrom(String comefrom) {
		this.comefrom = comefrom;
	}

	public String getCompactpath() {
		return compactpath;
	}

	public void setCompactpath(String compactpath) {
		this.compactpath = compactpath;
	}

	public String getLicencepath() {
		return licencepath;
	}

	public void setLicencepath(String licencepath) {
		this.licencepath = licencepath;
	}

	public String getHasRight() {
		return hasRight;
	}

	public void setHasRight(String hasRight) {
		this.hasRight = hasRight;
	}

	public String getWorktype() {
		return worktype;
	}

	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}

	public String getIstop() {
		return istop;
	}

	public void setIstop(String istop) {
		this.istop = istop;
	}
	
}
