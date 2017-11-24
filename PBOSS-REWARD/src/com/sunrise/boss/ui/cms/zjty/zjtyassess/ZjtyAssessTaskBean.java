package com.sunrise.boss.ui.cms.zjty.zjtyassess;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.zjty.zjtyassess.persistent.ZjtyAssessListVO;
import com.sunrise.boss.business.cms.zjty.zjtyassess.persistent.ZjtyAssessVO;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplan.persistent.ZjtyBusyxplanVO;
import com.sunrise.boss.business.cms.zjty.zjtycompact.persistent.ZjtyCompactListVO;
import com.sunrise.boss.business.cms.zjty.zjtycompact.persistent.ZjtyCompactVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.zjty.zjtyassess.ZjtyAssessDelegate;
import com.sunrise.boss.delegate.cms.zjty.zjtycompact.ZjtyCompactDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class ZjtyAssessTaskBean extends BaseBatchTaskBean {
	public ZjtyAssessTaskBean() throws Exception {
		super.setBatchName("�Խ���Ӫ�������˹�����");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "�Խ���Ӫ�������˹����� \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		try {
			
			//�ж������Ƿ���ڣ����Ƿ�Ϊ�Խ���Ӫ������
			//��Select WAYID from ch_pw_way Where    WAYTYPE = 'AG' AND WAYSUBTYPE = 'ZJTY'��������ע�ⲻ��Ҫ�ж������Ƿ���Ч��������������Ȼ�Ѿ�ʧЧ��������ȻҪ�����롣
			WayDelegate waydelegate=new WayDelegate();
			WayListVO wayListVO = new WayListVO();
			wayListVO.set_se_wayid(content[0]);
			//wayListVO.set_ne_waystate(Short.valueOf("1"));
			wayListVO.set_se_waytype("AG");
			wayListVO.set_se_waysubtype("ZJTY");
			DataPackage waydp = waydelegate.doQuery(wayListVO, user);
			if(waydp.getRowCount()==0){
				throw new Exception("�������벻����");

			}
			
//			�ж�ӳ���������Ͱ���
//			1��HAPPYONLINE---�������� 
//			2��XINXIJITAOKA---��Ϣ���׿�
//			3��CHANGEPLAN---�ײͱ��  
//			4��NEWUSER---ȫ��ͨ�ź�     
//			5��G3NETBOOK---G3������ 
//			Set<String> set = new HashSet<String>();
//			set.add("HAPPYONLINE");
//			set.add("XINXIJITAOKA");
//			set.add("CHANGEPLAN");
//			set.add("NEWUSER");
//			set.add("G3NETBOOK");
//			if(!set.contains(content[2])){
//				throw new Exception("ӳ�����Ͳ�����");	
//
//			}
			
			ZjtyAssessDelegate zjtyassessDelegate=new ZjtyAssessDelegate();
			ZjtyAssessListVO listvo=new ZjtyAssessListVO();
			listvo.set_se_wayid(content[0]);
			listvo.set_se_calcmonth(content[1]);
			listvo.set_ne_cityid(user.getCityid());
			DataPackage dp=zjtyassessDelegate.doQuery(listvo, user);
			if(dp!=null&&dp.getDatas().size()>0){
				ZjtyAssessVO zjtyassessVO=new ZjtyAssessVO();
				zjtyassessVO.setCityid(Short.parseShort(user.getCityid()));
				zjtyassessVO.setWayid(content[0]);
				zjtyassessVO.setCalcmonth(content[1]);
				if(content[2]!=null && content[2].length()>0){
					zjtyassessVO.setCoef1(new Float(content[2]));
				}else{
					zjtyassessVO.setCoef1(1f);
				}
				if(content[3]!=null && content[3].length()>0){
					zjtyassessVO.setCoef2(new Float(content[3]));
				}else{
					zjtyassessVO.setCoef2(1f);
				}
				if(content[4]!=null && content[4].length()>0){
					zjtyassessVO.setCoef3(new Float(content[4]));
				}else{
					zjtyassessVO.setCoef3(1f);
				}
				if(content[5]!=null && content[5].length()>0){
					zjtyassessVO.setEmpnum(new Integer(content[5]));
				}else{
					ZjtyCompactDelegate zjtycompactDelegate = new ZjtyCompactDelegate();
			    	ZjtyCompactListVO zjtycompactlistVO = new ZjtyCompactListVO();
			    	zjtycompactlistVO.set_se_wayid(content[0]);
			    	zjtycompactlistVO.set_ne_cityid(user.getCityid());
			    	DataPackage dp2 = zjtycompactDelegate.doQuery(zjtycompactlistVO, user);
			    	if(null !=dp2 && dp2.getDatas().size()>0){
			    		ZjtyCompactVO zjtycompactVO = (ZjtyCompactVO)dp2.getDatas().iterator().next();
			    		zjtyassessVO.setEmpnum(zjtycompactVO.getFixednum());
			    	}
				}
//				assessVO.setOpercode(user.getOpercode());
//				java.util.Date date = new java.util.Date();
//				assessVO.setOprtime(date);
//				assessVO.setSeq(((AssessVO)(dp.getDatas().iterator().next())).getSeq());
				
				zjtyassessDelegate.doUpdate(zjtyassessVO, user);
			}
			else{
				
				ZjtyAssessVO zjtyassessVO=new ZjtyAssessVO();
				zjtyassessVO.setCityid(Short.parseShort(user.getCityid()));
				zjtyassessVO.setWayid(content[0]);
				zjtyassessVO.setCalcmonth(content[1]);
				if(content[2]!=null && content[2].length()>0){
					zjtyassessVO.setCoef1(new Float(content[2]));
				}else{
					zjtyassessVO.setCoef1(1f);
				}
				if(content[3]!=null && content[3].length()>0){
					zjtyassessVO.setCoef2(new Float(content[3]));
				}else{
					zjtyassessVO.setCoef2(1f);
				}
				if(content[4]!=null && content[4].length()>0){
					zjtyassessVO.setCoef3(new Float(content[4]));
				}else{
					zjtyassessVO.setCoef3(1f);
				}
				if(content[5]!=null && content[5].length()>0){
					zjtyassessVO.setEmpnum(new Integer(content[5]));
				}else{
					ZjtyCompactDelegate zjtycompactDelegate = new ZjtyCompactDelegate();
			    	ZjtyCompactListVO zjtycompactlistVO = new ZjtyCompactListVO();
			    	zjtycompactlistVO.set_se_wayid(content[0]);
			    	zjtycompactlistVO.set_ne_cityid(user.getCityid());
			    	DataPackage dp2 = zjtycompactDelegate.doQuery(zjtycompactlistVO, user);
			    	if(null !=dp2 && dp2.getDatas().size()>0){
			    		ZjtyCompactVO zjtycompactVO = (ZjtyCompactVO)dp2.getDatas().iterator().next();
			    		zjtyassessVO.setEmpnum(zjtycompactVO.getFixednum());
			    	}
				}
				
				zjtyassessDelegate.doCreate(zjtyassessVO, user);
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