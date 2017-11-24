package com.sunrise.boss.business.zifee.yxplan.control;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemDAO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.zifee.eboxdisc.persistent.EboxdiscDAO;
import com.sunrise.boss.business.zifee.eboxdisc.persistent.EboxdiscListVO;
import com.sunrise.boss.business.zifee.eboxdisc.persistent.EboxdiscVO;
import com.sunrise.boss.business.zifee.feedisc.persistent.FeediscDAO;
import com.sunrise.boss.business.zifee.feedisc.persistent.FeediscListVO;
import com.sunrise.boss.business.zifee.feedisc.persistent.FeediscVO;
import com.sunrise.boss.business.zifee.feediscmonth.persistent.FeediscmonthDAO;
import com.sunrise.boss.business.zifee.feediscmonth.persistent.FeediscmonthListVO;
import com.sunrise.boss.business.zifee.feediscmonth.persistent.FeediscmonthVO;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeediscDAO;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeediscListVO;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeediscVO;
import com.sunrise.boss.business.zifee.minconsume.persistent.MinconsumeDAO;
import com.sunrise.boss.business.zifee.minconsume.persistent.MinconsumeListVO;
import com.sunrise.boss.business.zifee.minconsume.persistent.MinconsumeVO;
import com.sunrise.boss.business.zifee.plandisccode.persistent.PlandisccodeDAO;
import com.sunrise.boss.business.zifee.plandisccode.persistent.PlandisccodeListVO;
import com.sunrise.boss.business.zifee.plandisccode.persistent.PlandisccodeVO;
import com.sunrise.boss.business.zifee.prodservset.persistent.ProdservsetDAO;
import com.sunrise.boss.business.zifee.prodservset.persistent.ProdservsetVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanDAO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanListVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;
import com.sunrise.boss.business.zifee.yxplancplog.persistent.YxplancplogDAO;
import com.sunrise.boss.business.zifee.yxplancplog.persistent.YxplancplogVO;
import com.sunrise.boss.business.zifee.yxplanpresnt.persistent.YxplanpresntDAO;
import com.sunrise.boss.business.zifee.yxplanpresnt.persistent.YxplanpresntListVO;
import com.sunrise.boss.business.zifee.yxplanpresnt.persistent.YxplanpresntVO;
import com.sunrise.boss.business.zifee.yxplansplitscale.persistent.YxPlanSplitScaleDAO;
import com.sunrise.boss.business.zifee.yxplansplitscale.persistent.YxPlanSplitScaleListVO;
import com.sunrise.boss.business.zifee.yxplansplitscale.persistent.YxPlanSplitScaleVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.integration.IntegrationBean;
import com.sunrise.boss.ui.zifee.commons.ResultBean;

/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/zifee/yxplan/control/YxPlanControlBean"
 *           name="YxPlanControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class YxPlanControlBean extends AbstractControlBean implements
		YxPlanControl {

	public YxPlanVO doCreate(YxPlanVO vo, User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			YxPlanDAO dao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class, user);
			// vo.setStartdate(new java.sql.Date(2006,4,1));
			// vo.setStopdate(new java.sql.Date(2006,5,1));
			// vo.setYxplanid(Long.valueOf(1));
			// vo.setYxplanname("weww");
			if (vo.getSpecialflag() == null || "".equals(vo.getSpecialflag())) {
				vo.setSpecialflag("0");
			}
			if (vo.getYxplanshortname() == null
					|| "".equals(vo.getYxplanshortname().trim())) {
				if (vo.getYxplanname() == null || "".equals(vo.getYxplanname())) {
					throw new Exception("����ʱӪ���������Ʋ���Ϊ��");
				}
				vo.setYxplanshortname(vo.getYxplanname());
			}
			return (YxPlanVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(YxPlanVO vo, User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			YxPlanDAO dao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public YxPlanVO doUpdate(YxPlanVO vo, User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			if (vo.getYxplanshortname() == null
					|| "".equals(vo.getYxplanshortname().trim())) {
				if (vo.getYxplanname() != null
						&& !"".equals(vo.getYxplanname())) {
					vo.setYxplanshortname(vo.getYxplanname());
				}
			}
			YxPlanDAO dao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class, user);
			return (YxPlanVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public YxPlanVO doFindByPk(Serializable pk, User user) throws Exception {
		// TODO Auto-generated method stub
		YxPlanDAO dao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class, user);
		dao.setDbFlag("DB_COMMON", false);
		//dao.setDbFlag("DB_BOSSCOMMON", false);
		return (YxPlanVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(YxPlanListVO params, User user) throws Exception {
		// TODO Auto-generated method stub
		YxPlanDAO dao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class, user);
		//dao.setDbFlag("DB_BOSSCOMMON", false);
		dao.setDbFlag("DB_COMMON", false);
		return dao.query(params);
	}

	public Long getYxplanSeq(User user) throws Exception {
		YxPlanDAO dao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class, user);
		return (Long) dao.getSequence("PC_PS_YXPlAN_SEQ");// ֱ�ӵ�oracle����ȡseq��ֵ
	}

	/**
	 * ��������Ӫ������
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public YxPlanVO doBatchCreate(YxPlanVO vo, User user) throws Exception {
		YxPlanDAO dao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class, user);
		YxPlanVO yxplanvo = (YxPlanVO) dao.findByPk(vo.getYxplanid());
		if (yxplanvo != null) {
			throw new BusinessException("", "�����ļ�¼�Ѿ������ݿ���");
		}
		if (StringUtils.isEmpty(vo.getAreacode())) {
			throw new Exception("Ҫ������Ӫ�����������ʶΪ��");
		}
		if (user.isProvinceUser()) {
			DictitemDAO dictitemdao = (DictitemDAO) DAOFactory.build(
					DictitemDAO.class, user);
			DictitemListVO dictitemlist = new DictitemListVO();
			dictitemlist.set_se_groupid("PC_YXPLANAREACODE");
			dictitemlist.set_se_dictid(vo.getAreacode());
			if (dictitemdao.query(dictitemlist).getRowCount() == 0) {
				throw new BusinessException("", "�����ʶ" + vo.getAreacode()
						+ "������!");
			}
			if (!"100".equals(vo.getYxplanid().toString().substring(0, 3))) {
				throw new Exception("ȫʡ����ֻ��¼��ǰ��λΪ100��Ӫ������ID.");
			}
			if (!"100".equals(vo.getAreacode())
					&& !"999".equals(vo.getAreacode())) {
				throw new BusinessException("", "ȫʡ����������Ӫ�����������ʶ������\"100\"");
			}
		} else {
			if (!user.getCityid().equals(vo.getAreacode())) {
				throw new BusinessException("", "������Ӫ�����������ʶ�뵱ǰ����Ա�������ʶ��һ��!");
			}
			if (!vo.getYxplanid().toString().substring(0, 3).equals(
					user.getCityid())) {
				throw new Exception("��Ӫ��������ʶǰ3λ���Ϸ���ӦΪ����Ա���ڵ��б�ʶ.");
			}
		}

		checkPlanType(vo, user);
		checkuploadcalcfeekind(vo, user);
		// ����specialFlag�ֶΣ���Ҫ��Ĭ�ϵ�ֵ0��
		if (vo.getSpecialflag() == null || "".equals(vo.getSpecialflag())) {
			vo.setSpecialflag("0");
		}
		if (vo.getYxplanshortname() == null
				|| "".equals(vo.getYxplanshortname().trim())) {
			if (vo.getYxplanname() == null || "".equals(vo.getYxplanname())) {
				throw new Exception("�޸�ʱԭӪ���������Ʋ���Ϊ��");
			}
			vo.setYxplanshortname(vo.getYxplanname());
		}
		try {
			return (YxPlanVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}

	}

	/**
	 * ��������Ӫ������
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public YxPlanVO doBatchUpdate(YxPlanVO vo1, User user) throws Exception {
		YxPlanDAO dao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class, user);
		YxPlanVO yxplanvo = (YxPlanVO) dao.findByPk(vo1.getYxplanid());
		if (yxplanvo == null) {
			throw new BusinessException("", "Ҫ�޸ĵļ�¼�������ݿ���!");
		}
		// �ж���ʷ��¼�Ƿ�һ��
		if (user.isProvinceUser()) {
			DictitemDAO dictitemdao = (DictitemDAO) DAOFactory.build(
					DictitemDAO.class, user);
			DictitemListVO dictitemlist = new DictitemListVO();
			dictitemlist.set_se_groupid("PC_YXPLANAREACODE");
			dictitemlist.set_se_dictid(vo1.getAreacode());
			if (dictitemdao.query(dictitemlist).getRowCount() == 0) {
				throw new BusinessException("", "�����ʶ" + vo1.getAreacode()
						+ "������!");
			}
			// if(!"100".equals(vo1.getYxplanid().toString().substring(0, 3)))
			// {
			// throw new Exception("ȫʡ����ֻ��¼��ǰ��λΪ100��Ӫ������ID.");
			// }
			if (!"999".equals(vo1.getAreacode())
					&& !"100".equals(vo1.getAreacode())) {
				throw new BusinessException("", "�޸ĵ�Ӫ�����������ʶ�뵱ǰ����Ա�������ʶ��һ��!");
			}
		} else {
			if (!vo1.getAreacode().equals(user.getCityid())) {
				throw new BusinessException("", "�޸ĵ�Ӫ�����������ʶ�뵱ǰ����Ա�������ʶ��һ��!");
			}
		}
		String areacode = yxplanvo.getAreacode();

		if (vo1.getUploadcalcfeekind() != null) {
			checkuploadcalcfeekind(vo1, user);
		}
		if (vo1.getPlantype() != null) {
			checkPlanType(vo1, user);
		}
		if (vo1.getYxplanshortname() == null
				|| "".equals(vo1.getYxplanshortname())) {
			if (vo1.getYxplanname() != null && !"".equals(vo1.getYxplanname())) {
				vo1.setYxplanshortname(vo1.getYxplanname());
			}
		}
		// ������specialflag�ֶΣ���˸�����setSaveVO�������ָ�֮��ǵøĻ���
		setSaveVO(yxplanvo, vo1);
		yxplanvo.setAreacode(areacode);
		try {
			return (YxPlanVO) dao.update(yxplanvo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	/**
	 * ����ϴ���ѷ������
	 * 
	 * @param feedVO
	 * @param user
	 * @throws Exception
	 */
	private void checkuploadcalcfeekind(YxPlanVO yxPlanVO, User user)
			throws Exception {
		DictitemDAO delegate = (DictitemDAO) DAOFactory.build(
				DictitemDAO.class, user);
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid("PC_UPLOADCALCFEEKIND");
		listVO.set_se_dictid(yxPlanVO.getUploadcalcfeekind().toString());
		if (delegate.query(listVO).getRowCount() == 0) {
			throw new Exception(
					"�ϴ���ѷ�������ֶ����ݲ��Ϸ�����ο�0. ����ѷ���;1. ��������Ч����;2. ����������Ч����;3. ����������Ч����;4. ���ʵʱ��Ч����;5. Ԥ���ѷ���");
		}
	}

	/**
	 * ��� �ײ�����
	 */
	private void checkPlanType(YxPlanVO yxPlanVO, User user) throws Exception {
		DictitemDAO delegate = (DictitemDAO) DAOFactory.build(
				DictitemDAO.class, user);
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid("PC_PLANTYPE");
		listVO.set_se_dictid(yxPlanVO.getPlantype().toString());
		if (delegate.query(listVO).getRowCount() == 0) {
			throw new Exception(
					"�ײ������ֶ����ݲ��Ϸ�����ο�[SMS��GPRS��IP��MMS��RING��OTHERS��VOICE]");
		}
	}

	/**
	 * ����������ֵ�����־ö�����
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	protected void setSaveVO(Object yxplanvo, Object newVO) throws Exception {
		YxPlanVO tempVO = (YxPlanVO) yxplanvo;
		if (tempVO.getSpecialflag() != null
				&& "".equals(tempVO.getSpecialflag())) {
			((YxPlanVO) newVO).setSpecialflag(tempVO.getSpecialflag());
		}
		com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(yxplanvo,
				newVO);
	}

	/**
	 * �����ַ�������YxPlanVO
	 * 
	 * @param fields
	 * @param user
	 * @return
	 * @throws Exception
	 *             Ӫ��������ʶ0|Ӫ����������1|ȫʡ��ʶ2|��������3|ͣ������4|�����ʶ5|������Ѷ�6|������ѿ�Խ����7|
	 *             �Ƿ���Ҫ�����ײ�8|������9|�Ƿ�����ԤԼ10|�Ƿ�Ԥ������11|�����ô���12|��С�Ż�������13|�Ż�����ƫ����14|
	 *             ����ʱ�䵥Ԫ15|��Чʱ�����16|Ӫ�����������ʶ17|�Ƿ񱸷�18|�Ƿ��ӡ������19|
	 *             �Ƿ�����Ż�20|�Ƿ�Ӫҵ���Ż�21|ͣ��״̬�Ƿ���ȡ�����22|�Ƿ������Ա�Ż�23|��Դ24|Ӫ�����25|
	 *             Ӫ���������26|���ⷽ����־27|�Żݷ�Χ28|�ʷ�˵��29|˵��30|
	 */
	public YxPlanVO buildVO(String[] fields, User user) throws Exception {
		YxPlanVO result = null;
		try {
			result = new YxPlanVO();
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");

			result.setYxplanid(new Long(fields[0]));// Ӫ��������ʶ
			result.setYxplanname(fields[1]);// Ӫ����������
			result.setYxplancode(fields[2]);// ȫʡ��ʶ
			result.setStartdate(format.parse(fields[3]));// ��������
			result.setStopdate(format.parse(fields[4]));// ͣ������
			result.setCheckercode(user.getOpercode());// �����˹���
			result.setOperatorcode(user.getOpercode());// ����Ա����
			if (fields[5].trim().length() > 0)
				result.setAreacode(fields[5]);// �����ʶ
			if (fields[6].trim().length() > 0)
				result.setMinconsume(new Double(fields[6]));// ������Ѷ�
			if (fields[7].trim().length() > 0)
				result.setConsumecycle(new Long(fields[7]));// ������ѿ�Խ����
			if (fields[8].trim().length() > 0)
				result.setBindpackageflag(new Byte(fields[8]));// �Ƿ���Ҫ�����ײ�
			if (fields[9].trim().length() > 0)
				result.setBindmonths(new Long(fields[9]));// ������
			if (fields[10].trim().length() > 0)
				result.setBookflag(new Byte(fields[10]));// �Ƿ�����ԤԼ
			if (fields[11].trim().length() > 0)
				result.setRcprepayflag(new Byte(fields[11]));// �Ƿ�Ԥ������
			if (fields[12].trim().length() > 0)
				result.setCouldusetimes(new Long(fields[12]));// �����ô���
			if (fields[13].trim().length() > 0)
				result.setMindisccycle(new Long(fields[13]));// ��С�Ż�������
			if (fields[14].trim().length() > 0)
				result.setDiscoffset(new Long(fields[14]));// �Ż�����ƫ����
			if (fields[15].trim().length() > 0)
				result.setTimeunit(fields[15]);// ����ʱ�䵥Ԫ
			if (fields[16].trim().length() > 0)
				result.setStarttimetype(new Byte(fields[16]));// ��Чʱ�����
			if (fields[17].trim().length() > 0)
				result.setYxplangroupid(new Long(fields[17]));// Ӫ�����������ʶ
			result.setGroupflag(new Byte("0"));// �Ƿ�Ӫ��������
			if (fields[18].trim().length() > 0)
				result.setBackupflag(new Byte(fields[18]));// �Ƿ񱸷�
			if (fields[19].trim().length() > 0)
				result.setPrintflag(new Byte(fields[19]));// �Ƿ��ӡ������
			if (fields[20].trim().length() > 0)
				result.setFeecalcprivflag(new Byte(fields[20]));// �Ƿ�����Ż�
			if (fields[21].trim().length() > 0)
				result.setRecfeeprivflag(new Byte(fields[21]));// �Ƿ�Ӫҵ���Ż�
			if (fields[22].trim().length() > 0)
				result.setStopuserrentflag(new Byte(fields[22]));// ͣ��״̬�Ƿ���ȡ�����
			if (fields[23].trim().length() > 0)
				result.setIsoutmemberpriv(new Byte(fields[23]));// �Ƿ������Ա�Ż�
			if (fields[24].trim().length() > 0)
				result.setSource(fields[24]);// ��Դ
			if (fields[25].trim().length() > 0)
				result.setSalestype(new Long(fields[25]));// Ӫ�����
			if (fields[26].trim().length() > 0)
				result.setPlankind(fields[26]);// Ӫ���������
			if (fields[27].trim().length() > 0)
				result.setSpecialflag(fields[27]);// ���ⷽ����־
			if (fields[28].trim().length() > 0)
				result.setDiscscope(fields[28]);// �Żݷ�Χ
			if (fields[29].trim().length() > 0)
				result.setFeecomment(fields[29]);// �ʷ�˵��
			if (fields[30].trim().length() > 0)
				result.setRemark(fields[30]);// ˵��
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
	public ResultBean doCheck(String[] fields, User user) throws Exception {
		ResultBean result = new ResultBean();
		result.setCode(0);
		result.setInfo("");

		if (fields.length != 31) {
			result.setCode(88);
			result.setInfo("�����ļ���ʽ�ֶ������ԣ���ȷΪ31��");
			return result;
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
				;
				break;

			// Ӫ����������1
			case 1:
				if (fields[i].length() < 1 || fields[i].length() > 128) {
					result.setCode(77);
					result.setInfo("[Ӫ����������]���Ȳ�����Ҫ�󣬷�ΧӦ����(1~128)");
				}
				;
				break;

			// ȫʡ��ʶ2
			case 2:
				if (!fields[i].trim().equals("")
						&& !fields[i]
								.matches("^([a-z|A-Z]{2})([01]{4})([012]{1})((20|19)\\d{2}(0[0-9]{1}|1[012]{1})(0[0-9]{1}|[12]{1}\\d{1}|3[01]{1}))(\\d{3})(\\d{6})(\\d{2})$")) {
					result.setCode(77);
					result.setInfo("ȫʡ��ʶ����������Ҫ�󣬾�����ο������ļ�");
				}
				;
				break;

			// ��������3
			case 3:
				try {
					SimpleDateFormat format = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					format.parse(fields[i]);
				} catch (Exception e) {
					result.setCode(77);
					result.setInfo("[��������]��ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd HH:mm:ss]");
				}
				;
				break;

			// ͣ������4
			case 4:
				try {
					SimpleDateFormat format = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					format.parse(fields[i]);
				} catch (Exception e) {
					result.setCode(77);
					result.setInfo("[ͣ������]��ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd HH:mm:ss]");
				}
				;
				break;

			// �����ʶ5
			case 5:
				if (fields[i].length() > 32) {
					result.setCode(77);
					result.setInfo("[�����ʶ]���Ȳ���,��ΧӦ����(0~32)");
				}
				;
				break;

			// ������Ѷ�6
			case 6:
				if (!fields[i].trim().equals("")) {
					try {
						new Double(fields[i]);
					} catch (Exception e) {
						result.setCode(77);
						result.setInfo("[������Ѷ�]��ʽ����");
					}
				}
				;
				break;

			// ������ѿ�Խ����7
			case 7:
				if (!fields[i].trim().equals("")
						&& !fields[i].matches("[0-9\\-]+")) {
					result.setCode(77);
					result.setInfo("[������ѿ�Խ����]��ʽ����,Ӧ��Ϊ������");
				}
				;
				break;

			// �Ƿ���Ҫ�����ײ�8
			case 8:
				if (!fields[i].trim().equals("") && !fields[i].matches("[0-1]")) {
					result.setCode(77);
					result.setInfo("[�Ƿ���Ҫ�����ײ�]��ʽ����,ֻ��Ϊ����0��1");
				}
				;
				break;

			// ������9
			case 9:
				if (!fields[i].trim().equals("")
						&& !fields[i].matches("[0-9\\-]+")) {
					result.setCode(77);
					result.setInfo("[������]��ʽ����,Ӧ��Ϊ������");
				}
				;
				break;

			// �Ƿ�����ԤԼ10
			case 10:
				if (!fields[i].trim().equals("") && !fields[i].matches("[0-1]")) {
					result.setCode(77);
					result.setInfo("[�Ƿ�����ԤԼ]��ʽ����,ֻ��Ϊ����0��1");
				}
				;
				break;

			// �Ƿ�Ԥ������11
			case 11:
				if (!fields[i].trim().equals("") && !fields[i].matches("[0-1]")) {
					result.setCode(77);
					result.setInfo("[�Ƿ�Ԥ������]��ʽ����,ֻ��Ϊ����0��1");
				}
				;
				break;

			// �����ô���12
			case 12:
				if (!fields[i].trim().equals("")
						&& !fields[i].matches("[0-9\\-]+")) {
					result.setCode(77);
					result.setInfo("[�����ô���]��ʽ����,ֻ��Ϊ����0��1");
				}
				;
				break;

			// ��С�Ż�������13
			case 13:
				if (!fields[i].trim().equals("")
						&& !fields[i].matches("[0-9\\-]+")) {
					result.setCode(77);
					result.setInfo("[��С�Ż�������]��ʽ����,Ӧ��Ϊ������");
				}
				;
				break;

			// �Ż�����ƫ����14
			case 14:
				if (!fields[i].trim().equals("")
						&& !fields[i].matches("[0-9\\-]+")) {
					result.setCode(77);
					result.setInfo("[�Ż�����ƫ����]��ʽ����,Ӧ��Ϊ������");
				}
				;
				break;

			// ����ʱ�䵥Ԫ15
			case 15:
				if (fields[i].length() > 32) {
					result.setCode(77);
					result.setInfo("[����ʱ�䵥Ԫ]���Ȳ���,��ΧӦ����0~32");
				}
				;
				break;

			// ��Чʱ�����16
			case 16:
				if (!fields[i].trim().equals("") && !fields[i].matches("[0-1]")) {
					result.setCode(77);
					result.setInfo("[��Чʱ�����]��ʽ����,ֻ��Ϊ����0��1");
				}
				;
				break;

			// Ӫ�����������ʶ17
			case 17:
				if (!fields[i].trim().equals("")
						&& !fields[i].matches("[0-9\\-]+")) {
					result.setCode(77);
					result.setInfo("[Ӫ�����������ʶ]��ʽ����,Ӧ��Ϊ������");
				}
				;
				break;

			// �Ƿ񱸷�18
			case 18:
				if (!fields[i].trim().equals("") && !fields[i].matches("[0-1]")) {
					result.setCode(77);
					result.setInfo("[�Ƿ񱸷�]��ʽ����,ֻ��Ϊ����0��1");
				}
				;
				break;

			// �Ƿ��ӡ������19
			case 19:
				if (!fields[i].trim().equals("") && !fields[i].matches("[0-1]")) {
					result.setCode(77);
					result.setInfo("[�Ƿ��ӡ������]��ʽ����,ֻ��Ϊ����0��1");
				}
				;
				break;

			// �Ƿ�����Ż�20
			case 20:
				if (!fields[i].trim().equals("") && !fields[i].matches("[0-1]")) {
					result.setCode(77);
					result.setInfo("[�Ƿ�����Ż�]��ʽ����,ֻ��Ϊ����0��1");
				}
				;
				break;

			// �Ƿ�Ӫҵ���Ż�21
			case 21:
				if (!fields[i].trim().equals("") && !fields[i].matches("[0-1]")) {
					result.setCode(77);
					result.setInfo("[�Ƿ�Ӫҵ���Ż�]��ʽ����,ֻ��Ϊ����0��1");
				}
				;
				break;

			// ͣ��״̬�Ƿ���ȡ�����22
			case 22:
				if (!fields[i].trim().equals("") && !fields[i].matches("[0-1]")) {
					result.setCode(77);
					result.setInfo("[ͣ��״̬�Ƿ���ȡ�����]��ʽ����,ֻ��Ϊ����0��1");
				}
				;
				break;

			// �Ƿ������Ա�Ż�23
			case 23:
				if (!fields[i].trim().equals("") && !fields[i].matches("[0-1]")) {
					result.setCode(77);
					result.setInfo("[�Ƿ������Ա�Ż�]��ʽ����,ֻ��Ϊ����0��1");
				}
				;
				break;

			// ��Դ24
			case 24:
				if (fields[i].length() > 255) {
					result.setCode(77);
					result.setInfo("[��Դ]���Ȳ���,��ΧӦ����0~255");
				}
				;
				break;

			// Ӫ�����25
			case 25:
				if (!fields[i].trim().equals("")
						&& !fields[i].matches("[0-1]{1,2}")) {
					result.setCode(77);
					result.setInfo("[Ӫ�����]��ʽ���ԣ���ȷΪ����2λ����֮��");
				}
				;
				break;

			// Ӫ���������26
			case 26:
				if (fields[i].length() > 32) {
					result.setCode(77);
					result.setInfo("[Ӫ���������]���Ȳ���,��ΧӦ����0~32");
				}
				;
				break;

			// ���ⷽ����־27
			case 27:
				if (fields[i].length() > 32) {
					result.setCode(77);
					result.setInfo("[���ⷽ����־]���Ȳ���,��ΧӦ����0~32");
				}
				;
				break;

			// �Żݷ�Χ28
			case 28:
				if (fields[i].length() > 8) {
					result.setCode(77);
					result.setInfo("[�Żݷ�Χ]���Ȳ���,��ΧӦ����0~8");
				}
				;
				break;

			// �ʷ�˵��29
			case 29:
				if (fields[i].length() > 255) {
					result.setCode(77);
					result.setInfo("[�ʷ�˵��]���Ȳ���,��ΧӦ����0~255");
				}
				;
				break;

			// ˵��30
			case 30:
				if (fields[i].length() > 255) {
					result.setCode(77);
					result.setInfo("[˵��]���Ȳ���,��ΧӦ����0~255");
				}
				;
				break;

			}
		}

		return result;
	}

	/**
	 * ϵͳ�Զ�����yxplanid.
	 * 
	 * @param user
	 * @return Long
	 * @throws Exception
	 */
	public Long doGetYxplanID(User user) throws Exception {
		Long result = null;
		YxPlanDAO dao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class, user);
		String cityid = user.getCityid();
		if (user.isProvinceUser()) {
			cityid = "100";
		}
		do {
			String seqString = "" + getYxplanSeq(user);
			String yxplanid = cityid
					+ StringUtils.repeat("0", 11 - seqString.length())
					+ seqString;
			result = new Long(yxplanid);
		} while (dao.findByPk(result) != null);
		return result;
	}

	public void doSinglecopy(String oldid, String copyitem, YxPlanVO vo,
			boolean f, String filename, User user) throws Exception {
		try {
			YxPlanDAO dao = (YxPlanDAO) DAOFactory.build(YxPlanDAO.class, user);

			String tempstr = "," + copyitem + ",";
			Long newid = vo.getYxplanid();
			String strID = String.valueOf(newid);
			if (strID.length() != 14) {
				throw new Exception("��Ӫ��������ʶ������Ϊ14λ�����ִ�");
			}
			if (user.isProvinceUser()) {
				if (!"100".equals(strID.substring(0, 3))) {
					throw new Exception("ȫʡ����ֻ��¼��ǰ��λΪ100��Ӫ������ID.");
				}
			} else if (!strID.substring(0, 3).equals(user.getCityid())) {
				throw new Exception("��Ӫ��������ʶǰ3λ���Ϸ���ӦΪ����Ա���ڵ��б�ʶ.");
			}
			YxPlanVO temp = (YxPlanVO) dao.findByPk(newid);
			if (temp != null) {
				throw new Exception("��Ӫ��������ʶ�Ѵ���.");
			}
			// ��������
			if (vo.getYxplanshortname() == null
					|| "".equals(vo.getYxplanshortname())) {
				if (vo.getYxplanname() != null
						&& !"".equals(vo.getYxplanname())) {
					vo.setYxplanshortname(vo.getYxplanname());
				}
			}
			dao.create(vo);
			if (tempstr.indexOf(",0,") != -1) {
				doCopyfixfeedisc(oldid, newid, user);
			}
			if (tempstr.indexOf(",1,") != -1) {
				doCopyplandisccode(oldid, newid, user);
			}
			if (tempstr.indexOf(",2,") != -1) {
				doCopyfeedisc(oldid, newid, user);
			}
			if (tempstr.indexOf(",3,") != -1) {
				doCopyeboxdisc(oldid, newid, user);
			}
			if (tempstr.indexOf(",4,") != -1) {
				doCopyscale(oldid, newid, user);
			}
			if (tempstr.indexOf(",5,") != -1) {
				doCopypresnt(oldid, newid, user);
			}
			if (tempstr.indexOf(",27,") != -1) {
				doCopymonth(oldid, newid, user);
			}
			if (tempstr.indexOf(",28,") != -1) {
				doCopyminconsume(oldid, newid, user);
			}
			if (tempstr.indexOf(",29,") != -1) {
				doCopyprodservset(oldid, newid, user);
			}
			if (f) {
				doLogCopy(new Long(oldid), newid, copyitem, user);
			} else {
				doBatchLogCopy(new Long(oldid), newid, copyitem, filename, user);
			}
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	/**
	 * �����̶����Ż���ϸ
	 * 
	 * @param oldid
	 * @param newid
	 * @param user
	 * @return 1-��������ϸ 0-�޶�Ӧ����ϸ
	 * @throws Exception
	 */
	private int doCopyfixfeedisc(String oldid, Long newid, User user)
			throws Exception {
		PcPsFixfeediscDAO fixfeediscDAO = (PcPsFixfeediscDAO) DAOFactory.build(
				PcPsFixfeediscDAO.class, user);
		PcPsFixfeediscListVO listVO = new PcPsFixfeediscListVO();
		listVO.set_ne_yxplanid(oldid);
		DataPackage dp = fixfeediscDAO.query(listVO);
		if (dp.getRowCount() > 0) {
			Iterator iterator = dp.getDatas().iterator();
			while (iterator.hasNext()) {
				PcPsFixfeediscVO vo = new PcPsFixfeediscVO();
				PcPsFixfeediscVO temp = (PcPsFixfeediscVO) iterator.next();
				BeanUtils.copyProperties(vo, temp);
				vo.setFixfeediscid(null);
				vo.setYxplanid(newid);
				fixfeediscDAO.create(vo);
			}
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * ����Ӫ�������Żݴ�����ϸ
	 * 
	 * @param oldid
	 * @param newid
	 * @param user
	 * @return 1-��������ϸ 0-�޶�Ӧ����ϸ
	 * @throws Exception
	 */
	private int doCopyplandisccode(String oldid, Long newid, User user)
			throws Exception {
		PlandisccodeDAO plandisccodeDAO = (PlandisccodeDAO) DAOFactory.build(
				PlandisccodeDAO.class, user);
		PlandisccodeListVO listVO = new PlandisccodeListVO();
		listVO.set_ne_yxplanid(oldid);
		DataPackage dp = plandisccodeDAO.query(listVO);
		if (dp.getRowCount() > 0) {
			Iterator iterator = dp.getDatas().iterator();
			while (iterator.hasNext()) {
				PlandisccodeVO vo = new PlandisccodeVO();
				PlandisccodeVO temp = (PlandisccodeVO) iterator.next();
				BeanUtils.copyProperties(vo, temp);
				vo.setYxplanid(newid);
				plandisccodeDAO.create(vo);
			}
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * �����ʷ��Ż�������ϸ
	 * 
	 * @param oldid
	 * @param newid
	 * @param user
	 * @return 1-��������ϸ 0-�޶�Ӧ����ϸ
	 * @throws Exception
	 */
	private int doCopyfeedisc(String oldid, Long newid, User user)
			throws Exception {
		FeediscDAO feediscDAO = (FeediscDAO) DAOFactory.build(FeediscDAO.class,
				user);
		FeediscListVO listVO = new FeediscListVO();
		listVO.set_ne_yxplanid(oldid);
		DataPackage dp = feediscDAO.query(listVO);
		if (dp.getRowCount() > 0) {
			Iterator iterator = dp.getDatas().iterator();
			while (iterator.hasNext()) {
				FeediscVO vo = new FeediscVO();
				FeediscVO temp = (FeediscVO) iterator.next();
				BeanUtils.copyProperties(vo, temp);
				vo.setYxplanid(newid);
				vo.setFeediscid(null);
				feediscDAO.create(vo);
			}
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * �����ʻ�Ԥ���Ż���ϸ
	 * 
	 * @param oldid
	 * @param newid
	 * @param user
	 * @return 1-��������ϸ 0-�޶�Ӧ����ϸ
	 * @throws Exception
	 */
	private int doCopyeboxdisc(String oldid, Long newid, User user)
			throws Exception {
		EboxdiscDAO eboxdiscDAO = (EboxdiscDAO) DAOFactory.build(
				EboxdiscDAO.class, user);
		EboxdiscListVO listVO = new EboxdiscListVO();
		listVO.set_ne_yxplanid(oldid);
		DataPackage dp = eboxdiscDAO.query(listVO);
		if (dp.getRowCount() > 0) {
			Iterator iterator = dp.getDatas().iterator();
			while (iterator.hasNext()) {
				EboxdiscVO vo = new EboxdiscVO();
				EboxdiscVO temp = (EboxdiscVO) iterator.next();
				BeanUtils.copyProperties(vo, temp);
				vo.setYxplanid(newid);
				eboxdiscDAO.create(vo);
			}
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * ����Ӫ���������ʲ����ϸ
	 * 
	 * @param oldid
	 * @param newid
	 * @param user
	 * @return 1-��������ϸ 0-�޶�Ӧ����ϸ
	 * @throws Exception
	 */
	private int doCopyscale(String oldid, Long newid, User user)
			throws Exception {
		YxPlanSplitScaleDAO scaleDAO = (YxPlanSplitScaleDAO) DAOFactory.build(
				YxPlanSplitScaleDAO.class, user);
		YxPlanSplitScaleListVO listVO = new YxPlanSplitScaleListVO();
		listVO.set_ne_yxplanid(oldid);
		DataPackage dp = scaleDAO.query(listVO);
		if (dp.getRowCount() > 0) {
			Iterator iterator = dp.getDatas().iterator();
			while (iterator.hasNext()) {
				YxPlanSplitScaleVO vo = new YxPlanSplitScaleVO();
				YxPlanSplitScaleVO temp = (YxPlanSplitScaleVO) iterator.next();
				BeanUtils.copyProperties(vo, temp);
				vo.setYxplanid(newid);
				scaleDAO.create(vo);
			}
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * ����Ӫ��������������������Ϣ��
	 * 
	 * @param oldid
	 * @param newid
	 * @param user
	 * @return 1-��������ϸ 0-�޶�Ӧ����ϸ
	 * @throws Exception
	 */
	private int doCopypresnt(String oldid, Long newid, User user)
			throws Exception {
		YxplanpresntDAO presntDAO = (YxplanpresntDAO) DAOFactory.build(
				YxplanpresntDAO.class, user);
		YxplanpresntListVO listVO = new YxplanpresntListVO();
		listVO.set_ne_yxplanid(oldid);
		DataPackage dp = presntDAO.query(listVO);
		if (dp.getRowCount() > 0) {
			Iterator iterator = dp.getDatas().iterator();
			while (iterator.hasNext()) {
				YxplanpresntVO vo = new YxplanpresntVO();
				YxplanpresntVO temp = (YxplanpresntVO) iterator.next();
				BeanUtils.copyProperties(vo, temp);
				vo.setYxplanid(newid);
				presntDAO.create(vo);
			}
			return 1;
		} else {
			return 0;
		}
	}

	private int doCopymonth(String oldid, Long newid, User user)
			throws Exception {
		FeediscmonthDAO monthDAO = (FeediscmonthDAO) DAOFactory.build(
				FeediscmonthDAO.class, user);
		FeediscmonthListVO listVO = new FeediscmonthListVO();
		listVO.set_ne_yxplanid(oldid);
		DataPackage dp = monthDAO.query(listVO);
		if (dp.getRowCount() > 0) {
			Iterator iterator = dp.getDatas().iterator();
			while (iterator.hasNext()) {
				FeediscmonthVO vo = new FeediscmonthVO();
				FeediscmonthVO temp = (FeediscmonthVO) iterator.next();
				BeanUtils.copyProperties(vo, temp);
				vo.setYxplanid(newid);
				monthDAO.create(vo);
			}
			return 1;
		} else {
			return 0;
		}
	}

	private int doCopyminconsume(String oldid, Long newid, User user)
			throws Exception {
		MinconsumeDAO minDAO = (MinconsumeDAO) DAOFactory.build(
				MinconsumeDAO.class, user);
		MinconsumeListVO listVO = new MinconsumeListVO();
		listVO.set_ne_yxplanid(oldid);
		DataPackage dp = minDAO.query(listVO);
		if (dp.getRowCount() > 0) {
			Iterator iterator = dp.getDatas().iterator();
			while (iterator.hasNext()) {
				MinconsumeVO vo = new MinconsumeVO();
				MinconsumeVO temp = (MinconsumeVO) iterator.next();
				BeanUtils.copyProperties(vo, temp);
				vo.setYxplanid(newid);
				minDAO.create(vo);
			}
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * 
	 * @param oldid
	 * @param newid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private int doCopyprodservset(String oldid, Long newid, User user)
			throws Exception {
		ProdservsetDAO prodDAO = (ProdservsetDAO) DAOFactory.build(
				ProdservsetDAO.class, user);
		try {
			Long oldID = new Long(oldid);
			ProdservsetVO temp = (ProdservsetVO) prodDAO.findByPk(oldID);
			if (temp != null) {
				ProdservsetVO vo = new ProdservsetVO();
				BeanUtils.copyProperties(vo, temp);
				vo.setYxplanid(newid);
				prodDAO.create(vo);
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			if (e instanceof NumberFormatException) {
				throw new Exception("���ָ�ʽ������");
			} else {
				throw new Exception(e.getMessage());
			}
		}

	}

	private void doLogCopy(Long oldid, Long newid, String copyitem, User user)
			throws Exception {
		YxplancplogDAO yxplancplogDAO = (YxplancplogDAO) DAOFactory.build(
				YxplancplogDAO.class, user);
		YxplancplogVO vo = new YxplancplogVO();
		Date now = new Date(System.currentTimeMillis());
		IntegrationBean integrationBean = new IntegrationBean(user);

		String huaweiIP = integrationBean.getHuaweiIP();
		String huaweiPort = integrationBean.getHuaweiPort();
		String huaweiWebRoot = integrationBean.getHuaweiWebRoot();

		if (huaweiWebRoot == null)
			huaweiWebRoot = "/boss";
		String huaweiContextPath = huaweiIP != null ? "http://" + huaweiIP : "";
		if (huaweiIP != null && huaweiPort != null && !"80".equals(huaweiPort))
			huaweiContextPath = huaweiContextPath + ":" + huaweiPort;
		huaweiContextPath = huaweiContextPath + huaweiWebRoot;
		String url = huaweiContextPath + "/product/privilegeCopyAction.do"
				+ "?actionType=queryInit&yxplanid=" + oldid.toString()
				+ "&newyxplanid=" + newid.toString();
		vo.setCopyitem(copyitem);
		vo.setCreatetime(now);
		vo.setModifytime(now);
		vo.setNewyxplanid(newid);
		vo.setOprcode(user.getOpercode());
		vo.setOprobject("CX");
		vo.setOprresulte("Success");
		vo.setOprstate("2");
		vo.setOprtype("Single");
		vo.setOrgyxplanid(oldid);
		vo.setRemark(url);
		yxplancplogDAO.create(vo);
	}

	private void doBatchLogCopy(Long oldid, Long newid, String copyitem,
			String filename, User user) throws Exception {
		YxplancplogDAO yxplancplogDAO = (YxplancplogDAO) DAOFactory.build(
				YxplancplogDAO.class, user);
		YxplancplogVO vo = new YxplancplogVO();
		Date now = new Date(System.currentTimeMillis());
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddhhmmss");
		vo.setCopyitem(copyitem);
		vo.setCreatetime(now);
		vo.setModifytime(now);
		vo.setNewyxplanid(newid);
		vo.setOprcode(user.getOpercode());
		vo.setOprobject("CX");
		vo.setOprresulte("Success");
		vo.setOprstate("1");
		vo.setOprtype("Batch");
		vo.setOrgyxplanid(oldid);
		vo.setBatchno(user.getCityid() + fmt.format(rightNow.getTime()));
		vo.setRemark(filename);
		yxplancplogDAO.create(vo);

	}

	public String getAreacode(Long yxplanid, User user) throws Exception {
		YxPlanDelegate delegate = new YxPlanDelegate();
		YxPlanVO vo = delegate.doFindByPk(yxplanid, user);
		if (vo == null) {
			return null;
		} else {
			return vo.getAreacode() == null ? "" : vo.getAreacode();
		}
	}
}
