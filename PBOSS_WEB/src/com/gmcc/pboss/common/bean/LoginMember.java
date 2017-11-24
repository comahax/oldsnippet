package com.gmcc.pboss.common.bean;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.Role;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-7-29
 * 所属项目：
 * 所属模块：
 * 描述：用户登录后在Session中的对象。
 */
public class LoginMember implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7886524711501313042L;
	
	/**公务机号码*/
	private String 	officetel;
	/**渠道编码*/
	private String wayid;
	/**地市标识*/
	private String cityid;
	/**地市编号*/
	private String cityno;
	/**姓名*/
	private String employeename;
	/**雇员工号*/
	private String oprcode;
	/**是否为店主 isnet=0 表示 店员，isnet=1 表示 店主,isnet=5 表示 省公司管理员,isnet=6 表示 市公司管理员*/
	private Long isnet;
	/**角色名称*/
	private String roleName;
	/**所在服务厅*/
	private String servoffice;
	/**雇员Id 用于查询网点资料时使用*/
	private String employeeid;
	/**渠道*/
	private Channel channel;
	/**是否显示酬金模块*/
	private String isShowReward;
	/**是否显示本地酬金模块*/
	private String isShowLocalReward;
	/**分销合作商-收款人姓名*/
	private String recpers;
	/**分销合作商-收款人账户*/
	private String acctno;
	/**分销合作商-收款人开户行*/
	private String bankname;
	/**上级渠道经理名称*/
	private String magName;
	/**菜单项，可以从根开始向下遍历构成树 */
	private Map<String,ArrayList> menuMap;
	/**成员属性*/
	private Short empattr2;
	/**联系电话*/
	private String telephone;
	/**延迟信息是否加载 2012-07-12 史晓龙 */
	private boolean infoloaded;
	
	/*
	private String employeeid;
	private String oprcode;
	private Date birthday;
	private Long sex;
	private Long edulevel;
	private String nativehome;
	private Long polivisage;
	private String department;
	private Long station;
	private Long joblevel;
	private Date intime;
	private Long worktime;
	private Long hereworktime;
	private Long employtype;
	private String company;
	private String telephone;
	private String officetel;
	private Date outtime;
	private String outresult;
	private String homeaddr;
	private String cardid;
	private String waytype;
	private String pvtemail;
	private String ofcphone;
	private String ofcemail;
	private String speciality;
	private String countyid;
	private String svccode;
	private String posittype;
	private Long contacttype;
	private Long empstatus;
	private String actbank;
	private String actno;
	private String actname;
	private String actpid;
	private Double bail;
	private String gradschool;
	private Date gradtime;
	private Long ismarried;
	private Long outreason;
	private String trainlevel;
	private String hobby;
	private String character;
	private String asses;
	private String workhistry;
	private String prizeorpunish;
	private String empass;
	private Long right;
	private String netpass;
	private Long isopen;
	private String selectmobile;
	*/
	/**角色名称*/
	public String getRoleName() {
		//return roleName = (this.isnet == Long.valueOf("1"))?"店主":"店员";
		return Role.getRoleName(isnet.intValue());
	}
	/**渠道编码*/
	public String getWayid() {
		return wayid;
	}
	/**渠道编码*/
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	/**地市标识*/
	public String getCityid() {
		return cityid;
	}
	/**地市标识*/
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	/**姓名*/
	public String getEmployeename() {
		return employeename;
	}
	/**姓名*/
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	/**雇员工号*/
	public String getOprcode() {
		return oprcode;
	}
	/**雇员工号*/
	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}
	/**是否为店主 isnet=0 表示 店员，isnet=1 表示 店主,isnet=5 表示 省公司管理员,isnet=6 表示 市公司管理员*/
	public Long getIsnet() {
		return isnet;
	}
	/**是否为店主 isnet=0 表示 店员，isnet=1 表示 店主,isnet=5 表示 省公司管理员,isnet=6 表示 市公司管理员*/
	public void setIsnet(Long isnet) {
		this.isnet = isnet;
	}
	/**所在服务厅*/
	public String getServoffice() {
		return servoffice;
	}
	/**所在服务厅*/
	public void setServoffice(String servoffice) {
		this.servoffice = servoffice;
	}
	/**公务机号码*/
	public String getOfficetel() {
		return officetel;
	}
	/**公务机号码*/
	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}
	/**地市编号*/
	public String getCityno() {
		return cityno;
	}
	/**地市编号*/
	public void setCityno(String cityid) {
		this.cityno = Constant.getConstantName(ConstantsType.BRANCH_NO, cityid);
	}
	/**雇员Id 用于查询网点资料时使用*/
	public String getEmployeeid() {
		return employeeid;
	}
	/**雇员Id 用于查询网点资料时使用*/
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	/**渠道*/
	public Channel getChannel() {
		return channel;
	}
	/**渠道*/
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public String getIsShowReward() {
		return isShowReward;
	}
	public void setIsShowReward(String isShowReward) {
		this.isShowReward = isShowReward;
	}
	public String getIsShowLocalReward() {
		return isShowLocalReward;
	}
	public void setIsShowLocalReward(String isShowLocalReward) {
		this.isShowLocalReward = isShowLocalReward;
	}
	
	public String getRecpers() {
		return recpers;
	}
	public void setRecpers(String recpers) {
		this.recpers = recpers;
	}
	public String getAcctno() {
		return acctno;
	}
	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	
	public String getMagName() {
		return magName;
	}
	public void setMagName(String magName) {
		this.magName = magName;
	}
	
	public Map<String, ArrayList> getMenuMap() {
		if(menuMap==null){
			menuMap = new HashMap<String,ArrayList>();
		}
		return menuMap;
	}
	public void setMenuMap(Map<String, ArrayList> menuMap) {
		this.menuMap = menuMap;
	}
	public Short getEmpattr2() {
		return empattr2;
	}
	public void setEmpattr2(Short empattr2) {
		this.empattr2 = empattr2;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public boolean isInfoloaded() {
		return infoloaded;
	}
	public void setInfoloaded(boolean infoloaded) {
		this.infoloaded = infoloaded;
	}
}
