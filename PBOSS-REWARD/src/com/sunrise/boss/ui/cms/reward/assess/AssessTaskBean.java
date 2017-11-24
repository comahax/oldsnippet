package com.sunrise.boss.ui.cms.reward.assess;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.cms.reward.assess.AssessDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.cms.reward.assess.persistent.AssessListVO;
import com.sunrise.boss.business.cms.reward.assess.persistent.AssessVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;

public class AssessTaskBean extends BaseBatchTaskBean {
	public AssessTaskBean() throws Exception {
		super.setBatchName("考核分数导入");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "考核分数导入 \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		try {
			
			
			//1、判断渠道编码是否存在,不用判断,否则速度太慢,直接在后台处理,康熠已经确认了
			WayDelegate waydelegate=new WayDelegate();
			WayListVO wayListVO = new WayListVO();
			wayListVO.set_se_wayid(content[0]);
//			wayListVO.set_ne_waystate(Short.valueOf("1")); //可以是无效的渠道
			wayListVO.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
			wayListVO.set_se_waytype("AG");
			DataPackage waydp = waydelegate.doQuery(wayListVO, user);
			if(waydp.getRowCount()==0){
				throw new Exception("渠道编码不存在,或者不是社会渠道,或者渠道不属于该地市");

			}
			//从数据库load,参数CH_ASSESSTYPE,
			Set<String> set = new HashSet<String>();
//			set.add("1");
//			set.add("2");
//			set.add("3");
//			set.add("4");
//			set.add("5");
			//校验数据
			Map<String,String> map=new HashMap<String, String>();
			
			Set<String> values=new HashSet<String>();
			values.add("0");
			values.add("1");
			
			DictitemDelegate dictitemDelegate=new DictitemDelegate();
			DictitemListVO dictitemListVO=new DictitemListVO();
			dictitemListVO.set_se_groupid("CH_ASSESSTYPE");
			dictitemListVO.set_se_dictid(content[1]);
			DataPackage dataPackage=dictitemDelegate.doQuery(dictitemListVO, user);
			if(dataPackage!=null && dataPackage.getDatas().size()>0){
	    		Iterator it = dataPackage.getDatas().iterator();
				if(it.hasNext()) {
					DictitemVO dictitemVO=(DictitemVO)it.next();
//					set.add(dictitemVO.getDictid());
					if("BOOL".equals(dictitemVO.getDescription())){
						if(!values.contains(content[2])){
							throw new Exception("是否型的的考核值,只能是1和0,1表示是,0表示否");
						}
					}
					if(null==dictitemVO.getDescription()||"NUMBER".equals(dictitemVO.getDescription())){
						if(!(0<=Double.valueOf(content[2])&&Double.valueOf(content[2])<=100)){
							throw new Exception("数值型考核值,只能是0和100之间.");
						}
					}	
//					map.put(dictitemVO.getDictid(), dictitemVO.getDescription());
				}
			}else{
				throw new Exception("考核类型不存在");	
			}
			
//			if(!set.contains(content[1])){
//				throw new Exception("考核类型不存在");	
//				
//			}
			
			
			
//			Set<String> set1 = new HashSet<String>();
////			set1.add("1");
//			set1.add("2");
//			set1.add("3");
//			set1.add("4");
//			set1.add("5");
//			Set<String> values=new HashSet<String>();
//			values.add("0");
//			values.add("1");
//			if(set1.contains(content[1]) && !values.contains(content[2])){
//				throw new Exception("当考核类型为双忠诚度标识(是/否),经营否决考核项目标识(是/否),宣传补贴标识(是/否)," +
//						"双排他标识(是/否)时考核值,只能是1和0,1表示是,0表示否");	
//			}
			
			AssessDelegate assessDelegate=new AssessDelegate();
			AssessListVO listvo=new AssessListVO();
			listvo.set_se_wayid(content[0]);
			listvo.set_se_calcmonth(content[3]);
			listvo.set_ne_assesstype(content[1]);
			DataPackage dp=assessDelegate.doQuery(listvo, user);
			if(dp!=null&&dp.getDatas().size()>0){
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				AssessVO assessVO=new AssessVO();
				assessVO.setWayid(content[0]);
				assessVO.setAssesstype(Long.parseLong(content[1]));
				assessVO.setValue(Double.parseDouble(content[2]));
				assessVO.setOpertype("U");
				assessVO.setCalcmonth(content[3]);
				assessVO.setRemark(content[4]);
				assessVO.setOpercode(user.getOpercode());
				java.util.Date date = new java.util.Date();
				assessVO.setOprtime(date);
				assessVO.setSeq(((AssessVO)(dp.getDatas().iterator().next())).getSeq());
				
				assessDelegate.doUpdate(assessVO, user);
			}
			else{
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				AssessVO assessVO=new AssessVO();
				assessVO.setWayid(content[0]);
				assessVO.setAssesstype(Long.parseLong(content[1]));
				assessVO.setValue(Double.parseDouble(content[2]));
				assessVO.setOpertype("I");
				assessVO.setCalcmonth(content[3]);
				assessVO.setRemark(content[4]);
				assessVO.setOpercode(user.getOpercode());
				java.util.Date date = new java.util.Date();
				assessVO.setOprtime(date);
				
				assessDelegate.doCreate(assessVO, user);
			}
			
			line = rowCount + "   " + line + "    操作成功";
			resultVO.setOk(true);
			resultVO.setInfo(line);
			return resultVO;
			}catch (Exception ex) { // 插入失败
				line = rowCount + "   " + line + "    错误信息:" + ex.getMessage();
				resultVO.setInfo(line);
				resultVO.setOk(false);
			}
			
		return resultVO;
	}


}