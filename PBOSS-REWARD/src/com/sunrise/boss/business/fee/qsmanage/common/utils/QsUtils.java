package com.sunrise.boss.business.fee.qsmanage.common.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sunrise.boss.business.qsmanage.paramrules.impfielddeta.persistent.ImpFieldDetaVO;
import com.sunrise.boss.business.qsmanage.paramrules.imptabledeta.persistent.ImpTableDetaListVO;
import com.sunrise.boss.business.qsmanage.paramrules.imptabledeta.persistent.ImpTableDetaVO;
import com.sunrise.boss.business.qsmanage.paramrules.tabdefine.persistent.TabDefineVO;
import com.sunrise.boss.business.qsmanage.paramsmanage.chghis.persistent.ChgHisVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.export.ExcelCodeToName;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.qsmanage.paramsmanage.chghis.ReqDetaBean;
import com.sunrise.pub.tools.PublicUtils;
import com.sunrise.pub.tools.StringSplit;

/**
 * 
 * @author wangguangying 20090323
 * 更改获取字段，表，主键等方式，原为从配置文件获取，现改为从数据库中获取。
 *
 */
public class QsUtils {

	private final static String SPLIT_KEY = "~";

	private static final String INSERT = "I";

	private static final String UPDATE = "U";

	private static final String DELETE = "D";
	
	/**获取请求详细信息，显示在弹出页面上
	 * @throws Exception 
	 */
	public static List getDetaList(ChgHisVO vo, User user) throws Exception{
		ExcelCodeToName et = new ExcelCodeToName();
		List list = new ArrayList();
		TabDefineVO tabvo = getTabdefine(vo.getTabname(), user);
		String paramname = tabvo.getFieldnamestr();
		String tran = tabvo.getTranslate();
		String[] params = StringSplit.split(paramname, "~");
		String[] trans = StringSplit.split(tran, "~");
		String[] oldvalues = null;
		String[] newvalues = null;

		if (vo.getOldvalue() != null && !"".equals(vo.getOldvalue())) {
			oldvalues = StringSplit.split(vo.getOldvalue(), "~");
		}

		if (vo.getNewvalue() != null && !"".equals(vo.getNewvalue())) {
			newvalues = StringSplit.split(vo.getNewvalue(), "~");
		}

		for (int i = 0; i < params.length; i++) {
			ReqDetaBean bean = new ReqDetaBean();
			bean.setColumn(params[i]);

			if (vo.getOldvalue() != null && !"".equals(vo.getOldvalue())) {
				if (trans[i] == null || "".equals(trans[i])) {
					bean.setOldvalue(oldvalues[i]);
				} else {
					bean.setOldvalue(et
							.codeToName(trans[i], oldvalues[i], user));
				}
			}

			if (vo.getNewvalue() != null && !"".equals(vo.getNewvalue())) {
				if (trans[i] == null || "".equals(trans[i])) {
					bean.setNewvalue(newvalues[i]);
				} else {
					bean.setNewvalue(et
							.codeToName(trans[i], newvalues[i], user));
				}
			}

			list.add(bean);
		}
		return list;
	}
	
	public static TabDefineVO getTabdefine(String tabcode, User user) throws Exception{
		CommonDelegate delegate = new CommonDelegate(TabDefineVO.class);
		return (TabDefineVO) delegate.doFindByPk((Serializable) tabcode, user);
	}
	
	public static ImpTableDetaVO getTabledeta(Class clazz, User user) throws Exception{
		ImpTableDetaListVO listVO = new ImpTableDetaListVO();
		listVO.set_se_entparam(clazz.getName());
		CommonDelegate delegate = new CommonDelegate(ImpTableDetaVO.class);
		DataPackage dp = delegate.doQuery(listVO, user, false);
		if(dp != null && dp.getDatas() != null && dp.getDatas().size() > 0){
			return (ImpTableDetaVO) dp.toList(ImpTableDetaVO.class).get(0);
		}
		return null;
	}

	public static String getUseVO(Class clazz, User user) throws Exception {
		return getTabledeta(clazz, user).getEntfoml();
	}
	public static String getUseVO(Class clazz) throws Exception {
		User newuser = new User();
		newuser.setCityid("999");
		return getUseVO(clazz, newuser);
	}
	public static String getTableName(Class voClass, User user) throws Exception {
		return getTabledeta(voClass, user).getTabfoml();
	}

	public static String[] getTablePKName(Class voClass, User user) throws Exception {
		return getTabledeta(voClass, user).getMainfield().split(SPLIT_KEY);
	}

	public static String[] getPropertyName(String keyvalue) {

		if (null != keyvalue) {
			return StringSplit.split(keyvalue, SPLIT_KEY);
		}
		return null;
	}

	// 获取某个vo的主键串
	public static String getTablePKStr(Class voClass, User user) throws Exception {

		String[] pk = getTablePKName(voClass, user);
		if (null != pk) {
			String str_pk = "";
			for (int i = 0; i < pk.length; i++) {
				str_pk = str_pk + pk[i] + SPLIT_KEY;
			}
			return str_pk;
		}
		return "";
	}

	// 获取某个vo的主键值串
	public static String getTablePkStrValue(Object clazzvo, User user) throws Exception {

		String[] pk = getTablePKName(clazzvo.getClass(), user);
		if (null != pk) {
			String str_pkvalue = "";
			for (int i = 0; i < pk.length; i++) {
				Object ob = BeanUtils.getProperty(clazzvo, pk[i]);
				str_pkvalue = str_pkvalue + ob.toString() + SPLIT_KEY;
			}
			return str_pkvalue;
		}
		return "";
	}

	// 获取某个vo的一定字段的值串
	public static String getPropertyStrValue(Object clazzvo, String[] key)
			throws Exception {

		if (null != key) {
			String str_pkvalue = "";
			for (int i = 0; i < key.length; i++) {
				Object ob = BeanUtils.getProperty(clazzvo, key[i]);
				str_pkvalue = str_pkvalue + ob.toString() + SPLIT_KEY;
			}
			return str_pkvalue;
		}
		return "";
	}

	// A： “操作类型”：根据上一次的修改类型与本次的修改类型进行按照如下运算法则取值：I+U=I;I+D=撤消请求;U+U=U;U+D=D;
	// D+I=U
	public static String getOperType(String oldopertype, String newopertype)
			throws Exception {

		if (newopertype.equals(oldopertype)) {
			if (INSERT.equals(newopertype)) { // II 报错
				throw new Exception(
						"请求表数据有误：oldopertype = insert ，newopertype = insert ");
			}
			return newopertype;

		} else if (UPDATE.equals(oldopertype) && INSERT.equals(newopertype)) { // 这种情况要报错
			throw new Exception(
					"请求表数据有误：oldopertype = update ，newopertype = insert ");

		} else if (UPDATE.equals(oldopertype) && DELETE.equals(newopertype)) {
			return DELETE;

		} else if (INSERT.equals(oldopertype) && UPDATE.equals(newopertype)) {
			return INSERT;

		} else if (INSERT.equals(oldopertype) && DELETE.equals(newopertype)) {
			return DELETE;

		} else if (DELETE.equals(oldopertype) && INSERT.equals(newopertype)) {
			return UPDATE;

		} else if (DELETE.equals(oldopertype) && UPDATE.equals(newopertype)) {
			return DELETE;
		}

		return newopertype; // 如果oldopertype为空
	}

	/**检查导入数据类型*/
	public static Object checkVarible(ImpFieldDetaVO vo, String item)
			throws Exception {
		if (vo.getFieldtype().equals("Long")) {
			try {
				Long tmp = Long.valueOf(item);
				return tmp;
			} catch (NumberFormatException ex) {
				throw new NumberFormatException(vo.getFieldname() + "[" + item
						+ "]应该是数字！");
			}
		} else if (vo.getFieldtype().equals("Double")) {

			try {
				Double tmp = Double.valueOf(item);
				return tmp;
			} catch (NumberFormatException ex) {
				throw new NumberFormatException(vo.getFieldname() + "[" + item
						+ "]应该是数字！");
			}

		} else if (vo.getFieldtype().equals("Short")) {

			try {
				Short tmp = Short.valueOf(item);
				return tmp;
			} catch (NumberFormatException ex) {
				throw new NumberFormatException(vo.getFieldname() + "[" + item
						+ "]应该是数字！");
			}

		} else if (vo.getFieldtype().equals("Integer")) {

			try {
				Integer tmp = Integer.valueOf(item);
				return tmp;
			} catch (NumberFormatException ex) {
				throw new NumberFormatException(vo.getFieldname() + "[" + item
						+ "]应该是数字！");
			}

		} else if (vo.getFieldtype().equals("Float")) {

			try {
				Float tmp = Float.valueOf(item);
				return tmp;
			} catch (NumberFormatException ex) {
				throw new NumberFormatException(vo.getFieldname() + "[" + item
						+ "]应该是数字！");
			}

		} else if (vo.getFieldtype().equals("Date")) {
			try {
				if (item.length() == 19) {
					PublicUtils.UtilStrToDate(item);
					return item;
				} else if (item.length() == 10) {
					PublicUtils.UtilStrToDate(item, "yyyy-MM-dd");
					return item;
				} else {
					throw new Exception("");
				}
			} catch (Exception e) {
				throw new Exception(vo.getFieldname() + "[" + item
						+ "]应该是日期类型！");
			}
		} else if (vo.getFieldtype().equals("java.sql.Date")) {
			try {
				if (item.length() == 19) {
					return PublicUtils
							.strToSqlDate(item, "yyyy-MM-dd HH:mm:ss");
				} else if (item.length() == 10) {
					return PublicUtils.strToSqlDate(item, "yyyy-MM-dd");
				} else {
					throw new Exception("");
				}
			} catch (Exception e) {
				throw new Exception(vo.getFieldname() + "[" + item
						+ "]应该是日期类型！");
			}
		} else {
			return item;
		}
	}
}
