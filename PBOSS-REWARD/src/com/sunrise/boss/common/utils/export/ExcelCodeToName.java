package com.sunrise.boss.common.utils.export;

import net.sf.ehcache.Cache;

import org.apache.log4j.Logger;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.common.utils.CacheSinglton;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2NameConfiger;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2name;

public class ExcelCodeToName {

	private static Logger log = Logger.getRootLogger();

	private String code, dbFlag;

	static public final String SYSCODE_FLAG = "$";

	static public final String CONFIG_FLAG = "#";

	public static final int EVAL_PAGE = 6;

	static public final String CLASS_PREFIX = "com.sunrise.boss.ui.commons.taglib.code2name.impl.";


	public String codeToName(String code, String codevalue, User user_1) {
		if (codevalue == null || "null".equals(codevalue)) {
			return "";
		}
		/** 取得user和dbFlag(cityid) */
		User user = user_1;
		User newUser = new User();
		try {
			BeanUtils.copyProperties(newUser, user);
			if(newUser.getCityid()==null||newUser.getCityid().trim().length()<1){
				newUser.setCityid(SysInfo.COMMON_DB_FLAG);
			}
			
		} catch (Exception e) {
			log.info("Code2name Tag exception", e);
			e.printStackTrace();
		}
		if (dbFlag != null && dbFlag.trim().length() > 0) {
			newUser.setCityid(dbFlag);
		}

		/** 三种翻译方式 */
		String theName = null;
		DictitemVO vo = new DictitemVO();
		String groupId = code.substring(1, code.length());
		try {
			if (code.indexOf(SYSCODE_FLAG) == 0) { // 1.查系统字典参数表里面的翻译

				if (!SysInfo.USE_CACHE_FLAG) {
					CommonDelegate dictitemDelegate = new CommonDelegate(
							DictitemVO.class);

					vo.setGroupid(groupId);
					vo.setDictid(codevalue.toString());
					vo = (DictitemVO) dictitemDelegate.doFindByPk(vo, newUser);
					theName = vo.getDictname();
				} else {

					Cache cache = CacheSinglton.getInstance().getCache();
					if (codevalue != null)
						vo = (DictitemVO) cache.get(
								codevalue.toString() + "-" + groupId)
								.getValue();
				}

				if (null != vo) {
					theName = vo.getDictname();
				}
			} else if (code.indexOf(CONFIG_FLAG) == 0) { // 2.根据配置文件配置的单表相应的翻译
				try {
					Object obj = Code2NameConfiger.getName(code.substring(1,
							code.length()), codevalue, newUser.getCityid());
					if (obj != null) {
						theName = obj.toString();
					}
				} catch (Exception ex) {
					log.info("Code2name transaction exception", ex);
					ex.printStackTrace();
				}
			} else { // 3.自定义方法，实现Code2Name接口
				Code2name instance = null;
				try {
					instance = (Code2name) Class.forName(CLASS_PREFIX + code)
							.newInstance();
					theName = instance.translate(codevalue, newUser);
				} catch (Exception ex) {
					if(log.isDebugEnabled()){
						log.debug("Code2name transaction exception", ex);
					}
				}
			}

			if (theName == null) {
				theName = codevalue;
			}
		} catch (Exception ex) {
			if(log.isDebugEnabled()){
				log.debug("Code2name transaction exception", ex);
			}
			return codevalue;
		}
		if (theName == null) {
			return codevalue;
		}
		return theName;
	}

}
