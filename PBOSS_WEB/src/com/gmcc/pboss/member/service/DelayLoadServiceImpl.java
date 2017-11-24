package com.gmcc.pboss.member.service;

import java.util.ArrayList;
import java.util.Map;

import com.gmcc.pboss.biz.info.node.model.ChDstCooperator;
import com.gmcc.pboss.biz.info.node.service.ChDstCooperatorService;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.member.dao.IMemberDao;
import com.gmcc.pboss.member.model.Employee;
import com.gmcc.pboss.menu.service.SaDbWebfunctionitemService;

public class DelayLoadServiceImpl extends BaseServiceImpl implements
		IDelayLoadService {
	public DelayLoadServiceImpl(){
		super();
		this.serviceCode = ServiceCode.MEMBER_INFO_DELAT_LOAD;
		this.serviceName = "��Ա����";
		this.isNeedLogin = true;// ��Ҫ��¼		
	}
	
	private IMemberDao memberDao;
	/** ע��ChDstCooperatorService�ӿ�,���ݵ�½�û�����id���ҷ���������*/
	private ChDstCooperatorService chDstCooperatorService;
	
	/**���ز˵���Service���˵���Ϣ�������ݿ��SA_DB_WEBFUNCTIONITEM��*/
	private SaDbWebfunctionitemService saDbWebfunctionitemService;
	
	public LoginMember fillMember(LoginMember member){
		if(member.getIsnet() == 5 || member.getIsnet() == 6){
			//���ز˵���
			Map<String,ArrayList> menuMap = this.saDbWebfunctionitemService.getMenuMap(member.getCityid(),Integer.parseInt(member.getIsnet().toString()));
			member.setMenuMap(menuMap);
			
			member.setInfoloaded(true);
			
			return member;
		}
		//��ȡ��������Ϣ
		ChDstCooperator cooperator = this.chDstCooperatorService.getByWayid(member.getChannel().getWayid());
		//��ȡ����������Ϣ
		Employee mag = this.getById(member.getChannel().getWaymagcode());
		member.setIsShowReward(this.saDbWebfunctionitemService.getShowReward(member.getCityid()));
		member.setIsShowLocalReward(this.saDbWebfunctionitemService.getShowLocalReward(member.getCityid()));
		if(cooperator!=null){
			member.setRecpers(cooperator.getRecpers());
			member.setAcctno(cooperator.getAcctno());
			member.setBankname(cooperator.getBankname());
		}
		if(mag!=null){
			member.setMagName(mag.getEmployeename());
		}
		//���ز˵���
		Map<String,ArrayList> menuMap = this.saDbWebfunctionitemService.getMenuMap(member.getCityid(),Integer.parseInt(member.getIsnet().toString()));
		member.setMenuMap(menuMap);
		
		member.setInfoloaded(true);
		
		return member;
	}
	
	public Employee getById(String id) {
		// TODO Auto-generated method stub
		Employee emp = this.memberDao.getById(id);
		return emp;
	}

	public void setMemberDao(IMemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void setChDstCooperatorService(
			ChDstCooperatorService chDstCooperatorService) {
		this.chDstCooperatorService = chDstCooperatorService;
	}

	public void setSaDbWebfunctionitemService(
			SaDbWebfunctionitemService saDbWebfunctionitemService) {
		this.saDbWebfunctionitemService = saDbWebfunctionitemService;
	}
}
