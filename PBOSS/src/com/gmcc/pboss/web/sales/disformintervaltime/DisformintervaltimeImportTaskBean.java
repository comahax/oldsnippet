package com.gmcc.pboss.web.sales.disformintervaltime;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyDBParam;
import com.gmcc.pboss.business.channel.microarea.MicroareaDBParam;
import com.gmcc.pboss.business.sales.disformintervaltime.DisformintervaltimeDBParam;
import com.gmcc.pboss.business.sales.disformintervaltime.DisformintervaltimeVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.channel.cntycompany.Cntycompany;
import com.gmcc.pboss.control.channel.cntycompany.CntycompanyBO;
import com.gmcc.pboss.control.channel.microarea.Microarea;
import com.gmcc.pboss.control.channel.microarea.MicroareaBO;
import com.gmcc.pboss.control.sales.disformintervaltime.DisformintervaltimeBO;
import com.gmcc.pboss.control.sales.disformintervaltime.Disformintervaltime;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class DisformintervaltimeImportTaskBean extends BaseBatchTaskBean {	
	public DisformintervaltimeImportTaskBean() throws Exception{
		super.setBatchName("���͵�����ʱ�����������ϴ�");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try{
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			String countyid = items[0];
			String mareacode = items[1];
			String starlevel = items[2];
			Long interval = Long.parseLong(items[3]);
			
			//���ݲ������ŵ��й�˾��У��ֹ�˾
			CntycompanyDBParam cparam = new CntycompanyDBParam();
			cparam.set_se_citycompid(user.getCityid());
			cparam.set_se_countycompid(countyid);
			cparam.set_pagesize("0");
			//cparam.setDataOnly(true);
			cparam.setCountOnly(true);
			Cntycompany cbo = (CntycompanyBO)BOFactory.build(CntycompanyBO.class, user);
			DataPackage cdp = cbo.doQuery(cparam);
			if(cdp.getRowCount()==0){
				throw new Exception("�ֹ�˾��Ϣ������");
			}
			//���ݷֹ�˾У��΢����
			MicroareaDBParam mparam = new MicroareaDBParam();
			mparam.set_se_macode(mareacode);
			mparam.getQueryConditions().put("COUNTYID", countyid);
			//mparam.setNameSql("boss.cms.microarea.queryBycountyid");
			//mparam.setQueryByNameSql(true);
			mparam.set_pagesize("0");
			//mparam.setCountOnly(true);
			mparam.setDataOnly(true);
			Microarea mbo = (MicroareaBO)BOFactory.build(MicroareaBO.class, user);
			//DataPackage mdp = mbo.doQuery(mparam);
			DataPackage mdp = mbo.doFindCountyMarea(mparam);
			if(mdp.getDatas().size()==0){
				throw new Exception("΢������Ϣ������");
			}
			//У���Ǽ�
			DictitemDBParam dparam = new DictitemDBParam();
			dparam.set_se_groupid("CH_STARLEVEL");
			dparam.set_se_dictid(starlevel);
			dparam.set_pagesize("0");
			dparam.setCountOnly(true);
			Dictitem dbo = (DictitemBO)BOFactory.build(DictitemBO.class, user);
			DataPackage ddp = dbo.doQuery(dparam);
			if(ddp.getRowCount()==0){
				throw new Exception("�����Ǽ�������");
			}
			
			//���ݷֹ�˾��΢�����Ǽ���ѯ����ʱ����Ϣ
			DisformintervaltimeDBParam disparam = new DisformintervaltimeDBParam();
			disparam.set_se_countyid(countyid);
			disparam.set_se_mareacode(mareacode);
			disparam.set_ne_starlevel(starlevel);
			disparam.set_pagesize("0");
			disparam.setDataOnly(true);
			Disformintervaltime disbo = (DisformintervaltimeBO)BOFactory.build(DisformintervaltimeBO.class, user);
			DataPackage disdp = disbo.doQuery(disparam);
			if(disdp.getDatas().size()==0){//����
				DisformintervaltimeVO vo = new DisformintervaltimeVO();
				vo.setCountyid(countyid);
				vo.setMareacode(mareacode);
				vo.setStarlevel(Short.parseShort(starlevel));
				vo.setIntervaltime(interval);
				disbo.doCreate(vo);
				line=rowCount+"|"+line+"�������ݳɹ�|";
			}else if(disdp.getDatas().size()==1){//����
				DisformintervaltimeVO vo = (DisformintervaltimeVO)disdp.getDatas().get(0);
				vo.setCountyid(countyid);
				vo.setMareacode(mareacode);
				vo.setStarlevel(Short.parseShort(starlevel));
				vo.setIntervaltime(interval);
				disbo.doUpdate(vo);
				line=rowCount+"|"+line+"�������ݳɹ�|";
			}else{//���ڶ������ݣ�����ҵ���������������
				throw new Exception("���ݼ�¼�Ѵ��ڶ���|");
			}			
			
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			line = rowCount+"|"+line+e.getMessage()+"|";
			e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
	
		return resultVO;
	}
}
