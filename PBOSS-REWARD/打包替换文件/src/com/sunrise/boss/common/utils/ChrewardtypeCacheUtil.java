package com.sunrise.boss.common.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.cms.chadtdictidname.persistent.ChAdtDictidnameListVO;
import com.sunrise.boss.business.cms.chadtdictidname.persistent.ChAdtDictidnameVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.cms.chadtdictidname.ChAdtDictidnameDelegate;
import com.sunrise.boss.ui.commons.User;

public final class ChrewardtypeCacheUtil {
	private static Log log = LogFactory.getLog(ChrewardtypeCacheUtil.class);
	
	private static Map<String,HashMap<String,String>> cityRewardtypeMap = new HashMap<String,HashMap<String,String>>();
	//生产
	private static final String[] cities = {"200", "751","763","758","766","755","757","760","756","769","762","752","753","759","662","750","668","768","663","754","660"};
	//测试
	//private static final String[] cities = {"760"};
	private static final String CH_REWARDTYPE = "CH_REWARDTYPE";
	private ChrewardtypeCacheUtil(){
		;
	}
	
	public static void refresh(){
		try{
			log.info("加载CH_REWARDTYPE社会渠道酬金类型：开始");
			System.out.println("加载CH_REWARDTYPE社会渠道酬金类型：开始");
			DictitemDelegate delegate = new DictitemDelegate();
			User user = new User();
			user.setCityid(SysInfo.COMMON_DB_FLAG);
			DictitemListVO listvo =new DictitemListVO();
			listvo.set_pagesize("0");
			listvo.set_se_groupid(CH_REWARDTYPE);
			DataPackage commondp = delegate.doQuery(listvo, user);
			
			ChAdtDictidnameDelegate adtDelegate = new ChAdtDictidnameDelegate();
			ChAdtDictidnameListVO adtListvo = new ChAdtDictidnameListVO();
			adtListvo.set_pagesize("0");
			adtListvo.set_se_groupid(CH_REWARDTYPE);
			DataPackage dp = null;
			for(String cityid:cities){
				user.setCityid(cityid);
				dp = adtDelegate.doQuerySelf(adtListvo, user);
				HashMap<String,String> citytype = new HashMap<String,String>();
				if(dp!=null && dp.getDatas().size()>0){
					for(Iterator<ChAdtDictidnameVO> iter = dp.toList(ChAdtDictidnameVO.class).iterator();iter.hasNext();){
						ChAdtDictidnameVO vo = iter.next();
						citytype.put(vo.getDictid(), vo.getDictname());
					}
				}
				for(Iterator<DictitemVO> iter = commondp.toList(DictitemVO.class).iterator(); iter.hasNext();){
					DictitemVO cvo = iter.next();
					if( !citytype.containsKey(cvo.getDictid())){
						citytype.put(cvo.getDictid(), cvo.getDictname());
					}
				}
				cityRewardtypeMap.put(cityid, citytype);
			}	
			
			log.info("加载CH_REWARDTYPE社会渠道酬金类型：完成");
			System.out.println("加载CH_REWARDTYPE社会渠道酬金类型：完成");
		}catch(Exception ex){
			log.info("加载CH_REWARDTYPE社会渠道酬金类型：异常");
			System.out.println("加载CH_REWARDTYPE社会渠道酬金类型：异常");
			ex.printStackTrace();
		}
	}
	
	public static HashMap getCitymap(String cityid){
		if(cityRewardtypeMap.size()==0){
			ChrewardtypeCacheUtil.refresh();
		}
		return cityRewardtypeMap.get(cityid);
	}
	
	public static String getCityRewardname(String cityid,String rewardtype){
		if(cityRewardtypeMap.size()==0){
			ChrewardtypeCacheUtil.refresh();
		}
		return cityRewardtypeMap.get(cityid).get(rewardtype);
	}
	
}
