package test.com.gmcc.pboss.biz.info.reward.action;

import com.gmcc.pboss.biz.info.reward.action.OperationAction;

import test.com.gmcc.pboss.common.BaseTest;

public class OperationActionTest extends BaseTest {

	private OperationAction operationAction;

	public OperationAction getOperationAction() {
		return operationAction;
	}

	public void setOperationAction(OperationAction operationAction) {
		this.operationAction = operationAction;
	}

	public void testQuery() {
		getOperationAction().doQuery();
	}
}
