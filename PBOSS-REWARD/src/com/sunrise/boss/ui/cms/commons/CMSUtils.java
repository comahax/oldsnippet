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
	 * 解析字串
	 */
	public static String[] splitStr(String str) throws Exception {

		return str.split(CMSConstant.MAIL_ADDR_SPLIT);

	}

	/**
	 * 删除文件
	 */
	public static void deleteFile(String path) throws Exception {

	}

	/**
	 * 返回yyyy-MM-dd格式的当天日期的字符串
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getCurrentSimpleDateStr() throws Exception {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		return f.format(new Date());
	}

	/**
	 * 返回yyyy-MM-dd HH:mm:ss格式的当天日期的字符串
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getCurrentDateStr() throws Exception {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return f.format(new Date());
	}

	/**
	 * 返回yyyy-MM-dd格式的指定时间的字符串
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
	 * 判断字符串是否为空，空则返回真，非空则返回假
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
	 * 将时间转换为相应的长整型数字，比如2006-06-03转换为20060603
	 * 
	 * @param date---格式"yyyy-MM-dd"
	 * @return
	 */
	public static Long getLongDate(String date) throws Exception {
		if (!date.matches(CMSConstant.DATE_REGEX)) {
			// 不匹配格式"yyyy-MM-dd"
			throw new Exception("日期字符串的格式不匹配'yyyy-MM-dd'");
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
	 * 根据类别和固定参数组id，得到相应的组装翻译对象（可以得到商品类型的翻译对象）
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
//		/* 调用商品类型接口，得到商品类型值 */
//		ResmanageInterf interf = new ResmanageDelegate();
//		Set set = interf.getComType(new Long(goodclass.toString()), user);
//
//		DictitemDelegate dictitemDelegate = new DictitemDelegate();
//		for (Iterator it = set.iterator(); it.hasNext();) {
//			String code = ((Long) it.next()).toString();
//			DictitemVO vo = new DictitemVO();
//			vo.setGroupid(groupid); // 填入组id
//			vo.setDictid(code); // 填入商品类型值
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
	 * 得到页面显示的商品列表集合
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
			bean.setResid(comVO.getComid().toString()); // 商品标识
			bean.setResname(comVO.getComname().toString()); // 商品名称
			bean.setPrice(comVO.getComprice().toString()); // 商品价格
			comList.add(bean);
		}
		return comList;
	}

	/**
	 * 得到积分卡
	 * 
	 * @return
	 */
	public static Collection getIntegralColl() {
		List integralList = new ArrayList();
		ApplyResBean bean = new ApplyResBean();
		bean.setResid("-1"); // 积分卡的标识为-1
		bean.setResname("积分卡"); // 积分卡名称
		bean.setPrice("0"); // 价格为0

		integralList.add(bean);
		return integralList;
	}

	/**
	 * 得到SIM卡列表
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
			bean.setResid(vo.getDictid()); // SIM卡类型标识
			bean.setResname(vo.getDictname()); // SIM卡类型名称
			bean.setPrice("0"); // 价格统一填0
			simColl.add(bean);
		}
		return simColl;
	}

	private static Collection getSIMDictitemColl(User user) throws Exception {
		DictitemDelegate dictitemDelegate = new DictitemDelegate();
		DictitemListVO dictForm = new DictitemListVO();
		dictForm.set_se_groupid(CMSConstant.DICTITEM_IM_SIMTYPE); // SIM卡类型
		dictForm.set_pagesize("0");
		DataPackage dp = (DataPackage) dictitemDelegate.doQuery(dictForm, user);
		return dp.getDatas();
	}

	/* 文件处理 */
	/**
	 * 得到上传文件并解析为字串
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
			throw new Exception("找不到指定文件！");
		} catch (IOException ex1) {
			throw new Exception("读写错误:" + ex1.getMessage());
		} catch (NullPointerException ex1) {
			throw new Exception("请指定批处理文件！");
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
					throw new Exception("文件上传出现错误! ");
				}
			}
		} catch (Exception ex) {
			throw new Exception("读入文件时出现错误！");
		}
		return buffer.toString();
	}

	/**
	 * 根据分割符拆分字串
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
	 * 得到参数文件，解析
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
			returns[1] = "地市公司";
			return returns;
		}
		if (StringUtils.equals("Cntycom", orgtype)) {
			returns[0] = "3";
			returns[1] = "分公司";
			return returns;
		}
		if (StringUtils.equals("Svc", orgtype)) {
			returns[0] = "4";
			returns[1] = "服务销售中心";
			return returns;
		}
		if (StringUtils.equals("Ma", orgtype)) {
			returns[0] = "5";
			returns[1] = "微区域";
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
	 * 生成指定长度的随机数,大小写字母加数字组合
	 * 
	 * @param pwdlength
	 *            生成的密码的总长度
	 * @return 密码的字符串
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

			i = Math.abs(r.nextInt(maxnumber)); // 生成的数最大为62-1

			if (i >= 0 && i < ch.length) {
				pwd.append(ch[i]);
				countlength++;
			}
		}

		return pwd.toString();
	}

	/*
	 * 得到指定固定参数的ID/NAME @param 固定参数名称，需返回的字段"id"/"name" @return String[]
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
			throw new Exception("调整规则有误,应该为[" + buf.toString() + "] 中的一种!");
		}
	}

}
