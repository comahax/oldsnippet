package com.gmcc.pboss.web.channel.checkedapply;


import org.apache.commons.lang.StringUtils;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailDBParam;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.base.operright.Operright;
import com.gmcc.pboss.control.base.operright.OperrightBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.checkedapplydetail.Checkedapplydetail;
import com.gmcc.pboss.control.channel.checkedapplydetail.CheckedapplydetailBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class CheckedapplyTaskBean extends BaseBatchTaskBean{
	
	protected String applyno;
	
	public CheckedapplyTaskBean() throws Exception {
		super.setBatchName("��Ȩ�������������������");
		super.setOprtype("����");
		super.setWriteLog(true); 
	}

	protected String doStart() {
		return "�к�|��������|���˷�ʽ|��������|��������|������|  \r\n";
	}
	//��������  ���˷�ʽ  �������� ��������
	@Override
	protected ResultVO processLine(String line, int rowCount) {
		 
		ResultVO resultVO = new ResultVO();
		try {
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");  
			Way way = (Way)BOFactory.build(WayBO.class,user);
			WayDBParam wayDBParam = new WayDBParam();
			wayDBParam.set_se_wayid(items[0]);
			wayDBParam.set_se_cityid(user.getCityid());
			DataPackage dp = way.doCheckWayState(wayDBParam);
			if (null == dp || dp.getDatas().size()==0){
				throw new Exception("�������["+items[0]+"]�����ڣ����������������Ϣ�������¼���������Ϣ");
			}
			WayVO wayVO = (WayVO)dp.getDatas().get(0);
			if (("1").equals(items[1])) { 
				if(("").equals(wayVO.getChainhead()) || null == wayVO.getChainhead()){
					throw new Exception("����["+items[0]+"]������������û�����ã��뵽���������Ϣ����ҳ������");
				}
			}
			WayVO newvo = way.doFindByPk(items[0]);
			if ("1".equals(items[2])) {
				if ("N".equals(newvo.getChecked())) {
					throw new Exception("����["+items[0]+"]�Ѿ��˳���Ȩ");
				}
			} else {
				if ("Y".equals(newvo.getChecked())) {
					throw new Exception("����["+items[0]+"]�Ѿ���Ȩ");
				}
			}
			
			Checkedapplydetail checkedapplydetail = (Checkedapplydetail)BOFactory.build(CheckedapplydetailBO.class, user);
			CheckedapplydetailDBParam detailDBParam = new CheckedapplydetailDBParam();
			detailDBParam.set_se_cityid(user.getCityid());
			detailDBParam.set_se_wayid(items[0]);
			detailDBParam.set_sql_status("waystatus is null");
			DataPackage detaildp = checkedapplydetail.doQuery(detailDBParam);
			if (detaildp!=null && detaildp.getDatas().size()>0) {
				throw new Exception("����["+items[0]+"]�Ѿ����룬�����������");
			}
		 
			String content="";
			if (("1").equals(items[2])){
				content = items[3];
			}
			// �ж��й�˾�Ƿ�������ϵͳ��������Ȩ���㼸��������̡�(systemid=83, paramtype=��channel��)����ֵΪ1
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class, user);
			String value = sysparam.doFindByID("83", "channel");
			Operright operright = (Operright) BOFactory.build(OperrightBO.class, DBAccessUser.getInnerUser());
			//�жϵ�ǰ��¼�û��Ƿ�ӵ�зֹ�˾����
			boolean ch_checked_county = operright.doCheckPermission(user.getOprcode(), "CH_CHECKED_COUNTY");
			//�жϵ�ǰ��¼�û��Ƿ�ӵ���й�˾��������
			boolean ch_checked_midcity = operright.doCheckPermission(user.getOprcode(), "CH_CHECKED_MIDCITY");
			
			CheckedapplydetailVO detailVo = new CheckedapplydetailVO ();
			if (value != null && value.equals("1") && ch_checked_county) {
				detailVo.setIsflag(Short.parseShort("0"));
			} else if (value != null && value.equals("1") && ch_checked_midcity) {
				detailVo.setIsflag(Short.parseShort("1"));
			}
			detailVo.setCityid(user.getCityid());
			detailVo.setOprcode(user.getOprcode());
			detailVo.setApplytype(items[2]);
			detailVo.setWayid(items[0]);
			detailVo.setChktype(items[1]);
			detailVo.setChgtype(content); 
			// �����뵥�Ų�Ϊ�յ�ʱ��
			if (applyno!=null && !"".equals(applyno)) {
				detailVo.setApplyno(Long.parseLong(applyno));
			}
			DataPackage dp1 = way.doQueryWaytype(wayDBParam);
			if(("1").equals(wayVO.getIstop())){
				detailVo.setWtype("1");
			}else if(null != dp1 && dp1.getDatas().size()>0){
//				 WayVO wayvo1 = (WayVO)dp1.getDatas().get(0);
//				 if (("2").equals(wayvo1.getIstietong())){
				 detailVo.setWtype("2");
//				 }else{
//					 detailVo.setWtype("3");
//				 }
			 } else {
				 detailVo.setWtype("3");
			 }
			
			checkedapplydetail.doCreate(detailVo);
 			line = rowCount
			        + "|"
			        + items[0]
			        + "|"
			        + Code2NameUtils.code2Name("$CH_ASSESSMTHD",items[1], user.getCityid())
					+ "|"
					+ Code2NameUtils.code2Name("$CH_CHECKTYPE",items[2], user.getCityid())
					+ "|"  
					+  content 
					+ "|"+"�����ɹ�"+"|";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) { 
			line = rowCount + "   " + line + "|������Ϣ:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

	public String getApplyno() {
		return applyno;
	}

	public void setApplyno(String applyno) {
		this.applyno = applyno;
	}

}
