package com.sunrise.boss.ui.cms.commons;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.resmanage.com.persistent.ComVO;
import com.sunrise.boss.business.resmanage.interf.control.ResmanageInterf;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;

public class CMSUtils {

	/**
	 * �����ִ�
	 */
	public static String[] splitStr(String str) throws Exception {

		return str.split(CMSConstant.MAIL_ADDR_SPLIT);

	}

	/**
	 * ɾ���ļ�
	 */
	public static void deleteFile(String path) throws Exception {

	}

	/**
	 * ����yyyy-MM-dd��ʽ�ĵ������ڵ��ַ���
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getCurrentSimpleDateStr() throws Exception {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		return f.format(new Date());
	}

	/**
	 * ����yyyy-MM-dd HH:mm:ss��ʽ�ĵ������ڵ��ַ���
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getCurrentDateStr() throws Exception {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return f.format(new Date());
	}

	/**
	 * ����yyyy-MM-dd��ʽ��ָ��ʱ����ַ���
	 * 
	 * @param time
	 * @return
	 * @throws Exception
	 */
	public static String getTimeStrWithDay(Timestamp time) throws Exception {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		return f.format(time);
	}

	/**
	 * �ж��ַ����Ƿ�Ϊ�գ����򷵻��棬�ǿ��򷵻ؼ�
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str.trim()))
			return true;
		return false;
	}

	/**
	 * ��ʱ��ת��Ϊ��Ӧ�ĳ��������֣�����2006-06-03ת��Ϊ20060603
	 * 
	 * @param date---��ʽ"yyyy-MM-dd"
	 * @return
	 */
	public static Long getLongDate(String date) throws Exception {
		if (!date.matches(CMSConstant.DATE_REGEX)) {
			// ��ƥ���ʽ"yyyy-MM-dd"
			throw new Exception("�����ַ����ĸ�ʽ��ƥ��'yyyy-MM-dd'");
		}
		StringBuffer strBuff = new StringBuffer();
		int index1 = date.indexOf("-");
		strBuff.append(date.substring(0, index1));
		int index2 = date.lastIndexOf("-");
		strBuff.append(date.substring(index1 + 1, index2));
		strBuff.append(date.substring(index2 + 1));
		return new Long(strBuff.toString());
	}

	/**
	 * �������͹̶�������id���õ���Ӧ����װ������󣨿��Եõ���Ʒ���͵ķ������
	 * 
	 * @param goodclass
	 * @param groupid
	 * @param user
	 * @return
	 * @throws Exception
	 */
//	public static Collection getTranscode(Short goodclass, String groupid,
//			User user) throws Exception {
//		List transcode = new ArrayList();
//		/* ������Ʒ���ͽӿڣ��õ���Ʒ����ֵ */
//		ResmanageInterf interf = new ResmanageDelegate();
//		Set set = interf.getComType(new Long(goodclass.toString()), user);
//
//		DictitemDelegate dictitemDelegate = new DictitemDelegate();
//		for (Iterator it = set.iterator(); it.hasNext();) {
//			String code = ((Long) it.next()).toString();
//			DictitemVO vo = new DictitemVO();
//			vo.setGroupid(groupid); // ������id
//			vo.setDictid(code); // ������Ʒ����ֵ
//			vo = (DictitemVO) dictitemDelegate.doFindByPk(vo, user);
//			if (vo != null) {
//				TranscodeBean bean = new TranscodeBean();
//				bean.setName(vo.getDictname());
//				bean.setCode(code);
//				transcode.add(bean);
//			}
//		}
//		return transcode;
//	}

	/**
	 * �õ�ҳ����ʾ����Ʒ�б���
	 * 
	 * @param coll
	 * @return
	 * @throws Exception
	 */
	public static Collection getComColl(Collection coll) {
		List comList = new ArrayList();
		for (Iterator it = coll.iterator(); it.hasNext();) {
			ComVO comVO = (ComVO) it.next();
			ApplyResBean bean = new ApplyResBean();
			bean.setResid(comVO.getComid().toString()); // ��Ʒ��ʶ
			bean.setResname(comVO.getComname().toString()); // ��Ʒ����
			bean.setPrice(comVO.getComprice().toString()); // ��Ʒ�۸�
			comList.add(bean);
		}
		return comList;
	}

	/**
	 * �õ����ֿ�
	 * 
	 * @return
	 */
	public static Collection getIntegralColl() {
		List integralList = new ArrayList();
		ApplyResBean bean = new ApplyResBean();
		bean.setResid("-1"); // ���ֿ��ı�ʶΪ-1
		bean.setResname("���ֿ�"); // ���ֿ�����
		bean.setPrice("0"); // �۸�Ϊ0

		integralList.add(bean);
		return integralList;
	}

	/**
	 * �õ�SIM���б�
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public static Collection getSIMColl(User user) throws Exception {
		List simColl = new ArrayList();
		Collection dictitem = getSIMDictitemColl(user);
		for (Iterator it = dictitem.iterator(); it.hasNext();) {
			DictitemVO vo = (DictitemVO) it.next();
			ApplyResBean bean = new ApplyResBean();
			bean.setResid(vo.getDictid()); // SIM�����ͱ�ʶ
			bean.setResname(vo.getDictname()); // SIM����������
			bean.setPrice("0"); // �۸�ͳһ��0
			simColl.add(bean);
		}
		return simColl;
	}

	private static Collection getSIMDictitemColl(User user) throws Exception {
		DictitemDelegate dictitemDelegate = new DictitemDelegate();
		DictitemListVO dictForm = new DictitemListVO();
		dictForm.set_se_groupid(CMSConstant.DICTITEM_IM_SIMTYPE); // SIM������
		dictForm.set_pagesize("0");
		DataPackage dp = (DataPackage) dictitemDelegate.doQuery(dictForm, user);
		return dp.getDatas();
	}

	/* �ļ����� */
	/**
	 * �õ��ϴ��ļ�������Ϊ�ִ�
	 * 
	 * @param indepotForm
	 * @return
	 * @throws Exception
	 */
	private static String getInputFile(FormFile inputFile) throws Exception {
		InputStream inputstream = null;

		try {
			inputstream = inputFile.getInputStream();
		} catch (FileNotFoundException ex1) {
			throw new Exception("�Ҳ���ָ���ļ���");
		} catch (IOException ex1) {
			throw new Exception("��д����:" + ex1.getMessage());
		} catch (NullPointerException ex1) {
			throw new Exception("��ָ���������ļ���");
		}

		StringBuffer buffer = new StringBuffer("");
		int totalSize = inputFile.getFileSize();
		byte[] bytes = new byte[totalSize];
		try {
			int i = 0;
			int j = 0;
			for (; i < totalSize; i++) {
				try {
					j = inputstream.read(bytes, i, 1);
					if (bytes[i] > 0) {
						byte[] tmp = new byte[1];
						tmp[0] = bytes[i];
						buffer.append(new String(tmp, "US-ASCII"));
					} else {
						i++;
						j = inputstream.read(bytes, i, 1);
						byte[] tmp = new byte[2];
						tmp[0] = bytes[i - 1];
						tmp[1] = bytes[i];
						buffer.append(new String(tmp, "GBK"));
					}
				} catch (Exception ex) {
					throw new Exception("�ļ��ϴ����ִ���! ");
				}
			}
		} catch (Exception ex) {
			throw new Exception("�����ļ�ʱ���ִ���");
		}
		return buffer.toString();
	}

	/**
	 * ���ݷָ������ִ�
	 * 
	 * @param total
	 * @return
	 * @throws Exception
	 */
	private static StringTokenizer getRows(String total) throws Exception {
		StringTokenizer rows = null;
		if (total.indexOf("\r\n") != -1) {
			rows = new StringTokenizer(total, "\r\n");
		} else {
			rows = new StringTokenizer(total, "\n");
		}
		return rows;
	}

	/**
	 * �õ������ļ�������
	 * 
	 * @param indepotForm
	 * @return
	 * @throws Exception
	 */
	public static Iterator getData(FormFile inputFile) throws Exception {
		List list = new ArrayList();
		String total = getInputFile(inputFile);
		StringTokenizer rows = null;
		if (total != null) {
			rows = getRows(total);
		}
		if (rows != null) {
			for (; rows.hasMoreTokens();) {
				String row = rows.nextToken();
				list.add(row);
			}
		}
		return list.iterator();
	}

	public static String[] doGetOrgtypeNumber(String orgtype) throws Exception {
		String[] returns = new String[] { "", "" };
		if (StringUtils.equals("Citycom", orgtype)) {
			returns[0] = "2";
			returns[1] = "���й�˾";
			return returns;
		}
		if (StringUtils.equals("Cntycom", orgtype)) {
			returns[0] = "3";
			returns[1] = "�ֹ�˾";
			return returns;
		}
		if (StringUtils.equals("Svc", orgtype)) {
			returns[0] = "4";
			returns[1] = "������������";
			return returns;
		}
		if (StringUtils.equals("Ma", orgtype)) {
			returns[0] = "5";
			returns[1] = "΢����";
			return returns;
		}
		return returns;
	}

	public static String doGetOrgtypebynumber(String orgtype) {
		if (StringUtils.equals("2", orgtype)) {
			return "Citycom";
		}
		if (StringUtils.equals("3", orgtype)) {
			return "Cntycom";
		}
		if (StringUtils.equals("4", orgtype)) {
			return "Svc";
		}
		if (StringUtils.equals("5", orgtype)) {
			return "Ma";
		}
		return "";
	}

	public static boolean doGetwaytype(WayVO wayvo, String waytype,
			String waysubtype, String runmode) throws Exception {
		if (StringUtils.isEmpty(waytype)) {
			return true;
		}
		if (wayvo.getWaystate().intValue() != 1) {
			return false;
		}
		if (StringUtils.equals(wayvo.getWaytype(), waytype)) {
			if (StringUtils.isEmpty(waysubtype)) {
				return true;
			} else {
				if (StringUtils.equals(wayvo.getWaysubtype(), waysubtype)) {
					if (StringUtils.isEmpty(runmode)) {
						return true;
					} else {
						if (StringUtils.equals(wayvo.getRunmode().toString(),
								runmode)) {
							return true;
						} else {
							return false;
						}
					}
				} else {
					return false;
				}
			}
		} else {
			return false;
		}

		//		
		//		
		// if(StringUtils.isNotEmpty(waytype) &&
		// !StringUtils.equals(wayvo.getWaytype(), waytype)){
		// if(StringUtils.isNotEmpty(waysubtype)
		// &&!StringUtils.equals(wayvo.getWaysubtype(), waysubtype)){
		// if(StringUtils.isNotEmpty(runmode)
		// &&!StringUtils.equals(wayvo.getRunmode().toString(), runmode)){
		// return false;
		// }
		// return false;
		// }
		// return false;
		// }else{
		// return true;
		// }
	}

	/**
	 * ����ָ�����ȵ������,��Сд��ĸ���������
	 * 
	 * @param pwdlength
	 *            ���ɵ�������ܳ���
	 * @return ������ַ���
	 */
	public static String genRandomNumer(int pwdlength) {
		final int maxnumber = 62;
		int i;
		int countlength = 0;
		char[] ch = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
				'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6',
				'7', '8', '9' };

		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (countlength < pwdlength) {

			i = Math.abs(r.nextInt(maxnumber)); // ���ɵ������Ϊ62-1

			if (i >= 0 && i < ch.length) {
				pwd.append(ch[i]);
				countlength++;
			}
		}

		return pwd.toString();
	}

	/*
	 * �õ�ָ���̶�������ID/NAME @param �̶��������ƣ��践�ص��ֶ�"id"/"name" @return String[]
	 */
	public static String[] getIDorname(String groupid, String idorname) {
		String[] rtn = {};
		try {
			DictitemDelegate dictitemDelegate = new DictitemDelegate();
			DictitemListVO dictForm = new DictitemListVO();
			dictForm.set_se_groupid(groupid.trim());
			dictForm.set_pagesize("0");
			User user = new User();
			DataPackage dp = (DataPackage) dictitemDelegate.doQuery(dictForm,
					user);
			int i = 0;
			rtn = new String[dp.getDatas().size()];
			for (Iterator it = dp.getDatas().iterator(); it.hasNext(); i++) {
				DictitemVO vo = (DictitemVO) it.next();
				if ("name".equalsIgnoreCase(idorname.trim())) {
					rtn[i] = vo.getDictname().toString();
				} else {
					rtn[i] = vo.getDictid().toString();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rtn;
	}

	public static void checkDict(String groupid, String dictid, User user) throws Exception{
		CommonDelegate dictitemDelegate = new CommonDelegate(DictitemVO.class);
		DictitemListVO listvo = new DictitemListVO();
		listvo.set_se_groupid(groupid);
		DataPackage dp = dictitemDelegate.doQuery(listvo, user, false);
		if (dp != null && dp.getDatas()!= null && dp.getDatas().size() > 0){
			Iterator it = dp.getDatas().iterator();
			StringBuffer buf = new StringBuffer();
			while (it.hasNext()){
				DictitemVO vo = (DictitemVO)it.next();
				buf.append(vo.getDictid() + ",");
				if (vo.getDictid().equals(dictid)){
					return;
				}
			}
			throw new Exception("������������,Ӧ��Ϊ[" + buf.toString() + "] �е�һ��!");
		}
	}

}
