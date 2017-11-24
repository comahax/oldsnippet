package com.sunrise.boss.ui.cms.reward.chadtbaseprodid;

import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;
import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.business.cms.reward.chadtbaseprodid.persistent.ChAdtBaseprodidListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.reward.chadtbaseprodid.ChAdtBaseprodidDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class ChAdtBaseprodidCheck extends BaseCheckFormat{
	
	
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		 
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("", "要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}
	
	public void checkLine(String line, int rowCount, User user) throws Exception {
		if (null == line || "".equals(line)) {
			return;
		} 
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 9) {
			throw new Exception("上传数据列数不对,应为8列,请查看说明帮助!");
		} 
		if (StringUtils.isEmpty(content[0]) || content[0].getBytes("GBK").length > 32) {
			throw new Exception("[产品标识]不能为空，并且长度最大为32");
		}
		if ( StringUtils.isEmpty(content[1])) {
			throw new Exception("[地市标识]不能为空");
		}else{
			String  cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
			if(!cityid.equals(content[1]))
				throw new Exception("您只能操作工号对应的地市"+cityid+"而导入的地市标识为：【"+content[1]+"】,请修改");
		} 
 
		if (StringUtils.isEmpty(content[2])) {
			throw new Exception("[套餐类型]不能为空");
		}  else if (!content[2].trim().matches("(3G|4G)")) {  
			throw new Exception("请输入有效的【套餐类型】");
		}
		 
		if (StringUtils.isEmpty(content[4])) {
			throw new Exception("[套餐类别]不能为空，并且必需为整数");
		} else if (!content[4].trim().matches("(1|2|3)")) {
			throw new Exception("请输入有效的套餐类型[套餐类别]");
		}
		if (StringUtils.isEmpty(content[6]) || !CheckUtil.checkDouble(content[6], 14, 2)) {
			throw new Exception("[套餐值]不能为空,且最多只能有2个小数");
		}
		
		ChAdtBaseprodidListVO newVo = new ChAdtBaseprodidListVO();
		 newVo.set_se_cityid(content[1]);
		 newVo.set_se_prodid(content[0]);
		 ChAdtBaseprodidDelegate delegate = new ChAdtBaseprodidDelegate();
		DataPackage dp = delegate.doQuery(newVo, user);
		
		if ( dp.getRowCount()>0) {
			throw new Exception("地市【"+content[1]+"】产品标识为：【"+content[0]+"】已存在相同记录!");
		}
	}
}
