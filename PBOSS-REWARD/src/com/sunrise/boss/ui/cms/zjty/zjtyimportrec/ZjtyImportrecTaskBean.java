package com.sunrise.boss.ui.cms.zjty.zjtyimportrec;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.zjty.zjtyimportrec.persistent.ZjtyImportrecListVO;
import com.sunrise.boss.business.cms.zjty.zjtyimportrec.persistent.ZjtyImportrecVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.zjty.zjtyimportrec.ZjtyImportrecDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.PublicUtils;

public class ZjtyImportrecTaskBean extends BaseBatchTaskBean {
	public ZjtyImportrecTaskBean() throws Exception {
		super.setBatchName("�Խ���Ӫ�������������ϴ�");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "�Խ���Ӫ�������������ϴ� \r\n";
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
			wayListVO.set_se_wayid(content[2]);
			//wayListVO.set_ne_waystate(Short.valueOf("1"));
			wayListVO.set_se_waytype("AG");
			wayListVO.set_se_waysubtype("ZJTY");
			DataPackage waydp = waydelegate.doQuery(wayListVO, user);
			if(waydp.getRowCount()==0){
				throw new Exception("ҵ��������������");

			}
			
			//1.�����·�
			try{
				Date now = new Date();
				String nowstr = PublicUtils.formatUtilDate(now, "yyyyMM");
				if(new Long(content[0])>new Long(nowstr)){
					throw new Exception("�����·ݲ��ܴ��ڵ�ǰ�·�");
				}
			}catch (Exception e) {
				throw new Exception("�����·ݲ���ȷ");
			}
			//4.ҵ����ʱ��
			try{
				Date date = PublicUtils.UtilStrToDate(content[3], "yyyy-MM-dd HH:mm:ss");
				Calendar ca = Calendar.getInstance(Locale.CHINA);//��ǰʱ��
				Calendar ca2 = Calendar.getInstance();
				ca2.setTime(date);
				if(ca2.after(ca)){
					throw new Exception("ҵ����ʱ�䲻�ܴ��ڵ�ǰϵͳʱ��");
				}
			}catch (Exception e) {
				throw new Exception("ҵ����ʱ�䲻��ȷ");
			}
			
//			�����·�|����ҵ�����|ҵ��������|ҵ����ʱ��|ҵ��������|ҵ��������|���뷢����ҵ����|
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ZjtyImportrecDelegate zjtyimportrecDelegate=new ZjtyImportrecDelegate();
			ZjtyImportrecListVO listvo=new ZjtyImportrecListVO();
//			listvo.set_se_calcmonth(content[0]);
			listvo.set_se_opnid(content[1]);
			listvo.set_se_wayid(content[2]);
			listvo.set_de_oprtime(content[3]);
			if(content[5].trim().length()>0){
				listvo.set_se_mobile(content[5]);
			}
			DataPackage dp=zjtyimportrecDelegate.doQuery(listvo, user);
			if(dp!=null&&dp.getDatas().size()>0){
//				zjtybusyxplanVO.setCityid(user.getCityid());
//				zjtybusyxplanVO.setOpnid(content[0]);
//				zjtybusyxplanVO.setYxplanid(Long.parseLong(content[1]));
//				zjtybusyxplanVO.setPlanbusitype(content[2]);				
//				assessVO.setOpercode(user.getOpercode());
//				java.util.Date date = new java.util.Date();
//				assessVO.setOprtime(date);
//				assessVO.setSeq(((AssessVO)(dp.getDatas().iterator().next())).getSeq());
				ZjtyImportrecVO zjtyimportrecVO=new ZjtyImportrecVO();
				zjtyimportrecVO.setCalcmonth(content[0]);
				zjtyimportrecVO.setOpnid(content[1]);
				zjtyimportrecVO.setWayid(content[2]);
				zjtyimportrecVO.setOprtime(format.parse(content[3]));
				zjtyimportrecVO.setOprcode(content[4]);
				zjtyimportrecVO.setSeq(((ZjtyImportrecVO)(dp.getDatas().iterator().next())).getSeq());
				if(content[5]!=null && content[5].length()>0){
					zjtyimportrecVO.setMobile(content[5]);
				}
				if(content[6]!=null && content[6].length()>0){
					zjtyimportrecVO.setBusivalue(Double.parseDouble(content[6]));
				}
				
				zjtyimportrecDelegate.doUpdate(zjtyimportrecVO, user);
			}
			else{
				
				ZjtyImportrecVO zjtyimportrecVO=new ZjtyImportrecVO();
				zjtyimportrecVO.setCalcmonth(content[0]);
				zjtyimportrecVO.setOpnid(content[1]);
				zjtyimportrecVO.setWayid(content[2]);
				zjtyimportrecVO.setOprtime(format.parse(content[3]));
				zjtyimportrecVO.setOprcode(content[4]);
				if(content[5]!=null && content[5].length()>0){
					zjtyimportrecVO.setMobile(content[5]);
				}
				if(content[6]!=null && content[6].length()>0){
					zjtyimportrecVO.setBusivalue(Double.parseDouble(content[6]));
				}
				
				zjtyimportrecDelegate.doCreate(zjtyimportrecVO, user);
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