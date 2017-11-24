package com.sunrise.boss.ui.cms.way;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountDAO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountListVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountVO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.bchcontact.BchcontactDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.wayaccount.WayaccountDelegate;
import com.sunrise.boss.delegate.cms.waycompact.WaycompactDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

/**
 * �����̵��봦��BEAN
 * @author zhaowen
 *
 */
public class BatchLOGISWayTaskBean extends BaseBatchTaskBean {
	private WayDelegate delegate;
	private BchcontactDelegate bchdelegate;
	private WaycompactDelegate comdelegate;
	private WayaccountDelegate accdelegate;
	
	public BatchLOGISWayTaskBean() {
		try {
			delegate = new WayDelegate();
			bchdelegate = new BchcontactDelegate();
			comdelegate = new WaycompactDelegate();
			accdelegate = new WayaccountDelegate();
			batchName = "���������Ϣ����";
			setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		return "��� | �������� | �������� | �ϼ��������� | ������ | ���й�˾ | �ֹ�˾ | ������������ | ΢����  | �������� | ��ϸ��ַ | ���������� | ��������ϵ�绰 | �����˵������� | ҵ����ϵ������ | ҵ����ϵ����ϵ�绰 | ҵ����ϵ�˵������� | ��ͬ���� | ��ͬ���� | ǩ���ͬʱ�� | ��ͬ������ | ���˴��� | Ӫҵִ�ձ�� | ��Ӫ�������ͱ��� | ��Ӫ��Χ | �����ʺ� | �������� | �����˺����� | ���������֤���� " + "\r\n";
	}

	/**
	 * ����һ����¼
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		//ȥ�ո�
		for(int i=0;i<items.length;i++)
		{
			if(items[i]!=null)
				items[i]=items[i].trim();
		}
		WayVO wayVO = new WayVO();
		BchcontactVO bchcontactVO = new BchcontactVO();
		WaycompactVO waycompactVO = new WaycompactVO();
		WayaccountVO wayaccountVO = new WayaccountVO();
		
		WayVO wayVO1 = new WayVO();
		BchcontactVO bchcontactVO1 = new BchcontactVO();
		WaycompactVO waycompactVO1 = new WaycompactVO();
		WayaccountVO wayaccountVO1 = new WayaccountVO();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {

			//�������������Ϣ
			wayVO.setWayid(items[0]);
			wayVO1 = delegate.doFindByPk(wayVO.getWayid(), user);
			if (wayVO1 == null) {// ����
				wayVO.setWayname(items[1]);
				wayVO.setUpperwayid(items[2]);
				wayVO.setCooperator("".equals(items[3].trim())? null : new Short(items[3]));
				wayVO.setCityid(items[4]);
				wayVO.setCountyid(items[5]);
				wayVO.setSvccode(items[6]);
				wayVO.setMiscode(items[7]);
				wayVO.setAdacode(items[8]);
				wayVO.setLatitude(items[9]);
				wayVO.setLongtitude(items[10]);
				wayVO.setAddress(items[11]);
				wayVO.setWaytype("AG");
				wayVO.setWaysubtype("LOGS");
				delegate.doCreate(wayVO, user);
			}else {
				BeanUtils.copyProperties(wayVO, wayVO1);
				if (items[1] == null || "".equals(items[1])) {
					wayVO.setWayname(wayVO1.getWayname());
				} else if ("null".equals(items[1]) || "��".equals(items[1])) {
					throw new BusinessException("�������Ʋ����޸�Ϊ��!");
				} else
					wayVO.setWayname(items[1]);
				if (items[2] == null || "".equals(items[2])) {
					wayVO.setUpperwayid(wayVO1.getUpperwayid());
				} else if ("null".equals(items[2]) || "��".equals(items[2])) {
					throw new BusinessException("�ϼ��������벻���޸�Ϊ��!");
				} else
					wayVO.setUpperwayid(items[2]);
				if (items[3] == null || "".equals(items[3])) {
					wayVO.setCooperator(wayVO1.getCooperator());
				} else if ("null".equals(items[3]) || "��".equals(items[3])) {
					wayVO.setCooperator(null);
				} else
					wayVO.setCooperator(new Short(items[3]));
				if (items[4] == null || "".equals(items[4])) {
					wayVO.setCityid(wayVO1.getCityid());
				} else if ("null".equals(items[4]) || "��".equals(items[4])) {
					wayVO.setCityid(null);
				} else
					wayVO.setCityid(items[4]);
				if (items[5] == null || "".equals(items[5])) {
					wayVO.setCountyid(wayVO1.getCountyid());
				} else if ("null".equals(items[5]) || "��".equals(items[5])) {
					wayVO.setCountyid(null);
				} else
					wayVO.setCountyid(items[5]);
				if (items[6] == null || "".equals(items[6])) {
					wayVO.setSvccode(wayVO1.getSvccode());
				} else if ("null".equals(items[6]) || "��".equals(items[6])) {
					wayVO.setSvccode(null);
				} else
					wayVO.setSvccode(items[6]);
				if (items[7] == null || "".equals(items[7])) {
					wayVO.setMiscode(wayVO1.getMiscode());
				} else if ("null".equals(items[7]) || "��".equals(items[7])) {
					wayVO.setMiscode(null);
				} else
					wayVO.setMiscode(items[7]);
				if (items[8] == null || "".equals(items[8])) {
					wayVO.setAdacode(wayVO1.getAdacode());
				} else if ("null".equals(items[8]) || "��".equals(items[8])) {
					wayVO.setAdacode(null);
				} else
					wayVO.setAdacode(items[8]);
				if (items[9] == null || "".equals(items[9])) {
					wayVO.setLatitude(wayVO1.getLatitude());
				} else if ("null".equals(items[9]) || "��".equals(items[9])) {
					wayVO.setLatitude(null);
				} else
					wayVO.setLatitude(items[9]);
				if (items[10] == null || "".equals(items[10])) {
					wayVO.setLongtitude(wayVO1.getLongtitude());
				} else if ("null".equals(items[10]) || "��".equals(items[10])) {
					wayVO.setLongtitude(null);
				} else
					wayVO.setLongtitude(items[10]);
				if (items[11] == null || "".equals(items[11])) {
					wayVO.setAddress(wayVO1.getAddress());
				} else if ("null".equals(items[11]) || "��".equals(items[11])) {
					wayVO.setAddress(null);
				} else
					wayVO.setAddress(items[11]);
				
				delegate.doUpdate(wayVO, user);
			}
			
			//��ͨ��Ϣ
			bchcontactVO.setWayid(items[0]);
			bchcontactVO1 = bchdelegate.doFindByPk(bchcontactVO.getWayid(),
					user);
			if (bchcontactVO1 == null) { // ����
				bchcontactVO.setPrincipal(items[10]);
				bchcontactVO.setPrincipaltel(items[13]);
				bchcontactVO.setPrincipalemail(items[14]);
				bchcontactVO.setLinkman(items[15]);
				bchcontactVO.setLinkmantel(items[16]);
				bchcontactVO.setLinkmanemail(items[17]);
				bchdelegate.doCreate(bchcontactVO,user);
			}else {
				BeanUtils.copyProperties(bchcontactVO, bchcontactVO1);
				if (items[10] == null || "".equals(items[10])) {
					bchcontactVO.setPrincipal(bchcontactVO1.getPrincipal());
				} else if ("null".equals(items[10]) || "��".equals(items[10])) {
					throw new BusinessException("���������������޸�Ϊ��!");
				} else
					bchcontactVO.setPrincipal(items[10]);
				if (items[13] == null || "".equals(items[13])) {
					bchcontactVO.setPrincipaltel(bchcontactVO1.getPrincipaltel());
				} else if ("null".equals(items[13]) || "��".equals(items[13])) {
					throw new BusinessException("��������ϵ�绰�����޸�Ϊ��!");
				} else
					bchcontactVO.setPrincipaltel(items[13]);
				if (items[14] == null || "".equals(items[14])) {
					bchcontactVO.setPrincipalemail(bchcontactVO1.getPrincipalemail());
				} else if ("null".equals(items[14]) || "��".equals(items[14])) {
					bchcontactVO.setPrincipalemail(null);
				} else
					bchcontactVO.setPrincipalemail(items[14]);
				if (items[15] == null || "".equals(items[15])) {
					bchcontactVO.setLinkman(bchcontactVO1.getLinkman());
				} else if ("null".equals(items[15]) || "��".equals(items[15])) {
					throw new BusinessException("ҵ����ϵ�����������޸�Ϊ��!");
				} else
					bchcontactVO.setLinkman(items[15]);
				if (items[16] == null || "".equals(items[16])) {
					bchcontactVO.setLinkmantel(bchcontactVO1.getLinkmantel());
				} else if ("null".equals(items[16]) || "��".equals(items[16])) {
					bchcontactVO.setLinkmantel(null);
				} else
					bchcontactVO.setLinkmantel(items[16]);
				if (items[17] == null || "".equals(items[17])) {
					bchcontactVO.setLinkmanemail(bchcontactVO1.getLinkmanemail());
				} else if ("null".equals(items[17]) || "��".equals(items[17])) {
					bchcontactVO.setLinkmanemail(null);
				} else
					bchcontactVO.setLinkmanemail(items[17]);
				bchdelegate.doUpdate(bchcontactVO, user);
			}

			//��ͬ��Ϣ
			waycompactVO.setWayid(items[0]);
			waycompactVO1 = comdelegate.doFindByPk(waycompactVO.getWayid(), user);
			if (waycompactVO1 ==null) {
				waycompactVO.setCompactno(items[18]);
				waycompactVO.setCompactname(items[19]);
				waycompactVO.setBegintime(new  java.sql.Date(format.parse(items[20]).getTime()));
				waycompactVO.setSigntime(new  java.sql.Date(format.parse(items[20]).getTime()));
				waycompactVO.setEndtime(new  java.sql.Date(format.parse(items[21]).getTime()));
				waycompactVO.setPrincipal(items[22]);
				waycompactVO.setLicenceno(items[23]);
				if (items[24] != null && !"".equals(items[24])) {
					waycompactVO.setRunareatype(new Short(items[24]));
				}
				waycompactVO.setCopbound(items[25]);
				comdelegate.doCreate(waycompactVO,user);
			}else {
				BeanUtils.copyProperties(waycompactVO, waycompactVO1);
				if (items[18] == null || "".equals(items[18])) {
					waycompactVO.setCompactno(waycompactVO1.getCompactno());
				} else if ("null".equals(items[18]) || "��".equals(items[18])) {
					throw new BusinessException("��ͬ���벻���޸�Ϊ��!");
				} else
					waycompactVO.setCompactno(items[18]);
				if (items[19] == null || "".equals(items[19])) {
					waycompactVO.setCompactname(waycompactVO1.getCompactname());
				} else if ("null".equals(items[19]) || "��".equals(items[19])) {
					throw new BusinessException("��ͬ���Ʋ����޸�Ϊ��!");
				} else
					waycompactVO.setCompactname(items[19]);
				if (items[20] == null || "".equals(items[20])) {
					waycompactVO.setBegintime(waycompactVO1.getBegintime());
					waycompactVO.setSigntime(waycompactVO1.getSigntime());
				} else if ("null".equals(items[20]) || "��".equals(items[20])) {
					throw new BusinessException("ǩ���ͬʱ����ߺ�ͬ�����ղ����޸�Ϊ��!");
				} else {
					waycompactVO.setBegintime(new  java.sql.Date(format.parse(items[20]).getTime()));
					waycompactVO.setSigntime(new  java.sql.Date(format.parse(items[20]).getTime()));
				}
					
				if (items[21] == null || "".equals(items[21])) {
					waycompactVO.setEndtime(waycompactVO1.getEndtime());
				} else if ("null".equals(items[21]) || "��".equals(items[21])) {
					waycompactVO.setEndtime(null);
				} else
					waycompactVO.setEndtime(new  java.sql.Date(format.parse(items[21]).getTime()));
				if (items[22] == null || "".equals(items[22])) {
					waycompactVO.setPrincipal(waycompactVO1.getPrincipal());
				} else if ("null".equals(items[22]) || "��".equals(items[22])) {
					waycompactVO.setPrincipal(null);
				} else
					waycompactVO.setPrincipal(items[22]);
				if (items[23] == null || "".equals(items[23])) {
					waycompactVO.setLicenceno(waycompactVO1.getLicenceno());
				} else if ("null".equals(items[23]) || "��".equals(items[23])) {
					waycompactVO.setLicenceno(null);
				} else
					waycompactVO.setLicenceno(items[23]);
				if (items[24] == null || "".equals(items[24])) {
					waycompactVO.setRunareatype(waycompactVO1.getRunareatype());
				} else if ("null".equals(items[24]) || "��".equals(items[24])) {
					waycompactVO.setRunareatype(null);
				} else
					waycompactVO.setRunareatype(new Short(items[24]));
				if (items[25] == null || "".equals(items[25])) {
					waycompactVO.setCopbound(waycompactVO1.getCopbound());
				} else if ("null".equals(items[25]) || "��".equals(items[25])) {
					waycompactVO.setCopbound(null);
				} else
					waycompactVO.setCopbound(items[25]);
				
				comdelegate.doUpdate(waycompactVO,user);
			}
			
			//�ʻ���Ϣ
			wayaccountVO.setWayid(items[0]);
			wayaccountVO.setAccid(new Integer(1));
			WayaccountListVO acclistvo = new WayaccountListVO();
			acclistvo.set_ne_accid(wayaccountVO.getAccid());
			acclistvo.set_se_wayid(wayaccountVO.getWayid());
			DataPackage accdp = (DataPackage) accdelegate.doQuery(acclistvo, user);
			List acclist = (List)accdp.getDatas();
			if (acclist.size()==0) {
				wayaccountVO.setBankname(items[27]);
				wayaccountVO.setAcctno(items[26]);
				wayaccountVO.setAcctname(items[28]);
				wayaccountVO.setAcctfid(items[29]);
				wayaccountVO.setAccttype(new Short("0"));
				wayaccountVO.setChargetype(new Short("0"));
				accdelegate.doCreate(wayaccountVO,user);
			}else {
				wayaccountVO1 = (WayaccountVO)acclist.get(0);
				BeanUtils.copyProperties(wayaccountVO, wayaccountVO1);
				
				if (items[27] == null || "".equals(items[27])) {
					wayaccountVO.setBankname(wayaccountVO.getBankname());
				} else if ("null".equals(items[27]) || "��".equals(items[27])) {
					throw new BusinessException("�������в����޸�Ϊ��!");
				} else
					wayaccountVO.setBankname(items[27]);
				if (items[26] == null || "".equals(items[26])) {
					wayaccountVO.setAcctno(wayaccountVO.getAcctno());
				} else if ("null".equals(items[26]) || "��".equals(items[26])) {
					wayaccountVO.setAcctno(null);
				} else
					wayaccountVO.setAcctno(items[26]);
				if (items[28] == null || "".equals(items[28])) {
					wayaccountVO.setAcctname(wayaccountVO.getAcctname());
				} else if ("null".equals(items[28]) || "��".equals(items[28])) {
					throw new BusinessException("�����ʺ����Ʋ����޸�Ϊ��!");
				} else
					wayaccountVO.setAcctname(items[28]);
				if (items[29] == null || "".equals(items[29])) {
					wayaccountVO.setAcctfid(wayaccountVO.getAcctfid());
				} else if ("null".equals(items[29]) || "��".equals(items[29])) {
					wayaccountVO.setAcctfid(null);
				} else
					wayaccountVO.setAcctfid(items[29]);
				
				accdelegate.doUpdate(wayaccountVO,user);
			}

			
			
			
			
				
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount));
			return resultVO;
		} catch (Exception ex) { // ����ʧ��
			msg = ex.getMessage();
			ex.printStackTrace();
			resultVO.setOk(false);
			resultVO.setInfo(showInfo(resultVO, items, rowCount) + msg);
			return resultVO;
		}
	}

	/**
	 * ����ļ���ʽ
	 */
	public String showInfo(ResultVO resultVO, String[] items, int rowCount) {
		final String COMPART = " | "; // �ָ�
		StringBuffer resultStr = new StringBuffer();
		// ���
		resultStr.append(rowCount).append(COMPART);
		resultStr.append(items[0]).append(COMPART);
		resultStr.append(items[1]).append(COMPART);
		resultStr.append(items[2]).append(COMPART);
		resultStr.append(items[3]).append(COMPART);
		resultStr.append(items[4]).append(COMPART);
		resultStr.append(items[5]).append(COMPART);
		resultStr.append(items[6]).append(COMPART);
		resultStr.append(items[7]).append(COMPART);
		resultStr.append(items[8]).append(COMPART);
		resultStr.append(items[9]).append(COMPART);
		resultStr.append(items[10]).append(COMPART);
		resultStr.append(items[11]).append(COMPART);
		resultStr.append(items[12]).append(COMPART);
		resultStr.append(items[13]).append(COMPART);
		resultStr.append(items[14]).append(COMPART);
		resultStr.append(items[15]).append(COMPART);
		resultStr.append(items[16]).append(COMPART);
		resultStr.append(items[17]).append(COMPART);
		resultStr.append(items[18]).append(COMPART);
		resultStr.append(items[19]).append(COMPART);
		resultStr.append(items[20]).append(COMPART);
		resultStr.append(items[21]).append(COMPART);
		resultStr.append(items[22]).append(COMPART);	
		resultStr.append(items[23]).append(COMPART);
		resultStr.append(items[24]).append(COMPART);
		resultStr.append(items[25]).append(COMPART);
		resultStr.append(items[26]).append(COMPART);
		resultStr.append(items[27]).append(COMPART);
		resultStr.append(items[28]).append(COMPART);

		resultStr.append("����");
		resultStr.append(COMPART);
		// ������
		if (resultVO.isOk()) {
			resultStr.append("�ɹ�");
		} else {
			resultStr.append("ʧ��");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}

}
