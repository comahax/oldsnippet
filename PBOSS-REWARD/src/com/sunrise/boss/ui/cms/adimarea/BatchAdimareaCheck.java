package com.sunrise.boss.ui.cms.adimarea;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.delegate.cms.adimarea.AdimareaDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;

public class BatchAdimareaCheck extends BaseCheckFormat {
	public BatchAdimareaCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (rowCount > 10000) {
			throw new Exception("文件行数不能超过10000行");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		// String[] items = line.split("\\|");
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		// 检查列数
		if (items.length != 15) {
			throw new Exception("上传数据列数不对,应为15列,请查看说明帮助!");
		}
		AdimareaDelegate delegate = new AdimareaDelegate();
		if (items[0] == null || "".equals(items[0].trim())
				|| items[0].length() > 18)
			throw new Exception("[行政区划编码]不能为空，也不能大于18位!");
		if (delegate.doFindByPk(items[0], user) == null) {// 新增
			if (items[1].length() > 64)
				throw new Exception("[行政区划名称]过长！必须不大于32个字");
			if (!"null".equals(items[2]) && !"空".equals(items[2])
					&& !"".equals(items[2].trim())) {
				try { // 检查items[2]是否为数字
					Double temp = Double.valueOf(items[2]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[行政区划类型编码]类型不对(" + items[2]
							+ "),应该是数字字符串!");
				}
				if (items[2].getBytes().length > 2)
					throw new Exception("[行政区划类型编码]过长！必须不大于2位");
			}
			if (!"null".equals(items[3]) && !"空".equals(items[3])
					&& !"".equals(items[3].trim())) {
				try { // 检查items[3]是否为数字
					Double temp = Double.valueOf(items[3]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[行政区划级别编码]类型不对(" + items[3]
							+ "),应该是数字字符串!");
				}
				if (items[3].getBytes().length > 2)
					throw new Exception("[行政区划级别编码]过长！必须不大于2位");
			}
			if (items[4].length() > 18)
				throw new Exception("[上级行政区划编码]过长！必须不大于18位");
			if (!"null".equals(items[5]) && !"空".equals(items[5])
					&& !"".equals(items[5].trim())) {
				try { // 检查items[5]是否为数字
					Double temp = Double.valueOf(items[5]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[数据统计年度]类型不对(" + items[5]
							+ "),应该是数字字符串!");
				}
				if (items[5].getBytes().length > 4)
					throw new Exception("[数据统计年度]过长！必须不大于4位");
			}
			if (!"null".equals(items[6]) && !"空".equals(items[6])
					&& !"".equals(items[6].trim())) { 
			try { // 检查items[6]是否为数字
				Double temp = Double.valueOf(items[6]);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("[辖区人口数]类型不对(" + items[6] + "),应该是数字字符串!");
			}
			if (items[6].getBytes().length > 10)
				throw new Exception("[辖区人口数]过长！必须不大于10位");
			}
			
			if (!"null".equals(items[7]) && !"空".equals(items[7])
					&& !"".equals(items[7].trim())) {
				try { // 检查items[7]是否为数字
					Double temp = Double.valueOf(items[7]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[常住人口数]类型不对(" + items[7]
							+ "),应该是数字字符串!");
				}
				if (items[7].getBytes().length > 10)
					throw new Exception("[常住人口数]过长！必须不大于10位");
			}
			if (!"null".equals(items[8]) && !"空".equals(items[8])
					&& !"".equals(items[8].trim())) {
				try { // 检查items[8]是否为数字
					Double temp = Double.valueOf(items[8]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[流动人口数]类型不对(" + items[8]
							+ "),应该是数字字符串!");
				}
				if (items[8].getBytes().length > 10)
					throw new Exception("[流动人口数]过长！必须不大于10位");
			}
			if (!"null".equals(items[9]) && !"空".equals(items[9])
					&& !"".equals(items[9].trim())) { 
			try { // 检查items[9]是否为数字
				Double temp = Double.valueOf(items[9]);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("[辖区面积]类型不对(" + items[9] + "),应该是数字字符串!");
			}
			if (items[9].getBytes().length > 16)
				throw new Exception("[辖区面积]过长！必须不大于16位");
			}
			
			if (!"null".equals(items[10]) && !"空".equals(items[10])
					&& !"".equals(items[10].trim())) {
			try { // 检查items[10]是否为数字
				Double temp = Double.valueOf(items[10]);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("[辖区人均可支配收入]类型不对(" + items[10]
						+ "),应该是数字字符串!");
			}
			if (items[10].getBytes().length > 10)
				throw new Exception("[辖区人均可支配收入]过长！必须不大于10位");
			}
			
			if (!"null".equals(items[11]) && !"空".equals(items[11])
					&& !"".equals(items[11].trim())) {
			try { // 检查items[11]是否为数字
				Double temp = Double.valueOf(items[11]);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("[辖区移动用户数]类型不对(" + items[11]
						+ "),应该是数字字符串!");
			}
			if (items[11].getBytes().length > 10)
				throw new Exception("[辖区移动用户数]过长！必须不大于10位");
			}
			
			if (!"null".equals(items[12]) && !"空".equals(items[12])
					&& !"".equals(items[12].trim())) {
				try { // 检查items[12]是否为数字
					Double temp = Double.valueOf(items[12]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[辖区联通用户数]类型不对(" + items[12]
							+ "),应该是数字字符串!");
				}
				if (items[12].getBytes().length > 10)
					throw new Exception("[辖区联通用户数]过长！必须不大于10位");
			}
			if (!"null".equals(items[13]) && !"空".equals(items[13])
					&& !"".equals(items[13].trim())) {
				try { // 检查items[13]是否为数字
					Double temp = Double.valueOf(items[13]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[辖区电信用户数]类型不对(" + items[13]
							+ "),应该是数字字符串!");
				}
				if (items[13].getBytes().length > 10)
					throw new Exception("[辖区电信用户数]过长！必须不大于10位");
			}
			if (!"null".equals(items[14]) && !"空".equals(items[14])
					&& !"".equals(items[14].trim())) {
				try { // 检查items[14]是否为数字
					Double temp = Double.valueOf(items[14]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[辖区移动电话用户数]类型不对(" + items[14]
							+ "),应该是数字字符串!");
				}
				if (items[14].getBytes().length > 10)
					throw new Exception("[辖区移动电话用户数]过长！必须不大于10位");
			}
		} else {// 修改
			if (!"null".equals(items[1]) && !"空".equals(items[1])
					&& !"".equals(items[1].trim())) {
				if (items[1].length() > 64)
					throw new Exception("[行政区划名称]过长！必须不大于32个字");
			}
			if (!"null".equals(items[2]) && !"空".equals(items[2])
					&& !"".equals(items[2].trim())) {
				try { // 检查items[2]是否为数字
					Double temp = Double.valueOf(items[2]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[行政区划类型编码]类型不对(" + items[2]
							+ "),应该是数字字符串!");
				}
				if (items[2].getBytes().length > 2)
					throw new Exception("[行政区划类型编码]过长！必须不大于2位");
			}
			if (!"null".equals(items[3]) && !"空".equals(items[3])
					&& !"".equals(items[3].trim())) {
				try { // 检查items[3]是否为数字
					Double temp = Double.valueOf(items[3]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[行政区划级别编码]类型不对(" + items[3]
							+ "),应该是数字字符串!");
				}
				if (items[3].getBytes().length > 2)
					throw new Exception("[行政区划级别编码]过长！必须不大于2位");
			}
			if (!"null".equals(items[4]) && !"空".equals(items[4])
					&& !"".equals(items[4].trim())) {
				if (items[4].length() > 18)
					throw new Exception("[上级行政区划编码]过长！必须不大于18位");
			}
			if (!"null".equals(items[5]) && !"空".equals(items[5])
					&& !"".equals(items[5].trim())) {
				try { // 检查items[5]是否为数字
					Double temp = Double.valueOf(items[5]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[数据统计年度]类型不对(" + items[5]
							+ "),应该是数字字符串!");
				}
				if (items[5].getBytes().length > 4)
					throw new Exception("[数据统计年度]过长！必须不大于4位");
			}
			if (!"null".equals(items[6]) && !"空".equals(items[6])
					&& !"".equals(items[6].trim())) {
				try { // 检查items[6]是否为数字
					Double temp = Double.valueOf(items[6]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[辖区人口数]类型不对(" + items[6]
							+ "),应该是数字字符串!");
				}
				if (items[6].getBytes().length > 10)
					throw new Exception("[辖区人口数]过长！必须不大于10位");
			}
			if (!"null".equals(items[7]) && !"空".equals(items[7])
					&& !"".equals(items[7].trim())) {
				try { // 检查items[7]是否为数字
					Double temp = Double.valueOf(items[7]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[常住人口数]类型不对(" + items[7]
							+ "),应该是数字字符串!");
				}
				if (items[7].getBytes().length > 10)
					throw new Exception("[常住人口数]过长！必须不大于10位");
			}
			if (!"null".equals(items[8]) && !"空".equals(items[8])
					&& !"".equals(items[8].trim())) {
				try { // 检查items[8]是否为数字
					Double temp = Double.valueOf(items[8]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[流动人口数]类型不对(" + items[8]
							+ "),应该是数字字符串!");
				}
				if (items[8].getBytes().length > 10)
					throw new Exception("[流动人口数]过长！必须不大于10位");
			}
			if (!"null".equals(items[9]) && !"空".equals(items[9])
					&& !"".equals(items[9].trim())) {
				try { // 检查items[9]是否为数字
					Double temp = Double.valueOf(items[9]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[辖区面积]类型不对(" + items[9]
							+ "),应该是数字字符串!");
				}
				if (items[9].getBytes().length > 16)
					throw new Exception("[辖区面积]过长！必须不大于16位");
			}
			if (!"null".equals(items[10]) && !"空".equals(items[10])
					&& !"".equals(items[10].trim())) {
				try { // 检查items[10]是否为数字
					Double temp = Double.valueOf(items[10]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[辖区人均可支配收入]类型不对(" + items[10]
							+ "),应该是数字字符串!");
				}
				if (items[10].getBytes().length > 10)
					throw new Exception("[辖区人均可支配收入]过长！必须不大于10位");
			}
			if (!"null".equals(items[11]) && !"空".equals(items[11])
					&& !"".equals(items[11].trim())) {
				try { // 检查items[11]是否为数字
					Double temp = Double.valueOf(items[11]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[辖区移动用户数]类型不对(" + items[11]
							+ "),应该是数字字符串!");
				}
				if (items[11].getBytes().length > 10)
					throw new Exception("[辖区移动用户数]过长！必须不大于10位");
			}
			if (!"null".equals(items[12]) && !"空".equals(items[12])
					&& !"".equals(items[12].trim())) {
				try { // 检查items[12]是否为数字
					Double temp = Double.valueOf(items[12]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[辖区联通用户数]类型不对(" + items[12]
							+ "),应该是数字字符串!");
				}
				if (items[12].getBytes().length > 10)
					throw new Exception("[辖区联通用户数]过长！必须不大于10位");
			}
			if (!"null".equals(items[13]) && !"空".equals(items[13])
					&& !"".equals(items[13].trim())) {
				try { // 检查items[13]是否为数字
					Double temp = Double.valueOf(items[13]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[辖区电信用户数]类型不对(" + items[13]
							+ "),应该是数字字符串!");
				}
				if (items[13].getBytes().length > 10)
					throw new Exception("[辖区电信用户数]过长！必须不大于10位");
			}
			if (!"null".equals(items[14]) && !"空".equals(items[14])
					&& !"".equals(items[14].trim())) {
				try { // 检查items[14]是否为数字
					Double temp = Double.valueOf(items[14]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[辖区移动电话用户数]类型不对(" + items[14]
							+ "),应该是数字字符串!");
				}
				if (items[14].getBytes().length > 10)
					throw new Exception("[辖区移动电话用户数]过长！必须不大于10位");
			}
		}
	}
}
