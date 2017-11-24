package com.gmcc.pboss.control.examine.importcoefficient;

import java.util.List;

import com.gmcc.pboss.business.cms.examine.coefficient.control.Coefficient;
import com.gmcc.pboss.business.cms.examine.coefficient.control.CoefficientBO;
import com.gmcc.pboss.business.cms.examine.coefficient.persistent.CoefficientListVO;
import com.gmcc.pboss.business.cms.examine.coefficient.persistent.CoefficientVO;
import com.gmcc.pboss.business.cms.examine.rewardasse.RewardasseVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.examine.rewardasse.Rewardasse;
import com.gmcc.pboss.control.examine.rewardasse.RewardasseBO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class ImportCoefficientBO extends AbstractControlBean implements ImportCoefficient{

	public void doImport(String exmnperiod) throws Exception{
		String paramValue = null;
		Sysparam paramBO = (Sysparam) BOFactory.build(SysparamBO.class,user);
		
//		���ݡ�ϵͳ��ʶ[SYSTEMID]��=1������������[PARAMTYPE]��=��pboss_kh�����ҡ�ϵͳ����[IB_GL_SYSPARAM]����
//		����ȡ������ֵ[PARAMVALUE]�������Ϊ0��������˳������Ϊ1����ֱ�������¸�����ϵ��ϵͳ����������Ӧ�߼���
		paramValue = paramBO.doFindByID("1", "pboss_kh");
		if("0".equals(paramValue))
			return ;
		else if("1".equals(paramValue)){
			//��׼���̶���𿼺�ϵ��
			paramValue = paramBO.doFindByID("2", "pboss_kh");
			if(!"-1".equals(paramValue)){
				doStandardImmutable(exmnperiod,Long.parseLong(paramValue));
			}
			//��׼�����ֳ�𿼺�ϵ��
			paramValue = paramBO.doFindByID("3", "pboss_kh");
			if(!"-1".equals(paramValue)){
				doStandardIntegral(exmnperiod,Long.parseLong(paramValue));
			}
			//��׼��ר�Ž�������ϵ��
			paramValue = paramBO.doFindByID("4", "pboss_kh");
			if(!"-1".equals(paramValue)){
				doStandardBaksheesh(exmnperiod,Long.parseLong(paramValue));
			}
			
			//����ҵ�������𿼺�ϵ��
			paramValue = paramBO.doFindByID("5", "pboss_kh");
			if(!"-1".equals(paramValue)){
				doDataOperationBase(exmnperiod,Long.parseLong(paramValue));
			}
			
			//����ҵ������𿼺�ϵ��
			paramValue = paramBO.doFindByID("6", "pboss_kh");
			if(!"-1".equals(paramValue)){
				doDataOperationEncouragement(exmnperiod,Long.parseLong(paramValue));
			}
			
			//����ҵ�������𿼺�ϵ��
			paramValue = paramBO.doFindByID("7", "pboss_kh");
			if(!"-1".equals(paramValue)){
				doServerOperationBase(exmnperiod,Long.parseLong(paramValue));
			}
			
			//����ҵ������𿼺�ϵ��
			paramValue = paramBO.doFindByID("8", "pboss_kh");
			if(!"-1".equals(paramValue)){
				doServerOperationEncouragement(exmnperiod,Long.parseLong(paramValue));
			}
			
			//�Ǽ���𿼺�ϵ��
			paramValue = paramBO.doFindByID("9", "pboss_kh");
			if(!"-1".equals(paramValue)){
				doStarLevel(exmnperiod,Long.parseLong(paramValue));
			}
			
			//��Ŀ�����𿼺�ϵ��
			paramValue = paramBO.doFindByID("10", "pboss_kh");
			if(!"-1".equals(paramValue)){
				doProjectStart(exmnperiod,Long.parseLong(paramValue));
			}
			
			//�������޽�����ϵ��
			paramValue = paramBO.doFindByID("11", "pboss_kh");
			if(!"-1".equals(paramValue)){
				doCooperateAward(exmnperiod,Long.parseLong(paramValue));
			}
//			
//			//ȫ������ϵ��
//			paramValue = paramBO.doFindByID("12", "pboss_kh");
//			if(!"-1".equals(paramValue)){
//				doAllCoefficient(exmnperiod,Long.parseLong(paramValue));
//			}
		}
	}
	
	
	public void doAddRewardasse(String exmnperiod,Long exmnid,Integer rewardtype) throws Exception{
		Coefficient coefficientBO = (Coefficient) BOFactory.build(CoefficientBO.class,user);
		Rewardasse rewardasseBO = (Rewardasse)BOFactory.build(RewardasseBO.class,user);
		CoefficientListVO param = new CoefficientListVO();
		param.setQueryAll(true);
		param.setDataOnly(true);
		param.getQueryConditions().put("EXMNID", exmnid);
		param.getQueryConditions().put("EXMNPERIOD", exmnperiod);
		DataPackage dp = coefficientBO.doQueryByNameSql("com.gmcc.pboss.business.cms.examine.coefficient.persistent.queryCoefficientUnion_CH_PW_COEFFICIENT_AND_CH_PW_COEFREVISION", param);
		if( null != dp && null != dp.getDatas() && !dp.getDatas().isEmpty()){
			for(CoefficientVO vo:(List<CoefficientVO>) dp.getDatas()){
				RewardasseVO rewardassVO = new RewardasseVO();
				rewardassVO.setWayid(vo.getWayid());
				rewardassVO.setAssemonth(vo.getExmnperiod());
				rewardassVO.setAssegrade(vo.getCoefficient().floatValue());
				rewardassVO.setRewardtype(rewardtype);
				
				rewardasseBO.doCreate(rewardassVO);
			}
		}
	}
	/**
	 * ��׼���̶���𿼺�ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doStandardImmutable(String exmnperiod,Long exmnid) throws Exception{
		doAddRewardasse(exmnperiod,exmnid,0);
	}
	
	/**
	 * ��׼�����ֳ�𿼺�ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doStandardIntegral(String exmnperiod,Long exmnid) throws Exception{
		doAddRewardasse(exmnperiod,exmnid,1);
	}
	
	
	/**
	 * ��׼��ר�Ž�������ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doStandardBaksheesh(String exmnperiod,Long exmnid) throws Exception{
		doAddRewardasse(exmnperiod,exmnid,2);
	}
	
	/**
	 * ����ҵ�������𿼺�ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doDataOperationBase(String exmnperiod,Long exmnid) throws Exception{
		doAddRewardasse(exmnperiod,exmnid,3);
	}
	
	/**
	 * ����ҵ������𿼺�ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doDataOperationEncouragement(String exmnperiod,Long exmnid) throws Exception{
		doAddRewardasse(exmnperiod,exmnid,4);
	}
	
	/**
	 * ����ҵ�������𿼺�ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doServerOperationBase(String exmnperiod,Long exmnid) throws Exception{
		doAddRewardasse(exmnperiod,exmnid,5);
	}
	
	/**
	 * ����ҵ������𿼺�ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doServerOperationEncouragement(String exmnperiod,Long exmnid) throws Exception{
		doAddRewardasse(exmnperiod,exmnid,6);
	}
	/**
	 * �Ǽ���𿼺�ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doStarLevel(String exmnperiod,Long exmnid) throws Exception{
		doAddRewardasse(exmnperiod,exmnid,7);
	}
	
	
	/**
	 * ��Ŀ�����𿼺�ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doProjectStart(String exmnperiod,Long exmnid) throws Exception{
		doAddRewardasse(exmnperiod,exmnid,8);
	}
	
	/**
	 * �������޽�����ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doCooperateAward(String exmnperiod,Long exmnid) throws Exception{
		doAddRewardasse(exmnperiod,exmnid,30);
	}
	
	/**
	 * ȫ������ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doAllCoefficient(String exmnperiod,Long exmnid) throws Exception{
//		doAddRewardasse(exmnperiod,exmnid,99);
		doStandardIntegral(exmnperiod,exmnid);
		doStandardImmutable(exmnperiod,exmnid);
		doStandardBaksheesh(exmnperiod,exmnid);
		doDataOperationBase(exmnperiod,exmnid);
		doDataOperationEncouragement(exmnperiod,exmnid);
		doServerOperationBase(exmnperiod,exmnid);
		doServerOperationEncouragement(exmnperiod,exmnid);
		doStarLevel(exmnperiod,exmnid);
		doProjectStart(exmnperiod,exmnid);
		doCooperateAward(exmnperiod,exmnid);
	}

}
