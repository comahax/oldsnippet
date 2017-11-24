package com.sunrise.boss.ui.cms.zjty.zjtybusitosmp;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.zjty.zjtybusitosmp.persistent.ZjtyBusitosmpListVO;
import com.sunrise.boss.business.cms.zjty.zjtybusitosmp.persistent.ZjtyBusitosmpVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.zjty.zjtybusitosmp.ZjtyBusitosmpDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class ZjtyBusitosmpTaskBean extends BaseBatchTaskBean {
	public ZjtyBusitosmpTaskBean() throws Exception {
		super.setBatchName("�Խ���ӪӪ��������ҵ�����ӳ���ϵ����");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "�Խ���ӪӪ��������ҵ�����ӳ���ϵ���� \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		try {
			
//			�ж�ӳ���������Ͱ���
//			1��RECHANGEABLE---��ֵ�� 
//			2��SUITE---�׿��ź���
//			3��G3---G3��Ʒ�ź�

			Set<String> set = new HashSet<String>();
			set.add("rechangeable");
			set.add("suite");
			set.add("G3");
			if(!set.contains(content[2])){
				throw new Exception("ӳ�����Ͳ�����");	

			}
			
			ZjtyBusitosmpDelegate zjtybusitosmpDelegate=new ZjtyBusitosmpDelegate();
			ZjtyBusitosmpListVO listvo=new ZjtyBusitosmpListVO();
			listvo.set_se_opnid(content[0]);
			listvo.set_ne_comid(content[1]);
			listvo.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
			DataPackage dp=zjtybusitosmpDelegate.doQuery(listvo, user);
			if(dp!=null&&dp.getDatas().size()>0){
				ZjtyBusitosmpVO zjtybusitosmpVO=new ZjtyBusitosmpVO();
				zjtybusitosmpVO.setCityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
				zjtybusitosmpVO.setOpnid(content[0]);
				zjtybusitosmpVO.setComid(Long.parseLong(content[1]));
				zjtybusitosmpVO.setSort(content[2]);				
//				assessVO.setOpercode(user.getOpercode());
//				java.util.Date date = new java.util.Date();
//				assessVO.setOprtime(date);
//				assessVO.setSeq(((AssessVO)(dp.getDatas().iterator().next())).getSeq());
				
				zjtybusitosmpDelegate.doUpdate(zjtybusitosmpVO, user);
			}
			else{
				
				ZjtyBusitosmpVO zjtybusitosmpVO=new ZjtyBusitosmpVO();
				zjtybusitosmpVO.setCityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
				zjtybusitosmpVO.setOpnid(content[0]);
				zjtybusitosmpVO.setComid(Long.parseLong(content[1]));
				zjtybusitosmpVO.setSort(content[2]);
				
				zjtybusitosmpDelegate.doCreate(zjtybusitosmpVO, user);
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