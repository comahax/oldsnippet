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
 * Ӧ���ڴ�������ģ���ҵ�񹤾���
 * 
 * @author zhangsw
 * @version 1.0
 */
public class BusinessUtils {

	/**
	 * ��������������Map��������������keyװ�ز�������valueװ�ض�Ӧ�Ĳ���ֵ
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
	//			// ��ĳ������û��ֵ����paramValueΪ"";
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
	 * ���������е�value���ְ�˳��ŵ�List�б�������
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
			// ��ĳ������û��ֵ����paramValueΪ"";
			if (pos < paramKV.length() - 1) {
				paramValue = paramKV.substring(pos + 1);
			}
			paramValueList.add(paramValue);
		}
		return paramValueList;
	}
	
	/**
	 * ȥ��������srcParamStr��û��ֵ�Ĳ���
	 * @param srcParamStr
	 * @return ����������ֵ�Ĳ���
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
	 * ����SQL��ѯ���: ���ݲ�����paramStr�����Բ�ѯ������û��ֵ�Ĳ�����
	 * ��SQL����е�@paramName@ �����Ӧ��ֵ�滻��
	 * </pre>
	 * 
	 * @param srcQueryString
	 *            ԴSQL��ѯ���
	 * @param paramStr
	 *            ������
	 * @return ������SQL��ѯ���
	 */
	public static String reformQueryString(String srcQueryString,String paramStr) {
		
		srcQueryString = srcQueryString.trim();
		// ȥ�����л��з�������windows��UNIXϵͳ���з���ͬ���µ�����
		srcQueryString = srcQueryString.replaceAll("(\n\r|\r\n|\n|\r)", " ");
		int length = srcQueryString.length();
		String lastChar = srcQueryString.substring(length-1, length);
		// ���SQL��β���зֺ�";",��ȥ���ֺ�
		if(";".equals(lastChar)) {
			srcQueryString = srcQueryString.substring(0,length-1);
		}
		if(srcQueryString.indexOf("@") == -1 || paramStr == null) {
			// sql���޶�̬����
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
//			Pattern p = Pattern.compile("(@([^@]*)?)"+hvParam+"([^@]*)?@"); //����ƥ��
//			Matcher m = p.matcher(srcQueryString);
//			if(m.find()) {
//				String matchStr = m.group();
//				srcQueryString = srcQueryString.replace(matchStr, (String)paramMap.get(hvParam));
//			}
//			
//		}
		
/*//		if(noValueParams.size() > 0) {
		
			// listIndex��¼��ֵ�����б�noValueParams�ı���λ��
			int listIndex = 0;
			// �Ȱ�SQL ��䰴'where'�ַ�����������
			String[] splitQueryByWhere = srcQueryString.split("(?i)where");
			tempBuf.append(splitQueryByWhere[0]);
//			String regex = "=|<|<=|>|>=|!=|<>|(?i)not|(?i)like|(?i)in";
			String regex = "(?i)and|(?i)or|(?i)where|(?i)group|\\)";
			String noValueParam = noValueParams.get(listIndex);
			// ��Ϊ��@�ŵ����������϶�λ��where ���ұߣ�
			// ���Ե�һ��where�Ӿ�ǰ���sql���ؿ���,����±���1��ʼ
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
						while (j>0 && !splitQueryBySpace[--j].matches(regex)); // ��ֵ�������ڵ����������(λ����ֵ����ǰ��)
						for (; j < i-1;) {
							splitQueryBySpace[++j] = "";
						}
						j = i;
						while(j < splitQueryBySpace.length-1 && !splitQueryBySpace[++j].matches(regex)); // ��ֵ�������ڵ����������(λ����ֵ��������)
						boolean isEnd = false;
						if(j == splitQueryBySpace.length-1)
							isEnd = true;
						if(isEnd) {
							// ���ѵ�ĳ��where�����ĩβ�������һ������Ԫ�ؿ�ʼ�滻
							for(;j>i;) { 
								splitQueryBySpace[j--] = "";
							}
						}else {
							// ��δ��ĳ��where�����ĩβ���ӵ����ڶ�������Ԫ�ؿ�ʼ�滻
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
					Pattern p = Pattern.compile("(@([^@]*)?)"+paramName+"(([^@]*)?@)"); //����ƥ��
					Matcher m = p.matcher(srcQueryString);
					if(m.find()) {
						String matchStr = m.group();
						srcQueryString = srcQueryString.replace(matchStr, (String)paramMap.get(paramName));
					}
					
				}
				if(srcQueryString.indexOf("@") > -1) {
						// listIndex��¼��ֵ�����б�noValueParams�ı���λ��
//						int listIndex = 0;
						// �Ȱ�SQL ��䰴'where'�ַ�����������
						String[] splitQueryByWhere = srcQueryString.split("(?i)where");
						tempBuf.append(splitQueryByWhere[0]);
//						String regex = "=|<|<=|>|>=|!=|<>|(?i)not|(?i)like|(?i)in";
						String regex = "(?i)and|(?i)or|(?i)where|(?i)group|\\)";
//						String noValueParam = noValueParams.get(listIndex);
						// ��Ϊ��@�ŵ����������϶�λ��where ���ұߣ�
						// ���Ե�һ��where�Ӿ�ǰ���sql���ؿ���,����±���1��ʼ
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
									while (j>0 && !splitQueryBySpace[--j].matches(regex)); // ��ֵ�������ڵ����������(λ����ֵ����ǰ��)
									for (; j < i-1;) {
										splitQueryBySpace[++j] = "";
									}
									j = i;
									while(j < splitQueryBySpace.length-1 && !splitQueryBySpace[++j].matches(regex)); // ��ֵ�������ڵ����������(λ����ֵ��������)
									boolean isEnd = false;
									if(j == splitQueryBySpace.length-1)
										isEnd = true;
									if(isEnd) {
										// ���ѵ�ĳ��where�����ĩβ�������һ������Ԫ�ؿ�ʼ�滻
										for(;j>i;) {
											splitQueryBySpace[j--] = "";
										}
									}else {
										// ��δ��ĳ��where�����ĩβ���ӵ����ڶ�������Ԫ�ؿ�ʼ�滻
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
	 * ����ָ���µ���һ���µĵ�һ�� ʱ������Ϊ 0ʱ0��0��
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
   " AND A.STORAREA IN (@CHECKBOX:��Դ����{NODIS:δ����;ZG:ֱ��;LS:����;BD:����;DHH:������;}@)"+
   " AND A.CREATETIME >= TO_DATE('@DATE:������ʼʱ��{START}@', 'yyyymmddhh24miss')"+
   " AND A.CREATETIME <= TO_DATE('@DATE:������ֹʱ��{END}@', 'yyyymmddhh24miss')"+
   " AND C.COMACTIVE >= TO_DATE('@DATE:�׿���Ч��ʼʱ��{START}@', 'yyyymmddhh24miss')"+
   " AND C.COMACTIVE <= TO_DATE('@DATE:�׿���Ч��ֹʱ��{END}@', 'yyyymmddhh24miss');", "��Դ����='NODIS','ZG';"));
		
	}
	
}
