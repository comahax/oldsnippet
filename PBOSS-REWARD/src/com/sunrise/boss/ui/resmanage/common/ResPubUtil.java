package com.sunrise.boss.ui.resmanage.common;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.admin.operator.persistent.OperatorVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.business.resmanage.common.pubdef.ResConstant;
import com.sunrise.boss.business.resmanage.oprresmanage.audit.persistent.AuditVO;
import com.sunrise.boss.delegate.admin.operator.OperatorDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;
import com.sunrise.boss.ui.commons.integration.IntegrationBean;

public class ResPubUtil {

	public static final String Paramtype = "resource";

	public static final Long LimitedNumSystemid = new Long(17);

	public static final Long DefaultNum = new Long(30000);

	public static long getLimitedNum(User user) throws Exception {
		SysparamVO vo = getSysparamVO(LimitedNumSystemid, user);
		if (vo != null && vo.getParamvalue() != null)
			return Long.valueOf(vo.getParamvalue()).longValue();
		else
			return DefaultNum.longValue();
	}

	public static void checkCount(User user, int rowCount) throws Exception {
		long limitedNum = getLimitedNum(user);
		if (rowCount > limitedNum) {
			throw new Exception("�ļ��������ܳ���" + limitedNum + "��!");
		}
	}

	public static SysparamVO getSysparamVO(Long systemid, User user) throws Exception {
		SysparamDelegate delegate = new SysparamDelegate();
		SysparamVO vo = new SysparamVO();
		vo.setParamtype(Paramtype);
		vo.setSystemid(systemid);
		return delegate.doFindByPk(vo, user);
	}

	public static FtpInfo getFtpInfo(User user) throws Exception {
		FtpInfo fi = new FtpInfo();
		SysparamVO sysvo = new SysparamVO();
		sysvo = getSysparamVO(ResConstant.SysParam_BatchFileFTP, user);
		if (sysvo == null) {
			throw new Exception("��Դϵͳ����û�����ã��޷�ȡ�������ļ����Ŀ¼");
		} else {
			String url = sysvo.getParamvalue();
			fi.ftpServer = StringUtils.substringBetween(url, "@", ":");
			fi.ftpPort = new Integer(StringUtils.substringAfterLast(url, ":")).intValue();
			fi.ftpPwd = StringUtils.substringBetween(url, ":", "@");
			fi.ftpUser = StringUtils.substringBefore(url, ":");

			return fi;
		}
	}

	public static FtpInfo getFtpInfo(Long paramid, User user) throws Exception {
		FtpInfo fi = new FtpInfo();
		String url = getSysparamVO(paramid, user).getParamvalue();

		fi.ftpServer = StringUtils.substringBetween(url, "@", ":");
		fi.ftpPort = new Integer(StringUtils.substringAfterLast(url, ":")).intValue();
		fi.ftpPwd = StringUtils.substringBetween(url, ":", "@");
		fi.ftpUser = StringUtils.substringBefore(url, ":");

		return fi;
	}

	private ResPubUtil() {
	}

	/**
	 * �Ǽ�̨����˼�¼��
	 * 
	 * @param sheetid
	 * @param reqoprcode
	 * @param auditoprcode
	 * @param inoprcode
	 * @param outoprcode
	 * @param user
	 * @throws Exception
	 */
	public static void registerAudit(String sheetid, String reqoprcode, String auditoprcode, String inoprcode, String outoprcode, User user) throws Exception {
		try {
			AuditVO vo = new AuditVO();
			vo.setReqoprcode(reqoprcode);
			vo.setSheetid(sheetid);
			vo.setAuditoprcode(auditoprcode);
			vo.setInoprcode(inoprcode);
			vo.setOutoprcode(outoprcode);
			vo.setState(ResConstant.AUDITSATE_NEEDAUDIT);
			vo.setCreatetime(new Date(System.currentTimeMillis()));

			OperatorDelegate delegate = new OperatorDelegate();
			OperatorVO queryvo = delegate.doFindByPk(reqoprcode, user);
			if (null == queryvo) {
				throw new Exception("������" + reqoprcode + " ,�ڲ���Ա��(SA_SO_OPERATOR)�в�����");
			}

			vo.setWayid(queryvo.getOrgid());// 20081106�����˵�������wayid

			new CommonDelegate(AuditVO.class).doCreate(vo, user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("�Ǽ���˼�¼�����!");
		}
	}

	public static String getHuaweiCtx(User user) {
		IntegrationBean integrationBean = new IntegrationBean(user);
		String huaweiIP = integrationBean.getHuaweiIP();
		String huaweiPort = integrationBean.getHuaweiPort();
		String huaweiWebUrl = "/boss/reception/monitorbusiness/bookingNumServer.do?method=bookingnum";

		String huaweiContextPath = huaweiIP != null ? "http://" + huaweiIP : "";
		if (huaweiIP != null && huaweiPort != null && !"80".equals(huaweiPort))
			huaweiContextPath = huaweiContextPath + ":" + huaweiPort;
		huaweiContextPath = huaweiContextPath + huaweiWebUrl;
		return huaweiContextPath;
	}
}
