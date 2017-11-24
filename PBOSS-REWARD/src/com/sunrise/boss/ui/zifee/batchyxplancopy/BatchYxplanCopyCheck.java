package com.sunrise.boss.ui.zifee.batchyxplancopy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.zifee.yxplan.control.YxPlanControl;
import com.sunrise.boss.business.zifee.yxplan.control.YxPlanControlBean;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanListVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

/**
 * 继承BaseCheckFormat或者实现ICheckFormat接口
 * 
 * @author zengjianxin
 */
public class BatchYxplanCopyCheck extends BaseCheckFormat {
	public BatchYxplanCopyCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (null == line || "".equals(line)) {
			return;
		}
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		// 检查列数
		if (items.length != 7) {
			throw new Exception("上传数据列数不对,应为7列,请查看说明帮助!");
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		if (items[0] == null || "".equals(items[0].trim())
				|| "空".equals(items[0].trim())) {
			throw new Exception("[模版营销方案标识]不能为空!");
		}
		//新增列[新营销方案标识]
		if (items[1] == null || "".equals(items[1].trim())
				|| "空".equals(items[1].trim())) {
			//throw new Exception("[新营销方案标识]不能为空!");
		}else{
//			新营销方案标识验证
			if (items[1].matches("\\d{14}")) {
				if(user.isProvinceUser()  && !items[1].substring(0, 3).equals("100") ){
					throw new Exception("[新营销方案标识]前3位不合法，全省工号前三位应该为100！");
				}
				if((items[1].substring(0, 3).equals(user.getCityid())) || (user.isProvinceUser() && "100".equals(items[1].substring(0, 3)))){
					YxPlanListVO params=new YxPlanListVO();
					params.set_ne_yxplanid(items[1].toString());
					YxPlanControl control=(YxPlanControl) ControlFactory.build(YxPlanControlBean.class);
					DataPackage dp=control.doQuery(params, user);
					if(dp.getDatas().size()>0){
						throw new Exception("新营销方案标识已存在!");
					}
				}else{
					throw new Exception("[新营销方案标识]前3位不合法，应为操作员所在地市标识！");
				}
			}else{
				throw new Exception("[新营销方案标识]长度需为14位数字字串！");
			}
		}
		if (items[2] == null || "".equals(items[2].trim())
				|| "空".equals(items[2].trim())) {
			throw new Exception("[新营销方案名称]不能为空!");
		}
		if (items[3] == null || "".equals(items[3].trim())
				|| "空".equals(items[3].trim())) {
			throw new Exception("[启动时间]不能为空!");
		}
		if (items[4] == null || "".equals(items[4].trim())
				|| "空".equals(items[4].trim())) {
			throw new Exception("[停用时间]不能为空!");
		}
		if (items[5] == null || "".equals(items[5].trim())
				|| "空".equals(items[5].trim())) {
			throw new Exception("[营销方案说明]不能为空!");
		}
		if (items[6] == null || "".equals(items[6].trim())
				|| "空".equals(items[6].trim())) {
			throw new Exception("[需要复制的明细串]不能为空!");
		}

		if (!items[0].matches("\\d{1,14}")) {
			throw new Exception("[模版营销方案标识]出错，正确为1-14位数字！");
		}
		
		
		if (items[2].trim().length() > 128) {
			throw new Exception("[新营销方案名称]长度不能大于128！");
		}
		// 启动时间
		Date d2 = null;
		try {
			d2 = sdf.parse(items[3]);
		} catch (Exception e) {
			throw new Exception("[启动时间]格式不对，正确格式为[yyyy-MM-dd HH:mm:ss]");
		}

		// 启动时间
		Date d3 = null;
		try {
			d3 = sdf.parse(items[4]);
		} catch (Exception e) {
			throw new Exception("[停用时间]格式不对，正确格式为[yyyy-MM-dd HH:mm:ss]");
		}

		if (sdf.parse(items[4]).before(sdf.parse(items[3]))) {
			throw new Exception("[停用时间]不能在[启动时间]之前！");
		}

		if (items[5].trim().length() > 2000) {
			throw new Exception("[营销方案说明]长度不能大于2000！");
		}
	}
}