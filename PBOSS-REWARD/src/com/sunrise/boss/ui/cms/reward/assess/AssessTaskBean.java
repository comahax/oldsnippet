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
		super.setBatchName("���˷�������");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "���˷������� \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		try {
			
			
			//1���ж����������Ƿ����,�����ж�,�����ٶ�̫��,ֱ���ں�̨����,�����Ѿ�ȷ����
			WayDelegate waydelegate=new WayDelegate();
			WayListVO wayListVO = new WayListVO();
			wayListVO.set_se_wayid(content[0]);
//			wayListVO.set_ne_waystate(Short.valueOf("1")); //��������Ч������
			wayListVO.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
			wayListVO.set_se_waytype("AG");
			DataPackage waydp = waydelegate.doQuery(wayListVO, user);
			if(waydp.getRowCount()==0){
				throw new Exception("�������벻����,���߲����������,�������������ڸõ���");

			}
			//�����ݿ�load,����CH_ASSESSTYPE,
			Set<String> set = new HashSet<String>();
//			set.add("1");
//			set.add("2");
//			set.add("3");
//			set.add("4");
//			set.add("5");
			//У������
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
							throw new Exception("�Ƿ��͵ĵĿ���ֵ,ֻ����1��0,1��ʾ��,0��ʾ��");
						}
					}
					if(null==dictitemVO.getDescription()||"NUMBER".equals(dictitemVO.getDescription())){
						if(!(0<=Double.valueOf(content[2])&&Double.valueOf(content[2])<=100)){
							throw new Exception("��ֵ�Ϳ���ֵ,ֻ����0��100֮��.");
						}
					}	
//					map.put(dictitemVO.getDictid(), dictitemVO.getDescription());
				}
			}else{
				throw new Exception("�������Ͳ�����");	
			}
			
//			if(!set.contains(content[1])){
//				throw new Exception("�������Ͳ�����");	
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
//				throw new Exception("����������Ϊ˫�ҳ϶ȱ�ʶ(��/��),��Ӫ���������Ŀ��ʶ(��/��),����������ʶ(��/��)," +
//						"˫������ʶ(��/��)ʱ����ֵ,ֻ����1��0,1��ʾ��,0��ʾ��");	
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
			
			line = rowCount + "   " + line + "    �����ɹ�";
			resultVO.setOk(true);
			resultVO.setInfo(line);
			return resultVO;
			}catch (Exception ex) { // ����ʧ��
				line = rowCount + "   " + line + "    ������Ϣ:" + ex.getMessage();
				resultVO.setInfo(line);
				resultVO.setOk(false);
			}
			
		return resultVO;
	}


}