package com.gmcc.pboss.gathering;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import open.tool.rule.data.VO;

import com.gmcc.pboss.business.promotion.elmttmpl.DefaultVO;

/**
 * 考核客户数(即主动通信大于5元的号码)
 * @author zhangsiwei
 *
 */
public class AsscustGathering implements Gathering {

	public List<VO> gather(Map factor) {
		
		List<VO> resultList = new ArrayList<VO>();
		// 当前地市ID
		String cityid = (String)factor.get("cityid");
		// 考核客户数文件存放目录名称
		String asscust_path = (String)factor.get(cityid+"_asscust_path");
		if(asscust_path == null) {
			throw new RuntimeException("配置文件promotionGatherData.properties中名称为 "+cityid+"_asscust_path的属性不存在，请核实");
		}
		
		// 主动通信起始年月
		String startMonth = (String)factor.get("主动通信起始年月");
		// 主动通信终止年月
		String endMonth = (String)factor.get("主动通信终止年月");
		
		// 获取 起始月份 到 终止月份 之间的所有月份(包括起始月份和终止月份)
		List<String> intervalMonths = getAllMonths(startMonth,endMonth);
		
		// 考核客户数文件存放目录
		File dir = new File(asscust_path);
		if(!dir.exists()) {
			throw new RuntimeException("该目录不存在: "+asscust_path);
		}
		if(!dir.isDirectory()) {
			throw new RuntimeException(asscust_path+" 不是一个目录");
		}
		// allMonthFlag判断是否每个月都有文件
		boolean allExistFlag = true;
		for(int i=0;i<intervalMonths.size();i++) {
			String month = intervalMonths.get(i);
			String fileNameRegex = "bi_asscust_"+month+"00_"+cityid+"_[0-9]{3}"+"_00.txt";
			String[] fileNames = getFileList(dir,fileNameRegex);
			if(fileNames == null || fileNames.length <=0) {
				// 若某个月份没有文件
				allExistFlag = false;
				break;
			}
		}
		if(!allExistFlag) {
			// 若某个月份没有文件，则表示没有一个号码满足条件:"每个月都存在考核客户文件中"
			return resultList;
		}else {
			// 采取set存放最终符合条件的号码使号码只出现一次
			Set<String> resultSet = new HashSet<String>();
			for(int i=0;i<intervalMonths.size();i++) {
				String month = intervalMonths.get(i);
				// 存放各个月份号码的Set
				Set<String> monthNumberSet = new HashSet<String>();
				// 考核客户数文件名称：bi_asscust_yyyymm00_zz_xxx_00.txt
				String fileNameRegex = "bi_asscust_"+month+"00_"+cityid+"_[0-9]{3}"+"_00.txt";
				String[] fileNames = getFileList(dir,fileNameRegex);
				
				for(int j=0;j<fileNames.length;j++) {
					String fileName = fileNames[j];
					monthNumberSet.addAll(saveNumberToSet(asscust_path,fileName));
				}
				if(i > 0) {
					// 取各个月份的号码的交集
					resultSet.retainAll(monthNumberSet);
				}else {
					// 先将第一个月份的号码全部放到resultSet中
					resultSet.addAll(monthNumberSet);
				}
			}
			// 把结果封装到VO里面
			for(Iterator<String> it = resultSet.iterator();it.hasNext();) {
				String number = it.next();
				DefaultVO defaultVo = new DefaultVO();
				HashMap<String, Object> keys = new HashMap<String, Object>();
				keys.put("RESID", number);
				defaultVo.setKeys(keys);
				resultList.add(defaultVo);
			}
			return resultList;
		}
		
	}
	
	/**
	 * 把文件中的号码保存到Set集合中
	 * @param dir
	 * @param fileName
	 * @return
	 */
	private Set<String> saveNumberToSet(String dir,String fileName) {
		Set<String> numberSet = new HashSet<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(dir + "/" + fileName)));
			String s = "";
			while ((s = br.readLine()) != null) {
				// 去掉号码后面的"|"分隔符
				if(!"".equals(s)) {
					// 如果不是空行
					s = s.substring(0, s.length()-1);
					numberSet.add(s);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return numberSet;
	}
	
	/**
	 * 根据“考核客户数文件名称正则表达式[SRCFILENAME]”获取文件列表
	 * 
	 * @param srcdir
	 * @param srcFileName
	 * @return
	 */
	private String[] getFileList(File dir, String srcFileName) {
		return dir.list(new DirFilter(srcFileName));
	}
	
	/**
	 * 用于通过正则表达式过滤文件列表的内部类
	 * 
	 * @author zhangsiwei
	 * 
	 */
	protected class DirFilter implements FilenameFilter {

		private Pattern pattern;

		public DirFilter(String regex) {
			pattern = Pattern.compile(regex);
		}

		public boolean accept(File dir, String name) {
			return pattern.matcher(name).matches();
		}
	}

	/**
	 * 获取 起始月份 到 终止月份 之间的所有月份(包括起始月份和终止月份)
	 * @param _startDate 格式：yyyyMMddHHmmss
	 * @param _endDate	  格式：yyyyMMddHHmmss
	 * @return
	 */
	private List<String> getAllMonths(String _startDate,String _endDate) {
		List<String> result = new ArrayList<String>();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat monthFormat = new SimpleDateFormat("yyyyMM");
		Date _startMonthDate = null;
		Date _endMonthDate = null;
		try {
			_startMonthDate = format.parse(_startDate);
			_endMonthDate = format.parse(_endDate);
		} catch (ParseException e) {
			throw new RuntimeException("主动通信起始年月："+_startDate+" 或 主动通信终止年月："+_endDate+" 格式不正确。格式应为yyyyMMddHHmmss。");
		}
		if(_startMonthDate.after(_endMonthDate)) {
			throw new RuntimeException("主动通信起始年月："+_startDate+" 晚于  主动通信终止年月："+_endDate+"。 请核实。");
		}
		
		Calendar _startCal = Calendar.getInstance();
		Calendar _endCal = Calendar.getInstance();
		_startCal.setTime(_startMonthDate);
		_endCal.setTime(_endMonthDate);
		String _startMonth = monthFormat.format(_startMonthDate);
		String _endMonth = monthFormat.format(_endMonthDate);
		
		while(true) {
			if(_startMonth.equals(_endMonth)) {
				result.add(_startMonth);
				break;
			}
			String tempMonth = monthFormat.format(_startCal.getTime());
			if(_endMonth.equals(tempMonth)) {
				result.add(tempMonth);
				break;
			}else {
				_startCal.add(Calendar.MONTH, 1);
				result.add(tempMonth);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		AsscustGathering gather = new AsscustGathering();
		List<String> result = gather.getAllMonths("20090922000000", "20091222235959");

		for(String month : result) {
			System.out.println(month);
		}
		
//		String[] fileNames = gather.getFileList(new File("D:/workspace/pbossbgprocess/asscust"), "bi_asscust_20091000_ZS_[0-9]{3}_00.txt");
//		for(String fileName : fileNames) {
//			System.out.println(fileName);
//		}
//		Map factor = new HashMap();
//		factor.put("cityid", "ZS");
//		factor.put("主动通信起始年月", "200909");
//		factor.put("主动通信终止年月", "200912");
//		List<VO> resultList = gather.gather(factor);
//
//		for(int i=0;i<resultList.size();i++) {
//			DefaultVO defaultVo = (DefaultVO)resultList.get(i);
//			Map<String, ?> keys = defaultVo.getKeys();
//			Set<String> keySet = keys.keySet();
//			for(Iterator<String> it = keySet.iterator();it.hasNext();) {
//				String key = it.next();
//				Object keyValue = keys.get(key);
//				System.out.println(key+": "+keyValue);
//			}
//		}
	}
}
