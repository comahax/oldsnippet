package com.gmcc.pboss.common.utils.tools;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




/**
 * 应用于促销管理模块的业务工具类
 * 
 * @author zhangsw
 * @version 1.0
 */
public class BusinessUtils {

	/**
	 * 将参数串解析成Map保存起来，其中key装载参数名，value装载对应的参数值
	 * 
	 * @param paramString
	 *            : "key1=value1;key2=value2;..."
	 * @return Map [key1=value1,key2=value2,.....]
	 */
	public static Map parseParam2Map(String paramString) {
		Map paramMap = new HashMap();
		if(!"".equals(paramString)){
		
			String[] paramArr = paramString.trim().split(";");
			
			for (String paramKV : paramArr) {
				int pos = paramKV.trim().indexOf("=");
				String paramName = paramKV.substring(0, pos);
	//			String paramValue = "";
	//			// 若某个参数没有值，则paramValue为"";
	//			if (pos < paramKV.length() - 1) {
	//				paramValue = paramKV.substring(pos + 1);
	//			}
				String paramValue = paramKV.substring(pos + 1);
				paramMap.put(paramName, paramValue);
			}
		}
		return paramMap;
	}

	/**
	 * 将参数串中的value部分按顺序放到List中保存起来
	 * 
	 * @param paramString
	 *            : "key1=value1;key2=value2;..."
	 * @return List<String> [value1,value2,....]
	 */
	public static List<String> parseParam2List(String paramString) {
		String[] paramArr = paramString.split(";");
		List<String> paramValueList = new ArrayList<String>();
		for (String paramKV : paramArr) {
			int pos = paramKV.indexOf("=");
			String paramValue = "";
			// 若某个参数没有值，则paramValue为"";
			if (pos < paramKV.length() - 1) {
				paramValue = paramKV.substring(pos + 1);
			}
			paramValueList.add(paramValue);
		}
		return paramValueList;
	}
	
	/**
	 * 去掉参数串srcParamStr中没有值的参数
	 * @param srcParamStr
	 * @return 返回所有有值的参数
	 */
	public static String paramFiltering(String srcParamStr) {
		String[] paramArr = srcParamStr.split(";");
		StringBuffer resultBuf = new StringBuffer("");
		for(int i=0;i<paramArr.length;i++) {
			int pos = paramArr[i].indexOf("=");
			if(pos < paramArr[i].length()-1) {
				resultBuf.append(paramArr[i]+";");
			}
		}
		return resultBuf.toString();
	}

	
	/**
	 * <pre>
	 * 重组SQL查询语句: 根据参数串paramStr，忽略查询条件中没有值的参数，
	 * 将SQL语句中的@paramName@ 用其对应的值替换掉
	 * </pre>
	 * 
	 * @param srcQueryString
	 *            源SQL查询语句
	 * @param paramStr
	 *            参数串
	 * @return 重组后的SQL查询语句
	 */
	public static String reformQueryString(String srcQueryString,String paramStr) {
		
		srcQueryString = srcQueryString.trim();
		// 去掉所有换行符，避免windows和UNIX系统换行符不同导致的问题
		srcQueryString = srcQueryString.replaceAll("(\n\r|\r\n|\n|\r)", " ");
		int length = srcQueryString.length();
		String lastChar = srcQueryString.substring(length-1, length);
		// 如果SQL结尾含有分号";",则去掉分号
		if(";".equals(lastChar)) {
			srcQueryString = srcQueryString.substring(0,length-1);
		}
		if(srcQueryString.indexOf("@") == -1 || paramStr == null) {
			// sql中无动态参数
			return srcQueryString;
		}
		StringBuffer tempBuf = new StringBuffer();
		String[] paramArr = paramStr.split(";");
		Map paramMap = parseParam2Map(paramStr);
//		List<String> noValueParams = new ArrayList<String>();
//		List<String> haveValueParams = new ArrayList<String>();
//		for (String param : paramArr) {
//			int pos = param.indexOf("=");
//			if (pos == param.length() - 1) {
//				noValueParams.add(param.substring(0, pos));
//			}else {
//				haveValueParams.add(param.substring(0,pos));
//			}
//		}
		
//		for(String hvParam : haveValueParams) {
//			Pattern p = Pattern.compile("(@([^@]*)?)"+hvParam+"([^@]*)?@"); //懒惰匹配
//			Matcher m = p.matcher(srcQueryString);
//			if(m.find()) {
//				String matchStr = m.group();
//				srcQueryString = srcQueryString.replace(matchStr, (String)paramMap.get(hvParam));
//			}
//			
//		}
		
/*//		if(noValueParams.size() > 0) {
		
			// listIndex记录无值参数列表noValueParams的遍历位置
			int listIndex = 0;
			// 先把SQL 语句按'where'字符串划分区域
			String[] splitQueryByWhere = srcQueryString.split("(?i)where");
			tempBuf.append(splitQueryByWhere[0]);
//			String regex = "=|<|<=|>|>=|!=|<>|(?i)not|(?i)like|(?i)in";
			String regex = "(?i)and|(?i)or|(?i)where|(?i)group|\\)";
			String noValueParam = noValueParams.get(listIndex);
			// 因为带@号的条件参数肯定位于where 的右边，
			// 所以第一个where子句前面的sql不必考虑,因此下标由1开始
			for (int index = 1; index < splitQueryByWhere.length; index++) {
				String[] splitQueryBySpace = splitQueryByWhere[index].split("\\s+");
				boolean noValue = false;
				for (int i = 0; i < splitQueryBySpace.length; i++) {
					Pattern p = Pattern.compile("(@([^@]*)?)"+noValueParam+"([^@]*)?@");
					Matcher m = p.matcher(splitQueryBySpace[i]);
					
					if (listIndex < noValueParams.size()
							&& (m.find())) {
						noValue = true;
						int j = i;
//						if(splitQueryBySpace[i].matches(".*(>|>=|<|<=).*")) {
//							splitQueryBySpace[i] = "1=1";
//						}else {
						while (j>0 && !splitQueryBySpace[--j].matches(regex)); // 无值参数所在的条件代码段(位于无值参数前面)
						for (; j < i-1;) {
							splitQueryBySpace[++j] = "";
						}
						j = i;
						while(j < splitQueryBySpace.length-1 && !splitQueryBySpace[++j].matches(regex)); // 无值参数所在的条件代码段(位于无值参数后面)
						boolean isEnd = false;
						if(j == splitQueryBySpace.length-1)
							isEnd = true;
						if(isEnd) {
							// 若已到某个where分组的末尾，从最后一个分组元素开始替换
							for(;j>i;) { 
								splitQueryBySpace[j--] = "";
							}
						}else {
							// 若未到某个where分组的末尾，从倒数第二个分组元素开始替换
							for(;j>i+1;) {
								splitQueryBySpace[--j] = "";
							}
						}
						
//						splitQueryBySpace[i] =  splitQueryBySpace[i].replace("@" + noValueParam + "@", "1=1");
//						if(splitQueryBySpace[i].matches("[^@]*\\)")) {
//							splitQueryBySpace[i] = "1=1)";
//						}else {
							splitQueryBySpace[i] = "1=1";
//						}
//						}
	
						if (++listIndex < noValueParams.size()) {
							noValueParam = noValueParams.get(listIndex);
						}
					}
				}*/
				for(Iterator it = paramMap.keySet().iterator();it.hasNext();) {
					String paramName = (String)it.next();
					Pattern p = Pattern.compile("(@([^@]*)?)"+paramName+"(([^@]*)?@)"); //懒惰匹配
					Matcher m = p.matcher(srcQueryString);
					if(m.find()) {
						String matchStr = m.group();
						srcQueryString = srcQueryString.replace(matchStr, (String)paramMap.get(paramName));
					}
					
				}
				if(srcQueryString.indexOf("@") > -1) {
						// listIndex记录无值参数列表noValueParams的遍历位置
//						int listIndex = 0;
						// 先把SQL 语句按'where'字符串划分区域
						String[] splitQueryByWhere = srcQueryString.split("(?i)where");
						tempBuf.append(splitQueryByWhere[0]);
//						String regex = "=|<|<=|>|>=|!=|<>|(?i)not|(?i)like|(?i)in";
						String regex = "(?i)and|(?i)or|(?i)where|(?i)group|\\)";
//						String noValueParam = noValueParams.get(listIndex);
						// 因为带@号的条件参数肯定位于where 的右边，
						// 所以第一个where子句前面的sql不必考虑,因此下标由1开始
						for (int index = 1; index < splitQueryByWhere.length; index++) {
							String[] splitQueryBySpace = splitQueryByWhere[index].split("\\s+");
							boolean noValue = false;
							for (int i = 0; i < splitQueryBySpace.length; i++) {
								Pattern p = Pattern.compile("@([^@]*)?@");
								Matcher m = p.matcher(splitQueryBySpace[i]);
								
								if ((m.find())) {
									noValue = true;
									int j = i;
//									if(splitQueryBySpace[i].matches(".*(>|>=|<|<=).*")) {
//										splitQueryBySpace[i] = "1=1";
//									}else {
									while (j>0 && !splitQueryBySpace[--j].matches(regex)); // 无值参数所在的条件代码段(位于无值参数前面)
									for (; j < i-1;) {
										splitQueryBySpace[++j] = "";
									}
									j = i;
									while(j < splitQueryBySpace.length-1 && !splitQueryBySpace[++j].matches(regex)); // 无值参数所在的条件代码段(位于无值参数后面)
									boolean isEnd = false;
									if(j == splitQueryBySpace.length-1)
										isEnd = true;
									if(isEnd) {
										// 若已到某个where分组的末尾，从最后一个分组元素开始替换
										for(;j>i;) {
											splitQueryBySpace[j--] = "";
										}
									}else {
										// 若未到某个where分组的末尾，从倒数第二个分组元素开始替换
										for(;j>i+1;) {
											splitQueryBySpace[--j] = "";
										}
									}
									
//									splitQueryBySpace[i] =  splitQueryBySpace[i].replace("@" + noValueParam + "@", "1=1");
//									if(splitQueryBySpace[i].matches("[^@]*\\)")) {
//										splitQueryBySpace[i] = "1=1)";
//									}else {
										splitQueryBySpace[i] = "1=1";
//									}
//									}
				
//									if (++listIndex < noValueParams.size()) {
//										noValueParam = noValueParams.get(listIndex);
//									}
								}
							}
				tempBuf.append(" WHERE ");
				if (noValue) {
					for (int i = 0; i < splitQueryBySpace.length; i++) {
						tempBuf.append(" " + splitQueryBySpace[i]);
					}
				} else {
					tempBuf.append(splitQueryByWhere[index]);
				}
			}
			return tempBuf.toString();
		}else {
			return srcQueryString;
		}
		
	}
	
	/**
	 * 返回指定月的上一个月的第一天 时间重置为 0时0分0秒
	 * @param curDate
	 * @return
	 */
	public static Date getLastMonthFirstDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -1);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND,0);
		return cal.getTime();
	}


	public static void setParamter(PreparedStatement pstmt, String paramClass,
			int paramIndex, String paramValueStr) throws Exception {
		if ("java.lang.String".equalsIgnoreCase(paramClass)
				|| "java.lang.Character".equalsIgnoreCase(paramClass)) {
			pstmt.setString(paramIndex, paramValueStr);
		} else if ("java.lang.Integer".equalsIgnoreCase(paramClass)) {
			pstmt.setInt(paramIndex, new Integer(paramValueStr));
		} else if ("java.lang.Long".equalsIgnoreCase(paramClass)) {
			pstmt.setLong(paramIndex, new Long(paramValueStr));
		} else if ("java.lang.Double".equalsIgnoreCase(paramClass)) {
			pstmt.setDouble(paramIndex, new Double(paramValueStr));
		} else if ("java.lang.Float".equalsIgnoreCase(paramClass)) {
			pstmt.setFloat(paramIndex, new Float(paramValueStr));
		} else if ("java.lang.Short".equalsIgnoreCase(paramClass)) {
			pstmt.setShort(paramIndex, new Short(paramValueStr));
		} else if ("java.lang.Byte".equalsIgnoreCase(paramClass)) {
			pstmt.setByte(paramIndex, new Byte(paramValueStr));
		} else if ("java.util.Date".equalsIgnoreCase(paramClass)) {
			java.util.Date date = null;
			if (paramValueStr.length() == 4) { // yyyy
				date = new SimpleDateFormat("yyyy").parse(paramValueStr);
			} else if (paramValueStr.length() == 6) { // yyyyMM
				date = new SimpleDateFormat("yyyyMM").parse(paramValueStr);
			} else if (paramValueStr.length() == 8) { // yyyyMMdd
				date = new SimpleDateFormat("yyyyMMdd").parse(paramValueStr);
			} else { // yyyyMMddHHmmss
				date = new SimpleDateFormat("yyyyMMddHHmmss")
						.parse(paramValueStr);
			}
			pstmt.setTimestamp(paramIndex, new Timestamp(date.getTime()));
		}
	}

	public static void main(String[] args) throws Exception {
		
//		System.out
//				.println(BusinessUtils
//						.reformQueryString(
//								""
//										+ "SELECT CITYID,WAYID,'ALL' COMKIND, COUNT(*) BUSIVALUE FROM "
//										+ "(select * from table where id<@ID@ and sid>=@SID@ and name like @NAME@ and age not in @AGE@) DUAL "
//										+ "WHERE ACTIVETIME >= to_date(@STARTTIME@,'yyyyMMdd') AND ACTIVETIME<=to_date(@ENDTIME@,'yyyyMMdd') GROUP BY CITYID,WAYID;",
//								"SID=1;NAME=alvin;STARTTIME=20090501;ENDTIME=20090807;"));
		System.out.println(BusinessUtils.reformQueryString("SELECT A.WAYID WAYID, B.COMCATEGORY COMCATEGORY, C.COMRESID RESID, 1 BUSIVALUE"+
  " FROM FX_SW_ORDER A, FX_SW_ORDERRESDET B, IM_FX_COMRESSMP C" +
  " WHERE A.ORDERID = B.ORDERID " +
   " AND B.COMRESID = C.COMRESID " +
   " AND B.RESTYPE = 'COMRESSMP'"+
   " AND B.ORDERCOMTYPE IN ('CUSTORDER', 'SYSTIEIN')"+ 
   " AND A.STORAREA IN (@CHECKBOX:资源库区{NODIS:未分配;ZG:直供;LS:连锁;BD:保底;DHH:订货会;}@)"+
   " AND A.CREATETIME >= TO_DATE('@DATE:订货起始时间{START}@', 'yyyymmddhh24miss')"+
   " AND A.CREATETIME <= TO_DATE('@DATE:订货终止时间{END}@', 'yyyymmddhh24miss')"+
   " AND C.COMACTIVE >= TO_DATE('@DATE:套卡有效起始时间{START}@', 'yyyymmddhh24miss')"+
   " AND C.COMACTIVE <= TO_DATE('@DATE:套卡有效终止时间{END}@', 'yyyymmddhh24miss');", "资源库区='NODIS','ZG';"));
		
	}
	
}
