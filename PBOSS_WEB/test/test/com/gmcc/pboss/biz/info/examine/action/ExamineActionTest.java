package test.com.gmcc.pboss.biz.info.examine.action;

import com.gmcc.pboss.biz.info.examine.action.ChPwExmnRsltAction;
import com.gmcc.pboss.biz.info.reward.action.OperationAction;
import com.gmcc.pboss.common.bean.LoginMember;

import test.com.gmcc.pboss.common.BaseTest;

public class ExamineActionTest extends BaseTest{
	private ChPwExmnRsltAction chPwExmnRsltAction;

	/**
	 * @return the chPwExmnRsltAction
	 */
	public ChPwExmnRsltAction getChPwExmnRsltAction() {
		return chPwExmnRsltAction;
	}

	/**
	 * @param chPwExmnRsltAction the chPwExmnRsltAction to set
	 */
	public void setChPwExmnRsltAction(ChPwExmnRsltAction chPwExmnRsltAction) {
		this.chPwExmnRsltAction = chPwExmnRsltAction;
	}

	public void testQuery(){
		//ע���¼�û�
		LoginMember member = new LoginMember();
		member.setCityid("GZ");
		member.setWayid("CH_2323");
		member.setEmployeename("������_��Ա");
		member.setIsnet(Long.valueOf("0"));
		
//		examineAction.setTestMember(member);
		chPwExmnRsltAction.doList();
	}
}
