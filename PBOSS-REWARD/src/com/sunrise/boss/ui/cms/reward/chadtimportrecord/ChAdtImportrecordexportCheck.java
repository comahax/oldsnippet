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
			throw new BusinessException("","Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
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
				}else{//��ѯ�������ݻ�������Ϊ�գ��޷����û��ϲ���У�飬�׳�һ���쳣
					throw new Exception();
				}
			}catch(Exception ex){
				ex.printStackTrace();
				throw new Exception("�޷���ȡ[ҵ�����]��[��������]�б�");
			}
		}
		
		String[] content =StringUtils.splitPreserveAllTokens(line, "|");
		
		if (content.length != 8) {
			throw new Exception("�ϴ�������������,ӦΪ7��,��鿴˵������!");
		}
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","�������벻��Ϊ��");
		}
//		if(StringUtils.isEmpty(content[1])){
//			throw new BusinessException("","������벻��Ϊ��");
//		}
//		if(StringUtils.isEmpty(content[2])){
//			throw new BusinessException("","ҵ����벻��Ϊ��");
//		}
//		if(StringUtils.isEmpty(content[3])){
//			throw new BusinessException("","����ʱ�䲻��Ϊ��");
//		}
		if(StringUtils.isEmpty(content[4])){
			throw new BusinessException("","�������Ͳ���Ϊ��");
		}
//		if(StringUtils.isEmpty(content[5])){
//			throw new BusinessException(""," �������Ϊ��");
//		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if(!StringUtils.isEmpty(content[i])){
					if (!CheckUtil.checkString(content[i], 20, true)) {
						throw new Exception("[��������]���ܴ���20λ");
					}
				}
				break;
			case 1:
				if (!CheckUtil.checkString(content[i], 15,true)) {
					throw new Exception("[�������]���ܴ���15λ");
				}
				break;
			case 2:
				if(!StringUtils.isEmpty(content[i])){
					if (!CheckUtil.checkString(content[i], 18,true)) {
						throw new Exception("[ҵ�����]���ܴ���18λ");
					}
					if(!this.typeinfo.containsKey(content[i])){
						throw new Exception("[ҵ�����]������");
					}
				}
				break;
			case 3:
				if(!StringUtils.isEmpty(content[i])){
					try {
						sf.parse(content[i]);
					} catch (Exception pe) {
						throw new Exception("[����ʱ��]��ʽ����,ӦΪyyyy-MM-dd");
					}
				}
				break;
			case 4:
				if(!StringUtils.isEmpty(content[i])){
					if (!this.typeinfo.containsKey(content[i])) {
						throw new Exception("[��������]������");
					}
				}
				break;
			case 5:
				if(!StringUtils.isEmpty(content[i])){
					if (!CheckUtil.checkDouble(content[i], 14, 2)) {
						throw new Exception("[������]�������ֲ��ܳ���14λ,С�����ֲ��ܳ���2λ");
					}
				}
				break;
			case 6:
				if(!StringUtils.isEmpty(content[i])){
					if(!CheckUtil.checkDouble(content[i], 16, 4)){
						throw new Exception("[ϵ��]�������ֲ��ܳ���12λ��С�����ֲ��ܳ���4λ");						
					}
				}
				break;
			}
		}
	}
}
