package com.sunrise.boss.ui.cms.zjty.zjtybusyxplan;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;


import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.reward.assess.AssessDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.zjty.zjtybusyxplan.ZjtyBusyxplanDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.boss.business.cms.reward.assess.persistent.AssessListVO;
import com.sunrise.boss.business.cms.reward.assess.persistent.AssessVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplan.persistent.ZjtyBusyxplanListVO;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplan.persistent.ZjtyBusyxplanVO;

public class ZjtyBusyxplanTaskBean extends BaseBatchTaskBean {
	public ZjtyBusyxplanTaskBean() throws Exception {
		super.setBatchName("��Ʒ������ҵ��������õ���");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "��Ʒ������ҵ��������õ��� \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		try {
			
//			�ж�ӳ���������Ͱ���
//			1��HAPPYONLINE---�������� 
//			2��XINXIJITAOKA---��Ϣ���׿�
//			3��CHANGEPLAN---�ײͱ��  
//			4��NEWUSER---ȫ��ͨ�ź�     
//			5��G3NETBOOK---G3������ 
//			6��YCHFTC---Ԥ�滰���޳�
//			7��CONG3CLIENT---��Լ����������Ʒ
			Set<String> set = new HashSet<String>();
			set.add("HAPPYONLINE");
			set.add("XINXIJITAOKA");
			set.add("CHANGEPLAN");
			set.add("NEWUSER");
			set.add("G3NETBOOK");
			set.add("YCHFTC");
			set.add("CONG3CLIENT");
			if(!set.contains(content[1])){
				throw new Exception("ӳ�����Ͳ�����");	

			}
			
			ZjtyBusyxplanDelegate zjtybusyxplanDelegate=new ZjtyBusyxplanDelegate();
			ZjtyBusyxplanListVO listvo=new ZjtyBusyxplanListVO();
			listvo.set_se_opnid(content[0]);
			listvo.set_se_prodid(content[2]);
			listvo.set_se_cityid(user.getCityid());
			DataPackage dp=zjtybusyxplanDelegate.doQuery(listvo, user);
			if(dp!=null&&dp.getDatas().size()>0){
				ZjtyBusyxplanVO zjtybusyxplanVO=new ZjtyBusyxplanVO();
				zjtybusyxplanVO.setCityid(user.getCityid());
				zjtybusyxplanVO.setOpnid(content[0]);
				zjtybusyxplanVO.setPlanbusitype(content[1]);
				zjtybusyxplanVO.setProdid(content[2]);
				if (!"".equals(content[3].trim())) {
					zjtybusyxplanVO.setWrapfee(Double.parseDouble(content[3].trim()));
				}
//				assessVO.setOpercode(user.getOpercode());
//				java.util.Date date = new java.util.Date();
//				assessVO.setOprtime(date);
//				assessVO.setSeq(((AssessVO)(dp.getDatas().iterator().next())).getSeq());
				
				zjtybusyxplanDelegate.doUpdate(zjtybusyxplanVO, user);
			}
			else{
				
				ZjtyBusyxplanVO zjtybusyxplanVO=new ZjtyBusyxplanVO();
				zjtybusyxplanVO.setCityid(user.getCityid());
				zjtybusyxplanVO.setOpnid(content[0]);
				zjtybusyxplanVO.setPlanbusitype(content[1]);
				zjtybusyxplanVO.setProdid(content[2]);
				if (!"".equals(content[3].trim())) {
					zjtybusyxplanVO.setWrapfee(Double.parseDouble(content[3].trim()));
				}
				
				zjtybusyxplanDelegate.doCreate(zjtybusyxplanVO, user);
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