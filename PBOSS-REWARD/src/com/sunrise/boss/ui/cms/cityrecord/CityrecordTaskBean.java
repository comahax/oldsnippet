package com.sunrise.boss.ui.cms.cityrecord;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.chadtbusitoapprove.control.ChAdtBusitoapproveControl;
import com.sunrise.boss.business.cms.chadtbusitoapprove.control.ChAdtBusitoapproveControlBean;
import com.sunrise.boss.business.cms.chadtbusitoapprove.persistent.ChAdtBusitoapproveListVO;
import com.sunrise.boss.business.cms.chadtbusitoapprove.persistent.ChAdtBusitoapproveVO;
import com.sunrise.boss.business.cms.cityrecord.control.CityrecordControl;
import com.sunrise.boss.business.cms.cityrecord.control.CityrecordControlBean;
import com.sunrise.boss.business.cms.cityrecord.persistent.CityrecordListVO;
import com.sunrise.boss.business.cms.cityrecord.persistent.CityrecordVO;
import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.business.cms.operation.control.OperationControl;
import com.sunrise.boss.business.cms.operation.control.OperationControlBean;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.cityrecord.CityrecordDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.PublicUtils;

public class CityrecordTaskBean extends BaseBatchTaskBean {
	public CityrecordTaskBean() throws Exception {
		super.setBatchName("�й�˾�����ϸ�ϴ���������");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "�й�˾�����ϸ�ϴ��������� \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		try {		
			//1���ж����������Ƿ����
			WayDelegate waydelegate=new WayDelegate();
			WayListVO wayListVO = new WayListVO();
			wayListVO.set_se_wayid(content[0]);
			wayListVO.set_ne_waystate(Short.valueOf("1"));
			wayListVO.set_se_waytype("AG");
			wayListVO.set_sne_waysubtype("ZJTY");
			DataPackage waydp = waydelegate.doQuery(wayListVO, user);
			if(waydp.getRowCount()==0){
				throw new Exception("�������벻����");
			}
			//2.��ѯȫʡͳһҵ�������Ϣ��(CH_PW_OPERATION)���Ƿ���ڸ�ҵ�����OPNID
			OperationDelegate odel = new OperationDelegate();
			if(null == odel.doFindByPk(content[1], user)){
				throw new Exception("ҵ����벻����");
			}
			
			//3.�жϳ������Ƿ���ȷ
			Set<String> notjijianset = new HashSet<String>();//�ǼƼ�ҵ�񼯺�
			notjijianset.add("0701010100004");
			notjijianset.add("0701010100001");
			notjijianset.add("0701010100003");
			notjijianset.add("0701010100002");
			notjijianset.add("0701010100005");
			if(notjijianset.contains(content[1])){
				if(StringUtils.equals(content[1], "0701010100004")){
					if(!StringUtils.equals(content[2], "30")){
						throw new Exception("�����������ȷ");
					}
				}
				if(StringUtils.equals(content[1], "0701010100001")){
					if(!StringUtils.equals(content[2], "60")){
						throw new Exception("�����������ȷ");
					}
				}
				if(StringUtils.equals(content[1], "0701010100003")){
					if(!StringUtils.equals(content[2], "54")){
						throw new Exception("�����������ȷ");
					}
				}
				if(StringUtils.equals(content[1], "0701010100002")){
					if(!StringUtils.equals(content[2], "55")){
						throw new Exception("�����������ȷ");
					}
				}
				if(StringUtils.equals(content[1], "0701010100005")){
					if(!StringUtils.equals(content[2], "7")){
						throw new Exception("�����������ȷ");
					}
				}
			}else{
				OperationControl opcontrol = (OperationControl)ControlFactory.build(OperationControlBean.class);
				OperationVO opvo = opcontrol.doFindByPk(content[1], user);
				if("CARD".equals(opvo.getBusibelong())){
					if((!StringUtils.equals("0", content[2])) && (!StringUtils.equals("1", content[2])) &&(!StringUtils.equals("2", content[2]))){
						throw new Exception("�����������ȷ");
					}
				}
				if("SERV".equals(opvo.getBusibelong())){
					if((!StringUtils.equals("5", content[2])) && (!StringUtils.equals("6", content[2]))){
						throw new Exception("�����������ȷ");
					}
				}
				if("DATA".equals(opvo.getBusibelong())){
					if((!StringUtils.equals("9", content[2])) && (!StringUtils.equals("10", content[2]))){
						throw new Exception("�����������ȷ");
					}
				}
			}
			//4.�ж��ֻ�����
			Set<String> notjijianset2 = new HashSet<String>();//�ǼƼ�ҵ�񼯺�
			notjijianset2.add("0701010100004");
			notjijianset2.add("0701010100003");
			notjijianset2.add("0701010100002");
			if(!notjijianset2.contains(content[1])){
				if(StringUtils.isBlank(content[3])){
					throw new Exception("�ֻ����벻����Ϊ��");
				}
			}
			//5.�����·�
			try{
				Date now = new Date();
				String nowstr = PublicUtils.formatUtilDate(now, "yyyyMM");
				if(new Long(content[4])>new Long(nowstr)){
					throw new Exception("�����·ݲ��ܴ��ڵ�ǰ�·�");
				}
			}catch (Exception e) {
				throw new Exception("�����·ݲ���ȷ");
			}
			//6.ҵ����ʱ��
			try{
				Date date = PublicUtils.UtilStrToDate(content[5], "yyyy-MM-dd HH:mm:ss");
				Calendar ca = Calendar.getInstance(Locale.CHINA);//��ǰʱ��
				Calendar ca2 = Calendar.getInstance();
				ca2.setTime(date);
				if(ca2.after(ca)){
					throw new Exception("ҵ����ʱ�䲻�ܴ��ڵ�ǰϵͳʱ��");
				}
			}catch (Exception e) {
				throw new Exception("ҵ����ʱ�䲻��ȷ");
			}
			//7.ҵ������ҵ�������
			if(!CheckUtil.checkDouble(content[6],10, 2) ){
				throw new Exception("ҵ������ҵ���������뾫ȷ����λС��");
			}
			if(new Double(content[6])<0){
				throw new Exception("ҵ������ҵ����������Ϊ����");
			}
			//8.Ӧ�����ϼ�
			if(!CheckUtil.checkDouble(content[7],10, 2)){
				throw new Exception("Ӧ�����ϼƱ��뾫ȷ����λС��");
			}
			if(new Double(content[7])<0){
				throw new Exception("Ӧ�����ϼƱ���Ϊ����");
			}
			//9.����Ӧ�����
			if(!CheckUtil.checkDouble(content[8],10, 2)){
				throw new Exception("����Ӧ�������뾫ȷ����λС��");
			}
			if(new Double(content[8])<0){
				throw new Exception("����Ӧ��������Ϊ����");
			}
			//10.��������
			if(!"00000".equals(content[9])){
				ChAdtBusitoapproveControl cbcontrol = (ChAdtBusitoapproveControl)ControlFactory.build(ChAdtBusitoapproveControlBean.class);
				ChAdtBusitoapproveListVO cblistvo = new ChAdtBusitoapproveListVO();
				//cblistvo.set_ne_approveid(content[9]);
				cblistvo.set_se_opnid(content[1]);
				cblistvo.set_orderby("apptime");
				cblistvo.set_desc("1");
				DataPackage cbdp = cbcontrol.doQuery(cblistvo, user);
				ChAdtBusitoapproveVO cbvo = new ChAdtBusitoapproveVO();
				if(null!= cbdp && cbdp.getDatas().size()>0){
					List cbdplist = (ArrayList)cbdp.getDatas();
					cbvo = (ChAdtBusitoapproveVO)cbdplist.get(0);
				}else{
					throw new Exception("��������"+ content[9]+"���ǵ�ǰҵ�����µ���������,�����ҵ�������COMSǰ̨����: ������->�������ҵ�����->������Ч�Թ���->ҵ�������������ϵ��ѯ,��ȡ���µ���������");
				}
				//if(!(Long.valueOf(content[9]).longValue() == cbvo.getApproveid().longValue())){
				if(!content[9].equals(cbvo.getApproveid())){	//���������Ϊstring��
					throw new Exception("��������"+ content[9]+"���ǵ�ǰҵ�����µ���������,�����ҵ�������COMSǰ̨����: ������->�������ҵ�����->������Ч�Թ���->ҵ�������������ϵ��ѯ,��ȡ���µ���������");
				}
			}
			//�����ظ��ж�
			CityrecordControl crcontrol = (CityrecordControl) ControlFactory.build(CityrecordControlBean.class);
			CityrecordListVO listvo = new CityrecordListVO();
			if(StringUtils.isNotBlank(content[3])){//���MOBILE��Ϊ�յļƼ���ҵ��,����:��ҵ�����+ҵ����ʱ��+�������+ҵ���������IMEI��+�����·�
				listvo.set_se_opnid(content[1]);
				//listvo.set_dnl_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd")+" 00:00:00");
				//listvo.set_dnm_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd")+" 23:59:59");
				listvo.set_de_oprtime(content[5]);
				listvo.set_ne_rewardtype(content[2]);
				listvo.set_se_mobile(content[3]);
				listvo.set_se_rewardmonth(content[4]);
				DataPackage dp = crcontrol.doQuery(listvo, user);
				if(null!=dp && dp.getDatas().size()>0){
					throw new Exception("�Ѵ��ڸü�¼�ϴ���ϸ");
				}
			}else if(StringUtils.isBlank(content[3]) && ("0701010100004".equals(content[1]) || 
					"0701010100003".equals(content[1]) || "0701010100002".equals(content[1]))){//���MOBILEΪ�հ��ǼƼ���ҵ��,�����:�������+ҵ�����+������+ҵ����ʱ��+�����·�
				listvo.set_se_wayid(content[0]);
				listvo.set_se_opnid(content[1]);
				//listvo.set_dnl_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd")+" 00:00:00");
				//listvo.set_dnm_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd")+" 23:59:59");
				listvo.set_de_oprtime(content[5]);
				listvo.set_ne_rewardtype(content[2]);
				listvo.set_se_rewardmonth(content[4]);
				DataPackage dp = crcontrol.doQuery(listvo, user);
				if(null!=dp && dp.getDatas().size()>0){
					throw new Exception("�Ѵ��ڸü�¼�ϴ���ϸ");
				}
			}
			
			CityrecordDelegate dele = new CityrecordDelegate();
			CityrecordVO vo = new CityrecordVO();
			vo.setIsflag((short)2);
			vo.setOprcode(user.getOpercode());
			vo.setOptime(new Date());
			vo.setSystemflag((short)1);
			vo.setApproveid(null);
			
			vo.setWayid(content[0]);
			vo.setOpnid(content[1]);
			vo.setRewardtype(new Short(content[2]));
			vo.setMobile((content[3]));
			vo.setRewardmonth(content[4]);
			vo.setOprtime(PublicUtils.UtilStrToDate(content[5]));
			vo.setBusivalue(new Double(content[6]));
			vo.setPaysum(new Double(content[7]));
			vo.setPaymoney(new Double(content[8]));
			vo.setApproveid(content[9]);
			
			dele.doCreate(vo, user);
			
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