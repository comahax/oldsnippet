package test.com.gmcc.pboss.common;

import java.util.List;

import com.gmcc.pboss.biz.info.regactInfo.model.MhTkRegactinfo;
import com.gmcc.pboss.biz.info.regactInfo.service.RegactInfoService;
import com.gmcc.pboss.biz.info.regactInfo.support.RegactInfoQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.member.support.MemberQueryParameter;

import test.com.gmcc.pboss.common.BaseTest;

public class CommonTest extends BaseTest {


	/**登录时所用参数：
	 * inputCode
	 * officeTel
	 * */
	private MemberQueryParameter loginParameter;

	/**
	 * @return the loginParameter
	 */
	public MemberQueryParameter getLoginParameter() {
		return loginParameter;
	}


	/**
	 * @param loginParameter the loginParameter to set
	 */
	public void setLoginParameter(MemberQueryParameter loginParameter) {
		this.loginParameter = loginParameter;
	}


	public void testQuery() {
		//测试手机号码归属地
		System.out.println();
	}

}
