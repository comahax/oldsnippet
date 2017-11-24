package com.sunrise.boss.ui.cms.reward.chadtimportrecord;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.business.cms.reward.typeinfo.persistent.TypeinfoListVO;
import com.sunrise.boss.business.cms.reward.typeinfo.persistent.TypeinfoVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.reward.typeinfo.TypeinfoDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;

public class ChAdtImportrecordexportCheck extends BaseCheckFormat {
	private Map<String,String> typeinfo = null;
	
	public ChAdtImportrecordexportCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user) throws Exception {
		if(this.typeinfo==null){
			this.typeinfo = new HashMap<String,String>();
			try{
				TypeinfoDelegate delegate = new TypeinfoDelegate();
				TypeinfoListVO params = new TypeinfoListVO();
				params.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
				params.set_ne_facetype("2");
				params.set_pagesize("0");
				DataPackage dp = delegate.doQuery(params, user);
				if(dp!=null && dp.getDatas().size()>0){
					Iterator iter = dp.getDatas().iterator();
					while(iter.hasNext()){
						TypeinfoVO vo = (TypeinfoVO)iter.next();
						this.typeinfo.put(vo.getType(), vo.getTypename());
					}
				}else{//查询不到数据或者数据为空，无法对用户上产做校验，抛出一个异常
					throw new Exception();
				}
			}catch(Exception ex){
				ex.printStackTrace();
				throw new Exception("无法获取[业务编码]和[导入类型]列表");
			}
		}
		
		String[] content =StringUtils.splitPreserveAllTokens(line, "|");
		
		if (content.length != 8) {
			throw new Exception("上传数据列数不对,应为7列,请查看说明帮助!");
		}
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","渠道编码不能为空");
		}
//		if(StringUtils.isEmpty(content[1])){
//			throw new BusinessException("","办理号码不能为空");
//		}
//		if(StringUtils.isEmpty(content[2])){
//			throw new BusinessException("","业务编码不能为空");
//		}
//		if(StringUtils.isEmpty(content[3])){
//			throw new BusinessException("","办理时间不能为空");
//		}
		if(StringUtils.isEmpty(content[4])){
			throw new BusinessException("","导入类型不能为空");
		}
//		if(StringUtils.isEmpty(content[5])){
//			throw new BusinessException(""," 办理金额不能为空");
//		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if(!StringUtils.isEmpty(content[i])){
					if (!CheckUtil.checkString(content[i], 20, true)) {
						throw new Exception("[渠道编码]不能大于20位");
					}
				}
				break;
			case 1:
				if (!CheckUtil.checkString(content[i], 15,true)) {
					throw new Exception("[办理号码]不能大于15位");
				}
				break;
			case 2:
				if(!StringUtils.isEmpty(content[i])){
					if (!CheckUtil.checkString(content[i], 18,true)) {
						throw new Exception("[业务编码]不能大于18位");
					}
					if(!this.typeinfo.containsKey(content[i])){
						throw new Exception("[业务编码]不存在");
					}
				}
				break;
			case 3:
				if(!StringUtils.isEmpty(content[i])){
					try {
						sf.parse(content[i]);
					} catch (Exception pe) {
						throw new Exception("[办理时间]格式不对,应为yyyy-MM-dd");
					}
				}
				break;
			case 4:
				if(!StringUtils.isEmpty(content[i])){
					if (!this.typeinfo.containsKey(content[i])) {
						throw new Exception("[导入类型]不存在");
					}
				}
				break;
			case 5:
				if(!StringUtils.isEmpty(content[i])){
					if (!CheckUtil.checkDouble(content[i], 14, 2)) {
						throw new Exception("[办理金额]整数部分不能超过14位,小数部分不能超过2位");
					}
				}
				break;
			case 6:
				if(!StringUtils.isEmpty(content[i])){
					if(!CheckUtil.checkDouble(content[i], 16, 4)){
						throw new Exception("[系数]整数部分不能超过12位，小数部分不能超过4位");						
					}
				}
				break;
			}
		}
	}
}
