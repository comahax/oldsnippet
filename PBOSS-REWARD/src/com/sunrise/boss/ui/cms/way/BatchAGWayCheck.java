package com.sunrise.boss.ui.cms.way;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.AuditUtils;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchAGWayCheck extends BaseCheckFormat {
	public BatchAGWayCheck() {
		super();
	}

	public void checkFile(FormFile file,HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount) throws Exception {
		if (null == line || "".equals(line)) {
			return;
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String[] items = line.split("\\|");
		
		// 检查列数
		if (items.length != 29) {
			throw new Exception("上传数据列数不对,应为29列,请查看说明帮助!");
		}
		
		//渠道编码0
		if (items[0].getBytes().length>18 || StringUtils.isEmpty(items[0])){
			throw new Exception("渠道编码长度出错，正确范围为1~18");
		}else
		{
			if(!AuditUtils.doCheckWayidStyle(items[0].trim()))
			{
				throw new Exception("渠道编码不符合规范,应该是字母开头,并且没有下划线");
			}
		}
		
		//渠道名称1
		if(StringUtils.isEmpty(items[1]) || items[1].getBytes().length>256){
			throw new Exception("渠道名称不能为空且长度不能大于256");
		}
		
		//上级渠道编码2
		if (!items[2].matches("\\w{1,18}")){
			throw new Exception("上级渠道编码长度出错，正确范围为1~18");
		}

		//合作方3
		if (!items[3].matches("\\d{0,2}")){
			throw new Exception("合作方出错，正确为0-2位数字");
		}	
		
		//地市公司4
		if(items[4].getBytes().length>14){
			throw new Exception("地市公司长度不能大于14");
		}
		
		//分公司5
		if(items[5].getBytes().length>14){
			throw new Exception("分公司长度不能大于14");
		}
		
		//服务销售中心6
		if(items[6].getBytes().length>14){
			throw new Exception("服务销售中心长度不能大于14");
		}

		//微区域7
		if(items[7].getBytes().length>14){
			throw new Exception("微区域长度不能大于14");
		}
		
		//行政区划8
		if(items[8].getBytes().length>18){
			throw new Exception("行政区划长度不能大于18");
		}
		
		//详细地址9
		if(items[9].getBytes().length>128){
			throw new Exception("详细地址长度不能大于128");
		}

		//负责人姓名10-------------------------------------------
		if(StringUtils.isEmpty(items[10]) || items[10].getBytes().length>64){
			throw new Exception("负责人姓名长度不能为空且不能大于64");
		}
		
		//负责人联系电话11
		if(items[11].getBytes().length>20){
			throw new Exception("负责人联系电话格式不对");
		}
		
		//负责人电子邮箱12
		if (!StringUtils.isEmpty(items[12])&&!items[12].matches("[_a-zA-Z\\d\\-\\.]+@[_a-zA-Z\\d\\-]+(\\.[_a-zA-Z\\d\\-]+)+")){
			throw new Exception("负责人电子邮箱格式不对");
		}
		
		//业务联系人姓名13
		if(StringUtils.isEmpty(items[13]) || items[13].getBytes().length>64){
			throw new Exception("业务联系人姓名不能为空且长度不能大于64");
		}

		//业务联系人联系电话14
		if(items[14].getBytes().length>20){
			throw new Exception("业务人联系电话格式不对");
		}	
		
		//业务联系人电子邮箱15
		if (!StringUtils.isEmpty(items[15])&&!items[15].matches("[_a-zA-Z\\d\\-\\.]+@[_a-zA-Z\\d\\-]+(\\.[_a-zA-Z\\d\\-]+)+")){
			throw new Exception("业务联系人电子邮箱格式不对");
		}
		
		//合同编码16---------------------------------------------------------------------
		if (!items[16].matches("\\w{1,17}")){
			throw new Exception("合同编码长度有错,正确范围1~17");
		}
		
		//合同名称17
		if(StringUtils.isEmpty(items[17]) || items[17].getBytes().length>255){
			throw new Exception("合同名称不能为空且长度不能大于255");
		}
		
		//签署合同时间18
		Date d1=null;
		try {
			d1 = format.parse(items[18]);
		} catch (Exception e) {
			throw new Exception("签署合同时间格式不对，正确格式为[yyyy-MM-dd]");
		}

		//合同到期日19
		Date d2=null;
		try {
			d2 = format.parse(items[19]);
		} catch (Exception e) {
			throw new Exception("合同到期日格式不对，正确格式为[yyyy-MM-dd]");
		}
		
		//判断日期先后
		if (d2.before(d1)){
			throw new Exception("合同到期日格早于签署合同时间，发生错误");
		}

		//法人代表20
		if(items[20].getBytes().length>64){
			throw new Exception("法人代表长度不能大于64");
		}
		
		//营业执照编号21
		if(items[21].getBytes().length>64){
			throw new Exception("营业执照编号长度不能大于64");
		}
		
		//经营区域类型编码22
		if (!items[22].matches("\\d{0,2}")){
			throw new Exception("经营区域类型，正确为0-2位数字");
		}
		
		//经营范围23
		if (!items[23].matches("\\d{0,2}")){
			throw new Exception("经营范围，正确为0-2位数字");
		}
		
		//银行帐号24------------------------------------------------------
		if (!items[24].matches("\\d{1,6}")){
			throw new Exception("银行帐号出错，正确为1-6位数字");
		}	
		
		//开户银行25
		if(StringUtils.isEmpty(items[25]) || items[25].getBytes().length>128){
			throw new Exception("开户银行不为能空且长度不能大于128");
		}
		
		//银行帐号26
		if(items[26].getBytes().length>50){
			throw new Exception("银行帐号长度不能大于50");
		}
		
		//开户账号名称27
		if(items[27].getBytes().length>50){
			throw new Exception("开户账号名称长度不能大于50");
		}
		
		//开户人身份证号码28
		if(items[28].getBytes().length>32){
			throw new Exception("开户人身份证号码长度不能大于32");
		}
		
	}
	
	//test
//	public static void main(String[] args) throws Exception{
//		BatchAGWayCheck check = new BatchAGWayCheck();
//		String str = "JFJMXXXXX|测试渠道|JFJM00000|1|JM|JM|||1|江门建设路101号|张三|020-31647847|abcd@abc.com|李四|0726-98564587|abc@xyz.com|45478|测试合同信息|1990-12-12|2006-01-02|王五|abcde12323|1|1|98546|中国银行|123456789|公司XX帐户|1234567897894587";
//		try{
//			check.checkLine(str,0);
//			System.out.println("ok");
//		}catch(Exception e){
//		    e.printStackTrace();
//		}
//	}
}