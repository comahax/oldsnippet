package net.gmcc.pboss.domain.business.terminalReward;


@javax.jws.WebService(targetNamespace = "http://terminalReward.business.domain.pboss.gmcc.net/", serviceName = "TerminalRewardServiceService", portName = "TerminalRewardServicePort", wsdlLocation = "/data/TerminalRewardServiceService.wsdl")
public class TerminalRewardServiceDelegate {

	net.gmcc.pboss.domain.business.terminalReward.TerminalRewardService terminalRewardService = new net.gmcc.pboss.domain.business.terminalReward.TerminalRewardService();

	public String queryTerminalReward(String wayid, String remonth) {
		return terminalRewardService.queryTerminalReward(wayid, remonth);
	}

}