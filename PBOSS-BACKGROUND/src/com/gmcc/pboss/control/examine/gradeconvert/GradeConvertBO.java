package com.gmcc.pboss.control.examine.gradeconvert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.business.cms.examine.coefficient.control.Coefficient;
import com.gmcc.pboss.business.cms.examine.coefficient.control.CoefficientBO;
import com.gmcc.pboss.business.cms.examine.coefficient.persistent.CoefficientVO;
import com.gmcc.pboss.business.cms.examine.exmnrslt.control.Exmnrslt;
import com.gmcc.pboss.business.cms.examine.exmnrslt.control.ExmnrsltBO;
import com.gmcc.pboss.business.cms.examine.exmnrslt.persistent.ExmnrsltListVO;
import com.gmcc.pboss.business.cms.examine.exmnrslt.persistent.ExmnrsltVO;
import com.gmcc.pboss.business.cms.examine.mapping.control.Mapping;
import com.gmcc.pboss.business.cms.examine.mapping.control.MappingBO;
import com.gmcc.pboss.business.cms.examine.mapping.persistent.MappingListVO;
import com.gmcc.pboss.business.cms.examine.mapping.persistent.MappingVO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class GradeConvertBO extends AbstractControlBean implements GradeConvert{
	private Log log = LogFactory.getLog(GradeConvertBO.class);
	
	public void process(String stateTime) throws Exception {
		// TODO Auto-generated method stub
//		���ݡ���������[EXMNPERIOD]�����������£��ӡ����˽��[CH_PW_EXMNRSLT]�����л�ȡ���м�¼�������ü�¼����
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		Date stateDate = null;
		try{
			stateDate = format.parse(stateTime);
		}catch(Exception e){
			System.out.println("===============��������������["+stateTime+"]  ��ʽ ����ȷ��yyyyMM)");
			return;
		}
		Exmnrslt exmnrsltControl = (ExmnrsltBO) BOFactory.build(ExmnrsltBO.class,user);
		
		ExmnrsltListVO exmnrsltParam = new ExmnrsltListVO();
		exmnrsltParam.setQueryAll(true);
		exmnrsltParam.setDataOnly(true);
		exmnrsltParam.set_se_exmnperiod(stateTime);
		
		DataPackage exmnrsltDP = exmnrsltControl.doQuery(exmnrsltParam);
		if( null != exmnrsltDP && null != exmnrsltDP.getDatas() && !exmnrsltDP.getDatas().isEmpty()){
			Iterator exmnrsltIterator = exmnrsltDP.getDatas().iterator();
			GradeConvertBO bo = (GradeConvertBO)BOFactory.build(GradeConvertBO.class,user);
			while(exmnrsltIterator.hasNext()){
				try{
					ExmnrsltVO exmnrsltVO = (ExmnrsltVO)exmnrsltIterator.next();
					bo.doGradeConvert(exmnrsltVO);
				}catch(Exception e){
					e.printStackTrace();
					LoggerUtils.error(e, log);
				}				
			}
		}
	}
	
	
	public void doGradeConvert(ExmnrsltVO exmnrsltVO) throws Exception {
//		a)	���ݡ����˱�ʶ[EXMNID]���͡����б�ʶ[CITYID]���ӡ�����ӳ��[CH_PW_MAPPING]�����л�ȡ��ӳ�䷽ʽ[MMODE]����
		Mapping mappingControl = (MappingBO)BOFactory.build(MappingBO.class,user);
		MappingListVO mappingParam = new MappingListVO();
		mappingParam.setQueryAll(true);
		mappingParam.setDataOnly(true);
		mappingParam.set_ne_exmnid(""+exmnrsltVO.getExmnid());
		mappingParam.set_se_cityid(user.getCityid());
		DataPackage mappingDP = mappingControl.doQuery(mappingParam);
		if( null == mappingDP || null == mappingDP.getDatas() || mappingDP.getDatas().isEmpty()){
//			b)	����ÿ����ڡ�����ӳ��[CH_PW_MAPPING]����û������ӳ����Ϣ��
//			������һ�ʼ�¼������ϵ��[CH_PW_COEFFICIENT]�����У����С�ϵ��ֵ[COEFFICIENT]
//			 ��Ϊ����������˵Ŀ��˷���������������һ�����˽����¼��
			Coefficient coefficientControl = (CoefficientBO)BOFactory.build(CoefficientBO.class,user);
			CoefficientVO coefficientVO = new CoefficientVO();
			coefficientVO.setExmnid(exmnrsltVO.getExmnid());
			coefficientVO.setWayid(exmnrsltVO.getWayid());
			coefficientVO.setExmnperiod(exmnrsltVO.getExmnperiod());
			coefficientVO.setCoefficient(exmnrsltVO.getExmnmark());
			coefficientControl.doCreate(coefficientVO);
		}else{
			List mapingList = (List)mappingDP.getDatas();
//			c)	���ݡ����˷��������ҷ�����Ӧ���䣻�޶�Ӧӳ�����䣬������һ�ʼ�¼������ϵ��[CH_PW_COEFFICIENT]�����У�
//			���С�ϵ��ֵ[COEFFICIENT]��Ϊ0������������һ�����˽����¼�������ȡ��ӳ���¼�ġ�ӳ�䷽ʽ[MMODE]����
//			�жϡ�ӳ�䷽ʽ[MMODE]�������Ϊ��������[0]����������һ�ʼ�¼������ϵ��[CH_PW_COEFFICIENT]�����У�
//			���С�ϵ��ֵ[COEFFICIENT]��Ϊ��ӳ��ϵ��/����[COEFORBASE]�������Ϊ��������[1]����
//			������һ�ʼ�¼��������ϵ��[CH_PW_COEFFICIENT]�����У����С�ϵ��ֵ[COEFFICIENT]��Ϊ�����˷���[EXMNMARK]��/��ӳ��ϵ��/����[COEFORBASE]��
//			������������һ�����˽����¼��
			Coefficient coefficientControl = (CoefficientBO)BOFactory.build(CoefficientBO.class,user);
			int i = 0;
			for(;i<mapingList.size();i++){
				MappingVO mappingVO = (MappingVO)mapingList.get(i);
				if(mappingVO.getMarkll().doubleValue()<= exmnrsltVO.getExmnmark().doubleValue() 
						&& exmnrsltVO.getExmnmark().doubleValue()<mappingVO.getMarkul().doubleValue()){
					if("0".equals(mappingVO.getMmode())){
//						���Ϊ��������[0]����������һ�ʼ�¼������ϵ��[CH_PW_COEFFICIENT]�����У�
//						���С�ϵ��ֵ[COEFFICIENT]��Ϊ��ӳ��ϵ��/����[COEFORBASE]����
						CoefficientVO coefficientVO = new CoefficientVO();
						coefficientVO.setExmnid(exmnrsltVO.getExmnid());
						coefficientVO.setWayid(exmnrsltVO.getWayid());
						coefficientVO.setExmnperiod(exmnrsltVO.getExmnperiod());
						coefficientVO.setCoefficient(mappingVO.getCoeforbase());
						coefficientControl.doCreate(coefficientVO);									
					}else if("1".equals(mappingVO.getMmode())){
//						���Ϊ��������[1]����
//						������һ�ʼ�¼��������ϵ��[CH_PW_COEFFICIENT]�����У����С�ϵ��ֵ[COEFFICIENT]��Ϊ�����˷���[EXMNMARK]��/��ӳ��ϵ��/����[COEFORBASE]��
						CoefficientVO coefficientVO = new CoefficientVO();
						coefficientVO.setExmnid(exmnrsltVO.getExmnid());
						coefficientVO.setWayid(exmnrsltVO.getWayid());
						coefficientVO.setExmnperiod(exmnrsltVO.getExmnperiod());
						coefficientVO.setCoefficient(new Double(exmnrsltVO.getExmnmark().doubleValue()/mappingVO.getCoeforbase().doubleValue()));;
						coefficientControl.doCreate(coefficientVO);							
					}
					break;//��ȡ��������Ӧ����ļ�¼���������˳���ͬһ�������䲻���ڽ��棬��
				}
			}
			
			if(i == mapingList.size()){//δ�ҵ����˷�����Ӧ��ӳ���������
//				�޶�Ӧӳ�����䣬������һ�ʼ�¼������ϵ��[CH_PW_COEFFICIENT]�����У����С�ϵ��ֵ[COEFFICIENT]��Ϊ0��
				CoefficientVO coefficientVO = new CoefficientVO();
				coefficientVO.setExmnid(exmnrsltVO.getExmnid());
				coefficientVO.setWayid(exmnrsltVO.getWayid());
				coefficientVO.setExmnperiod(exmnrsltVO.getExmnperiod());
				coefficientVO.setCoefficient(new Double(0));
				coefficientControl.doCreate(coefficientVO);	
			}
		}
	}
}
	
