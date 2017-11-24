package com.gmcc.pboss.web.channel.zjty.zjtywayinfo;

import java.sql.Date;
import org.apache.commons.beanutils.BeanUtils;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.zjty.zjtywayinfo.ZjtywayinfoVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.zjty.zjtywayinfo.Zjtywayinfo;
import com.gmcc.pboss.control.channel.zjty.zjtywayinfo.ZjtywayinfoBO;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class ZjtywayinfoTaskBean extends BaseBatchTaskBean {
	WayBO delegate;
	Zjtywayinfo zjtywayinfodelegate;
	public ZjtywayinfoTaskBean()  throws Exception {
		try {
			batchName = "�Խ���Ӫ��Ϣ����";
			super.setBatchName("�������������ͨ");
			super.setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		try {
			delegate = (WayBO)BOFactory.build(WayBO.class, user);
			zjtywayinfodelegate = (Zjtywayinfo)BOFactory.build(ZjtywayinfoBO.class, user);
		} catch (Exception e) {
		}
//		BatchzjtywayinfoForm batchForm = (BatchzjtywayinfoForm) form;
		return "����|��������|�ϼ�����|���������|����������|������|���й�˾|�ֹ�˾|������������|΢����|�Ǽ�|��Ӫģʽ|�Ƿ�����|������ʽ|��ҵ��Դ����|" +
				"��Ȧ����|��������|��ϵ�绰|��������|����γ��|������|��ϸ��ַ|����״̬|�Ƿ���������|�����̱���|�Ƿ���|ȫ��ͳһ��������|����|������������|" +
				"�Ƿ���������|ǰ̨Ӫҵ������O��|�����ŶӽкŻ�|����POS��|����24Сʱ����Ӫҵ��|����VIPרϯ|����VIP��|G3���������|ί�з���˾����|" +
				"����ע���|���˴���|���֤����|ǩԼ���|Э��ǩ����Чʱ��|Э���ֹʱ��|�����˵绰|Э������|ǩԼʱ��| "
				+ "\r\n";
	}

	/**
	 * ����һ����¼
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		String op = "";

		ZjtywayinfoForm vo = new ZjtywayinfoForm();
		try {
//			// ������������ж�
//			WayVO wayVO = null;
//			Way wdelegate = (Way)BOFactory.build(WayBO.class, user);
//			wayVO = wdelegate.doFindByPk(items[0].trim());
//			if (wayVO == null) {
//				throw new Exception( "������:"+ items[0] +" ��ϵͳ�в����ڡ�");
//			}
			
			// ���ӻ����޸��ж�
			WayVO updateVO = null;
			if (!isNull(items[0])){
				Object obj = delegate.doFindByPk2(items[0].trim());
				if(obj != null){
					updateVO = (WayVO)obj;	
				}
			}
			if (updateVO == null) {
				op = "����";
				this.buildVO(items, vo);
				ZjtywayinfoVO zjtywayinfoVO = new ZjtywayinfoVO();				
			     BeanUtils.copyProperties(zjtywayinfoVO, vo);				
				zjtywayinfodelegate.doMulsave(zjtywayinfoVO, user);
			} else {
				op = "�޸�";

				this.buildVO(items, vo);
				ZjtywayinfoVO zjtywayinfoVO = new ZjtywayinfoVO();				
			     BeanUtils.copyProperties(zjtywayinfoVO, vo);		
				zjtywayinfodelegate.doMulupdate(zjtywayinfoVO, user);
			}
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount, op));
			return resultVO;
		} catch (Exception ex) { // ����ʧ��
			msg = ex.getMessage();
			ex.printStackTrace();
			resultVO.setOk(false);
			resultVO.setInfo(showInfo(resultVO, items, rowCount, op) + msg);
			return resultVO;
		}
	}

	/**
	 * ����ļ���ʽ
	 */
	public String showInfo(ResultVO resultVO, String[] items, int rowCount,
			String op) {
		final String COMPART = " | "; // �ָ�
		StringBuffer resultStr = new StringBuffer();
		// ���
		resultStr.append(rowCount).append(COMPART);
		for (int i = 0; i < items.length; i++) {
			resultStr.append(items[i]).append(COMPART);
		}
		resultStr.append(op);
		// ������
		if (resultVO.isOk()) {
			resultStr.append("�ɹ�");
		} else {
			resultStr.append("ʧ��");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}
//	1����|2��������|3�ϼ�����|4���������|5����������|6������|7���й�˾|8�ֹ�˾|9������������|
//	10΢����|11�Ǽ�|12��Ӫģʽ|13�Ƿ�����|14������ʽ|15��ҵ��Դ����|16��Ȧ����|17��������|18��ϵ�绰|
//	19��������|20����γ��|21������|22��ϸ��ַ|23����״̬|24�Ƿ���������|25�����̱���|26�Ƿ���|
//	27ȫ��ͳһ��������|28����|29������������|30�Ƿ���������|31ǰ̨Ӫҵ������O��|32�����ŶӽкŻ�|
//	33����POS��|34����24Сʱ����Ӫҵ��|35����VIPרϯ|36����VIP��|37G3���������|38ί�з���˾����|
//	39����ע���|40���˴���|41���֤����|42ǩԼ���|43Э��ǩ����Чʱ��|44Э���ֹʱ��|
	private void buildVO(String[] items, ZjtywayinfoForm vo) throws Exception {
		if (notNull(items[0]))
			vo.setWayid(items[0]);// ��������
		if (notNull(items[1]))
			vo.setWayname(items[1]);// ��������
		if (notNull(items[2]))
			vo.setUpperwayid(items[2]);// �ϼ�����
		if (notNull(items[3]))
			vo.setSvbrchcode(items[3]);// ���������
		if (notNull(items[4]))
			vo.setBchlevel(items[4]);// ����������
		if (notNull(items[5]))
			vo.setWaysubtype("ZJTY");// ������
//		if (notNull(items[6]))
//			vo.setCityid(items[6]);// ���й�˾
		vo.setCityid(user.getCityid());
		if (notNull(items[7-1]))
			vo.setCountyid(items[7-1]);// �ֹ�˾
		if (notNull(items[8-1]))
			vo.setSvccode(items[8-1]);// ������������
		if (notNull(items[9-1]))
			vo.setMareacode(items[9-1]);// ΢����
		if (notNull(items[10-1]))
			vo.setStarlevel(Long.valueOf(items[10-1]));// �Ǽ�
//		if (notNull(items[11]))
//			vo.setRunmode(Long.valueOf(items[11]));// ��Ӫģʽ
		vo.setRunmode(Long.valueOf("1"));
		if (notNull(items[12-1-1]))
			vo.setIsconnected(Long.valueOf(items[12-1-1]));// �Ƿ�����
		if (notNull(items[13-1-1]))
			vo.setConnecttype(Long.valueOf(items[13-1-1]));// ������ʽ
		if (notNull(items[14-1-1]))
			vo.setPrtsource(Long.valueOf(items[14-1-1]));// ��ҵ��Դ����
		if (notNull(items[15-1-1]))
			vo.setBuztypecode(Short.parseShort(items[15-1-1]));// ��Ȧ����
		if (notNull(items[16-1-1]))
			vo.setAdtypecode(Short.parseShort(items[16-1-1]));// ��������
		if (notNull(items[17-1-1]))
			vo.setBuzphoneno(items[17-1-1]);// ��ϵ�绰		
		if (notNull(items[18-1-1]))
			vo.setAdacode(items[18-1-1]);// ��������
		if (notNull(items[19-1-1]))
			vo.setLatitude(items[19-1-1]);// ����γ��
		if (notNull(items[20-1-1]))
			vo.setLongtitude(items[20-1-1]);// ������
		if (notNull(items[21-1-1]))
			vo.setAddress(items[21-1-1]);// ��ϸ��ַ
		if (notNull(items[22-1-1]))
			vo.setWaystate(Short.parseShort(items[22-1-1]));// ����״̬
		if (notNull(items[23-1-1]))
			vo.setIscoreway(Long.valueOf(items[23-1-1]));// �Ƿ���������
//		if (notNull(items[24]))
//			vo.setCooperator(Short.parseShort(items[24]));// �����̱���
		if (notNull(items[24-1-1]))
			vo.setChainhead(items[24-1-1]);// �����̱���
		if (notNull(items[25-1-1]))
			vo.setIsshare(items[25-1-1]);// �Ƿ���
		if (notNull(items[26-1-1]))
			vo.setUniquewayid(items[26-1-1]);// ȫ��ͳһ��������
		if (notNull(items[27-1-1]))
			vo.setTown(items[27-1-1]);// ����
		if (notNull(items[28-1-1]))
			vo.setProvtype(Short.valueOf(items[28-1-1]));// ������������
		if (notNull(items[29-1-1]))
			vo.setMobilemall(Short.valueOf(items[29-1-1]));// �Ƿ���������
		if (notNull(items[30-1-1]))
			vo.setFrontarea(Double.valueOf(items[30-1-1]));// ǰ̨Ӫҵ������O��
		if (notNull(items[31-1-1]))
			vo.setHaswaitmach(Short.valueOf(items[31-1-1]));// �����ŶӽкŻ�
		if (notNull(items[32-1-1]))
			vo.setHasposmach(Short.valueOf(items[32-1-1]));// ����POS��
		if (notNull(items[33-1-1]))
			vo.setHas24mall(Short.valueOf(items[33-1-1]));// ����24Сʱ����Ӫҵ��
		if (notNull(items[34-1-1]))
			vo.setHasvipseat(Short.valueOf(items[34-1-1]));// ����VIPרϯ
		if (notNull(items[35-1-1]))
			vo.setHasviproom(Short.valueOf(items[35-1-1]));// ����VIP��
		if (notNull(items[36-1-1]))
			vo.setG3area(Double.valueOf(items[36-1-1]));// G3���������
		if (notNull(items[37-1-1]))
			vo.setCompany(items[37-1-1]);// ί�з���˾����
		if (notNull(items[38-1-1]))
			vo.setBusnum(items[38-1-1]);// ����ע���
		if (notNull(items[39-1-1]))
			vo.setPrincipal(items[39-1-1]);// ���˴���
		if (notNull(items[40-1-1]))
			vo.setCertinum(items[40-1-1]);// ���֤����
		if (notNull(items[41-1-1]))
			vo.setCompactno(items[41-1-1]);// ǩԼ���
		if (notNull(items[42-1-1]))
 			vo.setSigntime(Date.valueOf(items[42-1-1]));// Э��ǩ����Чʱ��
		if (notNull(items[43-1-1]))
			vo.setEndtime(Date.valueOf(items[43-1-1]));// Э���ֹʱ��
		if(notNull(items[44-1-1]))
			vo.setPrincipaltel(items[44-1-1]);//45�����˵绰
		if(notNull(items[45-1-1]))
			vo.setCompactname(items[45-1-1]);//46Э������
		if(notNull(items[46-1-1]))
			vo.setBegintime(Date.valueOf(items[46-1-1]));//47ǩԼʱ��
	}

	private boolean isNull(String item) {
		return "".equals(item.trim()) || "null".equals(item)
				|| "��".equals(item);
	}

	private boolean notNull(String item) {
		if (item == null) {
			return false;
		}
		if (item.trim().length() > 0) {
			return true;
		} else {
			return false;
		}
	}
}
