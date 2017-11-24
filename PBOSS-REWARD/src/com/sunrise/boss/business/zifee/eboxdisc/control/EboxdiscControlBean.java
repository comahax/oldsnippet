/**
 * auto-generated code
 * Mon Sep 04 20:34:08 CST 2006
 */
package com.sunrise.boss.business.zifee.eboxdisc.control;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.business.fee.woff.eboxunit.persistent.EBoxUnitDAO;
import com.sunrise.boss.business.fee.woff.eboxunit.persistent.EBoxUnitListVO;
import com.sunrise.boss.business.fee.woff.eboxunit.persistent.EBoxUnitVO;
import com.sunrise.boss.business.zifee.eboxdisc.persistent.EboxdiscDAO;
import com.sunrise.boss.business.zifee.eboxdisc.persistent.EboxdiscListVO;
import com.sunrise.boss.business.zifee.eboxdisc.persistent.EboxdiscVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanDAO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanListVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.zifee.commons.ResultBean;

/**
 * <p>
 * Title: EboxdiscControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author eboxdisc
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/zifee/eboxdisc/control/EboxdiscControlBean"
 *           name="EboxdiscControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class EboxdiscControlBean extends AbstractControlBean implements
		EboxdiscControl {

	public EboxdiscVO doCreate(EboxdiscVO vo, User user) throws Exception {
		try {
			doCheckCreate(vo, user);
			EboxdiscDAO dao = (EboxdiscDAO) DAOFactory.build(EboxdiscDAO.class,
					user);
			vo.setEboxdiscid(getEboxdiscSeq(user));
			return (EboxdiscVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(EboxdiscVO vo, User user) throws Exception {
		try {
			EboxdiscDAO dao = (EboxdiscDAO) DAOFactory.build(EboxdiscDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public EboxdiscVO doUpdate(EboxdiscVO vo, User user) throws Exception {
		try {

			EBoxUnitDAO edao = (EBoxUnitDAO) DAOFactory.build(
					EBoxUnitDAO.class, user);
			EBoxUnitVO eboxunitVO = new EBoxUnitVO();
			EBoxUnitVO feesourceVO = new EBoxUnitVO();

			EboxdiscControl control = (EboxdiscControl) ControlFactory
					.build(EboxdiscControlBean.class);

			EboxdiscVO pkvo = new EboxdiscVO();
			pkvo.setYxplanid(vo.getYxplanid());
			pkvo.setEboxdiscid(vo.getEboxdiscid());

			EboxdiscVO vo2 = control.doFindByPk(pkvo, user);
			if (vo.getEboxunitid() != null
					&& !"".equals(vo.getEboxunitid().toString().trim())) {
				eboxunitVO = (EBoxUnitVO) edao.findByPk(vo.getEboxunitid());
			} else {
				vo2.setEboxunitid(null);
			}

			if (vo.getFeesourceid() != null
					&& !"".equals(vo.getFeesourceid().toString().trim())) {
				feesourceVO = (EBoxUnitVO) edao.findByPk(vo.getFeesourceid());
			} else {
				vo2.setFeesourceid(null);
			}
			if (vo != vo2 && vo != null && vo2 != null) {

				if (eboxunitVO != null && feesourceVO != null) {
					if (feesourceVO.getEboxunitstate() != null
							&& eboxunitVO.getEboxunitstate() != null) {
						int flag = 1;
						if (flag != feesourceVO.getEboxunitstate().intValue()
								&& flag != eboxunitVO.getEboxunitstate()
										.intValue()) {
							throw new BusinessException("",
									"����ʧ�ܣ������[�˱���Ŀ��ʶ]��[�۷���Ŀ��ʶ]�ѽ���");
						}
					}
				}

				if (vo.getEboxunitid() != null
						&& !vo.getEboxunitid().equals(vo2.getEboxunitid())) {
					if (eboxunitVO != null) {

						if (eboxunitVO.getEboxunitstate() != null) {
							int flag = 1;
							if (flag != eboxunitVO.getEboxunitstate()
									.intValue()) {
								throw new BusinessException("",
										"����ʧ�ܣ�[�˱���Ŀ��ʶ]�ѽ���");
							}
						}
					}
				}
				if (vo.getFeesourceid() != null
						&& !vo.getFeesourceid().equals(vo2.getFeesourceid())) {
					if (feesourceVO != null) {

						if (feesourceVO.getEboxunitstate() != null) {
							int flag = 1;
							if (flag != feesourceVO.getEboxunitstate()
									.intValue()) {
								throw new BusinessException("",
										"����ʧ�ܣ�[�۷���Ŀ��ʶ]�ѽ���");
							}
						}

					}

				}

			}
			EboxdiscDAO dao = (EboxdiscDAO) DAOFactory.build(EboxdiscDAO.class,
					user);
			BeanUtils.copyProperties(vo2, vo);
			EboxdiscVO eboxdiscvo = (EboxdiscVO) dao.update(vo2);

			return eboxdiscvo;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public EboxdiscVO doFindByPk(Serializable pk, User user) throws Exception {
		EboxdiscDAO dao = (EboxdiscDAO) DAOFactory.build(EboxdiscDAO.class,
				user);
		return (EboxdiscVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(EboxdiscListVO params, User user)
			throws Exception {
		EboxdiscDAO dao = (EboxdiscDAO) DAOFactory.build(EboxdiscDAO.class,
				user);
		return dao.query(params);
	}

	public DataPackage doBatchquery(EboxdiscListVO params, User user)
			throws Exception {
		EboxdiscDAO dao = (EboxdiscDAO) DAOFactory.build(EboxdiscDAO.class,
				user);
		return dao.queryByNamedSqlQuery("batchQuery", params);
	}

	public Long getEboxdiscSeq(User user) throws Exception {
		EboxdiscDAO dao = (EboxdiscDAO) DAOFactory.build(EboxdiscDAO.class,
				user);

		return (Long) dao.getSequence("PC_PS_EBOXDISC_SEQ");
	}

	/**
	 * �����ַ�������EboxdiscVO
	 * 
	 * @param fields
	 * @param user
	 * @return
	 * @throws Exception
	 *             Ӫ��������ʶ0|�����˱���Ŀ1|������Ӫ��������ʶ2|�ʻ�Ԥ���Ż���Ч����3|��ʼ��Чʱ��4|��Чʱ����5|
	 *             �Ƿ�˳��6|֧������7|���/����8|�Ƿ������Ŀ��ϸ9|�ʻ�Ԥ���Ż�����10|�ʻ�Ԥ���Żݽ�ת����11|
	 *             ��ʼƫ������12|����ƫ������13|�Żݽ�������14|�Ƿ�����15|���ͷ�ʽ16|�����Żݱ�ʶ17|
	 *             �������Ա���18|�۷���Դ����19|�۷���Ŀ��ʶ20|֧�����21|˵��22|
	 */
	public EboxdiscVO buildVO(String[] fields, User user, String oprtype)
			throws Exception {
		EboxdiscVO result = null;
		try {
			result = new EboxdiscVO();
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			// ����
			if ("0".equals(oprtype)) {
				result.setYxplanid(new Long(fields[0]));// Ӫ��������ʶ
				if (fields[1].trim().length() > 0)
					result.setEboxunitid(new Long(fields[1]));// �����˱���Ŀ
				if (fields[2].trim().length() > 0)
					result.setInplanid(new Long(fields[2]));// ������Ӫ��������ʶ
				if (fields[3].trim().length() > 0)
					result.setEffectivetype(fields[3]);// �ʻ�Ԥ���Ż���Ч����
				if (fields[4].trim().length() > 0)
					result.setEffectivedate(format.parse(fields[4]));// ��ʼ��Чʱ��
				if (fields[5].trim().length() > 0)
					result.setEffectiveinterval(new Integer(fields[5]));// ��Чʱ����
				if (fields[6].trim().length() > 0)
					result.setIspostpone(new Byte(fields[6]));// �Ƿ�˳��
				if (fields[7].trim().length() > 0)
					result.setPaytimes(new Integer(fields[7]));// ֧������
				if (fields[8].trim().length() > 0)
					result.setAmount(new Long(fields[8]));// ���/����
				if (fields[9].trim().length() > 0)
					result.setEnterunitdetflag(new Byte(fields[9]));// �Ƿ������Ŀ��ϸ
				if (fields[10].trim().length() > 0)
					result.setDisctype(fields[10]);// �ʻ�Ԥ���Ż�����
				if (fields[11].trim().length() > 0)
					result.setRollovertype(fields[11]);// �ʻ�Ԥ���Żݽ�ת����
				if (fields[12].trim().length() > 0)
					result.setEffectivecycles(new Integer(fields[12]));// ��ʼƫ������
				if (fields[13].trim().length() > 0)
					result.setExpiredcycles(new Integer(fields[13]));// ����ƫ������
				if (fields[14].trim().length() > 0)
					result.setExpireddate(format.parse(fields[14]));// �Żݽ�������
				if (fields[15].trim().length() > 0)
					result.setIspresent(new Byte(fields[15]));// �Ƿ�����
				if (fields[16].trim().length() > 0)
					result.setPresenttype(fields[16]);// ���ͷ�ʽ
				if (fields[17].trim().length() > 0)
					result.setReladiscid(new Long(fields[17]));// �����Żݱ�ʶ
				if (fields[18].trim().length() > 0)
					result.setAffixid(fields[18]);// �������Ա���
				if (fields[19].trim().length() > 0)
					result.setFeesourcetype(fields[19]);// �۷���Դ����
				if (fields[20].trim().length() > 0)
					result.setFeesourceid(new Long(fields[20]));// �۷���Ŀ��ʶ
				if (fields[21].trim().length() > 0)
					result.setRemark(fields[21]);// ˵��
				if (fields[22].trim().length() > 0)
					result.setPayinterval(new Integer(fields[22]));// ֧�����
				if (fields[23].trim().length() > 0)
					result.setValidity(new Integer(fields[23]));// ��Ч������
				if (fields[24].trim().length() > 0)
					result.setPesenteboxunitid(new Long(fields[24]));// �����Ż��˱���Ŀ��ʶ
			}
			// �޸�
			if ("1".equals(oprtype)) {
				result.setEboxdiscid(new Long(fields[0]));// �ʻ�Ԥ���Żݱ�ʶ
				result.setYxplanid(new Long(fields[1]));// Ӫ��������ʶ
				if (fields[2].trim().length() > 0)
					result.setEboxunitid(new Long(fields[2]));// �����˱���Ŀ
				if (fields[3].trim().length() > 0)
					result.setInplanid(new Long(fields[3]));// ������Ӫ��������ʶ
				if (fields[4].trim().length() > 0)
					result.setEffectivetype(fields[4]);// �ʻ�Ԥ���Ż���Ч����
				if (fields[5].trim().length() > 0)
					result.setEffectivedate(format.parse(fields[5]));// ��ʼ��Чʱ��
				if (fields[6].trim().length() > 0)
					result.setEffectiveinterval(new Integer(fields[6]));// ��Чʱ����
				if (fields[7].trim().length() > 0)
					result.setIspostpone(new Byte(fields[7]));// �Ƿ�˳��
				if (fields[8].trim().length() > 0)
					result.setPaytimes(new Integer(fields[8]));// ֧������
				if (fields[9].trim().length() > 0)
					result.setAmount(new Long(fields[9]));// ���/����
				if (fields[10].trim().length() > 0)
					result.setEnterunitdetflag(new Byte(fields[10]));// �Ƿ������Ŀ��ϸ
				if (fields[11].trim().length() > 0)
					result.setDisctype(fields[11]);// �ʻ�Ԥ���Ż�����
				if (fields[12].trim().length() > 0)
					result.setRollovertype(fields[12]);// �ʻ�Ԥ���Żݽ�ת����
				if (fields[13].trim().length() > 0)
					result.setEffectivecycles(new Integer(fields[13]));// ��ʼƫ������
				if (fields[14].trim().length() > 0)
					result.setExpiredcycles(new Integer(fields[14]));// ����ƫ������
				if (fields[15].trim().length() > 0)
					result.setExpireddate(format.parse(fields[15]));// �Żݽ�������
				if (fields[16].trim().length() > 0)
					result.setIspresent(new Byte(fields[16]));// �Ƿ�����
				if (fields[17].trim().length() > 0)
					result.setPresenttype(fields[17]);// ���ͷ�ʽ
				if (fields[18].trim().length() > 0)
					result.setReladiscid(new Long(fields[18]));// �����Żݱ�ʶ
				if (fields[19].trim().length() > 0)
					result.setAffixid(fields[19]);// �������Ա���
				if (fields[20].trim().length() > 0)
					result.setFeesourcetype(fields[20]);// �۷���Դ����
				if (fields[21].trim().length() > 0)
					result.setFeesourceid(new Long(fields[21]));// �۷���Ŀ��ʶ
				if (fields[22].trim().length() > 0)
					result.setRemark(fields[22]);// ˵��
				if (fields[23].trim().length() > 0)
					result.setPayinterval(new Integer(fields[23]));// ֧�����
				if (fields[24].trim().length() > 0)
					result.setValidity(new Integer(fields[24]));// ��Ч������
				if (fields[25].trim().length() > 0)
					result.setPesenteboxunitid(new Long(fields[25]));// �����Ż��˱���Ŀ��ʶ
			}

			return result;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * �������ļ��ĺϷ���(������ʽƥ��)
	 * 
	 * @param fields
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ResultBean doCheck(String[] fields, User user, String oprtype)
			throws Exception {

		EBoxUnitDAO ebdao = (EBoxUnitDAO) DAOFactory.build(EBoxUnitDAO.class,
				user);

		ResultBean result = new ResultBean();
		result.setCode(0);
		result.setInfo("");
		
		if ("0".equals(oprtype)) {// ����

			YxPlanDAO yxdao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class,
					user);

			if (fields.length != 25) {
				result.setCode(88);
				result.setInfo("�����ļ���ʽ�ֶ������ԣ���ȷΪ25��");
				return result;
			}
			checkYxplanID(fields[0],user);
			// ҵ���飬�������Ҫ�ģ�ȫ������
			// �ʻ�Ԥ���Ż���Ч����="FIX_DATE"(ָ��������),��Чʱ������Ч
			// �ʻ�Ԥ���Ż���Ч����="AFTER_MONS_1ST"(ָ��������),��ʼ��Чʱ��
			if (fields[3].equals("FIX_DATE")) {
				fields[5] = "";
			} else if (fields[3].equals("AFTER_MONS_1ST")) {
				fields[4] = "";
			}

			// �Ƿ�����Ϊ0�����ͷ�ʽ�������Żݱ�ʶ��������
			// Ϊ1�Ļ����������Ա��벻���ã�������ͷ�ʽΪ������ô�����Żݱ�ʶ������
			if (fields[15].equals("0")) {
				fields[16] = "";
				fields[17] = "";
			} else if (fields[15].equals("1")) {
				fields[18] = "";
				if (fields[16].equals("PresentAmount")) {
					fields[17] = "";
				}
			}

			// �۷���Դ����Ϊ�ֽ�ʱ���۷���Ŀ��ʶ������
			if (fields[19].equals("FeeSrcCash")) {
				fields[20] = "";
			}

			// ���ֶ���һ���м��
			for (int i = 0; i < fields.length; i++) {

				// ֻҪ��鵽һ���������������ټ��
				if (result.getCode() != 0)
					break;

				switch (i) {

				// Ӫ��������ʶ0
				case 0:
					if (!fields[i].matches("[0-9]{14}")) {
						result.setCode(77);
						result.setInfo("[Ӫ��������ʶ]��������Ϊ14λ����");
					}
					if (result.getCode() == 0 && !fields[i].trim().equals("")) {
						YxPlanListVO listvo = new YxPlanListVO();
						listvo.set_ne_yxplanid(fields[i]);
						if (yxdao.count(listvo) == 0) {
							result.setCode(78);
							result.setInfo("[Ӫ��������ʶ]" + fields[i] + "������!");
						}

					}
					;
					break;

				// �����˱���Ŀ1
				case 1:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[�����˱���Ŀ]���Ͳ�����Ҫ��Ӧ��Ϊ����");
					}
					if (result.getCode() == 0 && !fields[i].trim().equals("")) {
						EBoxUnitListVO listvo = new EBoxUnitListVO();
						listvo.set_ne_eboxunitid(fields[i]);
						if (ebdao.count(listvo) == 0) {
							result.setCode(78);
							result.setInfo("[�����˱���Ŀ]" + fields[i] + "������!");
						}
					}
					;
					break;

				// ������Ӫ��������ʶ2
				case 2:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[������Ӫ��������ʶ]���Ͳ�����Ҫ��Ӧ��Ϊ����");
					}
					;
					break;

				// �ʻ�Ԥ���Ż���Ч����3
				case 3:
					if (fields[i].length() > 32) {
						result.setCode(77);
						result.setInfo("[�ʻ�Ԥ���Ż���Ч����]���Ȳ���,��ΧӦ����(0~32)");
					}
					;
					break;

				// ��ʼ��Чʱ��4
				case 4:
					if (!fields[i].trim().equals("")) {
						try {
							SimpleDateFormat format = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss");
							format.parse(fields[i]);
						} catch (Exception e) {
							result.setCode(77);
							result
									.setInfo("[��ʼ��Чʱ��]��ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd HH:mm:ss]");
						}
					}
					;
					break;

				// ��Чʱ����5
				case 5:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[��Чʱ����]���Ͳ�����Ҫ��Ӧ��������");
					}
					;
					break;

				// �Ƿ�˳��6
				case 6:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-1]+")) {
						result.setCode(77);
						result.setInfo("[�Ƿ�˳��]��ʽ����,ֻ��Ϊ����0��1");
					}
					;
					break;

				// ֧������7
				case 7:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[֧������]��ʽ����,Ӧ��Ϊ������");
					}
					;
					break;

				// ���/����8
				case 8:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[���/����]��ʽ����,Ӧ��Ϊ������");
					}
					;
					break;

				// �Ƿ������Ŀ��ϸ9
				case 9:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-1]")) {
						result.setCode(77);
						result.setInfo("[�Ƿ������Ŀ��ϸ]��ʽ����,ֻ��Ϊ����0��1");
					}
					;
					break;

				// �ʻ�Ԥ���Ż�����10
				case 10:
					if (fields[i].length() > 32) {
						result.setCode(77);
						result.setInfo("[�ʻ�Ԥ���Ż�����]���Ȳ���,��ΧӦ����0~32");
					}
					;
					break;

				// �ʻ�Ԥ���Żݽ�ת����11
				case 11:
					if (fields[i].length() > 32) {
						result.setCode(77);
						result.setInfo("[�ʻ�Ԥ���Żݽ�ת����]���Ȳ���,��ΧӦ����0~32");
					}
					;
					break;

				// ��ʼƫ������12
				case 12:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[��ʼƫ������]��ʽ����,Ӧ��Ϊ������");
					}
					;
					break;

				// ����ƫ������13
				case 13:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[����ƫ������]��ʽ����,Ӧ��Ϊ������");
					}
					;
					break;

				// �Żݽ�������14
				case 14:
					if (!fields[i].trim().equals("")) {
						try {
							SimpleDateFormat format = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss");
							format.parse(fields[i]);
						} catch (Exception e) {
							result.setCode(77);
							result
									.setInfo("[�Żݽ�������]��ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd HH:mm:ss]");
						}
					}
					;
					break;

				// �Ƿ�����15
				case 15:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-1]")) {
						result.setCode(77);
						result.setInfo("[�Ƿ�����]��ʽ����,ֻ��Ϊ����0��1");
					}
					;
					break;

				// ���ͷ�ʽ16
				case 16:
					if (fields[i].length() > 16) {
						result.setCode(77);
						result.setInfo("[���ͷ�ʽ]���Ȳ���,��ΧӦ����0~16");
					}
					;
					break;

				// �����Żݱ�ʶ17
				case 17:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[�����Żݱ�ʶ]��ʽ����,Ӧ��Ϊ������");
					}
					;
					break;

				// �������Ա���18
				case 18:
					if (fields[i].length() > 16) {
						result.setCode(77);
						result.setInfo("[�������Ա���]���Ȳ���,��ΧӦ����0~16");
					}
					;
					break;

				// �۷���Դ����19
				case 19:
					if (fields[i].length() > 16) {
						result.setCode(77);
						result.setInfo("[�۷���Դ����]���Ȳ���,��ΧӦ����0~16");
					}
					;
					break;

				// �۷���Ŀ��ʶ20
				case 20:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[�۷���Ŀ��ʶ]��ʽ����,Ӧ��Ϊ������");
					}
					;
					break;

				// ˵��21
				case 21:
					if (fields[i].length() > 255) {
						result.setCode(77);
						result.setInfo("[�۷���Դ����]���Ȳ���,��ΧӦ����0~255");
					}
					;
					break;
				// ֧�����22
				case 22:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[֧�����]��ʽ����,Ӧ��Ϊ������");
					}
					;
					break;

				// ��Ч������23
				case 23:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[��Ч������]��ʽ����,Ӧ��Ϊ������");
					}
					;
					break;
				
				case 24:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[�����Ż��˱���Ŀ��ʶ]��ʽ����,Ӧ��Ϊ������");
					}
					;
					break;
				}
			}

			int payinterval = 0;
			int paytimes = 0;
			int cycles = 0;
			int pro = 0;
			try {
				payinterval = "".equals(fields[22].trim()) ? 0 : new Integer(
						fields[22]).intValue();
				paytimes = "".equals(fields[7].trim()) ? 0 : new Integer(
						fields[7]).intValue();
				cycles = "".equals(fields[13].trim()) ? 0 : new Integer(
						fields[13]).intValue();
				pro = payinterval * paytimes;
			} catch (Exception e) {
				result.setCode(77);
				result.setInfo("�ַ���ת��Ϊ���������ͱ���");
				return result;
			}
			// �ʻ�Ԥ���Żݽ�ת����11
			if (!"1".equals(fields[11].trim())
					&& !"0".equals(fields[11].trim())) {
				result.setCode(77);
				result.setInfo("[�ʻ�Ԥ���Żݽ�ת����]��ʽ����,ֻ��Ϊ����0��1");
				return result;
			}
			if (fields[11].trim().equals("0") && cycles >= 1) {
				// ok
			} else {
				if (fields[11].trim().equals("1")) {
					if (cycles == -1 || cycles >= pro) {
						// ok
					} else {
						result.setCode(77);
						result
								.setInfo("�ʻ�Ԥ���Żݽ�ת����ֱ������ʱ,����ƫ�����ڱ���Ϊ-1���ߴ��ڵ���֧������*֧�����");
						return result;
					}
				} else {
					result.setCode(77);
					result.setInfo("�ʻ�Ԥ���Żݽ�ת����Ϊƽ���ı���ʱ,����ƫ�����ڱ�����ڵ���1");
					return result;
				}
			}

		} else if ("1".equals(oprtype)) {// �޸�
			EboxdiscDAO dao = (EboxdiscDAO) DAOFactory.build(EboxdiscDAO.class,
					user);// ���ڲ�ѯ�ü�¼�Ƿ����

			if (fields.length != 26) {
				result.setCode(88);
				result.setInfo("�����ļ���ʽ�ֶ������ԣ���ȷΪ26��");
				return result;
			}
			checkYxplanID(fields[1],user);
			// ���������д����Լ��
			if (!fields[0].trim().equals("") && !fields[1].trim().equals("")) {
				if(!CheckUtil.checkNum(fields[0]))
				{
					throw new Exception("[�ʻ�Ԥ���Żݱ�ʶ]����Ϊ����");
				}
				EboxdiscListVO listvo = new EboxdiscListVO();
				listvo.set_ne_eboxdiscid(fields[0]);
				listvo.set_ne_yxplanid(fields[1]);
				if (dao.count(listvo) == 0) {
					result.setCode(100);
					result.setInfo("�޸�ʧ�ܣ�ϵͳ������Ӫ��������ʶ" + fields[1]
							+ "�µ��ʻ�Ԥ���Żݱ�ʶΪ" + fields[0] + "�ļ�¼");
				}
			}

			// ҵ���飬�������Ҫ�ģ�ȫ������
			// �ʻ�Ԥ���Ż���Ч����="FIX_DATE"(ָ��������),��Чʱ������Ч
			// �ʻ�Ԥ���Ż���Ч����="AFTER_MONS_1ST"(ָ��������),��ʼ��Чʱ��
			if (fields[4].equals("FIX_DATE")) {
				fields[6] = "";
			} else if (fields[4].equals("AFTER_MONS_1ST")) {
				fields[5] = "";
			}

			// �Ƿ�����Ϊ0�����ͷ�ʽ�������Żݱ�ʶ��������
			// Ϊ1�Ļ����������Ա��벻���ã�������ͷ�ʽΪ������ô�����Żݱ�ʶ������
			if (fields[16].equals("0")) {
				fields[17] = "";
				fields[18] = "";
			} else if (fields[16].equals("1")) {
				fields[19] = "";
				if (fields[17].equals("PresentAmount")) {
					fields[18] = "";
				}
			}

			// �۷���Դ����Ϊ�ֽ�ʱ���۷���Ŀ��ʶ������
			if (fields[20].equals("FeeSrcCash")) {
				fields[21] = "";
			}

			// ���ֶ���һ���м��
			for (int i = 2; i < fields.length; i++) {

				// ֻҪ��鵽һ���������������ټ��
				if (result.getCode() != 0)
					break;

				switch (i) {
				// �����˱���Ŀ2
				case 2:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[�����˱���Ŀ]���Ͳ�����Ҫ��Ӧ��Ϊ����");
					}
					if (result.getCode() == 0 && !fields[i].trim().equals("")) {
						EBoxUnitListVO listvo = new EBoxUnitListVO();
						listvo.set_ne_eboxunitid(fields[i]);
						if (ebdao.count(listvo) == 0) {
							result.setCode(78);
							result.setInfo("[�����˱���Ŀ]" + fields[i] + "������!");
						}
					}
					;
					break;

				// ������Ӫ��������ʶ3
				case 3:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[������Ӫ��������ʶ]���Ͳ�����Ҫ��Ӧ��Ϊ����");
					}
					;
					break;

				// �ʻ�Ԥ���Ż���Ч����4
				case 4:
					if (fields[i].length() > 32) {
						result.setCode(77);
						result.setInfo("[�ʻ�Ԥ���Ż���Ч����]���Ȳ���,��ΧӦ����(0~32)");
					}
					;
					break;

				// ��ʼ��Чʱ��5
				case 5:
					if (!fields[i].trim().equals("")) {
						try {
							SimpleDateFormat format = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss");
							format.parse(fields[i]);
						} catch (Exception e) {
							result.setCode(77);
							result
									.setInfo("[��ʼ��Чʱ��]��ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd HH:mm:ss]");
						}
					}
					;
					break;

				// ��Чʱ����6
				case 6:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[��Чʱ����]���Ͳ�����Ҫ��Ӧ��������");
					}
					;
					break;

				// �Ƿ�˳��7
				case 7:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-1]+")) {
						result.setCode(77);
						result.setInfo("[�Ƿ�˳��]��ʽ����,ֻ��Ϊ����0��1");
					}
					;
					break;

				// ֧������8
				case 8:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[֧������]��ʽ����,Ӧ��Ϊ������");
					}
					;
					break;

				// ���/����9
				case 9:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[���/����]��ʽ����,Ӧ��Ϊ������");
					}
					;
					break;

				// �Ƿ������Ŀ��ϸ10
				case 10:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-1]")) {
						result.setCode(77);
						result.setInfo("[�Ƿ������Ŀ��ϸ]��ʽ����,ֻ��Ϊ����0��1");
					}
					;
					break;

				// �ʻ�Ԥ���Ż�����11
				case 11:
					if (fields[i].length() > 32) {
						result.setCode(77);
						result.setInfo("[�ʻ�Ԥ���Ż�����]���Ȳ���,��ΧӦ����0~32");
					}
					;
					break;

				// �ʻ�Ԥ���Żݽ�ת����12
				case 12:
					if (fields[i].length() > 32) {
						result.setCode(77);
						result.setInfo("[�ʻ�Ԥ���Żݽ�ת����]���Ȳ���,��ΧӦ����0~32");
					}
					;
					break;

				// ��ʼƫ������13
				case 13:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[��ʼƫ������]��ʽ����,Ӧ��Ϊ������");
					}
					;
					break;

				// ����ƫ������14
				case 14:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[����ƫ������]��ʽ����,Ӧ��Ϊ������");
					}
					;
					break;

				// �Żݽ�������15
				case 15:
					if (!fields[i].trim().equals("")) {
						try {
							SimpleDateFormat format = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss");
							format.parse(fields[i]);
						} catch (Exception e) {
							result.setCode(77);
							result
									.setInfo("[�Żݽ�������]��ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd HH:mm:ss]");
						}
					}
					;
					break;

				// �Ƿ�����16
				case 16:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-1]")) {
						result.setCode(77);
						result.setInfo("[�Ƿ�����]��ʽ����,ֻ��Ϊ����0��1");
					}
					;
					break;

				// ���ͷ�ʽ17
				case 17:
					if (fields[i].length() > 16) {
						result.setCode(77);
						result.setInfo("[���ͷ�ʽ]���Ȳ���,��ΧӦ����0~16");
					}
					;
					break;

				// �����Żݱ�ʶ18
				case 18:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[�����Żݱ�ʶ]��ʽ����,Ӧ��Ϊ������");
					}
					;
					break;

				// �������Ա���19
				case 19:
					if (fields[i].length() > 16) {
						result.setCode(77);
						result.setInfo("[�������Ա���]���Ȳ���,��ΧӦ����0~16");
					}
					;
					break;

				// �۷���Դ����20
				case 20:
					if (fields[i].length() > 16) {
						result.setCode(77);
						result.setInfo("[�۷���Դ����]���Ȳ���,��ΧӦ����0~16");
					}
					;
					break;

				// �۷���Ŀ��ʶ21
				case 21:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[�۷���Ŀ��ʶ]��ʽ����,Ӧ��Ϊ������");
					}
					;
					break;

				// ˵��22
				case 22:
					if (fields[i].length() > 255) {
						result.setCode(77);
						result.setInfo("[�۷���Դ����]���Ȳ���,��ΧӦ����0~255");
					}
					;
					break;
				// ֧�����23
				case 23:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[֧�����]��ʽ����,Ӧ��Ϊ������");
					}
					;
					break;
				// ��Ч������24
				case 24:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[��Ч������]��ʽ����,Ӧ��Ϊ������");
					}
					;
					break;
				case 25:
					if (!fields[i].trim().equals("")
							&& !fields[i].matches("[0-9\\-]+")) {
						result.setCode(77);
						result.setInfo("[�����Ż��˱���Ŀ��ʶ]��ʽ����,Ӧ��Ϊ������");
					}
					;
					break;
				}
			}

			int payinterval = 0;
			int paytimes = 0;
			int cycles = 0;
			int pro = 0;
			try {
				payinterval = "".equals(fields[23].trim()) ? 0 : new Integer(
						fields[23]).intValue();
				paytimes = "".equals(fields[8].trim()) ? 0 : new Integer(
						fields[8]).intValue();
				cycles = "".equals(fields[14].trim()) ? 0 : new Integer(
						fields[14]).intValue();
				pro = payinterval * paytimes;
			} catch (Exception e) {
				result.setCode(77);
				result.setInfo("�ַ���ת��Ϊ���������ͱ���");
				return result;
			}
			// �ʻ�Ԥ���Żݽ�ת����12
			if (!"1".equals(fields[12].trim())
					&& !"0".equals(fields[12].trim())) {
				result.setCode(77);
				result.setInfo("[�ʻ�Ԥ���Żݽ�ת����]��ʽ����,ֻ��Ϊ����0��1");
				return result;
			}
			if (fields[12].trim().equals("0") && cycles >= 1) {
				// ok
			} else {
				if (fields[12].trim().equals("1")) {
					if (cycles == -1 || cycles >= pro) {
						// ok
					} else {
						result.setCode(77);
						result
								.setInfo("�ʻ�Ԥ���Żݽ�ת����ֱ������ʱ,����ƫ�����ڱ���Ϊ-1���ߴ��ڵ���֧������*֧�����");
						return result;
					}
				} else {
					result.setCode(77);
					result.setInfo("�ʻ�Ԥ���Żݽ�ת����Ϊƽ���ı���ʱ,����ƫ�����ڱ�����ڵ���1");
					return result;
				}
			}

		} else {
			result.setCode(100);
			result.setInfo("��ѡ����ȷ�Ĳ�������(����/�޸�/ɾ��)!");
		}

		return result;
	}

	/**
	 * �������˱���Ŀ��ʶ���͡��۷���Ŀ��ʶ���߼����
	 * 
	 * @param vo
	 * @param user
	 */
	private void doCheckCreate(EboxdiscVO vo, User user) throws Exception {// ���

		// ��� [�˱���Ŀ��ʶ]&[�۷���Ŀ��ʶ]״̬�Ƿ�Ϊ����[1]
		EBoxUnitDAO eboxUnitDAO = (EBoxUnitDAO) DAOFactory.build(
				EBoxUnitDAO.class, user);
		EBoxUnitVO eboxUnitidVO = new EBoxUnitVO();
		EBoxUnitVO FeesourceidVO = new EBoxUnitVO();
		if (vo.getEboxunitid() != null) {
			eboxUnitidVO = (EBoxUnitVO) eboxUnitDAO
					.findByPk(vo.getEboxunitid());
		}
		if (vo.getFeesourceid() != null) {
			FeesourceidVO = (EBoxUnitVO) eboxUnitDAO.findByPk(vo
					.getFeesourceid());
		}

		if (eboxUnitidVO != null && FeesourceidVO != null)

			if (FeesourceidVO.getEboxunitstate() != null
					&& eboxUnitidVO.getEboxunitstate() != null) {
				int flag = 1;
				if (flag != FeesourceidVO.getEboxunitstate().intValue()
						&& flag != eboxUnitidVO.getEboxunitstate().intValue()) {
					throw new BusinessException("",
							"����ʧ�ܣ������[�˱���Ŀ��ʶ]��[�۷���Ŀ��ʶ]�ѽ���");
				}
			}
		if (eboxUnitidVO != null)

			if (eboxUnitidVO.getEboxunitstate() != null) {
				int flag = 1;
				if (flag != eboxUnitidVO.getEboxunitstate().intValue()) {
					throw new BusinessException("", "����ʧ�ܣ�[�˱���Ŀ��ʶ]�ѽ���");
				}
			}
		if (FeesourceidVO != null)

			if (FeesourceidVO.getEboxunitstate() != null) {
				int flag = 1;
				if (flag != FeesourceidVO.getEboxunitstate().intValue()) {
					throw new BusinessException("", "����ʧ�ܣ�[�۷���Ŀ��ʶ]�ѽ���");
				}
			}
	}
	private void checkYxplanID(String yxplanid,User user) throws Exception
	{
		if(!CheckUtil.checkNum(yxplanid,14))
		{
			throw new Exception("Ӫ��������ʶΪ������14λ���ȵ����ֲ��Ҳ���Ϊ��:"+yxplanid);
		}
		String areacode=new YxPlanDelegate().getAreacode(new Long(StringUtils.trim(yxplanid)), user);
		if(areacode==null)
		{
			throw new Exception("Ӫ��������ʶ�������в�����!"+yxplanid);
		}
		if(user.isProvinceUser())
		{
			if(!"999".equals(areacode) && !"100".equals(areacode))
			{
				throw new Exception("ʡ������ֻ�ܲ���ʡ��Ӫ������! ������Ϣ:"+yxplanid);
			}
		}else 
		{
			if(!areacode.equals(user.getCityid()))
			{
				throw new Exception("�õ�¼�û�ֻ�ܲ���������Ӫ������! ������Ϣ:"+yxplanid);
			}
		}
	}

}
