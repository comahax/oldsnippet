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
 * ���˿ͻ���(������ͨ�Ŵ���5Ԫ�ĺ���)
 * @author zhangsiwei
 *
 */
public class AsscustGathering implements Gathering {

	public List<VO> gather(Map factor) {
		
		List<VO> resultList = new ArrayList<VO>();
		// ��ǰ����ID
		String cityid = (String)factor.get("cityid");
		// ���˿ͻ����ļ����Ŀ¼����
		String asscust_path = (String)factor.get(cityid+"_asscust_path");
		if(asscust_path == null) {
			throw new RuntimeException("�����ļ�promotionGatherData.properties������Ϊ "+cityid+"_asscust_path�����Բ����ڣ����ʵ");
		}
		
		// ����ͨ����ʼ����
		String startMonth = (String)factor.get("����ͨ����ʼ����");
		// ����ͨ����ֹ����
		String endMonth = (String)factor.get("����ͨ����ֹ����");
		
		// ��ȡ ��ʼ�·� �� ��ֹ�·� ֮��������·�(������ʼ�·ݺ���ֹ�·�)
		List<String> intervalMonths = getAllMonths(startMonth,endMonth);
		
		// ���˿ͻ����ļ����Ŀ¼
		File dir = new File(asscust_path);
		if(!dir.exists()) {
			throw new RuntimeException("��Ŀ¼������: "+asscust_path);
		}
		if(!dir.isDirectory()) {
			throw new RuntimeException(asscust_path+" ����һ��Ŀ¼");
		}
		// allMonthFlag�ж��Ƿ�ÿ���¶����ļ�
		boolean allExistFlag = true;
		for(int i=0;i<intervalMonths.size();i++) {
			String month = intervalMonths.get(i);
			String fileNameRegex = "bi_asscust_"+month+"00_"+cityid+"_[0-9]{3}"+"_00.txt";
			String[] fileNames = getFileList(dir,fileNameRegex);
			if(fileNames == null || fileNames.length <=0) {
				// ��ĳ���·�û���ļ�
				allExistFlag = false;
				break;
			}
		}
		if(!allExistFlag) {
			// ��ĳ���·�û���ļ������ʾû��һ��������������:"ÿ���¶����ڿ��˿ͻ��ļ���"
			return resultList;
		}else {
			// ��ȡset������շ��������ĺ���ʹ����ֻ����һ��
			Set<String> resultSet = new HashSet<String>();
			for(int i=0;i<intervalMonths.size();i++) {
				String month = intervalMonths.get(i);
				// ��Ÿ����·ݺ����Set
				Set<String> monthNumberSet = new HashSet<String>();
				// ���˿ͻ����ļ����ƣ�bi_asscust_yyyymm00_zz_xxx_00.txt
				String fileNameRegex = "bi_asscust_"+month+"00_"+cityid+"_[0-9]{3}"+"_00.txt";
				String[] fileNames = getFileList(dir,fileNameRegex);
				
				for(int j=0;j<fileNames.length;j++) {
					String fileName = fileNames[j];
					monthNumberSet.addAll(saveNumberToSet(asscust_path,fileName));
				}
				if(i > 0) {
					// ȡ�����·ݵĺ���Ľ���
					resultSet.retainAll(monthNumberSet);
				}else {
					// �Ƚ���һ���·ݵĺ���ȫ���ŵ�resultSet��
					resultSet.addAll(monthNumberSet);
				}
			}
			// �ѽ����װ��VO����
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
	 * ���ļ��еĺ��뱣�浽Set������
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
				// ȥ����������"|"�ָ���
				if(!"".equals(s)) {
					// ������ǿ���
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
	 * ���ݡ����˿ͻ����ļ�����������ʽ[SRCFILENAME]����ȡ�ļ��б�
	 * 
	 * @param srcdir
	 * @param srcFileName
	 * @return
	 */
	private String[] getFileList(File dir, String srcFileName) {
		return dir.list(new DirFilter(srcFileName));
	}
	
	/**
	 * ����ͨ��������ʽ�����ļ��б���ڲ���
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
	 * ��ȡ ��ʼ�·� �� ��ֹ�·� ֮��������·�(������ʼ�·ݺ���ֹ�·�)
	 * @param _startDate ��ʽ��yyyyMMddHHmmss
	 * @param _endDate	  ��ʽ��yyyyMMddHHmmss
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
			throw new RuntimeException("����ͨ����ʼ���£�"+_startDate+" �� ����ͨ����ֹ���£�"+_endDate+" ��ʽ����ȷ����ʽӦΪyyyyMMddHHmmss��");
		}
		if(_startMonthDate.after(_endMonthDate)) {
			throw new RuntimeException("����ͨ����ʼ���£�"+_startDate+" ����  ����ͨ����ֹ���£�"+_endDate+"�� ���ʵ��");
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
//		factor.put("����ͨ����ʼ����", "200909");
//		factor.put("����ͨ����ֹ����", "200912");
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
