package com.sunrise.boss.ui.cms.rewardranlog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.rewardranlog.persistent.RewardranlogVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountListVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.rewardranlog.RewardranlogDelegate;
import com.sunrise.boss.delegate.cms.wayaccount.WayaccountDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class RewardranlogTaskBean extends BaseBatchTaskBean {
	private RewardranlogDelegate delegate;
//	private WayDelegate waydelegate;
	private WayaccountDelegate wayaccountDelegate;
	boolean cando = false;
	public RewardranlogTaskBean() throws Exception{
		// TODO Auto-generated constructor stub
		delegate = new RewardranlogDelegate();
//		waydelegate=new WayDelegate();
		wayaccountDelegate=new WayaccountDelegate();
		super.setBatchName("��𷢷���־������");
		super.setWriteLog(true);
	}
	protected String doStart() {
		return "��𷢷���־�������� \r\n";
	}
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO=new ResultVO();
		String[] content = StringSplit.split(line, "|");
		String wayid = "";
		try{
			// ͨ���տ��˻�ȡ������id
			WayaccountListVO aclistvo = new WayaccountListVO();
			aclistvo.set_se_acctno(content[1]);
			DataPackage accdp = wayaccountDelegate.doQuery(aclistvo, user);
			if(accdp == null || accdp.getRowCount()==0){
				throw new BusinessException("","�˻����������ϲ����ڣ����ڡ����������Ϣ����ά�������Ϣ��");
			} else {
				//�˻���¼����
				Iterator it = accdp.getDatas().iterator();
				while (it.hasNext()) {
					WayaccountVO accvo = (WayaccountVO)it.next();
					wayid = accvo.getWayid();
				}
			}
			RewardranlogVO vo = new RewardranlogVO();
			// ��������
			if (!StringUtils.isEmpty(content[0])) {
				vo.setWayid(content[0]);
			} else {
				if ("".equals(wayid)) {
					throw new BusinessException("","�˻����������ϲ����ڣ����ڡ����������Ϣ����ά�������Ϣ��");
				}
				vo.setWayid(wayid);
			}
			// �տ��˻�
			vo.setPaccount(content[1]);
			// �����˻�
			vo.setRaccount(content[2]);
			// �Ƴ��·�
			vo.setCalcmonth(content[3]);
			// ֧�����
			vo.setRemark((Double.valueOf(content[4])));
			// ֧��ʱ��
			if(!StringUtils.isEmpty(content[5])){
				SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try{
					vo.setPtime(format1.parse(content[5]));
				}catch(Exception e){
					throw new BusinessException("","֧��ʱ���ʽ����ȷ����ȷ�ĸ�ʽӦ��Ϊyyyy-MM-dd HH:mm:ss");
				}
			}
			// ��ע˵��
			if (!"".equals(content[6].trim())) {
				vo.setMemo(content[6].trim());
			}
			// ��������
			vo.setOpercode(user.getOpercode());
			// ����ʱ��
			vo.setOpertime(new Date());
			// ��������
			vo.setOpertype("I");
			delegate.doCreate(vo, user);
			
			line = rowCount + "   " + line + "    �����ɹ�";			
			resultVO.setInfo(line);
			resultVO.setOk(true);
			
		}catch(Exception e){
			line = rowCount + "   " + line + "    ������Ϣ:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
