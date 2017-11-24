package com.gmcc.pboss.biz.info.reward.service.impl;

import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.gmcc.pboss.biz.info.reward.service.AdtService;
import com.gmcc.pboss.biz.info.reward.service.FailService;
import com.gmcc.pboss.biz.info.reward.service.OperationService;
import com.gmcc.pboss.biz.info.reward.support.FailModelSetParameter;
import com.gmcc.pboss.biz.info.reward.support.RewardFailQueryParameter;
import com.gmcc.pboss.biz.info.reward.support.RewardFailQueryParameterProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceConditionCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.util.Assert;

/**
 * 
 * ���У��ʧ����Ϣ��ѯ
 * 
 */
public class FailServiceImpl extends QueryBaseServiceImpl implements FailService, InitializingBean {

	public FailServiceImpl() {
		this.isNeedLogin = true;
		this.serviceCode = ServiceCode.REWARDFAIL_SOCIETY;
		this.serviceName = "���У��ʧ����Ϣ_�������";
		setProcessor(new RewardFailQueryParameterProcessor());
	}

	private AdtService adtService;
	private OperationService operationService;

	private Map daos;

	public void setAdtService(AdtService adtService) {
		this.adtService = adtService;
	}

	public AdtService getAdtService() {
		return adtService;
	}

	public void setOperationService(OperationService operationService) {
		this.operationService = operationService;
	}

	public OperationService getOperationService() {
		return operationService;
	}

	public void setDaos(Map daos) {
		this.daos = daos;
	}

	public void afterPropertiesSet() throws Exception {
		Assert.notEmpty(daos, ServiceConditionCode.FAIL_DAOS_INIT, "daos û�б���ʼ����");
	}

	public ServiceResult query(LoginMember member, QueryParameter parameter) {

		determineDao((RewardFailQueryParameter) parameter);
		return super.query(member, parameter);

	}

	public QueryResult getAll(QueryParameter parameter) {
		QueryResult result = super.getAll(parameter);
		Iterator iter = result.getData().iterator();
		while (iter.hasNext()) {
			Object obj = iter.next();
			Assert.isTrue(FailModelSetParameter.class.isAssignableFrom(obj.getClass()), ServiceConditionCode.FAIL_ASSIGNABLE_FROM, obj.getClass().getName()
					+ " ���� " + FailModelSetParameter.class.getName() + " ��ʵ���࣡");

			setParameter((FailModelSetParameter) obj, (RewardFailQueryParameter) parameter);
		}
		return result;
	}

	/**
	 * 
	 * ��ֵ, �ο�
	 * {@link com.gmcc.pboss.biz.info.reward.support.FailModelSetParameter}
	 * 
	 */
	protected void setParameter(FailModelSetParameter remark, RewardFailQueryParameter parameter) {
		remark.setRemark(getAdtService().getRemark(remark.getAdtcode()));
		remark.setOpnname(getOperationService().getOperationName(remark.getOpnid()));
		remark.setRewardtypeName(Constant.getConstantName(ConstantsType.SOCIETY_REWARDVERIFIED_TPYPE, parameter.getType()));
	}

	/**
	 * 
	 * ���ݲ�ѯʱ parameter ���󴫵ݵ� type ֵ���� DAO
	 * 
	 */
	private void determineDao(RewardFailQueryParameter parameter) {
		BaseDao dao = (BaseDao) daos.get(parameter.getType());
		Assert.notNull(dao, ServiceConditionCode.FAIL_DAO, "�Ƿ��ĳ�����ͣ�");
		setDao(dao);
	}

}
