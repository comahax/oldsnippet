package com.sunrise.boss.ui.cms.way;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactVO;
import com.sunrise.boss.business.cms.common.AuditUtils;
import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountListVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountVO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.bchcontact.BchcontactDelegate;
import com.sunrise.boss.delegate.cms.distribute.cooperator.CooperatorDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.wayaccount.WayaccountDelegate;
import com.sunrise.boss.delegate.cms.waycompact.WaycompactDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

/**
 * �����̵��봦��BEAN
 * 
 * @author zhaowen
 * 
 */
public class BatchDISWayTaskBean extends BaseBatchTaskBean {
	private WayDelegate delegate;

	private BchcontactDelegate bchdelegate;

	private WaycompactDelegate comdelegate;

	private WayaccountDelegate accdelegate;

	private CooperatorDelegate coopdelegate;

	public BatchDISWayTaskBean() {
		try {
			delegate = new WayDelegate();
			bchdelegate = new BchcontactDelegate();
			comdelegate = new WaycompactDelegate();
			accdelegate = new WayaccountDelegate();
			coopdelegate = new CooperatorDelegate();
			batchName = "���������Ϣ����";
			setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		return "��� | �������� | �������� | �ϼ��������� | ������ | ���й�˾ | �ֹ�˾ | ������������ | ΢����  | �Ǽ� | �����㼶 | �������� | ������ | ����γ�� | ��ϸ��ַ | ���������� | ��������ϵ�绰 | �����˵������� | ҵ����ϵ������ | ҵ����ϵ����ϵ�绰 | ҵ����ϵ�˵������� | ��ͬ���� | ��ͬ���� | ǩ���ͬʱ�� | ��ͬ������ | ���˴��� | Ӫҵִ�ձ�� | ��Ӫ�������ͱ��� | ��Ӫ��Χ | �����ʺ� | �������� | �����ʺ� | �����˺����� | ���������֤����  | �ͻ���ַ | �ջ���ϵ�� | �ջ���ϵ���� | �ջ���֤������ | Ӫҵִ����Ч�� | ��֤������ | ��������|��Чʱ��|ʧЧʱ��|������λ|�����̼���|���̺�|֤�����|֤������|ע���ַ|ע���ʽ�|����״̬"
				+ "\r\n";
	}

	/**
	 * ����һ����¼
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		for(int i=0;i<items.length;i++)
		{
			items[i]=items[i].trim();
		}
		WayVO wayVO = new WayVO();
		BchcontactVO bchcontactVO = new BchcontactVO();
		WaycompactVO waycompactVO = new WaycompactVO();
		WayaccountVO wayaccountVO = new WayaccountVO();
		CooperatorVO cooperatorvo = new CooperatorVO();// ������

		WayVO wayVO1 = new WayVO();
		BchcontactVO bchcontactVO1 = new BchcontactVO();
		WaycompactVO waycompactVO1 = new WaycompactVO();
		WayaccountVO wayaccountVO1 = new WayaccountVO();
		CooperatorVO cooperatorvo1 = new CooperatorVO();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {

			// �������������Ϣ
			wayVO.setWayid(items[0]);
			wayVO1 = delegate.doFindByPk(wayVO.getWayid(), user);
			if (wayVO1 == null) {// ����
				wayVO.setWayid(items[0]);
				wayVO.setWayname(items[1]);
				wayVO.setUpperwayid(items[2]);
				wayVO.setCooperator("".equals(items[3]) ? null
						: new Short(items[3]));
				wayVO.setCityid(items[4]);
				wayVO.setCountyid(items[5]);
				wayVO.setSvccode(items[6]);
				wayVO.setMareacode(items[7]);

				wayVO.setWaystate("".equals(items[48]) ? null
						: new Short(items[48]));// ����״̬

				wayVO.setTaxtype("".equals(items[8]) ? null : new Short(
						items[8]));
				wayVO.setMainlayer("".equals(items[9]) ? null
						: new Short(items[9]));

				wayVO.setAdacode(items[10]);
				wayVO.setLatitude(items[11]);
				wayVO.setLongtitude(items[12]);
				wayVO.setAddress(items[13]);
				wayVO.setWaytype("AG");
				wayVO.setWaysubtype("DIS");
				// ����������Ĭ��ֵΪ1�����ã�
				wayVO.setWaystate(new Short("1"));
				delegate.doCreate(wayVO, user);
			} else {
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
					wayVO.setMareacode(wayVO1.getMareacode());
				} else if ("null".equals(items[7]) || "��".equals(items[7])) {
					wayVO.setMareacode(null);
				} else
					wayVO.setMareacode(items[7]);
				if (items[8] == null || "".equals(items[8])) {
					wayVO.setStarlevel(wayVO1.getStarlevel());
				} else if ("null".equals(items[8]) || "��".equals(items[8])) {
					wayVO.setStarlevel(null);
				} else
					wayVO.setStarlevel(new Long(items[8]));
				if (items[9] == null || "".equals(items[9])) {
					wayVO.setMainlayer(wayVO1.getMainlayer());
				} else if ("null".equals(items[9]) || "��".equals(items[9])) {
					wayVO.setMainlayer(null);
				} else
					wayVO.setMainlayer(new Short(items[9]));
				if (items[10] == null || "".equals(items[10])) {
					wayVO.setAdacode(wayVO1.getAdacode());
				} else if ("null".equals(items[10]) || "��".equals(items[10])) {
					wayVO.setAdacode(null);
				} else
					wayVO.setAdacode(items[10]);
				if (items[11] == null || "".equals(items[11])) {
					wayVO.setLatitude(wayVO1.getLatitude());
				} else if ("null".equals(items[11]) || "��".equals(items[11])) {
					wayVO.setLatitude(null);
				} else
					wayVO.setLatitude(items[11]);
				if (items[12] == null || "".equals(items[12])) {
					wayVO.setLongtitude(wayVO1.getLongtitude());
				} else if ("null".equals(items[12]) || "��".equals(items[12])) {
					wayVO.setLongtitude(null);
				} else
					wayVO.setLongtitude(items[12]);
				if (items[13] == null || "".equals(items[13])) {
					wayVO.setAddress(wayVO1.getAddress());
				} else if ("null".equals(items[13]) || "��".equals(items[13])) {
					wayVO.setAddress(null);
				} else
					wayVO.setAddress(items[13]);
				if (items[48] == null || "".equals(items[48])) {
					wayVO.setWaystate(wayVO1.getWaystate());
				} else if ("null".equals(items[48]) || "��".equals(items[48])) {
					throw new BusinessException("����״̬�����޸�Ϊ��,������0��1!");
				} else
					wayVO.setWaystate(new Short(items[48]));

				delegate.doUpdate(wayVO, user);
			}

			// ��ͨ��Ϣ
			bchcontactVO.setWayid(items[0]);
			bchcontactVO1 = bchdelegate.doFindByPk(bchcontactVO.getWayid(),
					user);
			if (bchcontactVO1 == null) { // ����
				bchcontactVO.setPrincipal(items[14]);
				bchcontactVO.setPrincipaltel(items[15]);
				bchcontactVO.setPrincipalemail(items[16]);
				bchcontactVO.setLinkman(items[17]);
				bchcontactVO.setLinkmantel(items[18]);
				bchcontactVO.setLinkmanemail(items[19]);
				bchcontactVO.setCompany(items[41]);
				if (!"".equals(items[42]))
					bchcontactVO.setCoplevel(new Integer(items[42]));
				bchcontactVO.setBusnum(items[43]);
				if (!"".equals(items[44]))
					bchcontactVO.setCertitype(new Integer(items[44]));
				bchcontactVO.setCertinum(items[45]);
				bchcontactVO.setRegadress(items[46]);
				if (!"".equals(items[47]))
					bchcontactVO.setRegcapital(new Long(items[47]));
				bchdelegate.doCreate(bchcontactVO, user);
			} else {
				BeanUtils.copyProperties(bchcontactVO, bchcontactVO1);
				if (items[14] == null || "".equals(items[14])) {
					bchcontactVO.setPrincipal(bchcontactVO1.getPrincipal());
				} else if ("null".equals(items[14]) || "��".equals(items[14])) {
					throw new BusinessException("���������������޸�Ϊ��!");
				} else
					bchcontactVO.setPrincipal(items[14]);
				if (items[15] == null || "".equals(items[15])) {
					bchcontactVO.setPrincipaltel(bchcontactVO1
							.getPrincipaltel());
				} else if ("null".equals(items[15]) || "��".equals(items[15])) {
					throw new BusinessException("��������ϵ�绰�����޸�Ϊ��!");
				} else
					bchcontactVO.setPrincipaltel(items[15]);
				if (items[16] == null || "".equals(items[16])) {
					bchcontactVO.setPrincipalemail(bchcontactVO1
							.getPrincipalemail());
				} else if ("null".equals(items[16]) || "��".equals(items[16])) {
					bchcontactVO.setPrincipalemail(null);
				} else
					bchcontactVO.setPrincipalemail(items[16]);
				if (items[17] == null || "".equals(items[17])) {
					bchcontactVO.setLinkman(bchcontactVO1.getLinkman());
				} else if ("null".equals(items[17]) || "��".equals(items[17])) {
					throw new BusinessException("ҵ����ϵ�����������޸�Ϊ��!");
				} else
					bchcontactVO.setLinkman(items[17]);
				if (items[18] == null || "".equals(items[18])) {
					bchcontactVO.setLinkmantel(bchcontactVO1.getLinkmantel());
				} else if ("null".equals(items[18]) || "��".equals(items[18])) {
					bchcontactVO.setLinkmantel(null);
				} else
					bchcontactVO.setLinkmantel(items[18]);
				if (items[19] == null || "".equals(items[19])) {
					bchcontactVO.setLinkmanemail(bchcontactVO1
							.getLinkmanemail());
				} else if ("null".equals(items[19]) || "��".equals(items[19])) {
					bchcontactVO.setLinkmanemail(null);
				} else
					bchcontactVO.setLinkmanemail(items[19]);

				if (items[41] == null || "".equals(items[41])) {
					bchcontactVO.setCompany((bchcontactVO1.getCompany()));
				} else if ("null".equals(items[41]) || "��".equals(items[41])) {
					bchcontactVO.setCompany(null);
				} else
					bchcontactVO.setLinkmanemail(items[41]);

				if (items[42] == null || "".equals(items[42])) {
					bchcontactVO.setCoplevel(bchcontactVO1.getCoplevel());
				} else if ("null".equals(items[42]) || "��".equals(items[42])) {
					bchcontactVO.setCoplevel(null);
				} else
					bchcontactVO.setCoplevel(new Integer(items[42]));

				if (items[43] == null || "".equals(items[43])) {
					bchcontactVO.setBusnum(bchcontactVO1.getBusnum());
				} else if ("null".equals(items[43]) || "��".equals(items[43])) {
					bchcontactVO.setBusnum(null);
				} else
					bchcontactVO.setBusnum(items[43]);

				if (items[44] == null || "".equals(items[44])) {
					bchcontactVO.setCertitype(bchcontactVO1.getCertitype());
				} else if ("null".equals(items[44]) || "��".equals(items[44])) {
					bchcontactVO.setCertitype(null);
				} else
					bchcontactVO.setCertitype(new Integer(items[44]));

				if (items[45] == null || "".equals(items[45])) {
					bchcontactVO.setCertinum(bchcontactVO1.getCertinum());
				} else if ("null".equals(items[45]) || "��".equals(items[45])) {
					bchcontactVO.setCertinum(null);
				} else
					bchcontactVO.setCertinum(items[45]);

				if (items[46] == null || "".equals(items[46])) {
					bchcontactVO.setRegadress(bchcontactVO1.getRegadress());
				} else if ("null".equals(items[46]) || "��".equals(items[46])) {
					bchcontactVO.setRegadress(null);
				} else
					bchcontactVO.setRegadress(items[46]);

				if (items[47] == null || "".equals(items[47])) {
					bchcontactVO.setRegcapital(bchcontactVO1.getRegcapital());
				} else if ("null".equals(items[47]) || "��".equals(items[47])) {
					bchcontactVO.setRegcapital(null);
				} else
					bchcontactVO.setRegcapital(new Long(items[47]));

				bchdelegate.doUpdate(bchcontactVO, user);
			}

			// ��ͬ��Ϣ
			waycompactVO.setWayid(items[0]);
			waycompactVO1 = comdelegate.doFindByPk(waycompactVO.getWayid(),
					user);
			if (waycompactVO1 == null) {
				waycompactVO.setCompactno(items[20]);
				waycompactVO.setCompactname(items[21]);
				waycompactVO.setBegintime("".equals(items[22]) ? null
						: new java.sql.Date(format.parse(items[22]).getTime()));
				waycompactVO.setSigntime("".equals(items[22]) ? null
						: new java.sql.Date(format.parse(items[22]).getTime()));
				waycompactVO.setEndtime("".equals(items[23]) ? null
						: new java.sql.Date(format.parse(items[23]).getTime()));
				waycompactVO.setPrincipal(items[24]);
				waycompactVO.setLicenceno(items[25]);
				waycompactVO.setRunareatype("".equals(items[26]) ? null
						: new Short(items[26]));
				waycompactVO.setCopbound(items[27]);
				waycompactVO.setBail("".equals(items[37]) ? null
						: new Double(items[37]));
				waycompactVO.setBegintime("".equals(items[39]) ? null
						: new java.sql.Date(format.parse(items[39]).getTime()));
				waycompactVO.setEndtime("".equals(items[40]) ? null
						: new java.sql.Date(format.parse(items[40]).getTime()));
				comdelegate.doCreate(waycompactVO, user);
			} else {
				BeanUtils.copyProperties(waycompactVO, waycompactVO1);
				if (items[20] == null || "".equals(items[20])) {
					waycompactVO.setCompactno(waycompactVO1.getCompactno());
				} else if ("null".equals(items[20]) || "��".equals(items[20])) {
					throw new BusinessException("��ͬ���벻���޸�Ϊ��!");
				} else
					waycompactVO.setCompactno(items[20]);
				if (items[21] == null || "".equals(items[21])) {
					waycompactVO.setCompactname(waycompactVO1.getCompactname());
				} else if ("null".equals(items[21]) || "��".equals(items[21])) {
					throw new BusinessException("��ͬ���Ʋ����޸�Ϊ��!");
				} else
					waycompactVO.setCompactname(items[21]);
				if (items[22] == null || "".equals(items[22])) {
					waycompactVO.setBegintime(waycompactVO1.getBegintime());
					waycompactVO.setSigntime(waycompactVO1.getSigntime());
				} else if ("null".equals(items[22]) || "��".equals(items[22])) {
					throw new BusinessException("ǩ���ͬʱ����ߺ�ͬ�����ղ����޸�Ϊ��!");
				} else {
					waycompactVO.setBegintime(new java.sql.Date(format.parse(
							items[22]).getTime()));
					waycompactVO.setSigntime(new java.sql.Date(format.parse(
							items[22]).getTime()));
				}

				if (items[23] == null || "".equals(items[23])) {
					waycompactVO.setEndtime(waycompactVO1.getEndtime());
				} else if ("null".equals(items[23]) || "��".equals(items[23])) {
					waycompactVO.setEndtime(null);
				} else
					waycompactVO.setEndtime(new java.sql.Date(format.parse(
							items[23]).getTime()));
				if (items[24] == null || "".equals(items[24])) {
					waycompactVO.setPrincipal(waycompactVO1.getPrincipal());
				} else if ("null".equals(items[24]) || "��".equals(items[24])) {
					waycompactVO.setPrincipal(null);
				} else
					waycompactVO.setPrincipal(items[24]);
				if (items[25] == null || "".equals(items[25])) {
					waycompactVO.setLicenceno(waycompactVO1.getLicenceno());
				} else if ("null".equals(items[25]) || "��".equals(items[25])) {
					waycompactVO.setLicenceno(null);
				} else
					waycompactVO.setLicenceno(items[25]);
				if (items[26] == null || "".equals(items[26])) {
					waycompactVO.setRunareatype(waycompactVO1.getRunareatype());
				} else if ("null".equals(items[26]) || "��".equals(items[26])) {
					waycompactVO.setRunareatype(null);
				} else
					waycompactVO.setRunareatype(new Short(items[26]));
				if (items[27] == null || "".equals(items[27])) {
					waycompactVO.setCopbound(waycompactVO1.getCopbound());
				} else if ("null".equals(items[27]) || "��".equals(items[27])) {
					waycompactVO.setCopbound(null);
				} else
					waycompactVO.setCopbound(items[27]);
				if (items[37] == null || "".equals(items[37])) {
					waycompactVO.setBail(waycompactVO1.getBail());
				} else if ("null".equals(items[37]) || "��".equals(items[37])) {
					waycompactVO.setBail(null);
				} else
					waycompactVO.setBail(new Double(items[37]));

				comdelegate.doUpdate(waycompactVO, user);
			}

			// �ʻ���Ϣ
			wayaccountVO.setWayid(items[0]);
			wayaccountVO.setAccid(new Integer(1));
			WayaccountListVO acclistvo = new WayaccountListVO();
			acclistvo.set_ne_accid(wayaccountVO.getAccid());
			acclistvo.set_se_wayid(wayaccountVO.getWayid());
			DataPackage accdp = (DataPackage) accdelegate.doQuery(acclistvo,
					user);
			List acclist = (List) accdp.getDatas();
			if (acclist.size() == 0) {
				wayaccountVO.setAccid(new Integer(1));
				wayaccountVO.setBankname(items[29]);
				wayaccountVO.setAcctno(items[28]);
				wayaccountVO.setAcctname(items[30]);
				wayaccountVO.setAcctfid(items[31]);
				wayaccountVO.setAccttype(new Short("0"));
				wayaccountVO.setChargetype(new Short("0"));
				wayVO.setWaystate(new Short("1"));
				accdelegate.doCreate(wayaccountVO, user);
			} else {
				wayaccountVO1 = (WayaccountVO) acclist.get(0);
				BeanUtils.copyProperties(wayaccountVO, wayaccountVO1);

				if (items[28] == null || "".equals(items[28])) {
					wayaccountVO.setBankname(wayaccountVO.getBankname());
				} else if ("null".equals(items[28]) || "��".equals(items[28])) {
					throw new BusinessException("�����ʺŲ����޸�Ϊ��!");
				} else
					wayaccountVO.setBankname(items[28]);
				if (items[29] == null || "".equals(items[29])) {
					wayaccountVO.setBankname(wayaccountVO.getBankname());
				} else if ("null".equals(items[29]) || "��".equals(items[29])) {
					throw new BusinessException("�������в����޸�Ϊ��!");
				} else
					wayaccountVO.setBankname(items[29]);
				if (items[30] == null || "".equals(items[30])) {
					wayaccountVO.setAcctname(wayaccountVO.getAcctname());
				} else if ("null".equals(items[30]) || "��".equals(items[30])) {
					throw new BusinessException("�����ʺ����Ʋ����޸�Ϊ��!");
				} else
					wayaccountVO.setAcctname(items[30]);
				if (items[31] == null || "".equals(items[31])) {
					wayaccountVO.setAcctfid(wayaccountVO.getAcctfid());
				} else if ("null".equals(items[31]) || "��".equals(items[31])) {
					wayaccountVO.setAcctfid(null);
				} else
					wayaccountVO.setAcctfid(items[31]);

				accdelegate.doUpdate(wayaccountVO, user);
			}

			BeanUtils.copyProperties(cooperatorvo, wayVO);
			BeanUtils.copyProperties(cooperatorvo, bchcontactVO);
			BeanUtils.copyProperties(cooperatorvo, waycompactVO);
			BeanUtils.copyProperties(cooperatorvo, wayaccountVO);

			cooperatorvo.setCooperauid(wayVO.getWayid());
			cooperatorvo1 = coopdelegate.doFindByPk(cooperatorvo
					.getCooperauid(), user);
			if (cooperatorvo1 == null) {
				cooperatorvo.setCooperaname(wayVO.getWayname());
				cooperatorvo.setCpabbrname(wayVO.getWayname());
				cooperatorvo.setCocheckname(wayVO.getShortname());
				cooperatorvo.setState(new Short("1"));
				cooperatorvo.setMemo(wayVO.getFunction());
				cooperatorvo.setOldcoopera(wayVO.getBusicode());
				cooperatorvo.setSmsmobileno(wayVO.getBuzphoneno());
				cooperatorvo.setServman(bchcontactVO.getPrincipal());
				cooperatorvo.setCooperadel(bchcontactVO.getPrincipal());
				cooperatorvo.setConntel(bchcontactVO.getPrincipaltel());
				cooperatorvo.setUsremail(bchcontactVO.getPrincipalemail());
				cooperatorvo.setConnpers(bchcontactVO.getLinkman());
				cooperatorvo.setBusconntel(bchcontactVO.getLinkmantel());
				cooperatorvo.setConnfaxno(bchcontactVO.getFax());
				cooperatorvo.setStarttime(waycompactVO.getBegintime());
				cooperatorvo.setLicenceid(waycompactVO.getLicenceno());
				cooperatorvo.setCustmanager(wayVO.getWaymagcode());
				cooperatorvo.setBaillwrlmt(new Double("0"));
				cooperatorvo.setDistrictid(SessionFactoryRouter
						.conversionCityid2Num(wayVO.getCityid()));
				cooperatorvo.setSendaddr(items[32]);
				cooperatorvo.setRecpers(items[33]);
				cooperatorvo.setRecconntel(items[34]);
				cooperatorvo.setReccertno(items[35]);
				cooperatorvo.setLicvalidate("".equals(items[36]) ? null
						: new java.sql.Date(format.parse(items[36]).getTime()));
				cooperatorvo.setIntime("".equals(items[38]) ? null
						: new java.sql.Date(format.parse(items[38]).getTime()));
				coopdelegate.doCreate1(cooperatorvo, user);
			} else {
				BeanUtils.copyProperties(cooperatorvo, cooperatorvo1);
				if (items[32] == null || "".equals(items[32])) {
					cooperatorvo.setSendaddr(cooperatorvo1.getSendaddr());
				} else if ("null".equals(items[32]) || "��".equals(items[32])) {
					cooperatorvo.setSendaddr(null);
				} else
					cooperatorvo.setSendaddr(items[32]);
				if (items[33] == null || "".equals(items[33])) {
					cooperatorvo.setRecpers(cooperatorvo1.getRecpers());
				} else if ("null".equals(items[33]) || "��".equals(items[33])) {
					cooperatorvo.setRecpers(null);
				} else
					cooperatorvo.setRecpers(items[33]);
				if (items[34] == null || "".equals(items[34])) {
					cooperatorvo.setRecconntel(cooperatorvo1.getRecconntel());
				} else if ("null".equals(items[34]) || "��".equals(items[34])) {
					cooperatorvo.setRecconntel(null);
				} else
					cooperatorvo.setRecconntel(items[34]);
				if (items[35] == null || "".equals(items[35])) {
					cooperatorvo.setReccertno(cooperatorvo1.getReccertno());
				} else if ("null".equals(items[35]) || "��".equals(items[35])) {
					cooperatorvo.setReccertno(null);
				} else
					cooperatorvo.setReccertno(items[35]);
				if (items[36] == null || "".equals(items[36])) {
					cooperatorvo.setLicvalidate(cooperatorvo1.getLicvalidate());
				} else if ("null".equals(items[36]) || "��".equals(items[36])) {
					cooperatorvo.setLicvalidate(null);
				} else
					cooperatorvo.setLicvalidate(new java.sql.Date(format.parse(
							items[36]).getTime()));
				if (items[38] == null || "".equals(items[38])) {
					cooperatorvo.setIntime(cooperatorvo1.getIntime());
				} else if ("null".equals(items[38]) || "��".equals(items[38])) {
					cooperatorvo.setIntime(null);
				} else
					cooperatorvo.setIntime(new java.sql.Date(format.parse(
							items[38]).getTime()));
				coopdelegate.doUpdate1(cooperatorvo, user);
			}

			// ����VO
			AuditUtils utils = new AuditUtils();
			String[] waypk = { "wayid" };
			String[] newwayfield = { "address" };
			String[] cooperaupk = { "cooperauid" };
			String[] cooperatorfield = { "sendaddr" };
			String[] wayaccountpk = { "accid", "wayid" };
			String[] wayaccountfield = { "acctno", "bankname" };

			wayVO = (WayVO) utils.doSaveAudit(wayVO, "CH_PW_WAY",
					"CH_PW_STRBWAY", newwayfield, waypk, "CH_PW_SOTYWAY_AUDIT",
					user);
			cooperatorvo = (CooperatorVO) utils.doSaveAudit(cooperatorvo,
					"CH_DST_COOPERATOR", "CH_PW_STRBWAY", cooperatorfield,
					cooperaupk, "CH_PW_SOTYWAY_AUDIT", user);
			wayaccountVO = (WayaccountVO) utils.doSaveAudit(wayaccountVO,
					"CH_PW_WAYACCOUNT", "CH_PW_STRBWAY", wayaccountfield,
					wayaccountpk, "CH_PW_SOTYWAY_AUDIT", user);

			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount));
			return resultVO;
		} catch (Exception ex) { // ����ʧ��
			msg = ex.getMessage();
			resultVO.setOk(false);
			ex.printStackTrace();
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
		resultStr.append(items[29]).append(COMPART);
		resultStr.append(items[30]).append(COMPART);
		resultStr.append(items[31]).append(COMPART);
		resultStr.append(items[32]).append(COMPART);
		resultStr.append(items[33]).append(COMPART);
		resultStr.append(items[34]).append(COMPART);
		resultStr.append(items[35]).append(COMPART);
		resultStr.append(items[36]).append(COMPART);
		resultStr.append(items[37]).append(COMPART);
		resultStr.append(items[38]).append(COMPART).append(items[39]).append(
				COMPART).append(items[40]).append(COMPART).append(items[41])
				.append(COMPART).append(items[42]).append(COMPART).append(
						items[43]).append(COMPART).append(items[44]).append(
						COMPART).append(items[45]).append(COMPART).append(
						items[46]).append(COMPART).append(items[47]).append(
						COMPART).append(items[48]).append(COMPART).append("����");
		resultStr.append(COMPART);
		// ������
		if (resultVO.isOk()) {
			resultStr.append("�ɹ�����ϸ��ַ,�ͻ���ַ,������,�ʺ�,��Ҫ��˳ɹ��������Ч��");
		} else {
			resultStr.append("ʧ��");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}

}
