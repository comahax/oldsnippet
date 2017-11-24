package com.gmcc.pboss.biz.info.reward.service.impl;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.gmcc.pboss.biz.info.reward.model.RewardTotal;
import com.gmcc.pboss.biz.info.reward.service.RewardService;
import com.gmcc.pboss.biz.info.reward.support.RewardTotalQueryParameterProcessor;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.util.CommonUtil;

public class RewardTotalServiceImpl extends AbstractRewardService implements RewardService {

	private static Logger logger = Logger.getLogger(RewardTotalServiceImpl.class);
	
	//CommunicatePlateauDaoHibernate cpDao = (CommunicatePlateauDaoHibernate)this.getDao();
//	ChPwAdvinfo advinfo = (ChPwAdvinfo)cpDao.get(advinfoid);
	
	private BaseDao rewardRecordDao;
	
	/**
	 * @return the rewardRecordDao
	 */
	public BaseDao getRewardRecordDao() {
		return rewardRecordDao;
	}

	/**
	 * @param rewardRecordDao the rewardRecordDao to set
	 */
	public void setRewardRecordDao(BaseDao rewardRecordDao) {
		this.rewardRecordDao = rewardRecordDao;
	}


	public RewardTotalServiceImpl() {
		super();
		this.setServiceCode(ServiceCode.REWARDREPORT_TOTAL);
		this.setServiceName("��ʵ��֧����𱨱�");
		
		setProcessor(new RewardTotalQueryParameterProcessor());
	}

	// ����ҵ������
	public QueryResult getAll(QueryParameter parameter) {
		QueryResult result = super.getAll(parameter);
		Iterator iter = result.getData().iterator();
		//@@�����޸ĵ�
		while (iter.hasNext()) {
			RewardTotal record = (RewardTotal) iter.next();
			record.setRewardtypeName(Constant.getConstantName(ConstantsType.SOCIETY_REWARD_TPYPE, record.getRewardtype().toString()));

			//���ںϳ�
			record.setRewardmonth1(CommonUtil.getShowMonth(record.getRewardmonth1()));
			if (StringUtils.isNotEmpty(record.getRewardmonth2())){
			//���ںϳ�
				record.setRewardmonth2(CommonUtil.getShowMonth(record.getRewardmonth2()));
			}
			//���ںϳ�
			if (StringUtils.isNotEmpty(record.getRewardmonth3())){
				record.setRewardmonth3(CommonUtil.getShowMonth(record.getRewardmonth3()));
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.service.impl.BaseServiceImpl#queryForOne(com.gmcc.pboss.common.bean.LoginMember, com.gmcc.pboss.common.support.QueryParameter)
	 */
//	@Override
//	public ServiceResult queryForOne(LoginMember member,
//			QueryParameter parameter) {
//		// TODO Auto-generated method stub
//		//��ȡ������Ϣ
//		RewardQueryParameter param = (RewardQueryParameter)parameter; 
//		ServiceResult result = new ServiceResult();
//		result.setSuccess(false);
//		result.setRetCode(MemberServiceRetCode.FAIL);
//		try{
//			Long advinfoid = new Long(param.getOpnid());//��Stringת��Long
//			ChPwAdvinfo advinfo = (ChPwAdvinfo) this.communicatePlateauDao.get(advinfoid);
//			result.setSuccess(true);
//			result.setRetCode(MemberServiceRetCode.SUCCESS);
//			result.setRetObject(advinfo);
//		}catch(Exception e){
//			logger.error("RewardTotalServiceImpl.queryForOne(��ȡ������Ϣ[id="+ param.getOpnid() +"]����):"+e.getMessage());
//			result.setSuccess(false);
//			result.setRetCode(RewardServiceRetCode.ADVINFO_ERROR);
//		}
//		return result;
//	}
	
	
}
