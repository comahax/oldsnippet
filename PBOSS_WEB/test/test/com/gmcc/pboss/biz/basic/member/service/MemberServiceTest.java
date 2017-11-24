package test.com.gmcc.pboss.biz.basic.member.service;

import java.util.Date;

import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.exception.TransactionProcessionException;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.member.service.EmployeeApplyService;
import com.gmcc.pboss.member.service.IMemberService;
import com.gmcc.pboss.member.support.EmployeeApplyParameter;
import com.gmcc.pboss.member.support.MemberQueryParameter;
import com.gmcc.pboss.model.employee.ChPwEmployeeapply;

import test.com.gmcc.pboss.common.BaseTest;

public class MemberServiceTest extends BaseTest {

	private EmployeeApplyService employeeApplyService;
	
	/**
	 * @return the employeeApplyService
	 */
	public EmployeeApplyService getEmployeeApplyService() {
		return employeeApplyService;
	}


	/**
	 * @param employeeApplyService the employeeApplyService to set
	 */
	public void setEmployeeApplyService(EmployeeApplyService employeeApplyService) {
		this.employeeApplyService = employeeApplyService;
	}


	public void testEmployeeApply() {
		LoginMember member = new LoginMember();
		member.setCityid("ZS");
		member.setWayid("CH_2323");
		
		EmployeeApplyParameter eaParam = new EmployeeApplyParameter();
		
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		System.out.println("Employee Apply!");
		
		ChPwEmployeeapply saveObj = new ChPwEmployeeapply();
		saveObj.setEmployeename("Test");
		saveObj.setWayid("CH_2323");
		saveObj.setAuditstatus(Byte.valueOf("0"));
		saveObj.setOptime(new Date());
		eaParam.setApply(saveObj);
		
		try {
			employeeApplyService.transactionProcessing(member, eaParam, ServiceType.MODIFY);
		} catch (TransactionProcessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//登录测试

	/***
	 * 登录时所用Service
	 */
	private IMemberService memberService;
	
	
	
	//jUnit测试入门
	public void testLogin(){

		//检查登录参数是否为空
		MemberQueryParameter loginParameter = new MemberQueryParameter();
		loginParameter.setOfficeTel("13560697384");
		
		ServiceResult rslt = memberService.transact(null, loginParameter,ServiceType.INITIATE);
		System.out.println(rslt.isSuccess()+":["+ rslt.getMessage() + "]:");
	}


	/**
	 * @return the memberService
	 */
	public IMemberService getMemberService() {
		return memberService;
	}


	/**
	 * @param memberService the memberService to set
	 */
	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
	}

}
