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
//		根据“考核周期[EXMNPERIOD]”（处理年月）从“考核结果[CH_PW_EXMNRSLT]”表中获取所有记录，遍历该记录集：
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		Date stateDate = null;
		try{
			stateDate = format.parse(stateTime);
		}catch(Exception e){
			System.out.println("===============参数：处理年月["+stateTime+"]  格式 不正确（yyyyMM)");
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
//		a)	根据“考核标识[EXMNID]”和“地市标识[CITYID]”从“分数映射[CH_PW_MAPPING]”表中获取“映射方式[MMODE]”；
		Mapping mappingControl = (MappingBO)BOFactory.build(MappingBO.class,user);
		MappingListVO mappingParam = new MappingListVO();
		mappingParam.setQueryAll(true);
		mappingParam.setDataOnly(true);
		mappingParam.set_ne_exmnid(""+exmnrsltVO.getExmnid());
		mappingParam.set_se_cityid(user.getCityid());
		DataPackage mappingDP = mappingControl.doQuery(mappingParam);
		if( null == mappingDP || null == mappingDP.getDatas() || mappingDP.getDatas().isEmpty()){
//			b)	如果该考核在“分数映射[CH_PW_MAPPING]”表没有设置映射信息，
//			则新增一笔记录“考核系数[CH_PW_COEFFICIENT]”表中，其中“系数值[COEFFICIENT]
//			 ”为该渠道该项考核的考核分数；继续处理下一条考核结果记录；
			Coefficient coefficientControl = (CoefficientBO)BOFactory.build(CoefficientBO.class,user);
			CoefficientVO coefficientVO = new CoefficientVO();
			coefficientVO.setExmnid(exmnrsltVO.getExmnid());
			coefficientVO.setWayid(exmnrsltVO.getWayid());
			coefficientVO.setExmnperiod(exmnrsltVO.getExmnperiod());
			coefficientVO.setCoefficient(exmnrsltVO.getExmnmark());
			coefficientControl.doCreate(coefficientVO);
		}else{
			List mapingList = (List)mappingDP.getDatas();
//			c)	根据“考核分数”查找分数对应区间；无对应映射区间，则新增一笔记录“考核系数[CH_PW_COEFFICIENT]”表中，
//			其中“系数值[COEFFICIENT]”为0；继续处理下一条考核结果记录；否则获取该映射记录的“映射方式[MMODE]”，
//			判断“映射方式[MMODE]”；如果为“按区间[0]”，则新增一笔记录“考核系数[CH_PW_COEFFICIENT]”表中，
//			其中“系数值[COEFFICIENT]”为“映射系数/基数[COEFORBASE]”；如果为“按基数[1]”，
//			则新增一笔记录到“考核系数[CH_PW_COEFFICIENT]”表中，其中“系数值[COEFFICIENT]”为“考核分数[EXMNMARK]”/“映射系数/基数[COEFORBASE]”
//			；继续处理下一条考核结果记录；
			Coefficient coefficientControl = (CoefficientBO)BOFactory.build(CoefficientBO.class,user);
			int i = 0;
			for(;i<mapingList.size();i++){
				MappingVO mappingVO = (MappingVO)mapingList.get(i);
				if(mappingVO.getMarkll().doubleValue()<= exmnrsltVO.getExmnmark().doubleValue() 
						&& exmnrsltVO.getExmnmark().doubleValue()<mappingVO.getMarkul().doubleValue()){
					if("0".equals(mappingVO.getMmode())){
//						如果为“按区间[0]”，则新增一笔记录“考核系数[CH_PW_COEFFICIENT]”表中，
//						其中“系数值[COEFFICIENT]”为“映射系数/基数[COEFORBASE]”；
						CoefficientVO coefficientVO = new CoefficientVO();
						coefficientVO.setExmnid(exmnrsltVO.getExmnid());
						coefficientVO.setWayid(exmnrsltVO.getWayid());
						coefficientVO.setExmnperiod(exmnrsltVO.getExmnperiod());
						coefficientVO.setCoefficient(mappingVO.getCoeforbase());
						coefficientControl.doCreate(coefficientVO);									
					}else if("1".equals(mappingVO.getMmode())){
//						如果为“按基数[1]”，
//						则新增一笔记录到“考核系数[CH_PW_COEFFICIENT]”表中，其中“系数值[COEFFICIENT]”为“考核分数[EXMNMARK]”/“映射系数/基数[COEFORBASE]”
						CoefficientVO coefficientVO = new CoefficientVO();
						coefficientVO.setExmnid(exmnrsltVO.getExmnid());
						coefficientVO.setWayid(exmnrsltVO.getWayid());
						coefficientVO.setExmnperiod(exmnrsltVO.getExmnperiod());
						coefficientVO.setCoefficient(new Double(exmnrsltVO.getExmnmark().doubleValue()/mappingVO.getCoeforbase().doubleValue()));;
						coefficientControl.doCreate(coefficientVO);							
					}
					break;//能取到分数对应区间的记录处理后可以退出（同一考核区间不存在交叉，）
				}
			}
			
			if(i == mapingList.size()){//未找到考核分数对应的映射分数区间
//				无对应映射区间，则新增一笔记录“考核系数[CH_PW_COEFFICIENT]”表中，其中“系数值[COEFFICIENT]”为0；
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
	
